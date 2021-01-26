package com.bk.game.dto;

import com.bk.game.dto.enums.Items;
import com.bk.game.dto.enums.Rasa;
import lombok.Data;

@Data
public abstract class Person {
    private Rasa rasa;
    private String name;

    private int health; // здоровье
    private int stamina; // стамина
    private int mana;   // мана
    private int strength; // сила

    private Items lHand;
    private Items rHand;

    private Items[] boosts = new Items[4];

    private boolean turn;
}
