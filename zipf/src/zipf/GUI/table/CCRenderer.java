package zipf.GUI.table;

import java.awt.Component;
import javax.swing.JTable;
import zipf.GUI.grid.Grid;
import zipf.event.CC;
import zipf.event.Param;

public class CCRenderer extends CustomRenderer {

    public CCRenderer(Grid tools) {
        super(tools);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof CC) {
            return (Component) ((CC)value).connectedPanel;
        }
        return null;
    }
}
