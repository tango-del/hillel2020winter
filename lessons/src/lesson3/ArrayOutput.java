package lesson3;

/*
8.Создайте массив, содержащий 10 первых нечетных чисел. Выведете элементы массива на консоль в одну строку, разделяя запятой.
 */

public class ArrayOutput {
    public static void main(String[] args) {
        init();
    }

    public static void init(){
        int[] array = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i] + "\n");
            }
        }

        printArray(array);
    }

    //output one line inside brackets
    static void printArray(int[] arr) {
        System.out.print("[");
        for (int j : arr) {
            System.out.printf("%d ", j);
        }
        System.out.println("]");
    }
}
