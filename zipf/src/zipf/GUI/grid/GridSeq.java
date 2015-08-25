package zipf.GUI.grid;

import java.awt.Point;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import zipf.GUI.table.SeqModel;
import zipf.GUI.table.SeqRenderer;
import zipf.GUI.tree.ToolsSplitTree;
import zipf.GUI.vis.Vis;
import zipf.event.Event;
import zipf.event.NoteSeq;
import zipf.event.Seq;
import zipf.event.Song;
import zipf.event.interfaces.Element;

public class GridSeq extends ToolsBar {

    public GridSeq() {
    }

    public GridSeq(GridEdit edit) {
        super(edit, 60);
        this.addControl(new SidePanelSeqEdit(this));
    }

    @Override
    public void setMRQ() {
        Song song = new Song(1027, this);
        edit.mainQueue = song;
        GridTools.songInEdit = song;
        model = new SeqModel(this);
        renderer = new SeqRenderer(this);
    }

    public void addTrack() {
        ((Song) queue()).addTrack();
        this.updateAll();
    }

    @Override
    public void gridClicked() {
        this.visualizeSeq(queueInEdit);
        singleFocusOn((Vis) queueInEdit.getVis());
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
        moveFocusedOnGrid();
    }

    @Override
    public void newQueue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void initQueue(Seq seq) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visualizeSeq(Seq seq) {
        if (seq instanceof NoteSeq) {
            visualizeNoteSeq(seq);
        } else if (seq instanceof Song) {
            visualizeSong((Song) seq);
        }
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        ((ToolsBar) this).loadFileToNewGrid(ToolsSplitTree.selectedFile);
        dtde.getDropTargetContext().dropComplete(true);
    }

    private void visualizeNoteSeq(Seq seq) {
        if (((Song) queue()).items.containsValue(seq)) {
            seq = (NoteSeq) seq.copy();
        }
        seq.queue = (queue());
        Point gridPoint = getGridPoint();
        if (gridPoint != null) {
            seq.trackNumber = gridPoint.y;
            seq.setPosition(seq.longValue(gridPoint.x));
            seq.initUI();
            setMoveRoot(seq.eventVis);
            edit.updateColumns();
            this.singleFocusOn((Vis) seq.getVis());
            moveFocusedOnGrid();
        }

    }

    void visualizeSong(Song seq) {
        clearGrid();
        edit.mainQueue = seq;
        GridTools.songInEdit = seq;
        seq.setVisibility(this);
        updateAll();
    }
}
