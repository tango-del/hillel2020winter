package com.bk.game.service;

import com.bk.game.dto.Hero;
import com.bk.game.dto.Monster;
import com.bk.game.dto.enums.Items;
import com.bk.game.dto.enums.Rasa;
import com.bk.game.exceptions.UnsupportedHeroException;

public class HeroCreator {
    public static Hero createHero(int rasa, String name) {
        Hero hero = new Hero();
        hero.setName(name);

        switch (rasa) {
            case 1:
                hero.setRasa(Rasa.WARRIOR);
                hero.setLHand(Items.SWORD);
                hero.setRHand(Items.SWORD);
                hero.setStrength(75);
                hero.setHealth(500);
                break;

            case 2:
                hero.setRasa(Rasa.WIZARD);
                hero.setLHand(Items.SWORD);
                hero.setRHand(Items.SHIELD);
                hero.setStrength(25);
                hero.setHealth(1000);
                break;

            case 3:
                hero.setRasa(Rasa.ARCHER);
                hero.setLHand(Items.SWORD);
                hero.setRHand(Items.SHIELD);
                hero.setStrength(75);
                hero.setHealth(500);
                break;

            default:
                throw new UnsupportedHeroException("Can not create hero");
        }
        return hero;
    }

    public static Monster createMonster() {
        Monster monster = new Monster();
        monster.setName("BIG MONSTER");
        monster.setHealth(1500);
        monster.setStrength(10);

        return monster;
    }
}
