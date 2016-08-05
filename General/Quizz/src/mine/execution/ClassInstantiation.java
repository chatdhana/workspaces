package mine.execution;

/**
 * Creation of new instance of Type.
 * 
 * New class instance is explicitly created when evaluation of a class instance
 * creation expression causes a class be instantiated.
 * 
 * New class instance may be created Implicitly by:
 * 
 * 1) Loading of a class or interface which contains String literal.
 * 
 * 2) Boxing conversion.
 * 
 * 3) String concatenation operator.
 * 
 * 
 * Whenever a new class instance is created memory space is allocated for,
 * 
 * 1) all the instance variables of class type
 *  
 * 2) and all the instance variables of each superclass of class type
 *  
 * 3) including all the hidden instance variables of super type.
 * 
 * OutOfMemoryError is thrown if there is not enough space available for allocation.
 * 
 * :::Evaluation of Instance Creation:::
 * 
 * Just before a reference to the newly created object is returned as the result,
 * 
 * 1) Assign the arguments for the constructor to a newly created parameter variables.
 * 
 * 2) If the constructor begins with an explicit constructor call to another constructor in the same class (using this keyword), 
 * 	then evaluate the arguments and process that constructor invocation recursively.
 * 
 * 3) If it doesn't begin with this() call, then this constructor will begin with 
 * 	an invocation of explicit or implicit superclass constructor (using super keyword).
 * 
 * 4) Execute the instance initializers and instance variable initializers for this class 
 *  and assigns the result of instance variable initializer to the corresponding instance variables.
 * 
 * 5) Execute the rest of the body of this constructor.
 * 
 * :::Dynamic Dispatch During Instance Creation:::
 * If methods are invoked that are overridden in subclasses in the object being initialized, then these 
 * overriding methods are used, even before the new object is completely initialized.
 * 
 * 
 */
public class ClassInstantiation {

	public static void main(String[] args) {
		Sub t = new Sub();
		t.printThree();
	}
}


/**
 * Dynamic Dispatch During Instance Creation:
 * 
 * If methods are invoked that are overridden in subclasses in the object being
 * initialized, then these overriding methods are used, even before the new
 * object is completely initialized.
 * 
 * 
 */
class Super {
	Super() {
		printThree(); // Note: Overridden by Subclass.
	}

	void printThree() {
		System.out.println("three");
	}
}
class Sub extends Super {
	int three = (int) Math.PI; // That is, 3

	void printThree() {
		System.out.println(three);
	}
}