package zipf.event;

import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.SysexMessage;
import javax.sound.midi.Track;
import javax.sound.midi.Transmitter;
import zipf.GUI.MidiHelper;
import zipf.IO.MidiTools;
import zipf.event.interfaces.MidiMetrics;
import zipf.eventControl.SeqReceiver;

public class MidiSequence {

    public transient Sequencer msr;
    long flushPosition;
    transient public Sequence mse;
    public transient Track noteTrack;
    public transient Track metaTrack;
    public transient Track paramTrack;
    public transient Track commandTrack;
    public Seq queue;
    Timer timer;

    public MidiSequence(Seq seq, boolean connected) {
        queue = seq;
        try {
            mse = new Sequence(Sequence.PPQ, MidiMetrics.PPQ);
            msr = MidiSystem.getSequencer(connected);
            msr.addMetaEventListener(new MetaEventListener() {

                @Override
                public void meta(MetaMessage meta) {
//                    System.out.println(meta);
                    send(meta, msr.getTickPosition());
                }
            });
            msr.setSequence(mse);
            msr.open();
            msr.start();
            msr.stop();
            msr.setTickPosition(0);
//            setTempoInBPM(queue.tempo);
            trackFill();
        } catch (InvalidMidiDataException ex) {
            Logger.getLogger(Seq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Seq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addEvent(Event event) {
        if (event instanceof Seq && event.queue instanceof Song) {
            NoteSeq seq = (NoteSeq) event;
            Track track = ((Song) seq.queue).getSongTrack(seq.trackNumber);
            if (seq.parentTrack != track) {
                seq.parentTrack = track;
                track.add(seq.event);
                ((Song) seq.queue).getSongTrack(seq.trackNumber).add(seq.offNote);
            }
        } else if (event instanceof Note) {
            addMidiEvent(((Note) event).event);
            addMidiEvent(((Note) event).offNote);
        } else {
            addMidiEvent(event.event);
        }
    }

    public void removeEvent(Event event) {
        if (event instanceof Seq) {
            NoteSeq seq = (NoteSeq) event;
            Track track = seq.parentTrack;
            if (track != null) {
                track.remove(seq.event);
                track.remove(seq.offNote);
            }
            seq.parentTrack = null;
        } else if (event instanceof Note) {
            removeMidiEvent(((Note) event).event);
            removeMidiEvent(((Note) event).offNote);
            send(((Note) event).offNote.getMessage());
        } else {
            removeMidiEvent(event.event);
        }
    }

    void trackFill() {
        noteTrack = mse.createTrack();
        metaTrack = mse.createTrack();
        paramTrack = mse.createTrack();
        commandTrack = mse.createTrack();
    }

    public void addMidiEvent(MidiEvent event) {
        if (event != null) {
            if (event.getMessage() instanceof ShortMessage) {
                noteTrack.add(event);
            }
            if (event.getMessage() instanceof MetaMessage) {
                metaTrack.add(event);
            }
            if (event.getMessage() instanceof SysexMessage) {
                commandTrack.add(event);
            }
        }
    }

    public void removeMidiEvent(MidiEvent event) {
        if (event.getMessage() instanceof ShortMessage) {
            noteTrack.remove(event);
        }
        if (event.getMessage() instanceof MetaMessage) {
            metaTrack.remove(event);
        }
        if (event.getMessage() instanceof SysexMessage) {
            commandTrack.remove(event);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        System.out.println("*" + this.queue.getName() + "*");
        for (int i = 0; i < mse.getTracks().length; i++) {
            Track track = mse.getTracks()[i];
            str.append("Track N°").append(i).append(" (length: ").append(track.size()).append(")").append("\n");
            for (int j = 0; j < mse.getTracks()[i].size(); j++) {
                MidiEvent event = track.get(j);
                str.append("     (index: ").append(j).append(") - position: ").append(event.getTick()).append("  type: ").append((event.getMessage()).getClass().getSimpleName());
                str.append("\n");
            }
        }
        str.append("\n");
        return str.toString();
    }

    public Pool getCurrentPool() {
        Pool pool = queue.pools.get(getTickPosition());
        if (pool != null) {
            return pool;
        } else {
            return null;
        }
    }

    public long getLoopStartPoint() {
        return msr.getLoopStartPoint();
    }

    public int getIntTickPosition() {
        return queue.intValue(getTickPosition());
    }

    public long getTickPosition() {
        if (isPlaying()) {
            return msr.getTickPosition();
        } else {
//            System.out.println("tick position " + msr.getTickPosition());
            return -1;
        }
    }

    public long getTickLength() {
        return msr.getTickLength();
    }

    public boolean isPlaying() {
        return msr.isRunning();
    }

    public boolean isLooped() {
        return msr.getLoopCount() == Sequencer.LOOP_CONTINUOUSLY;
    }

    public long getLoopEndPoint() {
        return (int) msr.getLoopEndPoint();
    }

    public void send(MidiMessage msg) {
        send(msg, -1l);
    }

    float getTempoInMPQ() {
        return msr.getTempoInMPQ() * msr.getTempoFactor();
    }

    long getMicrosecondPosition() {
        return msr.getMicrosecondPosition();
    }

    int getResolution() {
        return mse.getResolution();
    }

    Track[] getTracks() {
        return mse.getTracks();
    }

    public void close() {
        msr.close();
    }

    boolean isOpen() {
        return msr.isOpen();
    }

    Object getSequence() {
        return msr.getSequence();
    }

    void setSequence(Sequence mse) {
        try {
            msr.setSequence(mse);
        } catch (InvalidMidiDataException ex) {
            Logger.getLogger(Midi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Receiver getReceiver() {
        try {
            return msr.getReceiver();
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Midi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    void setTempoInBPM(float value) {
        msr.setTempoFactor(value / msr.getTempoInBPM());
    }

    public Transmitter getTransmitter() {
        try {
            return msr.getTransmitter();
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Midi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setLoopCount(int count) {
        msr.setLoopCount(count);
    }

    public void checkOpen() {
        if (!msr.isOpen()) {
            try {
                msr.open();
            } catch (MidiUnavailableException ex) {
                Logger.getLogger(MidiSequence.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void open() {
        try {
            msr.open();
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(MidiSequence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    long getMicrosecondLength() {
        return msr.getMicrosecondLength();
    }

    public float getTempoInBPM() {
        return msr.getTempoInBPM() * msr.getTempoFactor();
    }

    public void send(MidiMessage msg, long l) {
        System.out.println("empty send in MidiSequence");
    }
}
