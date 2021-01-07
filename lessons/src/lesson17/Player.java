package lesson17;

import lesson17.enums.Signs;

public abstract class Player {
    private Signs signs; // камень ножницы бумага

    public Signs getSigns() {
        return signs;
    }

    public void setSigns(Signs signs) {
        this.signs = signs;
    }
}
