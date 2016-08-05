package mine.general.cloning;

public class ClassB extends ClassA implements Cloneable {
	private StringBuilder childSB;

	public StringBuilder getChildSB() {
		return childSB;
	}

	public void setChildSB(StringBuilder childSB) {
		this.childSB = childSB;
	}
	
	public static void main(String[] args) {
		ClassC a = new ClassC();
		a.m();
	}

}
