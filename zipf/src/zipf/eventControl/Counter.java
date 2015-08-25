package zipf.eventControl;

import java.util.HashMap;
import zipf.IO.Settings;
import zipf.event.zTimer;
import zipf.event.interfaces.Element;
import zipf.event.interfaces.Nameable;

public class Counter {

    static HashMap<String, Integer> counts = new HashMap<String, Integer>();

    public static String countAndName(Nameable o) {
        String name = o.getClass().getSimpleName();
        int i = 0;
        if (counts.get(name) != null) {
            i = counts.get(name) + 1;
        }
        counts.put(name, i);
        Settings.setIntProp(name + "DayCount", i);
        Settings.saveSettings();
        return zTimer.getDate() + " - " + name + "°" + i;
//        settings.showPropList();
    }

    public static void setCount(String str, int value) {
        counts.put(str, value);
    }
}
