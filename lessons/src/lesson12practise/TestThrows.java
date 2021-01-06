package lesson12practise;

public class TestThrows {
    public static void main(String[] args) {
        int result = 0;
        try {
             result = getFactorial( 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(result);
    }

    public static int getFactorial(int num) throws RuntimeException {
        if (num < 1) {
            throw new RuntimeException("number < 1");
        }
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
