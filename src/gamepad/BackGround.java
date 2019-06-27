package gamepad;

import java.awt.*;

public class BackGround extends GameObject {

    BackGround(String path) {
        super(path);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, pos_x, pos_y, Conf.WIDTH, Conf.HEIGHT, null);
    }

    @Override
    public void update() {

    }
}
