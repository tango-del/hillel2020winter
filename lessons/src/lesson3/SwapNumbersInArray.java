package lesson3;
/*
11.Поменять наибольший и наименьший элементы массива местами
12.Найти среднее арифметическое всех элементов массива
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

        findAverageArbitrary(array);
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

    //swap indexes of max and min numbers in array
    public static void swapMinMaxNumbers(int[] arr, int indexMin, int indexMax) {
        int temp = arr[indexMin];
        arr[indexMin] = arr[indexMax];
        arr[indexMax] = temp;
    }

    //find sum of all numbers in array and calc average arbitrary
    public static void findAverageArbitrary(int[] arr){
        int sumNumber = 0;
        for (int i : arr) {
            sumNumber += i;
        }
        float averageNumber = (float) sumNumber / arr.length;
        System.out.printf("Average arbitrary of array: %.2f", averageNumber);
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
