package de.phvu.extension_test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.sjvie.extension_point_test.ExtensionInterface;

public class FirstExtensionTest implements ExtensionInterface{

	@Override
	public String getName() {
		return "TestButtonWithLog";
	}
	
	@Override
	public void createChild(Composite parent) {
		// TODO Auto-generated method stub
		Label label = new Label(parent, SWT.LEFT);
		label.setText("Log start:");
		
		Button button1 = new Button(parent, SWT.PUSH);
		button1.setText("click me");
		button1.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch(e.type) {
				case SWT.Selection:
					label.setText(label.getText()+"\nButton wurde geklickt");
					parent.layout();
					parent.redraw();
				}
			}
		});
		
		Button buttonReset = new Button(parent, SWT.PUSH);
		buttonReset.setText("RESET");
		buttonReset.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch(e.type) {
				case SWT.Selection:
					// create a dialog with ok and cancel buttons and a question icon
					MessageBox dialog =
					    new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
					dialog.setText("My info");
					dialog.setMessage("Do you really want to do this?");
					int result = dialog.open();
					
					if(result == SWT.OK){
						label.setText("log emptied");
						parent.layout();
						parent.redraw();
					}
				}
			}
		});
		
		
		
		
		
		
	}
}
