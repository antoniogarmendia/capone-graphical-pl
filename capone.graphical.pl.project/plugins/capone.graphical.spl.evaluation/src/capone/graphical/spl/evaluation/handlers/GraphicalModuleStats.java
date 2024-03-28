package capone.graphical.spl.evaluation.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;

import capone.composer.helper.HandlerHelper;
import capone.graphical.spl.evaluation.utils.CaponeStatsUtils;

public class GraphicalModuleStats extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IFile file = HandlerHelper.getSelectedFile(event);
		CaponeStatsUtils.writeCaponeGraphicalModuleStats(file);
		System.out.println("[CAPONE] Generate Module Stats");
		return null;
	}

}
