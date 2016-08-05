package mine.adt;

public class QueueUsage {
	public static void main(String[] args) {
		queueByArrayUsage();
	}

	private static void queueByArrayUsage() {
		Queue<String> queue = new QueueByArray<>(3);
		System.out.println("peek:" + queue.peek());
		queue.insert("A");
		System.out.println("peek:" + queue.peek());
		queue.insert("B");
		System.out.println("peek:" + queue.peek());
		queue.remove();
		System.out.println("peek:" + queue.peek());
		queue.insert("C");
		System.out.println("peek:" + queue.peek());
		queue.insert("D");
		System.out.println("peek:" + queue.peek());
	}
}
