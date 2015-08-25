package zipf.lookAndFeel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;
import zipf.GUI.grid.GridEdit;

class CustomSliderUI extends BasicSliderUI {

    public CustomSliderUI(JSlider slider) {
        super(slider);
    }

    @Override
    public void paintThumb(Graphics g) {
    g.setColor(Colors.CONDITION_BACKGROUND);
    Rectangle rect = thumbRect;
    g.fillRoundRect(rect.x,rect.y,this.getThumbSize().width, getThumbSize().height,15,15);
    g.setColor(Color.white);
    g.drawRoundRect(rect.x,rect.y,this.getThumbSize().width, getThumbSize().height,15,15);
    }

    @Override
    protected Dimension getThumbSize() {
        return new Dimension(20,20);
    }



    @Override
    public void paintTrack(Graphics g) {
        g.setColor(Colors.CONDITION_BACKGROUND);

        int w = slider.getBounds().width;
        int h = slider.getBounds().height;
        if (slider.getOrientation() == JSlider.VERTICAL) {
            int w2 = h;
            h = w;
            w = w2;
        }
        int p1 = 0;
        int p2 = 0;
        int p3 = w - w / 17;
        int p4 = w - w / 20;
        int p5 = w - w / 17;
        int p6 = h / 2 + 1;
        int p7 = h / 2 - 1;
        int p8 = h / 6;
        int p9 = h / 6 * 3;
        int p10 = h / 6 * 5;
        int[] coord1 = new int[]{p1, p2, p3, p4, p5};
        int[] coord2 = new int[]{p6, p7, p8, p9, p10};
        if (slider.getOrientation() == JSlider.VERTICAL) {
            g.fillPolygon(coord2, coord1, 5);
            g.setColor(Color.white);
            g.drawPolygon(coord2, coord1, 5);
        } else {
            g.fillPolygon(coord1, coord2, 5);
            g.setColor(Color.white);
            g.drawPolygon(coord1, coord2, 5);
        }
    }


}
