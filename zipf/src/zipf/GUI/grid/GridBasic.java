package zipf.GUI.grid;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.event.TableModelListener;
import zipf.GUI.table.CustomTable;
import zipf.event.NoteSeq;
import zipf.event.Seq;
import zipf.lookAndFeel.Borders;
import zipf.lookAndFeel.Colors;
import zipf.lookAndFeel.CustomButtonUI;

public abstract class GridBasic extends Grid {

    public GridBasic() {
        initComponents();
        super.table = table;
        super.editPane = editPane;
    }

    public GridBasic(final GridEdit edit, int ch) {
        super(edit, ch);
        initComponents();
        super.table = table;
        super.editPane = editPane;
        setMRQ();
        initTable();
        edit.grids.add(this);
        setAlignmentX(0.0F);
        scrollLoop.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                edit.scrollGrids(e.getValue());

            }
        });
        gridSplit.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                for (GridBasic grid : edit.grids) {
                    grid.gridSplit.setDividerLocation((Integer)evt.getNewValue());
                }
            }
        });
        gridSplit.setPreferredSize(new Dimension(955, ch));
        updateCh();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gridSplit = new javax.swing.JSplitPane();
        controls = new javax.swing.JPanel();
        gridContainer = new javax.swing.JPanel();
        scrollLoop = new javax.swing.JScrollPane();
        editPane = new javax.swing.JLayeredPane();
        table = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        gridSplit.setBorder(null);
        gridSplit.setDividerLocation(120);
        gridSplit.setAlignmentY(0.5F);
        gridSplit.setAutoscrolls(true);

        controls.setLayout(new java.awt.BorderLayout());
        gridSplit.setLeftComponent(controls);

        gridContainer.setBackground(new java.awt.Color(51, 51, 255));
        gridContainer.setLayout(new java.awt.BorderLayout());

        scrollLoop.setBackground(Colors.CONDITION_LIGHT_BACKGORUND);
        scrollLoop.setBorder(new CustomButtonUI(10, 5, Color.white, Colors.CONDITION_BACKGROUND));
        scrollLoop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                scrollLoopMouseEntered(evt);
            }
        });

        editPane.setAlignmentX(0.0F);
        editPane.setAlignmentY(0.0F);
        editPane.setOpaque(true);
        editPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editPaneMouseEntered(evt);
            }
        });

        table.setForeground(new java.awt.Color(153, 153, 153));
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setGridColor(new java.awt.Color(204, 204, 204));
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table.setTableHeader(null);
        table.setUpdateSelectionOnSort(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        table.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tableMouseDragged(evt);
            }
        });
        table.setBounds(0, 0, -1, -1);
        editPane.add(table, javax.swing.JLayeredPane.DEFAULT_LAYER);

        scrollLoop.setViewportView(editPane);

        gridContainer.add(scrollLoop, java.awt.BorderLayout.CENTER);

        gridSplit.setRightComponent(gridContainer);

        add(gridSplit, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseDragged
        gridDragged();
}//GEN-LAST:event_tableMouseDragged

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        gridClicked();
}//GEN-LAST:event_tableMouseClicked

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        gridPressed(evt);
    }//GEN-LAST:event_tableMousePressed

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
        gridReleased();
    }//GEN-LAST:event_tableMouseReleased

    private void editPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPaneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_editPaneMouseEntered

    private void scrollLoopMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrollLoopMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_scrollLoopMouseEntered
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel controls;
    public javax.swing.JLayeredPane editPane;
    public javax.swing.JPanel gridContainer;
    public javax.swing.JSplitPane gridSplit;
    public javax.swing.JScrollPane scrollLoop;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    public void addControl(SidePanel panel) {
        controls.add(panel);
    }

    public void gridPressed(MouseEvent evt) {
    }

    public void gridClicked() {
    }

    public abstract void gridDragged();

    public abstract void gridReleased();
}
