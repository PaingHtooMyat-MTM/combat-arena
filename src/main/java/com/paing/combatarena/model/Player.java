package com.paing.combatarena.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Character {

    public Player(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
    }

    @Override
    public void takeTurn(ArrayList<Character> enemies) {
        if (!isAlive()) {
            System.out.println(name + " is dead and cannot take a turn.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nYour turn! Choose an action:");
        System.out.println("1. Attack");
        System.out.println("2. Pass");

        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.print("Enter choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.next(); // discard invalid input
            }
        }

        if (choice == 1) {
            System.out.println("Choose an enemy to attack:");
            for (int i = 0; i < enemies.size(); i++) {
                Character enemy = enemies.get(i);
                System.out.println((i + 1) + ". " + enemy.getName() + " (HP: " + enemy.getHealth() + ")");
            }

            int targetIndex = -1;
            while (targetIndex < 0 || targetIndex >= enemies.size()) {
                System.out.print("Enter enemy number: ");
                if (scanner.hasNextInt()) {
                    targetIndex = scanner.nextInt() - 1;
                } else {
                    scanner.next(); // discard invalid input
                }
            }

            Character target = enemies.get(targetIndex);
            if (target.isAlive()) {
                attack(target);
            } else {
                System.out.println(target.getName() + " is already dead.");
            }
        } else {
            System.out.println(name + " passes the turn.");
        }
    }
}
