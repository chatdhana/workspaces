package mine.general;

/**
 * Expressions with unary operators group right-to-left, so that -~x means the same as -(~x).
 * 
 * A variable that is declared final cannot be decremented because when an access of such a final variable is used as an
 * expression, the result is a value, not a variable.
 * 
 * The result of the unary expression must be a variable of a type that is convertible to a numeric type, or a compile-time error
 * occurs.
 * 
 * 
 */
public class UnaryOperator {

	public static void main(String[] args) {
		new UnaryOperator().operators();
	}
	void operators(){
		postfix();
		prefix();
		unaryPlusMinus();
		bitwiseComplement();
		logicalComplement();
	}

	/**
	 * The type of the prefix decrement/increment expression is the type of the variable. The result of the prefix decrement expression is
	 * not a variable, but a value.
	 */
	void postfix() {
		Double counter = 1.01d;
		System.out.println("postfix:");
		System.out.println(counter++); // post increment expression
		System.out.println(counter--); // post decrement expression
		System.out.println(-counter++);
	}
	
	void prefix() {
		int counter = 1;
		System.out.println("prefix");
		System.out.println(++counter); // pre-increment expression
		System.out.println(--counter); // pre-decrement expression
	}
	
	/**
	 * The type of the operand expression of the unary + or - operator must be a type that is convertible to a primitive numeric
	 * type, or a compile-time error occurs.
	 * 
	 * The value of the unary minus expression is the arithmetic negation of the promoted value of the operand.
	 * 
	 */
	void unaryPlusMinus() {
		int i = 0;
		float f = 0.0f;
		System.out.println("unaryPlusMinus:");
		System.out.println(+i);
		System.out.println(-i);
		System.out.println(+f);
		System.out.println(-f);
		
	}
	
	/**
	 * The value of the unary bitwise complement expression is the bitwise complement of the promoted value of the operand. In all
	 * cases, ~x equals (-x)-1.
	 */
	void bitwiseComplement() {
		int i = 2;
		System.out.println("bitwiseComplement");
		System.out.println(-2 -1 );
		System.out.println(~i );
	}
	
	/**
	 * The type of the operand expression of the unary ! operator must be boolean or Boolean, or a compile-time error occurs.
	 * 
	 * The type of the unary logical complement expression is boolean.
	 */
	void logicalComplement() {
		Boolean flag = false;
		System.out.println("logicalComplement");
		System.out.println(!flag);
	}

}
