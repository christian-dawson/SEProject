package model;

import java.awt.Color;

/**
 *
 * @author Chris
 */
public class AlgorithmHandler {
    private Strategy strategy;
    
    public AlgorithmHandler(){
        strategy = new PlacementStrategy();
    }
    
    public void setStrategy(Strategy strat){
        strategy = strat;
    }
    
    public void evaluateMove(MoveNode node){
        strategy.evaluateMove(node);
    }
}
