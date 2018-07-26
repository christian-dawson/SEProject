package model;

import controller.Main;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Chris
 */
public class PlacementStrategy implements Strategy {
    @Override
    public void evaluateMove(MoveNode node){
           int value = 5;
           if(node.getBoard().isCorner(node.returnMove()[1])){
               if(node.isMax())value += 5;
               else value -= 5;
           }
           node.updateValue(value);
           
//        Main.game.print(move);
//        int value;
//        int increase;
//        if(move[2] != -1){
//            if(board.at(move[1]).getColor() == Main.game.board.getTurn()){
//                value = 5;
//            }
//            else{
//                value = 0;
//            }
//        }
//        else{
//            value = 1;
//            if(board.isCorner(move[1])){
//                value +=2;
//            }
//        }
//        if(board.at(move[1]).getColor() == Color.WHITE){
//            increase = board.whitePieces().size() - board.blackPieces().size();
//        }
//        else{
//            increase = board.blackPieces().size() - board.whitePieces().size();
//        }
//        increase *= 5;
//        return value + increase;
    }
}