/*
 * generated by Xtext 2.25.0
 */
package capone.validation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.xtext.validation.Check;

import capone.CaponePackage;
import capone.Diagram;
import capone.Module;
import capone.RuleSet;

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class CaponeDslValidator extends AbstractCaponeDslValidator {
	
//	private DefaultFeatureProvider fp;
	
	@Check
	public void checkMetamodel (Module module) {
		if (module.getMetamodel()==null) 
			error("The module lacks a metamodel (ecore) file", 
					CaponePackage.Literals.MODULE__NAME,
					"ERR_Metamodel");		
		else if (!exists(module.getMetamodel()))
			error("The file does not exist", 
					CaponePackage.Literals.MODULE__METAMODEL,
					"ERR_Metamodel");				
		else if (!module.getMetamodel().endsWith(".ecore"))
			error("The file should be an .ecore file", 
					  CaponePackage.Literals.MODULE__METAMODEL, 
					  "ERR_Metamodel_Extension");
	}
	
	/*
	 * Check that the Viewpoint exist 
	 * */
	@Check
	public void checkViewpoint(Diagram diagram) {
		if (diagram.getViewpointFileURI() != null) {
			if (!exists(diagram.getViewpointFileURI())) {
				error("The file does not exist", 
						CaponePackage.Literals.DIAGRAM__VIEWPOINT_FILE_URI,
						"ERR_Viewpoint");
			}	
			if (!diagram.getViewpointFileURI().endsWith(".odesign")) {
				error("File extension should be .odesign", 
						CaponePackage.Literals.DIAGRAM__VIEWPOINT_FILE_URI,
						"ERR_Viewpoint");
			}
		} else {
			error("The module lacks a viewpoint (odesign) file", 
					CaponePackage.Literals.DIAGRAM__VIEWPOINT_FILE_URI,
					"ERR_Viewpoint_Extension");
		}
	}
	
/*	@Check
	public void checkRuleFile (Module module) {
		if (module.getRules()==null) 
			error("The module lacks a rule (henshin) file", 
					CaponePackage.Literals.MODULE__NAME,
					"ERR_RuleFile");
	}*/
	
	@Check
	public void checkRuleFile (RuleSet ruleset) {
		IFile file = this.getFile(ruleset.getRulefile());
		if (file == null)
			error("The file does not exist", 
					CaponePackage.Literals.RULE_SET__RULEFILE,
					"ERR_RuleFile");		
		else if (!ruleset.getRulefile().endsWith(".henshin"))
			error("The file should be a .henshin file", 
					  CaponePackage.Literals.RULE_SET__RULEFILE, 
					  "ERR_RuleFile_Extension");
		else {
			org.eclipse.emf.henshin.model.Module module = loadModule(file);
			if (module==null)
				error("The file does not contain a valid transformation module", 
						CaponePackage.Literals.RULE_SET__RULEFILE,
						"ERR_RuleFile_Trafo");
			else {
				List<String> invalidRules = new ArrayList<>();
				ruleset.getRules().forEach(rule -> { if (module!=null && !hasRule(module, rule.getName())) invalidRules.add(rule.getName()); } );
				if (!invalidRules.isEmpty()) 
					error("The file does not define the following rules: " + invalidRules,
							CaponePackage.Literals.RULE_SET__RULEFILE,
							"ERR_RuleSet_InvalidRules");
			}
		}
	}
	
	@Check
	public void checkDependenciesWhenNonTop (Module module) {
		if (!module.isIsTop() && module.getAllModuleDependencies().isEmpty()) 
			error("The module needs to extend some other module", 
					CaponePackage.Literals.MODULE__NAME,
					"ERR_DependenciesWhenNonTop");
	}
	
	@Check
	public void checkDependenciesWhenTop (Module module) {
		String error = "Top modules cannot extend other modules";
		if (module.isIsTop() && !module.getModuleMandatory().isEmpty()) 
			error(error, 
					CaponePackage.Literals.MODULE__MODULE_MANDATORY,
					"ERR_DependenciesWhenTop");
		if (module.isIsTop() && !module.getModuleOptional().isEmpty()) 
			error(error, 
					CaponePackage.Literals.MODULE__MODULE_OPTIONAL,
					"ERR_DependenciesWhenTop");
		if (module.isIsTop() && !module.getModuleAlternative().isEmpty()) 
			error(error, 
					CaponePackage.Literals.MODULE__MODULE_ALTERNATIVE,
					"ERR_DependenciesWhenTop");
		if (module.isIsTop() && !module.getModuleOr().isEmpty()) 
			error(error, 
					CaponePackage.Literals.MODULE__MODULE_OR,
					"ERR_DependenciesWhenTop");
	}
	
	@Check
	public void checkRules (RuleSet ruleset) {
		if (ruleset.getRules().isEmpty()) 
			error("The module must define at least one rule", 
					CaponePackage.Literals.RULE_SET__RULEFILE,
					"ERR_RuleSet");
	}	
	
	//
	private IFile getFile (String file) {
		// TODO: search only in current project  
		for (IProject p : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			if (!p.isOpen()) continue;
			IFile fl = p.getFile(file);
			if (fl.exists())
				return fl;
		}
		return null;
	}	
	
	//
	private boolean exists (String file) {
		return getFile(file)!=null;
	}
	
	//
	private org.eclipse.emf.henshin.model.Module loadModule (IFile f) {
		ResourceSet resourceSet = new ResourceSetImpl();

        // register UML
        EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();
        packageRegistry.put(HenshinPackage.eNS_URI, HenshinPackage.eINSTANCE);

        // Register XML resource as UMLResource.Factory.Instance
        Map<String,Object> extensionFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
        extensionFactoryMap.put("xmi", new XMIResourceFactoryImpl());
        Resource resource = (Resource) resourceSet.createResource(URI.createFileURI(f.getFullPath().toOSString()));

        // try to load the file into resource
        try {
			resource.load(null);
			return (org.eclipse.emf.henshin.model.Module)resource.getContents().get(0);
		} 
        catch (IOException e) {}
		return null;
	}	
	
	//
	private boolean hasRule(org.eclipse.emf.henshin.model.Module module, String rule) {
		for (org.eclipse.emf.henshin.model.Rule r : module.getAllRules()) 			
			if (r.getName().equals(rule)) 
				return true;		
		return false;
	}
	
//	private void getFeatureProvider() {
//		if (this.fp==null) {
//			IFile fmFile = this.getFile("model.xml");
//			this.fp = new DefaultFeatureProvider(fmFile);
//		}
//	}
//	
//
//	private boolean isValidFeature(String f) {	
//		this.getFeatureProvider();	
//		return this.fp.getFeature(f)!=null;		
//	}
	
}
