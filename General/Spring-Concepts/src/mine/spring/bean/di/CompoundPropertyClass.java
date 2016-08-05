package mine.spring.bean.di;

public class CompoundPropertyClass {

	private CompoundPropertyClass1 class1Field;

	public CompoundPropertyClass1 getClass1Field() {
		return class1Field;
	}

	public void setClass1Field(CompoundPropertyClass1 class1Field) {
		this.class1Field = class1Field;
	}

}

class CompoundPropertyClass1 {
	private CompoundPropertyClass2 class2Field;

	public CompoundPropertyClass2 getClass2Field() {
		return class2Field;
	}

	public void setClass2Field(CompoundPropertyClass2 class2Field) {
		this.class2Field = class2Field;
	}

}

class CompoundPropertyClass2 {
	String stringField;

	public String getStringField() {
		return stringField;
	}

	public void setStringField(String stringField) {
		this.stringField = stringField;
		System.out.println("CompoundPropertyClass2.stringField:" + this.stringField);
	}

}
