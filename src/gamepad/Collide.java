package gamepad;

import java.util.ArrayList;

public class Collide {
    Player_01 player01;
    Player_02 player02;

    public Collide(Player_01 player01, Player_02 player02) {
        this.player01 = player01;
        this.player02 = player02;
    }

    public void test() {
        test_01();
        test_02();
    }

    private void test_01() {
        int pos_x = player01.pos_x + Conf.plane_R / 2;
        int pos_y = player01.pos_y + Conf.plane_R / 2;
        ArrayList<Bullet> temp = new ArrayList<>();
        for (Bullet _bullet :
                player02.bullets) {
            int p_x = _bullet.pos_x;
            int p_y = _bullet.pos_y;
            if (testFunc(pos_x, pos_y, Conf.plane_R / 2, p_x, p_y, Conf.bullet_R / 2)) {
                temp.add(_bullet);
            }
        }
        for (Bullet _bullet :
                temp) {
            player02.bullets.remove(_bullet);
            if (player01.life != 0) {
                player01.life--;
                player01.boom = true;
            }
        }
    }

    private void test_02() {
        int pos_x = player02.pos_x + Conf.plane_R / 2;
        int pos_y = player02.pos_y + Conf.plane_R / 2;
        ArrayList<Bullet> temp = new ArrayList<>();
        for (Bullet _bullet :
                player01.bullets) {
            int p_x = _bullet.pos_x;
            int p_y = _bullet.pos_y;
            if (testFunc(pos_x, pos_y, Conf.plane_R / 2, p_x, p_y, Conf.bullet_R / 2)) {
                temp.add(_bullet);
            }
        }
        for (Bullet _bullet :
                temp) {
            player01.bullets.remove(_bullet);
            if (player02.life != 0) {
                player02.life--;
                player02.boom = true;
            }
        }
    }

    private boolean testFunc(int x1, int y1, int r1, int x2, int y2, int r2) {
        int length = (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        if (length > r1 + r2)
            return false;
        else
            return true;
    }
}
