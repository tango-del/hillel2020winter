package lesson17;

import lesson17.enums.Signs;
import lesson17.exceptions.UnsupportedSignException;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * TODO
 * Написать консольную игру камень ножницы бумага
 * - пользователь должен выбирать количество игр и ввести свое имя +
 * - пользователь должен иметь возможность прервать игру +
 * - после прекращения игры пользователь должен увидеть результат
 * - результат надо сохранить в файл - https://www.baeldung.com/java-write-to-file
 * (если файла нет его надо создать, если файл есть то дописать результат в файл) - формат записи выбрать самому
 */

public class Start {
    // хранит полную локальную дату времени компьютера
    private static final LocalDateTime currentDateTime = LocalDateTime.now();
    // форматирует локальную дату по указанным ключам
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
    // название файла куда будут записываться результаты выполнения программы (имя файла включает отформатированное локальное время)
    private static final String nameFile = "result-" + currentDateTime.format(formatter) + ".txt";
    // строка с директорией где будет создаваться файл с результатами выполнения программы
    private static final String dirWhereSaveFile = "C:\\Users\\Tango\\IdeaProjects\\hillel2020winter\\lessons\\src\\lesson17\\results";
    // Файл который хранит директорию заданную в @String dirWhereSaveFile
    private static final File makeDirectoryToSaveResults = new File(dirWhereSaveFile);
    // Файл который хранит файл заданный в @String nameFile в директории @File makeDirectoryToSaveResults
    private static final File fileResults = new File(makeDirectoryToSaveResults, nameFile);
    private static BufferedWriter writer;
    private static final StringBuilder str = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }

    /**
     * Метод проверяет наличие файла куда будет записываться результат выполнения программы,
     * а так же проверяет наличие каталога где будет хранится этот файл.
     * Создаёт объект класса @BufferedWriter что бы записать текст в поток вывода символов
     * в конструкторе создаётся объект @FileWriter который записывает поток символов в указанны
     * File @fileResults который хранит в себе путь каталога и название файла
     *
     * @throws IOException
     */
    private static void checkFilesExists() throws IOException {
        // проверка существует ли директория, если нет то создаёт
        if (!makeDirectoryToSaveResults.exists()) {
            makeDirectoryToSaveResults.mkdir();
        }
        // проверка существует ли файл с заданным именем, если нет то создаёт
        if (!fileResults.exists()) {
            fileResults.createNewFile();
        }
        try {
            writer = new BufferedWriter(new FileWriter(fileResults));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void init() throws IOException {
        checkFilesExists();

        Scanner scanner = new Scanner(System.in);
        User user = new User();
        Computer computer = new Computer();
        Integer chooseUser;
        Integer chooseComp;
        int count = 0;
        String playerChooseContinue;

        System.out.println("Choose User Name:");
        str.append("Choose User Name:\n");

        user.setName(scanner.next());
        str.append(user.getName()).append('\n');

        System.out.println("Choose count games");
        str.append("Choose count games\n");
        Integer countGames = scanner.nextInt();
        str.append(countGames)
                .append('\n');

        do {
            ++count;
            str.append(">-------------<\n" + "GAME: ")
                    .append(count)
                    .append('\n')
                    .append("Choose sign:\n")
                    .append("1: rock\n")
                    .append("2: scissors\n")
                    .append("3: paper\n");

            System.out.println(">-------------<");
            System.out.println("GAME: " + count);
            System.out.println("Choose sign:");
            System.out.println("1: rock"); //камень
            System.out.println("2: scissors"); // ножницы
            System.out.println("3: paper"); // бумага
            //chooseUser = scanner.nextInt(); //user choose sign
            chooseUser = (int) (Math.random() * 3) + 1; //user choose sign

            chooseComp = (int) (Math.random() * 3) + 1; //comp choose sign

            user.setSigns(choose(chooseUser));
            computer.setSigns(choose(chooseComp));

            winnerInRound(user, computer);

            --countGames;

            System.out.println("Want to continue? Y-y");
            str.append("Want to continue? Y-y\n");
            playerChooseContinue = scanner.next();
            str.append(playerChooseContinue).append('\n');
        } while (checkGameContinue(countGames, playerChooseContinue));

        finalWinner(user, computer);

        writeToFile();
    }

    /**
     * Метод проверяет что колличество заданных игр  > 0
     * а так же перезаписанная строка @playerChooseContinue
     * эквиваоентна заданному параметру
     *
     * @param countGames
     * @param playerChooseContinue
     * @return
     */
    private static boolean checkGameContinue(Integer countGames, String playerChooseContinue) {
        return countGames > 0 && playerChooseContinue.equalsIgnoreCase("Y");
    }

    /**
     * Метод записывает поток символов в объект StringBuilder @str
     * который переводит в String. В конце закрывает поток.
     *
     * @throws IOException
     */
    private static void writeToFile() throws IOException {
        writer.write(str.toString());
        writer.close();
    }

    private static void finalWinner(User user, Computer computer) {
        if (user.getNumberOfRoundsWon() < computer.getNumberOfRoundsWon()) {
            str.append(">---------<")
                    .append('\n')
                    .append(">COMP--WON<")
                    .append('\n')
                    .append(">---------<")
                    .append('\n');
            System.out.println(">---------<");
            System.out.println(">COMP--WON<");
            System.out.println(">---------<");
        } else if (user.getNumberOfRoundsWon() > computer.getNumberOfRoundsWon()) {
            str.append(">---------<")
                    .append('\n')
                    .append(">USER--WON<")
                    .append('\n')
                    .append(">---------<")
                    .append('\n');
            System.out.println(">---------<");
            System.out.println(">USER--WON<");
            System.out.println(">---------<");
        } else if (user.getNumberOfRoundsWon() == computer.getNumberOfRoundsWon()) {
            str.append(">---------<")
                    .append('\n')
                    .append(">NO-WINNER<")
                    .append('\n')
                    .append(">---------<")
                    .append('\n');
            System.out.println(">---------<");
            System.out.println(">NO-WINNER<");
            System.out.println(">---------<");
        }
        //final results
        str.append(user)
                .append('\n');
        str.append(computer)
                .append('\n');
        System.out.println(user);
        System.out.println(computer);
    }

    /**
     * Метод принимает два объекта, вызывает у @user заданный Enum
     * с помощью Getter и проходит им через switch. При совпадении
     * с одним из перечисленных Enum, вызывает еще один switch
     * в котором вызывает Getter Enum Signs у @computer и при совпадении
     * с одним из перечисленных Enum : прикрпляет указанную строку в StringBuilder.
     * По указанному ниже
     *
     * ----------------------------------------------------------
     * ROCK > SCISSORS |  SCISSORS > PAPER    |  PAPER > ROCK
     * ROCK < PAPER    |  SCISSORS < ROCK     |  PAPER < SCISSORS
     * ROCK = ROCK     |  SCISSORS = SCISSORS |  PAPER = PAPER
     * ----------------------------------------------------------
     * @param user
     * @param computer
     * @throws UnsupportedSignException
     * @throws IOException
     */
    private static void winnerInRound(User user, Computer computer) throws UnsupportedSignException, IOException {
        switch (user.getSigns()) {
            case ROCK -> {
                switch (computer.getSigns()) {
                    case ROCK -> {
                        str.append("user - rock, comp - rock --> NO WINNER")
                                .append('\n');
                        System.out.println("user - rock, comp - rock --> NO WINNER");
                    }
                    case SCISSORS -> {
                        str.append("user - rock, comp - scissors --> USER WIN")
                                .append('\n');
                        System.out.println("user - rock, comp - scissors --> USER WIN");
                        user.setNumberOfRoundsWon(user.getNumberOfRoundsWon() + 1);
                    }
                    case PAPER -> {
                        str.append("user - rock, comp - paper --> COMP WIN")
                                .append('\n');
                        System.out.println("user - rock, comp - paper --> COMP WIN");
                        computer.setNumberOfRoundsWon(computer.getNumberOfRoundsWon() + 1);
                    }
                }
//                if (computer.getSigns().equals(Signs.ROCK)) {
//                    str.append("user - rock, comp - rock --> NO WINNER")
//                            .append('\n');
//                    System.out.println("user - rock, comp - rock --> NO WINNER");
//                } else if (computer.getSigns().equals(Signs.SCISSORS)) {
//                    str.append("user - rock, comp - scissors --> USER WIN")
//                            .append('\n');
//                    System.out.println("user - rock, comp - scissors --> USER WIN");
//                    user.setNumberOfRoundsWon(user.getNumberOfRoundsWon() + 1);
//                } else if (computer.getSigns().equals(Signs.PAPER)) {
//                    str.append("user - rock, comp - paper --> COMP WIN")
//                            .append('\n');
//                    System.out.println("user - rock, comp - paper --> COMP WIN");
//                    computer.setNumberOfRoundsWon(computer.getNumberOfRoundsWon() + 1);
//                }
            }
            case SCISSORS -> {
                switch (computer.getSigns()) {
                    case ROCK -> {
                        str.append("user - scrissors, comp - rock -> COMP WIN")
                                .append('\n');
                        System.out.println("user - scrissors, comp - rock -> COMP WIN");
                        computer.setNumberOfRoundsWon(computer.getNumberOfRoundsWon() + 1);
                    }
                    case SCISSORS -> {
                        str.append("user - scrissors, comp - scissors --> НИЧЬЯ")
                                .append('\n');
                        System.out.println("user - scrissors, comp - scissors --> НИЧЬЯ");
                    }
                    case PAPER -> {
                        str.append("user - scrissors, comp - paper --> USER WIN")
                                .append('\n');
                        System.out.println("user - scrissors, comp - paper --> USER WIN");
                        user.setNumberOfRoundsWon(user.getNumberOfRoundsWon() + 1);
                    }
                }
//                if (computer.getSigns().equals(Signs.ROCK)) {
//                    str.append("user - scrissors, comp - rock -> COMP WIN")
//                            .append('\n');
//                    System.out.println("user - scrissors, comp - rock -> COMP WIN");
//                    computer.setNumberOfRoundsWon(computer.getNumberOfRoundsWon() + 1);
//                } else if (computer.getSigns().equals(Signs.SCISSORS)) {
//                    str.append("user - scrissors, comp - scissors --> НИЧЬЯ")
//                            .append('\n');
//                    System.out.println("user - scrissors, comp - scissors --> НИЧЬЯ");
//                } else if (computer.getSigns().equals(Signs.PAPER)) {
//                    str.append("user - scrissors, comp - paper --> USER WIN")
//                            .append('\n');
//                    System.out.println("user - scrissors, comp - paper --> USER WIN");
//                    user.setNumberOfRoundsWon(user.getNumberOfRoundsWon() + 1);
//                }
            }
            case PAPER -> {
                switch (computer.getSigns()) {
                    case ROCK -> {
                        str.append("user - paper, comp - rock --> USER WIN")
                                .append('\n');
                        System.out.println("user - paper, comp - rock --> USER WIN");
                        user.setNumberOfRoundsWon(user.getNumberOfRoundsWon() + 1);
                    }
                    case SCISSORS -> {
                        str.append("user - paper, comp - scirssors --> COMP WIN")
                                .append('\n');
                        System.out.println("user - paper, comp - scirssors --> COMP WIN");
                        computer.setNumberOfRoundsWon(computer.getNumberOfRoundsWon() + 1);
                    }
                    case PAPER -> {
                        str.append("user - paper, comp - paper --> НИЧЬЯ")
                                .append('\n');
                        System.out.println("user - paper, comp - paper --> НИЧЬЯ");
                    }
                }
//                if (computer.getSigns().equals(Signs.ROCK)) {
//                    str.append("user - paper, comp - rock --> USER WIN")
//                            .append('\n');
//                    System.out.println("user - paper, comp - rock --> USER WIN");
//                    user.setNumberOfRoundsWon(user.getNumberOfRoundsWon() + 1);
//                } else if (computer.getSigns().equals(Signs.SCISSORS)) {
//                    str.append("user - paper, comp - scirssors --> COMP WIN")
//                            .append('\n');
//                    System.out.println("user - paper, comp - scirssors --> COMP WIN");
//                    computer.setNumberOfRoundsWon(computer.getNumberOfRoundsWon() + 1);
//                } else if (computer.getSigns().equals(Signs.PAPER)) {
//                    str.append("user - paper, comp - paper --> НИЧЬЯ")
//                            .append('\n');
//                    System.out.println("user - paper, comp - paper --> НИЧЬЯ");
//                }
            }
            default -> {
                str.append(">EXCEPTION<: ")
                        .append("You choose wrong Sign")
                        .append('\n');
                writeToFile();
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
                        .append('\n');
                writeToFile();
                throw new UnsupportedSignException("You choose wrong Sign");
        }
    }
}
