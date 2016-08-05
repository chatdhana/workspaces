package mine.polymorphism;

import java.util.ArrayList;
import java.util.List;

public abstract class MethodOverriding {
	public static void main(String[] args) throws Exception {
		MethodOverridingSuper superVarType = new MethodOverridingSub();
		MethodOverridingSub subVarType = new MethodOverridingSub();
		
		/* Overriding definition in subclass will always be called, 
		   even if the reference to an object is taken from a variable whose type is superclass */
		superVarType.instanceMeth();
		
		System.out.println("------------------------------------------------------------");
		/* A qualified name or a cast to a superclass type is not effective in attempting to
		access an overridden method */
		((MethodOverridingSuper)subVarType).instanceMeth();
		
		System.out.println("------------------------------------------------------------");
		
		superVarType.instanceMethNotOverridden();
		
		System.out.println("------------------------------------------------------------");
		
		subVarType.instanceMethNotOverridden();
		
		System.out.println("------------------------------------------------------------");
		
	}
}

abstract class MethodOverridingSuper {

	public MethodOverridingSuper() throws ClassNotFoundException {
		super();
	}
	
	abstract void abstractMeth();

	void instanceMeth() {
		System.out.println("instanceMeth() @ Super");
	}

	strictfp List instanceMeth(List<String> list) throws Exception {
		System.out.println("instanceMeth(List<String> list) @ Super");
		return list;
	}
	void instanceMethNotOverridden() throws Exception {
		System.out.println("instanceMethNotOverridden() @ Super");
		instanceMeth();
		instanceMeth(new ArrayList<String>());
	}

	static void staticMeth() {

	}
}

class MethodOverridingSub extends MethodOverridingSuper {

	public MethodOverridingSub() throws Exception {
		super();
	}

	@Override
	void abstractMeth() {
		System.out.println("abstractMeth() @ Child");
	}

	/** This static method cannot hide the instance method */
	/*
	 * static void instanceMeth() {
	 * 
	 * }
	 */

	/** This instance method cannot override the static method */
	/*
	 * void staticMeth() {
	 * 
	 * }
	 */

	@Override
	void instanceMeth() {
		System.out.println("instanceMeth() @ Child");
	}

	/**
	 * signature of the overriding method to differ from the overridden one, if
	 * a parameter type is Generic Type
	 * @return 
	 */
	@Override
	ArrayList instanceMeth(List list) throws ClassNotFoundException {
		// some operation
		System.out.println("instanceMeth(List list) @ Child");
		//super.instanceMeth(list); // Overridden method can be accessed by using
									// a method invocation expression contains
									// the keyword super.
//		throw new InvocationTargetException(null);
		return null;
	}

}