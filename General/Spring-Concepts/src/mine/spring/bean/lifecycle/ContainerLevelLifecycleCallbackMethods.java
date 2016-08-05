package mine.spring.bean.lifecycle;

public class ContainerLevelLifecycleCallbackMethods {
	public void init() {
		System.out.println("ContainerLevelLifecycleCallbackMethods called default continer level default-init-method (init()).");
	}

	public void initMethod() {
		System.out.println("ContainerLevelLifecycleCallbackMethods called custom bean specific init-method (initMethod()).");
	}

	public void destroy() {
		System.out
				.println("ContainerLevelLifecycleCallbackMethods called default container level default-destroy-method (destroy()).");
	}

	public void destroyMethod() {
		System.out
				.println("ContainerLevelLifecycleCallbackMethods called custom bean specific destroy-method (destroyMethod()).");
	}

}
