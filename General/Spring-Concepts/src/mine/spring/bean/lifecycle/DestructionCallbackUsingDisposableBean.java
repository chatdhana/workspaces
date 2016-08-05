package mine.spring.bean.lifecycle;

import org.springframework.beans.factory.DisposableBean;

public class DestructionCallbackUsingDisposableBean implements DisposableBean {

	private int intField;
	private String stringField;
	private Object objField;

	@Override
	public void destroy() throws Exception {
		System.out.println("DestructionCallbackUsingDisposableBean called DisposableBean's destroy().");
	}

	public void destroyMethod() {
		System.out.println("DestructionCallbackUsingDisposableBean called custom destroy method (destroyMethod()).");
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
