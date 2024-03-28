package capone.composer.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;

import capone.composer.helper.HandlerHelper;
import capone.composer.siriusAnalysis.SiriusAnalyser;
import capone.composer.siriusAnalysis.SiriusConflictsAnalyser;

public class AnalyseGraphicalConflictsHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {		
		IFile file = HandlerHelper.getSelectedFile(event);
		System.out.println("[CAPONE] Analysing graphical conflicts for "+file.getName());
		new SiriusConflictsAnalyser(file);
		return Status.OK_STATUS;
	}

}
