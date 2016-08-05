package mine.spring.bean.lifecycle.aware;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

public class MyOtherAwares implements ApplicationEventPublisherAware, BeanClassLoaderAware, LoadTimeWeaverAware,
		MessageSourceAware, NotificationPublisherAware, ResourceLoaderAware, ServletConfigAware, ServletContextAware {

	@Override
	public void setServletContext(ServletContext servletContext) {
		System.out.println("MyOtherAwares - ServletContextAware: Current ServletContext the container runs in."
				+ " servletContext:" + servletContext);

	}

	@Override
	public void setServletConfig(ServletConfig servletConfig) {
		System.out.println("MyOtherAwares - ServletConfig: Current ServletConfig the container runs in."
				+ " servletConfig:"	+ servletConfig);

	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		System.out.println("MyOtherAwares - ResourceLoaderAware: Configured loader for low-level access to resources."
				+ " resourceLoader:" + resourceLoader);

	}

	@Override
	public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
		System.out.println("MyOtherAwares - NotificationPublisherAware: The Spring JMX notification publisher."
				+ " notificationPublisher:" + notificationPublisher);

	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("MyOtherAwares - MessageSourceAware: Configured message source for resolving messages."
				+ " messageSource:" + messageSource);

	}

	@Override
	public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
		System.out.println("MyOtherAwares - LoadTimeWeaverAware: Defined weaver for processing class definition at load time."
				+ " loadTimeWeaver:" + loadTimeWeaver);

	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("MyOtherAwares - BeanClassLoaderAware: The class loader used to load the bean classes."
				+ " classLoader:" + classLoader);

	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		System.out.println("MyOtherAwares - ApplicationEventPublisherAware: Event publisher of the enclosing ApplicationContext."
				+ " applicationEventPublisher:" + applicationEventPublisher);
	}

}
