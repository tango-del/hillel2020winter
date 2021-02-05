import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    static Logger loggerDebug = LoggerFactory.getLogger("logger.debug");
    static Logger loggerWarn = LoggerFactory.getLogger("logger.warn");
    static Logger loggerInfo = LoggerFactory.getLogger("logger.info");
    static Logger loggerError = LoggerFactory.getLogger("logger.error");

    public static void main(String[] args) throws NullPointerException {
        int[] a = null;
//        for (int i = 0; i < 10; i++) {
//            loggerDebug.debug(String.valueOf(Math.random() * 100));
//            loggerInfo.info("info current i -> " + i);
//            if (i < 25) {
//                loggerWarn.warn("warn current i -> " + i);
//            } else {
//                loggerError.error("error current i -> " + i);
//            }
//            try {
//                if (i == 36) {
//                    System.out.println(a[0]);
//                }
//            } catch (NullPointerException e) {
//                loggerError.error(e.getMessage());
//                e.printStackTrace();
//                break;
        loggerDebug.debug("debug message");
        loggerInfo.info("info message");
        loggerWarn.warn("warn message");
        loggerError.error("error message");
    }
}
