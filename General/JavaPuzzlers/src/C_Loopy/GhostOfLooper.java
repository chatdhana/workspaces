package C_Loopy;

/**
 * Narrowing primitive conversions can lose information about the magnitude or precision of numeric values.
 * 
 * Do not use compound assignment operators on short, byte, or char variables.
 * 
 */
public class GhostOfLooper {
	public static void main(String[] args) {
		// Place your declaration for i here

		/* byte i=-1; */ short i = -1;
		while (i != 0) {
			System.out.println(i);
			i >>>= 1;
			// i = i >>> 1;
		}
	}
}
