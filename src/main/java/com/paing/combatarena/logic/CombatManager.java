package com.paing.combatarena.logic;

import com.paing.combatarena.model.Character;
import com.paing.combatarena.model.Enemy;
import com.paing.combatarena.model.Player;
import com.paing.combatarena.ui.BattleUI;
import com.paing.combatarena.ui.MenuPrinter;
import com.paing.combatarena.utils.ColorCode;
import com.paing.combatarena.utils.DelayUtil;

import java.util.ArrayList;

public class CombatManager {
    final private Player player;
    final private ArrayList<Enemy> enemies;
    final private BattleUI battleUI;
    final private MenuPrinter menuPrinter;

    public CombatManager(Player player, ArrayList<Enemy> enemies) {
        this.player = player;
        this.enemies = enemies;
        this.battleUI = new BattleUI();
        this.menuPrinter = new MenuPrinter();
    }

    public void startBattle() {
        menuPrinter.printStartMessage();
        DelayUtil.delay(1000);

        while (player.isAlive() && enemies.stream().anyMatch(Enemy::isAlive)) {
            ArrayList<Character> enemyCharacters = new ArrayList<>(enemies);
            battleUI.displayTurnBanner(player, ColorCode.GREEN );
            player.takeTurn(enemyCharacters);

            if (player.wantsToExitBattle()) {
                player.setExitBattle(false); // reset the flag for next battle
                DelayUtil.delay(2000);
                return; // immediately stop the battle
            }

            DelayUtil.delay(2000);

            ArrayList<Character> playerList = new ArrayList<>();
            playerList.add(player);

            for (Enemy enemy : enemies) {
                if (enemy.isAlive()) {
                    battleUI.displayTurnBanner(enemy, ColorCode.RED);
                    enemy.takeTurn(playerList);
                    DelayUtil.delay(2000);
                }
            }
        }

        if (player.isAlive()) {
            menuPrinter.printVictory();
        } else {
            menuPrinter.printDefeat();
        }
    }
}
