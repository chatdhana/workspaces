package mine.spring.bean.di;

public class PrototypeBeanInjectionReplacedMethod {
	private int intField;
	private float floatField;
	private String stringField;
	private Object objField;
	private int[] intArray;
	private Object[] objArray;
	private PrototypeBean prototypeBean;

	public void usageMethod() {
		System.out.println("Gets brand new instance of PrototypeBean on every request." + createPrototypeBean());
	}

	protected PrototypeBean createPrototypeBean() {
		return null;
	}

}
