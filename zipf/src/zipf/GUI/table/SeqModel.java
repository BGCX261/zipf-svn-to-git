package zipf.GUI.table;

import javax.swing.table.AbstractTableModel;
import zipf.GUI.grid.GridSeq;
import zipf.event.Pool;
import zipf.event.Song;

public class SeqModel extends CustomModel {



    public SeqModel(GridSeq tools) {
       super(tools);

    }

    @Override
    public int getRowCount() {
        return ((Song)tools.queue()).trackCount();
    }


}
