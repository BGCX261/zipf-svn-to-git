package zipf.GUI.vis;

import java.awt.event.MouseEvent;
import zipf.GUI.vis.VisPanel;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JPanel;
import zipf.GUI.grid.GridTools;
import zipf.GUI.grid.ToolsVis;
import zipf.lookAndFeel.Colors;

public class TransportBar extends Vis {

    public TransportBar(ToolsVis tools) {
        super(tools);
        setBackground(Colors.CONDITION_MEDIUM_BACKGORUND);
        setBounds(0, 0, 14, 127*tools.ch);
        tools.editPane.add(this, javax.swing.JLayeredPane.POPUP_LAYER);
    }

    @Override
    public int position() {
        return (int) (getLocation().x / tools.cw());
    }

    @Override
    public void setPosition(int i) {
         setLocation((int) ((float)i * tools.cw()), getLocation().y);
    }

    @Override
    public void updateBounds() {
        setBounds((int) (tools.cw() * (float) position()), 0, 14, tools.editPane.getHeight());
    }

    @Override
    public void mouseClicked(MouseEvent evt) {

    }

    @Override
    public void mouseDragged(MouseEvent evt) {
        Point p = tools.getGridPoint();
        if (p!=null) {
        setPosition(p.x);
        }
    }

    @Override
    public void mousePressed(MouseEvent evt) {
    }

    @Override
    public void mouseReleased(MouseEvent evt) {
        tools.queue().Midi.setIntTickPosition(position());
    }

    

}
