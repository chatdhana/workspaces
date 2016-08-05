package A_Expressive;

/**
 * It is generally best to avoid mixed-type computations.
 * 
 * Negative decimal constants are clearly identifiable by the presence of a minus sign.
 * 
 * Hex and octal literals are negative if their high-order bit is set.
 *
 */
public class JoyOfHex {
	public static void main(String[] args) {
		// Problem: Addition of long hexadecimal literal with int hexadecimal literal.
		System.out.println(Long.toHexString(0x100000000L + 0xcafebabe));
		/*
		 * The left operand is of type long, and the right operand is of type int. To perform the computation, Java promotes the
		 * int value to a long with a widening primitive conversion and adds the two long values. Because int is a
		 * signed integral type, the conversion performs sign extension: It promotes the negative int value to a numerically equal
		 * long value
		 */
		
		// Solution
		System.out.println(Long.toHexString(0x100000000L + 0xcafebabeL));
	}
}
