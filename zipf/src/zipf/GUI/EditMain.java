package zipf.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.TabbedPaneUI;
import zipf.GUI.grid.GridEdit;
import zipf.GUI.grid.GridNote;
import zipf.event.NoteSeq;
import zipf.event.Seq;
import zipf.lookAndFeel.Designer;
import zipf.lookAndFeel.Colors;
import zipf.lookAndFeel.CustomTabbedUI;

public class EditMain extends javax.swing.JPanel {

    public EditMain() {
        initComponents();
        Designer.design((JPanel) this);
        Rectangle rec = new Rectangle(0, editNotes.gridTable.editPane.getHeight() / 3, 10, 10);
        editNotes.gridTable.editPane.scrollRectToVisible(rec);
        browser.setTools(editNotes.gridTable);
        GUIsplit.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                editNotes.gridTable.gridSplit.setDividerLocation(editNotes.gridTable.dividerFactor);
            }
        });
        editNotes.updateCw(15);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GUIsplit = new javax.swing.JSplitPane(JSplitPane.HORIZONTAL_SPLIT,browser,tabbed);
        tabbed = new javax.swing.JTabbedPane();
        editNotes = new zipf.GUI.grid.GridEditNotes();
        editSeq = new zipf.GUI.grid.GridEditSeq();
        editConditions = new zipf.GUI.EditConditions();
        jPanel1 = new javax.swing.JPanel();
        browser = new zipf.GUI.Browser();

        setPreferredSize(new java.awt.Dimension(1200, 550));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        GUIsplit.setBorder(null);
        GUIsplit.setDividerLocation(200);
        GUIsplit.setLastDividerLocation(60);
        GUIsplit.setOpaque(false);

        tabbed.setFocusable(false);
        tabbed.setMaximumSize(new java.awt.Dimension(1050, 700));
        tabbed.setMinimumSize(new java.awt.Dimension(700, 700));
        tabbed.setPreferredSize(new java.awt.Dimension(1050, 700));
        tabbed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedStateChanged(evt);
            }
        });

        editNotes.setMinimumSize(new java.awt.Dimension(1100, 660));
        editNotes.setPreferredSize(new java.awt.Dimension(1200, 700));
        tabbed.addTab("                                        note                                 ", editNotes);
        tabbed.addTab("                                      sequence                                ", editSeq);
        tabbed.addTab("                            conditions                           ", editConditions);
        tabbed.addTab("tab4", jPanel1);

        GUIsplit.setRightComponent(tabbed);

        browser.setMaximumSize(new java.awt.Dimension(250, 650));
        browser.setMinimumSize(new java.awt.Dimension(210, 650));
        GUIsplit.setLeftComponent(browser);

        add(GUIsplit);
    }// </editor-fold>//GEN-END:initComponents

    private void tabbedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedStateChanged
        Component edit = tabbed.getSelectedComponent();
        if (edit instanceof GridEdit) {
            CurrentItems.setCurrentEdit((GridEdit) edit);
        }
    }//GEN-LAST:event_tabbedStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JSplitPane GUIsplit;
    public zipf.GUI.Browser browser;
    public zipf.GUI.EditConditions editConditions;
    public zipf.GUI.grid.GridEditNotes editNotes;
    private zipf.GUI.grid.GridEditSeq editSeq;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTabbedPane tabbed;
    // End of variables declaration//GEN-END:variables
}
