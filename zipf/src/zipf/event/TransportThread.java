package zipf.event;

import java.util.Timer;
import java.util.TimerTask;
import zipf.GUI.vis.TransportBar;

public class TransportThread extends TimerTask {

    Seq queue;
    public long currentTick;
    TransportBar transportBar;
    public Object transportSync = new Object();
    Midi Midi;
    public int counter;

    public TransportThread(Seq seq) {
        this.queue = seq;
        Midi = queue.Midi;
        transportBar = queue.tools.getTransportBar();
    }

    @Override
    public void run() {
        if(!queue.Midi.isPlaying()){
            this.cancel();
        }
        int tick = queue.Midi.getIntTickPosition();
        transportBar.setPosition(tick);
    }



}
