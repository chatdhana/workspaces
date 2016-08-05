package mine.polymorphism;

public class ConstructorNotInherited {
	public static void main(String[] args) {
		// ConstructorNotInheritedSub sub = new ConstructorNotInheritedSub(1,2); // Compile-time error
	}
}

class ConstructorNotInheritedSuper {
	int x;
	int y;
	static int z ;
	private ConstructorNotInheritedSuper() {
	}

	public ConstructorNotInheritedSuper(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	private class InnerClassSuper {
		int x;
	}
}

class ConstructorNotInheritedSub extends ConstructorNotInheritedSuper {
	Double x;
	public ConstructorNotInheritedSub() {
		super(1, 2);
		System.out.println(this.x);
		System.out.println(((ConstructorNotInheritedSuper) this).x);
	}

}
 
