package com.paing.combatarena.model;

public class CharacterPresets {
    public static Player createWarrior() {
        return new Player("Warrior", 150, 100, 10);
    }

    public static Player createArcher() {
        return new Player("Archer", 100, 120, 15);
    }

    public static Player createMage() {
        return new Player("Mage", 80, 150, 20);
    }
}
