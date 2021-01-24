package lesson17;

import lesson17.Players.Computer;
import lesson17.Players.User;
import java.io.*;
import java.util.Scanner;

/**
 * Написать консольную игру камень ножницы бумага
 * - пользователь должен выбирать количество игр и ввести свое имя +
 * - пользователь должен иметь возможность прервать игру +
 * - после прекращения игры пользователь должен увидеть результат +
 * - результат надо сохранить в файл - https://www.baeldung.com/java-write-to-file +
 * (если файла нет его надо создать, если файл есть то дописать результат в файл) - формат записи выбрать самому
 *
 * - переделать путь создания каталога (будет в корне проэкта) +
 * - раскинуть реализацию создания каталога с файлами и фукнционал  +
 * - Подумай как оптимизировать вычислене результата
 */

public class StartGame {
    private static FileCreator fileCreator = new FileCreator();
    private static GameFunctions gameFunctions = new GameFunctions();
    private static Scanner scanner = new Scanner(System.in);
    static StringBuilder str = new StringBuilder();
    //append(System.lineSeparator()) - добавляет новую строку

    public static void main(String[] args) throws IOException {
        start();
    }

    /**
     * Метод начинает игру Камень-Ножницы-Бумага.
     * Все действия записываются в @StringBuilder str.
     * Играет пользователь и компьютер.
     * С помощью @Scanner Пользователь называет своё Имя,
     * колличество игр которые хочет сыграть,
     * выбирает Enum @Signs который записывается в него через Setter.
     * Компьютер генерирует случайный знак в каждом раунде, после чего
     * вызывается метод для подсчета победителя в раунде.
     *
     * @throws IOException
     * @countGames уменьшается на 1 после каждого раунда
     * Пользователь выбирает хочет ли продолжить игру.
     * Когда игра заканчивается программа подсчитывает колличество выйгранных раундов
     * у обоих игроков, объявляет победителя, записывает в файл все данные @StringBuilder.
     */
    private static void start() throws IOException {
        fileCreator.checkFilesExists();

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

            user.setSigns(gameFunctions.choose(chooseUser));
            computer.setSigns(gameFunctions.choose(chooseComp));

            gameFunctions.winnerInRound(user, computer);

            --countGames; //decrease count games

            System.out.println("Want to continue? Y-y or N-n");

            str.append("Want to continue? Y-y or N-n")
                    .append(System.lineSeparator());

            playerChooseContinue = scanner.next();
            str.append(playerChooseContinue)
                    .append(System.lineSeparator());

            while (!playerChooseContinue.equalsIgnoreCase("y") && !playerChooseContinue.equalsIgnoreCase("n")) {
                System.out.println("Wrong symbol. Try again: Y-y or N-n");

                str.append("Wrong symbol. Try again: Y-y or N-n").append(System.lineSeparator());

                playerChooseContinue = scanner.next();

                str.append(playerChooseContinue).append(System.lineSeparator());
            }
        } while (gameFunctions.checkGameContinue(countGames, playerChooseContinue));

        scanner.close();

        gameFunctions.finalWinner(user, computer);

        fileCreator.writeToFile(str);
    }
}
