package mine.spring.bean.di;


public abstract /*abstarct is optional*/class PrototypeBeanInjectionLookupMethod {
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

	protected abstract PrototypeBean createPrototypeBean();
	
	/*protected PrototypeBean createPrototypeBean() {
	}*/
	
	public int getIntField() {
		return intField;
	}

	public void setIntField(int intField) {
		this.intField = intField;
	}

	public float getFloatField() {
		return floatField;
	}

	public void setFloatField(float floatField) {
		this.floatField = floatField;
	}

	public String getStringField() {
		return stringField;
	}

	public void setStringField(String stringField) {
		this.stringField = stringField;
	}

	public Object getObjField() {
		return objField;
	}

	public void setObjField(Object objField) {
		this.objField = objField;
	}

	public int[] getIntArray() {
		return intArray;
	}

	public void setIntArray(int[] intArray) {
		this.intArray = intArray;
	}

	public Object[] getObjArray() {
		return objArray;
	}

	public void setObjArray(Object[] objArray) {
		this.objArray = objArray;
	}

	public PrototypeBean getPrototypeBean() {
		return prototypeBean;
	}

	public void setPrototypeBean(PrototypeBean prototypeBean) {
		this.prototypeBean = prototypeBean;
	}

}
