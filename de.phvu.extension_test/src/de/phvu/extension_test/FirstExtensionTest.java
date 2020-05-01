package de.phvu.extension_test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.sjvie.extension_point_test.ExtensionInterface;

public class FirstExtensionTest implements ExtensionInterface{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void createChild(Composite parent) {
		// TODO Auto-generated method stub
		System.out.println("askldjakljd");
		Label label = new Label(parent, SWT.LEFT);
		label.setText("ALSKDLAK");
	}
}
