package zipf.GUI.grid;

import javax.swing.JPanel;
import zipf.GUI.KeyInput;
import zipf.event.NoteSeq;
import zipf.event.Seq;
import zipf.event.Song;
import zipf.event.interfaces.MidiMetrics;

public abstract class GridTools extends JPanel implements Metrics, MidiMetrics {

    public final static int GRID = 0;
    public final static int CONDITIONS = 1;
    public final static int PARAMS = 2;
    public static Song songInEdit;
    public static NoteSeq queueInEdit;
    public GridEdit edit;

    public GridTools() {
    }

    public float cw() {
        if (edit.gridOff) {
            return (float) edit.cw * edit.getTickResolution() / (float) queue().resolution;
        }
        return edit.cw;
    }

    public float tw() {
        return (float) edit.cw * edit.getTickResolution() / (float) PPQ;
    }

    public int columns() {
        if (edit.gridTable != null) {
            return edit.gridTable.model.getColumnCount();
        } else {
            return queue().intDuration();
        }
    }

    public Seq queue() {
        return edit.mainQueue;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
