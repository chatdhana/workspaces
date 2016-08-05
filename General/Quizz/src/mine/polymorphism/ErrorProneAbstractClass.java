package mine.polymorphism;

public abstract class ErrorProneAbstractClass implements ErrorProneIface {
	// public abstract int method1(int x); // Compile time error

	public abstract void method1(int x);
}

interface ErrorProneIface {
	void method1(int x);
}

class ErrorProneSubClass extends ErrorProneAbstractClass {
	@Override
	public void method1(int x) {
		return;
	}
}

class ErrorProneDeepSubClass extends ErrorProneSubClass {
	@Override
	public void method1(int x) {
		return;
	}
}



interface IFace1 {
	int method1();
	Integer method2();
	int method3();
}

interface IFace2 {
	int method1();
	Double method2();
	double method3();
}

/** A class cannot have multiple methods with the same signature and different return types;
 * it is impossible for a single class to implement both interface IFace1 and interface IFace2 */
/*class ConcreteClass implements IFace1, IFace2 {
	@Override
	public int method1() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Integer method2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int method3() {
		// TODO Auto-generated method stub
		return 0;
	}
}
*/


/** Illegal Multiple Inheritance of an Interface */
/*interface I<T> {}
class B implements I<Number> {}
class C extends B implements I<Integer> {} // interface I cannot be implemented more than once with different arguments: I<Integer> and I<String>
*/