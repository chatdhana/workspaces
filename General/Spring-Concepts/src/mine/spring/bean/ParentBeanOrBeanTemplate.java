package mine.spring.bean;

public class ParentBeanOrBeanTemplate {

	int prntIntField;
	String prntStringField;
	Object prntObjField;

	public void init() {

	}

	public void destroy() {

	}

	public int getPrntIntField() {
		return prntIntField;
	}

	public void setPrntIntField(int prntIntField) {
		this.prntIntField = prntIntField;
	}

	public String getPrntStringField() {
		return prntStringField;
	}

	public void setPrntStringField(String prntStringField) {
		this.prntStringField = prntStringField;
	}

	public Object getPrntObjField() {
		return prntObjField;
	}

	public void setPrntObjField(Object prntObjField) {
		this.prntObjField = prntObjField;
	}

}
