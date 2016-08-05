package mine.adt;

public class QueueByArray<E> extends AbstractQueue<E> {

	private int front;
	private int rear;
	private int nSize;
	private int maxSize;
	private Object[] queue;

	public QueueByArray() {
		maxSize = DEFAULT_MAX_SIZE_OF_QUEUE;
		queue = new Object[maxSize];
		front = 0;
		rear = -1;
	}

	public QueueByArray(int maxSize) {
		this.maxSize = maxSize;
		queue = new Object[this.maxSize];
		front = 0;
		rear = -1;
	}

	@Override
	public void insert(E element) {
		if (isFull()) {
			throw new IllegalStateException("Queue is full!");
		}
		wrapAroud();
		queue[++rear] = element;
		nSize++;
	}

	@Override
	public E remove() {
		if (isEmpty()) {
			return null;
		}
		E element = (E) queue[front++];
		nSize--;
		wrapAroud();
		return element;
	}

	/**
	 * Forming Circular queue by performing wrapAround.
	 */
	private void wrapAroud() {
		if (rear == maxSize - 1) {
			rear = -1;
		}

		if (front == maxSize) {
			front = 0;
		}
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			return null;
		}
		E element = (E) queue[front];
		return element;
	}

	@Override
	public int size() {
		return nSize;
	}

	@Override
	public boolean isFull() {
		return nSize == maxSize;
	}

	@Override
	public boolean isEmpty() {
		return nSize <= 0;
	}

}
