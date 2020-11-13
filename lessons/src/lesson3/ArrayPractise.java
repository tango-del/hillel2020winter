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
        int[] array = new int[]{20, 15, 82, 51, 10, 65, 59, 43, 16, 49};
        //fillArray(array);

        System.out.println("Array:");
        printArray(array);


    }

    //randomize all index in array from 0 to 100
    public static void fillArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101);
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
