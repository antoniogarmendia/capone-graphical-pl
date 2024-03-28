package capone.gs.handlers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.swt.widgets.Display;

import capone.BinaryOperator;
import capone.BinaryTerm;
import capone.CaponeFactory;
import capone.Diagram;
import capone.Formula;
import capone.Module;
import capone.NextTerm;
import capone.UnaryTerm;
import capone.composer.CaponeModuleLoader;
import capone.composer.helper.EMFHandler;
import capone.composer.helper.EMFUtils;
import capone.composer.helper.HandlerHelper;
import capone.gs.injector.IGraphicalStyle;

public class GraphicalStyleInjectorHandler extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			IExtensionRegistry      registry   = Platform.getExtensionRegistry();
			IConfigurationElement[] extensions = registry.getConfigurationElementsFor("capone.gs.GraphicalStyleInjector");
			String                  styleName  = event.getParameter("gsInjectorCode");
			for (int i = 0; i < extensions.length; i++) {
				IConfigurationElement element = extensions[i];
				if (element.getName().equals("GraphicalStyle") &&
					// instance of extension point must be equals to the value of the received parameter
					styleName!=null && 
					styleName.equals(element.getAttribute("name"))) {
					// does the injector define parameters?
					List<String> parameters = new ArrayList<>();
					for (IConfigurationElement child : element.getChildren())
						if (child.getName().equals("Parameter"))
							parameters.add(child.getAttribute("name"));
					// execute injection
					IFile caponeFile = HandlerHelper.getSelectedFile(event);
					System.out.println("Injecting style '"+styleName+"' in "+caponeFile.getName());
					IGraphicalStyle styleClass = (IGraphicalStyle)element.createExecutableExtension("style");
					this.injectGraphicalStyle(caponeFile, styleClass, styleName.replaceAll(" ", ""), parameters);
				}
			}		
		} 
		catch (CoreException e) { e.printStackTrace(); }
		return null;
	}
	/**
	 * It injects a graphical style into the active LPL.
	 * @param graphicalStyleClass
	 * @throws CoreException 
	 */
	private void injectGraphicalStyle(IFile caponeFile, IGraphicalStyle styleClass, String styleName, List<String> parameters) throws CoreException {
		EMFHandler emfHandler = new EMFHandler();
		
		// ask value of injector parameters (if there are any) ..............		
		Map<String,String> parameterValues = new HashMap<>();
		if (!parameters.isEmpty()) {
			GraphicalStyleParametersDialog dialog = new GraphicalStyleParametersDialog(Display.getCurrent().getActiveShell(), parameters);
			if (dialog.open() == Window.OK)
				for (String parameter : parameters) {
					parameterValues.put(parameter, dialog.getParameterValue(parameter));
			System.out.println(parameter +":"+ dialog.getParameterValue(parameter)); }
			// if the injection was cancelled:
			else return;
		}
		
		// for each module in the LPL .......................................
		CaponeModuleLoader cml          = new CaponeModuleLoader(caponeFile, true);
		List<Module>       modules      = cml.getModules();
		Module             topModule    = cml.getTopModules().get(0); // there is only one top module
		Module             newTopModule = null;
		
		// handle top module first
		modules.remove(topModule);
		modules.add(0, topModule);
		
		for (Module module : modules) {
			System.out.println("[CAPONE] module "+module.getName());
			
			ResourceSet resourceSet = module.eResource().getResourceSet();
			String moduleWithStyle  = module.getName() + "_" + styleName;
			IProject caponeProject  = caponeFile.getProject();
			String projectPath      = File.separator + caponeProject.getName();
			String modulesPath      = "/modules"; // TODO: update with path of module
			String modulePath       = modulesPath + File.separator + module.getName() + File.separator + moduleWithStyle;
			String ecoreFilepath    = modulePath + File.separator + moduleWithStyle + ".ecore";
			String odesignFilepath  = modulePath + File.separator + moduleWithStyle + ".odesign";
			String caponeFilepath   = modulePath + File.separator + moduleWithStyle + ".capone";
			
			// ..............................................................
			// create graphical syntax
			Diagram diagram      = module.getChooseDiagram();
			String  graphics     = diagram.getViewpointFileURI();
			Path    graphicsPath = new Path(projectPath + "/" + graphics);			
			Group   group        = EMFUtils.loadOdesign(graphicsPath);
			if (group!=null) {
				Group newGroup = styleClass.modifyGraphicalSpecification(group, parameterValues);
				this.save(resourceSet, newGroup, projectPath + odesignFilepath);
			}
			Diagram newDiagram = CaponeFactory.eINSTANCE.createDiagram();
			newDiagram.setViewpointFileURI(odesignFilepath);

			// ..............................................................
			// create capone module: child, optional, cross-tree constraint
			Module newModule = CaponeFactory.eINSTANCE.createModule();
			newModule.setName(module.getName() + "_" + styleName);
			newModule.getModuleOptional().add(module); 
			newModule.setMetamodel(ecoreFilepath);
			newModule.setChooseDiagram(newDiagram);
			if (module.isIsTop()) {
				newTopModule = newModule;
			}
			else {
				// condition1: Module_Style implies Top_Style 
				BinaryTerm condition1 = CaponeFactory.eINSTANCE.createBinaryTerm();
				UnaryTerm  left       = CaponeFactory.eINSTANCE.createUnaryTerm(); left.setVariable(newModule);
				UnaryTerm  right      = CaponeFactory.eINSTANCE.createUnaryTerm(); right.setVariable(newTopModule);
				condition1.setOperand1(left);
				condition1.setOperand2(right);
				condition1.setBoperator(BinaryOperator.IMPLIES);

				// condition2: Top_Style implies ( Module_Style implies Module ) 
				BinaryTerm condition2  = CaponeFactory.eINSTANCE.createBinaryTerm();
				BinaryTerm consequence = CaponeFactory.eINSTANCE.createBinaryTerm();
				UnaryTerm  termTopModule    = CaponeFactory.eINSTANCE.createUnaryTerm(); termTopModule.setVariable(newTopModule);
				UnaryTerm  termParentModule = CaponeFactory.eINSTANCE.createUnaryTerm(); termParentModule.setVariable(module);
				UnaryTerm  termChildModule  = CaponeFactory.eINSTANCE.createUnaryTerm(); termChildModule.setVariable(newModule);
				consequence.setOperand1(termChildModule);
				consequence.setOperand2(termParentModule);
				consequence.setBoperator(BinaryOperator.IMPLIES);
				condition2.setOperand1(termTopModule);
				condition2.setOperand2(consequence);
				condition2.setBoperator(BinaryOperator.IMPLIES);				
				
				// condition3: Top_Style implies ( Module implies Module_Style ) 
				BinaryTerm condition3  = CaponeFactory.eINSTANCE.createBinaryTerm();
				consequence = CaponeFactory.eINSTANCE.createBinaryTerm();
				termTopModule    = CaponeFactory.eINSTANCE.createUnaryTerm(); termTopModule.setVariable(newTopModule);
				termParentModule = CaponeFactory.eINSTANCE.createUnaryTerm(); termParentModule.setVariable(module);
				termChildModule  = CaponeFactory.eINSTANCE.createUnaryTerm(); termChildModule.setVariable(newModule);
				consequence.setOperand1(termParentModule);
				consequence.setOperand2(termChildModule);
				consequence.setBoperator(BinaryOperator.IMPLIES);
				condition3.setOperand1(termTopModule);
				condition3.setOperand2(consequence);
				condition3.setBoperator(BinaryOperator.IMPLIES);				
				
				// condition1 and condition2 and condition3
				NextTerm nextCondition2 = CaponeFactory.eINSTANCE.createNextTerm();
				nextCondition2.setTerm(condition2);
				nextCondition2.setBoperator(BinaryOperator.AND);
				condition1.setNext(nextCondition2);
				NextTerm nextCondition3 = CaponeFactory.eINSTANCE.createNextTerm();
				nextCondition3.setTerm(condition3);
				nextCondition3.setBoperator(BinaryOperator.AND);
				condition2.setNext(nextCondition3);
				
				Formula formula = CaponeFactory.eINSTANCE.createFormula();
				formula.setTerm(condition1);
				newModule.setFormula(formula);
			}
			this.save(resourceSet, newModule, projectPath + caponeFilepath);
			
			// ..............................................................
			// create empty metamodel
			Resource srcMetamodel = emfHandler.readEcore(module.getMetamodel(), caponeProject);
			if (srcMetamodel!=null) {
				EPackage srcPackage   = emfHandler.getEPackage(srcMetamodel);
				EPackage metamodel = EcoreFactory.eINSTANCE.createEPackage();
				metamodel.setNsURI(srcPackage.getNsURI());
				metamodel.setNsPrefix(srcPackage.getNsPrefix());
				metamodel.setName(srcPackage.getName());
				this.save(resourceSet, metamodel, projectPath + ecoreFilepath);
			}			
		}
	}
	
	/**
	 * Save resource
	 * @param rs
	 * @param object
	 * @param filePath
	 */
	private void save (ResourceSet rs, EObject object, String filePath) {
		Resource resource = rs.createResource(URI.createFileURI(filePath)); 
		resource.getContents().add(object);
		try {
			resource.save(null);
		} catch (IOException e) {
			System.err.println("[Capone] Error saving file");
		}
	}
}
