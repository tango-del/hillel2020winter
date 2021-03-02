import loggers.CustomLogger;

import java.util.Scanner;

public class StartProgram {
    static Scanner scanner;
    private static Integer cacheLifeCycle;

    public static void main(String[] args) {
        CustomLogger.logDebug("Program start");

        selectLifeCycle();

        init();

        CustomLogger.logDebug("Program end");

    }

    public static void selectLifeCycle() {

        scanner = new Scanner(System.in);
        CustomLogger.logDebug("init scanner with console output stream");


        CustomLogger.logInfo("Select all caches lifecycle between 1 - 100 minutes");

        boolean result;
        do {
            String str = scanner.next();

            try {
                cacheLifeCycle = Integer.valueOf(str);

                if (cacheLifeCycle <= 0 || cacheLifeCycle > 100) {
                    CustomLogger.logInfo("Selected number less then '0' or more then '100'");
                    result = true;

                } else {
                    result = false;
                }

            } catch (NumberFormatException e) {
                CustomLogger.logInfo("Incorrect number");
                result = true;
            }

        } while (result);
    }

    private static void init() {
        CustomCache customCache = new CustomCache(cacheLifeCycle);

        // first cache
        CustomLogger.logInfo("Select cache name");
        String cacheName1 = StartProgram.scanner.next();

        customCache.createCache(cacheName1);

        customCache.put(cacheName1, "city", "Odessa");
        customCache.put(cacheName1, "country", "Ukraine");

        CustomLogger.logInfo((String) customCache.get(cacheName1, "city"));
        CustomLogger.logInfo((String) customCache.get(cacheName1, "country"));


        // second cache
        CustomLogger.logInfo("Select cache name");
        String cacheName2 = StartProgram.scanner.next();

        customCache.createCache(cacheName2);

        customCache.put(cacheName2, "imper", "Telegram");
        customCache.put(cacheName2, "orem", "Skype");

        CustomLogger.logInfo((String) customCache.get(cacheName2, "imper"));
        CustomLogger.logInfo((String) customCache.get(cacheName2, "orem"));


        customCache.clearSomeCache(cacheName1);

        customCache.clearAllCache();


        CustomLogger.logDebug("scanner close");
        scanner.close();
    }
}
