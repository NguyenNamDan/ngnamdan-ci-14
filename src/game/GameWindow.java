package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    //static
    public GamePanel gamePanel;
    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isRightPress;
    public static boolean isLeftPress;
    public static boolean isFirePress;


    //ham tao
    public GameWindow() {
        this.setupWindow();
        this.createGamePanel();
        this.setupListener();

        this.setVisible(true);
    }

    private void setupListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    isUpPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    isDownPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    isLeftPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    isRightPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    isFirePress = true;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    isRightPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    isFirePress = false;
                }
            }
        });
    }

    private void createGamePanel() {
//        GamePanel panel = new GamePanel();
//        panel.setBackground(Color.RED);
        this.gamePanel = new GamePanel();
        this.gamePanel.setPreferredSize(new Dimension(800, 600));
        this.add(this.gamePanel);
        this.pack();
    }

    private void setupWindow() {
//        this.setSize(800, 600);
        this.setTitle("Touhou");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
