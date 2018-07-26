package view;

import controller.Main;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.GamePiece;

public class GamePanel extends JPanel {

    // size of the canvas - determined at runtime once rendered
    public int width;
    public int height;
    
    private Image image = null;

     public GamePanel(){
        try {
            image = ImageIO.read(getClass().getResource("board.png"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open board.png");
            System.exit(-1);
        }
    }
    
     public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        width = getSize().width;
        height = getSize().height;
        g2.setColor(Color.GRAY);
        g2.fillRect(0,0,width,height);
        g2.drawImage(image, 0, 0, width, height, null);
        g2.setStroke(new BasicStroke(5));
        Main.game.mode.board.render(g2);
       //g.drawString(Main.game.getMessage(), width/2, height/2);
    }
}
