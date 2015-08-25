package zipf.GUI.grid;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.Console;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.HashMap;
import javax.swing.JPanel;
import zipf.GUI.condition.ConSetContainer;
import zipf.GUI.condition.TreeSide;
import zipf.GUI.condition.TreeSides;

public class ToolsPanel {

    public static HashMap<String, Long> timeMeasure = new HashMap<String, Long>();

    public static void setFixedHeight(Component panel, int height) {
        panel.setMinimumSize(new Dimension(panel.getMinimumSize().width, height));
        panel.setPreferredSize(new Dimension(panel.getPreferredSize().width, height));
        panel.setMaximumSize(new Dimension(panel.getMaximumSize().width, height));
    }

    public static void setAutoHeight(JPanel panel) {
        setAutoHeight(panel, panel.getPreferredSize().width);
    }

    public static void setAutoHeight(JPanel panel, int width) {
        setFixedBounds(panel, width, getAutoHeight(panel));
    }

    public static int getAutoHeight(JPanel panel) {
        int i = 0;
        for (Component c : panel.getComponents()) {
            i += c.getPreferredSize().height;
        }
        return i;
    }

    public static void setFixedBounds(Component panel, int width, int height) {
        panel.setMaximumSize(new Dimension(width, height));
        panel.setPreferredSize(new Dimension(width, height));
        panel.setMinimumSize(new Dimension(width, height));
        if (panel instanceof JPanel) {
            ((JPanel) panel).updateUI();
        }
    }

    public static void start(Object o) {
        timeMeasure.put(o.toString(), System.nanoTime());

    }

    public static void getTime(Object o) {
        Formatter f = new Formatter();
        System.out.println(f.format("%s  %f", o.toString(), new BigDecimal((System.nanoTime() - timeMeasure.get(o.toString()))).doubleValue() / 100000d));
    }

    public static void setAutoHeightX(JPanel panel) {
        int i = 0;
        int width = 0;
        for (Component c : panel.getComponents()) {
            int size = c.getPreferredSize().height;
            if (i < size) {
                i = size;
            }
            width += c.getPreferredSize().width;
        }

        setFixedBounds(panel, width,i);
    }
}
