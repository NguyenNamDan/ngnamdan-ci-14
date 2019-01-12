package game;

import game.renderer.Animation;
import game.renderer.SingleImageRenderer;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    public Sphere sphereLeft;
    public Sphere sphereRight;
    BoxColider boxColider;
    FrameCounter fireCounter;
    int bloodsPlayer;

    public Player() {
        super();
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
        this.renderer = new Animation(images); //hoat anh

        this.position.set(200,400);
        this.sphereLeft = new Sphere();
        this.sphereRight = new Sphere();
        this.updateSpherePosition();
        this.boxColider = new BoxColider(this.position, 32, 48);
        this.fireCounter = new FrameCounter(20);
        this.bloodsPlayer = 3;
    }


    @Override //ghi de len phuong thuc cua class cha
    public void run() {
        super.run();
        this.move();
        this.limitPosition();
        this.fire();
        this.updateSpherePosition();
    }

    private void updateSpherePosition() {
        this.sphereLeft.position.set(this.position)
                .add(-20,30);
        this.sphereRight.position.set(this.position)
                .add(30,30);
    }

    private void fire() {
        if(fireCounter.run()) {
            if(GameWindow.isFirePress) {
                float startAngle = -(float)Math.PI/4;
                float endAngle = -3 * (float)Math.PI/4;
                float offset = (endAngle - startAngle) / 4;

                for (int i = 0; i < 5; i++) {
                    PlayerBullet bullet = new PlayerBullet();
                    bullet.position.set(this.position.x - 15, this.position.y);
                    bullet.velocity.setAngle(startAngle + offset * i);
                    this.fireCounter.reset();
                }
            }
        }
    }

    private void move() { //di chuyen
        float vX = 0;
        float vY = 0;
        if (GameWindow.isUpPress) {
            vY = -5;
        }
        if (GameWindow.isDownPress) {
            vY = 5;
        }
        if (GameWindow.isLeftPress) {
            vX = -5;
        }
        if (GameWindow.isRightPress) {
            vX = 5;
        }
        this.velocity.set(vX, vY).setLength(5);
    }

    private void limitPosition() { //gioi han
        if (this.position.y < 0) {
            this.position.set(this.position.x, 0);
        }
        if (this.position.y > 600 - 48) {
            this.position.set(this.position.x, 600 - 48);
        }
        if (this.position.x < 16) {
            this.position.set(16,this.position.y);
        }
        if (this.position.x > 384 - 32 - 16) {
            this.position.set(384 - 32 - 16, this.position.y);
        }
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }


    public void takeDamage() {
        this.bloodsPlayer--;
        if (this.bloodsPlayer == 0) {
            this.deactive();
            this.sphereLeft.deactive();
            this.sphereRight.deactive();
        }
    }
}
