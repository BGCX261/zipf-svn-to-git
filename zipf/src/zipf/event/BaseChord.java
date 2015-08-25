package zipf.event;

import zipf.event.conditions.ToolsEvent;
import zipf.event.interfaces.BaseEvent;

public class BaseChord extends BaseInterval implements BaseEvent {

    int baseNoteIndex;
    public BaseNote baseNote;
    String intervals;

    public BaseChord(BaseNote baseNote, String intervals) {
        this.baseNote = baseNote;
        this.intervals = intervals;
    }

    public void setBaseNote(BaseNote baseNote) {
        this.baseNote = baseNote;
    }

    public void setIntervals(String intervals) {
        this.intervals = intervals;
    }

    @Override
    public String toString() {
        String str = ToolsEvent.noteNames[baseNote.getY()%12] + " " + ToolsEvent.chordNames[intervals.length()].get(intervals)[1];
        if (baseNoteIndex > 0) {
            str += " " + baseNoteIndex + ". Inversion";
        }
        return str;
    }

    public void setBaseNoteIndex(int index) {
        this.baseNoteIndex = index;
    }
    /* TODO string constructor
     *
     */
}
