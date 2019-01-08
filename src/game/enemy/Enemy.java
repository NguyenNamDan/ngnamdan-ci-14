package game.enemy;

import game.GameObject;
import game.SphereBullet;
import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
    public Enemy() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/3.png"));
        this.renderer = new Animation(images); //hoat anh
        this.velocity.set(1, 0);
    }

    @Override
    public void run() {
        super.run();
        this.fire();
        this.limitPosition();
    }

    private void limitPosition() {

        if (this.position.x < 0) {
            this.velocity.set(1, 0);
        }
        if (this.position.x + 28 > 384) {
            this.velocity.set(-1, 0);
        }
    }

    int count; //TODO: coutinue editing
    private void fire() {
        this.count++;
        if (this.count > 20) {
            EnemyBullet bullet = new EnemyBullet();
            bullet.position.set(this.position);
            this.count = 0;
        }
    }
}
