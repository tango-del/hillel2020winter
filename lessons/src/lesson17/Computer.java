package lesson17;

public class Computer extends Player {
    public Computer() {
        setName("Computer");
    }
    @Override
    public String toString() {
        return "Computer: " + getName() + ", wins: " + getNumberOfRoundsWon() + " times";
    }
}
