package potential_programming_problems;

/*
 * Unreachable catch block for IOException. Only more specific exceptions are thrown 
 and handled by previous catch block(s).
 (Hidden catch block)
 * 
 * 
 */
public class HoddenCatchBlock {

	public static void main(String[] args) {

		/* Second catch block throws
		 * "Unreachable catch block for IOException. Only more specific
		 * exceptions are thrown and handled by previous catch block(s)" or "Hidden
		 * catch block".
		 */
		try {
			throw new java.io.CharConversionException();
		} catch (java.io.CharConversionException e) {
		} catch (java.io.IOException e) {
		}

	}

}
