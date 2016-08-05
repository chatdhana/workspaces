package mine.util;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {

	private transient Entry<K, V>[] buckets;

	@Override
	public V put(K key, V value) {
		return super.put(key, value);
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return null;
	}

	int hashFor(int key) {
		return 0;
	}

	int indexFor(int hash) {
		return 0;
	}

	static class Entry<K, V> implements Map.Entry<K, V> {
		final K key;
		V value;
		int hash;
		Entry<K, V> next;

		public Entry(K key, V value, int hash, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.hash = hash;
			this.next = next;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Map.Entry)) {
				return false;
			}

			Map.Entry entry = (Map.Entry) obj;
			if (entry.getKey() == getKey() || (entry.getKey() != null && entry.getKey().equals(getKey()))) {
				if (entry.getValue() == getValue() || (entry.getValue() != null && entry.getValue().equals(getValue()))) {
					return true;
				}
			}
			return false;
		}

	}

}
