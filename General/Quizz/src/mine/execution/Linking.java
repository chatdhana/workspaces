package mine.execution;

/**
 * Linking is the process of taking a binary form of a class or interface type
 * and combining it into the run-time state of the Java virtual machine, so that
 * it can be executed. A class or interface type is always loaded before it is
 * linked.
 * 
 * Three different activities are involved in linking: verification,
 * preparation, and resolution of symbolic references.
 * 
 */
public class Linking /* of Classes and Interfaces */{

	/**
	 * Verification ensures that the binary representation of a class or
	 * interface is structurally correct.
	 * 
	 * And checks if the program obeys the semantic requirements of JVM and JPL.
	 * 
	 * For example, it checks that every instruction has a valid operation code.
	 * 
	 */
	class Verification /* of the Binary Representation */{

		/*
		 * Error occurs during verification, an instance of the subclass of
		 * class LinkageError will be thrown at the point in the program that
		 * caused the class to be verified:
		 * 
		 * 
		 * VerifyError: The binary definition for a class or interface failed to
		 * pass a set of required checks to verify that it obeys the semantics
		 * of the Java virtual machine language and that it cannot violate the
		 * integrity of the Java virtual machine.
		 */
	}

	/**
	 * Preparation involves creating the static fields (class variables and
	 * constants) for a class or interface and initializing such fields to the
	 * default values. This does not require the execution of any source code.
	 * 
	 * Explicit initializers for static fields are executed as part of
	 * initialization, not preparation.
	 * 
	 * 
	 * Implementations of the Java virtual machine may precompute additional
	 * data structures at preparation time in order to make later operations on
	 * a class or interface more efficient. One particularly useful data
	 * structure is a "method table".
	 */
	class Preparation /* of a Class or Interface Type */{

	}

	/**
	 * The binary representation of a class or interface references other
	 * classes and interfaces and their fields, methods, and constructors
	 * symbolically, using the binary names.
	 * 
	 * For fields and methods, these symbolic references include the name of the
	 * class or interface type of which the field or method is a member, as well
	 * as the name of the field or method itself, together with appropriate type
	 * information.
	 * 
	 * Before a symbolic reference can be used it must undergo resolution,
	 * wherein a symbolic reference is checked to be correct and, typically,
	 * replaced with a direct reference that can be more efficiently processed
	 * if the reference is used repeatedly.
	 * 
	 */
	class Resolution /* of Symbolic References */{
		/*
		 * Error occurs during resolution, an instance of or subclass of class
		 * IncompatibleClassChangeError (subclass of LinkageError) will be
		 * thrown. This error may be thrown at any point in the program that
		 * uses a symbolic reference to the type, directly or indirectly:
		 * 
		 * 1) IllegalAccessError: A symbolic reference has been encountered that
		 * specifies a use or assignment of a field, invocation of method, or
		 * instantiation of class, to which the code containing an expression
		 * doesn't have access because a field or method was declared private,
		 * protected or default access (not public), or the class was not
		 * declared public.
		 * 
		 * This can occur, for example, if a field that is originally declared
		 * public is changed to be private after another class that refers to
		 * the field has been compiled.
		 * 
		 * 2) InstantiationError: A symbolic reference has been encountered that
		 * is used in class instance creation expression, but an instance can
		 * not be created because the reference turns out to refer to an
		 * interface or an abstract class.
		 * 
		 * This can occur, for example, if a class is originally not an abstract
		 * is changed to be abstract after another class which has reference to
		 * this class has been compiled to.
		 * 
		 * 3) NoSuchFieldError: A symbolic reference has been encountered that
		 * refers to a field of a specific class, but the class doesn't contain
		 * a field of that name.
		 * 
		 * This can occur, for example, if a field declaration was deleted from a
		 * class after some class that refers to the field was compiled.
		 * 
		 * 4) NoSuchMethodError: A symbolic reference has been encountered that
		 * refers to the method of a class, but the class doesn't have a method
		 * of that signature.
		 * 
		 * This can occur, for example, if a method declaration was deleted from
		 * a class after another class that refers to the method was compiled.
		 * 
		 * Additional Errors:
		 * 
		 * *) UnsatisfiedLinkError (<: LinkageError): It may be thrown if a
		 * class declares a native method for which no implementation can be
		 * found.
		 * 
		 * Cause: kind of resolution strategy is being used by an
		 * implementation of the Java virtual machine.
		 */
	}
}
