package gamepad;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {
    int pos_x;
    int pos_y;
    Image image;
    int angel;
    BufferedImage IMAGE;

    GameObject(String path) {
        this.pos_y = this.pos_x = 0;
        this.image = GameUtil.getImage(path);
    }

    GameObject(int pos_x, int pos_y, String path, int angel) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.IMAGE = GameUtil.getImage(path);
        this.image = GameUtil.rotateImage(IMAGE, angel);
        this.angel = angel;
    }

    public abstract void draw(Graphics g);

    public abstract void update();
}
