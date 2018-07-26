package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Main.gameWindow.pvp) {
            Main.gameWindow.removeModeSelect();
            Main.gameWindow.addGameOptions();
            Main.game.PVPStart();
            System.out.println("New Player vs. Player Game!");
        }
        if(ae.getSource() == Main.gameWindow.ava){
            System.out.println("New AI vs. AI Game!");
            Main.gameWindow.removeModeSelect();
            Main.gameWindow.addGameOptions();
            Main.game.PVAStart();
        }
        if(ae.getSource() == Main.gameWindow.exit){
            System.exit(0);
        }
    }
}
