package lesson2;
/*
Программа, которая находит среднее арифметическое значение произвольного количества чисел
 */

public class Task2 {
    public static void main(String[] args) {
        findAverageNumber();
    }

    public static void findAverageNumber(){
        short firstNumber = 54;
        short secondNumber = 84;
        short thirdNumber = 352;
        short fourthNumber = 1244;
        short fifthNumber = 135;
        double averageNumber = (double) (firstNumber + secondNumber + thirdNumber + fourthNumber + fifthNumber) / 5;
        System.out.printf("Average number of %s, %s, %s, %s and %s is: %s", firstNumber, secondNumber, thirdNumber, fourthNumber, fifthNumber, averageNumber);
    }
}
