package zipf.GUI.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import zipf.GUI.grid.GridNote;
import zipf.GUI.grid.GridTable;
import zipf.event.Note;

public class NoteRenderer extends CustomRenderer {

    public JPanel emptyGrayCell = new Cell();
    public JPanel emptyCell = new JPanel();
    public JPanel grayCell = new Cell();
    Color color = new Color(230, 230, 230);
    GridNote tools;

    public NoteRenderer() {
    }

    public NoteRenderer(GridNote tools) {
        this.tools = tools;
        super.tools = this.tools;
        emptyGrayCell.removeAll();
        emptyCell.setOpaque(false);
        emptyGrayCell.setBackground(color);
        grayCell.setBackground(color);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int resolution = tools.edit.getTickResolution();
        int tRow = row + 20;
        int row12 = tRow % 12;
        if ((row12 < 4 && tRow % 2 == 0) || ((row12 > 4 && row12 < 11) && (tRow + 1) % 2 == 0)) {
            if (column % (resolution * tools.barDiv / ((GridTable) tools).getColumnFactor()) == 0) {
                if (column != 0) {
                    return grayCell;
                }
            }
            return emptyGrayCell;
        }
//        System.out.println(tools.queue().resolution*tools.barDiv);
        if (column % (resolution * tools.barDiv / ((GridTable) tools).getColumnFactor()) == 0) {
            if (column == 0 && (((row - 1) - 6) % 12) == 0) {
                int oct = (row - 1 - 6) / 12;
                return new JLabel("C " + (8 - oct));
            }
            if (column != 0) {
                return cell;
            }
        }
        return null;
    }
}
