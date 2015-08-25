package zipf.GUI.table;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.TreeSet;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import zipf.GUI.condition.ConSetPanel;
import zipf.GUI.grid.Grid;
import zipf.GUI.vis.VisNote;
import zipf.GUI.grid.GridBasic;
import zipf.GUI.grid.GridNote;
import zipf.GUI.grid.GridTools;
import zipf.GUI.grid.ToolsVis;
import zipf.event.Note;
import zipf.event.NoteSeq;

public class CustomRenderer extends DefaultTableCellRenderer {

    Cell cell = new Cell();
    SelectedCell sCell = new SelectedCell();
    public Grid tools;

    public CustomRenderer() {
    }



    public CustomRenderer(Grid tools) {
        this.tools = tools;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {


        if (isSelected) {
            return sCell;
        }

        if (value instanceof Note) {
            return new JLabel("N");
        }
        if (column==0)
            return null;
        if (column % 4 == 0) {
            return cell;
        }
        if (hasFocus) {
            return new JLabel("foc");
        }

        return null;

    }


}
