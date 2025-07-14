package com.paing.combatarena.model;

import com.paing.combatarena.ui.InputHandler;
import com.paing.combatarena.utils.ColorCode;
import com.paing.combatarena.utils.DelayUtil;

import java.util.ArrayList;

public class Player extends Character {
    private final InputHandler inputHandler;
    private boolean exitBattle = false;

    public boolean wantsToExitBattle() {
        return exitBattle;
    }

    public void setExitBattle(boolean exitBattle) {
        this.exitBattle = exitBattle;
    }

    public Player(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
        this.inputHandler = new InputHandler();
    }

    public void increaseHealth(int amount) {
        this.health += amount;
    }

    public void increaseAttack(int amount) {
        this.attack += amount;
    }

    public void increaseDefense(int amount) {
        this.defense += amount;
    }

    @Override
    public void takeTurn(ArrayList<Character> enemies) {
        if (!isAlive()) {
            System.out.println(ColorCode.RED + name + " is dead and cannot take a turn." + ColorCode.RESET);
            return;
        }

        while (true) {
            System.out.println("\n" + ColorCode.BLUE + "Your turn! " + "Choose an action:" + ColorCode.RESET);
            System.out.println(ColorCode.CYAN + "1." + ColorCode.RESET + " Attack");
            System.out.println(ColorCode.CYAN + "2." + ColorCode.RESET + " Pass");
            System.out.println(ColorCode.CYAN + "3." + ColorCode.RESET + " View Stats");
            System.out.println(ColorCode.CYAN + "4." + ColorCode.RESET + " Exit Battle");
            System.out.println("\nYour current HP: " + ColorCode.GREEN + health + ColorCode.RESET + "\n");

            int choice = inputHandler.getIntInput("Enter choice: ");

            if (choice == 1) {
                System.out.println(ColorCode.BLUE + "\nChoose an enemy to attack:" + ColorCode.RESET);
                for (int i = 0; i < enemies.size(); i++) {
                    Character enemy = enemies.get(i);
                    String status = enemy.isAlive() ? "" : (ColorCode.RED + " [DEAD]" + ColorCode.RESET);
                    System.out.println(
                            String.valueOf(ColorCode.CYAN) +(i + 1) + ". " + ColorCode.RESET +
    enemy.getName() + " (HP: " + ColorCode.YELLOW + enemy.getHealth() + ColorCode.RESET +
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
                System.out.println(ColorCode.CYAN + name + " passes the turn." + ColorCode.RESET);
                break;

            } else if (choice == 3) {
//                System.out.println(ColorCode.BLUE + "=======================" + ColorCode.RESET);
                System.out.println(ColorCode.BLUE + "\n=== " + name + "'s Stats ===" + ColorCode.RESET);
                System.out.println("HP: " + ColorCode.YELLOW + health + ColorCode.RESET);
                System.out.println("ATK: " + ColorCode.YELLOW + attack + ColorCode.RESET);
                System.out.println("DEF: " + ColorCode.YELLOW + defense + ColorCode.RESET);

                DelayUtil.delay(3000);

            } else if (choice == 4) {
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
