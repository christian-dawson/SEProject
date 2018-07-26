/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Main;
import java.awt.Graphics2D;

/**
 *
 * @author Chris
 */
public abstract class GameMode {
    
    public Board board;
    
    public GameMode(){
        board = new Board();
    }
    
    public abstract void validateClick(int position);
    public abstract void validateMove(int[] data);
}
