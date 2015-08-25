package zipf.lookAndFeel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Shape;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class CustomTabbedUI extends BasicTabbedPaneUI {

    public CustomTabbedUI() {
        this.focus = Colors.CONDITION_BACKGROUND;
        this.shadow = Colors.CONDITION_BACKGROUND;
        this.lightHighlight = Colors.CONDITION_BACKGROUND;
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
    }

    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
        super.paintContentBorder(g, tabPlacement, selectedIndex);
//        Graphics2D g2= (Graphics2D) g;
//        g2.setColor(Color.red);
//        g2.drawShape(new Shape(this.tabPane.getComponentAt(selectedIndex).getBounds()));

    }

    @Override
    protected Insets getContentBorderInsets(int tabPlacement) {
        if(tabPane.getTabPlacement()==JTabbedPane.BOTTOM){
            return new Insets(0,0,2,0);
        } else return new Insets(2,2,2,2);
    }

    @Override
    protected void paintContentBorderBottomEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        g.setColor(Colors.TAB_LINE);
        Rectangle rec = new Rectangle();
        this.getTabBounds(selectedIndex,rec);
        g.drawLine(x+1, y, x+1, y+h-rec.height+2);
        g.drawLine(x+1, y, rec.x-x+1, y);
        if(tabPane.getTabPlacement()==JTabbedPane.BOTTOM){
            y+=h-1;
            rec.x-=1;
        }
        g.drawLine(rec.x+rec.width-1, y, w-1, y);
    }

    @Override
    protected void paintContentBorderLeftEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
    }

    @Override
    protected void paintContentBorderRightEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
    }

    @Override
    protected void paintContentBorderTopEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
    }

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
    }

    @Override
    protected void paintIcon(Graphics g, int tabPlacement, int tabIndex, Icon icon, Rectangle iconRect, boolean isSelected) {
    }

    @Override
    protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect) {
        super.paintTab(g, tabPlacement, rects, tabIndex, iconRect, textRect);
    }

    @Override
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
        super.paintTabArea(g, tabPlacement, selectedIndex);
    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
//        w -= 6;
        h+=20;
        if(tabPane.getTabPlacement()==JTabbedPane.BOTTOM){
            y-=23;
            x-=2;
            y+=1;
        }
        g.setColor(Colors.CONDITION_LIGHT_MEDIUM_BACKGORUND);
        if (isSelected) {
            g.setColor(Colors.TAB_BACKGROUND);
            g.fillRoundRect(x, y, w, h + 1, 75,75);
            g.drawRoundRect(x, y, w, h + 1, 75,75);
            g.setColor(Color.CYAN);
            g.drawRoundRect(x + 1, y + 1, w - 2, h - 1, 75,75);
            g.setColor(Colors.TAB_LINE);
            g.drawRoundRect(x + 1, y + 2, w - 2, h - 1, 75,75);
        } else {
            w+=8;
            x-=2;
            g.fillRoundRect(x, y + 1, w, h + 1, 20, 20);
//            g.setColor(Colors.CONDITION_BORDER);
            g.drawRoundRect(x, y, w, h + 1, 20, 20);
            g.setColor(Color.white);
            g.drawRoundRect(x + 1, y + 1, w - 2, h - 1, 20, 20);

        }
    }
}
