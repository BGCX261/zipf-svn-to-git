package zipf.GUI.grid;

import java.util.ArrayList;
import java.util.HashMap;
import zipf.event.Seq;
import zipf.event.Song;
import zipf.lookAndFeel.Borders;

public class GridEditTools extends GridTools {

    public HashMap<String, GridParam> params = new HashMap<String, GridParam>();
    public Seq mainQueue;
    public int cw = 10;
    public ArrayList<GridBasic> grids = new ArrayList<GridBasic>();
    public boolean gridOff;

    public GridEditTools() {
        edit = (GridEdit) this;
    }

    void scrollGrids(int value) {
        for (GridBasic grid : grids) {
            grid.scrollLoop.getHorizontalScrollBar().setValue(value);
        }
    }

    public void updateCw(int cw) {
        this.cw = cw;
        updateColumns();
        for (GridBasic grid : grids) {
            grid.updateGridBounds();
        }
        for (GridBasic grid : grids) {
            grid.updateCw();
        }
    }

    public void updateColumns() {
        for (Grid grid : grids) {
            grid.updateColumnCount();
        }
    }

    public int getTickResolution() {
        return Integer.parseInt(((GridEdit) this).transportControls.tickDiv.getText());
    }

    int getBarResolution() {
        return Integer.parseInt(((GridEdit) this).transportControls.barDiv.getText());
    }

    public void switchTo(int i){
        switch (i){
            case GRID: {
                ((GridEdit)this).editSplit.setDividerLocation(.75);
             break;
            }
            case CONDITIONS: {
                ((GridEdit)this).tabbedParamAndConditions.setSelectedIndex(1);
                ((GridEdit)this).editSplit.setDividerLocation(.25);
                break;
            }
            case PARAMS: {
                ((GridEdit)this).tabbedParamAndConditions.setSelectedIndex(0);
                break;
            }
        }
    }
}
