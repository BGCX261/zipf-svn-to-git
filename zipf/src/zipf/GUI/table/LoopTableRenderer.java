package zipf.GUI.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import zipf.GUI.grid.Grid;
import zipf.GUI.vis.VisLoopStart;
import zipf.GUI.vis.VisLoopStop;
import zipf.GUI.grid.GridBasic;
import zipf.GUI.grid.GridLoop;
import zipf.lookAndFeel.Colors;

public class LoopTableRenderer extends CustomRenderer {

//    VisLoopStart start = new VisLoopStart( (GridLoop) tools);
//    VisLoopStop stop = new VisLoopStop((GridLoop) tools);
    JLabel start = new JLabel("[");
    JLabel stop = new JLabel("]");

    public LoopTableRenderer(Grid tools) {
        this.tools = tools;
        stop.setHorizontalAlignment(RIGHT);
        start.setForeground(Colors.DARK);
        stop.setForeground(Colors.DARK);
        start.setFont(new java.awt.Font("Tahoma", 0, 18));
        stop.setFont(new java.awt.Font("Tahoma", 0, 18));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (column == tools.queue().getIntLoopStart()) {
            return start;
        }
        if (column+1 == tools.queue().getIntLoopEnd()) {
            return stop;
        }
        return null;
    }
}
