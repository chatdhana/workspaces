package potential_programming_problems;

public class FinallyDoesntCompleteNormally {

	public static void main(String[] args) {
		System.out.println(new FinallyDoesntCompleteNormally().testFinally());
	}

	int testFinally() {
		try {
			int y = 1 / 0;
			System.out.println("y:" + y);
			return 4;
		} catch (Exception e) {
			System.out.println("Error");
			return 1;
		} finally {
			// finally block does not complete normally
			return 2;
		}
	}
}
