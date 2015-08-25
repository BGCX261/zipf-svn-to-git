package zipf.GUI.grid;

import java.awt.Dimension;
import javax.swing.JPanel;
import zipf.event.Seq;
import zipf.lookAndFeel.Borders;

public abstract class GridLine extends GridBasic {

    public GridLine(GridEdit edit, int ch) {
        super(edit, ch);
        scrollLoop.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollLoop.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        table.setShowHorizontalLines(false);
        ToolsPanel.setFixedHeight(this, ch);
    }

    public GridLine() {
    }

    public void setValue(int position, Object value) {
        table.setValueAt(value, 0, position);
    }

    @Override
    public void gridReleased() {
        model.fireTableDataChanged();
    }
}
