package game;

import game.enemy.Enemy;
import physics.BoxColider;
import game.renderer.Animation;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject implements Physics {
    BoxColider boxColider;

    public PlayerBullet() {
        super();
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));
        this.renderer = new Animation(images, 0);
        this.velocity.set(0, -7);
        this.boxColider = new BoxColider(this.position, 30, 30);

    }

    @Override
    public void run() {
        super.run();
        Enemy enemy = GameObject.findIntersected(Enemy.class, this.boxColider);
        if (enemy != null) {
            enemy.deactive();
        }
    }


    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
