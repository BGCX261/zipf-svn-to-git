package zipf.event;

import zipf.event.interfaces.EventContainer;
import java.util.ArrayList;
import zipf.GUI.grid.Grid;

public class TrackLine extends Seq {

    Song queue;

    public TrackLine(Song parentSong, Grid tools) {
        super(null, 0, 0, 127, tools, false);
        this.queue = parentSong;
        super.queue = this.queue;
        initMidi();
        add();
    }

    @Override
    public void setDuration(long i) {
        queue.setDuration(i);
    }



    @Override
    public int getY() {
        return 1;
    }

 

    public int getTrackOrder() {
            return -1;
    }

    @Override
    public EventContainer getParent() {
        return this.queue;
    }

    @Override
    public void setParent(EventContainer eCon) {
        eCon = this.queue;
    }

}
