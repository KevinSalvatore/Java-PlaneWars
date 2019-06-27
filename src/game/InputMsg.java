package game;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class InputMsg {

    private Map<Integer, Boolean> keyStatus = new HashMap<>();
    private static InputMsg inst;

    private InputMsg() {
        init();
    }

    private void init() {
        for (int i = 0; i < 127; i++) {
            keyStatus.put(i, false);
        }
    }

    public static InputMsg getInst() {
        if (inst == null) {
            inst = new InputMsg();
        }
        return inst;
    }

    void setKeyStatus(KeyEvent e, boolean stat) {
        keyStatus.put(e.getKeyCode(), stat);
    }

    public boolean getKey(Integer keycode) {
        return keyStatus.get(keycode);
    }
}