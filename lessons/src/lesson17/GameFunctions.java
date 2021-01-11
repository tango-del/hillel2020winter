package lesson17;

import lesson17.Players.Computer;
import lesson17.Players.User;
import lesson17.enums.Signs;
import lesson17.exceptions.UnsupportedSignException;
import lesson17.interfaces.GameWork;
import java.io.IOException;

public class GameFunctions implements GameWork {
    private static FileCreator fileCreator = new FileCreator();

    /**
     * Метод проверяет что колличество заданных игр  > 0
     * а так же перезаписанная строка @playerChooseContinue
     * эквивалентна заданному параметру. @equalsIgnoreCase игнорирует верхний и нижний регистр строки.
     *
     * @param countGames
     * @param playerChooseContinue
     * @return
     */
    @Override
    public boolean checkGameContinue(Integer countGames, String playerChooseContinue) {
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
    @Override
    public void finalWinner(User user, Computer computer) {
        if (user.getNumberOfRoundsWon() < computer.getNumberOfRoundsWon()) {
            StartGame.str.append(">---------<")
                    .append(System.lineSeparator())
                    .append(">COMP--WON<")
                    .append(System.lineSeparator())
                    .append(">---------<")
                    .append(System.lineSeparator());
            System.out.println(">---------<");
            System.out.println(">COMP--WON<");
            System.out.println(">---------<");
        } else if (user.getNumberOfRoundsWon() > computer.getNumberOfRoundsWon()) {
            StartGame.str.append(">---------<")
                    .append(System.lineSeparator())
                    .append(">USER--WON<")
                    .append(System.lineSeparator())
                    .append(">---------<")
                    .append(System.lineSeparator());
            System.out.println(">---------<");
            System.out.println(">USER--WON<");
            System.out.println(">---------<");
        } else if (user.getNumberOfRoundsWon() == computer.getNumberOfRoundsWon()) {
            StartGame.str.append(">---------<")
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
        StartGame.str.append(user)
                .append(System.lineSeparator());
        StartGame.str.append(computer)
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
    @Override
    public void winnerInRound(User user, Computer computer) throws UnsupportedSignException, IOException {
        switch (user.getSigns()) {
            case ROCK -> {
                switch (computer.getSigns()) {
                    case ROCK -> {
                        StartGame.str.append("user - rock, comp - rock --> NO WINNER")
                                .append(System.lineSeparator());
                        System.out.println("user - rock, comp - rock --> NO WINNER");
                    }
                    case SCISSORS -> {
                        StartGame.str.append("user - rock, comp - scissors --> USER WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - rock, comp - scissors --> USER WIN");
                        user.setNumberOfRoundsWon(user.getNumberOfRoundsWon() + 1);
                    }
                    case PAPER -> {
                        StartGame.str.append("user - rock, comp - paper --> COMP WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - rock, comp - paper --> COMP WIN");
                        computer.setNumberOfRoundsWon(computer.getNumberOfRoundsWon() + 1);
                    }
                }
            }
            case SCISSORS -> {
                switch (computer.getSigns()) {
                    case ROCK -> {
                        StartGame.str.append("user - scissors, comp - rock -> COMP WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - scissors, comp - rock -> COMP WIN");
                        computer.setNumberOfRoundsWon(computer.getNumberOfRoundsWon() + 1);
                    }
                    case SCISSORS -> {
                        StartGame.str.append("user - scissors, comp - scissors --> НИЧЬЯ")
                                .append(System.lineSeparator());
                        System.out.println("user - scissors, comp - scissors --> НИЧЬЯ");
                    }
                    case PAPER -> {
                        StartGame.str.append("user - scissors, comp - paper --> USER WIN")
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
                        StartGame.str.append("user - paper, comp - rock --> USER WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - paper, comp - rock --> USER WIN");
                        user.setNumberOfRoundsWon(user.getNumberOfRoundsWon() + 1);
                    }
                    case SCISSORS -> {
                        StartGame.str.append("user - paper, comp - scissors --> COMP WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - paper, comp - scissors --> COMP WIN");
                        computer.setNumberOfRoundsWon(computer.getNumberOfRoundsWon() + 1);
                    }
                    case PAPER -> {
                        StartGame.str.append("user - paper, comp - paper --> НИЧЬЯ")
                                .append(System.lineSeparator());
                        System.out.println("user - paper, comp - paper --> НИЧЬЯ");
                    }
                }
            }
            default -> {
                StartGame.str.append(">EXCEPTION<: ")
                        .append("You choose wrong Sign")
                        .append(System.lineSeparator());
                fileCreator.writeToFile(StartGame.str);
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
    @Override
    public Signs choose(Integer number) throws UnsupportedSignException, IOException {
        switch (number) {
            case 1:
                return Signs.ROCK;
            case 2:
                return Signs.SCISSORS;
            case 3:
                return Signs.PAPER;
            default:
                StartGame.str.append(">EXCEPTION< :")
                        .append("You choose wrong Sign")
                        .append(System.lineSeparator());
                fileCreator.writeToFile(StartGame.str);
                throw new UnsupportedSignException("You choose wrong Sign");
        }
    }
}
