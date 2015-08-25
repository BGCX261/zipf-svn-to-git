package zipf.eventControl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import zipf.event.Event;
import zipf.event.Seq;
import zipf.event.SeqNote;
import zipf.event.interfaces.Element;
import zipf.event.conditions.ToolsEvent;

public class Memory {

    public static HashMap<Long, Object> memory = new HashMap<Long, Object>();
    public static ArrayList<Seq> playing = new ArrayList<Seq>();

    public static byte[] add(Object o) {
        long id = System.currentTimeMillis();
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Memory.class.getName()).log(Level.SEVERE, null, ex);
        }
        memory.put(id, o);
        return ToolsEvent.lToBytes(id);
    }
}
