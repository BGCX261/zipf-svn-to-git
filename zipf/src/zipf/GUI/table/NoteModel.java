package zipf.GUI.table;

import javax.swing.table.AbstractTableModel;
import zipf.GUI.grid.GridNote;
import zipf.GUI.grid.GridSeq;
import zipf.event.Event;
import zipf.event.Param;
import zipf.event.Pool;
import zipf.event.Song;

public class NoteModel extends CustomModel {

    public NoteModel(GridNote tools) {
       super(tools);
    }

        @Override
    public int getRowCount() {
        return 127;
    }


}
