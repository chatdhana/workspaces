package mine.execution;

/**
 * Initialization of a class consists of executing its static initializers and
 * the initializers for static fields (class variables) declared in the class.
 * 
 * Initialization of an interface consists of executing the initializers for
 * fields (constants) declared in the interface.
 * 
 * Before a class is initialized, its direct superclass must be initialized, but
 * interfaces implemented by the class are not initialized.
 *
 * Similarly, the superinterfaces of an interface are not initialized before the
 * interface is initialized.
 * 
 * Note:: Upon marking the current Class object's initialization status as In-Progress,
 * before initializing superclasses or executing other static initializers, JVM
 * initializes Final class variables and fields of interfaces whose values are
 * compile-time constant expressions.
 * 
 * A class or interface type T will be initialized immediately before the first
 * occurrence of any one of the following:
 * 
 * 1) T is a class and an instance of T is created.
 * 
 * 2) T is a class and a static method declared by T is invoked.
 * 
 * 3) A static field declared by T is assigned.
 * 
 * 4) A static field declared by T is used and the field is not a constant
 * variable.
 * 
 * 5) T is a top level class, and an assert statement lexically nested within T
 * is executed.
 * 
 * NOTE: A reference to a static field causes initialization of only the class or
 * interface that actually declares it, even though it might be referred to
 * through the name of a subclass, a subinterface, or a class that implements an
 * interface.
 * 
 * Invocation of certain reflective methods in class Class and in package
 * java.lang.reflect also causes class or interface initialization.
 * 
 */
public class Initialization /* of Classes and Interfaces */{
	static SubClass subClass;
	public static void main(String[] args) {
		subClass = new SubClass();
		System.out.println(SubInterface.str);
	}
}


/**
 * Kinds of Initializers:
 * 1) Class variable initializer.
 * 2) Field initializer, if type is Interface.
 * 3) Static initializer (block).
 * 4) Instance variable initializer.
 * 5) Instance initializer (block).
 */

/**
 * Order Of Initialization:
 * 1) Final class variables and fields of interfaces whose values are compile-time constant expressions.
 * 2) Class variables and fields of interfaces having explicit variable initializer, and Static initialization blocks (order by: Super to Sub and textual-appearance).
 * 3) Instance variables and blocks.
 * 4) Constructors.
 */

/**
 * Superclasses Are Initialized Before Subclasses.
 * 
 * Only The Class That Declares static Field Is Initialized.
 * 
 * Interface Initialization Does Not Initialize Superinterfaces.
 */
class MostSuperClass {
	static String str = Utility2.retTrimmedString("MostSuperClass");
}
class SuperClass extends MostSuperClass {
	static String str = Utility.retTrimmedString("SuperClass");
}

class SubClass extends SuperClass implements SubInterface {
	static String str = Utility.retTrimmedString("SubClass");
	static final String finalClassVariable = "FinalClassVariable";
}

interface SuperInterface {
	static String str = Utility.retTrimmedString("SuperInterface");
	static final String fieldVariableOfInterface = "FieldVariableOfInterface";
}

interface SubInterface extends SuperInterface {
	static String str = Utility.retTrimmedString("SubInterface");
}

class Utility extends Utility2 {
	static String str = retTrimmedString("Utility");
	static String retTrimmedString(String inStr) {
		System.out.println("inStr:" + inStr);
		return inStr == null ? inStr : inStr.trim();
	}
}

class Utility2 {
	static String str = retTrimmedString("Utility2");
	static String retTrimmedString(String inStr) {
		System.out.println("inStr:" + inStr);
		return inStr == null ? inStr : inStr.trim();
	}
}
