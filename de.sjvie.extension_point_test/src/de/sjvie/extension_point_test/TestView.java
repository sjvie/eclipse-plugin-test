package de.sjvie.extension_point_test;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.part.ViewPart;

public class TestView extends ViewPart {

	@Override
	public void createPartControl(Composite parent) {
		Label title = new Label(parent, SWT.LEFT);
		title.setText("Log");
//		Button btn = new Button(parent, SWT.LEFT);
//		btn.setText("HELO");
		
//		RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
//		parent.setLayout(rowLayout);

		ExtensionInterface[] extensionInterfaces = getExtensionInterfaces();

		for(ExtensionInterface extensionInterface : extensionInterfaces) {
			Button button = new Button(parent, SWT.PUSH);
			String name = extensionInterface.getName();
			if(name == null){
				name = "NO_NAME";
			}
			button.setText(name);
			button.addListener(SWT.Selection, event -> {
				System.out.println("MADHUW");
				extensionInterface.createChild(parent);
			});
		}
		
	}

	private ExtensionInterface[] getExtensionInterfaces() {

		List<ExtensionInterface> extensionInterfaces = new ArrayList<ExtensionInterface>();
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
					System.out.println("Added extinf");
					extensionInterfaces.add((ExtensionInterface) obj);
				}
			}
		}
		return extensionInterfaces.toArray(new ExtensionInterface[extensionInterfaces.size()]);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
