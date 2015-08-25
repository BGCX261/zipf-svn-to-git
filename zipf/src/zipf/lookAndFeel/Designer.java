package zipf.lookAndFeel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicCheckBoxUI;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.BasicSliderUI;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.plaf.metal.MetalScrollButton;
import javax.swing.text.JTextComponent;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import zipf.GUI.PanelCondition;
import zipf.GUI.grid.GridBasic;
import zipf.GUI.grid.GridEdit;
import zipf.GUI.grid.GridLine;
import zipf.GUI.grid.GridParam;
import zipf.GUI.grid.GridTable;
import zipf.GUI.grid.SidePanel;
import zipf.GUI.grid.ToolsPanel;
import zipf.GUI.grid.ToolsVis;
import zipf.GUI.grid.scrollBarUI;
import zipf.GUI.vis.TransportBar;
import zipf.GUI.vis.Vis;
import zipf.GUI.vis.VisPanel;

public class Designer {

    public static void design(AbstractButton button) {
        applyButtonStyle(button);
    }

    public static void design(Container c) {
        for (Component comp : c.getComponents()) {
            if (comp instanceof JTree) {
                designJTree((JTree) comp);
            } else if (comp instanceof JSlider) {
                ((JSlider) comp).setUI(new CustomSliderUI((JSlider) comp));
//                ((JSlider) comp).setBorder(Borders.BUTTON_ROUND);
            } else if (comp instanceof GridBasic) {
                ((JPanel) comp).setBorder(Borders.TREE_BORDER);
            } else if (comp instanceof JSplitPane) {
                designSplitPane(((JSplitPane) comp));
            } else if (comp instanceof JSpinner) {
                ((JSpinner) comp).setOpaque(false);
            } else if (comp instanceof SidePanel && ((JPanel) comp).getComponentCount() > 0) {
                ((JPanel) comp).setBorder(Borders.TREE_BORDER);
            } else if (comp instanceof JTabbedPane) {
                ((JTabbedPane) comp).setUI(new CustomTabbedUI());
                comp.setBackground(Colors.CONDITION_LIGHT_BACKGORUND);
            } else if (comp instanceof JScrollBar) {
                designScrollBar((JScrollBar) comp);
            } else if (comp instanceof JScrollPane) {
                ((JComponent) comp).setBorder(Borders.TREE_BORDER);
            }
            if (comp instanceof AbstractButton || comp instanceof JTextField) {
                applyButtonStyle((JComponent) comp);
            } else if (comp instanceof Container) {
                if (comp instanceof JPanel && !(comp instanceof Vis)) {
                    ((JPanel) comp).setOpaque(false);
                }
                design((Container) comp);
            }
        }
    }

    private static void applyButtonStyle(JComponent button) {
        (button).setForeground(Colors.DARK);
        if (button instanceof JCheckBox) {
            button.setOpaque(false);
            ((JCheckBox) button).setContentAreaFilled(false);
            ((JCheckBox) button).setBorderPaintedFlat(true);
            return;
        }
        button.setBorder(Borders.BUTTON_ROUND);
        button.setBackground(Colors.CONDITION_BACKGROUND);
        button.setOpaque(false);
        if (button instanceof JButton) {
            button.setBorder(new CustomButtonUI(13, 8, Colors.CONDITION_LIGHT_MEDIUM_BACKGORUND, Color.GRAY));
        button.setOpaque(true);
        }
        if (button instanceof BasicArrowButton) {
            ((BasicArrowButton) button).setBackground(Colors.CONDITION_LIGHT_BACKGORUND);
            ((BasicArrowButton) button).setForeground(Colors.CONDITION_BACKGROUND);
//            ((BasicArrowButton) button).setBorder(new CustomButtonUI(5,1,Colors.CONDITION_LIGHT_MEDIUM_BACKGORUND,Colors.CONDITION_LIGHT_BACKGORUND));
            ((BasicArrowButton) button).setBorder(Borders.PHANTOM);
        }
    }

    private static void designSplitPane(JSplitPane comp) {
        comp.setBackground(Colors.CONDITION_LIGHT_BACKGORUND);
        comp.setUI(new CustomSplitUI());
        comp.setBorder(null);
        comp.setDividerSize(25);
    }

    private static void designJTree(JTree tree) {
//        tree.setBorder(Borders.TREE_BORDER);
        tree.setBackground(Colors.CONDITION_LIGHT_BACKGORUND);
        tree.setCellRenderer(new CustomTreeRenderer());
        tree.setFont(new java.awt.Font(Font.SANS_SERIF, 0, 15));
    }

    private static void designScrollBar(JScrollBar scrollBar) {
        CustomScrollBarUI ui = new CustomScrollBarUI();
        scrollBar.setUI(ui);
        if (scrollBar.getOrientation() == JScrollBar.VERTICAL) {
            ToolsPanel.setFixedBounds(scrollBar, 25, scrollBar.getPreferredSize().width);
        } else {
            ToolsPanel.setFixedBounds(scrollBar, scrollBar.getPreferredSize().height, 25);
        }
        scrollBar.setOpaque(true);
    }

}
