package regular_expression;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchingFile {

	public static void main(String[] args) throws IOException {
		// Create a pattern to match comments
		Pattern p = Pattern.compile("//.*$", Pattern.MULTILINE);

		// Get a Channel for the source file
		File f = new File("./src/regular_expression/RegEx1.java");
		FileInputStream fis = new FileInputStream(f);
		FileChannel fc = fis.getChannel();

		// Get a CharBuffer from the source file
		ByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, (int) fc
				.size());
		Charset cs = Charset.forName("8859_1");
		CharsetDecoder cd = cs.newDecoder();
		CharBuffer cb = cd.decode(bb);

		// Run some matches
		Matcher m = p.matcher(cb);
		while (m.find())
			System.out.println("Found comment: " + m.group());

	}

}
