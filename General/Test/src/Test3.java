import java.util.ArrayList;
import java.util.List;

public class Test3 {

	{
		System.out.println("SB1");
		main(null);
	}

	{
		System.out.println("SB2");
		main(new String[] { "X" });
	}

	{
		main(null);
		System.out.println("SB3");
	}

	static final boolean X = true;

	public Test3(String x) {
		System.out.println("CONS1");
		List<String> strList = new ArrayList<>();
		strList.add("X");
		String str = strList.get(0);
	}
	
	public Test3(String x, String y) {
		System.out.println("CONS2");
	}

	public static void main(String[] args) {

		if (X) {
			System.out.println("Excluded part.");
		} else {
			System.out.println("Included part.");
		}
	}

}
