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
public class PVPMode extends GameMode{
    private int[] playerMove;
    private boolean playerCanRemovePiece;
    private boolean turnComplete;
    
    public PVPMode(){
        super();
        playerMove = new int[]{-1,-1,-1};
        playerCanRemovePiece = false;
    }
    
    public void validateClick(int x){
        System.out.println("click");
        turnComplete = false;
        if(playerCanRemovePiece){
            if(board.at(x) != null && board.at(x).getColor() != board.getTurn()){
                playerMove[2] = x;
                turnComplete = true;
            }
        }
        else if(board.getState() instanceof PhaseOne){
            if(board.at(x) == null){
                playerMove[1] = x;
                turnComplete = true;
            }
        }
        else if(board.getState() instanceof PhaseTwo){
            if(board.selected() == null){
                if(board.at(x) != null && board.at(x).getColor() == board.getTurn()){
                    board.select(x);
                    playerMove[0] = x;
                    turnComplete = false;
                }
            }
            else{
                if(board.at(x) == null){
                    board.deselect();
                    playerMove[1] = x;
                    turnComplete = true;
                }
                else if(board.at(x).getColor() == board.selected().getColor()){
                    board.select(x);
                    playerMove[0] = x;
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
    
    @Override
    public void validateMove(int[] data) {
        System.out.println(data[0] + "|" + data[1] + "|" + data[2]);
        if(board.getState().validateMove(data)){
            System.out.println("valid move");
            board.makeMove(data);
            playerMove = new int[]{-1,-1,-1};
        }
    }
}
