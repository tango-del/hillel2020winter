import org.ehcache.Cache;
import org.ehcache.CacheManager;

import java.util.Scanner;

/*
TODO:
 -Создать кеш:
 -положить в кеш- boolean put(String cache, String key, Object o)
 -достать - Object get (String cache, String key)
 -очистить все кеши - void clear();
 -очистить кеш - void clear(string cache)
 */
public class StartProgram {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        System.out.println("Select cache lifecycle in minutes");
        // TODO think about check InputMisMatchException
        Integer cacheLifeCycle = scanner.nextInt();

        CustomCache customCache = new CustomCache(cacheLifeCycle);

        customCache.createCache();


        customCache.put("one", "city", "Odessa");
        customCache.put("one", "country", "Ukraine");

        System.out.println(customCache.get("one", "city"));
        System.out.println(customCache.get("one", "country"));

        customCache.createCache();

        customCache.put("two", "imper", "Telegram");
        customCache.put("two", "orem", "Skype");

        System.out.println(customCache.get("two", "imper"));
        System.out.println(customCache.get("two", "orem"));

        customCache.clearCache("one");

        customCache.clearAllCache();

        System.out.println(CustomCache.mainCache);
    }
}
