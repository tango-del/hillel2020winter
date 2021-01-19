package lesson20practise.thread;

public class Functional_Interface_ImplementsEx {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Hello World");
        };
        new Thread(task).start();
    }
}
