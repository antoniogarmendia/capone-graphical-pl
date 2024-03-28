package capone.graphical.spl.evaluation.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;

import capone.composer.helper.HandlerHelper;
import capone.graphical.spl.evaluation.utils.ProductStatsUtils;

public class GenerateGraphicalProductsStats extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IFolder folder = HandlerHelper.getSelectedFolder(event);	
		ProductStatsUtils.writeProductsStatsOfAllContainedProducts(folder);
		System.out.println("[Capone] Generate Graphical Products Stats");
		return null;
	}	

}
