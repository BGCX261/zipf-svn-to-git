package zipf.event.interfaces;

import java.util.HashMap;
import zipf.eventControl.ToolsChord;
import zipf.eventControl.Counter;
import zipf.event.conditions.ToolsEvent;


public interface ProcessingEvents {

    Counter counter = new Counter();
    ToolsChord chordTools = new ToolsChord();
    ToolsEvent eTools = new ToolsEvent();
    String[] noteNames = ToolsEvent.noteNames;
    HashMap<String, String[]>[] chordNames = eTools.chordNames;
}
