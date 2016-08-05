package B_Character;

import java.io.File;
import java.util.regex.Matcher;

/**
 * Be careful when using unfamiliar library methods.
 */
public class MeToo {
	public static void main(String[] args) {
		System.out.println(MeToo.class.getName().replaceAll("\\.", File.separator) + ".class");
		// System.out.println(MeToo.class.getName().replaceAll("\\.", "\\") + ".class");

		// Solution 1 : Matcher.quoteReplacement()
		System.out.println(MeToo.class.getName().replaceAll("\\.", Matcher.quoteReplacement("\\")) + ".class");

		// Solution 2 : replace()
		System.out.println(MeToo.class.getName().replace(".", "\\") + ".class");

		// Solution 3 (for Java version < 5.0) : replace()
		System.out.println(MeToo.class.getName().replace('.', '\\'/* File.separatorChar */) + ".class");

	}
}
