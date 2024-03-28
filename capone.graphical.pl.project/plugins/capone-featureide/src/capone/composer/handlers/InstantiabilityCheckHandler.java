package capone.composer.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import capone.composer.effectiveMetamodel.Metamodel150Generator;
import capone.composer.helper.HandlerHelper;
import merlin.analysis.validate.properties.PropertyChecker;
import merlin.analysis.validate.properties.PropertyChecker.ProblemSpace;
import merlin.analysis.validate.properties.PropertyChecker.SolutionArity;
import merlin.analysis.validate.properties.PropertyResult;
import merlin.common.concepts.SelectedConcepts;
import merlin.common.features.DefaultFeatureProvider;

public class InstantiabilityCheckHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window  = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IFile            file    = HandlerHelper.getSelectedFile(event);
		IProject         project = file.getProject();

		try {
			// generate 150 metamodel		
			Resource metamodel150 = new Metamodel150Generator(file).generateEcore(file.getParent());
		
			// read name of feature model from 150 metamodel
			EPackage    epackage    = (EPackage)metamodel150.getContents().get(0);
			EAnnotation eannotation = epackage.getEAnnotation("features");
			String      featureModel = eannotation.getDetails().get("file");
		
			// analyse instantiability
			SelectedConcepts.setFeatureModel(featureModel);
			IFile  featmodelFile    = project.getFile(featureModel);		
			IFile  metamodel150File = project.getFile( metamodel150.getURI().lastSegment() );			
			metamodel150File.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
			
			PropertyChecker checker = new PropertyChecker(metamodel150File, new DefaultFeatureProvider(featmodelFile));
			checker.setDebug(Path.fromOSString(project.getLocation().toString()).toOSString());
			PropertyResult result = checker.check(
				""/*property*/, 
				""/*configuration scope*/, 
				SolutionArity.ONE/*number of solutions*/, // change to SolutionArity.ALL_MIN/SolutionArity.ALL_MAX to find all instantiable metamodels  
				ProblemSpace.EXISTS/*problem*/, 
				true/*generate witness*/, 
				true/*generate configuration*/, 
				false/*exercise features*/, 
				false/*check syntax*/
				);
		
			if (result.hasErrors()) MessageDialog.openError      (window.getShell(), "Merlin", metamodel150File.getName() + " has the following problems:\n" + result.getErrors());
			else                    MessageDialog.openInformation(window.getShell(), "Merlin", result.getSummary());				
		}
		catch (Exception e) {
			e.printStackTrace();
			return Status.ERROR;
		}

		return Status.OK_STATUS;
	}
}