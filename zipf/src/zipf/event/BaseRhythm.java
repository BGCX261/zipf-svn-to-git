package zipf.event;

import java.util.ArrayList;
import java.util.Arrays;

public class BaseRhythm extends ArrayList {

    public BaseRhythm(int... rhythm) {
        this.addAll(Arrays.asList(rhythm));
    }

    public BaseRhythm(String rhythm) {
        int i = 0;
        for (char c : rhythm.toCharArray()) {
            if (c == ' ') {
                i++;
            } else {
                add(i);
                i = 1;
            }
        }

    }
}
