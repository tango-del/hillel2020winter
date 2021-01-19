package lesson20practise.thread;

import java.util.Arrays;
import java.util.List;

public class SleepMet {
    public static void main(String[] args) throws InterruptedException {
        List<String> arrStr = Arrays.asList("one", "two", "three", "four");
        List<String> arrStr2 = List.of("one", "two", "three", "four"); // immutable

        System.out.println(arrStr.getClass());
        System.out.println(arrStr2.getClass());

        for (String str : arrStr) {
            Thread.sleep(2000);
            System.out.println(str);
        }

        for (int i = 0; i < 10; i++) {
            System.out.print("#");
            Thread.sleep(1000);
        }
        System.out.println();

        Thread thread = new ThreadTh("paralel thread");

        System.out.println(thread.getName());
        System.out.println(thread.getId());
        thread.start();

        for (int i = 0; i < 20; i++) {
            Thread.sleep(1500);
            System.out.println("MAIN >> value >> " + i);
        }
    }
}
