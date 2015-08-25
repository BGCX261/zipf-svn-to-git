package zipf.GUI.vis;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JLayeredPane;
import zipf.GUI.grid.ToolsVis;
import zipf.GUI.grid.Metrics;
import zipf.event.Event;

public class Vis<GenEvent extends Event> extends VisPanel implements Cloneable, Metrics {

    public GenEvent connectedEvent;

    public Vis(ToolsVis tools) {
        super(tools);
    }

    public Vis(ToolsVis tools, GenEvent event) {
        super(tools);
        connectedEvent = event;
    }

    public int position() {
        return connectedEvent.getIntPosition();
    }

    public int Y() {
        return Y(true);
    }

    public int Y(boolean invert) {
        if (invert) {
            return invert(connectedEvent.getY());
        }
        return connectedEvent.getY();
    }

    @Override
    public void updateBounds() {
        setBounds((int)((float)connectedEvent.getPosition() * tools.tw()), 0, (int) tools.cw(), tools.ch);
        revalidate();
    }

    @Override
    public String toString() {
        String str = "";
        str += "x: " + position() + "  y: " + Y();
        if (this instanceof VisBar) {
            str += " duration: " + ((VisBar) this).length();
        }
        return str;
    }

    public void setPosition(int i) {
            connectedEvent.setPosition(connectedEvent.longValue(i));
    }

    public void remove() {
        setVisible(false);
        tools.editPane.remove(this);
        connectedEvent.remove();
    }

    public void setY(int y) {
        connectedEvent.setY(y);
    }
}
