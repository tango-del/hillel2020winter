package lesson17.interfaces;

import lesson17.Players.Computer;
import lesson17.Players.User;
import lesson17.enums.Signs;
import lesson17.exceptions.UnsupportedSignException;

import java.io.IOException;

public interface GameWork {
    boolean checkGameContinue(Integer countGames, String playerChooseContinue);
    void finalWinner(User user, Computer computer);
    void winnerInRound(User user, Computer computer) throws UnsupportedSignException, IOException;
    Signs choose(Integer number) throws UnsupportedSignException, IOException;
}
