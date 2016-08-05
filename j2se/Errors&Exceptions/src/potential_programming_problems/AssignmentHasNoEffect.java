package potential_programming_problems;

public class AssignmentHasNoEffect {

	int x = 10;

	private void checkAssignmentHasNoEffect() {

		// The following assignment has no effect so it should be avoided for
		// good programming style.
		x = x;
	}
}
