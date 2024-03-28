package capone.gs.injector;

import java.util.Map;

import org.eclipse.sirius.viewpoint.description.Group;

public interface IGraphicalStyle {
	Group modifyGraphicalSpecification(Group group, Map<String,String> parameterValues);
}
