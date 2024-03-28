package capone.composer.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;

import capone.composer.CaponeModuleLoader;
import capone.composer.TrafoComposer;
import capone.composer.consistency.ConsistencyError;
import capone.composer.consistency.ExternalTypeConsistencyError;
import capone.composer.helper.EMFHandler;
import capone.composer.helper.HandlerHelper;
import capone.composer.helper.HenshinHelper;
import de.ovgu.featureide.fm.core.base.util.tree.TreeIterator;

public class ConsistencyCheckHandler extends AbstractHandler {

	private CaponeModuleLoader 	cml;	
	private EMFHandler 			emh = new EMFHandler();
	private IProject project;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//MessageDialog.openInformation(null, "Capone", "This functionality is not implemented yet...");
		IFile file = HandlerHelper.getSelectedFile(event);		   				
		checkConsistency(file);		
		return Status.OK_STATUS;
	}

	private List<ConsistencyError> checkConsistency(IFile file) {
		this.project = file.getProject();
		List<ConsistencyError> errors = new ArrayList<>();
		this.cml = new CaponeModuleLoader(file, true);
		String moduleName = this.getModuleName(file);		
		
		checkModuleConsistency(errors, moduleName);
		System.out.println("[CAPONE] consistency errors"+errors);
		
		for (ConsistencyError ce : errors) {
			try {
				IMarker marker = file.createMarker(IMarker.PROBLEM);
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
				marker.setAttribute(IMarker.MESSAGE, ce.toString());
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return errors;
	}

	private void checkModuleConsistency(List<ConsistencyError> errors, String moduleName) {
		System.out.println("[CAPONE] Checking consistency of module "+moduleName);
		
		Set<String> children = this.cml.getChildrenOf(moduleName);
		System.out.println("[CAPONE] Children = "+children);
		
		for (String childName : children ) {
			capone.Module module = this.cml.getModule(childName);			
			Module deltaTrafo    = this.getHenshinModule(module);
			if (deltaTrafo==null) continue;
			for (capone.Rule caponeRule : module.getRules().getRules()) {
				System.out.println("[CAPONE] Checking rule: "+caponeRule.getName());
				if (caponeRule.getExtendsrule() == null) {
					errors.add(new ConsistencyError(childName, caponeRule.getName()));					
					continue;
				}
				Rule henshinRuleExtension = TrafoComposer.getRuleByName(deltaTrafo, caponeRule);
				Set<String> typeNames = this.getTypeNamesOfGraph(henshinRuleExtension.getLhs());
				typeNames.addAll(this.getTypeNamesOfGraph(henshinRuleExtension.getRhs()));
				System.out.println("[CAPONE] Type names : "+typeNames);
				errors.addAll(this.checkTypeNames(module, typeNames, henshinRuleExtension));
			}
			// Now recursively find errors
			this.checkModuleConsistency(errors, module.getName());
		}
	}
	
	private List<ConsistencyError> checkTypeNames(capone.Module module, 
												  Set<String> typeNames,
												  Rule r) {
		List<ConsistencyError> errors = new ArrayList<>();
		String metamodelName = module.getMetamodel();
		Resource rs = this.emh.readEcore(metamodelName, project);
		rs.getAllContents().forEachRemaining( o -> {
			if (!(o instanceof EClass)) return;
			EClass cl = (EClass) o;
			if (!typeNames.contains(cl.getName())) 
				errors.add(new ExternalTypeConsistencyError(module.getName(), r.getName(), cl.getName()));
		});		
		return errors;
	}

	private Module getHenshinModule(capone.Module module) {
		if (module.getRules()==null) return null;
		String trafoName = module.getRules().getRulefile();
		Path trafoPath = new Path(trafoName);
		IFile trafoFile = this.project.getFile(trafoPath); 
		if (!trafoFile.exists()) return null;
		return HenshinHelper.load(trafoFile);
	}

	private Set<String> getTypeNamesOfGraph(Graph gr) {
		Set<String> typeNames = new LinkedHashSet<>();
		for (Node n : gr.getNodes()) 
			typeNames.add(n.getType().getName());		
		return typeNames;
	}

	private String getModuleName(IFile file) {
		String fileName = file.getName();
   		return fileName.substring(0, fileName.length()-".capone".length());
	}
}
