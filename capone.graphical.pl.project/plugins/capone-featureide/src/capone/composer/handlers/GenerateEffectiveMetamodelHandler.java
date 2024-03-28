package capone.composer.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.Status;

import capone.composer.effectiveMetamodel.EffectiveMetamodelGenerator;
import capone.composer.helper.HandlerHelper;

public class GenerateEffectiveMetamodelHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("[CAPONE] Generating effective metamodel");	
		IFile file = HandlerHelper.getSelectedFile(event);
		EffectiveMetamodelGenerator emg = new EffectiveMetamodelGenerator(file);
		emg.generateEcore(file.getParent());
		return Status.OK_STATUS;
	}
}
