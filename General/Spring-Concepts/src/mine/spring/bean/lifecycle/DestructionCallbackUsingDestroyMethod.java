package mine.spring.bean.lifecycle;

public class DestructionCallbackUsingDestroyMethod {
	private int intField;
	private String stringField;
	private Object objField;

	public void destroyMethod() {
		System.out.println("DestructionCallbackUsingDestroyMethod called custom destroy method (destroyMethod()).");
	}
	
	public int getIntField() {
		return intField;
	}

	public void setIntField(int intField) {
		this.intField = intField;
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

}
