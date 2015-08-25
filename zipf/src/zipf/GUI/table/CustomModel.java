package zipf.GUI.table;

import java.awt.Frame;
import java.awt.Point;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import zipf.GUI.grid.Grid;
import zipf.GUI.grid.GridBasic;
import zipf.GUI.grid.ToolsBar;
import zipf.GUI.grid.ToolsVis;
import zipf.event.Event;
import zipf.event.Note;
import zipf.event.Pool;
import zipf.event.interfaces.MidiMetrics;

public class CustomModel extends AbstractTableModel {

    public Grid tools;
    static int count;

    public CustomModel(Grid tools) {
        this.tools = tools;
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        if (tools.edit.gridOff) {
            return (int) tools.queue().getDuration() / (MidiMetrics.PPQ / tools.edit.getTickResolution());
        }
        return tools.queue().intDuration();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        super.addTableModelListener(l);
//        System.out.println("added  " + l);
    }
}
