package gamepad;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Plane extends GameObject {
    public ArrayList<Bullet> bullets;
    private Airflow airflow;
    protected int life = 5;
    public Image victoryImg = GameUtil.getImage("resource/images/end.png");
    protected boolean boom = false;
    public Image boomImg = GameUtil.getImage("resource/images/boom.png");

    Plane(int pos_x, int pos_y, String path, int angel) {
        super(pos_x, pos_y, path, angel);
        init();
    }

    private void init() {
        int p_x = pos_x + Conf.plane_R / 2;
        int p_y = pos_y + Conf.plane_R + 25;

        if (angel == 45) {
            p_x = pos_x;
            p_y = pos_y + Conf.plane_R;
        }
        if (angel == 90) {
            p_x = pos_x - 25;
            p_y = pos_y + Conf.plane_R / 2;
        }
        if (angel == 135) {
            p_x = pos_x;
            p_y = pos_y;
        }
        if (angel == 180) {
            p_x = pos_x + Conf.plane_R / 2;
            p_y = pos_y - 25;
        }
        if (angel == 225) {
            p_x = pos_x + Conf.plane_R;
            p_y = pos_y;
        }
        if (angel == 270) {
            p_x = pos_x + Conf.plane_R + 25;
            p_y = pos_y + Conf.plane_R / 2;
        }
        if (angel == 315) {
            p_x = pos_x + Conf.plane_R;
            p_y = pos_y + Conf.plane_R;
        }
        p_x = p_x - Conf.airflow_R / 2;
        p_y = p_y - Conf.airflow_R / 2;
        airflow = new Airflow(p_x, p_y, "resource/images/airflow.png", angel);
        bullets = new ArrayList<>();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                boom = false;
            }
        };
        timer.schedule(timerTask, 0, 600);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, pos_x, pos_y, Conf.plane_R, Conf.plane_R, null);
        for (Bullet _bullet : bullets) {
            _bullet.draw(g);
        }
        airflow.draw(g);
        if (life == 0) {
            g.drawImage(victoryImg, Conf.WIDTH / 2 - Conf.endImg_WIDTH / 2, Conf.HEIGHT / 2 - Conf.endImg_WIDTH / 2, Conf.endImg_WIDTH, Conf.endImg_HEIGHT, null);
        }
        if (boom == true) {
            g.drawImage(boomImg, pos_x + Conf.plane_R / 2 - Conf.Boom_R / 2, pos_y + Conf.plane_R / 2 - Conf.Boom_R / 2, Conf.Boom_R, Conf.Boom_R, null);
        }
        g.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.BOLD, 24);
        g.setFont(font);
    }

    @Override
    public void update() {
        int p_x = pos_x + Conf.plane_R / 2;
        int p_y = pos_y + Conf.plane_R + 25;

        if (angel == 45) {
            p_x = pos_x;
            p_y = pos_y + Conf.plane_R;
        }
        if (angel == 90) {
            p_x = pos_x - 25;
            p_y = pos_y + Conf.plane_R / 2;
        }
        if (angel == 135) {
            p_x = pos_x;
            p_y = pos_y;
        }
        if (angel == 180) {
            p_x = pos_x + Conf.plane_R / 2;
            p_y = pos_y - 25;
        }
        if (angel == 225) {
            p_x = pos_x + Conf.plane_R;
            p_y = pos_y;
        }
        if (angel == 270) {
            p_x = pos_x + Conf.plane_R + 25;
            p_y = pos_y + Conf.plane_R / 2;
        }
        if (angel == 315) {
            p_x = pos_x + Conf.plane_R;
            p_y = pos_y + Conf.plane_R;
        }
        airflow.pos_x = p_x - Conf.airflow_R / 2;
        airflow.pos_y = p_y - Conf.airflow_R / 2;
        airflow.angel = angel;
        airflow.update();
        for (Bullet _bullet : bullets) {
            _bullet.update();
        }
    }
}
