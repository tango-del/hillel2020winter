package lesson2;
import java.util.Scanner;
/*
Программа, которая находит среднее арифметическое значение двух чисел.
 */

public class Task1 {
    public static void main(String[] args) {
        findAverageValue();
    }

    public static void findAverageValue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first value:");
        short firstValue = scanner.nextShort();
        System.out.println("Enter second value:");
        short secondValue = scanner.nextShort();
        double averageValue = (double) (firstValue + secondValue) / 2;
        System.out.println(averageValue);
    }
}