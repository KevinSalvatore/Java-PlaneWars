package game;

import gamepad.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {
    private List<GameObject> allObj = new ArrayList<>();
    protected BackGround backGround;
    protected Player_01 plane1;
    protected Player_02 plane2;
    protected Collide collide;

    protected void addGameObject(GameObject go) {
        allObj.add(go);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (GameObject game : allObj) {
            game.draw(g);
        }
    }

    void updateLogic() {
        collide.test();
        for (GameObject game : allObj) {
            game.update();
        }
    }
}