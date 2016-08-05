package mine.polymorphism;

public class FinalMethodClass {

	void method1() {

	}

	/* final */static void methodFinal() {
		/*
		 * A method may be declared final, in which case it cannot be hidden or
		 * overridden.
		 */

	}
}

class FinalMethodSubClass extends FinalMethodClass {
	void method1() {

	}

	static void methodFinal() {

	}
}
