package A_Expressive;

/**
 * Do not assign to the same variable more than once in a single expression.
 * 
 */
public class CleverSwap {
	public static void main(String[] args) {
		int x = 1984;
		int y = 2001;
		x ^= y ^= x ^= y;
		System.out.println("x = " + x + "; y = " + y);

		x = 1984;
		y = 2001;
		x ^= (y ^= (x ^= y));
		System.out.println("x = " + x + "; y = " + y);

		x = 1984;
		y = 2001;
		x = x ^ y;
		y = y ^ x;
		x = x ^ y;
		System.out.println("x = " + x + "; y = " + y);
	}
}
