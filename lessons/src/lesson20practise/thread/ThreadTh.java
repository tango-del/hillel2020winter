package lesson20practise.thread;

public class ThreadTh extends Thread {
    public ThreadTh(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " THREAD >> value >> " + i);
        }
    }
}
