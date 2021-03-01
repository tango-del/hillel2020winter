import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;

import java.util.concurrent.TimeUnit;

/*
TODO:
 -Создать кеш:
 -положить в кеш- boolean put(String cache, String key, Object o)
 -достать - Object get (String cache, String key)
 -очистить все кеши - void clear();
 -очистить кеш - void clear(string cache)
 */
public class StartProgram {
    static CacheManager cacheManager;
    static Cache<String, Cache> mainCache;

    public static void main(String[] args) throws InterruptedException {
        // create cache manager
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        cacheManager.init();

        // create main cache <String, Cache>
        mainCache = cacheManager.createCache("main-cache", CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class, Cache.class, ResourcePoolsBuilder.heap(10))
                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(15, TimeUnit.SECONDS))));

        // create inner cache 1
        Cache<String, Object> innerCache1 = cacheManager.createCache("inner-cache-1", CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class, Object.class, ResourcePoolsBuilder.heap(10))
                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(15, TimeUnit.SECONDS))));

        innerCache1.put("name", "Denis");
        innerCache1.put("city", "Odessa");
        innerCache1.put("country", "Ukraine");

        // create inner cache 2
        Cache<String, Object> innerCache2 = cacheManager.createCache("inner-cache-2", CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class, Object.class, ResourcePoolsBuilder.heap(10))
                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(15, TimeUnit.SECONDS))));

        innerCache2.put("adawd0", 13);
        innerCache2.put("adawd1", 29);
        innerCache2.put("adawd2", 512);

        mainCache.put("people1", innerCache1);
        mainCache.put("people2", innerCache2);

        System.out.println(mainCache.containsKey("people1"));
        System.out.println(mainCache.containsKey("people2"));

        Thread.sleep(11000);

        System.out.println(mainCache.containsKey("people1"));
        System.out.println(mainCache.containsKey("people2"));


        System.out.println(mainCache.get("people1").get("name"));
        System.out.println(mainCache.get("people1").get("city"));
        System.out.println(mainCache.get("people1").get("country"));

        System.out.println("-----------");

        System.out.println(mainCache.get("people2").get("adawd0"));
        System.out.println(mainCache.get("people2").get("adawd1"));
        System.out.println(mainCache.get("people2").get("adawd2"));
    }
}
