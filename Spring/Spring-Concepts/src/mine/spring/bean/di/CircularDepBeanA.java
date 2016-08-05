package mine.spring.bean.di;

public class CircularDepBeanA {
	private CircularDepBeanB beanB;

	public CircularDepBeanA(CircularDepBeanB beanB) {
		this.beanB = beanB;
	}
}
