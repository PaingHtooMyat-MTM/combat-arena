package com.paing.combatarena.logic;

import com.paing.combatarena.model.Player;
import com.paing.combatarena.model.CharacterPresets;
import com.paing.combatarena.ui.InputHandler;
import com.paing.combatarena.utils.ColorCode;

public class PlayerCreator {

    private final InputHandler inputHandler = new InputHandler();

    public Player createPlayer() {
        while (true) {
            System.out.println("Choose a " + ColorCode.CYAN + "character " + ColorCode.RESET + "class:");
            System.out.println(ColorCode.CYAN + "1." + ColorCode.RESET + " Warrior");
            System.out.println(ColorCode.CYAN + "2." + ColorCode.RESET + " Archer");
            System.out.println(ColorCode.CYAN + "3." + ColorCode.RESET + " Mage");

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
