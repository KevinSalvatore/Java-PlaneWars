package gamepad;

import java.awt.*;

public class Bullet extends GameObject {
    Bullet(int pos_x, int pos_y, String path, int angel) {
        super(pos_x, pos_y, path, angel);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, pos_x, pos_y, Conf.bullet_R, Conf.bullet_R, null);
    }

    @Override
    public void update() {
        if (angel == 0)
            this.pos_y -= 6;
        if (angel == 45) {
            this.pos_x += 3;
            this.pos_y -= 3;
        }
        if (angel == 90)
            this.pos_x += 6;
        if (angel == 135) {
            this.pos_x += 3;
            this.pos_y += 3;
        }
        if (angel == 180)
            this.pos_y += 6;
        if (angel == 225) {
            this.pos_x -= 3;
            this.pos_y += 3;
        }
        if (angel == 270)
            this.pos_x -= 6;
        if (angel == 315) {
            this.pos_x -= 3;
            this.pos_y -= 3;
        }
    }
}
