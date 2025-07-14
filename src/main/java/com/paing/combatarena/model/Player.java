package com.paing.combatarena.model;

import com.paing.combatarena.ui.InputHandler;
import com.paing.combatarena.utils.ColorCode;
import com.paing.combatarena.utils.DelayUtil;

import java.util.ArrayList;

public class Player extends Character {
    private final InputHandler inputHandler;
    private boolean exitBattle = false;

    private int level = 1;
    private int exp = 0;
    private int expToLevel = 100;


    public Player(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
        this.inputHandler = new InputHandler();
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getExpToLevel() {
        return expToLevel;
    }

    public boolean wantsToExitBattle() {
        return exitBattle;
    }

    public void setExitBattle(boolean exitBattle) {
        this.exitBattle = exitBattle;
    }

    public void gainExp(int amount) {
        exp += amount;
        System.out.println(ColorCode.YELLOW + "Gained " + amount + " EXP!" + ColorCode.RESET);
        while (exp >= expToLevel) {
            levelUp();
        }
    }

    private void levelUp() {
        exp -= expToLevel;
        level++;
        expToLevel = (int) (expToLevel * 1.5);

        // Base increases
        baseHealth += 10;
        baseAttack += 2;
        baseDefense += 2;

        System.out.println(ColorCode.GREEN + "\n🎉 Level Up! You are now Level " + level + "!" + ColorCode.RESET);
        System.out.println("Base stats increased: +10 HP, +2 ATK, +2 DEF");

        // Stat point allocation
        int pointsToSpend = 2;

        while (pointsToSpend > 0) {
            System.out.println(ColorCode.YELLOW + "\nYou have " + pointsToSpend + " stat point(s) to allocate." + ColorCode.RESET);
            System.out.println(ColorCode.CYAN + "1." + ColorCode.RESET + " Increase HP (+10)");
            System.out.println(ColorCode.CYAN + "2." + ColorCode.RESET + " Increase ATK (+5)");
            System.out.println(ColorCode.CYAN + "3." + ColorCode.RESET + " Increase DEF (+3)");

            int choice = inputHandler.getIntInput("Choose a stat to increase: ");

            switch (choice) {
                case 1:
                    baseHealth += 10;
                    System.out.println("Base HP increased!");
                    break;
                case 2:
                    baseAttack += 5;
                    System.out.println("Base ATK increased!");
                    break;
                case 3:
                    baseDefense += 3;
                    System.out.println("Base DEF increased!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }
            pointsToSpend--;
        }

        resetStats(); // Heal and apply new stats
    }

//    public void increaseHealth(int amount) {
//        this.health += amount;
//    }
//
//    public void increaseAttack(int amount) {
//        this.attack += amount;
//    }
//
//    public void increaseDefense(int amount) {
//        this.defense += amount;
//    }

    @Override
    public void takeTurn(ArrayList<Character> enemies) {
        if (!isAlive()) {
            System.out.println(ColorCode.RED + name + " is dead and cannot take a turn." + ColorCode.RESET);
            return;
        }

        while (true) {
            System.out.println("\n" + ColorCode.BLUE + "Your turn! Choose an action:" + ColorCode.RESET);
            System.out.println(ColorCode.CYAN + "1." + ColorCode.RESET + " Attack");
            System.out.println(ColorCode.CYAN + "2." + ColorCode.RESET + " View Stats");
            System.out.println(ColorCode.CYAN + "3." + ColorCode.RESET + " Exit Battle");
            System.out.println("\nYour current HP: " + ColorCode.GREEN + health + ColorCode.RESET + "\n");

            int choice = inputHandler.getIntInput("Enter choice: ");

            if (choice == 1) {
                System.out.println(ColorCode.BLUE + "\nChoose an enemy to attack:" + ColorCode.RESET);
                for (int i = 0; i < enemies.size(); i++) {
                    Character enemy = enemies.get(i);
                    String status = enemy.isAlive() ? "" : (ColorCode.RED + " [DEAD]" + ColorCode.RESET);
                    System.out.println(
                            String.valueOf(ColorCode.CYAN) + (i + 1) + ". " + ColorCode.RESET +
                                    enemy.getName() + " (HP: " +
                                    ColorCode.YELLOW + enemy.getHealth() + ColorCode.RESET +
                                    ", ATK: " + ColorCode.YELLOW + enemy.getAttack() + ColorCode.RESET +
                                    ", DEF: " + ColorCode.YELLOW + enemy.getDefense() + ColorCode.RESET + ")" +
                                    status
                    );
                }

                int targetIndex = -1;
                while (targetIndex < 0 || targetIndex >= enemies.size()) {
                    targetIndex = inputHandler.getIntInput("\nEnter enemy number: ") - 1;
                    System.out.println();
                }

                Character target = enemies.get(targetIndex);
                if (target.isAlive()) {
                    attack(target);
                    System.out.println(ColorCode.GREEN + "You attacked " + target.getName() + "!" + ColorCode.RESET);
                } else {
                    System.out.println(ColorCode.RED + target.getName() + " is already dead." + ColorCode.RESET);
                }
                break;

            } else if (choice == 2) {
                System.out.println(ColorCode.BLUE + "\n=== " + name + "'s Stats ===" + ColorCode.RESET);
                System.out.println("Level: " + ColorCode.YELLOW + getLevel() + ColorCode.RESET);
                System.out.println("EXP: " + ColorCode.YELLOW + getExp() + "/" + getExpToLevel() + ColorCode.RESET);
                System.out.println("HP: " + ColorCode.YELLOW + health + ColorCode.RESET);
                System.out.println("ATK: " + ColorCode.YELLOW + attack + ColorCode.RESET);
                System.out.println("DEF: " + ColorCode.YELLOW + defense + ColorCode.RESET);

                DelayUtil.delay(3000);

            } else if (choice == 3) {
                String confirm = inputHandler.getStringInput(ColorCode.YELLOW + "Are you sure you want to exit the battle? (y/n): " + ColorCode.RESET).trim().toLowerCase();
                if (confirm.equals("y") || confirm.equals("yes")) {
                    this.setExitBattle(true);
                    System.out.println(ColorCode.YELLOW + "You chose to exit the battle. Returning to main menu..." + ColorCode.RESET);
                    break;
                } else {
                    System.out.println(ColorCode.GREEN + "Exit canceled. Back to action." + ColorCode.RESET);
                }

            } else {
                System.out.println(ColorCode.RED + "Invalid choice. Try again." + ColorCode.RESET);
            }
        }
    }
}
