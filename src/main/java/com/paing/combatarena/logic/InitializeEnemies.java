package com.paing.combatarena.logic;

import com.paing.combatarena.model.Enemy;

import java.util.ArrayList;

public class InitializeEnemies {
    public static ArrayList<Enemy> getEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy("Goblin", 50, 10, 2));
        enemies.add(new Enemy("Orc", 80, 15, 3));
        return enemies;
    }
}
