package com.paing.combatarena.logic;

import com.paing.combatarena.model.Player;
import com.paing.combatarena.model.CharacterPresets;
import com.paing.combatarena.ui.InputHandler;
import com.paing.combatarena.utils.ColorCode;

public class PlayerCreator {

    private final InputHandler inputHandler = new InputHandler();

    public Player createPlayer() {
        while (true) {
            System.out.println("Choose a " + ColorCode.CYAN + "character" + ColorCode.RESET + " class:\n");

            System.out.println(ColorCode.CYAN + "1. Warrior" + ColorCode.RESET + " - Tanky with moderate damage");
            System.out.println("   HP: " + ColorCode.YELLOW + "250" + ColorCode.RESET +
                    " | ATK: " + ColorCode.YELLOW + "60" + ColorCode.RESET +
                    " | DEF: " + ColorCode.YELLOW + "30" + ColorCode.RESET + "\n");

            System.out.println(ColorCode.CYAN + "2. Archer" + ColorCode.RESET + " - Balanced, fast attacker");
            System.out.println("   HP: " + ColorCode.YELLOW + "200" + ColorCode.RESET +
                    " | ATK: " + ColorCode.YELLOW + "75" + ColorCode.RESET +
                    " | DEF: " + ColorCode.YELLOW + "20" + ColorCode.RESET + "\n");

            System.out.println(ColorCode.CYAN + "3. Mage" + ColorCode.RESET + " - High burst damage, low defense");
            System.out.println("   HP: " + ColorCode.YELLOW + "150" + ColorCode.RESET +
                    " | ATK: " + ColorCode.YELLOW + "90" + ColorCode.RESET +
                    " | DEF: " + ColorCode.YELLOW + "10" + ColorCode.RESET + "\n");

            int choice = inputHandler.getIntInput("Enter choice: ");

            switch (choice) {
                case 1:
                    return CharacterPresets.createWarrior();
                case 2:
                    return CharacterPresets.createArcher();
                case 3:
                    return CharacterPresets.createMage();
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
