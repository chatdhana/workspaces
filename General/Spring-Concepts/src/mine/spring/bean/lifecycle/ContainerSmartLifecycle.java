package mine.spring.bean.lifecycle;

import org.springframework.context.SmartLifecycle;

public class ContainerSmartLifecycle implements SmartLifecycle {

	@Override
	public void start() {
		System.out.println("ContainerSmartLifecycle: Container called its own start method.");
	}

	@Override
	public void stop() {
		System.out.println("ContainerSmartLifecycle: Container called its own stop method.");
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
		return false;
	}

	@Override
	public void stop(Runnable callback) {
	}

}
