package lesson20practise.thread;

public class ThreadRun implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " RUNNABLE >> Run new thread...");
    }
}
