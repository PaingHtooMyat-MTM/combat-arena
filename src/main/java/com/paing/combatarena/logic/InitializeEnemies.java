package com.paing.combatarena.logic;

import com.paing.combatarena.model.Enemy;

import java.util.ArrayList;
import java.util.List;

public class InitializeEnemies {

    public static List<List<Enemy>> getEnemiesPerStage() {
        List<List<Enemy>> stages = new ArrayList<>();

        // Stage 1
        List<Enemy> stage1 = new ArrayList<>();
        stage1.add(new Enemy("Goblin", 100, 10, 5, 25));
        stage1.add(new Enemy("Rat", 80, 8, 3, 20));
        stages.add(stage1);

        // Stage 2
        List<Enemy> stage2 = new ArrayList<>();
        stage2.add(new Enemy("Orc", 150, 20, 10, 40));
        stage2.add(new Enemy("Orc Archer", 120, 25, 8, 35));
        stages.add(stage2);

        // Stage 3
        List<Enemy> stage3 = new ArrayList<>();
        stage3.add(new Enemy("Troll", 220, 30, 15, 55));
        stage3.add(new Enemy("Dark Elf", 180, 35, 12, 60));
        stages.add(stage3);

        // Stage 4
        List<Enemy> stage4 = new ArrayList<>();
        stage4.add(new Enemy("Wraith", 160, 55, 18, 70));
        stage4.add(new Enemy("Dread Knight", 300, 40, 25, 80));
        stages.add(stage4);

        // Stage 5
        List<Enemy> stage5 = new ArrayList<>();
        stage5.add(new Enemy("Dragon", 500, 50, 40, 150));
        stage5.add(new Enemy("Dark Sorcerer", 250, 55, 20, 100));
        stages.add(stage5);

        return stages;
    }
}
