package com.bk.game;

import com.bk.game.dto.Hero;
import com.bk.game.dto.Monster;
import com.bk.game.service.GameMech;
import com.bk.game.service.HeroCreator;
import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) {
        System.out.println("---- Select Rasa ----");
        System.out.println("1. WARRIOR");
        System.out.println("2. WIZARD");
        System.out.println("3. ARCHER");

        //select rasa
        Scanner sc = new Scanner(System.in);
        Integer rasa = sc.nextInt();

        //select name
        System.out.println("Name: ");
        String name = sc.next();
        System.out.println("name : " + name);

        Hero hero = HeroCreator.createHero(rasa, name);
        Monster monster = HeroCreator.createMonster();

        hero.setTurn(true);

        while (hero.getHealth() > 0 && monster.getHealth() > 0) {
            if (hero.isTurn()) {
                System.out.println();
                System.out.println("---- Select part of bodies ----");
                System.out.println("1. HEAD");
                System.out.println("2. BODY");
                System.out.println("3. LEGS");

                int a = sc.nextInt();
                new GameMech().game(a, hero, monster);
            } else {
                new GameMech().game(0, hero, monster);
            }
        }

        new GameMech().selectWinner(hero, monster);
    }
}
