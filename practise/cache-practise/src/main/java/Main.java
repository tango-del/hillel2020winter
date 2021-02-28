public class Main {
    public static void main(String[] args) throws InterruptedException {
        CacheHelper cacheHelper = new CacheHelper();
        UserDao userDao = new UserDao(cacheHelper);

        System.out.println(userDao.getUserById(1).toString());

        Thread.sleep(2000);

        System.out.println(userDao.getUserById(1).toString());

        Thread.sleep(12000);

        System.out.println(userDao.getUserById(1).toString());
    }
}
