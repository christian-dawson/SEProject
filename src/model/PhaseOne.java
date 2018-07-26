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
public class PhaseOne implements Phase{
     
    public boolean validateMove(int[] move){
        boolean validity = false;
        for(int i = 0; i < move.length; i++){
            if(move[i] < -1 || move[i] > 15){
                Main.game.setMessage("ERROR: invalid movement string passed");
            }
        }
        if(move[0] != -1){
            Main.game.setMessage("ERROR: Piece selection is not available in this phase");
        }
        else if(move[1] == -1){
            Main.game.setMessage("ERROR: Please trying selecting a different place");
        }
        else if(Main.game.mode.board.at(move[1]) != null){
            Main.game.setMessage("ERROR: Please select an empty location to place a piece");
        }
        else if((move[2] != -1 && Main.game.mode.board.at(move[2]) == null) || 
                (move[2] != -1 && Main.game.mode.board.at(move[2]).getColor() == Main.game.mode.board.getTurn())){
           Main.game.setMessage("ERROR: cannot remove piece at a location that does not contain an enemy piece"); 
        }
        else{
            validity = true;
        }
        return validity;
    }
    public void goNext(PhaseHandler p){
        p.setPhase(new PhaseTwo());
    }
}
