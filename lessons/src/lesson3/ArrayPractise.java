package lesson3;
/*
9.Дан массив размерности N, найти наименьший элемент массива и вывести на консоль (если наименьших элементов несколько — вывести их все).
10.В массиве из задания 9 найти наибольший элемент.
 */

import java.util.Scanner;

public class ArrayPractise {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input size of array:");
        int[] array = new int[scanner.nextInt()];
        fillArray(array);
        //int[] array = new int[]{82, 65, 10, 51, 82, 10, 82, 10, 49, 61};

        findMinNumbers(array);
        findMaxNumbers(array);

        System.out.println("Array:");
        printArray(array);

    }

    //randomize all numbers in array from 0 to 100
    public static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101);
        }
    }

    public static void findMinNumbers(int[] arr) {
        //ascending search min number
        int minNumber = arr[0];
        for (int j : arr) {
            if (minNumber > j) {
                minNumber = j;
            }
        }
        //equal min number in array and output with index
        for (int i = 0; i < arr.length; i++) {
            if (minNumber == arr[i]) {
                System.out.printf("Min number: %s index: %s", arr[i], i);
                System.out.println();
            }
        }
    }

    public static void findMaxNumbers(int[] arr) {
        //descending search max number
        int maxNumber = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (maxNumber < arr[i]) {
                maxNumber = arr[i];
            }
        }
        //equal max number in array and output with index
        for (int i = 0; i < arr.length; i++) {
            if (maxNumber == arr[i]) {
                System.out.printf("Max number: %s index: %s", arr[i], i);
                System.out.println();
            }
        }
    }

    //output array
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int j : arr) {
            System.out.printf("%d ", j);
        }
        System.out.println("]");
    }
}
