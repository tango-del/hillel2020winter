package lesson3;

/*
5.Даны переменные x и n вычислить x^n
 */

import java.util.Scanner;

public class VozvedenieStepen {
    public static void main(String[] args) {
        init();
    }

    public static void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number");
        int number = scanner.nextInt();
        System.out.println("Input pow");
        int pow = scanner.nextInt();

        int totalNumber = 1;
        for (int i = 1; i <= pow; i++) {
            totalNumber *= number;
        }
        System.out.printf("%s in pow %s is : %s", number, pow, totalNumber);
    }
}
