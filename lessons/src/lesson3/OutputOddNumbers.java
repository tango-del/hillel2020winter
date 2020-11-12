package lesson3;

/*
При помощи цикла for вывести на экран нечетные числа от 1 до 99
 */

public class OutputOddNumbers {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}
