package mine.spring.bean.di;

public class CircularDepBeanB {
	private CircularDepBeanA beanA;

	public CircularDepBeanB(CircularDepBeanA beanA) {
		this.beanA = beanA;
	}
}
