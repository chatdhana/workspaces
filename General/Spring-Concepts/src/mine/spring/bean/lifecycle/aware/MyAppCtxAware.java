package mine.spring.bean.lifecycle.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyAppCtxAware implements ApplicationContextAware {
	private static ApplicationContext appCtx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appCtx = applicationContext;
		System.out.println("MyAppCtxAware: This bean is provided with the ApplicationContext that created it. applicationContext:"+applicationContext);
	}

	public static ApplicationContext getAppCtx() {
		return appCtx;
	}

}
