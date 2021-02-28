import org.ehcache.Cache;

import java.util.Objects;

public class UserDao {
    private CacheHelper cache;

    public UserDao(CacheHelper cache) {
        this.cache = cache;
    }

    public User getUserById(Integer id) throws InterruptedException {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("argument id is null");
        }

        Cache ch = cache.getUserCache();
        if (ch.containsKey(id)) {
            System.out.println("get value from cache");
            return (User) ch.get(id);
        } else {
            System.out.println(String.format("value not found in cache with id : %s", id));
        }

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.print("#");
        }

        System.out.println();

        System.out.println("get value from DB");
        User user = new User(id, "Ivan", "Ivanov", 27, "0931525126", "email@email.com");
        ch.put(id, user);

        return user;
    }
}
