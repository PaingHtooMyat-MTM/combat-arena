package com.paing.combatarena;

import com.paing.combatarena.model.Player;
import com.paing.combatarena.ui.MainMenu;

public class Game {
    public static void main(String[] args) {
        Player player = new Player("Hero", 100, 100, 5);

        MainMenu menu = new MainMenu(player);
        menu.show();
    }
}
