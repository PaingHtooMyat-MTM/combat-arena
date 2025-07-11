package com.paing.combatarena.model;

import java.util.ArrayList;

public abstract class Character {
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;

    public Character(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        int actualDamage = Math.max(damage - defense, 0);
        health -= actualDamage;
        if (health < 0) health = 0;
        System.out.println(name + " took " + actualDamage + " damage. Remaining HP: " + health);
    }

    public void attack(Character target) {
        System.out.println(name + " attacks " + target.getName());
        target.takeDamage(attack);
    }

    public abstract void takeTurn(ArrayList<Character> opponents);
}
