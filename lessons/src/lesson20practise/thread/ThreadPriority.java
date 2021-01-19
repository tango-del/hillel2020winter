package lesson20practise.thread;

public class ThreadPriority {
    public static void main(String[] args) {
        ThrPriority t1 = new ThrPriority();
        ThrPriority t2 = new ThrPriority();

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.setName("thread 1 - MAX");
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.setName("thread 2 - MIN");

        t1.start();
        t2.start();
    }
}

class ThrPriority extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " iter : " + i);
        }
    }
}