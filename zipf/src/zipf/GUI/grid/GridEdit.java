package zipf.GUI.grid;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicTextUI.BasicCaret;
import zipf.GUI.KeyInput;
import zipf.event.Note;
import zipf.event.NoteSeq;
import zipf.event.TransportThread;
import zipf.event.Seq;
import zipf.event.Song;
import zipf.lookAndFeel.Borders;
import zipf.lookAndFeel.Colors;
import zipf.lookAndFeel.CustomScrollBarUI;
import zipf.lookAndFeel.Designer;

public class GridEdit extends GridEditTools {

    public ToolsBar gridTable;
    public JPanel Xpanel = new JPanel();

    public GridEdit() {
        super();
        if (this instanceof GridEditNotes) {
            gridTable = new zipf.GUI.grid.GridNote(this);
        } else {
            gridTable = new zipf.GUI.grid.GridSeq(this);
        }
        initComponents();
        gridTableContainer.add(gridTable);
        zoomSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                updateCw(zoomSlider.getValue());
            }
        });
        zoomSliderX.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                gridTable.updateCh(zoomSliderX.getValue());
            }
        });
        updateCw(cw);
        queue().transportThread = new TransportThread(queue());
        JPanel Xprepare = new JPanel();
        JPanel Ypanel = new JPanel();
        Xprepare.setLayout(new BorderLayout());
        Ypanel.setLayout(new BorderLayout());
        JScrollBar Xbar = gridTable.scrollLoop.getHorizontalScrollBar();
//        Xbar.setOrientation(JScrollBar.HORIZONTAL);
        JScrollBar Ybar = new JScrollBar();
//        gridTable.scrollLoop.setHorizontalScrollBar(Xbar);
        gridTable.scrollLoop.setVerticalScrollBar(Ybar);
//        gridTable.gridContainer.add(Xpanel, BorderLayout.SOUTH);
        gridTable.gridContainer.add(Ypanel, BorderLayout.EAST);
        Xprepare.add(Xbar, BorderLayout.CENTER);
        Xprepare.add(zoomSlider, BorderLayout.EAST);
        Ypanel.add(Ybar, BorderLayout.CENTER);
        Ypanel.add(zoomSliderX, BorderLayout.SOUTH);
        new KeyInput().setActions((JPanel) this, (ToolsVis) gridTable);
        Xpanel.setLayout(new BorderLayout());
        Xpanel.add(Xprepare,BorderLayout.CENTER);
        Xpanel.add(reset, BorderLayout.EAST);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        zoomSlider = new javax.swing.JSlider();
        zoomSliderX = new javax.swing.JSlider();
        reset = new javax.swing.JButton();
        transportControls = new zipf.GUI.grid.TransportControls((ToolsBar)gridTable);
        loopGrid = new zipf.GUI.grid.GridLoop(this);
        editSplit = new javax.swing.JSplitPane();
        gridTableContainer = new javax.swing.JPanel();
        tabbedParamAndConditions = new javax.swing.JTabbedPane();
        containerParam = new zipf.GUI.grid.ContainerParam((ToolsBar)gridTable);
        editConditions = new zipf.GUI.EditConditions();

        zoomSlider.setForeground(new java.awt.Color(0, 0, 255));
        zoomSlider.setMajorTickSpacing(1);
        zoomSlider.setMaximum(35);
        zoomSlider.setMinimum(5);
        zoomSlider.setMinorTickSpacing(2);
        zoomSlider.setSnapToTicks(true);
        zoomSlider.setToolTipText("zoom");
        zoomSlider.setAlignmentX(1.0F);
        zoomSlider.setFocusable(false);
        zoomSlider.setMaximumSize(new java.awt.Dimension(125, 20));
        zoomSlider.setMinimumSize(new java.awt.Dimension(125, 20));
        zoomSlider.setOpaque(false);
        zoomSlider.setPreferredSize(new java.awt.Dimension(125, 20));

        zoomSliderX.setMajorTickSpacing(2);
        zoomSliderX.setMinimum(10);
        zoomSliderX.setMinorTickSpacing(2);
        zoomSliderX.setOrientation(javax.swing.JSlider.VERTICAL);
        zoomSliderX.setSnapToTicks(true);
        zoomSliderX.setToolTipText("zoom");
        zoomSliderX.setFocusable(false);
        zoomSliderX.setInverted(true);
        zoomSliderX.setMaximumSize(new java.awt.Dimension(20, 125));
        zoomSliderX.setMinimumSize(new java.awt.Dimension(20, 125));
        zoomSliderX.setOpaque(false);
        zoomSliderX.setPreferredSize(new java.awt.Dimension(20, 125));

        ToolsPanel.setFixedBounds(reset, 25,25);
        reset.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reset.setMargin(new java.awt.Insets(0, 0, 0, 0));

        setBackground(Colors.CONDITION_BACKGROUND);
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1100, 660));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        transportControls.setBorder(Borders.TREE_BORDER);
        transportControls.setFocusable(false);
        transportControls.setMaximumSize(new java.awt.Dimension(1000, 50));
        transportControls.setMinimumSize(new java.awt.Dimension(1000, 50));
        transportControls.setOpaque(false);
        transportControls.setPreferredSize(new java.awt.Dimension(1000, 50));
        add(transportControls);

        loopGrid.setAlignmentX(0.0F);
        loopGrid.setFocusCycleRoot(true);
        add(loopGrid);

        editSplit.setDividerLocation(450);
        editSplit.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        editSplit.setResizeWeight(1.0);

        gridTableContainer.setAlignmentX(0.0F);
        gridTableContainer.setFocusable(false);
        gridTableContainer.setMaximumSize(new java.awt.Dimension(321312, 321312));
        gridTableContainer.setMinimumSize(new java.awt.Dimension(1, 0));
        gridTableContainer.setOpaque(false);
        gridTableContainer.setLayout(new javax.swing.BoxLayout(gridTableContainer, javax.swing.BoxLayout.Y_AXIS));
        editSplit.setTopComponent(gridTableContainer);

        tabbedParamAndConditions.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tabbedParamAndConditions.setMinimumSize(new java.awt.Dimension(1, 0));

        containerParam.setFocusable(false);
        containerParam.setLayout(new javax.swing.BoxLayout(containerParam, javax.swing.BoxLayout.LINE_AXIS));
        tabbedParamAndConditions.addTab("                             parameter                                      ", containerParam);

        editConditions.setFocusable(false);
        tabbedParamAndConditions.addTab("tab2", editConditions);

        editSplit.setRightComponent(tabbedParamAndConditions);

        add(editSplit);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public zipf.GUI.grid.ContainerParam containerParam;
    public zipf.GUI.EditConditions editConditions;
    public javax.swing.JSplitPane editSplit;
    public javax.swing.JPanel gridTableContainer;
    public zipf.GUI.grid.GridLoop loopGrid;
    private javax.swing.JButton reset;
    public javax.swing.JTabbedPane tabbedParamAndConditions;
    public zipf.GUI.grid.TransportControls transportControls;
    public javax.swing.JSlider zoomSlider;
    public javax.swing.JSlider zoomSliderX;
    // End of variables declaration//GEN-END:variables

}
