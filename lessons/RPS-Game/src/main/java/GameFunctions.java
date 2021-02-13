import Players.Computer;
import Players.User;
import enums.Signs;
import exceptions.UnsupportedSignException;
import interfaces.GameWork;
import loggers.CustomLogger;

import java.io.IOException;
import java.util.ResourceBundle;

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
            StartGame.fillStrBuilder(">---------<");
            StartGame.fillStrBuilder(StartGame.resourceBundle.getString("comp_win1"));
            StartGame.fillStrBuilder(">---------<");
            CustomLogger.logDebug(StartGame.resourceBundle.getString("comp_win2"));

        } else if (userQuantityWinRounds > computerQuantityWinRounds) {
            StartGame.fillStrBuilder(">---------<");
            StartGame.fillStrBuilder(StartGame.resourceBundle.getString("user_win1"));
            StartGame.fillStrBuilder(">---------<");
            CustomLogger.logDebug(StartGame.resourceBundle.getString("user_win2"));

        } else if (userQuantityWinRounds == computerQuantityWinRounds) {
            StartGame.fillStrBuilder(">---------<");
            StartGame.fillStrBuilder(StartGame.resourceBundle.getString("no_win1"));
            StartGame.fillStrBuilder(">---------<");
            CustomLogger.logDebug(StartGame.resourceBundle.getString("no_win2"));
        }
        //final results
        String userResult =
                StartGame.resourceBundle.getString("player") +
                user.getName() + " " +
                StartGame.resourceBundle.getString("won") +
                userQuantityWinRounds + " " +
                StartGame.resourceBundle.getString("times");

        String compResult =
                StartGame.resourceBundle.getString("computer") + " " +
                        StartGame.resourceBundle.getString("won") +
                        computerQuantityWinRounds + " " +
                        StartGame.resourceBundle.getString("times");

        StartGame.fillStrBuilder(userResult);
        CustomLogger.logDebug(userResult);
        StartGame.fillStrBuilder(compResult);
        CustomLogger.logDebug(compResult);
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
     * @throws UnsupportedSignException - если будет выбран не верный знак
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
                        StartGame.fillStrBuilder(StartGame.resourceBundle.getString("userRock_compRock_NoWin"));
                        CustomLogger.logDebug(StartGame.resourceBundle.getString("userRock_compRock_NoWin"));
                        break;
                    }
                    case SCISSORS: {
                        StartGame.fillStrBuilder(StartGame.resourceBundle.getString("userRock_compSciss_Uwin"));
                        CustomLogger.logDebug(StartGame.resourceBundle.getString("userRock_compSciss_Uwin"));
                        ++userQuantityWinRounds;
                        break;
                    }
                    case PAPER: {
                        StartGame.fillStrBuilder(StartGame.resourceBundle.getString("userRock_compPaper_CompWin"));
                        CustomLogger.logDebug(StartGame.resourceBundle.getString("userRock_compPaper_CompWin"));
                        ++computerQuantityWinRounds;
                        break;
                    }
                }
                break;
            }
            case SCISSORS: {
                switch (computer.getSigns()) {
                    case ROCK: {
                        StartGame.fillStrBuilder(StartGame.resourceBundle.getString("userSciss_compRock_CompWin"));
                        CustomLogger.logDebug(StartGame.resourceBundle.getString("userSciss_compRock_CompWin"));
                        ++computerQuantityWinRounds;
                        break;
                    }
                    case SCISSORS: {
                        StartGame.fillStrBuilder(StartGame.resourceBundle.getString("userSciss_compSciss_NoWin"));
                        CustomLogger.logDebug(StartGame.resourceBundle.getString("userSciss_compSciss_NoWin"));
                        break;
                    }
                    case PAPER: {
                        StartGame.fillStrBuilder(StartGame.resourceBundle.getString("userSciss_compPaper_Uwin"));
                        CustomLogger.logDebug(StartGame.resourceBundle.getString("userSciss_compPaper_Uwin"));
                        ++userQuantityWinRounds;
                        break;
                    }
                }
                break;
            }
            case PAPER: {
                switch (computer.getSigns()) {
                    case ROCK: {
                        StartGame.fillStrBuilder(StartGame.resourceBundle.getString("userPaper_compRock_Uwin"));
                        CustomLogger.logDebug(StartGame.resourceBundle.getString("userPaper_compRock_Uwin"));
                        ++userQuantityWinRounds;
                        break;
                    }
                    case SCISSORS: {
                        StartGame.fillStrBuilder(StartGame.resourceBundle.getString("userPaper_compSciss_CompWin"));
                        CustomLogger.logDebug(StartGame.resourceBundle.getString("userPaper_compSciss_CompWin"));
                        ++computerQuantityWinRounds;
                        break;
                    }
                    case PAPER: {
                        StartGame.fillStrBuilder(StartGame.resourceBundle.getString("userPaper_compPaper_NoWin"));
                        CustomLogger.logDebug(StartGame.resourceBundle.getString("userPaper_compPaper_NoWin"));
                        break;
                    }
                }
                break;
            }
            default: {
                StartGame.fillStrBuilder(">EXCEPTION<: " + StartGame.resourceBundle.getString("player_choose_wrong_sign"));
                fileCreator.writeToFile(StartGame.str);
                CustomLogger.logError("exceptions.UnsupportedSignException: " + StartGame.resourceBundle.getString("player_choose_wrong_sign"));
                CustomLogger.logDebug(StartGame.resourceBundle.getString("program_end_error"));
                throw new UnsupportedSignException(StartGame.resourceBundle.getString("player_choose_wrong_sign"));
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
     * @throws UnsupportedSignException - если будет выбран не верный знак
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
            default: {
                StartGame.fillStrBuilder(">EXCEPTION< : " + StartGame.resourceBundle.getString("player_choose_wrong_sign"));
                fileCreator.writeToFile(StartGame.str);

                CustomLogger.logError("exceptions.UnsupportedSignException: " + StartGame.resourceBundle.getString("player_choose_wrong_sign"));
                CustomLogger.logDebug(StartGame.resourceBundle.getString("program_end_error"));
                throw new UnsupportedSignException(StartGame.resourceBundle.getString("player_choose_wrong_sign"));
            }
        }
    }
}
