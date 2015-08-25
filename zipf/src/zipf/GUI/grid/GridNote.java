package zipf.GUI.grid;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.dnd.DropTargetDragEvent;
import java.io.File;
import javax.swing.JLayeredPane;
import javax.swing.JScrollBar;
import zipf.GUI.Midi2Seq;
import zipf.GUI.Zipf;
import zipf.GUI.vis.Vis;
import zipf.GUI.vis.VisNote;
import zipf.GUI.table.CustomModel;
import zipf.GUI.table.NoteModel;
import zipf.GUI.table.NoteRenderer;
import zipf.GUI.table.CustomRenderer;
import zipf.GUI.tree.ToolsSplitTree;
import zipf.event.Note;
import zipf.event.NoteSeq;
import zipf.event.Seq;
import zipf.event.interfaces.Element;
import zipf.eventControl.EventController;

public class GridNote extends ToolsBar {

    public GridVolume volumeGrid;

    public GridNote() {
        model = new CustomModel(this);
        renderer = new CustomRenderer(this);
    }

    public GridNote(GridEdit edit) {
        super(edit, 20);
        this.addControl(new SidePanelNote(this));
    }

    @Override
    public void setMRQ() {
        initQueue(new NoteSeq(127, this, true));
        renderer = new NoteRenderer(this);
        model = new NoteModel(this);
    }

    @Override
    public void gridClicked() {
        setMoveRoot();
        Note note = new Note(queue(), queue().longValue(moveRoot.x), invert(moveRoot.y), queue().longValue((queue().resolution)));
        singleFocusOn(note.eventVis);
    }

    @Override
    public void addToUI(Vis vis) {
        super.addToUI(vis);
        if (vis instanceof VisNote) {
            volumeGrid.editPane.add(((VisNote) vis).volumeVis, JLayeredPane.MODAL_LAYER);
        }
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        ((ToolsBar) this).loadFileToNewGrid(ToolsSplitTree.selectedFile);
        dtde.getDropTargetContext().dropComplete(true);
    }

    @Override
    public void visualizeSeq(Seq seq) {
        if (ctrlPressed) {
            Point grid = getGridPoint();
            seq.queue = queue();
            seq.setPosition(seq.longValue(grid.x));
            seq.baseNote = invert(grid.y);
            seq.initUI();
            return;
        }
        clearGrid();
        initQueue(seq);
        seq.setVisibility(this);
        edit.transportControls.jSpinner1.setValue(queue().Midi.getTempoInBPM());
                        edit.updateCw(15);
    }

    @Override
    public void newQueue() {
        /* TODO ask for saving
         * setResolution
         */
        clearGrid();
        visualizeSeq(new NoteSeq(127, this, true));
    }

    @Override
    public void initQueue(Seq seq) {
        edit.mainQueue = seq;
        GridTools.queueInEdit = (NoteSeq) seq;
        edit.updateColumns();
    }
}
