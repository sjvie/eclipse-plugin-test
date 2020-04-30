package de.phvu.extension_test;

import de.sjvie.extension_point_test.ExtensionInterface;

public class FirstExtensionTest implements ExtensionInterface{

	@Override
	public String extensionMethod() {
		return "first Method";
	}

	@Override
	public String secondMethod() {
		return "second Method";
	}
	

}
