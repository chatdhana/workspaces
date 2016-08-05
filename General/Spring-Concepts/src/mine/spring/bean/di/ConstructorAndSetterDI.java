package mine.spring.bean.di;

public class ConstructorAndSetterDI {

	private DICollBeanA depBeanA;
	private DICollBeanB depBeanB;
	private String stringField;
	private int intField;
	private long longField;

	public ConstructorAndSetterDI() {
	}
	
	public ConstructorAndSetterDI(DICollBeanA depBeanA, DICollBeanB depBeanB) {
		this.depBeanA = depBeanA;
		this.depBeanB = depBeanB;
	}

	public ConstructorAndSetterDI(DICollBeanA depBeanA, DICollBeanB depBeanB, String stringField, int intField, long longField) {
		this.depBeanA = depBeanA;
		this.depBeanB = depBeanB;
		this.stringField = stringField;
		this.intField = intField;
		this.longField = longField;
	}

	public DICollBeanA getDepBeanA() {
		return depBeanA;
	}

	public void setDepBeanA(DICollBeanA depBeanA) {
		this.depBeanA = depBeanA;
	}

	public DICollBeanB getDepBeanB() {
		return depBeanB;
	}

	public void setDepBeanB(DICollBeanB depBeanB) {
		this.depBeanB = depBeanB;
	}

	public String getStringField() {
		return stringField;
	}

	public void setStringField(String stringField) {
		this.stringField = stringField;
	}

	public int getIntField() {
		return intField;
	}

	public void setIntField(int intField) {
		this.intField = intField;
	}

	public long getLongField() {
		return longField;
	}

	public void setLongField(long longField) {
		this.longField = longField;
	}

}
