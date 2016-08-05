package mine.general;


public class Operators {

	public static void main(String[] args) {
		new Operators().operators();
	}

	void operators() {
		castOperator();
		multiplicativeOperator();
		additiveOperator();
		shiftOperator();
		relationalOperator();
		equalityOperator();
		integerBitwiseOperator();
		booleanLogicalOperator();
		conditionalOperator();
	}

	/**
	 * A cast expression converts, at run-time, a value of one numeric type to a similar value of another numeric type; or
	 * confirms, at compile-time, that the type of an expression is boolean; or checks, at run-time, that a reference value refers
	 * to an object whose class is compatible with a specified reference type.
	 * 
	 * The parentheses and the type they contain are sometimes called the cast operator.
	 * 
	 * A ClassCastException is thrown if a cast is found at run-time to be impermissible.
	 * 
	 */
	void castOperator() {
		OperatorsSub sub = new OperatorsSub();
		System.out.println("castOperator");
		System.out.println("sub:" + sub);
		System.out.println("(Number) sub:" + (Operators) sub);

		
	}
	
	/**
	 * The operators *, /, and % are called the multiplicative operators.
	 * 
	 * The multiplicative operators have the same precedence and are syntactically left associative (they group left-to-right).
	 * 
	 * The type of each of the operands of a multiplicative operator must be a type that is convertible to a primitive numeric
	 * type, or a compile-time error occurs.
	 * 
	 * Binary numeric promotion is performed on the operands.
	 * 
	 * The type of a multiplicative expression is the promoted type of its operands.
	 * 
	 * If the promoted type is int or long, then integer arithmetic is performed.
	 * 
	 * If the promoted type is float or double, then floating-point arithmetic is performed.
	 * 
	 * 
	 */
	void multiplicativeOperator() {
		multiplicationOperator();
		divisionOperator();
		remainderOperator();
	}

	/**
	 * Despite the fact that overflow, underflow, or loss of information may occur, evaluation of a multiplication operator *
	 * never throws a runtime exception.
	 */
	void multiplicationOperator() {
		System.out.println( 1 * 2);
	}

	/**
	 * The binary / operator performs division, producing the quotient of its operands. The left-hand operand is the dividend and
	 * the right-hand operand is the divisor.
	 */
	void divisionOperator() {
		System.out.println( 1 / 2);
		//System.out.println( 1 / 0); // java.lang.ArithmeticException: / by zero
		System.out.println(1.0 / 0.0);
		System.out.println(- 1.0 / 0.0);
		System.out.println(0.0 / 0.0);
	}

	/**
	 * The binary % operator is said to yield the remainder of its operands from an implied division; the left-hand operand is the
	 * dividend and the right-hand operand is the divisor.
	 */
	void remainderOperator() {
		System.out.println( 1 % 2);
		// System.out.println( 1 % 0); //  java.lang.ArithmeticException: / by zero
	}
	
	/**
	 * The operators + and - are called the additive operators.
	 * 
	 * The additive operators have the same precedence and are syntactically left associative (they group left-to-right).
	 * 
	 * The binary + operator performs addition when applied to two operands of numeric type, producing the sum of the operands.
	 * 
	 * The binary - operator performs subtraction, producing the difference of two numeric operands.
	 * 
	 */
	void additiveOperator() {
		// + String concatenation operator
		System.out.println(1 + 1 + "+String"); // 2+String
		System.out.println("String+" + 1 + 1); // String+11
		System.out.println("String+" + (1 + 1)); // String+2
		
		// + and - Additive operators for numeric types.
		
		System.out.println(1 + 1);
		
		/**
		 * The binary - operator performs subtraction when applied to two operands of numeric type, producing the difference of
		 * its operands; the left-hand operand is the minuend and the right-hand operand is the subtrahend.
		 * 
		 * For both integer and floating-point subtraction, it is always the case that a-b produces the same result as a+(-b).
		 * 
		 * Note that, for integer values, subtraction from zero is the same as negation. However, for floating-point operands,
		 * subtraction from zero is not the same as negation, because if x is +0.0, then 0.0-x is +0.0, but -x is -0.0.
		 */
		
		System.out.println("0 - 1:"+ (0 - 1)); // -1
		System.out.println("0.0 - 1.0:"+ (0.0 - 1.0));  // -1.0
		System.out.println("0 - 0:"+ (0 - 0));  // -1.0
		System.out.println("0.0 - 0.0:"+ (0.0 - 0.0));  // -1.0
	}

	/**
	 * The operators << (left shift), >> (signed right shift), and >>> (unsigned right shift) are called the shift operators.
	 * 
	 * The left-hand operand of a shift operator is the value to be shifted; the right-hand operand specifies the shift distance.
	 * 
	 * The shift operators are syntactically left-associative (they group left-to-right).
	 * 
	 * Unary numeric promotion is performed on each operand SEPARATELY.
	 * 
	 * It is a compile-time error if the type of each of the operands of a shift operator, after unary numeric promotion, is not a
	 * PRIMITIVE INTEGRAL type (int or long).
	 * 
	 * The type of the shift expression is the promoted type of the left-hand operand.
	 * 
	 * If left hand operand is:
	 * 
	 *  int 
	 *  	--> 5 lowest-order bits of right-hand operand are used as shift distance (2^5) .
	 *  	--> subjected to a bitwise logical AND operator & with the mask value 0x1f (0b11111).
	 *  	--> shift distance ranges from 0 to 31.
	 *  	--> bit count of max value of int type is 31.
	 *  long
	 *  	--> 6 lowest-order bits of right-hand operand are used as shift distance (2^6) .
	 *  	--> subjected to a bitwise logical AND operator & with the mask value 0x3f (0b111111).
	 *  	--> shift distance ranges from 0 to 63.
	 *		--> bit count of max value of long type is 63.
	 *  
	 */
	void shiftOperator() {
		leftshiftOperator();
		rightshiftSignedOperator();
		rightshiftUnSignedOperator();
	}

	/**
	 * Left Shift operator (<<).
	 * 
	 * The value of n << s is n left-shifted s bit positions; this is equivalent (even if overflow occurs) to multiplication by
	 * two to the power s.
	 * 
	 * 	n << s --> n * 2^s
	 * 
	 *  Excess bits shifted off to the left are discarded and 0 bits are filled at right end.
	 */
	void leftshiftOperator(){
		int intShiftval = 3;
		System.out.println("n << s --> n * 2^s");
		System.out.println("3 << 4 : "+ (intShiftval << 4));
		System.out.println("3 * 2^4 : "+ (3 * (int)Math.pow(2, 4)));
		System.out.println("3 << 4 --> 3 * 2^4 : "+ (intShiftval << 4));
		System.out.println("toBinaryString(intShiftval) :" + Integer.toBinaryString(intShiftval));
		System.out.println("toBinaryString(4) :" + Integer.toBinaryString(4));
		System.out.println("toBinaryString(Integer.MIN_VALUE) :" + Integer.toBinaryString(Integer.MIN_VALUE));
		System.out.println("toBinaryString(Integer.MAX_VALUE) :" + Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println("Integer.bitCount(Integer.MAX_VALUE) :" + Integer.bitCount(Integer.MAX_VALUE));
		
		
		System.out.println("intShiftval << 31: "+ (intShiftval << 31));
		System.out.println("intShiftval << 0: "+ (intShiftval << 0)); 
		System.out.println("intShiftval << 32: "+ (intShiftval << 32)); // distance 32 is considered as 0, and 33 is as 1,..
		
		long longShiftval = 3;
		System.out.println("longShiftval << 63: "+ (longShiftval << 63));
		System.out.println("longShiftval << 64: "+ (longShiftval << 64)); // distance 64 is considered as 0, and 65 is as 1,..
		
	}
	
	/**
	 * Signed Right Shift operator (>>).
	 * 
	 * The value of n >> s is n right-shifted s bit positions with sign-extension. The resulting value is ⌊ n / 2^s ⌋. For
	 * non-negative values of n, this is equivalent to truncating integer division, as computed by the integer division operator
	 * /, by two to the power s.
	 * 
	 * * For Negative Value: n >> s --> ⌊ n / 2^s ⌋
 	 * * For Non-Negative Value: n >> s --> n / 2^s
 	 * 
 	 * 	Excess bits shifted off to the right are discarded and copies of the left most bits are filled at left end.
 	 * 		
 	 * 	Retains sign bit.
	 */
	void rightshiftSignedOperator(){
		int intShiftValNonNeg = 16;
		int intShiftValNeg = -16;
		
		System.out.println("For Non-Negative: n >> s --> n / 2^s");
		System.out.println("16 >> 2 : "+ (intShiftValNonNeg >> 2));
		System.out.println("16 / 2^2 : "+ (16 / (int)Math.pow(2, 2)));
		System.out.println("16 >> 2 --> 16 / 2^2 : "+ (intShiftValNonNeg >> 2));
		System.out.println("toBinaryString(intShiftvalNonNeg) :" + Integer.toBinaryString(intShiftValNonNeg));
		System.out.println("toBinaryString(2) :" + Integer.toBinaryString(2));
		
		System.out.println("For Negative: n >> s --> ⌊ n / 2^s ⌋");
		System.out.println("-16 >> 2 : "+ (intShiftValNeg >> 2));
		System.out.println("-16 / 2^2 : "+ (-16 / (int)Math.pow(2, 2)));
		System.out.println("-16 >> 2 --> -16 / 2^2 : "+ (intShiftValNeg >> 2));
		System.out.println("toBinaryString(intShiftValNeg) :" + Integer.toBinaryString(intShiftValNeg));
		System.out.println("toBinaryString(2) :" + Integer.toBinaryString(2));
	}
	
	/**
	 * Unsigned Right Shift operator (>>>).
	 * 
	 * The value of n >>> s is n right-shifted s bit positions with zero-extension.
	 * 
	 * * For Negative Value: n >>> s --> (n >> s) + (2 << ~s) or (n >> s) + (2L << ~s).
 	 * * For Non-Negative Value: n >>> s --> n / 2^s --> same as '>>'
	 * 
	 * The added term (2 << ~s) or (2L << ~s) cancels out the propagated sign bit.
	 * 
	 *	Excess bits shifted off to the right are discarded and 0 bits are filled at left end.
	 */
	void rightshiftUnSignedOperator() {
		int intShiftValNeg = -16;
		
		System.out.println("For Negative: n >>> s --> (n >> s) + (2 << ~s)");
		System.out.println("-16 >>> 2 : "+ (intShiftValNeg >>> 2));
		System.out.println("toBinaryString(intShiftValNeg) :" + Integer.toBinaryString(intShiftValNeg));
		System.out.println("toBinaryString(2) :" + Integer.toBinaryString(2));
	}
	
	/**
	 * The numerical comparison operators <, >, <=, and >=, and the instanceof operator, are called the relational operators.
	 * 
	 * Numerical Comparison Operators : <, <=, >, and >=
	 * 
	 * Type Comparison Operator : instanceof
	 * 
	 * * If either operand is NaN, then the result is false.
	 * 
	 * * Positive zero and negative zero are considered equal.
	 * 
	 * * -0.0<0.0 is false, but -0.0<=0.0 is true; however the methods Math.min and Math.max treat negative zero as being strictly
	 * smaller than positive zero.
	 * 
	 * Operand of the instanceof operator must be a reference type or the null type; otherwise, a compile-time error occurs.
	 * 
	 * --> RelationalExpression instanceof ReferenceType
	 * 
	 * At run-time, the result of the instanceof operator is true if the value of the RelationalExpression is not null and the
	 * reference could be cast to the ReferenceType without raising a ClassCastException. Otherwise the result is false.
	 * 
	 * 
	 */
	void relationalOperator() {
		Integer x =10;
		long y =10;
		float z =10.0f;
		System.out.println("relationalOperator");
		if (x < z || y > z || x <= z || y >= z) {
			System.out.println("x < z || y > z || x <= z || y >= z");
		}
		System.out.println("(null instanceof Integer): "+ (null instanceof Integer));
	}
	
	/**
	 * The operators == (equal to) and != (not equal to) are called the equality operators.
	 * 
	 * The equality operators are syntactically left-associative (they group left-to-right).
	 * 
	 * The equality operators may be used to compare two operands that are
	 * 
	 * 1) convertible to numeric type, or
	 * 
	 * 2) two operands of type boolean or Boolean, or
	 * 
	 * 3) two operands that are each of either reference type or the null type.
	 * 
	 * . All other cases result in a compile-time error.
	 * 
	 * The type of an equality expression is always boolean.
	 * 
	 * In all cases, a!=b produces the same result as !(a==b).
	 * 
	 * 
	 */
	void equalityOperator() {
		booelanEqualityOperator();
		numericEqualityOperator();
		referenceEqualityOperator();
	}
	
	void booelanEqualityOperator() {
		Boolean b1Obj = new Boolean(true);
		Boolean b2Obj = new Boolean(true);
		Boolean b1ObjLit = true;
		Boolean b2ObjLit = true;
		boolean b = true;
		System.out.println("Booelan EqualityOperator");
		System.out.println("b1Obj==b2Obj:" + (b1Obj == b2Obj)); // false
		System.out.println("b1ObjLit==b2ObjLit:" + (b1ObjLit == b2ObjLit)); // true
		System.out.println("b==b2Obj:" + (b == b2Obj)); // true

	}
	
	void numericEqualityOperator() {
		int i = 1;
		Integer iObj = new Integer(1);
		Integer jObj = new Integer(1);
		
		System.out.println("Numeric EqualityOperator");
		System.out.println("-0.0==0.0:" + (-0.0==0.0)); // true
		System.out.println("i==iObj:" + (i==iObj)); // true
		System.out.println("iObj==jObj:" + (iObj==jObj)); // false
		
	}

	void referenceEqualityOperator() {
		String str1Lit = "String Literal";
		String str2Lit = "String Literal";
		Boolean b1Obj = new Boolean(true);
		Boolean b2Obj = new Boolean(true);
		
		System.out.println("Reference EqualityOperator");
		System.out.println("str1Lit==str2Lit:" + str1Lit == str2Lit); // false
		System.out.println("(str1Lit==str2Lit):" + (str1Lit == str2Lit)); // true
		System.out.println("(b1Obj==str2Lit):" + b1Obj == str2Lit); // false
		
	}
	
	/**
	 * The bitwise operators and logical operators include:
	 * 
	 * AND operator - &,
	 * 
	 * exclusive OR operator - ^,
	 * 
	 * and inclusive OR operator - |
	 * 
	 * 
	 * These operators have different precedence, with & having the highest precedence and | the lowest precedence.
	 * 
	 * Each of these operators is syntactically left-associative (each groups left-to-right).
	 * 
	 * The bitwise and logical operators may be used to compare two operands of numeric type or two operands of type boolean.
	 * 
	 */
	void integerBitwiseOperator() {
		long l1 = 7;
		int i1 = 1;
		System.out.println("IntegerBitwiseOperator");
		System.out.println("l1 & i1:" + (l1&i1)); // 1
		System.out.println("l1 ^ i1:" + (l1^i1)); // 6
		System.out.println("l1 | i1:" + (l1|i1)); // 7
		System.out.println((l1 | i1 ^ l1 & i1)); // 0111 | 0001 ^ 0111 & 0001 ==> 7
	}

	/**
	 * 
	 */
	void booleanLogicalOperator() {
		Boolean b1Obj = true;
		boolean b1 = false;
		System.out.println("booleanLogicalOperator:");
		System.out.println("b1 & b1Obj:" + (b1 & b1Obj)); // false
		System.out.println("b1 ^ b1Obj:" + (b1 ^ b1Obj)); // true
		System.out.println("b1 | b1Obj:" + (b1 | b1Obj)); // true
		System.out.println(b1Obj | b1 ^ b1Obj & b1); // true
		System.out.println(retBoolean(1) | retBoolean(2) ^ retBoolean(3) & retBoolean(4)); // true
	}
	
	boolean retBoolean(int order){
		System.out.println("Calling Order:"+order+"|" +(order%2 == 0));
		return order%2 == 0;
	}
	
	/**
	 * Conditional-And Operator &&
	 * 
	 * The conditional-and operator && is like &, but evaluates its right-hand operand only if the value of its left-hand operand
	 * is true.
	 */
	void conditionalANDOperator() {

	}

	/**
	 * Conditional-Or Operator ||
	 * 
	 * The conditional-or operator || operator is like |, but evaluates its righ-thand operand only if the value of its left-hand
	 * operand is false.
	 */
	void conditionalOROperator() {

	}
	
	/**
	 * The ternary conditional operator ? :
	 * 
	 * The conditional operator ? : uses the boolean value of one expression to decide which of two other expressions should be
	 * evaluated.
	 * 
	 * The conditional operator is syntactically RIGHT-associative (it groups right-to-left). Thus, a?b:c?d:e?f:g means the same
	 * as a?b:(c?d:(e?f:g)).
	 * 
	 * 
	 * The conditional operator has three operand expressions. ? appears between the first and second expressions, and : appears
	 * between the second and third expressions.
	 * 
	 * The first expression must be of type boolean or Boolean, or a compile-time error occurs.
	 * 
	 * It is a compile-time error for either the second or the third operand expression to be an invocation of a void method.
	 * 
	 * 
	 */
	void conditionalOperator() {
		
		System.out.println("conditionalOperator");
		System.out.println(retBoolean(1)?retBoolean(2):retBoolean(3));
		System.out.println(retBoolean(1)?retBoolean(2):retBoolean(3)?retBoolean(4):retBoolean(5)?retBoolean(6):retBoolean(7));
		System.out.println(retBoolean(1)?retBoolean(2):(retBoolean(3)?retBoolean(4):(retBoolean(5)?retBoolean(6):retBoolean(7))));
	}
}

class OperatorsSub extends Operators{
	
}
