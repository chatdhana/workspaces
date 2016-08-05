package mine.exception;

import java.io.FileNotFoundException;

public class VariableInitializer {
	public static void main(String[] args) throws Exception {
		new VariableInitializer();
	}
	
	private static String staticVariable1 = retStr1();
	private String instanceVariable1 = retStr1();
	
	/*
	 * It is a compile-time error if a class variable initializer or static
	 * initializer of a named class or interface can throw a checked exception class.
	 */
	// private static String staticVariable2 = retStr2(); // Compile-time error: Unhandled exception type FileNotFoundException
	
	/*
	 * It is a compile-time error if an instance variable initializer or
	 * instance initializer of a named class can throw a checked exception
	 * class UNLESS that exception class or one of its superclasses is
	 * explicitly declared in the throws clause of each constructor of its
	 * class
	 */
	private String instanceVariable2 = retStr2();
	
	/* UnChecked Exception: No compile-time checking, instance/static var initializer can throw a unchecked exception class */
	private static String staticVariable3 = retStr3();
	private String instanceVariable3 = retStr3();

	public VariableInitializer() throws Exception {
	}
	
	private static String retStr1() {
		System.out.println("Returning String1.");
		return "StringValue";
	}

	private static String retStr2() throws FileNotFoundException {
		System.out.println("Returning String2.");
		return "StringValue";
	}
	
	private static String retStr3() throws Error {
		System.out.println("Returning String3.");
		return "StringValue";
	}
}

class VarInitializerAtAnonymousClass {
	/*
	 * no compile-time error is due if an instance variable initializer or
	 * instance initializer of an anonymous class can throw an exception class
	 */
	void method() {
		new Thread() {
//			 private String instanceVariable1 = retStr1();
			 private String instanceVariable2 = retStr2();
			
			public void run() {

			}

			private String retStr1() throws FileNotFoundException {
				System.out.println("Returning String1.");
				return "StringValue";
			}
			private String retStr2() throws Error {
				System.out.println("Returning String2.");
				return "StringValue";
			}
		}.start();
	}
}