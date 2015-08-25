package zipf.event;

import com.sun.media.sound.MidiUtils;
import zipf.GUI.vis.TransportBar;
import zipf.event.interfaces.Visable;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import zipf.event.pending.ParameterCurve;
import zipf.event.pending.EntryPoints;
import zipf.event.interfaces.Element;
import zipf.event.interfaces.Durable;
import zipf.event.interfaces.EventContainer;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import javax.swing.JLayeredPane;
import zipf.GUI.MidiHelper;
import zipf.GUI.grid.Grid;
import zipf.GUI.grid.ToolsBar;
import zipf.GUI.vis.Vis;
import zipf.GUI.vis.VisNote;
import zipf.GUI.vis.VisPanel;
import zipf.GUI.vis.VisSeq;
import zipf.IO.MidiTools;
import zipf.event.conditions.DefaultRouter;
import zipf.event.interfaces.MidiItem;
import zipf.event.interfaces.Playable;
import zipf.event.interfaces.Propertable;
import zipf.event.interfaces.Routable;
import zipf.eventControl.EventController;
import zipf.eventControl.SeqReceiver;

public class Seq extends Note implements Element, MidiTools, Durable, EventContainer, MidiItem, Routable, Visable, Propertable {

    public HashMap<String, Object> properties = new HashMap<String, Object>();
    public transient Midi Midi;
    public transient Track parentTrack;
    public TreeMap<Long, Pool> pools = new TreeMap<Long, Pool>();
    public ArrayList<TreeMap<Long, CC>> ccs = new ArrayList<TreeMap<Long, CC>>(127);
    public transient Grid tools;
    public boolean visible;
    public int resolution = 4;
    public transient TransportThread transportThread;
    public int trackNumber;
    public TreeMap<Integer, Playable> items = new TreeMap<Integer, Playable>();
    public int baseNote = 60;
    public float tempo = 120;
    int loopState;

    public Seq(Seq parentSeq, int position, int y, long duration, Grid tools, boolean visible) {
        super(parentSeq, position, y, duration);
        this.visible = visible;
        this.tools = tools;
        this.duration = (duration *= (PPQ / resolution));
        for (int i = 0; i < 127; i++) {
            ccs.add(new TreeMap<Long, CC>());
        }
        channel = 15;
    }

    @Override
    public void initMidi() {
        Midi = new SeqReceiver(this, true);
        super.initMidi();
        setDuration(duration);
        setIntLoopEnd(16);
        setIntLoopStart(0);

        addTrack();
    }

    @Override
    public void initUI() {
        eventVis = new VisSeq((ToolsBar) queue.tools, this);
    }

// <editor-fold defaultstate="collapsed" desc="not yet implemented methods">
    public void toStepSequence(int l) {
//        pools.addPool((GenPool)new Chord());
        throw new UnsupportedOperationException();
    }

    public ParameterCurve eventDensity() {
        throw new UnsupportedOperationException();
    }

    public ParameterCurve entryLevel() {
        throw new UnsupportedOperationException();
    }

    public void quantize(int l) {
        throw new UnsupportedOperationException();
    }

    public void quantize(int l, int factor) {
        throw new UnsupportedOperationException();
    }

    public void quantize(int l, int factor, int swing) {
        throw new UnsupportedOperationException();
    }

    public void operators(int type, NoteSeq second) {
        throw new UnsupportedOperationException();
    }

    public EntryPoints emptySpaces() {
        throw new UnsupportedOperationException();
    }

    public void repeat() {
        throw new UnsupportedOperationException();
    }

    public void repeat(int times) {
        throw new UnsupportedOperationException();
    }

    public void repeat(long duration) {
        throw new UnsupportedOperationException();
    }

    public void normalize(int volume) {
        throw new UnsupportedOperationException();
    }

    public void convert(int type) {
        throw new UnsupportedOperationException();
    }

    public int rhythmicConsistency() {
        throw new UnsupportedOperationException();
    }

    public void sort(int param) {
        throw new UnsupportedOperationException();
    }

    public void apply(int rule) {
        throw new UnsupportedOperationException();
    }

    public Seq rhythmFromEntryPoints(Seq layer) {
        throw new UnsupportedOperationException();
    }// </editor-fold>

    public Pool getPool(long position) {
        Pool pool = pools.get(position);
        pool = (pool != null) ? pool : new Pool(queue, position);
        pools.put(position, pool);
        return pool;
    }

    @Override
    public void addEvent(Event event) {
        long eventPosition = event.position;
        if (event instanceof Note) {
            Note note = (Note) event;
            Pool pool = getPool(eventPosition);
            pool.addNote(note);
            pool.checkStructure();
        } else if (event instanceof CC) {
            ccs.get(((CC) event).ccNumber).put(event.position, (CC) event);
        } else if (event instanceof SeqNote) {
            SeqNote sn = (SeqNote) event;
            long offPosition = (eventPosition + sn.duration);
            Pool pool = getPool(eventPosition);
            pool.commands.add(sn.event);
            Pool poolOff = getPool(offPosition);
            poolOff.commands.add(sn.offNote);
        }
        addToMidi(event);
        event.queue = this;
    }

    @Override
    public void removeEvent(Event event) {
        long eventPosition = event.position;
        if (event instanceof Note) {
            Pool pool = pools.get(eventPosition);
            if (pool != null) {
                pool.removeNote((Note) event);
                pool.checkStructure();
            }
        } else if (event instanceof CC) {
            ccs.get(((CC) event).ccNumber).remove(event.position);
        } else if (event instanceof SeqNote) {
            SeqNote sn = (SeqNote) event;
            long offPosition = (eventPosition + sn.duration);
            Pool pool = getPool(eventPosition);
            pool.commands.remove(sn.event);
            Pool poolOff = getPool(offPosition);
            poolOff.commands.remove(sn.offNote);
        }
        Midi.removeEvent(event);
    }

    @Override
    public void updateEventPosition(long newPosition) {
        super.updateEventPosition(newPosition);
        if (queue != null && queue.Midi.isPlaying()) {
            ((Song) queue).syncAndPlay(this);
        }
    }

    @Override
    public void setY(int pitch) {
        pitch -= baseNote;
        if (pitch != 0) {
            transpose(pitch);
        }
    }

    @Override
    public int getY() {
        return baseNote;
    }

    public synchronized void transpose(int i) {
        for (Note note : getNotes()) {
            int pitch = note.getY();
            if (pitch + i > 127 || pitch + i < 0) {
                return;
            }
        }
        baseNote += i;
        for (Note note : getNotes()) {
            note.setY(note.getY() + i);
        }
    }

    public ArrayList<Note> getNotes() {
        ArrayList<Note> list = new ArrayList<Note>();
        for (Pool pool : this.pools.values()) {
            list.addAll(pool.noteMap.values());
        }
        return list;
    }

    @Override
    public void play() {
        if (Midi.isPlaying()) {
            stop();
            Midi.startSequencer();
        }
        if (Midi.getSequence() == null) {
            Midi.setSequence(Midi.mse);
        }
        if (!Midi.isPlaying()) {
            Midi.startSequencer();
        }
    }

    public void play(long tick) {
        Midi.setTickPosition(tick);
        play();
    }

    @Override
    public void stop() {
        Midi.stopSequencer();
        Midi.resetTransportPosition();
    }

    public synchronized void playItem(int key) {
        Seq seq = (Seq) items.get(key);
        if (!seq.Midi.isPlaying()) {
            seq.Midi.startSequencer();
        }
    }

    public synchronized void stopItem(int key) {
        Seq seq = (Seq) items.get(key);
        if (seq != null && seq.Midi.isPlaying()) {
            seq.stop();
        }
    }

    public synchronized void clearSeq() {
        Midi.stopSequencer();
        Midi.close();
        pools.clear();
        Midi.clear();
        items.clear();
    }

    @Override
    public void setDuration(long i) {
        Track track = Midi.getTracks()[0];
        for (int j = 0; j < track.size(); j++) {
            MidiEvent me = track.get(j);
            MidiMessage mm = me.getMessage();
            if (MidiHelper.code(mm).equals("End Of Track")) {
                me.setTick(i);
            }
        }
        super.setDuration(i);
    }

    @Override
    public long getDuration() {
        return Midi.getTickLength();
    }

    void addPool(Pool pool) {
        pools.put(pool.position, pool);
    }

    public void updateEventMidi(ToolsBar tools) {
        this.tools = tools;
        for (Object o : getEvents()) {
            if (o instanceof Event) {
                Event e = (Event) o;
                e.initMidi();
                addToMidi(e);
                if (o instanceof Seq) {
                    ((Seq) o).updateEventMidi(tools);
                }
            }
        }
    }

    public void setVisibility(ToolsBar tools) {
        if (!visible) {
            visible = true;
            for (Object o : getEvents()) {
                if (o instanceof Event) {
                    Event e = (Event) o;
                    e.initUI();
                }
            }
            transportThread = new TransportThread(this);
        }
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
        add();
    }

    @Override
    public DefaultRouter getRouter() {
        return ((SeqReceiver) Midi).router;
    }

    @Override
    public Receiver getReceiver() {
        return this.Midi.getReceiver();
    }

    public void addToMidi(Event event) {
        Midi.addEvent(event);
    }

    public void setIntLoopStart(int x) {
        long start = longValue(x);
        long loopEnd = Midi.getLoopEndPoint();
        if (start < loopEnd && start >= 0) {
            Midi.setLoopStartPoint(start);
            long space = longValue(4);
            if ((loopEnd - start) <= space) {
                Midi.setLoopEndPoint(start + space);
            }
        }
    }

    public int getIntLoopStart() {
        return intValue(Midi.getLoopStartPoint());
    }

    public int getIntLoopEnd() {
        return intValue(Midi.getLoopEndPoint());
    }

    public void setIntLoopEnd(int x) {
        long end = longValue(x);
        long loopStart = Midi.getLoopStartPoint();
        if (end > loopStart && end > 0) {
            if (end > duration) {
                setDuration(end);
            }
            Midi.setLoopEndPoint(end);
            long space = longValue(4);
            if ((end - loopStart) <= space && (end - space) >= 0) {
                Midi.setLoopStartPoint(end - space);
            }
        }
    }

    public ArrayList getEvents() {
        ArrayList events = new ArrayList();
        for (Pool pool : pools.values()) {
            events.addAll(pool.noteMap.values());
            events.addAll(pool.commands);
        }
        for (TreeMap<Long, CC> pool : ccs) {
            events.addAll(pool.values());
        }
        for (Object o : events) {
            if (o == null) {
                events.remove(o);
            }
        }
        return events;

    }

    public Collection<Note> getIntNotes(int x) {
        Pool pool = pools.get(longValue(x));
        return (pool != null) ? pool.noteMap.values() : null;
    }

    public Collection<Note> getNotes(long x) {
        Pool pool = pools.get(x);
        return (pool != null) ? pool.noteMap.values() : null;
    }

    public Collection<Note> getNotesInInt(int x) {
        ArrayList<Note> list = new ArrayList<Note>();
        SortedMap<Long, Pool> subMap = pools.subMap(longValue(x), longValue(x + 1));
        for (Pool pool : subMap.values()) {
            list.addAll(pool.noteMap.values());
        }
        return list;
    }

    public Pool getIntPool(int columnIndex) {
        return pools.get(longValue(columnIndex));
    }

    @Override
    public String toString() {
        System.out.println(this.getName());
        String str = "";
        StringBuilder strb = new StringBuilder();
        int maxNoteSize = 0;
        int maxParamSize = ccs.size();
        for (Pool pool : pools.values()) {
            if (pool.noteMap.size() > maxNoteSize) {
                maxNoteSize = pool.noteMap.size();
            }
        }
        if (!pools.isEmpty()) {
            for (int i = 0; i < maxNoteSize + 1; i++) {
                for (long j = 0; j <= pools.lastEntry().getValue().position; j++) {
                    Note note = null;
                    Pool pool = pools.get(j);
                    if (pool != null
                            && pool.noteMap.size() > i
                            && (note = (Note) pool.noteMap.values().toArray()[i]) != null) {
                        String str2 = note.toString();
                        while (str2.length() < 3) {
                            str2 += " ";
                        }
                        str2 = str2.substring(0, 3);
                        str += str2 + "|";
                    } else {
                        str += "   |";
                    }
                }
                strb.append(str).append("\n");
                str = "";
            }

            for (long j = 0; j <= pools.lastEntry().getValue().position; j++) {
                if (pools.get(j) != null) {
                    strb.append(pools.get(j).commands.toString());
                }
            }
            strb.append("\n");
        }

        for (int i = 0; i < ccs.size(); i++) {
            if (!ccs.get(i).isEmpty()) {
                strb.append(ccs.get(i)).append("\n");
            }
        }
        return strb.toString();
    }

    public void setTempo(float value) {
        Midi.setTempoInBPM(value);
        this.tempo = value;
    }

    public float getTempo() {
        return Midi.getTempoInBPM();
    }

    @Override
    public long longValue(int value) {
        return value * (PPQ / resolution);
    }

    @Override
    public int intValue(long l) {
        return (int) (l / (PPQ / resolution));
    }

    public void sync() {
        long newPosition = getQueueMicrosecondPosition(event.getTick());
        Midi.setMicrosecondPosition(newPosition);
    }

    public long getQueueMicrosecondPosition(long tick) {
        long startTime = MidiUtils.ticks2microsec(tick, queue.Midi.getTempoInMPQ(), Midi.getResolution());
        long playTime = queue.Midi.getMicrosecondPosition();
        long diff = playTime - startTime;
        return diff;
    }

    public void addTrack() {
        Midi.addTrack();
    }

    public Track getSongTrack(int index) {
        return getTracks()[index + 4];
    }

    public int trackCount() {
        return getTracks().length - 4;
    }

    public Track[] getTracks() {
        return Midi.getTracks();
    }

    @Override
    public void collectProperties() {
        set("loopCount", Midi.msr.getLoopCount());
        set("stored", 1);
        set("loopStart", Midi.getLoopStartPoint());
        set("loopEnd", Midi.getLoopEndPoint());
        set("trackCount", getTracks().length - 4);
        set("tempoFactor", Midi.msr.getTempoFactor());
        set("tempo", Midi.getTempoInBPM());
    }

    @Override
    public void applyProperties() {
        if (get("stored") != null) {

            System.out.println("applying");
            Midi.setLoopStartPoint(getLong("loopStart"));
            Midi.setLoopEndPoint(getLong("loopEnd"));
            Midi.setLoopCount(getInt("loopCount"));
            tools.edit.loopGrid.model.fireTableDataChanged();
            for (int i = 1; i < getInt("trackCount"); i++) {
                Midi.mse.createTrack();
            }
            tools.updateAll();
            setTempo((Float) get("tempo"));
        }
    }

    public Object get(String str) {
        return properties.get(str);
    }

    public int getInt(String str) {
        return (Integer) properties.get(str);
    }

    public long getLong(String str) {
        return (Long) properties.get(str);
    }

    public void set(String str, Object o) {
        properties.put(str, o);
    }
}
