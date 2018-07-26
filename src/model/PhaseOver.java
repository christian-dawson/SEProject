/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Main;

/**
 *
 * @author Chris
 */
public class PhaseOver implements Phase {
    public PhaseOver(){
        if(Main.game.mode.board.blackPieces().size() < 3){
            Main.game.setMessage("White Wins!");
        }
        else{
            Main.game.setMessage("Black Wins!");
        }
    }

    @Override
    public boolean validateMove(int[] move) {
        Main.game.setMessage("Please quit to start a new game!"); //To change body of generated methods, choose Tools | Templates.
        return false;
    }

    @Override
    public void goNext(PhaseHandler p) {
        Main.game.setMessage("Please quit to start a new game!");
    }
    
}
