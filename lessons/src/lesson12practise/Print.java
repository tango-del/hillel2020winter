package lesson12practise;

import java.util.Arrays;
import java.util.List;

public class Print {
    void print(String s) {
        if (s == null) {
            throw new NullPointerException("Exception: is null!");
        }
        System.out.println("Inside method print: " + s);
    }

    public static void main(String[] args) {
        Print print = new Print();
        List<String > list = Arrays.asList("first step", null, "second step");

        for (String a : list) {
            try {
                print.print(a);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                System.out.println("Exception was processed. Program continues");
            } finally {
                System.out.println("Inside block finally");
            }
            System.out.println("Go program...");
            System.out.println("--------------------");
        }
    }
}
