package zipf.GUI.grid;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import zipf.GUI.KeyInput;
import zipf.GUI.table.CustomModel;
import zipf.GUI.table.CustomRenderer;
import zipf.GUI.vis.TransportBar;
import zipf.event.Seq;

public abstract class Grid extends GridTools {

    public Grid() {
    }
    public Point moveRoot;
    public boolean lastClickRight;
    JScrollPane scrollPane;
    public CustomRenderer renderer;
    public CustomModel model;
    public JTable table;
    public JLayeredPane editPane;
    public int ch;

    public Grid(GridEdit edit, int ch) {
        this.edit = edit;
        this.ch = ch;
    }

    public abstract void setMRQ();

    public void initTable() {
        if (model == null) {
            table.setModel(new DefaultTableModel());
        } else {
            table.setModel(model);
        }
        table.setDefaultRenderer(Object.class, renderer);
    }

    public int rows() {
        return model.getRowCount();
    }

    public int invert(int i) {
        return Math.abs(rows() - i);
    }

    public Point quantizeCoordinates(Point p) {
        if (p != null) {
            p.x = (int) ((float) p.x / (float) cw());
            p.y /= ch;
            return p;
        }
        return null;
    }

    void updateColumnCount() {
        model.fireTableStructureChanged();
    }

    public void updateCw() {
        int editCw = edit.cw;
        table.setShowVerticalLines(editCw > 5);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setMinWidth(editCw);
            table.getColumnModel().getColumn(i).setPreferredWidth(editCw);
            table.getColumnModel().getColumn(i).setMaxWidth(editCw);
        }
    }

    public void updateCh() {
        table.setRowHeight(ch);
        ToolsPanel.setFixedHeight(editPane, rows() * ch);
        ToolsPanel.setFixedHeight(table, rows() * ch);
    }

    public void updateGridBounds() {
        Dimension dimension = new Dimension((int) ((float) columns() * cw()), rows() * ch);
        dimension.width = columns() * edit.cw;
        dimension.height = rows() * ch;
        table.setSize(dimension);
        editPane.setSize(dimension);
        table.setPreferredSize(dimension);
        editPane.setPreferredSize(dimension);
    }

    public void setMoveRoot() {
        moveRoot = getGridPoint();
    }

    public Point getGridPoint() {
        return quantizeCoordinates(editPane.getMousePosition());
    }

    public void updateAll() {
        updateGridBounds();
        updateColumnCount();
        updateCw();
        updateCh();
    }

    public TransportBar getTransportBar() {
        return edit.gridTable.transportBar;
    }
}
