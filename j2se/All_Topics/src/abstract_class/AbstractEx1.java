package abstract_class;


public class AbstractEx1 {

	public static void main(String[] args) {
		// Can not instantiate an abstract class
		// Abs1 abs1Obj= new Abs1();

		Cls clsObj = new Cls();
		clsObj.method1();
	}

}

/*
 * 1)All classes can only be extended. 2)No class can implement an abstract or
 * ordinary class. 3)Visibility modifiers of an abstract methods can be one of
 * public or protected. 4)Data members are constants. 5)Can not instantiate an
 * abstract class. 6)The abstract method can only be defined by an abstract
 * class. 7)The concrete class which extends an abstract class should implement
 * all the methods of an abstract class.
 */

/*
 * An abstract class is a class that is declared abstract—it may or may not
 * include abstract methods. Abstract classes cannot be instantiated, but they
 * can be subclassed.
 */

/*
 * (i) When there is some functionality across various classes. That is in
 * situations where the programmers see the code as the base.
 */
abstract class Abs1 {
	int i = 10;

	// default access specifier is public
	abstract void method1();
	/*It can contain signature as well as implementations*/
	void method2() {
	}

	abstract void method3();
}

abstract class Abs4 {
	int i = 10;

	// default access specifier is public
	// void method1();

	void method2() {
	}

	// abstract void method3();
}

abstract class Abs2 extends Abs1 {

}

class Cls extends Abs1 {

	void method1() {
		i = 19;
		System.out.println("value of i: " + i);
	}

	void method3() {

	}

}
