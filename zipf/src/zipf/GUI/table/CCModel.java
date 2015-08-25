package zipf.GUI.table;

import java.util.TreeMap;
import javax.swing.JPanel;
import zipf.GUI.grid.GridBasic;
import zipf.GUI.grid.GridParam;
import zipf.event.CC;
import zipf.event.Param;
import zipf.event.Pool;
import zipf.event.interfaces.MidiMetrics;

public class CCModel extends CustomModel {

    public int ccNumber;

    public CCModel(GridParam tools, int ccNumber) {
        super(tools);
        this.ccNumber = ccNumber;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return tools.queue().ccs.get(ccNumber).get((long) columnIndex * (MidiMetrics.PPQ / tools.edit.getTickResolution()));
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        CC cc = tools.queue().ccs.get(ccNumber).get((long) columnIndex * (MidiMetrics.PPQ / tools.edit.getTickResolution()));
        int i = ((Integer) value);
        if (cc != null) {
            cc.setY(i);
            tools.model.fireTableDataChanged();
            return;
        }
        if (i >= 0) {
            CC cc2 = new CC(tools.queue(), (long) columnIndex * (MidiMetrics.PPQ / tools.edit.getTickResolution()), i, 1);
            tools.model.fireTableDataChanged();
            return;
        }
    }

    public String getSignature() {
        return ((GridParam) tools).signature;
    }
}
