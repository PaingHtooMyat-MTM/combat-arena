package com.paing.combatarena.logic;

import com.paing.combatarena.model.Enemy;

import java.util.ArrayList;
import java.util.List;

public class InitializeEnemies {

    public static List<List<Enemy>> getEnemiesPerStage() {
        List<List<Enemy>> levels = new ArrayList<>();

        // Level 1 enemies
        List<Enemy> level1 = new ArrayList<>();
        level1.add(new Enemy("Goblin", 140, 10, 2));
        level1.add(new Enemy("Rat", 140, 5, 1));
        levels.add(level1);

        // Level 2 enemies
        List<Enemy> level2 = new ArrayList<>();
        level2.add(new Enemy("Orc", 200, 10, 4));
        level2.add(new Enemy("Orc Archer", 150, 20, 5));
        levels.add(level2);

        // Level 3 enemies
        List<Enemy> level3 = new ArrayList<>();
        level3.add(new Enemy("Troll", 250, 20, 6));
        level3.add(new Enemy("Dark Elf", 200, 30, 7));
        levels.add(level3);

        // Level 4 enemies
        List<Enemy> level4 = new ArrayList<>();
        level4.add(new Enemy("Wraith", 150, 40, 8));
        level4.add(new Enemy("Dread Knight", 350, 20, 20));
        levels.add(level4);

        // Level 5 enemies
        List<Enemy> level5 = new ArrayList<>();
        level5.add(new Enemy("Dragon", 500, 50, 35));
        level5.add(new Enemy("Dark Sorcerer", 250, 40, 10));
        levels.add(level5);

        return levels;
    }
}
