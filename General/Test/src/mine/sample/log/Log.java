package mine.sample.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
	private static Logger logger = LoggerFactory.getLogger(Log.class);
	public static void main(String[] args) {
		logger.trace("trace...");
		logger.error("error...");
	}
}
