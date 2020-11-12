package lesson3;

/*
При помощи цикла for вывести на экран нечетные числа от 1 до 99
Перепишите программы с использованием цикла while.
 */

public class OutputOddNumbers {
    public static void main(String[] args) {
        //outputOddWithFor();
        outputOddWithWhile();
    }

    public static void outputOddWithFor() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void outputOddWithWhile(){
        int number = 0;
        while (number <= 100) {
            if (number % 2 != 0) {
                System.out.println(number);
            }
            number++;
        }
    }
}
