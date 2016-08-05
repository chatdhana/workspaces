package mine.json.jackson.streaming;

import java.math.BigDecimal;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", DateFormatSymbols.getInstance());
		String date1 = "2014-06-05 12:15:34.999991";
		String date2 = "2014-06-05 12:15:34.999990";

		long dateFormatted1 = format.parse(date1.substring(0, date1.lastIndexOf('.') - 1)).getTime();
		long dateFormatted2 = format.parse(date2.substring(0, date2.lastIndexOf('.') - 1)).getTime();
		BigDecimal bd1 = new BigDecimal(dateFormatted1 + ".988632");
		BigDecimal bd2 = new BigDecimal(dateFormatted2 + ".899632");
		System.out.println(bd1.compareTo(bd2));

	}

}
