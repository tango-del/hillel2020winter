package lesson12practise;

public class TryFinally {
    public static void main(String[] args) {
        System.out.println(validate());
    }

    private static Boolean validate() {
        try {
            System.out.println("1");
            System.exit(1);

            return true;
        } finally {
            System.out.println("2");
        }
    }
}
