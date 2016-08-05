package mine.blocksandstatements;

public class DanglingElse {
	public static void main(String[] args) {
		if (0 == 0)
			if (1 == 0)
				System.out.println("Inner if");
		else
			System.out.println("Dangling Else");
	}

}
