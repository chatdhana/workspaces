package assertion;

public class Assertion {

	static int i = 1;

	public static void main(String[] args) {

		new Assertion().print();
	}

	public void print() {
		/*
		 * Two forms of the assert statement 1. Usual form An assert statement
		 * has two parts separated by a colon. The boolean condition must be
		 * true for execution to continue. If it is false, an AssertionError is
		 * thrown, which terminates execution and display the message string.
		 * Some examples: assert jobQueue.size() == 0 : "process: queue should
		 * have been empty."; assert connector != null : "merge: Connector null
		 * for " + rel; When asserts are enabled, the assert statement checks
		 * the condition (queue empty, connector is not null, etc) which must be
		 * true for the program to function correctly. If it's true, execution
		 * continues. If connector is null (expression is false), an exception
		 * containing the message is thrown. This message is for the programmer,
		 * so it doesn't have to be user friendly. 2. Abbreviated form The
		 * simplest form the assert statement specifies only a boolean
		 * expression that must be true. This is ok when there's not much to
		 * say, or the likelyhood of failing seems so remote it isn't worth the
		 * extra typing: assert n > 0; Enabling assertions at runtime Assertion
		 * checking defaults to off at runtime. You should always turn them on.
		 * assert statements are removed by class loader: java MyProg assert
		 * statements are execued: java -enableassertions MyProg Short form for
		 * allowing assertions: java -ea MyProg To disable assertions at various
		 * granularities, use: java -disableassertions MyProg or java -da MyProg
		 */
		assert i == 2 : "i should always be equal to 1";

		System.out.println("print method");
		// int i=1;
		switch (i) {
		case 1:
			System.out.println("case 1");
			break;
		default:
			System.out.println("default");
		}

	}

}
