package zipf.event;

import javax.swing.JPanel;
import zipf.GUI.vis.VisParamValue;

public abstract class Param extends Event {
       public VisParamValue connectedPanel = new VisParamValue();


    public Param( long position, int y) {
        super( position, y);
        connectedPanel = new VisParamValue();
        connectedPanel.setValue(y);
    }

}
