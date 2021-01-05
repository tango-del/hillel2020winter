package com.bk.game.service;

import com.bk.game.dto.Hero;
import com.bk.game.dto.Monster;
import com.bk.game.dto.enums.Action;

public class GameMech {
    public void game(int action, Hero hero, Monster monster) {
        // person boolean turn getter
        if (hero.isTurn()) {
            System.out.println("----- Hero turn -----");
            System.out.println("Monster before ataka H : " + monster.getHealth());
            int lh = hero.getLHand().getAtaka();
            int rh = hero.getRHand().getAtaka();

            int ataka = hero.getStamina() + lh + rh;

            double mult = mult(action);

            monster.setHealth(monster.getHealth() - (int) (ataka * mult));

            hero.setTurn(false);
            monster.setTurn(true);
            System.out.println("Monster after ataka H : " + monster.getHealth());

        } else if (monster.isTurn()) {
            System.out.println("----- Monster turn -----");
            System.out.println("Hero before ataka H : " + hero.getHealth());
            double mult = mult(0);

            hero.setHealth(hero.getHealth() - (int) (monster.getStrength() * mult));

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

    private double mult(int i) {
        Action a = getAAction(i);

        Action d = getDAction();

        if (a.equals(d)) {
            System.out.println("0.5");
            return 0.5d;
        } else {
            System.out.println("1.2");
            return 1.2d;
        }
    }

    private Action getAAction(int i) {
        if (i == 0) {
            i = (int) (Math.random() * 3) + 1;
        }

        switch (i) {
            case 1:
                return Action.HEAD;
            case 2:
                return Action.BODY;
            case 3:
                return Action.LEGS;
            default:
                return Action.BODY;
        }
    }

    private Action getDAction() {
        switch ((int) (Math.random() * 3) + 1) {
            case 1:
                return Action.HEAD;
            case 2:
                return Action.BODY;
            case 3:
                return Action.LEGS;
            default:
                return Action.BODY;
        }
    }
}
