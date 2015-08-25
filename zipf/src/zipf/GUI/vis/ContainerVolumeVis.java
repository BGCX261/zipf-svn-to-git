package zipf.GUI.vis;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class ContainerVolumeVis extends JLayeredPane {

    public ContainerVolumeVis() {
        this.setBackground(Color.white);
    }

    public void updateLayers() {
        TreeMap<Integer, Component> heights = new TreeMap<Integer, Component>();
        for (Component c : this.getComponents()) {
            if (c.getBackground() != Vis.FOCUSED) {
                heights.put(c.getHeight(), c);
            }
        }
        int i = JLayeredPane.DEFAULT_LAYER;
        int j = 0;
        for(Component c:heights.values()){
            this.setLayer(c, i-j);
            j++;
        }
    }

}
