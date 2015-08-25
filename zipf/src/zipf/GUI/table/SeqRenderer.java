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
import zipf.GUI.grid.GridSeq;
import zipf.GUI.grid.GridTable;
import zipf.GUI.grid.ToolsVis;
import zipf.event.Note;
import zipf.event.NoteSeq;

public class SeqRenderer extends CustomRenderer {

    public GridSeq tools;
    public JPanel emptyGrayCell = new Cell();
    public JPanel grayCell = new Cell();
    Color color = new Color(230,230,230);

    public SeqRenderer() {
    }

    public SeqRenderer(GridSeq tools) {
        this.tools = tools;
        emptyGrayCell.removeAll();
        emptyGrayCell.setBackground(color);
        grayCell.setBackground(color);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int resolution = tools.edit.getTickResolution();
        if (column % (resolution*tools.barDiv/((GridTable)tools).getColumnFactor()) == 0) {
            if (column == 0 && ((row - 6) % 12) == 0) {
                int oct = (row - 6) / 12;
                return new JLabel("C " + (8 - oct));
            }
            return cell;
        }
        return null;

    }
}
