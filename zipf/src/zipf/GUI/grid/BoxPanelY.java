package zipf.GUI.grid;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.Box.Filler;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class BoxPanelY extends JPanel{

    public BoxPanelY() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public Component add(Component comp) {
        return this.add(comp,this.getComponentCount());
    }

    @Override
    public Component add(Component comp, int index) {
        super.add(comp, index);
        ToolsPanel.setAutoHeight(this);
        return comp;
    }

    @Override
    public void remove(int index) {
        super.remove(index);
        ToolsPanel.setAutoHeight(this);
    }

    @Override
    public void remove(Component comp) {
        super.remove(comp);
        ToolsPanel.setAutoHeight(this);
    }
    
    

    
    

    
    
}
