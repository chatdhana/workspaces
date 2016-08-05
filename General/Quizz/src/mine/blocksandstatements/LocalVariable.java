package mine.blocksandstatements;

public class LocalVariable {
	class InnerClass {

	}

	void method() {
//		private int i =0; // Compile-time error; only final is permitted
		final int x;
		int y;
		int[] intArr= {};
		
		x = 0;
		if(x==0){
			
		}
		class LocalClass extends LocalVariable.InnerClass {
		}
	}
}
