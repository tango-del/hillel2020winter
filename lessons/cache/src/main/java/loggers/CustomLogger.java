package loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLogger {
    static Logger loggerDebug = LoggerFactory.getLogger("logger.debug");
    static Logger loggerError = LoggerFactory.getLogger("logger.error");
    static Logger loggerInfo = LoggerFactory.getLogger("logger.info");

    public static void logDebug(String str) {
        loggerDebug.debug(str);
    }

    public static void logInfo(String str) {
        loggerInfo.info(str);
    }

    public static void logError(String str) {
        loggerError.error(str);
    }
}
