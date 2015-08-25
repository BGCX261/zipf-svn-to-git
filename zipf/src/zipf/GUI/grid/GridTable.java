package zipf.GUI.grid;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.TableColumn;
import zipf.GUI.KeyInput;
import zipf.GUI.Browser;
import zipf.GUI.vis.TransportBar;
import zipf.GUI.vis.Vis;
import zipf.event.interfaces.Element;

public abstract class GridTable extends GridBasic implements DropTargetListener {

    public TransportBar transportBar = new TransportBar((ToolsVis) this);
    public Point dragStart;
    public ArrayList<Vis> viss = new ArrayList<Vis>();
    private int columnCount;

    public GridTable(GridEdit edit, int ch) {
        super(edit, ch);
        table.setDropTarget(new DropTarget(table, this));
    }

    public GridTable() {
    }

    @Override
    public void updateCw() {
        columnCount = columns();
        int resolution = edit.getTickResolution();
        int columnWidth = edit.cw;
        if (columnWidth < 15) {
            columnWidth *= resolution;
            columnCount = (columnCount % resolution) + (columnCount / resolution);
        }
        for (int i = 0; i < columnCount - 1; i++) {
            table.getColumnModel().getColumn(i).setMinWidth(columnWidth);
            table.getColumnModel().getColumn(i).setPreferredWidth(columnWidth);
            table.getColumnModel().getColumn(i).setMaxWidth(columnWidth);
        }
        updateVissBounds();
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
    }

    public void dragInElement(Element queue) {
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
    }

    public void updateVissBounds() {
    }

    public int getColumnFactor() {
        int i = Math.round((float) columns() / (float) columnCount);
        if (i < 0) {
            return i;
        }
        return 1;
    }
}
