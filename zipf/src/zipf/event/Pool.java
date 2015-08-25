package zipf.event;

import java.awt.Component;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import zipf.GUI.grid.ToolsVis;
import zipf.event.conditions.ToolsEvent;
import zipf.event.interfaces.Element;
import zipf.event.interfaces.Durable;
import zipf.event.interfaces.EventContainer;
import java.util.TreeSet;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import zipf.GUI.grid.GridNote;
import zipf.GUI.grid.ToolsPanel;
import zipf.GUI.vis.ContainerVolumeVis;
import zipf.GUI.vis.VisVolume;
import zipf.eventControl.ToolsChord;

public class Pool<GenEvent extends Event> extends NoteEvent implements Element, Comparable<Pool>, Durable {

    protected String name;
    protected int volume;
    public BaseNote baseNote;
    BaseChord baseChord;
    public ContainerVolumeVis volumeContainer = new ContainerVolumeVis();
    public TreeMap<Integer, Note> noteMap = new TreeMap<Integer, Note>();
    public ArrayList<CommandEvent> commands = new ArrayList<CommandEvent>();

    public Pool(Seq queue, long position, int y, int duration) {
        super(queue, position, y, duration);
    }

    Pool(Seq queue, long eventPosition) {
        this(queue, eventPosition, 0, 0);
    }

    @Override
    public int compareTo(Pool pool) {
        return (int) (this.position - pool.position);
    }

    @Override
    public void setY(int i) {
        baseNote.setY(i);
    }

    @Override
    public int getY() {
        return baseNote.getY();
    }

    @Override
    public String toString() {
        String str = "Notes(";
        for (Note e : noteMap.values()) {
            if (e != noteMap.lastEntry().getValue() && e != null) {
                str += e + ",";
            } else if (e != null) {
                str += e;
            }
        }
        str += ")";
        str = " Commands(";
        for (CommandEvent command : commands) {
            if (command != commands.get(commands.size() - 1) && command != null) {
                str += command + ",";
            } else if (command != null) {
                str += command;
            }
        }
        str += ")";
        return str;
    }

    @Override
    public void setDuration(long i) {
        for (NoteEvent note : noteMap.values()) {
            note.setDuration(i);
        }
    }

    @Override
    public long getDuration() {
        long tmp = 0;
        for (NoteEvent note : noteMap.values()) {
            if (tmp < note.getDuration()) {
                tmp = note.getDuration();
            }
        }
        return tmp;
    }

    @Override
    public void remove() {
        this.queue.pools.remove(this.position);
    }

    @Override
    public EventContainer getParent() {
        return queue;
    }

    @Override
    public void setParent(EventContainer eCon) {
        queue = (Seq) eCon;
    }

    private int getLongestDurable() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public ArrayList getEvents() {
        ArrayList list = new ArrayList();
        if (baseNote != null) {
            list.add(baseNote);
        }
        list.addAll((Collection<? extends GenEvent>) noteMap.values());
        return list;
    }

    public Integer[] getModNotes() {
        TreeSet<Integer> notesTS = new TreeSet<Integer>();
        for (Integer key : noteMap.keySet()) {
            notesTS.add(key % 12);
        }
        Integer[] pitch = new Integer[notesTS.size()];
        return notesTS.toArray(pitch);
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toMidi() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void writeObject(ObjectOutputStream os) {
        volumeContainer.removeAll();
        try {
            os.defaultWriteObject();
        } catch (IOException ex) {
            Logger.getLogger(Pool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void checkStructure() {
        if ((baseChord = ToolsChord.chordAnalyze(getModNotes())) != null) {
            baseNote = baseChord.baseNote;
        }
    }

    @Override
    public void updateY() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void removeNote(Note note) {
        noteMap.remove(note.getY());
        note.parentPool = null;
    }

    void addNote(Note note) {
        noteMap.put(note.getY(), note);
        note.parentPool = this;

    }
}
