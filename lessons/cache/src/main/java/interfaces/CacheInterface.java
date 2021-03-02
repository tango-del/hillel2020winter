package interfaces;

public interface CacheInterface {
    void createCache(String cache);
    boolean put(String cache, String key, Object value);
    Object get(String cache, String key);
    void clearAllCache();
    void clearSomeCache(String cache);
}
