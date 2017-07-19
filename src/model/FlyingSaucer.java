
package model;

import java.awt.Color;
import java.awt.Graphics2D;
import view.GamePanel;

public class FlyingSaucer extends GameFigure {
    
    private final int WIDTH = 40;
    private final int HEIGHT = 10;
    private final Color color = Color.yellow;
    private final int UNIT_TRAVEL = 5; // per frame
    
    private int direction = 1; // +1: to the right; -1 to the left
    
    public FlyingSaucer(float x, float y) {
        super(x, y);
        super.state = GameFigureState.UFO_STATE_APPEARED;
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(color);
        g.fillOval((int)(super.x - WIDTH/2), 
                (int)(super.y - HEIGHT/2), 
                WIDTH, HEIGHT);
    }

    @Override
    public void update() {
        if (direction > 0) {
            // moving to the right
            super.x += UNIT_TRAVEL;
            if (super.x + WIDTH/2 > GamePanel.width) {
                direction = -1;
            }
        } else {
            // moving to the left
            super.x -= UNIT_TRAVEL;
            if (super.x - WIDTH/2 <= 0) {
                direction = 1;
            }
        }
    }
    
}
