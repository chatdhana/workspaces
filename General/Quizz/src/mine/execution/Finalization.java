package mine.execution;

/**
 * The process of freeing up / releasing the resources held by the object before
 * the Garbage Collector reclaims the storage allocated for the object.
 * 
 * The definition of finalize that can be invoked for an object is called the
 * finalizer of that object.
 * 
 * Before the storage for an object is reclaimed by the garbage collector, the
 * Java virtual machine will invoke the finalizer of that object in any order
 * and may be concurrently.
 * 
 * Note that many finalizer threads may be active (this is sometimes needed on
 * large shared memory multiprocessors).
 * 
 * Unlike constructors, finalizers do not automatically invoke the finalizer for
 * the superclass; such an invocation must be coded explicitly.
 * 
 * If an uncaught exception is thrown during the finalization, the exception is
 * ignored and finalization of that object terminates.
 * 
 * A finalizer may be invoked explicitly, just like any other method.
 * 
 * The package java.lang.ref describes weak references, which interact with
 * garbage collection and finalization.
 * 
 */
public class Finalization {
	// java.lang.ref
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
}

/**
 * Every object can be characterized by two attributes:
 * 
 * 1) reachable, finalizer-reachable, or unreachable.
 * 
 * 2) unfinalized, finalizable, or finalized.
 * 
 * A reachable object is any object that can be accessed from any live thread.
 * 
 * A finalizer-reachable object can be reached from some finalizable object
 * through some chain of references, but not from any live thread.
 * 
 * An unreachable object cannot be reached by either means.
 * 
 * An unfinalized object has never had its finalizer automatically invoked.
 * 
 * A finalizable object has never had its finalizer automatically invoked, but
 * the Java virtual machine may eventually automatically invoke its finalizer.
 * 
 * A finalized object has had its finalizer automatically invoked.
 * 
 * An object o is not finalizable until its constructor has invoked the
 * constructor for Object on o and that invocation has completed successfully.
 * 
 * 
 * 
 */
class ImplementingFinalization {
	
}