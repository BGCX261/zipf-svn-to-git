package zipf.event;

import java.util.Timer;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Receiver;
import javax.sound.midi.Track;
import zipf.GUI.MidiHelper;

public class Midi extends MidiSequence {

    TransportThread transportThread;

    public Midi(Seq seq, boolean connected) {
        super(seq, connected);
    }

    public Track addTrack() {
        Track track = mse.createTrack();
        int loop = msr.getLoopCount();
        long start = getLoopStartPoint();
        long end = getLoopEndPoint();
        long position = getTickPosition();
        boolean playing = isPlaying();
        if (isOpen()) {
            close();
            open();
            getTransmitter().setReceiver((Receiver) this);
            setSequence(mse);
            setLoopStartPoint(start);
            setLoopEndPoint(end);
            setTickPosition(position);
            msr.setLoopCount(loop);
        }
        if (playing) {
            startSequencer();
        }
        return track;
    }

    public void setIntTickPosition(int position) {
        setTickPosition(queue.longValue(position));
    }

    public void setTickPosition(final long tick) {
        final Thread tmp = new Thread(new Runnable() {

            @Override
            public void run() {
                msr.setTickPosition(tick);
            }
        });
        tmp.start();
    }

    public void setLoopEndPoint(long visX) {
        msr.setLoopEndPoint(visX);
    }

    public void setLoopStartPoint(long visX) {
        msr.setLoopStartPoint(visX);
    }

    public void setTempoInMPQ(int l) {
        msr.setTempoFactor(l/msr.getTempoInMPQ());
    }

    void flush() {
        long test = getTickPosition();
        if (!(test == flushPosition)) {
            msr.stop();
            msr.start();
            flushPosition = test;
        }
    }

    void setMicrosecondPosition(long newPosition) {
        final long p = newPosition;
        final Thread tmp = new Thread(new Runnable() {

            @Override
            public void run() {
                msr.setMicrosecondPosition(p);
            }
        });
        tmp.start();
    }

    public void stopSequencer() {
        checkOpen();
        if (isPlaying()) {
            msr.stop();
        }
        if (queue.visible) {
            stopTransport();
        }
    }

    public void startSequencer() {
        checkOpen();
        if (!isPlaying()) {
            msr.start();
            if (queue.visible) {
                startTransport();
            }
        }
    }

    void startTransport() {

        if (timer != null) {
            timer.cancel();
        } 
        timer = new Timer();
        transportThread = new TransportThread(queue);
        timer.scheduleAtFixedRate(transportThread, 0, 200);

        //        timer.scheduleAtFixedRate(new TransportThread(queue), 0, (long) (queue.Midi.msr.getTempoInMPQ()/1000/queue.tools.edit.getTickResolution()));
    }

    public void stopTransport() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public void resetTransportPosition() {
        if (isLooped()) {
            setTickPosition(getLoopStartPoint());
        } else {
            setTickPosition(0);
        }
        if (queue.visible) {
            queue.tools.getTransportBar().setPosition(getIntTickPosition());
        }
    }


    public void clear() {
        for (Track track : mse.getTracks()) {
            mse.deleteTrack(track);
        }
        queue.initMidi();
    }
}
