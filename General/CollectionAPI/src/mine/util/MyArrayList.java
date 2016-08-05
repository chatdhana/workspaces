package mine.util;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList<E> extends AbstractList<E> implements List<E> {

	private transient Object[] data;
	private int size;

	private int modCount;

	public MyArrayList() {
		data = new Object[10];
	}
	
	public MyArrayList(int initialCapacity) {
		data = new Object[initialCapacity];
	}
	
	@Override
	public E get(int index) {
		rangeCheck(index);
		return (E) data[index];
	}

	@Override
	public E set(int index, E element) {
		rangeCheck(index);
		data[index] = element;
		size++;
		return (E) data[index];
	}

	@Override
	public void add(int index, E element) {
		ensureCapacity(index);
		rangeCheck(index);
		data[index] = element;
		size++;
	}

	@Override
	public E remove(int index) {
		E element = (E) data[index];
		data[index] = null;
		size--;
		return element;
	}

	@Override
	public int size() {
		return size;
	}

	private void rangeCheck(int index) {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	private void ensureCapacity(int minCapacity) {
		if (minCapacity - data.length > 0) {
			grow(minCapacity);
		}
	}

	private void grow(int minCapacity) {
		int oldCapacity = data.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity < minCapacity) {
			newCapacity = minCapacity;
		}
		data = Arrays.copyOf(data, newCapacity);
	}

}
