package loading_property;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class UsingPropertyClass {

	public static void main(String[] args) throws IOException {
		System.out.print("Before modification: ");
		new UsingPropertyClass().toReadProperties();
		new UsingPropertyClass().toWriteProperties();
		System.out.print("After modification : ");
		new UsingPropertyClass().toReadProperties();

	}

	// To read from properties file
	void toReadProperties() throws IOException {
		Properties props = new Properties();
		props.load(new FileInputStream(".\\src\\propertyfile.properties"));
		System.out.println("last.accessed.time="
				+ props.getProperty("last.accessed.time"));

	}

	// To write into properties file
	void toWriteProperties() throws IOException {
		Properties props = new Properties();
		props.load(new FileInputStream(".\\src\\propertyfile.properties"));
		props.setProperty("last.accessed.time", new Date().toString());
		props.store(new FileOutputStream(".\\src\\propertyfile.properties"),
				null);

	}
}
