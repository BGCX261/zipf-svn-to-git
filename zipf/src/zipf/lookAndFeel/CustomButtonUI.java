package zipf.lookAndFeel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import zipf.GUI.grid.ToolsPanel;

public class CustomButtonUI extends LineBorder {

    private int arc = 20;
    private Color colorOut = Colors.CONDITION_BACKGROUND;
    private Color colorIn = Color.white;

    public CustomButtonUI(int arc, int thickness, Color colorOut, Color colorIn) {
        this(arc);
        this.thickness = thickness;
        this.colorOut = colorOut;
        this.colorIn = colorIn;
    }

    public CustomButtonUI(int arc) {
        super(Colors.CONDITION_LIGHT_BACKGORUND);
        this.arc = arc;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
//        if (c instanceof JButton) {
//            JButton button = (JButton) c;
//        if (c.getBounds().height < 15) {
//            arc = 5;
//        }
//        }
        h -= 2;
        w -= 1;
        g.setColor(colorOut);
        int x2 = x;
        int y2 = y;
        int w2 = w;
        int h2 = h;
        for (int i = 0; i < thickness; i++) {
            g.drawRoundRect(x2, y2, w2, h2 + 1, arc, arc);
            x2--;
            y2--;
            w2 += 2;
            h2 += 2;
        }
        if (c.getBounds().height > 25 && c.getBounds().width > 25) {
            g.setColor(colorIn);
//            g.drawRoundRect(x + 2, y + 2, w - 4, h - 3, arc, arc);
            g.setColor(colorIn);
            g.drawRoundRect(x + 1, y + 1, w - 2, h - 1, arc, arc);
        }

    }
}
