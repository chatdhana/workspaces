package nested_classes;

// Anonymous inner class

/* Anonymous inner class is an inner class within the body of a method 
 * without naming it. 
 * 
 * Anonymous inner classes are declared and instantiated at the same time, using the new keyword with the name of the existing class or interface.
 */public class AnonymousClass {
	public static void main(String[] args) {
		new AnonymousClass().localMethod();
	}
	

	void localMethod() {
		new InnerClass() {
			void print() {
				System.out.println("From ananymous inner class.");
			}
		}.print();
	}
}
