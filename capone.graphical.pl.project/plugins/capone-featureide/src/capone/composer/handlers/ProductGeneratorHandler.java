package capone.composer.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import capone.composer.FeatureProjectWrapper;
import capone.composer.helper.HandlerHelper;
import capone.composer.wizard.CaponeProductWizard;
import de.ovgu.featureide.core.IFeatureProject;

public class ProductGeneratorHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IFile caponeFile = HandlerHelper.getSelectedFile(event);
		IProject prj = caponeFile.getProject();
		
		IWorkbenchWindow    window  = HandlerUtil.getActiveWorkbenchWindowChecked(event);
   		Shell               shell   = window.getShell();
   		IFeatureProject     project = new FeatureProjectWrapper(caponeFile);
   		CaponeProductWizard wizard  = new CaponeProductWizard(project, false, prj);
	    WizardDialog        dialog  = new WizardDialog(shell, wizard);
		wizard.setNeedsProgressMonitor(true);
		dialog.create();
		dialog.open();		
   		
		System.out.println("[CAPONE] Capone product generator");
		return Status.OK_STATUS;
	}
}
