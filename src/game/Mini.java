package game;


import gamepad.Conf;
import gamepad.GameScene;

public class Mini {
    public static void main(String[] args) {
        Director dt = new Director("Plane Wars");
        dt.setIcon("resource/images/plane.png");
        dt.setTimeIntervale(Conf.TIMEINTERVAL);
        GameScene my = new GameScene();
        dt.runGamePanel(my);
    }
}
