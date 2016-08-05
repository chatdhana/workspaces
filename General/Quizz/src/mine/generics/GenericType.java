package mine.generics;

public class GenericType<T> {
	T instanceMember;

	// static T staticMember; // Can't declare a static member of type TypeVariable

	public <M> GenericType() {
		M localVariable1;
		T localVariable2;
	}

	<M, E extends Throwable> void instanceMethod() throws E {
		System.out.println("Instance generic method");
	}

	static <M> void staticMethod(M param) {
		// / T localVariable; // Can't use Type Variable of a class in the static context.
		System.out.println("Static generic method");
	}

	public static void main(String[] args) {
		GenericType<String> genType = new GenericType<>(); // generic type (with type parameter)
		GenericType rawType = new GenericType(); // Raw type (without type parameter)

		GenericType.staticMethod("String"); /// raw type
		GenericType.<String> staticMethod("String"); // generic type
		try {
			genType.instanceMethod(); // raw type
			genType.<String, Exception> instanceMethod(); // generic type
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}

interface GenericInterface<T> {

}
