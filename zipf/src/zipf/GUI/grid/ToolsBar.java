package zipf.GUI.grid;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.sound.midi.Sequencer;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import zipf.GUI.Midi2Seq;
import zipf.GUI.vis.Vis;
import zipf.GUI.vis.VisPanel;
import zipf.GUI.vis.VisBar;
import zipf.IO.FileIO;
import zipf.event.Event;
import zipf.event.NoteEvent;
import zipf.event.NoteSeq;
import zipf.event.Seq;
import zipf.event.Song;
import zipf.event.interfaces.Routable;

public abstract class ToolsBar extends ToolsVis {

    public boolean ctrlPressed;
    public double dividerFactor;

    public ToolsBar() {
    }
    public static File selectedFile;
    private boolean resizing;
    public JPanel dragPanel = new DragPanel();
    public int barDiv = 4;

    public ToolsBar(GridEdit edit, int ch) {
        super(edit, ch);
        editPane.add(dragPanel, JLayeredPane.PALETTE_LAYER);
    }

    public void resizeBar(VisBar bar) {
        setMoveRoot();
        if (moveRoot != null) {
            long i = moveRoot.x - bar.position();
            if (i > 0) {
                i = bar.connectedEvent.longValue((int) i);
                ((NoteEvent) bar.connectedEvent).setDuration(i);
            }
        }
    }

    @Override
    public void visMousePressed(VisPanel vis, MouseEvent evt) {
        super.visMousePressed(vis, evt);
        if (evt.getPoint().x > vis.getWidth() - 10) {
            resizing = true;
        }
    }

    @Override
    public void visMouseReleased(VisPanel vis, MouseEvent evt) {
        vis.dragPoint = null;
        movedVis = null;
        resizing = false;
        copied = false;
    }

    @Override
    public void visDragged(VisPanel vis, MouseEvent evt) {
        if (resizing) {
            resizeBar((VisBar) vis);
            return;
        }
        super.visDragged(vis, evt);
    }

    public void playSequence() {
        queue().play();
    }

    public void stopSequencer() {
        queue().stop();
    }

    public void addCC() {
        GridParam gridCC = new GridCC(this, 1);
        addParam(gridCC);
    }

    public void addParam(GridParam gridParam) {
        edit.params.put(gridParam.signature, gridParam);
        edit.containerParam.paramContainer.add(gridParam);
        edit.containerParam.revalidate();
        gridParam.updateAll();
    }

    public void saveSeq(File file) {
        queue().set("file", file);
        FileIO.save(queue(), file);
    }

    public void saveSeq(String name) {
        File file = new File("Library" + File.separator + queue().getClass().getSimpleName() + File.separator + name);
        saveSeq(file);
    }

    public <GenSeq extends Seq> GenSeq load(File file) {
        GenSeq queue = (GenSeq) FileIO.load(file);
        queue.tools = this;
        queue.initMidi();
        queue.updateEventMidi(this);
        queue.applyProperties();
        return queue;
    }

    public abstract void newQueue();

    public abstract void initQueue(Seq seq);

    public void loadFileToNewGrid(File file) {
        if (file.isFile()) {
            Seq queue;
            if (file.getName().endsWith(".mid")) {
                queue = (NoteSeq) new Midi2Seq().convert(file, this);
            } else {
                queue = (Seq) load(file);
            }
            queue.visible = false;
            visualizeSeq(queue);
            edit.transportControls.loopButton.getModel().setSelected(queue.Midi.isLooped());
        }
    } // TODO temporäre Pattern letzte drei (setVisible())

    public abstract void visualizeSeq(Seq seq);

    public void clearGrid() {
        for (Vis vis : viss) {
            vis.remove();
        }
        queue().clearSeq();
        for (GridParam param : edit.params.values()) {
            param.model.fireTableDataChanged();
        }
        viss.clear();
        focused.clear();
        edit.transportControls.loopButton.setSelected(false);
        this.getTransportBar().setPosition(0);
    }

    void setSeqLength(int i) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void updateAll() {
        super.updateAll();
        updateVissBounds();
        if (transportBar != null) {
            transportBar.updateBounds();
        }
    }

    @Override
    public void gridPressed(MouseEvent evt) {
        setMoveRoot();
        dragStart = getGridPoint();
        if (dragStart != null) {
            tableMouseDragged = true;
            dragPanel.setBounds((int) ((float) dragStart.x * cw()), dragStart.y * ch, (int) cw(), ch);
            dragPanel.setVisible(true);
        }
    }

    @Override
    public void gridReleased() {
        dragPanel.setVisible(false);
        tableMouseDragged = false;
    }

    @Override
    public void gridDragged() {
        Point p = getGridPoint();
        if (p != null && dragStart != null) {
            int x = p.x;
            int y = p.y;
            int width = x - dragStart.x;
            int height = y - dragStart.y;
            if (width > 0) {
                x = dragStart.x;
            }
            if (height > 0) {
                y = dragStart.y;
            }
            Rectangle rec = new Rectangle((int) ((float) x * cw()), y * ch, (int) (((float) (Math.abs(width) + 1)) * cw()), (Math.abs(height) + 1) * ch);
            dragPanel.setBounds(rec);
            markItems(rec);
        }
    }

    void updateCh(int value) {
        ch = value;
        updateGridBounds();
        updateVissBounds();
        updateCh();
        table.updateUI();
        model.fireTableStructureChanged();
    }

    void setQuarterCount() {
        queue().resolution = edit.getTickResolution();
        this.barDiv = edit.getBarResolution();
        edit.updateColumns();
    }

    void setQuarterDivision(boolean state) {
        edit.gridOff = state;
        if (state) {
            queue().resolution = 256;
            updateVissBounds();
        } else {
            queue().resolution = edit.getTickResolution();
        }
    }

    void setLoopEnabled(boolean bool) {
        if (bool) {
            queue().Midi.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
        } else {
            queue().Midi.setLoopCount(0);
        }
    }

}
