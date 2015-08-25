package zipf.event;

import java.util.ArrayList;
import java.util.Iterator;
import zipf.GUI.grid.Grid;
import zipf.event.interfaces.Playable;

public class Song extends Seq {

    public Song(Seq parentSeq, int position, int y, long duration, Grid tools, boolean visible) {
        super(parentSeq, position, y, duration, tools, visible);
    }

    public Song(int duration, Grid tools) {
        super(null, 0, 0, duration, tools, true);
        initMidi();
    }

    @Override
    public void addEvent(Event event) {
        if (event instanceof NoteSeq) {
            Iterator<Playable> it = items.values().iterator();
            while (it.hasNext()) {
                if (it.next() == event) {
                    super.addEvent(event);
                    return;
                }
            }
            if (items.containsKey(event.getData())) {
                event.updateY(items.lastKey() + 1);
            }
            super.addEvent(event);
            items.put(event.getData(), event);
            if (Midi.isPlaying()) {
                syncAndPlay((NoteSeq) event);
            }
        } else {
            super.addEvent(event);
        }
    }

    @Override
    public void removeEvent(Event event) {
        super.removeEvent(event);
        if (event instanceof Seq) {
            if (((Seq) event).Midi.isPlaying()) {
                ((Playable) event).stop();
            }
        }
    }

    @Override
    public void stop() {
        super.stop();
        for (Playable p : items.values()) {
            p.stop();
        }
//        System.out.println("---------------------STOP---------------------------------------------");
    }

    public void syncAndPlay(final Seq seq) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                if (Midi.isPlaying()) {
                    long newPosition = seq.getQueueMicrosecondPosition(seq.event.getTick());
//                    System.out.println("syncandplay position " + newPosition);
                    if (newPosition >= 0) {
                        if (!seq.Midi.isPlaying()) {
                            seq.Midi.startSequencer();
                        }
                        long midiPosition = newPosition - seq.Midi.getMicrosecondPosition();
                        if (midiPosition != 0 || midiPosition < Midi.getMicrosecondLength()) {
//                            System.out.println("invoking with diff " + (newPosition - seq.Midi.getMicrosecondPosition()));
                            seq.Midi.setMicrosecondPosition(newPosition);
                        }
                    } else if (seq.Midi.isPlaying()) {
//                        System.out.println("put out of playing");
                        seq.stop();
                        Midi.flush();
                        return;
                    }
                }
            }
        }).start();

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
//        System.out.println(Midi);
        for (Playable p : items.values()) {
            Seq seq = (Seq) p;
            str.append("Track " + seq.trackNumber + " | " + seq.name + " start: " + seq.event.getTick() + "\n");
        }
//        for (int i = 0; i < Midi.getTracks().length; i++) {
//
//          System.out.println( i + " track size " + Midi.getTracks()[i].size() );
//        }
        return this.getName();
    }

    ArrayList<NoteSeq> getSeqNotes() {
        ArrayList<NoteSeq> list = new ArrayList<NoteSeq>();
        for (Pool pool : pools.values()) {
            for (Object o : pool.noteMap.values()) {
                if (o instanceof NoteSeq) {
                    list.add((NoteSeq) o);
                }
            }
        }
        return list;
    }
}
