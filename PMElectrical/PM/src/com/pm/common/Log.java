package com.pm.common;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log {

	private static Logger log = null;

	public static void initLogger() {
		log = Logger.getLogger("MyApp");
	}

	public static void setLogLevel(int level) {

		switch (level) {
		case 0:
			log.setLevel(Level.OFF);
			break;
		case 1:
			log.setLevel(Level.FATAL);
			break;
		case 2:
			log.setLevel(Level.ERROR);
			break;
		case 3:
			log.setLevel(Level.WARN);
			break;
		case 4:
			log.setLevel(Level.INFO);
			break;
		case 5:
			log.setLevel(Level.DEBUG);
			break;
		case 6:
			log.setLevel(Level.ALL);
			break;
		default:
			log.setLevel(Level.ALL);

		}

	}

	public static Logger getLogger() {
		return log;
	}

	/**
	 * 
	 * @param msg
	 *            The message you want to log.
	 */
	public static void log(Object msg) {

		/*
		 * Currently we are logging the messages in debug level if specofoed
		 * level is not in a range
		 */
		log.debug(msg);
	}

	/**
	 * 
	 * @param msg
	 *            The message you want to log.
	 * @param level
	 *            Level value can be 1 to 5 [ 1-Fatal 2-Error 3-Warn 4-Info
	 *            5-Debug ]
	 * 
	 */
	public static void log(Object msg, int level) {
		switch (level) {
		case 1:
			log.fatal(msg);
			break;
		case 2:
			log.error(msg);
			break;
		case 3:
			log.warn(msg);
			break;
		case 4:
			log.info(msg);
			break;
		case 5:
			log.debug(msg);
			break;
		default:
			System.out.println("The value for level should be 1 - 5");
			/*
			 * Currently we are logging the messages in debug level if specofoed
			 * level is not in a range
			 */
			log.debug(msg);
		}

	}

	/**
	 * 
	 * @param msg
	 *            The message you want to log.
	 * @param t
	 *            The stack trace of the java exception or error you want to
	 *            log.
	 * @param level
	 *            Level value can be 1 to 5 [ 1-Fatal 2-Error 3-Warn 4-Info
	 *            5-Debug ]
	 */

	public static void log(Object msg, Throwable t, int level) {

		switch (level) {
		case 1:
			log.fatal(msg, t);
			break;
		case 2:
			log.error(msg, t);
			break;
		case 3:
			log.warn(msg, t);
			break;
		case 4:
			log.info(msg, t);
			break;
		case 5:
			log.debug(msg, t);
			break;
		default:
			System.out.println("The value for level should be 1 - 5");
			/*
			 * Currently we are logging the messages in debug level if specofoed
			 * level is not in a range
			 */
			log.debug(msg, t);
		}
	}

}
