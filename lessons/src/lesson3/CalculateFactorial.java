package lesson3;

/*
Дано число n при помощи цикла for посчитать факториал n!
Перепишите программы с использованием цикла while.
Перепишите программы с использованием цикла do - while
 */

import java.util.Scanner;

public class CalculateFactorial {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number to calculate factorial:");
        long number = scanner.nextInt();
        calculateWithFor(number);
        calculateWithWhile(number);
        calculateWithDoWhile(number);
    }

    //calculate for
    public static void calculateWithFor(long number) {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.printf("Calculated with for : %s", factorial);
        System.out.println();

    }

    //calculate while
    public static void calculateWithWhile(long number) {
        long factorial = 1;
        int count = 1;
        while (count <= number) {
            factorial *= count;
            count++;
        }
        System.out.printf("Calculated with while : %s", factorial);
        System.out.println();
    }

    //calculate do while
    public static void calculateWithDoWhile(long number) {
        long factorial = 1;
        int count = 1;
        do {
            factorial *= count;
            count++;
        } while (count <= number);
        System.out.printf("Calculated with do while : %s", factorial);
    }
}
