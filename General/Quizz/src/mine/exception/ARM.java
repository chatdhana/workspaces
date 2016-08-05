package mine.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Automatic Resource management (ARM) by using try-with-resources statement.<br>
 * <br>
 * 
 * 
 * The try-with-resources statement is a try statement that declares one or more
 * resources. A resource is an object that must be closed after the program is
 * finished with it. <br>
 * <br>
 * 
 * The try-with-resources statement ensures that each resource is closed at the
 * end of the statement. Any object that implements java.lang.AutoCloseable,
 * which includes all objects which implement java.io.Closeable, can be used as
 * a resource
 * 
 * 
 */
public class ARM {

	public static void main(String[] args) {
		try {
			new ARM().writeToFileWithAutoClose("./io/ARM.txt");
			System.out.println("done");
		} catch (Throwable t) {
			System.err.println("Exception Occured....");
			Throwable[] suppressedExcArr = t.getSuppressed();
			if(suppressedExcArr.length>0) {
				System.out.println("Suppressed Exceptions....");
				for(Throwable suppExc : suppressedExcArr){
					suppExc.printStackTrace();
				}
			}
			t.printStackTrace();
		}
	}

	void writeToFile(String name) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(new File(name));
			out.write(Byte.valueOf("Without ARM"));

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	void writeToFileWithAutoClose(String name) throws Exception{
		try (FileOutputStream out = new FileOutputStream(new File(name));) {
			System.out.println(out.getFD().toString());
			out.write(Byte.valueOf("1"));
		} /*catch (NumberFormatException e) {
			System.err.println("Exception Caught at Catch Block...");
			e.printStackTrace();
		}*/ finally {
		}

	}
}
