package mine.adt;

public class StackUsage {

	public static void main(String[] args) {
		stackByArrayUsage();
	}

	static void stackByArrayUsage() {
		StackByArray<String> stack = new StackByArray<>(5);
		System.out.println("isFull:" + stack.isFull());
		System.out.println("isEmpty:" + stack.isEmpty());
		System.out.println("top:" + stack.peek());
		stack.push("ONE");
		System.out.println("push:" + stack.peek());
		stack.push("TWO");
		System.out.println("push:" + stack.peek());
		stack.push("THREE");
		System.out.println("push:" + stack.peek());
		System.out.println("isFull:" + stack.isFull());
		System.out.println("isEmpty:" + stack.isEmpty());
		System.out.println("pop:" + stack.pop());
		System.out.println("top:" + stack.peek());
		stack.push("THREE");
		System.out.println("push:" + stack.peek());
		stack.push("FOUR");
		System.out.println("push:" + stack.peek());
		stack.push("FIVE");
		System.out.println("push:" + stack.peek());
		System.out.println("isFull:" + stack.isFull());
		System.out.println("isEmpty:" + stack.isEmpty());
		stack.push("SIX");
		System.out.println("push:" + stack.peek());
	}
}
