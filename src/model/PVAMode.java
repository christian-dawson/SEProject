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
public class PVAMode extends GameMode {
    private boolean playerTurn, turnComplete, playerCanRemovePiece;
    private int[] playerMove;
    
    public void validateClick(int position){
        if(playerTurn){
            turnComplete = false;
            if(playerCanRemovePiece){
                if(board.at(position) != null && board.at(position).getColor() != board.getTurn()){
                    playerMove[2] = position;
                    turnComplete = true;
                }
            }
            else if(board.getState() instanceof PhaseOne){
                if(board.at(position) == null){
                    playerMove[1] = position;
                    turnComplete = true;
                }
            }
            else if(board.getState() instanceof PhaseTwo){
                if(board.selected() == null){
                    if(board.at(position) != null && board.at(position).getColor() == board.getTurn()){
                        board.select(position);
                        playerMove[0] = position;
                        turnComplete = false;
                    }
                }
                else{
                    if(board.at(position) == null){
                        board.deselect();
                        playerMove[1] = position;
                        turnComplete = true;
                    }
                    else if(board.at(position).getColor() == board.selected().getColor()){
                        board.select(position);
                        playerMove[0] = position;
                        turnComplete = false;
                    }
                }
            }
            if(board.doesMoveFormMill(playerMove) && !playerCanRemovePiece){
                Main.game.setMessage("Please select a piece to remove");
                playerCanRemovePiece = true;
                turnComplete = false;
            }
            if(turnComplete){
                validateMove(playerMove);
                playerCanRemovePiece = false;
            }
            Main.game.drawBoard();
        }
    }
    public void validateMove(int[] data){
        
    }
}
