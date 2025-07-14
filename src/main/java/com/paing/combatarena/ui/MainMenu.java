package com.paing.combatarena.ui;

import com.paing.combatarena.logic.CombatManager;
import com.paing.combatarena.logic.InitializeEnemies;
import com.paing.combatarena.model.Enemy;
import com.paing.combatarena.model.Player;
import com.paing.combatarena.utils.ColorCode;
import com.paing.combatarena.utils.DelayUtil;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final InputHandler inputHandler = new InputHandler();
    private final Player player;
    private int currentStage = 0; // 0-based index, meaning Stage 1

    public MainMenu(Player player) {
        this.player = player;
    }



    public void show() {
        boolean running = true;
        while (running) {

            System.out.println("\n====== Main Menu ======\n");
            System.out.println(ColorCode.CYAN + "1." + ColorCode.RESET + " Enter Battle");
            System.out.println(ColorCode.CYAN + "2." + ColorCode.RESET + " Upgrade Stats");
            System.out.println(ColorCode.CYAN + "3." + ColorCode.RESET + " Upgrade Weapon");
            System.out.println(ColorCode.CYAN + "4." + ColorCode.RESET + " View Stats");
            System.out.println(ColorCode.CYAN + "5." + ColorCode.RESET + " Exit");

            int choice = inputHandler.getIntInput("\nEnter choice: ");

            switch (choice) {
                case 1:
                    initializeEnemiesAndStartBattle();
                    break;
                case 2:
//                    upgradeStats();
                    break;
                case 3:
//                    upgradeWeapon();
                    break;
                case 4:
                    viewStats();
                    break;
                case 5: {
                    System.out.println("Exiting game. Goodbye!");
                    running = false;
                    break;
                }
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void initializeEnemiesAndStartBattle() {
        List<List<Enemy>> stages = InitializeEnemies.getEnemiesPerStage();

        for (int stage = currentStage; stage < stages.size(); stage++) {
            System.out.println("\n=== STAGE " + (stage + 1) + " ===");

            List<Enemy> enemiesThisStage = stages.get(stage);

            CombatManager manager = new CombatManager(player, new ArrayList<>(enemiesThisStage));
            boolean completed = manager.startBattle();

            if (!completed) {
                System.out.println("Exiting battle. Progress saved at Stage " + (stage + 1));
                break;  // Exited early, stop game progression
            }

            if(!player.isAlive()){
                player.resetStats();
                break;
            }


            // Only update stage if player won
            currentStage = stage + 1;
            player.resetStats(); // Reset stats for next stage

            System.out.println("Stage " + (stage + 1) + " complete!\n");
        }
        System.out.println(ColorCode.GREEN + "\n🎉 You've completed the game! GG! 🎉" + ColorCode.RESET);
    }

//    private void upgradeStats() {
//        System.out.println("Choose a stat to upgrade:");
//        System.out.println("1. Increase HP (+20)");
//        System.out.println("2. Increase DEF (+2)");
//
//        int choice = scanner.nextInt();
//        switch (choice) {
//            case 1:
//                //  player.increaseHealth(20);
//                System.out.println("HP upgraded!");
//            case 2:
////                player.increaseDefense(2);
//                System.out.println("DEF upgraded!");
//            default:
//                System.out.println("Invalid choice.");
//        }
//    }
//
//    private void upgradeWeapon() {
//        System.out.println("Weapon upgraded! ATK +5");

    ////        player.increaseAttack(5);
//    }
    private void viewStats() {
        System.out.println(ColorCode.BLUE + "\n=== Your Stats ===" + ColorCode.RESET);
        System.out.println("Name: " + ColorCode.YELLOW + player.getName() + ColorCode.RESET);
        System.out.println("HP: " + ColorCode.YELLOW + player.getHealth() + ColorCode.RESET);
        System.out.println("ATK: " + ColorCode.YELLOW + player.getAttack() + ColorCode.RESET);
        System.out.println("DEF: " + ColorCode.YELLOW + player.getDefense() + ColorCode.RESET);

        DelayUtil.delay(3000);
    }
}
