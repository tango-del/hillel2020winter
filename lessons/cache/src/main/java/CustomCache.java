import interfaces.CacheInterface;
import loggers.CustomLogger;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;

import java.util.concurrent.TimeUnit;

public class CustomCache implements CacheInterface {
    private static CacheManager cacheManager;
    private static Cache<String, Cache> mainCache;
    private static Integer cacheLifeCycle;
    private static final String NAME_MAIN_CACHE = "main-cache";

    public CustomCache(Integer cacheLifeCycle) {
        this.cacheLifeCycle = cacheLifeCycle;
        buildCacheManager();
        buildAndConfigureMainCache();
    }

    @Override
    public void createCache(String cache) {

        if (mainCache.containsKey(cache)) {
            CustomLogger.logError(String.format("Cache with name '%s' already exists", cache));
            throw new IllegalArgumentException(String.format("Cache with name '%s' already exists%n", cache));
        }

        Cache<String, Object> innerCache = cacheManager
                .createCache(cache,
                        CacheConfigurationBuilder
                                .newCacheConfigurationBuilder(String.class, Object.class,
                                        ResourcePoolsBuilder.heap(10))
                                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(cacheLifeCycle, TimeUnit.MINUTES))));
        mainCache.put(cache, innerCache);

        CustomLogger.logDebug(String.format("Create Cache with name '%s' and put in '%s'", cache, NAME_MAIN_CACHE));
    }

    @Override
    public boolean put(String cache, String key, Object value) {
        if (cache == null || key == null || value == null) {
            CustomLogger.logError("One of arguments in method 'put' is null");
            throw new IllegalArgumentException("One of arguments in method 'put' is null");
        }

        Cache tempCache = getCache(cache);

        if (tempCache == null) {
            CustomLogger.logError(String.format("Cache with name '%s' not found", cache));
            throw new NullPointerException(String.format("Cache with name '%s' not found%n", cache));
        }

        CustomLogger.logDebug(String.format("Put key: '%s' with value: '%s' in inner Cache with name: '%s'", key, value, cache));
        tempCache.put(key, value);

        return tempCache.containsKey(key);
    }

    @Override
    public Object get(String cache, String key) {
        if (!mainCache.containsKey(cache)) {
            CustomLogger.logError(String.format("Cache not found with name : '%s'", cache));
            throw new NullPointerException(String.format("Cache not found with name : '%s'%n", cache));
        }
        if (!mainCache.get(cache).containsKey(key)) {
            CustomLogger.logError(String.format("Cache with name '%s' don't have key : '%s'", cache, key));
            throw new NullPointerException(String.format("Cache with name '%s' don't have key : '%s'%n", cache, key));
        }

        CustomLogger.logDebug(String.format("Get value from inner Cache with name : '%s'", key));
        return mainCache.get(cache).get(key);
    }

    @Override
    public void clearAllCache() {
        cacheManager.removeCache(NAME_MAIN_CACHE);
        CustomLogger.logDebug(String.format("Remove '%s'", NAME_MAIN_CACHE));
        buildAndConfigureMainCache();
    }

    @Override
    public void clearSomeCache(String cache) {
        if (!mainCache.containsKey(cache)) {
            CustomLogger.logError(String.format("Cache with name '%s' not exists", cache));
            throw new IllegalArgumentException(String.format("Cache with name '%s' not exists%n", cache));
        }
        mainCache.remove(cache);
        CustomLogger.logDebug(String.format("Remove Cache with name : %s", cache));
    }

    private static Cache<String, Object> getCache(String cache) {
        return cacheManager.getCache(cache, String.class, Object.class);
    }

    private static void buildCacheManager() {
        // create cache manager
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        cacheManager.init();
        CustomLogger.logDebug("CacheManager initialized");
    }

    private static void buildAndConfigureMainCache() {
        // create main cache <String, Cache>
        mainCache = cacheManager.createCache(NAME_MAIN_CACHE, CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class, Cache.class, ResourcePoolsBuilder.heap(10))
                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(cacheLifeCycle, TimeUnit.MINUTES))));
        CustomLogger.logDebug(String.format("Cache '%s' created in EhcacheManager", NAME_MAIN_CACHE));
    }
}
