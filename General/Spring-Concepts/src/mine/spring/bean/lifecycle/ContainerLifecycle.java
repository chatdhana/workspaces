package mine.spring.bean.lifecycle;

import org.springframework.context.Lifecycle;

public class ContainerLifecycle implements Lifecycle {

	@Override
	public void start() {
		System.out.println("ContainerLifecycle: Container called its own start method.");
	}

	@Override
	public void stop() {
		System.out.println("ContainerLifecycle: Container called its own stop method.");
	}

	@Override
	public boolean isRunning() {
		return false;
	}

}
