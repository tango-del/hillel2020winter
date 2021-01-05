package com.bk.game.service;

import com.bk.game.dto.Hero;
import com.bk.game.dto.Monster;

public class GameMech {
    public void game(Hero hero, Monster monster) {
        // person boolean turn getter
        if (hero.isTurn()) {
            System.out.println("----- Hero turn -----");
            System.out.println("Monster before ataka H : " + monster.getHealth());
            int lh = hero.getLHand().getAtaka();
            int rh = hero.getRHand().getAtaka();

            int ataka = hero.getStamina() + lh + rh;

            monster.setHealth(monster.getHealth() - ataka);

            hero.setTurn(false);
            monster.setTurn(true);
            System.out.println("Monster after ataka H : " + monster.getHealth());

        } else if (monster.isTurn()) {
            System.out.println("----- Monster turn -----");


            System.out.println("Hero before ataka H : " + hero.getHealth());
            hero.setHealth(hero.getHealth() - monster.getStrength());

            monster.setTurn(false);
            hero.setTurn(true);
            System.out.println("Hero after ataka H : " + hero.getHealth());

        }
    }

    public void selectWinner(Hero hero, Monster monster) {
        if (hero.getHealth() > 0) {
            System.out.println("+--------------------+");
            System.out.println("|     Hero WIN       |");
            System.out.println("+--------------------+");
        } else if (monster.getHealth() > 0) {
            System.out.println("+--------------------+");
            System.out.println("|    Monster WIN     |");
            System.out.println("+--------------------+");
        }
    }
}
