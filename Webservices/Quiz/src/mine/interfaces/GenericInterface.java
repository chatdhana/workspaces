package mine.interfaces;

public interface GenericInterface<K, V, T extends Throwable> {
	void myAbstractMethod(K key, V value) throws T;
}
