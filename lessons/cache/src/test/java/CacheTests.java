import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CacheTests {
    static CustomCache customCache;

    @BeforeAll
    static void initCache() {
        customCache = new CustomCache(4);
        customCache.createCache("cache_one");
        customCache.createCache("cache_two");

    }

    @Order(1)
    @Test
    public void checkThrowCachePutWithNullArguments() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> customCache.put(null, "test_key", "test_value"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> customCache.put("cache_one", null, "test_value"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> customCache.put("cache_one", "test_key", null));

    }

    @Order(2)
    @Test
    public void checkCacheNotExists() {
        Assertions.assertThrows(NullPointerException.class,
                () -> customCache.put("unknown", "salad", "pasta"));

    }

    @Order(3)
    @Test
    public void checkCachePut() {
        Assertions.assertTrue(customCache.put("cache_two", "test_key", "test_value"));
    }

    @Order(4)
    @Test
    public void checkCacheGetThrowsAfterRemove() {
        customCache.put("cache_one", "test_key", "test_value");
        //delete test_name cache
        customCache.clearSomeCache("cache_one");

        //check not exists in main cache
        Assertions.assertThrows(NullPointerException.class,
                () -> customCache.get("cache_one", "test_key"));

    }

    @Order(5)
    @Test
    public void checkCacheGetThrows() {

        Assertions.assertThrows(NullPointerException.class,
                () -> customCache.get("test_name_test", "test_key"));

        Assertions.assertThrows(NullPointerException.class,
                () -> customCache.get("test_name1", "test_key"));

    }

    @AfterAll
    static void clearCache() {
        customCache.clearAllCache();
    }
}
