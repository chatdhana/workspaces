package mine.general;

public class StringConstant {
	public static String s1 = "Str12";

	public static void main(String[] args) {
		System.out.println(s1 == StringConstant2.s1);
		System.out.println(s1 == new String("Str1").intern());
	}
}
