package zipf.event;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiUnavailableException;
import zipf.event.interfaces.Durable;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import zipf.event.interfaces.MidiItem;
import zipf.event.interfaces.MidiMetrics;
import zipf.event.interfaces.Playable;

public abstract class NoteEvent extends Event implements Durable {

    public long duration = 4;
    transient public MidiEvent offNote;
    public transient MidiMessage offMsg;

    public NoteEvent(Seq queue, long position, int y, long duration) {
        super(queue, position, y);
        this.duration = duration;
    }

    @Override
    public void setDuration(long i) {
        {
            if (offNote != null) {
                duration = i;
//                boolean connected = queue != null;
//                if (connected) {
//                    queue.Midi.removeEvent(offNote);
//                }
                offNote.setTick(event.getTick() + i);
//                if (connected) {
//                    queue.Midi.addEvent(offNote);
//                }
            }
        }
//        eventVis.setSize(duration*queue.tools.cw(), queue.tools.ch);
    }

    @Override
    public long getDuration() {
        return duration;
    }

    public int intDuration(){
        return intValue(duration);
    }

    public void sendOff() {
            queue.Midi.send(this.offMsg, -1);
    }


    public void sendOn() {
            queue.Midi.send(this.msg, -1);
    }

    @Override
    public String printMetrics() {
        return super.printMetrics() + " duration " + duration;
    }

    @Override
    public void updateEventPosition(long newPosition) {
        event.setTick(newPosition);
        offNote.setTick(newPosition + duration);
    }
}
