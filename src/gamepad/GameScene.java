package gamepad;

import game.GamePanel;

public class GameScene extends GamePanel {

    public GameScene() {
        init();
    }

    private void init() {
        backGround = new BackGround("resource/images/background.jpg");
        this.addGameObject(backGround);
        plane1 = new Player_01(Conf.WIDTH / 5 - Conf.plane_R / 2, Conf.HEIGHT / 2 - Conf.plane_R / 2, "resource/images/plane_01.png", 90);
        this.addGameObject(plane1);
        plane2 = new Player_02(4 * Conf.WIDTH / 5 - Conf.plane_R / 2, Conf.HEIGHT / 2 - Conf.plane_R / 2, "resource/images/plane_02.png", 270);
        this.addGameObject(plane2);
        collide = new Collide(plane1, plane2);
    }
}