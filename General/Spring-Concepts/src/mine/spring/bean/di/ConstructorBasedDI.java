package mine.spring.bean.di;

public class ConstructorBasedDI {
	private DICollBeanA depBeanA;
	private DICollBeanB depBeanB;
	private String stringField;
	private int intField;
	private long longField;

	public ConstructorBasedDI(DICollBeanA depBeanA, DICollBeanB depBeanB) {
		this.depBeanA = depBeanA;
		this.depBeanB = depBeanB;
		System.out.println("this.depBeanA:" + this.depBeanA);
		System.out.println("this.depBeanB:" + this.depBeanB);
	}

	public ConstructorBasedDI(DICollBeanA depBeanA, DICollBeanB depBeanB, String stringField, int intField, long longField) {
		this.depBeanA = depBeanA;
		this.depBeanB = depBeanB;
		this.stringField = stringField;
		this.intField = intField;
		this.longField = longField;
		
		System.out.println("this.depBeanA:" + this.depBeanA);
		System.out.println("this.depBeanB:" + this.depBeanB);
		System.out.println("this.stringField:" + this.stringField);
		System.out.println("this.intField:" + this.intField);
		System.out.println("this.longField:" + this.longField);
	}
}
