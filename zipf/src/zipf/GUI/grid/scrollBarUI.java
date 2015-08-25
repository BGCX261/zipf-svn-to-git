package zipf.GUI.grid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;
import zipf.lookAndFeel.Colors;

public class scrollBarUI extends BasicScrollBarUI {

    public scrollBarUI(Color color){
        this.trackColor=color;
        this.trackHighlightColor = color;
    }

    void setTrackColor(Color color){
        this.trackColor=color;
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
//        g.setColor(Colors.CONDITION_LIGHT_BACKGORUND);
//        g.fillRoundRect(trackBounds.x, trackBounds.y, trackBounds.width,trackBounds.height,10,10);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        g.setColor(Colors.GRAY);
        if(thumbBounds.isEmpty()||!scrollbar.isEnabled()){
            return;
        }
        int w = thumbBounds.width;
        int h = thumbBounds.height;
        g.translate(thumbBounds.x, thumbBounds.y);
        g.fillRect(0, 0, w,h);
        g.translate(-thumbBounds.x, -thumbBounds.y);
    }




}
