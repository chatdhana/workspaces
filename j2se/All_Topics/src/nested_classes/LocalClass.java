package nested_classes;

// Local class example
/*
 * Local inner class an inner class within the body of a method.
 */
// Outer Class
public class LocalClass {
	public static void main(String[] args) {
		LocalClass o=new LocalClass();
		Interface i = o.localMethod();
		i.disp();
	}

	// Method of Outer class
	Interface localMethod() {

		// Local class
		class c implements Interface {
			public void disp() {
				System.out.println("from local class");

			}

		}
		return new c();

	}
}

interface Interface {
	void disp();
}
