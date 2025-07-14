package com.paing.combatarena;

import com.paing.combatarena.logic.PlayerCreator;
import com.paing.combatarena.model.Player;
import com.paing.combatarena.ui.MainMenu;

public class Game {
    public static void main(String[] args) {
        PlayerCreator playerCreator = new PlayerCreator();
        Player player = playerCreator.createPlayer();

        MainMenu menu = new MainMenu(player);
        menu.show();
    }
}
