package mine.arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayVsGenerics {

	public static void main(String[] args) {
		covariantArray();
		coinvariantGenerics();

		/*
		 * List<String>[] listArray1 = new ArrayList[1]; List<? extends String>[] listArray2 = new ArrayList<? extends String>[1];
		 * 
		 * listArray[0] = new ArrayList<String>(); listArray[0].add("One"); listArray[0].add("Two");
		 * 
		 * System.out.println(Arrays.toString(listArray));
		 */
	}

	static void covariantArray() {
		Super[] superArr = new Sub[10]; // Covariant type support during array declaration (Assignment of array of sub type into array of super type declaration)
		Super[] superArr2 = new Super[10];
		superArr[0] = new Sub();
		superArr2[0] = new Sub(); // Covariant type support during component assignment.
		
		try {
			superArr[0] = new Super(); // ArrayStoreException : Assignment of Super type component into Sub type array is not allowed at runtime.
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		String[] strArray = new String[10];
		Object[] objArray = strArray;
		
		try {
			objArray[0] = 10; // throws java.lang.ArrayStoreException
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * ArrayStoreException is thrown when the type of the value being assigned is not assignment-compatible with component
		 * type declared.
		 */
	}

	static void coinvariantGenerics() {

		SuperGen<String> superGen1 = new SuperGen<String>();
		SuperGen<String> superGen2 = new SubGen<String>();
		
		SuperGen<Super> superGen3 = new SuperGen<Super>();
		
		/* Generics does not support covariant type. */
		// SuperGen<Super> superGen4 = new SuperGen<Sub>(); // Compile time error
		// ArrayList<Super> list = new ArrayList<Sub>(); // Compile time error
		
		/* Generics does not support covariant type except wildcards */
		SuperGen<? extends Super> superGen5 = new SuperGen<Super>();
		SuperGen<? extends Super> superGen6 = new SuperGen<Sub>();
	}

	static void mixingOfCovariantAndCoinvariant() {
		// Assignment of raw array type reference into generic array type variable. (Allowed)
		ArrayList<String>[] listArray1 = new ArrayList[1]; // only covariant type
		
		// Assignment of generic array type reference into generic array type variable. (Not allowed)
		// ArrayList<String>[] listArray1 = new ArrayList<String>[1]; // both covariant type and coinvariant type
	}

}

class Super {

}

class Sub extends Super {

}


class SuperGen<T> {
	
}

class SubGen<T> extends SuperGen<T> {
	
}