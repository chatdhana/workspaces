package nested_classes;
// Inner class example

/*
 *	Inner classes can be used to implement helper classes.
 */

/*Types:
 * 	There are two additional types of inner classes. 
 *		1) You can declare an inner class within the body of a method.
 *		Such a class is known as a local inner class.
 *		2) You can also declare an inner class within the body of a method without naming it.
 *		These classes are known as anonymous inner classes. 
 */

/*Modifiers:
 * 	You can use the same modifiers for inner classes that you use for 
 * 	other members of the outer class.
 *  For example, you can use the access specifiers — private, public, 
 *  and protected — to restrict access to inner classes, 
 *  just as you do to other class members. 
 */

// General Inner class example.
public class InnerClass {
	public static void main(String[] args) {
		Outer.main1();
	}
	
}


// Outer class
class Outer {

	public static void main1() {
		// Instantiating Inner class
		//Inner innerObj=this.new Inner();
		Inner innerObj = new Outer().new Inner();
		// Calling Inner class's method
		innerObj.display();
	}

	private void displayOuter() {
		System.out.println("I'm From Outer Class.");
	}

	// Inner class
	class Inner {
		void display() {
			System.out.println("I'm From Inner Class.");
			// Calling Outer class's method
			displayOuter();
		}
	}

}
