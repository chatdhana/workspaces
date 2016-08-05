package pattern.decorator.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LowerCaseInputStream lowerCaseIO = null;
		try {
			lowerCaseIO = new LowerCaseInputStream(new FileInputStream(
					new File("./src/pattern/decorator/java/io/IOUtil.java")));
			int c = -1;
			while ((c = lowerCaseIO.read()) > -1) {
				System.out.println((char) c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				lowerCaseIO.close();
			} catch (IOException e) {
			}
		}

	}

}
