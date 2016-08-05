package mine.mine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test2 {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("key1", "Value1");
		props.put("key2", "Value2");
		try {
			props.storeToXML(new FileOutputStream(new File("./xmlFile.xml")), "storeToXML");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
