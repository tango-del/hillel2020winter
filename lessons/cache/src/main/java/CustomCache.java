import interfaces.CacheInterface;

public class CustomCache implements CacheInterface {

    @Override
    public void createCache() {

    }

    @Override
    public boolean put(String cache, String key, Object value) {
        return false;
    }

    @Override
    public Object get(String cache, String key) {
        return null;
    }

    @Override
    public void clearAllCache() {

    }

    @Override
    public void clearCache(String cache) {

    }
}
