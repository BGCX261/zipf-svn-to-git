package zipf.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import zipf.event.interfaces.Element;
import zipf.event.interfaces.EventContainer;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import zipf.GUI.vis.Vis;
import zipf.GUI.vis.VisPanel;
import zipf.IO.MidiIO;
import zipf.event.conditions.DefaultRouter;
import zipf.event.conditions.ToolsEvent;
import zipf.event.interfaces.MidiItem;
import zipf.event.interfaces.MidiMetrics;
import zipf.event.interfaces.Nameable;
import zipf.event.interfaces.Playable;
import zipf.event.interfaces.Routable;
import zipf.eventControl.Counter;
import zipf.eventControl.EventController;
import zipf.eventControl.Memory;
import zipf.eventControl.SeqReceiver;

public abstract class Event<GenEvent extends Event> implements Element, Routable, MidiItem, Playable, Nameable, MidiMetrics, Cloneable {

    public long position;
    public int y;
    public transient MidiMessage msg;
    transient public MidiEvent event;
    public Seq queue;
    public long memoID;
    public int type;
    transient public Vis eventVis;
    public static int gridCapacityY = 127;
    public String name;
    public int count;
    public int channel;
    ArrayList<Event> copies = new ArrayList<Event>();

    public Event(Seq queue, long position, int y) {
        this.queue = queue;
        this.y = y;
        this.position = position;
        if (!(this instanceof NoteEvent)) {
            initMidi();
            add();
        }
    }

    public Event(long position, int y) {
        this.y = y;
        this.position = position;
    }

    public void add() {
        if (queue != null) {
            queue.addEvent(this);
        }
    }

    public byte[] toMemory() {
        Memory.add(this);
        return ToolsEvent.lToBytes(this.memoID);
    }

    @Override
    public void setPosition(long newPosition) {
        if (newPosition != position) {
            remove();
            updateEventPosition(newPosition);
            position = newPosition;
            add();
        }
    }

    @Override
    public void setY(int newY) {
//        System.out.println("setting y in event " + y);
        if (newY != y) {
            remove();
            y = newY;
            updateY();
            add();
        }
    }

    @Override
    public long getPosition() {
        return position;
    }

    @Override
    public void remove() {
        if (queue != null) {
            queue.removeEvent(this);
        }
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public EventContainer getParent() {
        return this.queue;
    }

    @Override
    public void setParent(EventContainer eCon) {
        this.queue = (Seq) eCon;
        add();
    }

    @Override
    public Receiver getReceiver() {
        if (this.queue != null) {
            return queue.getReceiver();
        } else {
            return MidiIO.currentReceiver;
        }
    }

    @Override
    public DefaultRouter getRouter() {
        return ((SeqReceiver)queue.Midi).router;
    }

    public static int invert(int i) {
        return Math.abs(gridCapacityY - i);
    }

    public void initMidi() {
        System.out.println("empty init");
    }

    public String printMetrics() {
        return "x: " + position + " y: " + y;
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }

    public void initUI() {
        System.out.println("empty initVis" + event);
    }

    public void updateEventPosition(long newPosition) {
        event.setTick(newPosition);
    }

    public void changeY(int newY) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getName() {
        if (name == null) {
            name = Counter.countAndName(this);
        }
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public long longValue(int value) {
        return value * (PPQ / queue.resolution);
    }

    public int intValue(long l) {
        return (int) (l / (PPQ / queue.resolution));
    }

    public int getIntPosition() {
        return intValue(position);
    }

    public Event copy() {
        try {
            Event copy = (Event) super.clone();
            copy.initMidi();
            copy.name += " - copy " + "(" + copies.size() + ")";
            copies.add(copy);
            return copy;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    int getData() {
            throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void updateY() {
        updateY(y);
    }

    public void updateY(int y) {
        System.out.println("setting empty y in event");
    }
}
