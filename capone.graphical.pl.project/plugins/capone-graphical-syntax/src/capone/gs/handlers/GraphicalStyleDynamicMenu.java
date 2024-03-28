package capone.gs.handlers;

import java.util.HashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

public class GraphicalStyleDynamicMenu extends ExtensionContributionFactory {
	
	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		IExtensionRegistry      registry   = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor("capone.gs.GraphicalStyleInjector");
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement element = extensions[i];
			if (element.getName().equals("GraphicalStyle")) {
				String styleName = element.getAttribute("name");
				// create parameters of command contribution
				HashMap<String, String> params = new HashMap<String, String>();	
				params.put("gsInjectorCode", styleName);				
				CommandContributionItemParameter itemParameter = new CommandContributionItemParameter(serviceLocator, styleName, "capone.gs.commands.GSInjector", SWT.PUSH);
				itemParameter.label = styleName;
				itemParameter.parameters = params;
				// create command contribution
				CommandContributionItem item = new CommandContributionItem(itemParameter);
				item.setVisible(true);
				additions.addContributionItem(item, null);
			}
		}
	}
}