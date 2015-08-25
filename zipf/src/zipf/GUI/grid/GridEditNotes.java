package zipf.GUI.grid;

import javax.swing.JPanel;
import javax.swing.JToggleButton;
import zipf.GUI.KeyInput;
import zipf.IO.KeyboardPiano;
import zipf.event.Note;
import zipf.event.NoteSeq;


/*TODO delete Bar, entf, backslash - backMarkBars..
 * rename noteSeqs /custom folder
 * steprecording (str means duration+)
 * move with arrowKeys...
 * navigation...
 * title of noteSeq
 */

public class GridEditNotes extends GridEdit {



    public GridEditNotes() {
        ((GridNote)gridTable).volumeGrid = new GridVolume((ToolsBar) gridTable);
        gridTable.addParam(((GridNote)gridTable).volumeGrid);
    }
}
