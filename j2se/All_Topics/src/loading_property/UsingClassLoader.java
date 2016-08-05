package loading_property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UsingClassLoader {
	static InputStream is =null;
	public static void main(String[] args) throws IOException {

		new UsingClassLoader().toReadProperties();
	}

	void toReadProperties() throws IOException {

		ClassLoader cl = this.getClass().getClassLoader();
		is = cl.getResourceAsStream(".\\src\\propertyfile.properties");
		Properties props = new Properties();
		if (is != null)
			props.load(is);
		else
			System.out.println("Inputstream is not yet defined");
		System.out.println("last.accessed.time="
				+ props.getProperty("last.accessed.time"));
	}

}
