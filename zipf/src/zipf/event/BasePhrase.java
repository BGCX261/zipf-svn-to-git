package zipf.event;

import java.util.ArrayList;
import java.util.Arrays;

public class BasePhrase extends ArrayList {

    public BasePhrase(int... phrase) {
        this.addAll(Arrays.asList(phrase));
    }
}
