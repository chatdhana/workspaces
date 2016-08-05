package mine.adt;

public class StackByArray<T> extends AbstractStack<T> {

	private int maxSize;
	private Object[] stackArray;
	private int top;

	public StackByArray() {
		this.maxSize = DEFAULT_MAX_SIZE_OF_STACK;
		this.stackArray = new Object[maxSize];
		this.top = -1;
	}

	public StackByArray(int maxSize) {
		this.maxSize = maxSize;
		this.stackArray = new Object[maxSize];
		this.top = -1;
	}

	@Override
	public void push(T element) {
		if (isFull()) {
			throw new IllegalStateException("Stack is full!");
		}
		stackArray[++top] = element;
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			return null;
		}
		return (T) stackArray[top--];
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			return null;
		}
		return (T) stackArray[top];
	}

	public int size() {
		return top + 1;
	}

	@Override
	public boolean isFull() {
		return top == maxSize - 1;
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

}
