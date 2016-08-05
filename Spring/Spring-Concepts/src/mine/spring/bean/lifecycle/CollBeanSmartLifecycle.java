package mine.spring.bean.lifecycle;

import org.springframework.context.SmartLifecycle;

public class CollBeanSmartLifecycle implements SmartLifecycle {

	@Override
	public void start() {
		System.out.println("CollBeanSmartLifecycle: Container called its bean's start method.");
	}

	@Override
	public void stop() {
		System.out.println("CollBeanSmartLifecycle: Container called its bean's stop method.");
	}

	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPhase() {
		return 3;
	}

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable callback) {
		// TODO Auto-generated method stub

	}

}
