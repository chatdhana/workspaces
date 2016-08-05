package mine.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureSample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future future = executor.submit(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Task1");
			}
		});
		// future.cancel(true);
		while (!future.isDone()) {
			System.out.println("Still Running...");
		}

		try {
			System.out.println("Comleted:" + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executor.shutdown();
		System.out.println(executor.isShutdown());
	}

}
