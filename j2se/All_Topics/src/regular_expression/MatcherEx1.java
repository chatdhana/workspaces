package regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherEx1 {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("dhana");
		Matcher matcher = pattern.matcher("dhananjayan");
		System.out.println(matcher.matches()); //Attempts to match the entire region against the pattern. 
		System.out.println(matcher.find()); //Attempts to find the next subsequence of the input sequence that matc1hes the pattern. 
		System.out.println(matcher.lookingAt()); //Attempts to match the input sequence, starting at the beginning of the region, against the pattern. 

	}
}
