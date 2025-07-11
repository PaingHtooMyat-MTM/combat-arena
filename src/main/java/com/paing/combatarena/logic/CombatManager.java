package com.paing.combatarena.logic;

import com.paing.combatarena.model.Character;
import com.paing.combatarena.model.Enemy;
import com.paing.combatarena.model.Player;

import java.util.ArrayList;

public class CombatManager {
    private Player player;
    private ArrayList<Enemy> enemies;

    public CombatManager(Player player, ArrayList<Enemy> enemies) {
        this.player = player;
        this.enemies = enemies;
    }

    public void startBattle() {
        System.out.println("Battle Start!");
        delay(1000);

        while (player.isAlive() && enemies.stream().anyMatch(Enemy::isAlive)) {
            ArrayList<Character> enemyCharacters = new ArrayList<>(enemies);
            player.takeTurn(enemyCharacters);
            delay(2000);

            ArrayList<Character> playerList = new ArrayList<>();
            playerList.add(player);

            for (Enemy enemy : enemies) {
                if (enemy.isAlive()) {
                    enemy.takeTurn(playerList);
                    delay(2000);
                }
            }
        }

        if (player.isAlive()) {
            System.out.println("You won the battle!");
        } else {
            System.out.println("You were defeated.");
        }
    }

    private void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted!");
        }
    }
}
