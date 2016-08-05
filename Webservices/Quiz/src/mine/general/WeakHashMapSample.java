package mine.general;

import java.util.WeakHashMap;

public class WeakHashMapSample {
	public static void main(String[] args) {
		WeakHashMap<String, String> weakMap = new WeakHashMap<String, String>();
		String keyStrongReference = new String("key");
		weakMap.put(keyStrongReference, "value");
		System.gc();
		System.out.println(weakMap.get("key"));
		keyStrongReference = null;
		System.gc();
		System.out.println(weakMap.get("key"));
	}
}
