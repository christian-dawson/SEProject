package model;

import controller.Main;
import static controller.Main.gameWindow;
import java.awt.Graphics2D;

public class GameHandler {
    public int[] bestMove;
    
    public GameMode mode;
    private String message, opponentMove;
    private int[] movementData;
    private long currentTime, endTime;
    private long turnDuration = 4500;
    //private AI bot, testBot;

    public GameHandler() {        
        //intializes movementData to represent a null move
        movementData = new int[]{-1,-1,-1};
        bestMove = new int[]{-1,10,-1};
        
        //message definition
        message = "";
        opponentMove = "";        
    }
    
    public void PVPStart(){
        //starts the game at phase 0 with white as the first move.
        mode = new PVPMode();
        gameWindow.displayBoard();
        gameWindow.addMouseListener();
    }
    public void PVAStart(){
        ;
    }
    
    public void drawBoard(){
        Main.gameWindow.gamePanel.repaint();
        if(!message.equals("")){
            System.out.println(message);
        }
        message = "";
    }

    
    public void setMessage(String message){
        this.message = message;
    }
    public int[] translate(String movementInfo){
        try{
            String[] arr = movementInfo.split("|");
            int[] moves = new int[3];
            for(int i = 0; i < moves.length; i++){
                moves[i] = Integer.parseInt(arr[i]);
            }
            return moves;
        }
        catch(Exception e){
            e.printStackTrace();
            message = "ERROR: movement string is not in the correct format '#|#|#' ";
        }
        return new int[]{-1,-1,-1};
    }
    
    
    public void opponentMove(String move){
        opponentMove = move;
    }
    
    public String getMessage(){
        return message;
    }
}
