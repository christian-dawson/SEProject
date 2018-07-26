package model;

import java.awt.Color;
import java.awt.Graphics;

public class GamePiece implements Cloneable {
    private int position;
    private int diameter;
    private boolean selected;
    private Board board;
    private Color color;
    
    public GamePiece(int position, Color color, Board board){
        this.position = position;
        this.color = color;
        this.board  = board;
    }
    
    public void select(){
        selected = true;
    }
    
    public void deselect(){
        selected = false;
    }
    
    public void move(int position){
        this.position = position;
    }
    
    public int getPosition(){
        return position;
    }
    
    public Color getColor(){
        return color;
    }
    
    public void render(Graphics g){
        diameter = (int)(controller.Main.gameWindow.gamePanel.width * 0.1);
        g.setColor(color);
        g.fillOval((int)board.XYPositions().get(position).getX()-(diameter/2), 
                (int)board.XYPositions().get(position).getY()-(diameter/2), diameter, diameter);   
        if(selected){
            g.setColor(Color.YELLOW);
            g.drawOval((int)board.XYPositions().get(position).getX()-(diameter/2), 
                (int)board.XYPositions().get(position).getY()-(diameter/2), diameter, diameter);
        }
    }
    
    public void update(){
        diameter = (int)(controller.Main.gameWindow.gamePanel.width * 0.1);
    }
}
