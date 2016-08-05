package mine.spring.bean.lifecycle;

public class InitializationCallbackUsingInitMethod {
	private int intField;
	private float floatField;
	private String stringField;
	private Object objField;
	private int[] intArray;
	private Object[] objArray;

	public void initMethod() {
		this.intField = 1;
		this.stringField = "via init-method";
		this.objField = null;
		System.out.println("InitializationCallbackUsingInitMethod called init-method:: this.stringField:" + this.stringField);
	}
	
	public InitializationCallbackUsingInitMethod() {
	}

	public InitializationCallbackUsingInitMethod (int intField, String stringField, Object objField){
		this.intField = intField;
		this.stringField = stringField;
		this.objField = objField;
		System.out.println("InitializationCallbackUsingInitMethod called constructor:: this.stringField:" + this.stringField);
	}

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
		System.out.println("InitializationCallbackUsingInitMethod called property setter:: this.stringField:" + this.stringField);
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

}
