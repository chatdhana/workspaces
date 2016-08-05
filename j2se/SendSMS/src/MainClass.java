import java.io.IOException;

import com.service.sms.SMS;

public class MainClass {
	public static void main(String[] args) {
		try {
			SMS.send("9994783317", "dhanav", "9994783317", "hhi..");
			System.out.println("");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
