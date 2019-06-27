package game;

import gamepad.Conf;
import gamepad.GameUtil;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Director {
    public JFrame frame = new JFrame();
    public GamePanel gamePanel;
    public InputMsg inputMsg;
    public int timeIntervale;

    public void setTimeIntervale(int timeIntervale) {
        this.timeIntervale = timeIntervale;
    }

    public Director(String title) {
        frame.setTitle(title);
        init();
        inputMsg = InputMsg.getInst();
    }

    public void init() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Conf.WIDTH, Conf.HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    void setIcon(String path) {
        frame.setIconImage(GameUtil.getImage(path));
    }

    private void initKeyListener() {
        this.gamePanel.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                inputMsg.setKeyStatus(e, true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                inputMsg.setKeyStatus(e, false);
            }
        });
        this.gamePanel.requestFocus();
    }

    void runGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        frame.add(gamePanel);
        initKeyListener();
        final GamePanel finalGamePanel = this.gamePanel;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                finalGamePanel.updateLogic();
                finalGamePanel.repaint();
            }
        }, 0, this.timeIntervale);
    }
}
