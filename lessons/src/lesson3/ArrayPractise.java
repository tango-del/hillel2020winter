package lesson3;
/*
Дан массив размерности N, найти наименьший элемент массива и вывести на консоль (если наименьших элементов несколько — вывести их все).
 */

import java.util.Scanner;

public class ArrayPractise {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input size of array:");
//        int[] array = new int[scanner.nextInt()];
//        fillArray(array);
        int[] array = new int[]{20, 65, 10, 51, 82, 10, 82, 10, 49, 61};

        //int minNumber = findMinNumbers(array);
        findMinNumbers(array);

        System.out.println("Array:");
        printArray(array);

    }

    //randomize all index in array from 0 to 100
    public static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101);
        }
    }

    //find min number in array
    public static void findMinNumbers(int[] arr) {
        //ascending search minimum number
        int minNumber = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (minNumber > arr[i]) {
                minNumber = arr[i];
            }
        }
        //descending check to equal numbers
        for (int i = arr.length - 1; i >= 0; i--) {
            if (minNumber == arr[i]) {
                System.out.printf("Minimum number: %s at index: %s", arr[i], i);
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
