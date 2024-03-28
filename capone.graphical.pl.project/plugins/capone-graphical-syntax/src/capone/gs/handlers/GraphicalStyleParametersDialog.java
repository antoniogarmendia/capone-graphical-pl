package capone.gs.handlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class GraphicalStyleParametersDialog extends Dialog {
	
	private Map<String,String> parameterValues = new HashMap<>();
	private Map<String,Text>   parameterTexts  = new HashMap<>();

	public GraphicalStyleParametersDialog(Shell parentShell, List<String> parameters) {
		super(parentShell);
		for (String parameter : parameters) parameterValues.put(parameter, null); 
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			for (String parameter : parameterValues.keySet()) {
				parameterValues.put(parameter, parameterTexts.get(parameter).getText());
			}
		}		
		super.buttonPressed(buttonId);
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Capone");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.setLayout( new GridLayout( 2, false ) );
		Label    label    = null;
		Text     text     = null;
		GridData gridData = null;
        for (String parameter : parameterValues.keySet()) {
       		label = new Label(composite, SWT.LEFT);
       		label.setText(parameter);
       		gridData = new GridData();
       		gridData.horizontalAlignment = GridData.FILL;
       		gridData.grabExcessHorizontalSpace = true;
       		text = new Text(composite, SWT.SINGLE | SWT.BORDER);
       		text.setLayoutData(gridData);
       		parameterTexts.put(parameter, text);
		}
		return composite;
	}
	
	public String getParameterValue(String parameter) {
		return parameterValues.get(parameter);
	}
}