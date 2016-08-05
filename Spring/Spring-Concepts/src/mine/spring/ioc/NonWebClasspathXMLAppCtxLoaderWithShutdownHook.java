package mine.spring.ioc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NonWebClasspathXMLAppCtxLoaderWithShutdownHook {
	public static void main(String[] args) {
		AbstractApplicationContext appCtx = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		System.out.println("Non web application context is loaded.");
		appCtx.registerShutdownHook();
	}
}
