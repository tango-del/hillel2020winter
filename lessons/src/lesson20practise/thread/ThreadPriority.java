package lesson20practise.thread;

import lombok.SneakyThrows;

public class ThreadPriority {
    @SneakyThrows
    public static void main(String[] args) {
        ThrPriority t1 = new ThrPriority();
        ThrPriority t2 = new ThrPriority();

        System.out.println(t1.isAlive());

//        t1.setPriority(Thread.MAX_PRIORITY);
        t1.setName("thread 1 - MAX");
//        t2.setPriority(Thread.MIN_PRIORITY);
        t2.setName("thread 2 - MIN");

        t1.start();
//        t2.start();

        while (t1.isAlive()) {
            System.out.println(t1.isAlive());
            Thread.sleep(1234);
        }

    }
}

class ThrPriority extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(Thread.currentThread().getName() + " iter : " + i);
        }
    }
}