package lesson20practise.thread;

public class JoinMet {
    public static void main(String[] args) {
        Thread thread1 = new ThreadTh("join-1");
        Thread thread2 = new ThreadJoin("join-2");
        thread1.start();
        thread2.start();

        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(500);
                System.out.println("run main thread : iteration >> " + i);
                if (i == 5) {
                    thread1.join();
                }
                if (i == 6) {
                    thread2.join();
                }

            } catch (InterruptedException e) {
                System.out.println("catch interrupted exception");
            }
        }
    }
}

class ThreadJoin extends Thread {

    public ThreadJoin(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " THREAD >> value >> " + i);
        }
    }
}