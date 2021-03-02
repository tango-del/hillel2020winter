import interfaces.CacheInterface;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.ehcache.spi.serialization.Serializer;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class CustomCache implements CacheInterface, Serializable {
    private static CacheManager cacheManager;
    static Cache<String, Cache> mainCache;
    private static Integer cacheLifeCycle;
    private static final String NAME_MAIN_CACHE = "main-cache";

    public CustomCache(Integer cacheLifeCycle) {
        this.cacheLifeCycle = cacheLifeCycle;
        buildCacheManager();
        buildAndConfigureMainCache();

    }

    @Override
    public void createCache(String cache) {
        // TODO check cache name already exists

        if (mainCache.containsKey(cache)) {
            throw new IllegalArgumentException(String.format("Cache with name '%s' already exists%n", cache));
        }

        Cache<String, Object> innerCache = cacheManager
                .createCache(cache,
                        CacheConfigurationBuilder
                                .newCacheConfigurationBuilder(String.class, Object.class,
                                        ResourcePoolsBuilder.heap(10))
                                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(cacheLifeCycle, TimeUnit.MINUTES))));

        mainCache.put(cache, innerCache);
    }

    @Override
    public boolean put(String cache, String key, Object value) {
        if (cache == null || key == null || value == null) {
            throw new IllegalArgumentException("One of arguments in method 'put' is null");
        }

        Cache tempCache = getCache(cache);

        if (tempCache == null) {
            throw new NullPointerException(String.format("Cache with name '%s' not found%n", cache));
        }

        tempCache.put(key, value);

        return tempCache.containsKey(key);
    }

    @Override
    public Object get(String cache, String key) {
        if (!mainCache.containsKey(cache)) {
            throw new NullPointerException(String.format("Cache not found with name : '%s'%n", cache));
        }
        if (!mainCache.get(cache).containsKey(key)) {
            throw new NullPointerException(String.format("Cache with name '%s' don't have key : '%s'%n", cache, key));
        }

        return mainCache.get(cache).get(key);
    }

    @Override
    public void clearAllCache() {
        cacheManager.removeCache(NAME_MAIN_CACHE);
        buildAndConfigureMainCache();
    }

    @Override
    public void clearSomeCache(String cache) {
        if (!mainCache.containsKey(cache)) {
            throw new IllegalArgumentException(String.format("Cache with name '%s' not exists%n", cache));
        }
        mainCache.remove(cache);
    }

    private static Cache<String, Object> getCache(String cache) {
        return cacheManager.getCache(cache, String.class, Object.class);
    }

    private static void buildCacheManager() {
        // create cache manager
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        cacheManager.init();
    }

    private static void buildAndConfigureMainCache() {
        // create main cache <String, Cache>
//        mainCache = cacheManager.createCache(NAME_MAIN_CACHE, CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, Cache.class,
//                ResourcePoolsBuilder.heap(10).offheap(5, MemoryUnit.MB)).withValueSerializer((Class<? extends Serializer<Cache>>) Serializable.class)
//                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(cacheLifeCycle, TimeUnit.SECONDS))));

        mainCache = cacheManager.createCache(NAME_MAIN_CACHE, CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class, Cache.class, ResourcePoolsBuilder.heap(10))
                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(cacheLifeCycle, TimeUnit.MINUTES))));
    }
}
