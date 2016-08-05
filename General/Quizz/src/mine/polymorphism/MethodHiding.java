package mine.polymorphism;

import java.util.List;

/**
 * Invocation of static method uses the type of variable, decided at compile-time;
 * whereas invocation of instance method uses the class/instance of variable, decided at
 * run-time.
 * 
 */
public class MethodHiding {

	public static void main(String[] args) {
		MethodHidingSuper superType = new MethodHidingSub();
		MethodHidingSub subType = new MethodHidingSub();

		superType.staticMeth(); // calls superclass's meth
		subType.staticMeth(); // calls subclass's meth
		((MethodHidingSuper) subType).staticMeth(); // calls superclass's meth
		subType.instanceMeth();
	}
}

class MethodHidingSuper {

	public static void staticMeth() {
		System.out.println("staticMeth() @ Super");
	}

	public static void staticMeth(List<String> list) {
		System.out.println("staticMeth(List<String> list) @ Super");
	}
}

class MethodHidingSub extends MethodHidingSuper {
	/** Cannot reduce the visibility of the inherited method */
	/*
	 * static void staticMeth() {
	 * 
	 * }
	 */

	public static void staticMeth() {
		System.out.println("staticMeth() @ Child");
	}

	public void instanceMeth() {
		System.out.println("instanceMeth() @ Child");
		super.staticMeth();
	}
}