package mine.exception;

public class ExceptionOverview {
	public static void main(String[] args) {
	}
}


/**
 *	Subclass of java.lang.Throwable can't be declared Generic.
 */
//class MyException<T> extends Throwable {}


class MyException extends Throwable {

	/**
	 * Throwable and its subclasses are Serializable.
	 */
	private static final long serialVersionUID = 1L;
	
}

/**
 * The unchecked exception classes are the runtime exception classes and the
 * error classes.
 * 
 */
class UnCheckedExceptionClasses {

	class MyErrorClass extends Error {
		/*
		 * Error is the superclass of all the exceptions from which ordinary
		 * programs are not ordinarily expected to recover.
		 */
		
		class MyAnonymosException extends VirtualMachineError {
			/*
			 * An asynchronous exception is an exception that can potentially
			 * occur at any point in the execution of a program as a result of
			 * stopping thread or an internal error/resource limitation
			 * (subclass of VirtualMachineError).
			 */
		}
	}

	class MyRuntimeExceptionClass extends RuntimeException {

	}
}

/**
 * The checked exception classes are all subclasses of Throwable other than
 * RuntimeException and its subclasses and Error and its subclasses.
 * 
 */
class CheckedExceptionClasses {
	class MyExceptionClass extends Exception {
		/*
		 	Exception is the superclass of all the exceptions from which ordinary programs
			may wish to recover.
		 */
	}
}

