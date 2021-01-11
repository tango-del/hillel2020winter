package lesson17.Players;

public class User extends Player {
    @Override
    public String toString() {
        return "Player: " + getName() + ", wins: " + getNumberOfRoundsWon() + " times";
    }
}
