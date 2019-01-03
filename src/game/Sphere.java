package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Sphere extends GameObject {
    ArrayList<BufferedImage> images;
    int currentImageIndex;

    public Sphere() {
        this.images = new ArrayList<>();
        this.images.add(SpriteUtils.loadImage("assets/images/sphere/0.png"));
        this.images.add(SpriteUtils.loadImage("assets/images/sphere/1.png"));
        this.images.add(SpriteUtils.loadImage("assets/images/sphere/2.png"));
        this.images.add(SpriteUtils.loadImage("assets/images/sphere/3.png"));
        this.currentImageIndex = 0;
//        this.image = SpriteUtils.loadImage("assets/images/sphere/0.png");
    }

    @Override
    public void run() {
        super.run();
        this.fire();
    }

    int count; //TODO: coutinue editing
    private void fire() {
        this.count++;
        if(this.count > 20) {
            SphereBullet bullet = new SphereBullet();
            bullet.position.set(this.velocity);
            this.count = 0;
        }
    }

    int countRender; //TODO: coutinue editing
    @Override
    public void render(Graphics g) {
        BufferedImage currentImage = this.images.get(this.currentImageIndex);
        g.drawImage(currentImage
                , (int)this.position.x
                , (int)this.position.y
                , null);

        this.countRender++;
        if(this.count > 6) {
            this.currentImageIndex++;
            if(this.currentImageIndex >= this.images.size()) {
                this.currentImageIndex = 0;
            }
            this.countRender = 0;
        }
    }
}
