package A_Expressive;

/**
 * When working with large numbers, watch out for overflow—it's a silent killer.
 */
public class LongDivision {
	public static void main(String[] args) {

		/*
		// Problem 
		final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
		final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;*/
		
		// Solution
		final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
		final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;

		System.out.println(MICROS_PER_DAY + "/" + MILLIS_PER_DAY + "=" + MICROS_PER_DAY / MILLIS_PER_DAY);
	}
}
