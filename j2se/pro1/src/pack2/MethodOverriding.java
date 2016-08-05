package pack2;

public class MethodOverriding {

	
	public static void main(String[] args) {
		

	}

}


abstract class SuperAbsClass {
	abstract void getName();
}

abstract class SuperCls extends SuperAbsClass{
	protected void display() {
		
	}
}
class SubCls extends SuperCls {

	@Override
	void getName() {
		
		
	}
	
	public void display() {
		
	}

	
	
	
}