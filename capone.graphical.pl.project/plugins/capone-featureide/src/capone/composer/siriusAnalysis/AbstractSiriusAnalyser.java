package capone.composer.siriusAnalysis;

import java.util.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

import capone.Diagram;
import capone.Module;
import capone.composer.CaponeModuleLoader;
import capone.composer.DefaultFeatureProvider;
import capone.composer.ViewpointComposer;
import capone.composer.helper.EMFUtils;
import capone.composer.helper.FileUtils;
import capone.composer.helper.SiriusHelper;
import capone.composer.siriusAnalysis.conflicts.SymbolConflict;
import merlin.common.issues.ValidationIssue;
//import merlin.common.utils.FileUtils;

public abstract class AbstractSiriusAnalyser {
	protected CaponeModuleLoader cml;
	private capone.Module module;
	private IProject project;
	private IFile file;
	private String featureFileName;
	private DefaultFeatureProvider dfp;
	
	public AbstractSiriusAnalyser(IFile file) {
		this.cml = new CaponeModuleLoader(file, true);
		this.project = file.getProject();
		this.file = file;
		this.module = this.cml.getCaponeModule();
		this.featureFileName   = file.getName().replaceAll(".capone", ".xml");
		IFile featureFile = file.getProject().getFile(featureFileName); 
		this.dfp = new DefaultFeatureProvider(featureFile);
	}

	protected void checkConflicts(List<SymbolConflict> conflicts) {
		List<ValidationIssue> issues = new ArrayList<>();
		for (SymbolConflict sc: conflicts) {
			ValidationIssue vi = sc.getConflict(this.cml, this.dfp); 
			if (vi!=null) {
				System.out.println("Symbol Conflict: "+sc);
				issues.add(vi);
			}
		}
		FileUtils.updateMarkers(this.file, issues, "capone.marker.problem.sirius");
	}

	protected capone.Module getModuleOf(AbstractNodeMapping node, Map<capone.Module, List<AbstractNodeMapping>> mappings) {
		for (capone.Module mod : mappings.keySet()) 
			if (mappings.get(mod).contains(node)) return mod;		
		return null;
	}

	protected List<AbstractNodeMapping> flatten(Map<capone.Module, List<AbstractNodeMapping>> mappings) {
		// first do a pass of merging
		// TODO: the merging needs to be in order: start from top module
		ViewpointComposer vpc = new ViewpointComposer(null, null, null, null, null);
		for (capone.Module m: mappings.keySet()) {
			if (!mappings.containsKey(m)) continue;
			String depName = this.cml.getDependencyModule(m);
			if (depName==null) continue;
			capone.Module dep = this.getModuleFromName(depName, mappings);
			if (!mappings.containsKey(dep)) continue;
			for (AbstractNodeMapping anm: mappings.get(m)) {
				if (!(anm instanceof NodeMapping)) continue;
				AbstractNodeMapping parent = this.getNodeWithName(anm.getName(), mappings.get(dep));				
				if (parent==null || !(parent instanceof NodeMapping)) continue;
				vpc.mergeNodeMapping((NodeMapping)anm, (NodeMapping)parent);
			}
		}
		// finally, extract all mappings into a list
		List<AbstractNodeMapping> result = new ArrayList<>();
		for (capone.Module m: mappings.keySet()) 
			result.addAll(mappings.get(m));		
		return result;
	}

	protected Module getModuleFromName(String name, Map<Module, List<AbstractNodeMapping>> mappings) {
		for (capone.Module mod: mappings.keySet()) 
			if (mod.getName().equals(name)) return mod;		
		return null;
	}

	protected AbstractNodeMapping getNodeWithName(String name, List<? extends AbstractNodeMapping> mappings) {
		for (AbstractNodeMapping anm : mappings) { 
			if (anm.getName().equals(name)) return anm;
			if (anm instanceof ContainerMapping) { // look in children
				ContainerMapping cm = (ContainerMapping) anm;
				AbstractNodeMapping ret = this.getNodeWithName(name, cm.getSubNodeMappings());
				if (ret!=null) return ret;
			}
		}
		return null;
	}

	protected Map<capone.Module, List<AbstractNodeMapping>> getAllMappings(Map<capone.Module, Group> groups) {
		Map<capone.Module, List<AbstractNodeMapping>> moduleMappings = new LinkedHashMap<>();
		for (capone.Module m : groups.keySet()) {
			Group moduleViewpoint = groups.get(m);
			for (Viewpoint cp: moduleViewpoint.getOwnedViewpoints()) {
				for (RepresentationDescription rd: cp.getOwnedRepresentations()) {
					if (! (rd instanceof DiagramDescription)) continue;
					DiagramDescription dd = (DiagramDescription) rd;
					List<AbstractNodeMapping> mappings = SiriusHelper.getAllNodeMappings(dd);
					moduleMappings.put(m, mappings);
				}
			}
		}
		return moduleMappings;
	}
	
	protected Map<capone.Module, Group> getAllGroups() {
		Map<capone.Module, Group> groups = new LinkedHashMap<>();
		List<capone.Module> allModules = new ArrayList<>();
		allModules.add(this.cml.getCaponeModule()); // initialise with root
		allModules.addAll(this.cml.getModules());	// add the rest
		for (capone.Module m : allModules) {
			if (m.getChooseDiagram()==null) continue;
			String viewpointFile = m.getChooseDiagram().getViewpointFileURI();		
			Path viewpointPath = new Path(this.project.getFullPath().toOSString() + String.valueOf(Path.SEPARATOR) + viewpointFile);
			Group moduleViewpoint = EMFUtils.loadOdesign(viewpointPath);
			if (moduleViewpoint == null) {
				System.out.println("The viewpoint " + viewpointPath + "does not exist");
				continue;
			}
			groups.put(m, moduleViewpoint);
		}
		return groups;
	}
	
}
