package mine.spring.containerextn;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class MyOrderedBeanPostprocessor implements Ordered, BeanPostProcessor {

	private int order;
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println("MyOrderedBeanPostprocessor: Got a callback from container before initialization for a bean:" + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println("MyOrderedBeanPostprocessor: Got a callback from container after initialization for a bean:" + beanName);
		return bean;
	}

	@Override
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	

}
