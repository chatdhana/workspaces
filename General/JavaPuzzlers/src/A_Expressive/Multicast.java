package A_Expressive;

/**
 * Strive for clarity: If you can't tell what a program does by looking at it, it probably doesn't do what you want.
 * 
 * Sign extension is performed if the type of the original value is signed; zero extension if it is a char, regardless of the type
 * to which it is being converted.
 */
public class Multicast {
	public static void main(String[] args) {
		System.out.println((int) (char) (byte) -1); // 65535
		/*
		 * Because byte is a signed type, sign extension occurs when converting the byte value –1 to a char. The resulting char
		 * value has all 16 bits set, so it is equal to 216 – 1, or 65,535. The cast from char to int is also a widening primitive
		 * conversion, so the rule tells us that zero extension is performed rather than sign extension. The resulting int value
		 * is 65535, which is just what the program prints.
		 */

		// other type conversions

		char c = 65535;

		// Good practice to write a comment describing the behavior of the conversion.
		int i = c; // (c & 0xffff); Sign extension is not performed.
		System.out.println((int) (c & 0xffff));

		short s = (short) c; // Cast causes sign extension
		
		byte b = -1;
		char c2 = (char) b; // Sign extension is performed
	}
}
