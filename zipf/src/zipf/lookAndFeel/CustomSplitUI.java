package zipf.lookAndFeel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import zipf.GUI.Browser;
import zipf.GUI.grid.GridEdit;
import zipf.GUI.grid.GridLoop;
import zipf.GUI.grid.GridTable;
import zipf.GUI.grid.ToolsPanel;
import zipf.GUI.tree.ToolsSplitTree;

public class CustomSplitUI extends BasicSplitPaneUI {

    public CustomSplitUI() {
    }

    @Override
    public BasicSplitPaneDivider createDefaultDivider() {
        BasicSplitPaneDivider div = new CustomDivider(this);
        return div;
    }

    class CustomDivider extends BasicSplitPaneDivider {

        private final BasicSplitPaneUI ui;
        double position;
        int positionInt;
        boolean isGridTable;
        boolean isBrowser;
        boolean isTabbedPane;
        public ArrayList<JSplitPane> panes = new ArrayList<JSplitPane>();
        public boolean isArrowed;
        boolean isEdit;
        int horizontalRightInset;

        public CustomDivider(BasicSplitPaneUI ui) {
            super(ui);
            this.ui = ui;
            Component parent = ui.getSplitPane().getParent();
            isEdit = parent != null && parent instanceof GridEdit;
            isGridTable = ui.getSplitPane().getParent() instanceof GridTable;
            isBrowser = ui.getSplitPane().getParent() instanceof ToolsSplitTree;
            isTabbedPane = ui.getSplitPane().getBottomComponent() instanceof JTabbedPane;
            if (isGridTable || isBrowser || isTabbedPane) {
                isArrowed = true;
                panes.add(ui.getSplitPane());
                JPanel panel = new JPanel();
                panel.setOpaque(true);
                if (ui.getSplitPane().getOrientation() == JSplitPane.VERTICAL_SPLIT) {
                    ToolsPanel.setFixedBounds(panel, 30, 30);
//                    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
                    this.setLayout(new BorderLayout());
                    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
                    panel.add(getArrow(BasicArrowButton.SOUTH, isBrowser));
                    panel.add(getArrow(BasicArrowButton.NORTH, isBrowser));
                    this.add(panel, BorderLayout.WEST);
                } else {
                    ToolsPanel.setFixedBounds(panel, 20, 25);
                    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
                    panel.add(getArrow(BasicArrowButton.WEST, false));
                    panel.add(getArrow(BasicArrowButton.EAST, false));
                    this.add(panel);
                }
                for (Component c : panel.getComponents()) {
                    if (c.isVisible()) {
                        panel.setComponentZOrder(c, 0);
                    }
                }
                if (isEdit) {
                    GridEdit edit = (GridEdit) parent;
                    JPanel spacer = new JPanel();
//                    ToolsPanel.setFixedBounds(spacer,100,20);
                    spacer.setMinimumSize(new Dimension(100,20));
                    spacer.setPreferredSize(new Dimension(100,20));
//                    spacer.setMaximumSize(new Dimension(123123,123123));
                    edit.Xpanel.add(spacer,BorderLayout.WEST);
                    this.add(edit.Xpanel);
                    horizontalRightInset = 120;
                }

            }
//                    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        }

        BasicArrowButton getArrow(int i, final boolean invert) {
            BasicArrowButton button = new BasicArrowButton(i);

            if (invert && i == BasicArrowButton.SOUTH) {
                button.setVisible(false);
            } else if ((i == BasicArrowButton.NORTH || i == BasicArrowButton.EAST) && !invert) {
                button.setVisible(false);
            }
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    BasicArrowButton button = ((BasicArrowButton) e.getSource());
                    int index = button.getParent().getComponentZOrder(button);
                    switch (index) {
                        case 1: {
                            JPanel panel = (JPanel) ((Component) e.getSource()).getParent();
                            boolean visibility = (panel.getComponent(0).isVisible());
                            panel.getComponent(0).setVisible(!visibility);
                            panel.getComponent(1).setVisible(visibility);
                            ui.getSplitPane().setDividerLocation(positionInt);
                            break;
                        }
                        case 0: {
                            positionInt = ui.getSplitPane().getDividerLocation();
                            JPanel panel = (JPanel) ((Component) e.getSource()).getParent();
                            boolean visibility = (panel.getComponent(1).isVisible());
                            panel.getComponent(0).setVisible(visibility);
                            panel.getComponent(1).setVisible(!visibility);
                            double d = 1d;
                            if (invert || ui.getOrientation() == JSplitPane.HORIZONTAL_SPLIT) {
                                d = 0d;
                            }
                            ui.getSplitPane().setDividerLocation(d);
                            break;
                        }
                    }
                }
            });
            button.setForeground(ui.getSplitPane().getBackground());
//            ToolsPanel.setFixedBounds(button, 25, 25);

            return button;
        }

        public void setBorder(Border border) {
            super.setBorder(new AbstractBorder() {

                @Override
                public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                    g.setColor(Colors.CONDITION_LIGHT_MEDIUM_BACKGORUND);
                    if (ui.getOrientation() == JSplitPane.VERTICAL_SPLIT) {
                        if (isArrowed) {
//                            int inset = (width/16)+20;
                            width = horizontalRightInset;
                            int inset = 0;
                            int x1 = 23 + inset;
                            int y1 = height / 4;
                            int w1 = width - 28 - inset * 2;
                            int h1 = height / 2;
                            int x2 = 0 + inset;
                            int y2 = height / 4;
                            int w2 = width - 7 - inset * 2;
                            int h2 = height / 2;
                            g.fillRoundRect(x1, y1, w1, h1, 10, 10);
                            g.drawRoundRect(x2, y2, w2, h2, 10, 10);
                        } else {
//                            g.fillRoundRect(0, height / 4, width, height / 2, 10, 10);
//                            g.drawRoundRect(0, height / 4, width, height / 2, 10, 10);
                        }
                    } else if (isArrowed) {
//                           int inset = (height/16)+20;
                        int inset = 0;
                        int x1 = width / 4;
                        int y1 = 23 + inset;
                        int w1 = width / 2;
                        int h1 = height - 32 - (2 * inset);
                        int x2 = width / 4;
                        int y2 = 0 + inset;
                        int w2 = width / 2;
                        int h2 = height - 11 - inset * 2;
                        g.fillRoundRect(x1, y1, w1, h1, 10, 10);
                        g.drawRoundRect(x2, y2, w2, h2, 10, 10);
                    } else {
//                        g.fillRoundRect(width / 4, 0, width / 2, height-2, 10, 10);
//                        g.drawRoundRect(width / 4, 0, width / 2, height-2, 10, 10);
                    }
                }
            });
        }
    }
}
