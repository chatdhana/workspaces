package threadpack3;

class threadA extends Thread {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("thread A" + i);
		}
		synchronized (this) {
			notifyAll();
		}
	}
}

public class Threadex {

	public static void main(String ar[]) throws Exception {
		threadA a = new threadA();
		a.start();
		a.join();
		System.out.println("end main");
	}
}
