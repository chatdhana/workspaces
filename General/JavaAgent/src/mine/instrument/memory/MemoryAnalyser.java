package mine.instrument.memory;

import java.lang.instrument.Instrumentation;

public class MemoryAnalyser {
	private static Instrumentation intstrumentation = null;

	public static void premain(String arg, Instrumentation intstrumentation) {
		MemoryAnalyser.intstrumentation = intstrumentation;
	}

	public static long getObjectSize(Object objectToSize) {
		if (intstrumentation == null) {
			System.err.print("Agent is yet to be initialized.");
			return -1L;
		}
		return intstrumentation.getObjectSize(objectToSize);

	}

}
