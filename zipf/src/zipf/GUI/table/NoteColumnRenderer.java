package zipf.GUI.table;

import java.awt.Color;
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
import zipf.GUI.vis.VisNote;
import zipf.GUI.grid.GridBasic;
import zipf.GUI.grid.GridNote;
import zipf.GUI.grid.ToolsVis;
import zipf.event.Note;
import zipf.event.NoteSeq;

public class NoteColumnRenderer extends CustomRenderer {

    public ToolsVis grid;
    public JPanel emptyGrayCell = new Cell();
    public JPanel grayCell = new Cell();
    Color color = new Color(230, 230, 230);

    public NoteColumnRenderer() {
    }

    public NoteColumnRenderer(ToolsVis grid) {
        this.grid = grid;
        emptyGrayCell.removeAll();
        emptyGrayCell.setBackground(color);
        grayCell.setBackground(color);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        row += 9;
        if ((row % 12 < 4 && row % 2 == 0) || ((row % 12 > 4 && row % 12 < 11) && (row + 1) % 2 == 0)) {
            if (column % 4 == 0) {
                return grayCell;
            }
            return emptyGrayCell;
        }
        if (column != 0 && column % 4 == 0) {
            return cell;
        }
        return null;

    }
}
