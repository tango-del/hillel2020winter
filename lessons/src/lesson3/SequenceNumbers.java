package lesson3;

/*
Вывести 10 первых чисел последовательности 0, -5,-10,-15..
 */

public class SequenceNumbers {
    public static void main(String[] args) {
        init();
    }

    public static void init(){
        int number = 0;
        int count = 0;
        while (count < 10) {
            System.out.println(number);
            number = number - 5;
            count++;
        }
    }
}
