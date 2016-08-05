package overloading;

public class FinalClass {

	public static void main(String[] args) {
		new FinalClass().disp1();
		new FinalClass().disp2();

	}
	
	public final void disp1() {
		System.out.println("Final method");
	}
	public void disp2() {
		System.out.println("Non-Final method");
	}

}
