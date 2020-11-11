package lesson2;
/*
Программа, которая находит среднее арифметическое значение произвольного количества чисел
 */

import java.util.Scanner;

public class AverageArbitraryOfNumbers {
    public static void main(String[] args) {
        findAverageNumber();
    }

    public static void findAverageNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите общее колличество чисел:");
        float[] numbers = new float[scanner.nextInt()];

        System.out.println("Введите случайные числа:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextFloat();
        }

        float sumNumber = 0;
        for (int i = 0; i < numbers.length; i++) {
            sumNumber += numbers[i];
        }
        float averageNumber = sumNumber / numbers.length;
        System.out.printf("Среднее арифметическое значение: %s", averageNumber);
    }
}
