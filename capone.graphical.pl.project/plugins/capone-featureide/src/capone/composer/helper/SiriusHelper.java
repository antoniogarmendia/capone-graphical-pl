package capone.composer.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.sirius.diagram.description.AbstractNodeMapping;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.Layer;

public class SiriusHelper {
	/**
	 * @param viewPoint
	 * @return all ContainerMapping and NodeMappings within all layers of dd
	 */
	public static List<AbstractNodeMapping> getAllNodeMappings(DiagramDescription dd) {
		List<AbstractNodeMapping> results = new ArrayList<>();				
		
		SiriusHelper.addMappings(results, dd.getDefaultLayer());		
		for (Layer al: dd.getAdditionalLayers()) 
			SiriusHelper.addMappings(results, al);					
		return results;
	}

	private static void addMappings(List<AbstractNodeMapping> results, Layer al) {
		results.addAll(al.getNodeMappings());
		results.addAll(al.getContainerMappings());
	}
}
