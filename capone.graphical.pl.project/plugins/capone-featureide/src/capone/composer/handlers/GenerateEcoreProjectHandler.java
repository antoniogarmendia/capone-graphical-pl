package capone.composer.handlers;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import capone.composer.helper.EMFUtils;
import capone.composer.helper.HandlerHelper;


/*
 * Generate Ecore Project (GenModel), .Edit Project, .Editor Project  
 * */

public class GenerateEcoreProjectHandler extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		final IFile ecoreResource = HandlerHelper.getSelectedFile(event);
		final EPackage ePackage = EMFUtils.copyPackage(ecoreResource);	
		final String ecoreName = FilenameUtils.removeExtension(ecoreResource.getName());
		EMFUtils.generateEcoreEditEditorProject(ecoreName, ecoreName, ePackage, window.getWorkbench());
		return Status.OK_STATUS;
	}	
}
