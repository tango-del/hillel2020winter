package com.bk.game.dto.enums;

public enum Boosts {
    MANA_REGEN(15),
    HEALTH_REGEN(15);

    private int value;

    Boosts(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
