package gamepad;

import java.awt.*;

public class Airflow extends GameObject {
    Airflow(int pos_x, int pos_y, String path, int angel) {
        super(pos_x, pos_y, path, angel);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, pos_x, pos_y, Conf.airflow_R, Conf.airflow_R, null);
    }

    @Override
    public void update() {
        image = GameUtil.rotateImage(IMAGE, angel);
    }
}
