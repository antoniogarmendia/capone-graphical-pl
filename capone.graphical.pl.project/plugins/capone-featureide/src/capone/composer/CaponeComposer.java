package capone.composer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import capone.Module;
import capone.Rule;
import capone.composer.helper.CaponeHelper;
import capone.composer.helper.EMFHandler;
import de.ovgu.featureide.core.IFeatureProject;
import de.ovgu.featureide.core.builder.ComposerExtensionClass;
import de.ovgu.featureide.fm.core.ExtensionManager.NoSuchExtensionException;
import de.ovgu.featureide.fm.core.base.impl.ConfigFormatManager;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import de.ovgu.featureide.fm.core.configuration.DefaultFormat;
import de.ovgu.featureide.fm.core.io.IPersistentFormat;
import de.ovgu.featureide.fm.core.io.manager.SimpleFileHandler;

public class CaponeComposer extends ComposerExtensionClass {
	private IFile 			module;
	private File 			moduleFile;
	private Resource 		moduleResource;
	private capone.Module 	caponeModule;		// top module
	private EMFHandler 		emh = new EMFHandler();
	// maps each module to its submodules, if any
	private Map<Module, List<Module>> modules = new HashMap<>();
	private ResourceSet 	resourceSet;

	public CaponeComposer() {
		//System.out.println("[CAPONE] initializing composer plugin");
		this.removeJavaNature(); 
	}
	
	public CaponeComposer(IFile module) {
		this();
		this.module = module;
		IPath location = this.module.getLocation();
		if (location != null) {
			this.moduleFile = location.toFile();
			this.loadModule();
		}
	}

	private void removeJavaNature() {
		if (this.featureProject == null) return;
		IProject pr = this.featureProject.getProject();
		//System.out.println("[CAPONE] removing Java nature of project "+pr);
		try {
			if (pr.hasNature(JAVA_NATURE)) {
				IProjectDescription desc = pr.getDescription();
				String[] prevNatures = desc.getNatureIds();
				String[] newNatures = new String[prevNatures.length - 1];
				int idx = 0;
				for (int i = 0; i<prevNatures.length; i++) {
					if (!JAVA_NATURE.equals(prevNatures[i])) newNatures[idx++] = prevNatures[i];
				}
				desc.setNatureIds(newNatures);
				pr.setDescription(desc, new NullProgressMonitor());
			}			
		} 
		catch (CoreException e) { e.printStackTrace(); }
	}
	
	@Override public boolean initialize(IFeatureProject project) {
		boolean ret = super.initialize(project);
//		System.out.println("[CAPONE] initialize project");
		this.removeJavaNature();
		return ret;
	}

	@Override
	public void performFullBuild(Path config) {
		// TODO Auto-generated method stub
		System.out.println("[CAPONE] performing full build");
	}

	@Override
	public void buildPartialFeatureProjectAssets(IFolder sourceFolder, ArrayList<String> removedFeatures,
			ArrayList<String> mandatoryFeatures) throws IOException, CoreException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void buildConfiguration(IFolder folder, Configuration configuration, String cfgName) {
		//System.out.println("[CAPONE] Building Configuration "+configuration);
		if (this.isInitialized())		
			super.buildConfiguration(folder, configuration, cfgName);
		else
			this.persistConfig(folder, configuration, cfgName);
		Resource ecore = this.genEcore(folder, configuration, cfgName);
		new TrafoComposer().genTrafo(this.caponeModule, folder, configuration, ecore, modules);
		//Class to generate the viewpoint for the current configuration
		final ViewpointComposer viewpointComposer = new ViewpointComposer(this.caponeModule, folder, configuration, modules, ecore);
		//Generate the viewpoint
		viewpointComposer.generateViewpoint();
	}
	
	private Resource genEcore(IFolder folder, Configuration configuration, String cfgName) {
		//System.out.println("[CAPONE] Module.metamodel "+this.caponeModule.getMetamodel());
		String mmFile = this.caponeModule.getMetamodel();
		IPath mmPath = new org.eclipse.core.runtime.Path(mmFile);
		IFile ecoreFile = this.module.getProject().getFile(mmPath);
		Resource res = this.emh.readEcore(ecoreFile);
		if (res == null) {
			System.out.println("[CAPONE] meta-model "+ecoreFile+" does not exist");
			IWorkbench wb = PlatformUI.getWorkbench();
			IWorkbenchWindow window = wb.getActiveWorkbenchWindow();
	   		Shell               shell   = window.getShell();
			MessageBox box = new MessageBox(shell, SWT.CANCEL | SWT.OK);
			box.setText("Error");
			box.setMessage("Meta-model "+ecoreFile+" does not exist!");

			box.open(); 
			return null;
		}
		
		String fileName = this.module.getName();
		fileName = fileName.replaceAll("capone", "ecore");
		URI uri = URI.createFileURI(new File(folder.getLocation().toOSString()+File.separator+fileName).getAbsolutePath());
		
		List<Resource> ecores = this.getAllActiveEcores(configuration);
		for (Resource delta : ecores) {
			this.emh.extend(res, delta, null);
		}
		
		Resource newr = res.getResourceSet().createResource(uri);
		newr.getContents().addAll(EcoreUtil.copyAll(res.getContents()));
		try {
			newr.save(null);
		} catch (IOException e) {
			System.err.println("[Capone] Error saving file" + uri);
		}
		return newr;

	}

	private List<Resource> getAllActiveEcores(Configuration configuration) {
		List<Resource> ecores = new ArrayList<>();
		for (Module m : this.modules.keySet()) {
			if (m==this.caponeModule) continue;
			if (CaponeHelper.active(m, configuration)) {
				String ecoreFile = m.getMetamodel();
				Resource ecr = this.emh.readEcore(ecoreFile, this.module.getProject());
				if (ecr!=null) ecores.add(ecr);
				else {
					System.out.println("[CAPONE] Could not read ecore "+ecoreFile+" from module "+m.getName());
					// TODO: throw an exception?
				}
			}
		}
		return ecores;
	}

	private void persistConfig(IFolder folder, Configuration configuration, String cfgName) {
		IPersistentFormat<Configuration> format;
		try {
			if (!folder.exists()) {
				folder.create(true, true, null);
			}
			format = ConfigFormatManager.getInstance().getFormatById(DefaultFormat.ID);
			final IFile configurationFile = folder.getFile(cfgName + "." + format.getSuffix());
			SimpleFileHandler.save(Paths.get(configurationFile.getLocationURI()), configuration, format);
		} catch (NoSuchExtensionException | CoreException e) {
			System.err.println("[CAPONE] error saving configuration file to "+folder);
		}		
	}
	
	private void loadModule() {
		if (this.moduleResource==null) {
			if (this.emh==null) this.emh = new EMFHandler();
			this.moduleResource = this.emh.loadXtextModel(this.moduleFile);
			this.resourceSet = this.moduleResource.getResourceSet();
			this.caponeModule = (Module) this.moduleResource.getAllContents().next();
			//System.out.println("Module = "+this.caponeModule.getName());
			this.modules.put(this.caponeModule, new ArrayList<>());
			
			Set<Module> pending = new LinkedHashSet<>();
			List<Module> deps = this.findDependentModules(this.caponeModule);
			this.modules.get(this.caponeModule).addAll(deps);
			pending.addAll(deps);
			print("Deps: ", deps);
			
			int index = 0;
			
			List<Module> iterable = new LinkedList<>(pending);
		
			while (index < iterable.size()) {
				Module next = iterable.get(index++);
				//System.out.println("Module = "+next.getName());
				deps = this.findDependentModules(next);
				print("Deps: ", deps);
				pending.addAll(deps);
				iterable = new LinkedList<>(pending);
				print("Pending: ", pending);
				print("Iterable: ", iterable);
				this.modules.putIfAbsent(next, new ArrayList<>());
				//if (!this.modules.containsKey(next)) this.modules.put(next, new ArrayList<>());
				this.modules.get(next).addAll(deps);
			}
		}
	}
	
	private void print (String s, Collection<Module> modules) {
//		System.out.print(s);
//		for (Module m : modules) {
//			System.out.print(m.getName()+" ");
//		}
//		System.out.println("");
	}

	private List<File> allCaponeFiles(final File folder) {
		List<File> files = new ArrayList<>();
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	files.addAll(allCaponeFiles(fileEntry));
	        } else if (fileEntry.getName().endsWith(".capone")){
	            files.add(fileEntry);
	        }
	    }
	    return files;
	}

	private List<Module> findDependentModules(Module module) {
		List<Module> dependent = new ArrayList<>();
		IProject project = this.module.getProject();
		File root = new File(project.getLocation().toOSString());
		List<File> files= this.allCaponeFiles(root);
		for (File f: files) {
//			this.emh = new EMFHandler();
//			this.emh.setResourceSet(this.resourceSet);
			Resource res = this.emh.loadXtextModel(f);
			if (!res.getAllContents().hasNext()) continue;
			Module mod = (Module) res.getAllContents().next();
			Map<Dependency, List<String>> dee = CaponeHelper.getDependencies(f);
			//if (isDependency(module, mod.getDependencies()))
			if (isDependencyS(module, allValues(dee)))
				dependent.add(mod);
		}
		return dependent;
	}
	
	private List<String> allValues(Map<Dependency, List<String>> dee) {
		List<String> result = new ArrayList<>();
		for (Dependency d : dee.keySet()) 
			result.addAll(dee.get(d));		
		return result;
	}

	private boolean isDependencyS (Module mod, List<String> dependencies) {
		for (String s : dependencies) {
			if (mod.getName().equals(s)) return true;
		}
		return false;
	}
	
	private boolean isDependency (Module mod, List<Module> dependencies) {
		for (Module m : dependencies) {
			EcoreUtil.resolveAll(m);
			if (m.eIsProxy()) {
//				System.out.println(m.eResource().getURI());
//				System.out.println(m);
				if (m.toString().contains(mod.getName())) {
					return true;
				}
			}
			//System.out.println(mod.getName()+" "+m.getName());
			if (mod.getName().equals(m.getName())) return true;
		}
		return false;
	}

	@Override
	public boolean supportsPartialFeatureProject() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void addCompiler(IProject project, String sourcePath, String configPath, String buildPath) {
		//addNature(project);
		//addClasspathFile(project, buildPath);
	}
	
	@Override
	public boolean canGeneratInParallelJobs() {
		return false;
	}

	public void resolveProxyRules() {
		for (Module m : this.modules.keySet()) {
			if (m.getRules()==null) continue;
			for (Rule r : m.getRules().getRules()) {
				if (r.getExtendsrule()!=null) {
					Rule ex = r.getExtendsrule();
					if (ex.eIsProxy()) {
//						System.out.println("Resolving proxy rule "+ex.getName());
						this.resolve(r, m);
//						System.out.println("Resolving proxy rule "+ex.getName());
					}
				}
			}
		}
	}

	private void resolve(Rule r, Module m) {
		File f = this.findCaponeFile(m);
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(f));
			String line = reader.readLine();
			while (line != null) {
				if (line.contains("rules")) {
					this.resolveRuleBlock(r, m, line, reader);
					reader.close();
					return;
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void resolveRuleBlock(Rule r, Module m, String line, BufferedReader reader) {
		try {
			do {
				if (line.contains(r.getName()) && line.contains("extends")) {
					String parts[] = line.split("extends");
					String moduleAndRule[] = parts[1].split("\\.");
					this.resolveRuleAndModule(r, m, moduleAndRule[0].trim(), moduleAndRule[1].trim());
				}
				line = reader.readLine();
			} while (line!=null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void resolveRuleAndModule(Rule rule, Module mod, String moduleName, String ruleName) {
		for (Module m : this.modules.keySet()) {
			if (m.getName().equals(moduleName)) {
				if (m.getRules()==null) continue;
				for (Rule r : m.getRules().getRules()) {
					if (ruleName.equals(r.getName())) {
						rule.setExtendsrule(r);  // resolved!
						return;
					}
				}
			}
		}
	}

	private File findCaponeFile(Module m) {
		IProject project = this.module.getProject();
		File root = new File(project.getLocation().toOSString());
		List<File> files= this.allCaponeFiles(root);
		for (File f : files) 
			if (f.getName().equals(m.getName()+".capone")) return f;		
		return null;
	}
}
