package com.paing.combatarena.model;

import com.paing.combatarena.utils.ColorCode;

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

        String nameColor = this instanceof Player ? ColorCode.GREEN.toString() : ColorCode.RED.toString();

        System.out.println(nameColor + name + ColorCode.RESET + " took " + actualDamage + " damage. Remaining HP: " + ColorCode.GREEN + health + ColorCode.RESET);
    }

    public void attack(Character target) {
        String attackerColor = this instanceof Player ? ColorCode.GREEN.toString() : ColorCode.RED.toString();
        String targetColor = target instanceof Player ? ColorCode.GREEN.toString() : ColorCode.RED.toString();

        System.out.println(attackerColor + name + ColorCode.RESET + " attacks " + targetColor + target.getName() + ColorCode.RESET + "!");
        target.takeDamage(attack);
    }

    public abstract void takeTurn(ArrayList<Character> opponents);
}
