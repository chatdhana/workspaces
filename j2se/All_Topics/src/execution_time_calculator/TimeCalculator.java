package execution_time_calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TimeCalculator {
	static long start_time;

	public static void main(String[] args) throws IOException,
			InterruptedException {
		String classPath = "C:/Documents and Settings/dgovindan/Desktop/pro3/All_Topics/bin";
		String packageName = "loading_property";
		String className = "UsingPropertyClass";
		TimeCalculator.startTime();
		Process ps = Runtime.getRuntime().exec(
				new String[] { "java", "-cp", classPath,
						packageName + "." + className });
		ps.waitFor();
		TimeCalculator.endTime();
		BufferedReader output = new BufferedReader(new InputStreamReader(ps
				.getInputStream()));
		BufferedReader error = new BufferedReader(new InputStreamReader(ps
				.getErrorStream()));

		String line = null;
		if (ps.exitValue() == 0) {
			System.out.println("Output:");
			while ((line = output.readLine()) != null) {
				System.out.println(line);
			}
		} else {
			line = null;
			System.out.println("Error:");
			while ((line = error.readLine()) != null) {
				System.out.println(line);
			}
		}
		output.close();
		error.close();
		
	}

	public static void startTime() {
		start_time = System.currentTimeMillis();
	}

	public static void endTime() {
		DecimalFormat df = new DecimalFormat("##");
		long end_time = System.currentTimeMillis();
		float t = end_time - start_time;
		float sec = (float) Math.floor(t / 1000);
		float mSec = t % 1000;
		float min = 0, minTemp = 0, hr = 0;
		minTemp = (float) Math.floor(sec / 60);
		sec = sec % 60;
		min = minTemp % 60;
		hr = (float) Math.floor(minTemp / 60);
		System.out.println("This application took " + df.format(hr)
				+ " Hour(s); " + df.format(min) + " Minute(s); "
				+ df.format(sec) + " Second(s); " + df.format(mSec)
				+ " Milliseconds.");
		System.out
		.println("****************************************************************************");

	}

}
