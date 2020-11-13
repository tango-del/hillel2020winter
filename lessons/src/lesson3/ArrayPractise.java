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
        int[] array = new int[scanner.nextInt()];
        fillArray(array);

        int minNumber = findMinNumber(array);
        System.out.println("Minimum number: " + minNumber);

        System.out.println("Array:");
        printArray(array);

    }

    //randomize all index in array from 0 to 100
    public static void fillArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101);
        }
    }

    //find min number in array
    public static int findMinNumber(int[] arr) {
        //start check from 0 index array
        int minNumber = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (minNumber > arr[i]) {
                minNumber = arr[i];
            }
        }
        return minNumber;
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
