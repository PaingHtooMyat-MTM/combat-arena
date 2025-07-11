
package com.paing.combatarena.ui;

import com.paing.combatarena.model.Character;
import com.paing.combatarena.utils.ColorCode;

public class BattleUI {
    public void displayTurnBanner(Character character, ColorCode colorCode) {
        System.out.println("\n" + colorCode + "--- " + character.getName() + "'s Turn ---" + ColorCode.RESET);
    }
}
