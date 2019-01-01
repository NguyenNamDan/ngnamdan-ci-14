package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    Background background;
    Player player;
    static ArrayList<PlayerBullet> bullets; //TODO: continue editing

    // hàm tạo GamePanel
    public GamePanel() {
        this.background = new Background();
        this.player = new Player();
        this.bullets = new ArrayList<>();
//        this.bullets.add();
//        this.bullets.size();
//        this.bullets.get();
    }

    @Override
    public void paint(Graphics g) {
        // vẽ game
        this.background.render(g);
        this.player.render(g);
        for(int i = 0; i < this.bullets.size(); i++) {
            PlayerBullet bullet = this.bullets.get(i);
            bullet.render(g);
        }

    }

    public void gameLoop() {
        long lastLoop = 0;
        long delay = 1000 / 60;

        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastLoop > delay) {
                this.runAll(); // ~logic
                this.renderAll(); // ~render / hien thi
                lastLoop = currentTime;
            }
        }
    }

    public void runAll() {
        this.background.run();
        this.player.run();
        for(int i = 0; i < this.bullets.size(); i++) {
            PlayerBullet bullet = this.bullets.get(i);
            bullet.run();
        }
    }

    public void renderAll() {
        this.repaint(); // goi lai ham paint()
    }
}
