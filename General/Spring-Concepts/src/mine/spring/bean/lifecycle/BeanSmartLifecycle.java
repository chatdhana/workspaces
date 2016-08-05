package mine.spring.bean.lifecycle;

import org.springframework.context.SmartLifecycle;

public class BeanSmartLifecycle implements SmartLifecycle {

	@Override
	public void start() {
		System.out.println("BeanSmartLifecycle: Container called its bean's start method.");
	}

	@Override
	public void stop() {
		System.out.println("BeanSmartLifecycle: Container called its bean's stop method.");
	}

	@Override
	public boolean isRunning() {
		return false;
	}

	@Override
	public int getPhase() {
		return 0;
	}

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable callback) {
	}

}
