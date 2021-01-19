package lesson20practise.thread;

public class Main {
    public static void main(String[] args) {
        Thread threadTh = new ThreadTh("Thread 2");
        Thread threadRun = new Thread(new ThreadRun());
        threadRun.setName("Thread 3");
        System.out.println(Thread.currentThread().getName() + " start main");
        threadTh.start();
        threadRun.start();
        System.out.println(Thread.currentThread().getName() + " finish main");
    }
}
