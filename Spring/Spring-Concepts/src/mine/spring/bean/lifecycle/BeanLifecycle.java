package mine.spring.bean.lifecycle;

import org.springframework.context.Lifecycle;

public class BeanLifecycle implements Lifecycle {

	@Override
	public void start() {
		String x = null;
		x.toString();
		System.out.println("BeanLifecycle: Container called its bean's start method.");
	}

	@Override
	public void stop() {
		System.out.println("BeanLifecycle: Container called its bean's stop method.");
	}

	@Override
	public boolean isRunning() {
		return false;
	}

}
