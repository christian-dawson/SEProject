package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class Board implements Cloneable{
    
    private int piecesPlaced;
    private GamePiece pieceSelected;
    private PhaseHandler state;
    private Color turn;
    private int[] adjacent;
    private GamePiece[] layout;
    private final int[][] adjPos, mills;
    private ArrayList<GamePiece> white, black;
    
    public Board(){
        state = new PhaseHandler();
        adjacent = new int[16];
        adjacent[0] = -1;
        adjacent[1] = 5;
        adjacent[2] = -1;
        adjacent[3] = 7;
        adjacent[4] = -1;
        adjacent[5] = 1;
        adjacent[6] = -1;
        adjacent[7] = 3;
        adjacent[8] = -1;
        adjacent[9] = 13;
        adjacent[10] = -1;
        adjacent[11] = 15;
        adjacent[12] = -1;
        adjacent[13] = 9;
        adjacent[14] = -1;
        adjacent[15] = 11;
        
        turn = Color.WHITE;
        
        //instantiating game board
        layout = new GamePiece[16];
        
        //gamepiece information
        white = new ArrayList<>();
        black = new ArrayList<>();
        
        //used to validate piece movement in isValidMove()
        adjPos = new int[16][];
        mills = new int[8][];
        
        //mill locations
        mills[0] = new int[]{7,0,1};
        mills[1] = new int[]{1,2,3};
        mills[2] = new int[]{3,4,5};
        mills[3] = new int[]{5,6,7};
        mills[4] = new int[]{15,8,9};
        mills[5] = new int[]{9,10,11};
        mills[6] = new int[]{11,12,13};
        mills[7] = new int[]{13,14,15};
        
        //define adjacency
        adjPos[0] = new int[]{1,7,8};
        adjPos[1] = new int[]{0,2};
        adjPos[2] = new int[]{1,3,10};
        adjPos[3] = new int[]{2,4};
        adjPos[4] = new int[]{3,5,12};
        adjPos[5] = new int[]{4,6};
        adjPos[6] = new int[]{5,7,14};
        adjPos[7] = new int[]{0,6};
        adjPos[8] = new int[]{0,9,15};
        adjPos[9] = new int[]{8,10};
        adjPos[10] = new int[]{2,9,11};
        adjPos[11] = new int[]{10,12};
        adjPos[12] = new int[]{4,11,13};
        adjPos[13] = new int[]{12,14};
        adjPos[14] = new int[]{6,13,15};
        adjPos[15] = new int[]{8,14};
    }
    
    public Phase getState(){
        return state.currentPhase();
    }
    public void select(int position){
        pieceSelected = at(position);
    }
    public void deselect(){
        pieceSelected = null;
    }
    public GamePiece selected(){
        return pieceSelected;
    }
    public void place(GamePiece piece){
        layout[piece.getPosition()] = piece;
        if(piece.getColor() == Color.WHITE){
            white.add(layout[piece.getPosition()]);
        }
        else{
            black.add(layout[piece.getPosition()]);
        }
        piecesPlaced++;
    }
    public void setTurn(Color turn){
        this.turn = turn;
    }
    public void remove(int position){
        if(layout[position].getColor() == Color.WHITE){
            white.remove(layout[position]);
        }
        else{
            black.remove(layout[position]);
        }
        layout[position] = null;
    }
    public void move(int position, int newPosition){
        layout[position].move(newPosition);
        layout[newPosition] = layout[position];
        layout[position] = null;
    }
    
    public void makeMove(int[] move){
        if(move[0] != -1){
            if(pieceSelected != null){
                pieceSelected.deselect();
            }
            pieceSelected = at(move[0]);
            pieceSelected.select();
        }
        if(move[1] != -1){
            if(pieceSelected == null){
                place(new GamePiece(move[1], turn, this));
            }
            else{
                move(pieceSelected.getPosition(), move[1]);
                pieceSelected.deselect();
                pieceSelected = null;
            }
        }
        if(move[2] != -1){
            remove(move[2]); 
        }
        switchTurn();
    }
    
    public void switchTurn(){
        if(turn == Color.WHITE){
            turn = Color.BLACK;
        }
        else{
            turn = Color.WHITE;
        }
        if(piecesPlaced == 12 && state.currentPhase() instanceof PhaseOne){
                state.goNext();
        }
        if(piecesPlaced == 12 && (whitePieces().size() < 3 || 
                blackPieces().size() < 3)){
                    state.goNext();
        }
    }
    
    public Color getTurn(){
        return turn;
    }
    
    public GamePiece at(int position){
        return layout[position];
    }
    
    public GamePiece[] getLayout(){
        return layout;
    }
    
    public void setLayout(GamePiece[] layout){
        this.layout = layout;
    }
    
    public ArrayList<GamePiece> whitePieces(){
        return white;
    }
    
    public ArrayList<GamePiece> blackPieces(){
        return black;
    }
    
    public void setWhite(ArrayList<GamePiece> white){
        this.white = white;
    }
    public void setBlack(ArrayList<GamePiece> white){
        this.black = black;
    }
    public int[] moveableLocations(int position){
        int[] locations = new int[]{-1,-1,-1};
        int j = 0;
        for(int i : adjPos[position]){
            if(layout[i] == null){
                locations[j] = i;
                j++;
            }
        }
        return locations;
    }
    public boolean doesMoveFormMill(int[] move){
        for(int[] mill : mills){
            for(int j = 0; j < mill.length; j++){
                if(mill[j] == move[1]){
                    int x = 0;
                    if(mill[0] == move[0] || mill[1] == move[0] || mill[2] == move[0]) continue;
                    if(at(mill[0]) != null && at(mill[0]).getColor() == turn){
                        x++;
                    }
                    if(at(mill[1]) != null && at(mill[1]).getColor() == turn){
                        x++;
                    }
                    if(at(mill[2]) != null && at(mill[2]).getColor() == turn){
                        x++;
                    }
                    if(x == 2 && at(mill[j]) == null){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public Board returnCopy(){
        Board board = new Board();
        for(GamePiece piece : layout){
            if(piece == null)continue;
            if(piece.getColor() == Color.WHITE){
                board.place(new GamePiece(piece.getPosition(), Color.WHITE, board));
            }
            else{
                board.place(new GamePiece(piece.getPosition(), Color.BLACK, board));
            }
            
        }
        board.piecesPlaced = piecesPlaced;
        board.setTurn(turn);
        return board;
    }
    public boolean equals(Board board){
        System.out.println("equals called");
        for(int i = 0; i < layout.length; i++){
            if(layout[i] == null && board.getLayout()[i] != null){
                return false;
            }
            else if(layout[i] != null && board.getLayout()[i] == null){
                return false;
            }
            else if(layout[i].getColor() != board.getLayout()[i].getColor()){
                return false;
            }
        }
        return true;
    }
     public int[][] getMills(){
        return mills;
    }
    
    public boolean checkLocationAdjacency(int x, int y){
        for(int i = 0; i < adjPos[x].length; i++){
            if(adjPos[x][i] == y){
                return true;
            }
        }
        return false;
    }
    boolean isAdjacentCorner(int position){
        if(isCorner(position)){
            if(position == -1){
                return false;
            }
            if(layout[adjacent[position]] != null){
                return true;
            }
        }
        return false;
    }
    boolean isCorner(int position){
        return position == 7 ||position == 1 || position ==5 || position == 3 ||
                position == 11 ||position == 9 ||position == 15 ||position == 13;
    }
    
    public void render(Graphics g){
        for(GamePiece piece : white){
            piece.render(g);
        }
        for(GamePiece piece : black){
            piece.render(g);
        }
    }
    public static ArrayList<Point2D.Float> XYPositions(){
        //define boardLocations
        ArrayList<Point2D.Float> boardLocations = new ArrayList<>();
        boardLocations.add(new Point2D.Float(347, 44)); //0
        boardLocations.add(new Point2D.Float(623, 44)); //1
        boardLocations.add(new Point2D.Float(623, 219)); //2
        boardLocations.add(new Point2D.Float(623, 393)); //3
        boardLocations.add(new Point2D.Float(347, 393)); //4
        boardLocations.add(new Point2D.Float(67, 393)); //5
        boardLocations.add(new Point2D.Float(67, 219)); //6
        boardLocations.add(new Point2D.Float(67, 44));  //7
        boardLocations.add(new Point2D.Float(345, 131)); //8
        boardLocations.add(new Point2D.Float(483, 131)); //9
        boardLocations.add(new Point2D.Float(483, 219)); //10
        boardLocations.add(new Point2D.Float(483, 306)); //11
        boardLocations.add(new Point2D.Float(345, 306)); //12
        boardLocations.add(new Point2D.Float(206, 306)); //13
        boardLocations.add(new Point2D.Float(206, 219)); //14
        boardLocations.add(new Point2D.Float(206, 131)); //15
        return boardLocations;
    }
}
