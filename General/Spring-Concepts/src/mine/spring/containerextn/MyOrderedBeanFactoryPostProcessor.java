package mine.spring.containerextn;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

public class MyOrderedBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {

	private int order;
	
	@Override
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyOrderedBeanFactoryPostProcessor: beanFactory = " + beanFactory);
	}

}
