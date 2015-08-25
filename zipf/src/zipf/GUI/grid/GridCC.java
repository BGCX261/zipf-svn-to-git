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

public class GridCC extends GridParam {

    int ccNumber;

    public GridCC(ToolsBar tools, int ccNumber) {
        super(tools);
//        ((SidePanelParam) controls.getComponent(0)).paramTitle.setText("CC " + ccNumber);
        this.ccNumber = ccNumber;
        ((CCModel)model).ccNumber=ccNumber;
        gridSplit.setDividerLocation(edit.gridTable.gridSplit.getDividerLocation());
    }

    @Override
    public void setMRQ() {
        renderer = new CCRenderer(this);
        model = new CCModel(this, ccNumber);
    }
}
