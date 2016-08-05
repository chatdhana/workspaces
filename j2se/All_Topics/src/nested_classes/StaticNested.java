package nested_classes;
// Static Nested class example
public class StaticNested {

	public static void main(String[] args) {
		OuterClass.main1();
	}
}

/*
 •	A class defined within another class is called a nested class.
 •	Like other members of a class, a nested class can be declared static or not. 
 i)	A nonstatic nested class is called an inner class. An instance of an
 inner class can exist only within an instance of its enclosing class
 and has access to its enclosing class's members even if they are 
 declared private. 
 ii)	Nested classes that are declared static are simply called static nested classes.

 * 
 * 
 * 
 */
//Outer class
class OuterClass {

	public static void main1() {

		// Calling Inner class's method
		Nested nestedObj = new OuterClass.Nested();
		nestedObj.display();
	}

	// Static method
	private static void displayOuter1() {
		System.out.println("I'm From Outer Class.");
	}
	// Instance method
	private void displayOuter2() {
		System.out.println("I'm From Outer Class.");
	}

	// Static nested class
	static class Nested {
		void display() {
			System.out.println("I'm From Inner Class.");
			// Calling Outer class's ststic method
			OuterClass.displayOuter1();
			// Calling Outer class's instance method
			//OuterClass.displayOuter2(); /* This will throw an error*/
			/*Note: Like static class methods, a static nested class cannot refer directly
			to instance variables or methods defined in its enclosing class — it can 
			use them only through an object reference. */
		}
	}

}
