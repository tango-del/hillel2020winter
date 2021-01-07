package lesson17;

import lesson17.enums.Signs;
import lesson17.exceptions.UnsupportedSignException;

import java.util.Scanner;

/**
 * TODO
 *  Написать консольную игру камень ножницы бумага
 *  - пользователь должен выбирать количество игр и ввести свое имя +
 *  - пользователь должен иметь возможность прервать игру
 *  - после прекращения игры пользователь должен увидеть результат
 *  - результат надо сохранить в файл - https://www.baeldung.com/java-write-to-file
 *  (если файла нет его надо создать, если файл есть то дописать результат в файл) - формат записи выбрать самому
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        Computer computer = new Computer();
        Integer chooseUser;
        Integer chooseComp;
        int count = 0;
        String playerChooseContinue;


        System.out.println("Choose User Name:");
        user.setName(scanner.nextLine());
        System.out.println("Choose count games");
        Integer countGames = scanner.nextInt();

        do {
            System.out.println(">-------------<");
            System.out.println("GAME: " + ++count);
            System.out.println("Choose sign:");
            System.out.println("1: rock"); //камень
            System.out.println("2: scissors"); // ножницы
            System.out.println("3: paper"); // бумага
            chooseUser = scanner.nextInt(); //user choose sign
            //chooseUser = (int) (Math.random() * 3) + 1; //user choose sign
            chooseComp = (int) (Math.random() * 3) + 1; //comp choose sign

            user.setSigns(choose(chooseUser));
            computer.setSigns(choose(chooseComp));

            winnerInRound(user, computer);

            --countGames;

            System.out.println("Want to continue? Y/N");
            playerChooseContinue = scanner.next();
        } while (countGames > 0 && playerChooseContinue.equalsIgnoreCase("Y"));

        finalWinner(user, computer);

        System.out.println(user.getNumberOfRoundsWon());
        System.out.println(computer.getNumberOfRoundsWon());

    }

    private static void finalWinner(User user, Computer computer) {
        if (user.getNumberOfRoundsWon() < computer.getNumberOfRoundsWon()) {
            System.out.println(">---------<");
            System.out.println(">COMP--WON<");
            System.out.println(">---------<");
        } else if (user.getNumberOfRoundsWon() > computer.getNumberOfRoundsWon()) {
            System.out.println(">---------<");
            System.out.println(">USER- WON<");
            System.out.println(">---------<");
        } else if (user.getNumberOfRoundsWon() == computer.getNumberOfRoundsWon()) {
            System.out.println(">---------<");
            System.out.println(">NO WINNER<");
            System.out.println(">---------<");
        }
    }

    private static void winnerInRound(User user, Computer computer) throws UnsupportedSignException {
        switch (user.getSigns()) {
            case ROCK -> {
                if (computer.getSigns().equals(Signs.ROCK)) {
                    System.out.println("user - rock, comp - rock --> NO WINNER");
                } else if (computer.getSigns().equals(Signs.SCISSORS)) {
                    System.out.println("user - rock, comp - scissors --> USER WIN");
                    user.setNumberOfRoundsWon(user.getNumberOfRoundsWon() + 1);
                } else if (computer.getSigns().equals(Signs.PAPER)) {
                    System.out.println("user - rock, comp - paper --> COMP WIN");
                    computer.setNumberOfRoundsWon(computer.getNumberOfRoundsWon() + 1);
                }
            }
            case SCISSORS -> {
                if (computer.getSigns().equals(Signs.ROCK)) {
                    System.out.println("user - scrissors, comp - rock -> COMP WIN");
                    computer.setNumberOfRoundsWon(computer.getNumberOfRoundsWon() + 1);
                } else if (computer.getSigns().equals(Signs.SCISSORS)) {
                    System.out.println("user - scrissors, comp - scissors --> НИЧЬЯ");
                } else if (computer.getSigns().equals(Signs.PAPER)) {
                    System.out.println("user - scrissors, comp - paper --> USER WIN");
                    user.setNumberOfRoundsWon(user.getNumberOfRoundsWon() + 1);
                }
            }
            case PAPER -> {
                if (computer.getSigns().equals(Signs.ROCK)) {
                    System.out.println("user - paper, comp - rock --> USER WIN");
                    user.setNumberOfRoundsWon(user.getNumberOfRoundsWon() + 1);
                } else if (computer.getSigns().equals(Signs.SCISSORS)) {
                    System.out.println("user - paper, comp - scirssors --> COMP WIN");
                    computer.setNumberOfRoundsWon(computer.getNumberOfRoundsWon() + 1);
                } else if (computer.getSigns().equals(Signs.PAPER)) {
                    System.out.println("user - paper, comp - paper --> НИЧЬЯ");
                }
            }
            default -> throw new UnsupportedSignException("You choose wrong Sign");
        }
    }

    private static Signs choose(Integer test) throws UnsupportedSignException {
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
