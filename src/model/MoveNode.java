//package model;
//
//import java.awt.Color;
//
///**
// *
// * @author Chris
// */
//public class MoveNode extends MoveLeaf {
//    
//    private int numChilderen;
//    private MoveNode[] childeren;
//    private AlgorithmHandler handler;
//
//    public MoveNode(Board board, int[] move, MoveNode parent, boolean max, int value) {
//        super(board, move, parent, max, value);
//        handler = new AlgorithmHandler();
//    }
//    
//    public MoveNode findChild(Board board){
//        for(MoveNode child : childeren){
//            if(child == null) continue;
//            if(child.getBoard().equals(board)){
//                return child;
//            }
//        }
//        return null;
//    }
//    
//    public MoveNode[] childeren(){
//        return childeren;
//    }
//    
//    public void addChild(MoveNode child){
//        childeren[numChilderen] = child;
//        numChilderen++;
//    }
//    
//    public void createChilderen(MoveNode parent){
//        int[] move;
//        if(parent.getBoard().piecesPlaced < 12){
//            for(int i = 0; i < parent.getBoard().getLayout().length; i++){
//                if(parent.getBoard().at(i) == null){
//                    
//                    Board board = parent.getBoard().returnCopy();
//                    move = new int[]{-1,i,-1};
//                    board.place(new GamePiece(i, board.getTurn(), board));
//                    
//                    if(board.doesMoveFormMill(i)){
//                        //System.out.println("mill formed");
//                        if(parent.getBoard().getTurn() == Color.WHITE){
//                            for(GamePiece piece : parent.getBoard().blackPieces()){
//                                board = parent.getBoard().returnCopy();
//                                move = new int[]{-1,-1,piece.getPosition()};
//                                board.makeMove(move);
//                                move = new int[]{-1,i,piece.getPosition()};
//                            }
//                        }
//                        else{
//                            for(GamePiece piece : parent.getBoard().whitePieces()){
//                                board = parent.getBoard().returnCopy();
//                                move = new int[]{-1,-1,piece.getPosition()};
//                                board.makeMove(move);
//                                move = new int[]{-1,i,piece.getPosition()};
//                            }
//                        }
//                    }
//                    board.switchTurn();
//                    MoveNode child = new MoveNode(board, move, parent, !parent.isMax(), 0);
//                    handler.evaluateMove(child);
//                    parent.addChild(child);
//                }
//            }    
//        }
//        else{
//            handler.setStrategy(new MovementStrategy());
//            if(parent.getBoard().getTurn() == Color.WHITE){
//                for(GamePiece piece : parent.getBoard().whitePieces()){
//                    int[] available = parent.getBoard().moveableLocations(piece.getPosition());
//                    for(int i = 0; i < available.length; i++){
//                        if(available[i] == -1) continue;
//                        Board board = parent.getBoard().returnCopy();
//                        move = new int[]{piece.getPosition(),available[i],-1};
//                        board.makeMove(move);
//                        if(board.doesMoveFormMill(available[i])){
//                            for(GamePiece pieces : parent.getBoard().blackPieces()){
//                                move = new int[]{-1,-1,pieces.getPosition()};
//                                board.makeMove(move);
//                                move = new int[]{piece.getPosition(),available[i],pieces.getPosition()};
//                                board.switchTurn();
//                                //parent.addChild(new MoveNode(board, move, parent, !parent.isMax(), handler.evaluateMove(board, move)));
//                       
//                            }
//                        }
//                        else{
//                            board.switchTurn();
//                            //parent.addChild(new MoveNode(board, move, parent, !parent.isMax(), handler.evaluateMove(board, move)));
//                        }
//                    }
//                }
//            }
//            else{
//                for(GamePiece piece : parent.getBoard().blackPieces()){
//                    int[] available = parent.getBoard().moveableLocations(piece.getPosition());
//                    for(int i = 0; i < available.length; i++){
//                        Board board = parent.getBoard().returnCopy();
//                        if(available[i] == -1) continue;
//                        move = new int[]{piece.getPosition(),available[i],-1};
//                        board.makeMove(move);
//                        if(board.doesMoveFormMill(available[i])){
//                            for(GamePiece pieces : parent.getBoard().whitePieces()){
//                                move = new int[]{-1,-1,pieces.getPosition()};
//                                board.makeMove(move);
//                                move = new int[]{piece.getPosition(),available[i],pieces.getPosition()};
//                                board.switchTurn();
//                                //parent.addChild(new MoveNode(board, move, parent, !parent.isMax(), handler.evaluateMove(board, move)));
//                       
//                            }
//                        }
//                        else{
//                            board.switchTurn();
//                            //parent.addChild(new MoveNode(board, move, parent, !parent.isMax(), handler.evaluateMove(board, move)));
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
