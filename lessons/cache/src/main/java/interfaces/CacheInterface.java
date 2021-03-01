package interfaces;

public interface CacheInterface {
    void createCache();
    boolean put(String cache, String key, Object value);
    Object get(String cache, String key);
    void clearAllCache();
    void clearCache(String cache);
}
