package com.paing.combatarena.model;

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Character {
    private final int expReward;

    private static final Random random = new Random();

    public Enemy(String name, int health, int attack, int defense, int expReward) {
        super(name, health, attack, defense);
        this.expReward = expReward;
    }

    public int getExpReward() {
        return expReward;
    }

    @Override
    public void takeTurn(ArrayList<Character> opponents) {
        if (!isAlive()) {
            System.out.println(name + " is dead and cannot take a turn.");
            return;
        }

        ArrayList<Character> aliveOpponents = new ArrayList<>();
        for (Character c : opponents) {
            if (c.isAlive()) aliveOpponents.add(c);
        }

        if (aliveOpponents.isEmpty()) {
            System.out.println(name + " has no one to attack.");
            return;
        }

        Character target = aliveOpponents.get(random.nextInt(aliveOpponents.size()));
//        System.out.println("\n" + name + "'s turn.");
        attack(target);
    }
}
