package zipf.event;

import zipf.event.conditions.ToolsEvent;
import zipf.event.interfaces.BaseEvent;

public class BaseNote implements BaseEvent {

    private int y;

    public BaseNote() {
    }

    public BaseNote(int baseNote) {
        this.y = baseNote;
    }

    @Override
    public String toString() {
        return "Basenote " + ToolsEvent.noteNames[y%12];
    }

    public int getY(){
        return y;
    }

    public void setY(int i) {
        this.y = i;
    }
}
