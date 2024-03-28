package capone.composer.handlers;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.sirius.viewpoint.description.Group;

import capone.composer.helper.EMFUtils;
import capone.composer.helper.HandlerHelper;
import capone.composer.helper.ViewpointSpecificationProjectExtended;

public class GenerateViewpointSpecificationProject extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IFile viewpointFile = HandlerHelper.getSelectedFile(event);
		final Group viewpointGroup = EMFUtils.copyGroupViewpoint(viewpointFile);
		final String viewpointName = FilenameUtils.removeExtension(viewpointFile.getName());
		try {
			ViewpointSpecificationProjectExtended.createNewViewpointSpecificationProject(viewpointName + ".design", 
					viewpointName + ".odesign", viewpointGroup);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return Status.OK_STATUS;
	}	
	
}
