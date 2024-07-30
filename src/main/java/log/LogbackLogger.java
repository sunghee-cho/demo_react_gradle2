package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LogbackLogger {
private static Logger logger = LoggerFactory.getLogger(LogbackLogger.class);

void method() {
logger.trace("Trace");
logger.debug("Debug");
logger.info("Info");
logger.warn("Warn");
logger.error("Error");
}

public static void main(String args[]) {
	new LogbackLogger().method();
}
}

