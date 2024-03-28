package capone.composer.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;

import capone.composer.effectiveMetamodel.Metamodel150Generator;
import capone.composer.helper.HandlerHelper;

public class Generate150MetamodelHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("[CAPONE] Generating 150% metamodel");	
		IFile file = HandlerHelper.getSelectedFile(event);
		Metamodel150Generator emg = new Metamodel150Generator(file);
		emg.generateEcore(file.getParent());
		return Status.OK_STATUS;
	}
}
