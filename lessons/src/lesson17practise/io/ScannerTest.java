package lesson17practise.io;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner("Hello,world, Hello world Hello world");
        sc.useDelimiter(",");
        while (sc.hasNext()) {
            System.out.println(sc.next().trim());
        }
    }
}
