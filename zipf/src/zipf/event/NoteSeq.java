package zipf.event;

import java.awt.Point;
import java.util.ArrayList;
import zipf.event.interfaces.EventContainer;
import java.util.Arrays;
import java.util.TreeMap;
import zipf.GUI.grid.Grid;
import zipf.GUI.grid.GridSeq;
import zipf.GUI.grid.ToolsBar;
import zipf.GUI.vis.VisSeq;
import zipf.event.SeqNote;

public class NoteSeq extends Song {



    public NoteSeq(long duration, Grid tools, boolean visible) {
        super(null, 0, 0, duration, tools, visible);
        this.duration = duration;
        initMidi();
    }

    public NoteSeq(int duration, Grid tools, boolean visible) {
        super(null, 0, 0, duration, tools, visible);
        add();
        initMidi();
    }



    // <editor-fold defaultstate="collapsed" desc="not yet implemented">
    public Note highestNote() {
        throw new UnsupportedOperationException();
    }

    public Note lowestNote() {
        throw new UnsupportedOperationException();
    }

    public Note averagePitch() {
        throw new UnsupportedOperationException();
    }

    public int averageVolume() {
        throw new UnsupportedOperationException();
    }// </editor-fold>



    @Override
    public NoteSeq copy() {
        NoteSeq copy = (NoteSeq) super.copy();
        if(copy.queue!=null){
        copy.queue.Midi.getTracks()[0].remove(copy.event);
        copy.queue.Midi.getTracks()[0].remove(copy.offNote);
        copy.initMidi();
        copy.updateEventMidi((ToolsBar) tools);
        copy.queue.Midi.getTracks()[0].remove(copy.event);
        copy.queue.Midi.getTracks()[0].remove(copy.offNote);
        }
        return copy;
    }
}
