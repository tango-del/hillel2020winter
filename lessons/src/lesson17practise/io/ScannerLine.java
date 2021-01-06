package lesson17practise.io;

import java.util.Scanner;

public class ScannerLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "a";

        System.out.println("Введите значения...");
        while (!str.equals("Q")) {
            str = sc.nextLine();
            System.out.println("--> " + str);
        }
    }
}
