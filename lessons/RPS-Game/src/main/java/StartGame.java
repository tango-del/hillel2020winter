import Players.Computer;
import Players.User;
import loggers.CustomLogger;

import java.io.IOException;
import java.util.Scanner;

// Console game rock paper scissors with computer
public class StartGame {
    private static FileCreator fileCreator = new FileCreator();
    private static GameFunctions gameFunctions = new GameFunctions();
    private static Scanner scanner = new Scanner(System.in);
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) throws IOException {
        CustomLogger.logDebug("Program Start");
        start();
        CustomLogger.logDebug("Program end");
    }

    private static void start() throws IOException {
        fileCreator.checkFilesExists();

        User user = new User(); // user player
        Computer computer = new Computer(); // computer player

        Integer chooseUser;
        Integer chooseComp;

        int count = 0; // passed games counter
        String playerChooseContinue; // keeps symbol that user input to continue game

        System.out.println("Choose User Name:");
        fillStrBuilder("Choose User Name:");

        user.setName(scanner.next()); // sets user name
        fillStrBuilder(user.getName());
        CustomLogger.logDebug("User chose Name: " + user.getName());

        System.out.println("Choose count games");
        fillStrBuilder("Choose count games");

        Integer countGames = scanner.nextInt(); // sets count games

        fillStrBuilder(String.valueOf(countGames));
        CustomLogger.logDebug("User chose count games: " + countGames);

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
            CustomLogger.logDebug("User choose Sign : " + user.getSigns());
            computer.setSigns(gameFunctions.choose(chooseComp));
            CustomLogger.logDebug("Computer choose Sign : " + computer.getSigns());

            gameFunctions.winnerInRound(user, computer);

            --countGames; //decrease count games

            System.out.println("Want to continue? Y-y or N-n");

            fillStrBuilder("Want to continue? Y-y or N-n");

            playerChooseContinue = scanner.next();
            str.append(playerChooseContinue)
                    .append(System.lineSeparator());

            while (!playerChooseContinue.equalsIgnoreCase("y") && !playerChooseContinue.equalsIgnoreCase("n")) {
                CustomLogger.logWarn("User choose wrong symbol to continue game");

                playerChooseContinue = scanner.next();

                fillStrBuilder(playerChooseContinue);
            }
        } while (gameFunctions.checkGameContinue(countGames, playerChooseContinue));

        if (countGames > 1) {
            CustomLogger.logDebug("User decide to terminate game. Remaining count games amount : " + countGames);
            CustomLogger.logWarn("User decide to terminate game. Remaining count games amount : " + countGames);
        } else {
            CustomLogger.logDebug("User played all games");
        }

        scanner.close();
        CustomLogger.logWarn("Scanner closing");

        gameFunctions.finalWinner(user, computer);

        fileCreator.checkFilesExists();

        fileCreator.writeToFile(str);
    }

    public static void fillStrBuilder(String string) {
        //System.lineSeparator() - добавляет новую строку
        str.append(string).append(System.lineSeparator());
    }
}
