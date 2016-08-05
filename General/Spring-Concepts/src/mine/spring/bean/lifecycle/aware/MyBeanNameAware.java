package mine.spring.bean.lifecycle.aware;

import org.springframework.beans.factory.BeanNameAware;

public class MyBeanNameAware implements BeanNameAware {

	@Override
	public void setBeanName(String beanName) {
		System.out.println("MyBeanNameAware: This bean is provided with a name of this bean as defined in its bean definition. beanName:"+beanName);
	}

}
