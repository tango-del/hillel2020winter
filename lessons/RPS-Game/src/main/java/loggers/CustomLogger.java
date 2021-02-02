package loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLogger {
    static Logger loggerDebug = LoggerFactory.getLogger("logger.debug");
    static Logger loggerError = LoggerFactory.getLogger("logger.error");
    static Logger loggerWarn = LoggerFactory.getLogger("logger.warn");

    public static void logDebug(String str) {
        loggerDebug.debug(str);
    }

    public static void logError(String str) {
        loggerError.error(str);
    }

    public static void logWarn(String str) {
        loggerWarn.warn(str);
    }
}
