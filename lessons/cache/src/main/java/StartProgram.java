import loggers.CustomLogger;
import spark.Spark;

import java.util.Scanner;

/**
 * This program create outer Cache which can store inside n-size inner Caches.
 * Outer Cache key is String because it's immutable object.
 * Inner Caches key - String, value - Object
 * User through scanner select one lifecycle which will set to all created Caches
 *
 * To Interact with program through SPARK API uncomment method: initSpark()
 * To Interact without SPARK and use custom cache creation use method: customCreateCache()
 *
 * All output messages - debug level 'info'
 */
public class StartProgram {
    static Scanner scanner;
    private static Integer cacheLifeCycle;

    public static void main(String[] args) {
        CustomLogger.logDebug("Program start");

        if (args.length > 0) {
            outputHelpCommands(args[0]);

        } else {
            selectLifeCycle();

            initSpark();

//        customCreateCache();
        }

        CustomLogger.logDebug("Program end");

    }

    private static void initSpark() {
        CustomCache customCache = new CustomCache(cacheLifeCycle);

        Spark.post("/create-cache/:cache-name", ((request, response) -> {

            String cacheName = request.params(":cache-name");

            if (!CustomCache.getMainCache().containsKey(cacheName)) {

                customCache.createCache(request.params(":cache-name"));
                return "Created new cache";
            } else {

                return String.format("Cache with name '%s' already exists", request.params(":cache-name"));
            }
        }));

        Spark.put("/put-value/:cache-name/:key-input/:inner-value", (request, response) -> {
            String cacheName = request.params(":cache-name");
            String cacheKey = request.params(":key-input");
            String cacheValue = request.params(":inner-value");

            if (!CustomCache.getMainCache().containsKey(cacheName)) {
                return String.format("Cache with name '%s' not found", cacheName);
            }
            customCache.put(cacheName, cacheKey, cacheValue);

            return "Added new value in inner cache";

        });

        Spark.get("/get-value/:cache-name/:cache-key", (request, response) -> {
            response.type("application/json");

            String cacheName = request.params(":cache-name");
            String cacheKey = request.params(":cache-key");

            if (!CustomCache.getMainCache().containsKey(cacheName)) {
                return String.format("Cache not found with name : '%s'", cacheName);
            }
            if (!CustomCache.getMainCache().get(cacheName).containsKey(cacheKey)) {
                return String.format("Cache with name '%s' don't have key : '%s'", cacheName, cacheKey);
            }

            return customCache.get(request.params(":cache-name"), request.params(":cache-key"));
        });

        Spark.delete("/delete-cache/:cache-name", ((request, response) -> {

            String cacheName = request.params(":cache-name");

            if (!CustomCache.getMainCache().containsKey(cacheName)) {
                return String.format("Cache with name '%s' not exists", cacheName);
            }

            customCache.clearSomeCache(cacheName);
            return String.format("Cache: '%s' - successfully deleted", cacheName);
        }));

        Spark.delete("/clear-all", ((request, response) -> {
            customCache.clearAllCache();
            return "Main Cache successfully deleted";
        }));
    }

    /**
     * In this method user selects through scanner number in MINUTES.
     * Scanner initializing with stream input accept String data.
     * Trying to wrap a string in integer with catch NumberFormatException.
     * <p>
     * If user input scanner not only numbers then will throw exception which will catch
     * and set @result - true which will cause to repeat cycle 'do' and user will input data again.
     * <p>
     * If user input only numbers but his range will be less then 1 and more then 100 then
     * set @result - true which will cause to repeat cycle 'do' and user will input data again.
     * <p>
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
     * Method output help information to interact with program through SPARK
     * @param str - expect argument "-h"
     */
    private static void outputHelpCommands(final String str) {
        CustomLogger.logDebug("Program started with key '-h' to output help message for interact with SPARK");
        if (str == null) {
            CustomLogger.logError("IllegalArgumentException: Incorrect argument message");
            throw new IllegalArgumentException("Incorrect argument message");
        }

        if (str.equalsIgnoreCase("-h")) {
            StringBuilder output = new StringBuilder();
            output.append("Help commands to interact with SPARK methods:").append(System.lineSeparator());
            output.append(">>>POST<<< request:").append(System.lineSeparator());
            output.append("http://localhost:4567/create-cache/{cache-name} - POST inner cache with name {cache-name}").append(System.lineSeparator()).append(System.lineSeparator());

            output.append(">>>PUT<<< request:").append(System.lineSeparator());
            output.append("http://localhost:4567/put-value/{cache-name}/{cache-key}/{cache-value} - PUT inside inner cache new key with his value (type Object)").append(System.lineSeparator());
            output.append("{cache-name} - cache name").append(System.lineSeparator());
            output.append("{cache-key} - inner key of cache").append(System.lineSeparator());
            output.append("{cache-value} - value of inner key (type Object)").append(System.lineSeparator()).append(System.lineSeparator());

            output.append(">>>GET<<< request:").append(System.lineSeparator());
            output.append("http://localhost:4567/get-value/{cache-name}/{cache-key} - GET key value (type Object) from inner cache which stored in outer main cache").append(System.lineSeparator());
            output.append("{cache-name} - cache name").append(System.lineSeparator());
            output.append("{cache-key} - inner key of cache").append(System.lineSeparator()).append(System.lineSeparator());

            output.append(">>>DELETE<<< requests:").append(System.lineSeparator());
            output.append("http://localhost:4567/delete-cache/{cache-name} - DELETE inner cache with this name if he exists").append(System.lineSeparator()).append(System.lineSeparator());

            output.append("http://localhost:4567/clear-all - DELETE all inner caches and recreate main cache").append(System.lineSeparator());

            CustomLogger.logInfo(output.toString());
        }
    }

    /**
     * In this method was made tests that program work fine.
     * Creates two inner Caches, put there some values and try to get them.
     * Delete Some Cache and delete All Caches.
     * When program end stop scanner
     */
    private static void customCreateCache() {
        CustomCache customCache = new CustomCache(cacheLifeCycle);

        // first cache
        CustomLogger.logInfo("Select cache name");
        String cacheName1 = StartProgram.scanner.next();

        customCache.createCache(cacheName1);

        customCache.put(cacheName1, "city", "Odessa");
        customCache.put(cacheName1, "country", "Ukraine");

        CustomLogger.logInfo((String) customCache.get(cacheName1, "city"));
        CustomLogger.logInfo((String) customCache.get(cacheName1, "country"));

        customCache.clearSomeCache(cacheName1);

        customCache.createCache(cacheName1);

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
