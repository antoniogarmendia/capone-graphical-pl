package capone.composer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;

import capone.Module;
import capone.composer.helper.CaponeHelper;
import capone.composer.helper.EMFHandler;

public class CaponeModuleLoader {
	private boolean			reversed = false;
	private IFile 			module;
	private File 			moduleFile;
	private Resource 		moduleResource;
	private EMFHandler 		emh = new EMFHandler();
	private ResourceSet 	resourceSet;
	private capone.Module 	caponeModule;		// current module
	private Set<Module>	modules = new LinkedHashSet<>();
	private Map<Module, Map<Dependency, Set<String>>> modulesByDependency = new LinkedHashMap<>();
	private Map<Module, File> files = new LinkedHashMap<>();
	
	public CaponeModuleLoader (IFile f, boolean reversed) {
		this.reversed = reversed;
		this.module = f;
		IPath location = this.module.getLocation();
		if (location != null) {
			this.moduleFile = location.toFile();
			this.loadModule();
		}
	}
	
	public void resolveAllProxies() {
		for (Module m : this.modules) 
			EcoreUtil.resolveAll(m.eResource());		
	}
	
	// returns the direct dependent modules classified by Dependency
	public Map<Dependency, Set<String>> getModulesByDependency(String name) {
		for (Module m : this.modulesByDependency.keySet()) {
			if (m.getName().equals(name)) return this.modulesByDependency.get(m);
		}
		return Collections.emptyMap();
	}
		
	private void loadModule() {
		if (this.moduleResource==null) {
			if (this.emh==null) this.emh = new EMFHandler();
			this.moduleResource = this.emh.loadXtextModel(this.moduleFile);
			this.resourceSet = this.moduleResource.getResourceSet();
			this.caponeModule = (Module) this.moduleResource.getAllContents().next();
			
			List<Module> pending = new ArrayList<>();
			Map<Module,File> acum = this.findModules(this.caponeModule, this.moduleFile);
			this.files.putAll(acum);
			this.modules.addAll(acum.keySet());		// remove dups -> use set?
			pending.addAll(acum.keySet());
			int idx = 0;
			
			//Iterator<Module> it = pending.iterator();
		
			while (idx < pending.size()) {
				Module next = pending.get(idx);				
				Map<Module,File> deps = this.findModules(next,acum.get(next));
				this.files.putAll(acum);
				acum.putAll(deps);
				addNoDup(pending, deps.keySet());
				this.modules.addAll(deps.keySet());
				idx++;
			}
		}
	}
	
	public boolean isShared(String feature) {
		int num = 0;
		for (Module m : this.modulesByDependency.keySet()) {
			Map<Dependency, Set<String>> map = this.modulesByDependency.get(m);
			for (Dependency dk: map.keySet()) 
				if (map.get(dk).contains(feature)) num++;
		}
		return num>1;
	}
	
	private void addNoDup(List<Module> pending, Set<Module> set) {
		List<Module> toAdd = new ArrayList<>();
		for (Module m : set) 
			if (!hasModule(pending, m)) toAdd.add(m);
		pending.addAll(toAdd);
	}

	private boolean hasModule(List<Module> pending, Module m) {
		for (Module pm : pending) 
			if (pm.getName().equals(m.getName())) return true;
		return false;
	}

	private Map<Module, File> findModules(Module m, File f) {
		if (this.reversed)
			return this.findDependentModules(m);
		else 
			return this.findDependencyModules(m, f);
	}
	
	private Map<Module, File> findDependentModules(Module module) {
		Map<Module, File> dependent = new LinkedHashMap<>();
		IProject project = this.module.getProject();
		File root = new File(project.getLocation().toOSString());
		List<File> files= this.allCaponeFiles(root);
		for (File f: files) {
			Resource res = this.emh.loadXtextModel(f);
			if (!res.getAllContents().hasNext()) continue;
			Module mod = (Module) res.getAllContents().next();
			Map<Dependency, List<String>> dee = CaponeHelper.getDependencies(f);
			Dependency dk;
			if ((dk=isDependencyS(module, dee))!=null) {
				dependent.put(mod, f);
				if (!this.modulesByDependency.containsKey(module)) 
					this.modulesByDependency.put(module, new LinkedHashMap<Dependency, Set<String>>());
				Map<Dependency, Set<String>> deps = this.modulesByDependency.get(module);
				if (!deps.containsKey(dk))
						deps.put(dk, new LinkedHashSet<>());
				deps.get(dk).add(mod.getName());				
			} else if (mod.isIsTop() && !mod.getName().equals(module.getName())) {
				if (!dependent.containsKey(mod)) dependent.put(mod, f);
				if (!this.modulesByDependency.containsKey(mod)) 
					this.modulesByDependency.put(mod, new LinkedHashMap<Dependency, Set<String>>());				
			}
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
	
	private Dependency isDependencyS (Module mod, Map<Dependency, List<String>> dependencies) {
		for (Dependency dk : dependencies.keySet()) {
			for (String s : dependencies.get(dk)) {
				if (mod.getName().equals(s)) return dk;
			}
		}
		return null;
	}
	
	private Map<Module, File> findDependencyModules(Module module, File f) {
		Map<Dependency, List<String>> dependencies = CaponeHelper.getDependencies(f);
		
		Map<Module, File> dependent = new LinkedHashMap<>();
		IProject project = this.module.getProject();
		File root = new File(project.getLocation().toOSString());
		List<File> files= this.allCaponeFiles(root);
		for (File cf: files) {
			this.emh = new EMFHandler();
			//this.emh.setResourceSet(this.resourceSet);
			Resource res = this.emh.loadXtextModel(cf);
			Module mod = (Module) res.getAllContents().next();
			String modName = mod.getName();
			if (allValues(dependencies).contains(modName))
				dependent.put(mod,cf);
		}
		return dependent;
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
	
	public capone.Module getCaponeModule() {
		return this.caponeModule;
	}
	
	public IFile getModule() {
		return this.module;
	}
	
	public List<Module> getModules() {
		return new ArrayList<>(this.modules);
	}
	
	public Resource readEcore(IFile f) {
		return this.emh.readEcore(f);
	}
	
	public Resource readEcore(String fname, IProject pr) {
		return this.emh.readEcore(fname, pr);
	}
	
	public void extend(Resource res, Resource delta, String moduleName) {
		this.emh.extend(res, delta , moduleName);
	}

	public Set<String> getChildrenOf(String module) {
		return this.merge(this.getChildren(module));
	}

	private Set<String> merge(Map<Dependency, Set<String>> map) {
		Set<String> modules = new LinkedHashSet<>();
		for (Dependency dk : map.keySet()) 
			modules.addAll(map.get(dk));
		return modules;
	}

	public Dependency getDependencyKind(String parent, String child) {
		Map<Dependency, Set<String>> children = this.getChildren(parent);
		for (Dependency dk : children.keySet()) 
			if (children.get(dk).contains(child)) return dk;		
		return null;
	}
	
	public Map<Dependency, Set<String>> getChildren(String module) {
		for (Module m : this.modulesByDependency.keySet()) 
			if (m.getName().equals(module)) 
				return this.modulesByDependency.get(m);
		return Collections.emptyMap();
	}

	public List<String> childrenOfKind(String feat, Dependency ...kinds) {
		Map<Dependency, Set<String>> children = this.getChildren(feat);
		List<String> result = new ArrayList<>();
		for (Dependency d : kinds) 
			if (children.containsKey(d)) result.addAll(children.get(d));		
		return result;
	}

	public List<Module> getTopModules() {
		return this.modulesByDependency.keySet().stream().filter(m -> m.isIsTop()).collect(Collectors.toList());
	}

	public Module getModule(String name) {
		for (Module m : this.modules)
			if (m.getName().equals(name)) return m;
		return null;
	}

	public String getDependencyModule(Module m) {
		for (Module mod : this.modules) {			
			if (!(mod.getName().equals(m.getName()))) continue;
			for (Module dep: mod.getAllModuleDependencies()) {
				return dep.getName();
			}			
		}
		return null;
	}

	/**
	 * @param m1
	 * @param m2
	 * @return true if m1 is parent of m2 or vice-versa
	 */
	public boolean isParentOf(Module m1, Module m2) {	
		Set<String> children = new LinkedHashSet<String>();
		children.add(m2.getName());
		if (isInSet(m1, children)) return true;
		children = new LinkedHashSet<String>();
		children.add(m1.getName());
		return isInSet(m2, children);
	}
	
	private boolean isInSet(Module m, Set<String> modules) {
		if (modules.size()==0) return false;
		Iterator<String> it = modules.iterator();
		String firstModule = it.next(); 
		if (m.getName().equals(firstModule)) return true;
		modules.remove(firstModule);
		modules.addAll(this.getChildrenOf(firstModule));
		return this.isInSet(m, modules);
	}

	public File getFile(String module) {
		for (Module m : this.files.keySet()) {
			if (m.getName().equals(module)) return this.files.get(m);
		}
		return null;
	}
}
 