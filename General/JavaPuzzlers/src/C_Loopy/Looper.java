package C_Loopy;

/**
 * It is possible to represent infinity as a double or a float.
 * 
 * Adding a small floating-point value to a large one will not change the large value.
 * 
 * Binary floating-point arithmetic is only an approximation to real arithmetic.
 * 
 */
public class Looper {
	public static void main(String[] args) {
		// Place your declaration for i here

		// Solution
		System.out.println("Started..");
		float i = 33554432.0f;// 1.0/0.0; // Float.POSITIVE_INFINITY;

		//
		while (i == i + 2) {
			System.out.println(i);
		}
	}
}
