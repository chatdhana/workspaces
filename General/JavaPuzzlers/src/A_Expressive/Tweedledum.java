package A_Expressive;

/**
 * Compound assignment expressions automatically cast the result of the computation they perform to the type of the variable on
 * their left-hand side.
 * 
 * Do not use compound assignment operators on variables of type byte, short, or char.
 * 
 */
public class Tweedledum {
	public static void main(String[] args) {
		// Put your declarations for x and i here
		int i = 0, x = 0;
		
		// Solution
		// byte x = 0; int i = 0;

		
		x += i; // Must be LEGAL
		x = x + i; // Must be ILLEGAL
	}
}
