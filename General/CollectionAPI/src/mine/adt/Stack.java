package mine.adt;

public interface Stack<T> {

	void push(T element);

	T pop();

	T peek();

	int size();

	boolean isFull();

	boolean isEmpty();
}
