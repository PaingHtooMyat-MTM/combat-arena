package com.paing.combatarena;

import com.paing.combatarena.logic.CombatManager;
import com.paing.combatarena.model.Enemy;
import com.paing.combatarena.model.Player;

import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {
        Player player = new Player("Hero", 100, 20, 5);

        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy("Goblin", 40, 10, 2));
        enemies.add(new Enemy("Orc", 50, 15, 3));

        CombatManager combatManager = new CombatManager(player, enemies);
        combatManager.startBattle();
    }
}
