package mine.blocksandstatements;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Statements {

	enum WORIKING_DAYS {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
	}

	public static void main(String[] args) {
		new Statements().statements();
	}

	void statements() {
		emptyStement();
		labeledStatement();
		expressionStatements();
		ifStatement();
		assertStatements();
		switchStatement();
		whileStatement();
		doStatement();
		forStatement();
		breakStatement();
		continueStatement();
		returnStatement();
		throwStatement();
		synchronizedStatement();
		tryStatement();
		unreachableStatement();
	}

	/**
	 * An empty statement (;) does nothing.
	 * 
	 * Execution of an empty statement always completes normally.
	 */
	void emptyStement() {
		;
		;
		;
	}

	/**
	 * Statements may have label prefixes.
	 * 
	 * The Java programming language has no goto statement; identifier statement labels are used with break or continue statements
	 * appearing anywhere within the labeled statement.
	 * 
	 * A labeled statement is executed by executing the immediately contained Statement
	 * 
	 * If the statement is labeled by an Identifier and the contained Statement completes abruptly because of a break with the
	 * same Identifier, then the labeled statement completes normally. In all other cases of abrupt completion of the Statement,
	 * the labeled statement completes abruptly for the same reason
	 */
	void labeledStatement() {
		loopLabel1: while (true) {
			System.out.println("Loop1");
			loopLable2: for (int i = 1; i <= 100; i++) {
				System.out.println("Loop2");
				// loopLabel1: // Compile-time error: Duplicate label loopLabel1
				for (int j = 1;; j++) {
					if (j == 100) {
						break; // Terminates current loop.
					} else if (j == 50) {
						break loopLabel1; // Terminates the labeled loop.
					}

					if (j % i == 0) {
						continue; // skips to the next iteration of current
									// loop.
					} else if (i % j == 0) {
						continue loopLable2; // skips to the next iteration of
												// labeled loop.
					}
				}
			}
		}

		labelIdentifier: if (true) {
			System.out.println("labelIdentifier");
			break labelIdentifier;
		}

	}

	/**
	 * Expression Statements.
	 * 
	 * The expressions may be used as statements by following them with semicolons.
	 * 
	 * An expression statement is executed by evaluating the expression; if the expression has a value, the value is discarded.
	 */
	void expressionStatements() {
		int x = 0; // Assignment expression
		++x; // PreIncrement
		--x; // PreDecrement
		x++; // PostIncrement
		x--; // PostDecrement
		emptyStement(); // Method invocation
		new Statements(); // Class instance creation
	}

	/**
	 * The if statement allows conditional execution of a statement or a conditional choice of two statements, executing one or
	 * the other but not both.
	 * 
	 * The Expression must have type boolean or Boolean, or a compile-time error occurs. If the result is of type Boolean, it is
	 * subject to unboxing conversion.
	 */
	void ifStatement() {
		int x = 0;

		// If Statement
		if (x == 0)
			System.out.println("If Then Statement");

		// IfThenElseStatementNoShortIf
		if (x == 1)
			System.out.println("If Then Else Statement: The first contained Statement (then-statement)");
		else if (x == 2)
			System.out.println("If Then Else Statement: The second contained Statement (else-statemment)");
		else if (x == 3)
			System.out.println("If Then Else Statement: The third contained Statement");

		if (x == 1 && true && Boolean.TRUE) {
			System.out.println("If Then Else Statement: The first contained Statement1");
			System.out.println("If Then Else Statement: The first contained Statement2");
		} else {
			System.out.println("If Then Else Statement: The second contained Statement1");
			System.out.println("If Then Else Statement: The second contained Statement2");
		}
	}

	/**
	 * An assertion is an assert statement containing a boolean expression. An assertion is either enabled or disabled. If the
	 * assertion is enabled, execution of the assertion causes evaluation of the boolean expression and an error is reported if
	 * the expression evaluates to false. If the assertion is disabled, execution of the assertion has no effect whatsoever.
	 * 
	 * 
	 * It is a compile-time error if Expression1 does not have type boolean or Boolean. In the second form of the assert
	 * statement, it is a compile-time error if Expression2 is void.
	 * 
	 * An assert statement that is executed after its class has completed initialization is enabled if and only if the host system
	 * has determined that the top level class that lexically contains the assert statement enables assertions.
	 * 
	 * An assert statement that is executed before its class has completed initialization is enabled.
	 * 
	 * The assertion status of a class is set no later than the time it is initialized.
	 * 
	 * A disabled assert statement does nothing. In particular, neither Expression1 nor Expression2 (if it is present) are
	 * evaluated. Execution of a disabled assert statement always completes normally.
	 * 
	 */
	void assertStatements() {
		Boolean flag = Boolean.TRUE;
		assert flag : "No Problem";
		// assert !flag:"Detailed Msg";
		AssertSub.testAsserts(); // Prints 'Asserts disabled'

		/*
		 * If the value of Expression1 is true, no further action is taken and the assert statement completes normally.
		 * 
		 * If the value of Expression1 is false, the execution behavior depends on whether Expression2 is present:
		 * 
		 * If Expression2 is present, it is evaluated. If the evaluation completes abruptly for some reason, the assert statement
		 * completes abruptly for the same reason.
		 * 
		 * If the evaluation completes normally, an AssertionError instance whose "detail message" is the resulting value of
		 * Expression2 is created.
		 * 
		 * If the instance creation completes abruptly for some reason, the assert statement completes abruptly for the same
		 * reason.
		 * 
		 * If the instance creation completes normally, the assert statement completes abruptly by throwing the newly created
		 * AssertionError object.
		 * 
		 * IfExpression2 is not present, an AssertionError instance with no "detail message" is created. If the instance creation
		 * completes abruptly for some reason, the assert statement completes abruptly for the same reason. If the instance
		 * creation completes normally, the assert statement completes abruptly by throwing the newly created AssertionError
		 * object.
		 */
	}

	/**
	 * The switch statement transfers control to one of several statements depending on the value of an expression.
	 * 
	 * The body of a switch statement is known as a switch block.
	 * 
	 * The type of the Expression must be char, byte, short, int, Character, Byte, Short, Integer, String, or an enum type.
	 * 
	 * Any statement immediately contained by the switch block may be labeled with one or more switch labels, which are case or
	 * default labels.
	 * 
	 * All of the following must be true, or a compile-time error occurs:
	 * 
	 * * Every case constant expression associated with a switch statement must be assignable to the type of the switch
	 * Expression.
	 * 
	 * * No two of the case constant expressions associated with a switch statement may have the same value.
	 * 
	 * * No switch label is null.
	 * 
	 * * At most one default label may be associated with the same switch statement.
	 * 
	 * Order of case does not matter.
	 * 
	 * Execution of statements in a switch block "falls through labels". Javac/JVM doesn't report detection of Fall-Through in the
	 * switch Statement.
	 */
	void switchStatement() {
		char c = Character.MAX_VALUE;
		Byte b = Byte.MAX_VALUE;
		short s = Short.MAX_VALUE;
		Integer i = Integer.MAX_VALUE;
		String str = "STRINGVALUE";
		// enum WORIKING_DAYS {}
		switch (c) {
		case 'c':
		case 's':
		case Character.MAX_VALUE:
			System.out.println("Match Found.");
			break;
		default:
			System.out.println("SwitchDefault");
		}

		switch (str) {
		case "":
			// case "": // Compile-time error: Duplicate case
			break;
		/*
		 * case null: // 'null' not allowed. case expressions must be constant expressions. System.out.println("Null Value.");
		 * break;
		 */
		case "STRINGVALUE":
			System.out.println("SwitchLabel STRINGVALUE");
			// break; // Fall-Through in the switch Statement: if break is
			// omittrd, the code for each case falls through into the code for
			// the next case.
		default:
			System.out.println("SwitchDefault");
			break;
		/*
		 * default: // The default case is already defined System.out.println("SwitchDefault"); break;
		 */
		}

		switch (Enum.valueOf(WORIKING_DAYS.class, "MONDAY")) {
		default: // Default can be placed as first switch label. Order of case
					// does not matter.
			System.out.println("DefaultCase");
			break;
		case MONDAY:
			System.out.println("Monday");
			break;
		}

		// Execution Fall-Through
		switch (i) {
		case Integer.MAX_VALUE:
			System.out.println("Integer.MAX_VALUE:" + Integer.MAX_VALUE);
		case 1:
			System.out.println("1");
		case 2:
			System.out.println("2");
		case 3:
			System.out.println("3");
			break;
		}

	}

	/**
	 * The while statement executes an 'Expression' and a 'Statement' repeatedly until the value of the Expression is false.
	 * 
	 * The Expression must have type boolean or Boolean, or a compile-time error occurs.
	 * 
	 * A while statement is executed by first evaluating the Expression. If the result is of type Boolean, it is subject to
	 * unboxing conversion.
	 * 
	 * If evaluation of the Expression or the subsequent unboxing conversion (if any) completes abruptly for some reason, the
	 * while statement completes abruptly for the same reason.
	 * 
	 * If the value is true, then the contained Statement is executed. Then there is a choice:
	 * 
	 * If execution of the Statement completes normally, then the entire while statement is executed again, beginning by
	 * re-evaluating the Expression.
	 * 
	 * If execution of the Statement completes abruptly, If execution of the Statement completes abruptly because of a break with
	 * no label, no further action is taken and the while statement completes normally.
	 * 
	 * If execution of the Statement completes abruptly because of a continue with no label, then the entire while statement is
	 * executed again.
	 * 
	 * If execution of the Statement completes abruptly because of a continue with label L, then there is a choice:
	 * 
	 * If the while statement has label L, then the entire while statement is executed again.
	 * 
	 * If the while statement does not have label L, the while statement completes abruptly because of a continue with label L.
	 * 
	 * If execution of the Statement completes abruptly for any other reason, the while statement completes abruptly for the same
	 * reason.
	 * 
	 * If the (possibly unboxed) value of the Expression is false, no further action is taken and the while statement completes
	 * normally.
	 * 
	 */
	void whileStatement() {
		int i = 0;
		loop: while (true) {
			i++;
			if (i == 2) {
				break loop;
			}
			System.out.println("Executes Expression first and then executes contained Statement.");
		}
	}

	/**
	 * The do statement executes a 'Statement' and an 'Expression' repeatedly until the value of the expression is 'false'.
	 * 
	 * The Expression must have type boolean or Boolean, or a compile-time error occurs.
	 * 
	 * A do statement is executed by first executing the Statement. Then there is a choice:
	 * 
	 * * If execution of the Statement completes normally, then the Expression is evaluated. If the result is of type Boolean, it
	 * is subject to unboxing conversion.
	 * 
	 * ** If evaluation of the Expression or the subsequent unboxing conversion (if any) completes abruptly for some reason, the
	 * do statement completes abruptly for the same reason.
	 * 
	 * ** Otherwise, there is a choice based on the resulting value:
	 * 
	 * *** If the value is true, then the entire do statement is executed again.
	 * 
	 * *** If the value is false, no further action is taken and the do statement completes normally.
	 * 
	 * * If execution of the Statement completes abruptly,
	 * 
	 * ** If execution of the Statement completes abruptly because of a break with no label, then no further action is taken and
	 * the do statement completes normally.
	 * 
	 * ** If execution of the Statement completes abruptly because of a continue with no label, then the Expression is evaluated.
	 * Then there is a choice based on the resulting value:
	 * 
	 * *** If the value is true, then the entire do statement is executed again.
	 * 
	 * *** If the value is false, no further action is taken and the do statement completes normally.
	 * 
	 * ** If execution of the Statement completes abruptly because of a continue with label L, then there is a choice:
	 * 
	 * *** If the do statement has label L, then the Expression is evaluated. Then there is a choice:
	 * 
	 * **** If the value of the Expression is true, then the entire do statement is executed again.
	 * 
	 * **** If the value of the Expression is false, no further action is taken and the do statement completes normally.
	 * 
	 * *** If the do statement does not have label L, the do statement completes abruptly because of a continue with label L.
	 * 
	 * ** If execution of the Statement completes abruptly for any other reason, the do statement completes abruptly for the same
	 * reason.
	 * 
	 */
	void doStatement() {
		int i = 0;
		do {
			System.out.println("Executes contained statement first and then executes expression.");
			/*for(;;){
				
			}*/
		} while (++i < 2);
	}

	/**
	 * The for statement has two forms:
	 * 
	 * 1) The basic FOR statement
	 * 
	 * 2) The enhanced FOR statement
	 * 
	 */
	void forStatement() {
		basicForStatement();
		enhancedForStatement();
	}

	/**
	 * The basic FOR statement.
	 * 
	 * The basic for statement executes some initialization code, then executes an Expression, a Statement, and some update code
	 * repeatedly until the value of the Expression is false.
	 * 
	 * BasicForStatement:
	 * 
	 * for ( ForInitopt ; Expressionopt ; ForUpdateopt ) Statement
	 * 
	 * ForInit : Local Variable declaration, or Statement Expression
	 * 
	 * Expression : Any expression which results in value of type boolean.
	 * 
	 * ForUpdate : Any expression (increment/decrement operation) to be called for update for each iteration.
	 * 
	 */
	void basicForStatement() {

		for (int i = 0; i < 1; i++) {
			System.out.println("The Basic FOR statement 1.");
		}

		int i = 0;
		for (;;) {
			if (++i >= 2) {
				break;
			}
			System.out.println("The Basic FOR statement 2.");
		}

		for (emptyStement(), i = 0; i < 1; emptyStement(), i++) {
			System.out.println("The Basic FOR statement 3.");
		}
	}

	/**
	 * The Enhanced FOR statement.
	 * 
	 * EnhancedForStatement:
	 * 
	 * for ( FormalParameter : Expression ) Statement
	 * 
	 * Expression is a subtype of Iterable or Array Type,
	 * 
	 * 
	 */
	void enhancedForStatement() {

		List<? extends Integer> iterable = new ArrayList<>();
		for (Integer i : iterable) {
			System.out.println("Enhanced FOR Statement 1. " + i);
		}

		for (float f : iterable) {
			System.out.println("Enhanced FOR Statement 2. " + f);
		}

		int[] intArr = { 1 };
		for (final int i : intArr) {
			System.out.println("Enhanced FOR Statement 3. " + i);
		}

	}

	/**
	 * A break statement attempts to transfer control out of an enclosing statement.
	 * 
	 * BreakStatement:
	 * 
	 * break Identifieropt ;
	 * 
	 * * BREAK without LABEL:
	 * 
	 * A break statement with no label attempts to transfer control to the innermost enclosing switch, while, do, or for statement
	 * of the immediately enclosing method or initializer.
	 * 
	 * If no switch, while, do, or for statement in the immediately enclosing method, constructor, or initializer contains the
	 * break statement, a compile-time error occurs.
	 * 
	 * * BREAK with LABEL:
	 * 
	 * A break statement with label Identifier attempts to transfer control to the enclosing labeled statement.
	 * 
	 * In this labeled case, the break target need not be a switch, while, do, or for statement.
	 * 
	 * 
	 * A break statement must refer to a label within the immediately enclosing method, constructor, or initializer.
	 * 
	 * There are no non-local jumps. If no labeled statement with Identifier as its label in the immediately enclosing method,
	 * constructor, or initializer contains the break statement, a compile-time error occurs.
	 * 
	 * A break statement always completes abruptly.
	 * 
	 * 
	 * The preceding descriptions say "attempts to transfer control" rather than just "transfers control" because if there are any
	 * try statements within the break target whose try blocks or catch clauses contain the break statement, then any finally
	 * clauses of those try statements are executed, in order, innermost to outermost, before control is transferred to the break
	 * target. Abrupt completion of a finally clause can disrupt the transfer of control initiated by a break statement.
	 * 
	 */
	void breakStatement() {
		int x = 0;
		// Break without label

		while (true) {
			if (x++ < 1) {
				System.out.println("Break without label 1.");
				break; // Transfers control to immediately enclosing while
						// statement.
			}
		}

		// Break with Label

		labelIf: if (x > 0) {
			System.out.println("Break without label: labelIf.");
			while (true) {
				if (x++ < 1) {
					System.out.println("Break without label 2.");
					break labelIf; // Transfers control to the enclosing if
									// statement labeled labelIf.
				}
			}
		}

		// Break enclosed by try statement
		labelWhile: while (true) {
			try {
				if (x++ < 1) {
					System.out.println("Break without label 3.");
					break labelWhile; // Attempts to transfer control to the
										// enclosing while statement labeled
										// labelWhile.
				}
			} catch (Exception e) {

			} finally {
				System.out.println("Break:Executing finally block before transferring control to labled while statement");
			}
		}
	}

	/**
	 * The Continue Statement.
	 * 
	 * Ends the current iteration and begins new one.
	 * 
	 * ContinueStatement:
	 * 
	 * continue Identifieropt ;
	 * 
	 * A continue statement may occur only in a while, do, or for statement; statements of these three kinds are called iteration
	 * statements. Control passes to the loopcontinuation point of an iteration statement.
	 * 
	 * If no while, do, or for statement of the immediately enclosing method, constructor, or initializer contains the continue
	 * statement, a compile-time error occurs.
	 * 
	 * The continue target must be a while, do, or for statement, or a compile-time error occurs.
	 * 
	 * If there are any try statements within the continue target whose try blocks or catch clauses contain the continue
	 * statement, then any finally clauses of those try statements are executed, in order, innermost to outermost, before control
	 * is transferred to the continue target.
	 * 
	 * 
	 */
	void continueStatement() {

		for (int i = 0; i < 5; i++) {
			if (i % 2 == 0) {
				continue;
			}
			System.out.println("Continue without label 1. Odd Num:" + i);
		}

		int x = 0;

		labelWhile: while (true) {
			if (++x >= 2) {
				break labelWhile;
			}

			try {
				for (int i = 0;; i++) {
					if (i % 2 == 0) {
						continue;
					}
					System.out.println("Continue with label 2. Odd Num:" + i);
					continue labelWhile;
				}
			} finally {
				System.out.println("Continue:Executing finally block before transferring control to labled while statement. X:"
						+ x);
			}

		}

		labelIf: if (true) {
			labelWhile: while (++x <= 5) {
				/*
				 * Compile-time error: The continue target must be a while, do, or for statement, or a compile-time error occurs.
				 */
				// continue labelIf;

				continue labelWhile;
			}
		}

		
		labelDo: do {
			if(x%2 == 0)continue labelDo;
			System.out.println("Continue with label 3. X:"+x);
		} while (++x <= 7);
		
	}

	/**
	 * The return statement.
	 * 
	 * Transfers control to the invoker of a method or constructor.
	 * 
	 * ReturnStatement:
	 * 
	 * return Expressionopt ;
	 * 
	 * A return statement is contained in the innermost constructor, or method whose body encloses the return statement.
	 * 
	 * It is a compile-time error if a return statement is contained in an instance initializer or a static initializer.
	 * 
	 * A return statement with no Expression attempts to transfer control to the invoker of the method or constructor that
	 * contains it.
	 * 
	 * A return statement with an Expression must be contained in a method declaration that is declared to return a value, or a
	 * compile-time error occurs.
	 * 
	 * If there are any try statements within the method or constructor whose try blocks or catch clauses contain the return
	 * statement, then any finally clauses of those try statements will be executed, in order, innermost to outermost, before
	 * control is transferred to the invoker of the method or constructor.
	 * 
	 * 
	 */
	void returnStatement() {
		try {
			return;
		} finally {
			System.out.println("Return: Executing finally block.");
		}
	}

	/**
	 * The throw statement.
	 * 
	 * A throw statement causes an exception to be thrown. The result is an immediate transfer of control that may exit multiple
	 * statements and multiple constructor, instance initializer, static initializer and field initializer evaluations, and method
	 * invocations until a try statement is found that catches the thrown value. If no such try statement is found, then execution
	 * of the thread that executed the throw is terminated after invocation of the uncaughtException method for the thread group
	 * to which the thread belongs.
	 * 
	 * ThrowStatement:
	 * 
	 * throw Expression ;
	 * 
	 * The Expression in a throw statement must denote either:
	 * 
	 * 1) a variable or value of a reference type which is assignable to the type Throwable, or
	 * 
	 * 2) the null reference, or a compile-time error occurs.
	 * 
	 * 
	 * If evaluation of the Expression completes normally, producing a null value, then an instance V' of class
	 * NullPointerException is created and thrown instead of null.
	 * 
	 */
	void throwStatement() {
		
		// Throwing null reference
		try {
			throw null;
		} catch (final NullPointerException e) {
			//e.printStackTrace();
		}
		
		// Throwing a variable or value of a reference
		try {
			Throwable t = new Exception();
			throw (Exception) t;
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
	}
	
	/**
	 * The synchronized statement.
	 * 
	 * Acquires a mutual-exclusion lock on behalf of the executing thread for an object, executes a block, then releases a lock.
	 * While the executing thread owns a lock, no other thread may acquire it.
	 * 
	 * SynchronizedStatement:
	 * 
	 * synchronized ( Expression ) Block
	 * 
	 * The type of Expression must be a reference type, or a compile-time error occurs.
	 * 
	 * If the value of the Expression is null, a NullPointerException is thrown.
	 * 
	 * The locks acquired by synchronized statements are the same as the locks that are acquired implicitly by synchronized
	 * methods. 
	 * 
	 * A single thread may acquire a lock more than once, otherwise a deadlock occurs.
	 * 
	 */
	void synchronizedStatement() {

		synchronized (this) {
			synchronized (this) {
				System.out.println("Synchronized: Acquired a Lock!");
			}
		}
	}

	/**
	 * The try statement
	 * 
	 * A try statement executes a block. If a value is thrown and the try statement has one or more catch clauses that can catch
	 * it, then control will be transferred to the first such catch clause. If the try statement has a finally clause, then
	 * another block of code is executed, no matter whether the try block completes normally or abruptly, and no matter whether a
	 * catch clause is first given control.
	 * 
	 * The Block immediately after the keyword try is called the try block of the try statement.
	 * 
	 * The Block immediately after the keyword finally is called the finally block of the try statement.
	 * 
	 * A try statement may have catch clauses, called exception handlers.
	 * 
	 * A catch clause has one parameter called exception parameter, denotes a single class type or union of two class types
	 * (alternatives) separated by |.
	 * 
	 * uni-catch clause::
	 * 
	 * A catch class whose exception parameter is denoted as a single class type.
	 * 
	 * multi-catch clause:
	 * 
	 * A catch clause whose exception parameter is denoted as s union of class types.
	 * 
	 * It is a compile-time error if a type variable (T) is used in the denotation of the type of an exception parameter.
	 * 
	 * An exception parameter of a multi-catch clause is implicitly declared FINAL if it is not explicitly declared final.
	 * 
	 * In a uni-catch clause, an exception parameter that is not declared FINAL (implicitly or explicitly) is considered
	 * effectively final if it never occurs within its scope as the left-hand operand of an assignment operator.
	 * 
	 * A multi-catch clause can be thought of as a sequence of uni-catch clauses. That is, a catch clause whose exception
	 * parameter type is denoted as a union D1|D2|...|Dn is equivalent to a sequence of n catch clauses whose exception parameters
	 * have class types D1, D2, ..., Dn, respectively.
	 * 
	 * A try statement is permitted to omit catch clauses and a finally clause if it is a try-with-resources statement.
	 * 
	 * 
	 */
	<T extends Throwable> void tryStatement() {
		try {
			// try-catch
		} catch (Exception e) {
		}

		try {
			// try-catch-finally
		} catch (Exception e) { // Effectively final parameter but not by declaration.
		} catch (final Throwable e) { // Explicitly final.
		} /*catch (final T e) { // Compile-time error: Cannot use the type parameter T in a catch block.
		}*/ finally {
		}

		try {
			// try-finally
		} finally {
		}

		try (final FileInputStream fis = new FileInputStream(new File("x"));
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File("X")))) { // Resources are implicitly declared final
			
			// Basic try-with-resources : without Catch clause or finally clause.
			// Extended try-with-resources
			
			/*
			 * The type of a variable declared in a ResourceSpecification must be a subtype of AutoCloseable, or a compile-time
			 * error occurs.
			 */
			
			
			Class.forName("", true, null);
		} catch (IOException | ClassNotFoundException e) { // Implicitly final
		}

		
	}
	
	/**
	 * The UnReachable Statement.
	 * 
	 * Statement can never be executed.
	 * 
	 * It is a compile-time error if a statement cannot be executed because it is unreachable.
	 * 
	 * 
	 * 
	 */
	void unreachableStatement() {
		int x = 0;

		
		 /*while(false){ // using constant expression 'false'
		  // Compile-time error: UnReachable Code
		  }*/
		 

		if (false) { // using constant expression 'false'
			x++; // Dead Code
		}
		
		while (FLAG){ // 'conditionally compile' using variable.
			x++;
		}
		
		if(FLAG) { // 'conditionally compile' using variable.
			x++;
		}

	}
	static boolean FLAG = false;
}

class AssertSuper {
	static {
		/*
		 * An assert statement that is executed before its class has completed initialization is enabled.
		 */
		AssertSub.testAsserts(); // Prints 'Asserts enabled'
		// Will execute before AssertSub is initialized!
	}
}

class AssertSub extends AssertSuper {
	static void testAsserts() {
		boolean enabled = false;
		assert enabled = true;
		System.out.println("Asserts " + (enabled ? "enabled" : "disabled"));
	}
}

