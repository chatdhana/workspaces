package mine.spring.bean;

public class OuterBean {

	Object instanceField;
	
	public class InnerClass {
		public void print(){
			System.out.println("Called print() @ Inner Class");
		}
	}
	
	public static class StaticInnerClass {
		public void print(){
			System.out.println("Called print() @ Static Inner Class");
		}
	}
	
	
}
