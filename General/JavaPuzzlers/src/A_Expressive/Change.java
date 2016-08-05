package A_Expressive;

import java.math.BigDecimal;

/**
 * Avoid float and double where exact answers are required; for monetary calculations, use int, long, or BigDecimal.
 */
public class Change {
    public static void main(String args[]) {
        // problem
    	System.out.println(2.00 - 1.10);
        
    	// Poor solution
    	System.out.printf("%.2f%n", 2.00 - 1.10);
    	
    	// Right solution but degrades performance
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
    }
}
