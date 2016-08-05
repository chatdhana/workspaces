package B_Character;

import java.io.UnsupportedEncodingException;

/**
 * When translating between char sequences and byte sequences, you can and usually should specify a charset explicitly
 * 
 */
public class StringCheese {
	public static void main(String args[]) {
		byte bytes[] = new byte[256];
		for (int i = 0; i < 256; i++)
			bytes[i] = (byte) i;
		String str = null;
		try {
			// str = new String(bytes);
			str = new String(bytes, "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		for (int i = 0, n = str.length(); i < n; i++)
			System.out.print((int) str.charAt(i) + " ");
	}
}
