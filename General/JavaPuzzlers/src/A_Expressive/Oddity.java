package A_Expressive;

/**
 * Test that your methods behave properly when passed negative, zero, and positive values for each numerical parameter.
 */
public class Oddity {
	
	/*public static boolean isOdd(int i) {
		return i % 2 == 1;
	}*/

	public static boolean isOdd(int i) {
		System.out.println(Integer.toBinaryString(i));
		return (i & 1) == 1;
	}
	
	public static void main(String[] args) {
		for (int i = 15; i >= -15; i--) {
			System.out.println("i(" + i + ") isOdd? " + isOdd(i));
		}
	}
}
