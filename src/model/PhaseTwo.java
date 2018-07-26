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
public class PhaseTwo implements Phase {


    public boolean validateMove(int[] move){
        boolean validity = false;
        for(int i = 0; i < move.length; i++){
            if(move[i] < -1 || move[i] > 15){
                Main.game.setMessage("ERROR: movement string contains numbers NOT in the range [-1...15]");
                return validity;
            }
        }
        if(move[0] == -1 || move[1] == -1){
            Main.game.setMessage("ERROR: invalid movement string passed");
        }
        else if(move[0] == move[1]){
            Main.game.setMessage("ERROR: must move to a different square");
        }
        else if(Main.game.mode.board.at(move[0]) == null || Main.game.mode.board.at(move[0]).getColor() != Main.game.mode.board.getTurn()){
            Main.game.setMessage("ERROR: invalid piece selection");
        }
        else if(Main.game.mode.board.at(move[1]) != null || !Main.game.mode.board.checkLocationAdjacency(move[0], move[1])){
            Main.game.setMessage("ERROR: The selected piece cannot move to the passed location");
        }
        else if(move[2] != -1 && (Main.game.mode.board.at(move[2]) == null || 
                Main.game.mode.board.at(move[2]).getColor() == Main.game.mode.board.getTurn())){
            Main.game.setMessage("ERROR: invalid removal selection");
        }
        else{
            validity = true;
        }
        return validity;
    }
    public void goNext(PhaseHandler p){
        p.setPhase(new PhaseOver());
    }
}
