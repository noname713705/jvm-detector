package org.jhe.jvm.detector;
import junit.framework.TestCase;

public class TemurinJdk8Test extends TestCase {
	private App app;

	protected void setUp() {
		app=new App();
	}

	public void testJdk8() {
		System.setProperty("java.vendor", "Temurin");
		System.setProperty("java.vm.vendor", "Temurin");
		System.setProperty("java.vendor.url", "https://adoptium.net/");
		System.setProperty("java.vm.name", "OpenJDK 64-Bit Server VM");
		
		System.out.println("-- JDK8 -----------");
		app.doMain(new String[0]);
	}
	
	public void testFunky() {
		System.setProperty("java.vendor", "Oracle");
		System.setProperty("java.vm.vendor", "Oracle");
		System.setProperty("java.vendor.url", "https://something/");
		System.setProperty("java.vm.name", "My JVM");
		
		System.out.println("-- ORACLE ---------");
		app.doMain(new String[0]);
	}
	public void testIbm() {
		System.setProperty("java.vendor", "IBM Corporation");
		System.setProperty("java.version", "1.8.0_422");
		System.setProperty("java.vm.vendor", "java.vm.vendor");
		System.setProperty("java.vendor.url", "https://www.ibm.com/semeru-runtimes");
		System.setProperty("java.vm.name", "Eclipse OpenJ9 VM");
		System.setProperty("java.compiler", "j9jit29");
		System.setProperty("java.runtime.version", "1.8.0_422-b05");
		
		System.out.println("-- IBM ----------");
		app.doMain(new String[0]);
	}

}
