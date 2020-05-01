package de.sjvie.extension_point_test;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class LogView extends ViewPart {

	@Override
	public void createPartControl(Composite parent) {
		Label title = new Label(parent, SWT.LEFT);
		title.setText("Log");
//		Button btn = new Button(parent, SWT.LEFT);
//		btn.setText("HELO");
		
		Composite container = new Composite(parent, SWT.LEFT);
		Label label = new Label(parent, SWT.LEFT);
		label.setText("MIAU");
		
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IExtensionPoint ep = reg.getExtensionPoint("de.sjvie.extension_point_test");
		IExtension[] extensions = ep.getExtensions();
		for( int i = 0; i < extensions.length; i ++) {
			IExtension ext = extensions[i];
			IConfigurationElement[] ce = ext.getConfigurationElements();
			for(int j = 0; j < ce.length; j ++) {
				Object obj = null;
				try {
					obj = ce[j].createExecutableExtension("class");
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (obj instanceof ExtensionInterface) {
					((ExtensionInterface) obj).createChild(parent);
				}
			}
		}
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
