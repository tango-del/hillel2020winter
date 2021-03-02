import loggers.CustomLogger;

import java.util.Scanner;

public class StartProgram {
    static Scanner scanner;

    public static void main(String[] args) {
        CustomLogger.logDebug("Program start");

        init();

        CustomLogger.logDebug("Program end");

    }

    public static void init() {

        scanner = new Scanner(System.in);
        CustomLogger.logDebug("init scanner with console output stream");


        CustomLogger.logInfo("Select cache lifecycle in minutes");
        // TODO think about check InputMisMatchException
        Integer cacheLifeCycle = scanner.nextInt();

//        String test;
//
//        boolean result = true;
//        Integer test2 = 1;
//
//        do {
//            test = scanner.nextLine();
//            try {
//                test2 = Integer.valueOf(test);
//                result = false;
//            } catch (NumberFormatException e) {
//                System.out.println("Incorrect number");
//                result = true;
//            }
//        } while (result && test2 > 0 && test2 <= 10);

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