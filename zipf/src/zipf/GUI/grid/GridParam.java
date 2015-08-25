package zipf.GUI.grid;

import java.awt.Color;
import zipf.GUI.table.CCModel;
import zipf.GUI.table.CCRenderer;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import zipf.GUI.vis.Vis;
import zipf.GUI.vis.VisPanel;
import zipf.GUI.vis.VisHelper;
import zipf.event.CC;
import zipf.lookAndFeel.Designer;

public abstract class GridParam extends GridLine {

    public String signature;

    public GridParam(ToolsBar tools) {
        super(tools.edit, 60);
    }

    public void dragOperation() {
        Point gridPoint = editPane.getMousePosition();
        if (gridPoint != null) {
            int position = gridPoint.x/edit.cw;
            if (position < columns()) {
                if (!lastClickRight) {
                    model.setValueAt(VisHelper.getVisY(editPane.getMousePosition().y), 0, position);
                } else {
                    model.setValueAt(-1, 0, position);
                }
            }
        }
    }

    @Override
    public void gridDragged() {
        dragOperation();
    }

    @Override
    public void gridPressed(MouseEvent evt) {
        lastClickRight = evt.getButton() == MouseEvent.BUTTON3;
    }

    @Override
    public void gridClicked() {
        dragOperation();
    }
}
