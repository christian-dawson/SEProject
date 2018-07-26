/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Main;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Chris
 */
public class MovementStrategy implements Strategy {
    
    @Override
    public void evaluateMove(MoveNode node){
        node.updateValue(5);
    }
}
