//package model;
//
//import controller.Main;
//
///**
// *
// * @author Chris
// */
//public class AI {
//    private MoveNode head;
//    private boolean running;
//    private MoveNode bestMoveNode;
//    
//    public AI(){
//        head = new MoveNode();
//    }
//    public void run(MoveNode head){
//        this.head = head;
//        for(int i = 0; i < 1; i++){
//            tree.createNextDepth(tree.head());
//            applyMinMax(tree.head());
//        }
//    }
//    public void applyMinMax(MoveNode node){
//        if(node.childeren()[0] != null){
//            for(MoveNode child : node.childeren()){
//                if(child==null) continue;
//                applyMinMax(child);
//            }
//            if(node.childeren()[0].isMax()){
//                max(node);
//            }
//            else{
//                min(node);
//            }
//        }
//        if(node == tree.head()){
//            MoveNode bestNode = null;
//            for(MoveNode child : tree.head().childeren()){
//                if(bestNode == null)bestNode = child;
//                if(child == null) break;
//                if(child.returnValue() > bestNode.returnValue()){
//                   System.out.println("best move updated");
//                   bestNode = child;
//                }
//            }
//            updateBestMove(bestNode);
//        }
//    }
//    public void max(MoveNode node){
//        MoveNode bestNode = null;
//        for(MoveNode child : node.childeren()){
//            if(bestNode == null)bestNode = child;
//            if(child == null) break;
//            if(child.returnValue() > bestNode.returnValue()){
//                bestNode = child;
//            }
//        }
//        node.updateValue(bestNode.returnValue());
//    }
//    public void min(MoveNode node){
//        MoveNode worstNode = null;
//        for(MoveNode child : node.childeren()){
//            if(worstNode == null)worstNode = child;
//            if(child == null) break;
//            if(child.returnValue() < worstNode.returnValue()){
//                worstNode = child;
//            }
//        }
//        node.updateValue(worstNode.returnValue());
//    }
//    
//    public void updateBestMove(MoveNode node){
//        Main.game.bestMove = node.returnMove();
//        bestMoveNode = node;
//    }
//    public void updateHead(){
//        tree.setHead(bestMoveNode);
//    }
//    public void pause(){
//        running = false;
//    }
//}
