package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import model.Board;

public class MouseController extends MouseAdapter {
    
    public int x;
    public int y;

    @Override
    public void mousePressed(MouseEvent me) {
        x = me.getX();
        y = me.getY();
        //System.out.println("X: " + x + ", Y: " + y);
        int i = 0;
        for(Point2D.Float point : Board.XYPositions()){
            if(Math.abs(point.getX() - x) < 30 && Math.abs(point.getY() - y) < 30){
               Main.game.mode.validateClick(i);
            }
            i++;
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {
//        x = e.getX();
//        y = e.getY();
    }

}
