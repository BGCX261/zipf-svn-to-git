package zipf.GUI.table;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import zipf.GUI.grid.GridParam;
import zipf.GUI.vis.ContainerVolumeVis;

public class VolumeParamRenderer extends CustomRenderer {

    public VolumeParamRenderer(GridParam tools) {
        super(tools);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if(value instanceof Component){
            return (Component) value;
        }
        return null;
    }
}
