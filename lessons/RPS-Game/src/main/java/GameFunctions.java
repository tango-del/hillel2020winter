import Players.Computer;
import Players.User;
import enums.Signs;
import exceptions.UnsupportedSignException;
import interfaces.GameWork;

import java.io.IOException;

public class GameFunctions implements GameWork {
    private static FileCreator fileCreator = new FileCreator();
    static int userQuantityWinRounds;
    static int computerQuantityWinRounds;

    /**
     * Метод проверяет что колличество заданных игр  > 0
     * а так же перезаписанная строка @playerChooseContinue
     * эквивалентна заданному параметру. @equalsIgnoreCase игнорирует верхний и нижний регистр строки.
     *
     * @param countGames           - колличество заданных игр пользователем
     * @param playerChooseContinue - строка которую заполняет пользователь после каждого раунда
     * @return - результат обоих условий true\false
     */
    @Override
    public boolean checkGameContinue(Integer countGames, String playerChooseContinue) {
        return countGames > 0 && playerChooseContinue.equalsIgnoreCase("Y");
    }

    /**
     * Через @setNumberOfRoundsWon в оба объекта
     * записывается колличество выйгранных раундов @QuantityWinRounds
     * сверяет у двух объектов @NumberOfRoundsWon
     * Записывает в @StringBuilder результат подходящего условия
     * а так же переопределенный метод @toString у обоих объектов
     *
     * @param user     - объект игрока пользователь
     * @param computer - объект игрока компьютер
     */
    @Override
    public void finalWinner(User user, Computer computer) {
        user.setNumberOfRoundsWon(userQuantityWinRounds);
        computer.setNumberOfRoundsWon(computerQuantityWinRounds);

        if (userQuantityWinRounds < computerQuantityWinRounds) {
            StartGame.str.append(">---------<")
                    .append(System.lineSeparator())
                    .append(">COMP--WON<")
                    .append(System.lineSeparator())
                    .append(">---------<")
                    .append(System.lineSeparator());
            System.out.println(">---------<");
            System.out.println(">COMP--WON<");
            System.out.println(">---------<");
        } else if (userQuantityWinRounds > computerQuantityWinRounds) {
            StartGame.str.append(">---------<")
                    .append(System.lineSeparator())
                    .append(">USER--WON<")
                    .append(System.lineSeparator())
                    .append(">---------<")
                    .append(System.lineSeparator());
            System.out.println(">---------<");
            System.out.println(">USER--WON<");
            System.out.println(">---------<");
        } else if (userQuantityWinRounds == computerQuantityWinRounds) {
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
     * инкрементит @QuantityWinRounds если есть победитель.
     * Если у @user Enum не имеет совпадений в перечисленных case:
     * StringBuilder записывает указанную строку, вызывает метод для
     * записи потока символов в файл и выкидывает исключение
     *
     * @param user     - объект игрока пользователь
     * @param computer - объект игрока компьютер
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
            case ROCK: {
                switch (computer.getSigns()) {
                    case ROCK: {
                        StartGame.str.append("user - rock, comp - rock --> NO WINNER")
                                .append(System.lineSeparator());
                        System.out.println("user - rock, comp - rock --> NO WINNER");
                        break;
                    }
                    case SCISSORS: {
                        StartGame.str.append("user - rock, comp - scissors --> USER WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - rock, comp - scissors --> USER WIN");
                        ++userQuantityWinRounds;
                        break;
                    }
                    case PAPER: {
                        StartGame.str.append("user - rock, comp - paper --> COMP WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - rock, comp - paper --> COMP WIN");
                        ++computerQuantityWinRounds;
                        break;
                    }
                }
                break;
            }
            case SCISSORS: {
                switch (computer.getSigns()) {
                    case ROCK: {
                        StartGame.str.append("user - scissors, comp - rock -> COMP WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - scissors, comp - rock -> COMP WIN");
                        ++computerQuantityWinRounds;
                        break;
                    }
                    case SCISSORS: {
                        StartGame.str.append("user - scissors, comp - scissors --> НИЧЬЯ")
                                .append(System.lineSeparator());
                        System.out.println("user - scissors, comp - scissors --> НИЧЬЯ");
                        break;
                    }
                    case PAPER: {
                        StartGame.str.append("user - scissors, comp - paper --> USER WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - scissors, comp - paper --> USER WIN");
                        ++userQuantityWinRounds;
                        break;
                    }
                }
                break;
            }
            case PAPER: {
                switch (computer.getSigns()) {
                    case ROCK: {
                        StartGame.str.append("user - paper, comp - rock --> USER WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - paper, comp - rock --> USER WIN");
                        ++userQuantityWinRounds;
                        break;
                    }
                    case SCISSORS: {
                        StartGame.str.append("user - paper, comp - scissors --> COMP WIN")
                                .append(System.lineSeparator());
                        System.out.println("user - paper, comp - scissors --> COMP WIN");
                        ++computerQuantityWinRounds;
                        break;
                    }
                    case PAPER: {
                        StartGame.str.append("user - paper, comp - paper --> НИЧЬЯ")
                                .append(System.lineSeparator());
                        System.out.println("user - paper, comp - paper --> НИЧЬЯ");
                        break;
                    }
                }
                break;
            }
            default: {
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
     * @param number - число которое выбрал один из игроков для выбора Sign
     * @return - Sign rock/paper/scissort
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
