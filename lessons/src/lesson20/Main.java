package lesson20;

import lesson20.Threads.CustomThread;
import lesson20.Threads.ThreadNew;

/**
 *  Написать мини приложение банкомат, которое работает в нескольких потоках
 *  каждый поток может класть и снимать определенную сумму сумму из банкомата,
 *  каждая транзакция должна выводиться на экран в формате: поток - снятие/пополнение - сумма
 */

public class Main {
    public static void main(String[] args) {
        UserCard user = UserCard.getInstance("Denis");

        Thread thread1 = new CustomThread(user);
        Thread thread2 = new CustomThread(user);
//        Thread thread2 = new ThreadNew(user);
        thread1.start();
        thread2.start();
    }

    public static int valueRandomizer() {
        return (int) (Math.random() * 20);
    }
}
