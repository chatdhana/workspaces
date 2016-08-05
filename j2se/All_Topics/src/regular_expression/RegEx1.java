package regular_expression;

import java.util.regex.Pattern;

public class RegEx1 {

	public static void main(String[] args) {
		// Create a pattern to match breaks
		Pattern pattern = Pattern.compile("[,\\s]+");
		// Split input with the pattern
		String[] result = pattern.split("one,two, three   four ,	five");
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);

	}

}
