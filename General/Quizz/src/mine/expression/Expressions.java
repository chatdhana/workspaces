package mine.expression;

/**
 * <pre>The Expression.
 * 
 *  Evaluation order: 
 *  
 *  1) Left-Hand Operand Is Evaluated First.
 *  
 *  2) Evaluate Operands before Operation (except the conditional operators &&, ||, and ? :).
 *  
 *  3) Evaluation Respects Parentheses and Precedence.
 *  
 *  4) Argument Lists are Evaluated Left-to-Right.
 *  
 *  
 *
 *	</pre>
 */
public class Expressions {

	public static void main(String[] args) {
		int i = 2;
		int j = (i=3) * i;
		System.out.println("Expected 9; Actual:"+j);

		// Order of execution of Arguments
		String s = "s";
		printStr(s, (s ="S"), s);
		
		// Primary expression
		
		System.out.println(void.class);
	}
	
	 static void printStr(String s1, String s2, String s3){
		System.out.println(s1+s2+s3);
	}

}
