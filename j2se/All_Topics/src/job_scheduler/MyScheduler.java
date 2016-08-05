package job_scheduler;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MyScheduler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timer timer = new Timer();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		// Schedule to run every Sunday in midnight
		timer.schedule(new MyTimer(), cal.getTime(), 1000 * 2);

	}

}

class MyTimer extends TimerTask {
	static int count = 0;

	@Override
	public void run() {
		// Calling a method has to be called in a scheduled manner.
		myScheduledMethod();

	}

	void myScheduledMethod() {
		System.out.println("method called...");
		try {
			count++;
			if (count % 2 == 0)
				Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}