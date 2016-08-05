package mine.exception;

import java.io.FileNotFoundException;

public class Overriding {

	void method1() throws Exception {

	}
	void method2() {

	}
	void method3() throws RuntimeException{

	}
}

class OverridingSub extends Overriding {
	@Override
	void method1() throws RuntimeException {

	}

	/**
	 *  Checked Exception: Exception is not compatible with throws clause in Super Class's method2.
	 */
	@Override
	/*void method2() throws FileNotFoundException {
		super.method2();
	}*/
	
	/**
	 * UnChecked Exception : No Compile time checking of Exceptions for UnChecked Exceptions.
	 */
	void method2() throws Error {
		super.method2();
	}
	
	/**
	 * UnChecked Exception : No Compile time checking of Exceptions for UnChecked Exceptions.
	 */
	void method3() throws Error {
		super.method2();
	}
	
	/**
	 *  Checked Exception: Exception is not compatible with throws clause in Super Class's method2.
	 */
	/*void method3() throws Exception {
		super.method2();
	}*/
	
	/**
	 * UnChecked Exception : No Compile time checking of Exceptions for UnChecked Exceptions.
	 */
	void method4() /* throws clause not required to handle UnChecked Exceptions */ {
		throw new ArrayIndexOutOfBoundsException(2);
	}
	
}	