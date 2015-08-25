package zipf.lookAndFeel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.plaf.basic.BasicScrollBarUI;
import zipf.GUI.Zipf;
import zipf.GUI.grid.GridEdit;
import zipf.GUI.grid.GridTable;
import zipf.GUI.grid.ToolsPanel;

public class CustomScrollBarUI extends BasicScrollBarUI {

    public CustomScrollBarUI() {
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {

        g.setColor(Colors.CONDITION_LIGHT);
        g.fillRoundRect(trackBounds.x + 1, trackBounds.y + 1, trackBounds.width - 3, trackBounds.height - 3, 8, 8);
        g.setColor(Colors.CONDITION_MEDIUM_BACKGORUND);
        g.drawRoundRect(trackBounds.x + 1, trackBounds.y + 1, trackBounds.width - 3, trackBounds.height - 3, 8, 8);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        g.setColor(Colors.GRAY);
        if (thumbBounds.isEmpty() || !scrollbar.isEnabled()) {
            return;
        }
        int w = thumbBounds.width;
        int h = thumbBounds.height;
        g.translate(thumbBounds.x, thumbBounds.y);
        g.fillRoundRect(3, 3, w - 7, h - 7, 8, 8);
        g.setColor(Colors.CONDITION_LIGHT);
        g.drawRoundRect(3, 3, w - 7, h - 7, 8, 8);
        g.drawRect(3, 3, w - 7, h - 7);
        g.translate(-thumbBounds.x, -thumbBounds.y);
    }
}
