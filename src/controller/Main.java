package controller;

import javax.swing.JFrame;
import model.GameHandler;
import view.MainWindow;

public class Main {

    public static GameHandler game;
    public static MainWindow gameWindow;

    public static int WIN_WIDTH = 700;
    public static int WIN_HEIGHT = 500;

    public static void main(String[] args) {
        gameWindow = new MainWindow();
        gameWindow.setTitle("Six Men's Morris");
        gameWindow.setSize(WIN_WIDTH, WIN_HEIGHT);
        gameWindow.setLocation(100, 0);
        gameWindow.setResizable(false); // window size cannot change
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setVisible(true);
        
        game = new GameHandler();
    }
}
