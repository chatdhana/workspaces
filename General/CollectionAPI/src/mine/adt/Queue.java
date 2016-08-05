package mine.adt;

public interface Queue<E> {
	void insert(E element);

	E remove();

	E peek();

	int size();

	boolean isFull();

	boolean isEmpty();
}
