package lesson17.Players;

import lesson17.enums.Signs;

public abstract class Player {
    private Signs signs; // камень ножницы бумага
    private String name;
    private int numberOfRoundsWon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfRoundsWon() {
        return numberOfRoundsWon;
    }

    public void setNumberOfRoundsWon(int numberOfRoundsWon) {
        this.numberOfRoundsWon = numberOfRoundsWon;
    }

    public Signs getSigns() {
        return signs;
    }

    public void setSigns(Signs signs) {
        this.signs = signs;
    }
}
