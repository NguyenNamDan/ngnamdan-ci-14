package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject{
    public PlayerBullet() {
        super();
        this.image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        this.velocity.set(0, -7);
    }

    @Override
    public void run() {
        super.run();
    }
}
