//package model;
//
//import controller.Main;
//
///**
// *
// * @author Chris
// */
//public class MoveLeaf implements Cloneable{
//    private int[] move;
//    private int value;
//    private Board board;
//    private MoveNode parent;
//    private boolean max;
//    
//    public MoveLeaf(Board board, int[] move, MoveNode parent, boolean max, int value){
//        this.board = board;
//        this.move = move;
//        this.parent = parent;
//        this.max = max;
//        this.value = value;
//    }
//    
//    public boolean isMax(){
//        return max;
//    }
//    
//    public int returnValue(){
//        return value;
//    }
//    public void updateValue(int value){
//        this.value = value;
//    }
//    public Board getBoard(){
//        return board;
//    }
//    
//    public int returnMax(){
//        int max = 0;
//        for(MoveNode child : childeren){
//            if(child.returnValue() > max){
//                max = child.returnValue();
//            }
//        }
//        return max;
//    }
//    
//    public int returnMin(){
//        int min = 0;
//        for(MoveNode child : childeren){
//            if(child.returnValue() > min){
//                min = child.returnValue();
//            }
//        }
//        return min;
//    }
//    
//    public int[] returnMove(){
//        return move;
//    }
//}
