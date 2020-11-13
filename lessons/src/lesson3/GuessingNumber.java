package lesson3;
/*
ДЗ со звездочкой:
Программа "Угадай число"
Компьютер «загадывает» целое число от 1 до 200.
Пользователь должен угадать число.
Когда пользователь вводит свою догадку, компьютер отвечает,
было ли это число больше или меньше загаданного. Игра продлжается
до угадывания числа. Результат игры вывод на экран количества попыток
 */

import java.util.Scanner;

public class GuessingNumber {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        Scanner scanner = new Scanner(System.in);
        short count = 1;
        //generate number from 1 to 200
        short randomNumber = (short) (1 + (short) (Math.random() * 200));
        System.out.println("input number");
        short userNumber = scanner.nextShort();
        while (checkEqualNumbers(randomNumber, userNumber)) {
            count++;
            System.out.println("input number");
            userNumber = scanner.nextShort();
            if (count == 50) {
                break;
            }
        }
        if (count == 50) {
            System.out.printf("You reached %s count. Try to relax", count);
        } else {
            System.out.println("count: " + count);
        }
    }

    public static boolean checkEqualNumbers(short randomNumber, short userNumber) {
        if (randomNumber > userNumber) {
            System.out.println("My number > " + userNumber);
            return true;
        } else if (randomNumber < userNumber) {
            System.out.println("My number < " + userNumber);
            return true;
        } else {
            System.out.println("You guessed");
            return false;
        }

    }
}
