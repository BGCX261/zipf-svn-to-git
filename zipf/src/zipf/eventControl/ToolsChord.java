package zipf.eventControl;

import java.awt.Event;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import zipf.event.conditions.ToolsEvent;
import zipf.event.interfaces.ProcessingEvents;
import zipf.event.BaseChord;
import zipf.event.BaseNote;
import zipf.event.Note;
import zipf.event.Pool;

public class ToolsChord implements ProcessingEvents {

    public static BaseChord chordAnalyze(Integer[] pitch) {

        int mode = pitch.length;
        BaseChord baseChord = null;
        Integer c = getIntervals(pitch);
        String chord = c.toString();
        z:
        while (mode > 2 && mode < 6) {
            chord += chord;
            for (String str : chordNames[mode].keySet()) {
                if (chord.contains(str)) {
                    int index = chord.indexOf(str);
                    BaseNote baseNote = new BaseNote(pitch[index]);
                    EventController.fireBaseNote(baseNote);
                    baseChord = new BaseChord(baseNote, str);
                    break z;
                }

            }
            --mode;
        }
        return baseChord;
    }

    public static int getIntervals(Integer[] pitch) {
        int chord = 0;
        if (pitch.length > 1) {
            for (int j = 1; j < pitch.length; j++) {
                chord += Math.abs(pitch[j] - pitch[j - 1]);
                chord *= 10;
            }
            chord += (12 - pitch[pitch.length - 1] + pitch[0]);
        }
        return chord;
    }
}
