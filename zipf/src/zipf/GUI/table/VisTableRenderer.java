package zipf.GUI.table;

import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTable;
import zipf.GUI.grid.ToolsVis;
import zipf.event.Note;

public class VisTableRenderer extends CustomRenderer {

    public ToolsVis grid;

    public VisTableRenderer() {
    }

    public VisTableRenderer(ToolsVis grid) {
        this.grid = grid;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {


        if (isSelected) {
            int[] selColumns = table.getSelectedColumns();
            int[] selRows = table.getSelectedRows();
            int firstColumn = selColumns[0];
            int firstRow = selRows[0];
            int cLength = selColumns.length;
            int rLength = selRows.length;
            if (cLength>2||rLength>2) {
            
            grid.markItems(new Rectangle(firstColumn, firstRow, cLength,rLength));
        
            }
            if (grid.tableMouseDragged){
                return sCell;
        }}

        if (value instanceof Note) {
            return new JLabel("N");
        }

        if (column % 4 == 0) {
            return cell;
        }
        if (hasFocus) {
            return new JLabel("foc");
        }

        return null;

    }
}
