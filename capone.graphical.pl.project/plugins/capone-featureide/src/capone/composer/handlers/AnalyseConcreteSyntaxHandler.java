package capone.composer.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;

import capone.composer.helper.HandlerHelper;
import capone.composer.siriusAnalysis.SiriusAnalyser;

public class AnalyseConcreteSyntaxHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("[CAPONE] Analysing the concrete syntax");
		IFile file = HandlerHelper.getSelectedFile(event);
		SiriusAnalyser csAnalyser = new SiriusAnalyser(file);
		return Status.OK_STATUS;
	}

}
