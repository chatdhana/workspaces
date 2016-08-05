package mine.spring.containerextn;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<MyComplexBean> {

	@Override
	public MyComplexBean getObject() throws Exception {
		System.out.println("MyFactoryBean: getObject() called.");
		return new MyComplexBean();
	}

	@Override
	public Class<?> getObjectType() {
		return MyComplexBean.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
