package capone.gs.injectors;

import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.BackgroundStyle;
import org.eclipse.sirius.tools.api.ui.color.EnvironmentSystemColorFactory;
import org.eclipse.sirius.viewpoint.FontFormat;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.SystemColor;

import capone.gs.injector.IGraphicalStyle;

public class HighContrast implements IGraphicalStyle {
	
	private final int FONT_INCREMENT = 10;
	private final int LINE_INCREMENT = 10;
	private final SystemColor FOREGROUND_COLOR = EnvironmentSystemColorFactory.getDefault().getSystemColorDescription("black");
	private final SystemColor BACKGROUND_COLOR = EnvironmentSystemColorFactory.getDefault().getSystemColorDescription("white");

	@Override
	public Group modifyGraphicalSpecification(Group group, Map<String,String> parameterValues) {
		Group newGroup = EcoreUtil.copy(group);
		TreeIterator<EObject> contentIterator = newGroup.eAllContents();
		while (contentIterator.hasNext()) {
			EObject gObject = contentIterator.next();
			for (EStructuralFeature gFeature : gObject.eClass().getEAllStructuralFeatures()) {
				String featureName = gFeature.getName();
				//------------------------------------
				if (featureName.equals("labelSize")) {
					Integer oldValue = (Integer)gObject.eGet(gFeature);
					Integer newValue = oldValue==null? oldValue : oldValue + FONT_INCREMENT;
					gObject.eSet(gFeature, newValue);
				}
				//------------------------------------
				else if (featureName.equals("borderSizeComputationExpression") ||
						 featureName.equals("sizeComputationExpression")) {
					String oldValue = (String)gObject.eGet(gFeature);
					String newValue = "";
					if (oldValue==null || oldValue.isBlank() || oldValue.equals("0"))
						 newValue = oldValue;
					else newValue = (oldValue.startsWith("aql:")? "" : "aql:") + oldValue + "+" + LINE_INCREMENT;
					gObject.eSet(gFeature, newValue);
				}
				//------------------------------------
				else if (featureName.equals("backgroundColor") || 
					     featureName.equals("foregroundColor") ||
						 featureName.equals("color")) {
					if (gObject.eGet(gFeature)!=null) 
						gObject.eSet(gFeature, BACKGROUND_COLOR);
				}
				//------------------------------------
				else if (//featureName.equals("foregroundColor") ||
						 featureName.equals("labelColor") ||
						 featureName.equals("borderColor") ||
						 featureName.equals("strokeColor")) {
					if (gObject.eGet(gFeature)!=null) 
						gObject.eSet(gFeature, FOREGROUND_COLOR);
				}				
				//------------------------------------
				else if (featureName.equals("labelFormat")) {
					EList<FontFormat> format = (EList<FontFormat>)gObject.eGet(gFeature);
					if (!format.contains(FontFormat.BOLD_LITERAL))
						format.add(FontFormat.BOLD_LITERAL);
				}
				//------------------------------------
				else if (featureName.equals("backgroundStyle")) {
					if (gObject.eGet(gFeature)!=null)
						gObject.eSet(gFeature, BackgroundStyle.LIQUID_LITERAL);
				}
			}
		}
		return newGroup;
	}
}