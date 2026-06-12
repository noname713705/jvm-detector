package org.jhe.jvm.detector;

import java.util.Enumeration;
import java.util.Properties;


public class App {
	public static void main(String[] args) {
		new App().doMain(args);
	}

	public void doMain(String[] args) {
		if (args.length > 0) {
			if("*".equals(args[0])) {
				displayAllProperties();
			} else {
				displayProperties(args);
			}
		}
		String[] defaultProps = { "java.vendor", "java.version", "os.arch", "java.vendor.url", "java.compiler",
				"java.vm.name", "java.runtime.version" };
		displayProperties(defaultProps);
	}

	public void displayProperty(String name) {
		System.out.println(getProperty(name));
	}

	public void displayAllProperties() {
		Properties properties = System.getProperties();
		Enumeration keys = properties.propertyNames();
		while(keys.hasMoreElements()) {
			String key = (String)keys.nextElement();
			System.out.println(key+"="+properties.getProperty(key));
		}
	}
	public void displayProperties(String[] names) {
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			String property = getProperty(name);
			if (property.indexOf("Oracle") >= 0) {
				property += " <--- ##### BAM !";
			}
			if (property.indexOf("IBM Corp") >= 0) {
				property += " <--- ##### Warning !";
			}
			if (property.indexOf("OpenLogic") >= 0) {
				property += " <--- ##### Warning !";
			}
			System.out.println(property);
		}
	}

	public String getProperty(String name) {
		String property = System.getProperty(name);
		if (property == null) {
			property = "";
		}
		return name + "=" + property.toString();
	}
}
