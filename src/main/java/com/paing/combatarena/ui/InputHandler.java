package com.paing.combatarena.ui;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // discard invalid input
            }
        }
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNext()) {
            scanner.next();
            System.out.print("Invalid input. " + prompt);
        }
        return scanner.next();
    }
}
