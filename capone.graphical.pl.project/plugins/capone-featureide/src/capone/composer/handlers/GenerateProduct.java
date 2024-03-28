package capone.composer.handlers;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.ui.handlers.HandlerUtil;

import capone.composer.helper.EMFUtils;
import capone.composer.helper.HandlerHelper;
import capone.composer.helper.ProductConfiguration;
import capone.composer.helper.ViewpointSpecificationProjectExtended;

public class GenerateProduct extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IFolder currentSelection = HandlerHelper.getSelectedFolder(event);		
		final ProductConfiguration productConfiguration = checkEcoreViewpointExist(currentSelection);
		generateProduct(currentSelection.getName() ,productConfiguration, event); 
		return Status.OK_STATUS;
	}

	private void generateProduct(final String projectName, 
			final ProductConfiguration productConfiguration, final ExecutionEvent event) {
		// Generate Ecore
		final EPackage ePackage = EMFUtils.copyPackage(productConfiguration.getEcoreFile());
		//Set URI. Avoid collisions with other products.
		ePackage.setNsURI(ePackage.getNsURI() + "/" + projectName);
		final String ecoreName = FilenameUtils.removeExtension(productConfiguration.getEcoreFile().getName());
		EMFUtils.generateEcoreEditEditorProject(projectName + ".mm",
				ecoreName, ePackage, HandlerUtil.getActiveWorkbenchWindow(event).getWorkbench());		
		// Generate Viewpoint Specification Project
		final Group viewpointGroup = EMFUtils.copyGroupViewpoint(productConfiguration.getOdesignFile());
		//Change target meta-model
		EMFUtils.setTargetMetamodels(viewpointGroup,ePackage);
		try {
			ViewpointSpecificationProjectExtended.createNewViewpointSpecificationProject(projectName + ".design", 
					productConfiguration.getOdesignFile().getName(), viewpointGroup);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private ProductConfiguration checkEcoreViewpointExist(IFolder currentSelection) {
		final ProductConfiguration productConfiguration = new ProductConfiguration();
		try {
			final IResource[] members = currentSelection.members();
			for (IResource member : members) {
				if (member instanceof IFile) {
					final IFile fileMember = (IFile) member;
					if (fileMember.getFileExtension().equals("ecore")) {
						//Get ecore
						productConfiguration.setEcoreFile(fileMember);
					} else if (fileMember.getFileExtension().equals("odesign")) {
						//Process viewpoint
						productConfiguration.setOdesignFile(fileMember);
					}
					if (productConfiguration.getEcoreFile() != null && productConfiguration.getOdesignFile() != null)
						break;
				}
			}			
		} catch (CoreException e) {
			e.printStackTrace();
		}	
		//TODO check that Ecore and Viewpoint exist. If not throw an error.
		return productConfiguration;
	}

}
