package lesson17;

import lesson17.enums.Signs;
import lesson17.exceptions.UnsupportedSignException;

import java.io.*;
import java.util.Scanner;

/**
 * TODO
 *  Написать консольную игру камень ножницы бумага
 *  - пользователь должен выбирать количество игр и ввести свое имя +
 *  - пользователь должен иметь возможность прервать игру +
 *  - после прекращения игры пользователь должен увидеть результат +
 *  - результат надо сохранить в файл - https://www.baeldung.com/java-write-to-file +
 *  (если файла нет его надо создать, если файл есть то дописать результат в файл) - формат записи выбрать самому
 *
 * TODO №2
 *  - не надо харжкодить пути сохранения, у тебя работать будет только на виндовс +
 *  - Функциона для работы с файлами и функционал игры надо вынести в отделный интерфейс и его реализацию
 *  - Подумай как оптимизировать вычислене результата
 */

public class Start {
    private static FileCreator fileCreator = new FileCreator();
    private static final StringBuilder str = new StringBuilder();
    //append(System.lineSeparator()) - добавляет новую строку
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        init();
    }

    /**
     * Метод начинает игру Камень-Ножницы-Бумага.
     * Играет пользователь и компьютер.
     * С помощью @Scanner Пользователь называет своё Имя,
     * колличество игр которые хочет сыграть,
     * выбирает Enum @Signs который записывается в него через Setter.
     * Компьютер генерирует случайное число в каждом раунде, после чего
     * вызывается метод для подсчета победителя в раунде.
     *
     * @throws IOException
     * @countGames уменьшается на 1.
     * После каждого раунда пользователь выбирает хочет ли продолжить игру.
     * Когда игра заканчивается программа подсчитывает колличество выйгранных раундов
     * у обоих игроков, объявляет победителя, записывает их в файл по указанным параметрам.
     */
    private static void init() throws IOException {
        fileCreator.checkFilesExists();
        //checkFilesExists();


        User user = new User(); // user player
        Computer computer = new Computer(); // computer player

        Integer chooseUser;
        Integer chooseComp;

        int count = 0; // passed games counter
        String playerChooseContinue; // keeps symbol that user input to continue game

        System.out.println("Choose User Name:");
        str.append("Choose User Name:")
                .append(System.lineSeparator());

        user.setName(scanner.next()); // sets user name
        str.append(user.getName())
                .append(System.lineSeparator());

        System.out.println("Choose count games");
        str.append("Choose count games")
                .append(System.lineSeparator());

        Integer countGames = scanner.nextInt(); // sets count games

        str.append(countGames)
                .append(System.lineSeparator());

        do {
            ++count;
            str.append(">-------------<")
                    .append(System.lineSeparator())
                    .append("GAME: ")
                    .append(count)
                    .append(System.lineSeparator())
                    .append("Choose sign:")
                    .append(System.lineSeparator())
                    .append("1: rock")
                    .append(System.lineSeparator())
                    .append("2: scissors")
                    .append(System.lineSeparator())
                    .append("3: paper")
                    .append(System.lineSeparator());

            System.out.println(">-------------<");
            System.out.println("GAME: " + count);
            System.out.println("Choose sign:");
            System.out.println("1: rock"); //камень
            System.out.println("2: scissors"); // ножницы
            System.out.println("3: paper"); // бумага

            chooseUser = scanner.nextInt(); //user choose sign
            /*
            for test
            chooseUser = (int) (Math.random() * 3) + 1;
            chooseUser = 52;
            */

            chooseComp = (int) (Math.random() * 3) + 1; //comp choose sign

            user.setSigns(choose(chooseUser));
            computer.setSigns(choose(chooseComp));

            winnerInRound(user, computer);

            --countGames; //decrease count games

            System.out.println("Want to continue? Y-y or N-n");

            str.append("Want to continue? Y-y or N-n")
                    .append(System.lineSeparator());

            playerChooseContinue = scanner.next();
            str.append(playerChooseContinue)
                    .append(System.lineSeparator());

            while (!playerChooseContinue.equalsIgnoreCase("y") && !playerChooseContinue.equalsIgnoreCase("n")) {
                System.out.println("Wrong symbol. Try again");

                str.append("Wrong symbol. Try again").append(System.lineSeparator());

                playerChooseContinue = scanner.next();

                str.append(playerChooseContinue).append(System.lineSeparator());
            }
        } while (checkGameContinue(countGames, playerChooseContinue));

        scanner.close();

        finalWinner(user, computer);

        fileCreator.writeToFile(str);
    }

    /**
     * Метод проверяет что колличество заданных игр  > 0
     * а так же перезаписанная строка @playerChooseContinue
     * эквивалентна заданному параметру. @equalsIgnoreCase игнорирует верхний и нижний регистр строки.
     *
     * @param countGames
     * @param playerChooseContinue
     * @return
     */
    private static boolean checkGameContinue(Integer countGames, String playerChooseContinue) {
        return countGames > 0 && playerChooseContinue.equalsIgnoreCase("Y");
    }


    /**
     * Метод сверяет у двух объектов @NumberOfRoundsWon
     * Записывает в @StringBuilder результат подходящего условия
     * а так же переопределенный метод @toString у обоих объектов
     *
     * @param user
     * @param computer
     */
    private static void finalWinner(User user, Computer computer) {
        if (user.getNumberOfRoundsWon() < computer.getNumberOfRoundsWon()) {
            str.append(">---------<")
                    .append(System.lineSeparator())
                    .append(">COMP--WON<")
                    .append(System.lineSeparator())
                    .append(">---------<")
                    .append(System.lineSeparator());
            System.out.println(">---------<");
            System.out.println(">COMP--WON<");
            System.out.println(">---------<");
        } else if (user.getNumberOfRoundsWon() > computer.getNumberOfRoundsWon()) {
            str.append(">---------<")
                    .append(System.lineSeparator())
                    .append(">USER--WON<")
                    .append(System.lineSeparator())
                    .append(">---------<")
                    .append(System.lineSeparator());
            System.out.println(">---------<");
            System.out.println(">USER--WON<");
            System.out.println(">---------<");
        } else if (user.getNumberOfRoundsWon() == computer.getNumberOfRoundsWon()) {
            str.append(">---------<")
                    .append(System.lineSeparator())
                    .append(">NO-WINNER<")
                    .append(System.lineSeparator())
                    .append(">---------<")
                    .append(System.lineSeparator());
            System.out.println(">---------<");
            System.out.println(">NO-WINNER<");
            System.out.println(">---------<");
        }
        //final results
        str.append(user)
                .append(System.lineSeparator());
        str.append(computer)
                .append(System.lineSeparator());
        System.out.println(user);
        System.out.println(computer);
    }

    /**
     * Метод принимает два объекта, вызывает у @user заданный Enum
     * с помощью Getter и проходит им через switch. При совпадении
     * с одним из перечисленных Enum, вызывает switch в котором
     * указывает Getter Enum Signs у @computer, при совпадении
     * с одним из перечисленных Enum : Записывает указанную строку в @StringBuilder.
     * Исходя из условия ниже у объекта который выйграл
     * инкрементит @NumberOfRoundsWon если есть победитель.
     * Если у @user Enum не имеет совпадений в перечисленных case:
     * StringBuilder записывает указанную строку, вызывает метод для
     * записи потока символов в файл и выкидывает исключение
     *
     * @param user
     * @param computer
     * @throws UnsupportedSignException
     * @throws IOException
     * @UnsupportedSignException ----------------------------------------------------------
     * ROCK > SCISSORS |  SCISSORS > PAPER    |  PAPER > ROCK
     * ROCK < PAPER    |  SCISSORS < ROCK     |  PAPER < SCISSORS
     * ROCK = ROCK     |  SCISSORS = SCISSORS |  PAPER = PAPER
     * ----------------------------------------------------------
     */
    private static void winnerInRound(User user, Computer computer) throws UnsupportedSignException, IOException {
        switch (user.getSigns()) {
            case ROCK -> {
                switch (computer.getSigns()) {
                    case ROCK -> {
                        str.append("user - rock, comp - rock --> NO WINNER")
                                .append(System.lineSeparator());
                        System.out.println("user - rock, comp - rock --> NO WINNER");
                    }
                    case SCISSORS -> {
                        str.append("user - rock, comp - scissors --> USER WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - rock, comp - scissors --> USER WIN");
                        user.setNumberOfRoundsWon(user.getNumberOfRoundsWon() + 1);
                    }
                    case PAPER -> {
                        str.append("user - rock, comp - paper --> COMP WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - rock, comp - paper --> COMP WIN");
                        computer.setNumberOfRoundsWon(computer.getNumberOfRoundsWon() + 1);
                    }
                }
            }
            case SCISSORS -> {
                switch (computer.getSigns()) {
                    case ROCK -> {
                        str.append("user - scissors, comp - rock -> COMP WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - scissors, comp - rock -> COMP WIN");
                        computer.setNumberOfRoundsWon(computer.getNumberOfRoundsWon() + 1);
                    }
                    case SCISSORS -> {
                        str.append("user - scissors, comp - scissors --> НИЧЬЯ")
                                .append(System.lineSeparator());
                        System.out.println("user - scissors, comp - scissors --> НИЧЬЯ");
                    }
                    case PAPER -> {
                        str.append("user - scissors, comp - paper --> USER WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - scissors, comp - paper --> USER WIN");
                        user.setNumberOfRoundsWon(user.getNumberOfRoundsWon() + 1);
                    }
                }
            }
            case PAPER -> {
                switch (computer.getSigns()) {
                    //user - бумага  comp - камень
                    case ROCK -> {
                        str.append("user - paper, comp - rock --> USER WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - paper, comp - rock --> USER WIN");
                        user.setNumberOfRoundsWon(user.getNumberOfRoundsWon() + 1);
                    }
                    case SCISSORS -> {
                        str.append("user - paper, comp - scissors --> COMP WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - paper, comp - scissors --> COMP WIN");
                        computer.setNumberOfRoundsWon(computer.getNumberOfRoundsWon() + 1);
                    }
                    case PAPER -> {
                        str.append("user - paper, comp - paper --> НИЧЬЯ")
                                .append(System.lineSeparator());
                        System.out.println("user - paper, comp - paper --> НИЧЬЯ");
                    }
                }
            }
            default -> {
                str.append(">EXCEPTION<: ")
                        .append("You choose wrong Sign")
                        .append(System.lineSeparator());
                fileCreator.writeToFile(str);
                throw new UnsupportedSignException("You choose wrong Sign");
            }
        }
    }

    /**
     * Метод принимает число, проходит по нему через switch
     * при соответствии return указанный Enum
     * В случаи несоответствии записывает данные в @StringBuilder,
     * вызывает метод записи в файл и
     * выкидывает исключение @UnsupportedSignException
     *
     * @param number
     * @return
     * @throws UnsupportedSignException
     * @throws IOException
     */
    private static Signs choose(Integer number) throws UnsupportedSignException, IOException {
        switch (number) {
            case 1:
                return Signs.ROCK;
            case 2:
                return Signs.SCISSORS;
            case 3:
                return Signs.PAPER;
            default:
                str.append(">EXCEPTION< :")
                        .append("You choose wrong Sign")
                        .append(System.lineSeparator());
                fileCreator.writeToFile(str);
                throw new UnsupportedSignException("You choose wrong Sign");
        }
    }
}
