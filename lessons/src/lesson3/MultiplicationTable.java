package lesson3;

/*
7.Необходимо вывести на экран таблицу умножения на Х: (любое число вводимое из консоли)
 */

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        init();
    }

    public static void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number for multiplication table");
        int number = scanner.nextInt();
        int[] arrayMultiTable = new int[20];
        for (int i = 0; i < arrayMultiTable.length; i++) {
            int tempNumber = number * (i + 1);
            System.out.println(tempNumber);
        }

    }
}
