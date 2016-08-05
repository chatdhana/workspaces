package interface_example;

// Interface example

/* An interface is a reference type, similar to a class that can contain only 
 * constants, method signatures, and nested types. There are no method bodies. 
 * Interfaces cannot be instantiated—they can only be implemented by classes or
 * extended by other interfaces. 
 */
/*
 * It is well suited for the classes which vary in functionality but with 
 * the same method signatures.
 */

public interface Inf1 {
	/*
	 * 1)Contains only signature of the methods 2)Only public & abstract are
	 * permitted access specifier & modifier
	 * 
	 */
	void method1(); /* By default public and abstract */

	abstract int method2();

	// private abstract int method3(); //Wrong
	public abstract int method4();
	// static int method5(); //Wrong
}


