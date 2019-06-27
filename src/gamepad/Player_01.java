package gamepad;

import game.InputMsg;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Player_01 extends Plane {
    private boolean enable = true;

    Player_01(int pos_x, int pos_y, String path, int angel) {
        super(pos_x, pos_y, path, angel);
        init();
    }

    private void init() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                enable = true;
            }
        };
        timer.schedule(timerTask, 0, 500);
    }

    @Override
    public void update() {
        super.update();
        InputMsg inputMsg = InputMsg.getInst();
        if (inputMsg.getKey(KeyEvent.VK_SPACE)) {
            if (enable) {
                int p_x = pos_x + Conf.plane_R / 2 - Conf.bullet_R / 2;
                int p_y = pos_y - 20;
                if (angel == 45) {
                    p_x = pos_x + Conf.plane_R - Conf.bullet_R / 2;
                    p_y = pos_y - Conf.bullet_R / 2;
                }
                if (angel == 90) {
                    p_x = pos_x + Conf.plane_R - Conf.bullet_R / 2 + 20;
                    p_y = pos_y + Conf.plane_R / 2 - Conf.bullet_R / 2;
                }
                if (angel == 135) {
                    p_x = pos_x + Conf.plane_R - Conf.bullet_R / 2;
                    p_y = pos_y + Conf.plane_R - Conf.bullet_R / 2;
                }
                if (angel == 180) {
                    p_x = pos_x + Conf.plane_R / 2 - Conf.bullet_R / 2;
                    p_y = pos_y + Conf.plane_R - Conf.bullet_R / 2 + 20;
                }
                if (angel == 225) {
                    p_x = pos_x - Conf.bullet_R / 2;
                    p_y = pos_y + Conf.plane_R - Conf.bullet_R / 2;
                }
                if (angel == 270) {
                    p_x = pos_x - Conf.bullet_R / 2 - 20;
                    p_y = pos_y + Conf.plane_R / 2 - Conf.bullet_R / 2;
                }
                if (angel == 315) {
                    p_x = pos_x - Conf.bullet_R / 2;
                    p_y = pos_y - Conf.bullet_R / 2;
                }

                bullets.add(new Bullet(p_x, p_y, "C:\\Users\\kiman\\Desktop\\PlaneWars\\resource\\images\\bullet.png", angel));
                enable = false;
            }
        }
        if (inputMsg.getKey(KeyEvent.VK_W)) {
            if (inputMsg.getKey(KeyEvent.VK_A)) {
                this.pos_x -= 2;
                this.pos_y -= 2;
                angel = 315;
                image = GameUtil.rotateImage(IMAGE, angel);
            } else if (inputMsg.getKey(KeyEvent.VK_D)) {
                this.pos_x += 2;
                this.pos_y -= 2;
                angel = 45;
                image = GameUtil.rotateImage(IMAGE, angel);
            } else {
                this.pos_y -= 5;
                angel = 0;
                image = GameUtil.rotateImage(IMAGE, angel);
            }
            return;
        }
        if (inputMsg.getKey(KeyEvent.VK_S)) {
            if (inputMsg.getKey(KeyEvent.VK_A)) {
                this.pos_x -= 2;
                this.pos_y += 2;
                angel = 225;
                image = GameUtil.rotateImage(IMAGE, angel);
            } else if (inputMsg.getKey(KeyEvent.VK_D)) {
                this.pos_x += 2;
                this.pos_y += 2;
                angel = 135;
                image = GameUtil.rotateImage(IMAGE, angel);
            } else {
                this.pos_y += 5;
                angel = 180;
                image = GameUtil.rotateImage(IMAGE, angel);
            }
            return;
        }
        if (inputMsg.getKey(KeyEvent.VK_A)) {
            this.pos_x -= 5;
            angel = 270;
            image = GameUtil.rotateImage(IMAGE, angel);
        }
        if (inputMsg.getKey(KeyEvent.VK_D)) {
            this.pos_x += 5;
            angel = 90;
            image = GameUtil.rotateImage(IMAGE, angel);
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawString("Kevin".toUpperCase(), Conf.WIDTH / 14, 40);
        for (int i = 2; i < life + 2; i++) {
            g.drawImage(GameUtil.getImage("resource/images/heart.png"), i * Conf.WIDTH / 14, 20, Conf.heart_R, Conf.heart_R, null);
        }
    }
}
