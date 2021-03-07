import loggers.CustomLogger;

import java.util.Scanner;

/**
 * This program create outer Cache which can store inside n-size inner Caches.
 * Outer Cache key is String because it's immutable object.
 * Inner Caches key - String, value - Object.
 * tests.User through scanner select one lifecycle which will set to all created Caches
 */
public class StartProgram {
    static Scanner scanner;
    private static Integer cacheLifeCycle;

    public static void main(String[] args) {
        CustomLogger.logDebug("Program start");

        selectLifeCycle();

        init();

        CustomLogger.logDebug("Program end");

    }

    /**
     * In this method user selects through scanner number in MINUTES.
     * Scanner initializing with stream input accept String data.
     * Trying to wrap a string in integer with catch NumberFormatException.
     *
     * If user input scanner not only numbers then will throw exception which will catch
     * and set @result - true which will cause to repeat cycle 'do' and user will input data again.
     *
     * If user input only numbers but his range will be less then 1 and more then 100 then
     * set @result - true which will cause to repeat cycle 'do' and user will input data again.
     *
     * If all conditions done then at end @cacheLifeCycle - will set number in checked range and cycle will end.
     *
     * @throws NumberFormatException - cause if Integer will try wrap String to value
     */
    private static void selectLifeCycle() {

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

    /**
     * In this method was made tests that program work fine.
     * Creates two inner Caches, put there some values and try to get them.
     * Delete Some Cache and delete All Caches.
     * When program end stop scanner
     */
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
