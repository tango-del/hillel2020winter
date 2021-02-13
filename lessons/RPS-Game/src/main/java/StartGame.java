import Players.Computer;
import Players.User;
import loggers.CustomLogger;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

// Console game rock paper scissors with computer
public class StartGame {
    private static FileCreator fileCreator = new FileCreator();
    private static GameFunctions gameFunctions = new GameFunctions();
    private static Scanner scanner = new Scanner(System.in);
    static StringBuilder str = new StringBuilder();
    public static ResourceBundle resourceBundle;

    public static void main(String[] args) throws IOException {
        Locale locale;

        if (args.length == 0) {
            locale = Locale.US;
        } else {
            locale = new Locale(args[0]); // ru, en, de
        }

        resourceBundle = ResourceBundle.getBundle("lang", locale);

        CustomLogger.logDebug(resourceBundle.getString("start"));

        start();

        CustomLogger.logDebug(resourceBundle.getString("end"));
    }

    private static void start() throws IOException {
        fileCreator.checkFilesExists();

        User user = new User(); // user player
        Computer computer = new Computer(); // computer player

        Integer chooseUser;
        Integer chooseComp;

        int count = 0; // passed games counter
        String playerChooseContinue; // keeps symbol that user input to continue game

        CustomLogger.logDebug(resourceBundle.getString("choose_user_name"));
        fillStrBuilder(resourceBundle.getString("choose_user_name"));

        user.setName(scanner.nextLine()); // sets user name
        fillStrBuilder(user.getName());

        CustomLogger.logDebug(resourceBundle.getString("choose_count_games"));
        fillStrBuilder(resourceBundle.getString("choose_count_games"));

        Integer countGames = scanner.nextInt(); // sets count games

        fillStrBuilder(String.valueOf(countGames));

        do {
            ++count;
            str.append(">-------------<")
                    .append(System.lineSeparator())
                    .append(resourceBundle.getString("game"))
                    .append(count)
                    .append(System.lineSeparator());

            CustomLogger.logDebug(">-------------<");
            CustomLogger.logDebug(resourceBundle.getString("game") + count);
            CustomLogger.logDebug(resourceBundle.getString("choose_sign"));
            CustomLogger.logDebug("1: " + resourceBundle.getString("rock")); //камень
            CustomLogger.logDebug("2: " + resourceBundle.getString("scissors")); // ножницы
            CustomLogger.logDebug("3: " + resourceBundle.getString("paper")); // бумага

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

            CustomLogger.logDebug(resourceBundle.getString("want_continue"));

            fillStrBuilder(resourceBundle.getString("want_continue"));

            playerChooseContinue = scanner.next();
            fillStrBuilder(playerChooseContinue);

            while (!playerChooseContinue.equalsIgnoreCase("y") && !playerChooseContinue.equalsIgnoreCase("n")) {
                CustomLogger.logWarn(resourceBundle.getString("wrong_symbol_to_continue"));

                playerChooseContinue = scanner.next();

                fillStrBuilder(playerChooseContinue);
            }
        } while (gameFunctions.checkGameContinue(countGames, playerChooseContinue));

        if (countGames > 1) {
            CustomLogger.logDebug(resourceBundle.getString("user_terminate_game") + countGames);
            CustomLogger.logWarn(resourceBundle.getString("user_terminate_game") + countGames);
        } else {
            CustomLogger.logDebug(resourceBundle.getString("played_all_games"));
        }

        scanner.close();
        CustomLogger.logWarn(resourceBundle.getString("scan_close"));

        gameFunctions.finalWinner(user, computer);

        fileCreator.writeToFile(str);
    }

    public static void fillStrBuilder(String string) {
        //System.lineSeparator() - добавляет новую строку
        str.append(string).append(System.lineSeparator());
    }
}
