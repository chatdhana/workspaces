package mine.interfaces;

/**
 * A method declaration in the body of an interface is:
 * <p> 1) implicitly <b> public abstract</b>.</p>
 * <p> 2) not allowed to have any of: <b>strictfp</b>, <b>native</b>, or <b>synchronized</b></p>
 * <p> 3) not allowed to be <b>static</b> or <b>final</b></p>
 */
public strictfp interface AbstractMethods {
	/* public abstract */void myAbstractMethod1(); // Implicitly 'public static'

	public abstract void myAbstractMethod2(); // Explicilty 'public static'

	// native void myInvalidMethod1();
	// strictfp void myInvalidMethod2();
	// synchronized void myInvalidMethod3();

	// final void myInvalidMethod4();
	// static void myInvalidMethod5();
}
