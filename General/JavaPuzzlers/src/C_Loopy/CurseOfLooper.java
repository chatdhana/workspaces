package C_Loopy;

public class CurseOfLooper {
	public static void main(String[] args) {
		System.out.println("Started...");
		// Place your declarations for i and j here
		Integer i = -1;
		Integer j = new Integer(-1);
		while (i <= j && j <= i && i != j) {
		}
		System.out.println("done");
	}
}
