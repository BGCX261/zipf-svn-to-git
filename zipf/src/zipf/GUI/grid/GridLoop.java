package zipf.GUI.grid;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import zipf.GUI.table.CustomModel;
import zipf.GUI.table.LoopModel;
import zipf.GUI.table.LoopTableRenderer;

public class GridLoop extends GridLine {

    public GridLoop() {
        table.setModel(new DefaultTableModel());
    }

    public GridLoop(GridEdit edit) {
        super(edit, 30);
        this.addControl(new SidePanelLoop());
        this.updateGridBounds();
    }

    @Override
    public void setMRQ() {
        model = new CustomModel(this);
        renderer = new LoopTableRenderer(this);
    }

    @Override
    public void gridClicked() {
        setMoveRoot();
        if (moveRoot != null) {
            int loopStart = queue().getIntLoopStart();
            int loopEnd = queue().getIntLoopEnd();
            int position = moveRoot.x;
            if (Math.abs(position - loopStart) > Math.abs(position - loopEnd)) {
                queue().setIntLoopEnd(position);
            } else if (Math.abs(position - loopStart) < Math.abs(position - loopEnd)) {
                queue().setIntLoopStart(position);
            }
            model.fireTableDataChanged();
        }
    }

    @Override
    public void gridPressed(MouseEvent evt) {
        gridClicked();
    }

    @Override
    public void gridDragged() {
        gridClicked();
    }
}
