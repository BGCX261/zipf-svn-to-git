package zipf.event;

import zipf.event.interfaces.Visable;
import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;
import zipf.GUI.grid.GridParam;
import zipf.GUI.vis.Vis;
import zipf.GUI.vis.VisBar;
import zipf.GUI.vis.VisNote;
import zipf.GUI.grid.GridNote;
import zipf.GUI.grid.ToolsMoveVis;
import zipf.GUI.grid.ToolsVis;
import zipf.GUI.vis.ContainerVolumeVis;
import zipf.GUI.vis.VisVolume;
import zipf.IO.MidiTools;
import zipf.event.conditions.DefaultRouter;
import zipf.event.conditions.ToolsEvent;
import zipf.event.interfaces.Routable;
import zipf.eventControl.EventController;

public class Note extends NoteEvent implements MidiTools, Comparable<Note>, Visable {

    public int volume = 100;
    public Pool parentPool;
    private boolean marked;

    public Note() {
        this(null, 0, 60, 4);
    }

    public Note(Seq queue, long position, int y, long duration) {
        super(queue, position, y, duration);
        if (!(this instanceof Seq)) {
            initMidi();
            add();
            if (queue.visible) {
                initUI();
            }
        }
    }

    @Override
    public void initUI() {
        if (eventVis == null) {
            super.eventVis = this.eventVis;
            eventVis = new VisNote((GridNote) queue.tools, this);
        }
    }

    @Override
    public void initMidi() {
        msg = new ShortMessage();
        offMsg = new ShortMessage();
        super.msg = this.msg;
        super.offMsg = this.offMsg;
        toMidi();
    }

    @Override
    public void toMidi() {
        updateY();
        event = new MidiEvent(msg, position);
        offNote = new MidiEvent(offMsg, position + duration);
    }

    @Override
    public void play() {
        System.out.println("play");
        System.out.println(getReceiver());
    }

    @Override
    public void stop() {
        getReceiver().send(offMsg, -1);
    }

    @Override
    public int getY() {
        return ((ShortMessage) msg).getData1();
    }

    @Override
    public String toString() {
        String str = "";
        str += ToolsEvent.noteNames[y % 12];
        for (int i = 0; i < duration; i++) {
            if (i % 265 == 0) {
                str += "*";
            }
        }
        return str;
    }

    @Override
    public void updateY() {
        updateY(y);
    }

    public void updateY(int y) {
//        System.out.println("updating Y in Note");
        try {
            ((ShortMessage) msg).setMessage(ShortMessage.NOTE_ON, channel, y, volume);
            ((ShortMessage) offMsg).setMessage(ShortMessage.NOTE_OFF, channel, y, volume);
        } catch (InvalidMidiDataException ex) {
            Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateEventPosition(long newPosition) {
        event.setTick(newPosition);
        offNote.setTick(newPosition + duration);
    }

    public int getVolume() {
        return ((ShortMessage) msg).getData2();
    }

    public void setVolume(int volume) {
        if (volume < 128) {
            this.volume = volume;
            this.updateY();
            if (queue.visible) {
                ((VisNote) eventVis).setVolume(volume);
            }
        }
    }

    @Override
    public int compareTo(Note o) {
        return o.getY() - this.getY();
    }

    public void mark() {
        if (!marked) {
            ((VisNote) eventVis).mark();
            marked = true;
        }
    }

    public void unMark() {
        if (marked) {
            ((VisNote) eventVis).unMark();
            marked = false;
        }
    }

    @Override
    public void setDuration(long i) {
        super.setDuration(i);
        if (queue != null && eventVis != null && queue.visible) {
            eventVis.updateBounds();
        }
    }

    @Override
    public Vis getVis() {
        return eventVis;
    }

    @Override
    int getData() {
        return ((ShortMessage) msg).getData1();
    }
}
