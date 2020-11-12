package lesson3;

/*
При помощи цикла for вывести на экран нечетные числа от 1 до 99
 */

public class OutputOddNumbers {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        byte[] arrayNumbers = new byte[100];
        for (byte i = 0; i < arrayNumbers.length; i++) {
            arrayNumbers[i] = (byte) (i + 1);
            if (arrayNumbers[i] % 2 != 0) {
                System.out.println(arrayNumbers[i]);
            }
        }
    }
}
