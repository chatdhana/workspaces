package mine.exception;

/**
 * <pre>The uncaught exception is handled according to the following rules:
 * 
 * 1) If the current thread has an uncaught exception handler set, then that
 * handler is executed.
 * 
 * 2) Otherwise, the method uncaughtException is invoked for the ThreadGroup that
 * is the parent of the current thread. If the ThreadGroup and its parent
 * ThreadGroups do not override uncaughtException, then the default handler's
 * uncaughtException method is invoked.
 * </pre>
 */
public class UncaughtException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getUncaughtExceptionHandler()
				.toString());
		new UncaughtException().createThread();
		new UncaughtException().createThread();
		new UncaughtException().createThread();
	}
	
	void createThread() {
		new Thread() {
			public void run() {
				int i=0;
				while(i++ <100) {
					System.out.println((8 * (Integer.parseInt(Thread.currentThread().getName().split("-")[1])+1)) +" Thread "+Thread.currentThread().getName()+" Running...");
					if(i == (8 * (Integer.parseInt(Thread.currentThread().getName().split("-")[1])+1))){
//						i = i/0;
						System.exit(0);
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}.start();
	}

}
