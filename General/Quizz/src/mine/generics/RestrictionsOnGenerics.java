package mine.generics;

/**
 * Restrictions on java generics:
 * 
 * Cannot Instantiate Generic Types with Primitive Types.
 * 
 * Cannot Create Instances of Type Parameters.
 * 
 * Cannot Declare Static Fields Whose Types are Type Parameters.
 * 
 * Cannot Use Casts or instanceof With Parameterized Types.
 * 
 * Cannot Create Arrays of Parameterized Types.
 * 
 * Cannot Create, Catch, or Throw Objects of Parameterized Types.
 * 
 * Cannot Overload a Method Where the Formal Parameter Types of Each Overload Erase to the Same Raw Type.
 * 
 */
public class RestrictionsOnGenerics<T> {

	public static void main(String[] args) {
		RestrictionsOnGenerics.primitive();
		RestrictionsOnGenerics.instantiation(null);
		RestrictionsOnGenerics.instanceOfOrCast(null);
		RestrictionsOnGenerics.arraysOfParameterizedTypes();
		System.out.println("Done!");
	}

	/**
	 * Cannot Instantiate Generic Types with Primitive Types.
	 * 
	 * i.e. Cannot subsitute a primitive type for the type parameter
	 */
	static void primitive() {
		// GenericClass<int> genType = new GenericClass<>(); // compile-time error
	}

	/**
	 * Cannot Create Instances of Type Parameters.
	 */
	static <M> void instantiation(M param) {
		M localmemDecl;
		// M localMemInst = new M(); // compile-time error

		// But can instantiate it using reflection.
		try {
			if (param != null)
				localmemDecl = (M) param.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cannot Declare Static Fields Whose Types are Type Parameters.
	 * 
	 * i.e. static fields of type parameters are not allowed.
	 */
	// static T staticField;

	/**
	 * Cannot Use Casts or instanceof With Parameterized Types.
	 * 
	 * i.e. cannot cast to a parameterized type unless it is parameterized by unbounded wildcards.
	 * 
	 * i.e. compiler erases all type parameters in generic code, you cannot verify which parameterized type for a generic type is
	 * being used at runtime.
	 */
	static void instanceOfOrCast(Object obj) {

		// Casting

		GenericSuperClass<String> genType01 = new GenericClass<>();
		// GenericClass<Object> genType02 = (GenericClass<Object>) genType01; // Compile-time error

		GenericSuperClass<String> genType1 = new GenericClass<>();
		GenericClass<String> genType2 = (GenericClass<String>) genType1; // Ok

		// instanceof

		// Compile-time error
		/*
		 * if(obj instanceof T) {
		 * 
		 * }
		 * 
		 * if(obj instanceof GenericClass<String>) {
		 * 
		 * }
		 */

		if (obj instanceof GenericClass<?>) { // Ok

		}
	}

	/**
	 * Cannot Create Arrays of Parameterized Types.
	 */
	static void arraysOfParameterizedTypes() {
		GenericClass<String>[] genTypeArrayDecl; // Ok
		GenericClass<String>[] genTypeArrayInst01 = new GenericClass[10]; // Ok : Raw type assignment
		// GenericClass<String>[] genTypeArrayInst02 = new GenericClass<String>[10]; // Compile time error: Cannot create a
		// generic array of GenericClass<String>
		// GenericClass<String>[] genTypeArrayInst03 = new GenericClass<>[10]; // Compile-time error

		/*
		 * Why this restriction? Array performs Runtime-Data-Compliance-Checking on every insertion of components and throws
		 * ArrayStoreException if it fails.
		 * 
		 * But Generics doesn't perform this kind of validation at runtime, as it is meant for compile time checking.
		 */

		/* Array: performs compile-time check (with covariant support) and also runtime check */
		Object[] strArr = new String[10];
		strArr[0] = "string";
		// strArr[1] = 10; // Throws ArrayStorException

		// *Generics: performs only compile or static type checking by using the type parameters. Type parameters will not be
		// available at runtime.*/

		/*
		 * Combining arrays and generics: GenericClass<String>[] genTypeArray = new GenericClass<String>[10]; // Assume this
		 * construct is allowed. genTypeArray[0] = new GenericClass<String>(); // Ok genTypeArray[0] = new
		 * GenericClass<Integer>(); // Not ok: An ArrayStoreException exception should be thrown but the runtime can't detect it,
		 * as type parameters are erased.
		 */
	}

	/**
	 * Cannot Create, Catch, or Throw Objects of Parameterized Types.
	 * 
	 * *) Generic class can't subclass Throwable (directly or indirectly).
	 * 
	 * *) A method cannot catch an instance of a type parameter.
	 * 
	 * *) Can't use parameterized types in throw clause.
	 * 
	 * *) but can use type parameter in throws clause.
	 */
	static <E extends Throwable> void exception() throws E /* Ok */{
		/*
		 * class Generic<TV> extends Throwable { // The generic class Generic<TV> may not subclass java.lang.Throwable
		 * 
		 * }
		 */

		/*
		 * try {
		 * 
		 * } catch(E ex) { // Cannot use the type parameter E in a catch block
		 * 
		 * }
		 */
	}

	/**
	 * Cannot Overload a Method Where the Formal Parameter Types of Each Overload Erase to the Same Raw Type.
	 */
	static void overloading() {
		class MyClass {
			void overloadedMeth(GenericClass<String> param) {

			}
			/*void overloadedMeth(GenericClass<Integer> param) {
				// Method overloadedMeth(GenericClass<Integer>) has the same erasure overloadedMeth(GenericClass<T>) as another
				// method in type MyClass.
			}*/
		}
	}

}

class GenericSuperClass<T> {

}

class GenericClass<T> extends GenericSuperClass<T> {

}

class MyException extends Exception {

}

/**
 * Generic class can't subclass Throwable (directly or indirectly)
 */
/*
 * class MyExceptionSub<T> extends MyException {
 * 
 * }
 */