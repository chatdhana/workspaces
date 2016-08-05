package mine.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringAppContextAware implements ApplicationContextAware {

	private static ApplicationContext appCtx;

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		appCtx = arg0;
	}

	public static ApplicationContext getAppContext() {
		return appCtx;
	}

}
