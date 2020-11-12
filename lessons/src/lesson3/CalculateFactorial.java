package lesson3;

/*
Дано число n при помощи цикла for посчитать факториал n!
 */

import java.util.Scanner;

public class CalculateFactorial {
    public static void main(String[] args) {
        init();
    }

    public static void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number to calculate factorial:");
        long number = scanner.nextInt();
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println(factorial);
    }
}
