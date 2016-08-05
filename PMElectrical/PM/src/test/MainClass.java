package test;

import org.apache.log4j.Logger;

import com.pm.common.Log;

public class MainClass{

	/**
	 * @param args
	 */
	static Logger log = Logger.getLogger(MainClass.class);

	public static void main(String[] args) {
		Log.initLogger();
		Log.log("fatal msg", 1);
		log.fatal("dhana");

		Log.log("debug msg", 5);

	}

}
