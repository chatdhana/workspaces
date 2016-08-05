package mine.spring.bean;

public class ChildBean {

	private int childIntField;
	private String childStringField;
	private Object childObjectField;

	private String prntStringField;

	public void init() {

	}

	public void destroy() {

	}

	public int getChildIntField() {
		return childIntField;
	}

	public void setChildIntField(int childIntField) {
		this.childIntField = childIntField;
	}

	public String getChildStringField() {
		return childStringField;
	}

	public void setChildStringField(String childStringField) {
		this.childStringField = childStringField;
	}

	public Object getChildObjectField() {
		return childObjectField;
	}

	public void setChildObjectField(Object childObjectField) {
		this.childObjectField = childObjectField;
	}

	public String getPrntStringField() {
		return prntStringField;
	}

	public void setPrntStringField(String prntStringField) {
		this.prntStringField = prntStringField;
	}

}
