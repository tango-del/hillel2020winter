package lesson3;
/*
Поменять наибольший и наименьший элементы массива местами
 */

public class SwapNumbersInArray {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        int[] array = new int[]{20, 15, 82, 51, 65, 15, 43, 10, 49};

        printArray(array);

        findMinMaxNumbers(array);

        printArray(array);
    }

    public static void findMinMaxNumbers(int[] arr) {
        int minNumber = arr[0];
        int maxNumber = 0;
        int indexMin = 0;
        int indexMax = 0;
        //search max\min numbers with index
        for (int i = 0; i < arr.length; i++) {
            if (minNumber > arr[i]) {
                minNumber = arr[i];
                indexMin = i;
            } else if (maxNumber < arr[i]) {
                maxNumber = arr[i];
                indexMax = i;
            }
        }
        System.out.println("min: " + minNumber + " index: " + indexMin);
        System.out.println("max: " + maxNumber + " index: " + indexMax);
        swapMinMaxNumbers(arr, indexMin,indexMax);
    }

    public static void swapMinMaxNumbers(int[] arr, int indexMin, int indexMax) {
        int temp = arr[indexMin];
        arr[indexMin] = arr[indexMax];
        arr[indexMax] = temp;
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
