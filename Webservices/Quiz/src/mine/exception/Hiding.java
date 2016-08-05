package mine.exception;

public class Hiding {
	public Hiding() {
	}

	public Hiding(int x) throws ClassNotFoundException {
	}

	public Hiding(int x, int y) throws ClassNotFoundException {
	}

	public Hiding(int x, int y, int z) throws RuntimeException {
	}

	static void method1() throws Exception {
	}

	static int method1(int x) throws ClassNotFoundException {
		return 0;
	}

	static int method1(int x, int y) {
		return 0;
	}
}

class HidingSub extends Hiding {
	
	HidingSub() {
	}

	HidingSub(int x) throws Exception {
	}

	HidingSub(int x, int y) throws Exception {
		super(x);
	}
	
	HidingSub(int x, int y, int z) throws ClassNotFoundException {
		super(x);
	}
	
	static void method1() throws ClassNotFoundException {

	}
	
	static int method1(int x) throws ClassNotFoundException {
		return 0;
	}
	
	/**
	 *  Checked Exception: Exception is not compatible with throws clause in Super Class's method.
	 */
	/*static int method1(int x, int y) throws ClassNotFoundException {
		return 0;
	}*/
	
}
