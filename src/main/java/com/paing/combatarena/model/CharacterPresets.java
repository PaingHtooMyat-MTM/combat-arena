package com.paing.combatarena.model;

public class CharacterPresets {
    public static Player createWarrior() {
        return new Player("Warrior", 250, 100, 30);
    }

    public static Player createArcher() {
        return new Player("Archer", 200, 125, 20);
    }

    public static Player createMage() {
        return new Player("Mage", 150, 550, 10);
    }
}
