package mine.interfaces;

/**
 * If an interface has no direct superinterfaces, then the interface implicitly
 * declares 'public abstract' member methods correspond to 'public' instance
 * methods in Object class, unless the same method is not explicitly declared by
 * the interface.
 */
public interface ImplicitlyDeclaredMethods {

	/*
	 * Following public instance methods of Object class are implicitly declared
	 * in every SUPERMOST interface
	 */
	// boolean equals(Object obj);
	// String toString();
	// int hashCode();
	// Class getClass();
	// void notify();
	// void notifyAll();
	// void wait(long timeout);
	// void wait(long timeout, int nanos);
	// void wait();

	/*
	 * Following public instance methods from Object are overridden
	 * (explicitly/implicitly)
	 */
	// @Override boolean equals(Object obj);
	// @Override String toString();
	// @Override int hashCode();

	/*
	 * It is a compile-time error if the interface explicitly declares such a
	 * method m in the case where m is declared to be final in Object.
	 */

	/*
	 * Following explicit method declarations cause Compile-time error, but can
	 * be declared implicitly; Cannot override the final method from Object
	 * class.
	 */
	// Class getClass();
	// void notify();
	// void notifyAll();
	// void wait(long timeout);
	// void wait(long timeout, int nanos);
	// void wait();

}

interface ImplicitlyDeclaredMethodsSunInterface extends
		ImplicitlyDeclaredMethods {
	@Override
	boolean equals(Object obj);

	@Override
	String toString();

	@Override
	public int hashCode();
	// @Override
	// public int xxx(); // Compile-time error
	
	public int ownAbstractMethod();
}




