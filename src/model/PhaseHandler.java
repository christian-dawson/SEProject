
package model;
/**
 *
 * @author Chris
 */
public class PhaseHandler {
    private Phase phase;
    
    public PhaseHandler(){
        phase = new PhaseOne();
    }
    public boolean validateMove(int[] move){
        return phase.validateMove(move);
    }
    public void goNext(){
        phase.goNext(this);
    }
    public void setPhase(Phase phase){
        this.phase = phase;
    }
    public Phase currentPhase(){
        return phase;
    }
}
