package view;

import controller.ButtonListener;
import controller.MouseController;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {

    public static JButton pvp;
    public static JButton pva;
    public static JButton ava;
    public static JButton exit;
    public static MouseController mouseController;
    public static JPanel modeSelect, gameOptions;
    public static GamePanel gamePanel;
    public static Container c;

    public MainWindow() {

        c = getContentPane();
        
        modeSelect = new JPanel();
        pvp = new JButton("Player vs. Player");
        modeSelect.add(pvp);
        pva = new JButton ("Player vs. A.I.");
        modeSelect.add(pva);
        ava = new JButton("A.I. vs. A.I.");
        modeSelect.add(ava);
        c.add(modeSelect, "South");
        
        gameOptions = new JPanel();
        exit = new JButton("Quit");
        gameOptions.add(exit);

        ButtonListener buttonListener = new ButtonListener();
        pvp.addActionListener(buttonListener);
        pva.addActionListener(buttonListener);
        ava.addActionListener(buttonListener);
        exit.addActionListener(buttonListener);

        // just have one Component "true", the rest must be "false"
        pvp.setFocusable(false);
        pva.setFocusable(false);
        ava.setFocusable(false);
        exit.setFocusable(false);
    }
    
    public void addMouseListener(){
        mouseController = new MouseController();
        gamePanel.addMouseListener(mouseController);
        gamePanel.addMouseMotionListener(mouseController);
    }
    
    public void displayBoard(){
        gamePanel = new GamePanel();
        c.add(gamePanel, "Center");
        gamePanel.setFocusable(true);
        revalidate();
    }
    
    public void removeModeSelect(){
        c.remove(modeSelect);
        revalidate();
    }
    public void addGameOptions(){
        c.add(gameOptions, "South");
        revalidate();
    }
}
