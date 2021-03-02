import java.util.Scanner;

public class StartProgram {
    static Scanner scanner;

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);

        System.out.println("Select cache lifecycle in minutes");
        // TODO think about check InputMisMatchException
        Integer cacheLifeCycle = scanner.nextInt();
//        String test;
//
//        boolean result = true;
//        Integer test2 = 1;
//
//        do {
//            test = scanner.nextLine();
//            try {
//                test2 = Integer.valueOf(test);
//                result = false;
//            } catch (NumberFormatException e) {
//                System.out.println("Incorrect number");
//                result = true;
//            }
//        } while (result && test2 > 0 && test2 <= 10);

        CustomCache customCache = new CustomCache(cacheLifeCycle);

        // first cache

        System.out.println("Select cache name");
        String cacheName1 = StartProgram.scanner.next();

        customCache.createCache(cacheName1);

        customCache.put(cacheName1, "city", "Odessa");
        customCache.put(cacheName1, "country", "Ukraine");

        System.out.println(customCache.get(cacheName1, "city"));
        System.out.println(customCache.get(cacheName1, "country"));





        // second cache

        System.out.println("Select cache name");
        String cacheName2 = StartProgram.scanner.next();

        customCache.createCache(cacheName2);

        customCache.put(cacheName2, "imper", "Telegram");
        customCache.put(cacheName2, "orem", "Skype");

        System.out.println(customCache.get(cacheName2, "imper"));
        System.out.println(customCache.get(cacheName2, "orem"));


        System.out.println(CustomCache.mainCache);


//        customCache.clearSomeCache(cacheName1);

        customCache.clearAllCache();

        System.out.println(CustomCache.mainCache);

        scanner.close();
    }
}