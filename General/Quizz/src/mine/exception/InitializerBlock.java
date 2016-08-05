package mine.exception;

import java.io.FileNotFoundException;

public class InitializerBlock {

	static {
		// throw new Exception();
	}

	{
		// throw new ClassNotFoundException();
	}
	
	static {
		/*
		 * It is a compile-time error if a class variable initializer or static
		 * initializer of a named class or interface can throw a
		 * checked/unchecked exception class.
		 */
		
		retStr1();
		// retStr2();	// Compile-time error: Unhandled exception type FileNotFoundException
		retStr3(); // Can throw UnChecked Exception
	}
	
	{
	
		/*
		 * It is a compile-time error if an instance variable initializer or
		 * instance initializer of a named class can throw a checked exception
		 * class UNLESS that exception class or one of its superclasses is
		 * explicitly declared in the throws clause of each constructor of its
		 * class
		 */

		retStr1();
		retStr2(); // explicitly declared constructor has throws clause with Exception
		retStr3();
	}
	
	public InitializerBlock()  throws Exception {
		// TODO Auto-generated constructor stub
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

class InitializerBlockAtAnonymousClass {
	/*
	 * no compile-time error is due if an instance variable initializer or
	 * instance initializer of an anonymous class can throw an exception class
	 */
	void method() {
		new Thread() {
			
			{
				//retStr1();
				retStr2();
			}
			
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
