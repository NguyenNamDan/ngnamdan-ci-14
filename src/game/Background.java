package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject {

    //ham tao
    public Background() {
        super(); //goi lai ham tao cua class cha(GameObject) //luon goi ngam
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.position.set(0,600 - this.image.getHeight());
        this.velocity.set(0,1);
    }

    @Override
    public void run() {
        super.run();
        //TODO thieu gioi han di chuyen
    }
}
