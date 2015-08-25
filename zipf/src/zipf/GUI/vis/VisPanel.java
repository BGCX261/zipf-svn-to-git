package zipf.GUI.vis;

import java.awt.Color;
import java.awt.Event;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import zipf.GUI.grid.Metrics;
import zipf.GUI.grid.ToolsVis;

public class VisPanel extends JPanel implements Metrics {

    public ToolsVis tools;
    public static final Color INIT = new Color(0, 102, 102);
    public static final Color FOCUSED = Color.RED;
    public Point dragPoint;

    public VisPanel(final ToolsVis tools) {
        this.tools = tools;
        final VisPanel vis = this;
        addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vis.mouseClicked(evt);
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vis.mousePressed(evt);
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vis.mouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {

            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                vis.mouseDragged(evt);
            }


        });
    }

    public int invert(int i) {
        return Math.abs(tools.rows() - i);
    }

    public void updateBounds() {
    }

    public void mouseClicked(MouseEvent evt) {
        tools.visMouseClicked(this, evt);
    }

    public void mousePressed(MouseEvent evt) {
        tools.visMousePressed(this, evt);
    }

    public void mouseReleased(MouseEvent evt) {
        tools.visMouseReleased(this, evt);
    }

    public void mouseDragged(MouseEvent evt) {
        tools.visDragged(this, evt);
    }
}
