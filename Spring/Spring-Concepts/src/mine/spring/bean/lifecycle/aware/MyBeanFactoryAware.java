package mine.spring.bean.lifecycle.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class MyBeanFactoryAware implements BeanFactoryAware {

	private static BeanFactory myBeanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		myBeanFactory = beanFactory;
		System.out.println("MyBeanFactoryAware: This bean is provided with the BeanFactory that created it. beanFactory:"
				+ beanFactory);
	}

	public static BeanFactory getBeanFactory() {
		return myBeanFactory;
	}
}
