package com.paing.combatarena.utils;

public class DelayUtil {
    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted!");
        }
    }
}
