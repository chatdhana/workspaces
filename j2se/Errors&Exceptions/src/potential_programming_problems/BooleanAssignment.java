package potential_programming_problems;

public class BooleanAssignment {
	boolean flag1 = true, flag2 = true;

	private void testBooleanAssignmnt() {
		/*
		 * Possible accidental assignment in place of a comparison. A condition
		 * expression should not be reduced to an assignment
		 */
		// Following if statement should be avoided.
		if (flag1 = flag2) {
			System.out.println("");
		}
	}

}
