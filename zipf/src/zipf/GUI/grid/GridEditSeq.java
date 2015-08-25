package zipf.GUI.grid;

import zipf.event.Note;
import zipf.event.Seq;
import zipf.event.SeqNote;
import zipf.event.Song;

public class GridEditSeq extends GridEdit {



    public GridEditSeq() {
        songInEdit = (Song) mainQueue;
    }
}
