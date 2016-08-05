package mine.arrays;

import java.io.Serializable;

public class ArraySpec {

	static int CONSTANT_I=0;
	public static void main(String[] args) {
		new ArraySpec().caller();
	}
	
	void caller(){
		arrayDeclaration();
		arrayCreation();
		arrayInitialization();
		arrayCloning();
	}
	
	
	@SuppressWarnings("unused")
	<T> void arrayDeclaration(){
		int /*<SPACE>*/ [] primitive1DArr;
		Number refrence1DArr /* bracket pair allowed to follow variable name */ []; // Legal but not recommended.
		Number[] refrence2DArr[], refrence3DArr[][]; //mixed notation of dimension dec allowed but not recommended.
		T[] nonReifiableArr; // Non reifiable type array declaration allowed.
		Object objectTypeArr; // Object is a direct super class of an array type.
		Serializable serializableTypeArr;
		Cloneable cloneableTypeArr; // Every array type implements Serializable and Cloneable interfaces.
	}
	
	<T extends Number> void arrayCreation() {
		short size=0;
		int[] primitive1DArr;
		Number[][] refrence2DArr;
		T[] nonReifiableArr;
		// primitive1DArr = new int[-1]; // Runtime Exception; NegativeArraySizeException
		primitive1DArr = new int[size];
		refrence2DArr = new Integer[3][/*optional*/]; // nested array size dec is optional;
		refrence2DArr = new Integer[3][2];
		refrence2DArr[0] = new Integer[3];
		refrence2DArr[1] = new Integer[4];
		// refrence2DArr[2] = new Number[5]; // ArrayStoreException
		// nonReifiableArr = new T[]; // Compile-time error; Cannot create a generic array
		nonReifiableArr = (T[]) new Integer[10];
		Object objectTypeArr = nonReifiableArr;
	}

	<T> void arrayInitialization() {
		int i=0;
		int[] primitive1DArr = {};
		int[][] primitive2DArr = {{1,2},null,null}; // A trailing comma may appear after the last expression in an array initializer and is ignored.
		System.out.println("Order of execution of Array initializer..");
		int[][][] primitive3DArr = {{{returnInt(0),returnInt(1),returnInt(2),returnInt(3)}},{{returnInt(4)},{1,2,returnInt(5)}}};
		System.out.println("lResult: left to right in the textual order they occur in the source code.");
		Number[][] refrence2DArr = {{},{},{new Integer(3)}}; 
		// T[] nonReifiableArr = {}; // Compile-time error; 
		
		System.out.println(primitive3DArr.length + "|" + primitive3DArr[0].length + "|" + primitive3DArr.getClass());
		
		// Annonymous array initializer
		receivingAnnonymosArray(new Integer[/*DON'T MENTION SIZE*/][]{{11,12},{21,22},{31,32}});
	}
	
	int returnInt(int i){
		System.out.println(i);
		return i;
	}
	
	void receivingAnnonymosArray(Number[][] _2DArr){
		
	}

	/**
	 * <b>A clone of a multidimensional array is shallow</b>, which is to say that it
	 * creates only a single new array. <b>Subarrays are shared</b>.
	 * 
	 * All the members inherited from class Object; the only method of Object that is not
	 * inherited is its clone method.
	 */
	void arrayCloning(){
		int[][] primitive2DArr = {{1,2},null,null};
		int[][] primitive2DArrCloned = primitive2DArr.clone();
		System.out.println("Cloning...: Subarrays are shared");
		System.out.println(primitive2DArr.toString()+"|"+primitive2DArr[0].toString());
		System.out.println(primitive2DArrCloned.toString()+"|"+primitive2DArrCloned[0].toString());
	}

}