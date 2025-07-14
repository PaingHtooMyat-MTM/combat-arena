package com.paing.combatarena.model;

public class CharacterPresets {
    public static Player createWarrior() {
        return new Player("Warrior", 250, 60, 30); // Tanky with moderate damage
    }

    public static Player createArcher() {
        return new Player("Archer", 200, 75, 20); // Balanced with high attack
    }

    public static Player createMage() {
        return new Player("Mage", 150, 90, 10); // High burst, low defense
    }
}
