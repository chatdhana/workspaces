package mine.spring.bean.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PostConstructAndPreDestroy {

/*	public void init() {
		System.out.println("PostConstructAndPreDestroy called default continer level default-init-method (init()).");
	}

	public void initMethod() {
		System.out.println("PostConstructAndPreDestroy called custom bean specific init-method (initMethod()).");
	}*/

	@PostConstruct
	public void postConstruct() {
		System.out.println("PostConstructAndPreDestroy called postConstruct().");
	}

/*	public void destroy() {
		System.out.println("PostConstructAndPreDestroy called default container level default-destroy-method (destroy()).");
	}

	public void destroyMethod() {
		System.out.println("PostConstructAndPreDestroy called custom bean specific destroy-method (destroyMethod()).");
	}*/

	@PreDestroy
	public void preDestroy() {
		System.out.println("PostConstructAndPreDestroy called preDestroy().");
	}
}
