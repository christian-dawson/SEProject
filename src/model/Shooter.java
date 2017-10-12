package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import view.MainWindow;

public class Shooter extends GameFigure {

    Line2D.Float barrel;
    private final int BARREL_LEN = 20;

    public Shooter(int x, int y) {
        super(x, y);
        super.state = GameFigureState.SHOOTER_STATE_HEALTH_LEVEL_5;
        
        barrel = new Line2D.Float(super.x, super.y, super.x, super.y-BARREL_LEN);
    }

    @Override
    public void render(Graphics2D g) {
        g.setStroke(new BasicStroke(7)); // thickness of the line
        g.setColor(Color.YELLOW);
        int tx = MainWindow.mouseController.x;
        int ty = MainWindow.mouseController.y;
        double rad = Math.atan2(ty - super.y, tx - super.x);
        int bendy = (int)(BARREL_LEN * Math.sin(rad));
        int bendx = (int)(BARREL_LEN * Math.cos(rad));
        barrel = new Line2D.Float(super.x, super.y, super.x + bendx, super.y + bendy);
        g.draw(barrel);
    }

    @Override
    public void update() {
        // no periodic update is required (not animated)
        // if health level is implemented, update level
        // update is done via 'translate' when a key is pressed
    }

    public void translate(int dx, int dy) {
        barrel.x1 += dx;
        barrel.x2 += dx;
        barrel.y1 += dy;
        barrel.y2 += dy;
        super.x = barrel.x1;
        super.y = barrel.y1;
    }
    
    // Missile shoot location: adjut x and y to the image
    public float getXofMissileShoot() {
        return barrel.x2;
    }
    
    public float getYofMissileShoot() {
        return barrel.y2;
    }

}
