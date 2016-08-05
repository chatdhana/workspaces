package collection;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 •	A Queue is a collection for holding elements prior to processing.
 •	Besides basic Collection operations, queues provide additional insertion, removal, and inspection operations.
 •	Each Queue method exists in two forms:
 (1) one throws an exception if the operation fails, and 
 (2) the other returns a special value if the operation fails (either null or false, depending on the operation). 
 •	The regular structure of the interface is illustrated in the following table. 
 Queue Interface Structure":
 Throws exception				Returns special value
 Insert:		add(e)						offer(e)
 Remove:		remove()					poll()
 Examine:	element()					peek()

 •	Queues typically, but not necessarily, order elements in a FIFO (first-in-first-out) manner. Among the exceptions are priority queues, which order elements according to their values).

 */
public class QueueEx {
	public static void main(String[] args) {

		Queue<String> queue = new LinkedList<String>();
		queue.add("str1");
		queue.add("str2");
		queue.offer("str3");
		System.out.println("Queue Size:" + queue.size());
		int j = queue.size();
		for (int i = 0; i < j; i++) {

			if (i % 2 == 0) {
				System.out.println(queue.element());
				queue.remove();
			} else {
				System.out.println(queue.peek());
				queue.poll();
			}

		}
		System.out.println("Queue Size:" + queue.size());
		System.out.println(queue.peek()); // Returns null
		System.out.println(queue.element()); // Throws NoSuchElementException
		System.out.println(queue.poll()); // Returns null
		System.out.println(queue.remove()); // Throws NoSuchElementException

	}
}
