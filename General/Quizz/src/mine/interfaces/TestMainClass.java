/**
 * 
 */
package mine.interfaces;

import java.util.HashMap;

public class TestMainClass {

	public static void main(String[] args) {
		System.out.println("Started...");
		Runtime.getRuntime().traceMethodCalls(true);
		for (long i = 0; true; i++) {
			HashMap<Long, String> hashMap = new HashMap<Long, String>();
			for (int j = 0; j < 100; j++) {
				String str = "" + j;
				hashMap.put(i, str);
			}
			if (i % Integer.MAX_VALUE == 0) {
				System.out.println("GC...");
				System.gc();
			}

			if (i % 999999 == 0) {
				printMemoryFootprint();

			}
		}

	}

	private static void printMemoryFootprint() {
		System.out.println("Total:" + Runtime.getRuntime().totalMemory() / 1048576);
		System.out.println("Free:" + Runtime.getRuntime().freeMemory() / 1048576);
		System.out.println("Max:" + Runtime.getRuntime().maxMemory() / 1048576);
	}
}

