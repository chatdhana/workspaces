package mine.general;

public class Quizz1 {

	static String staticStr = "staticStr";
	public static void main(String[] args) {
		new Quizz1().caller();
	}
	
	void caller(){
		staticFieldAccess();
	}
	
	/**
	 * Receiver Variable Is Irrelevant For static Field Access
	 */
	void staticFieldAccess(){
		/* When a target reference is computed and then discarded because the invocation mode is
		static, the reference is not examined to see whether it is null*/
		// Following statement does not throw NPE.
		System.out.println(returnNull().staticStr); // Type of result , not value, is used to access static field.
	}
	
	Quizz1 returnNull(){
		return null;
	}
	
	
}
