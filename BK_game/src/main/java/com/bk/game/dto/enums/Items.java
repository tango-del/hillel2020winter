package com.bk.game.dto.enums;

public enum Items {
    SHIELD(0, 50),
    SWORD(15, 25);

    private int def;
    private int ataka;

    Items(int def, int ataka) {
        this.def = def;
        this.ataka = ataka;
    }

    public int getDef() {
        return def;
    }

    public int getAtaka() {
        return ataka;
    }
}
