package lesson17;

import lesson17.enums.Signs;
import lesson17.exceptions.UnsupportedSignException;

import java.util.Scanner;

/**
 * TODO
 * Написать консольную игру камень ножницы бумага
 * - пользователь должен выбирать количество игр и ввести свое имя
 * - пользователь должен иметь возможность прервать игру
 * - после прекращения игры пользователь должен увидеть результат
 * - результат надо сохранить в файл - https://www.baeldung.com/java-write-to-file
 * (если файла нет его надо создать, если файл есть то дописать результат в файл) - формат записи выбрать самому
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Choose sign:");
        System.out.println("1: rock"); //камень
        System.out.println("2: scissors"); // ножницы
        System.out.println("3: paper"); // бумага
        Scanner scanner = new Scanner(System.in);

        User user = new User();
        //set user sign
        Integer chooseUser = scanner.nextInt();
        user.setSigns(choose(chooseUser));

        Computer computer = new Computer();
        //set computer sign
        Integer chooseComp = (int) (Math.random() * 3) + 1;
        computer.setSigns(choose(chooseComp));

//        switch (chooseUser) {
//            case 1 -> user.setSigns(Signs.ROCK);
//            case 2 -> user.setSigns(Signs.SCISSORS);
//            case 3 -> user.setSigns(Signs.PAPER);
//        }
//        switch (chooseComp) {
//            case 1 -> computer.setSigns(Signs.ROCK);
//            case 2 -> computer.setSigns(Signs.SCISSORS);
//            case 3 -> computer.setSigns(Signs.PAPER);
//        }
        System.out.println(user);
        System.out.println(computer);
        winner(user, computer);
    }

    private static void winner(User user, Computer computer) {
        if (user.getSigns().equals(Signs.ROCK)) {
            System.out.println(user);
        }
    }

    private static Signs choose(Integer test) {
        switch (test) {
            case 1:
                return Signs.ROCK;
            case 2:
                return Signs.SCISSORS;
            case 3:
                return Signs.PAPER;
            default:
                throw new UnsupportedSignException("You choose wrong Sign");
        }
    }
}
