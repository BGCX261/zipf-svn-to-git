package zipf.GUI;

import java.awt.FlowLayout;
import zipf.GUI.condition.TreeSides;
import zipf.GUI.tree.ToolsEditConditions;
import zipf.GUI.tree.ToolsToggle;
import zipf.lookAndFeel.Designer;

public class PanelCondition extends ToolsEditConditions {

    static int editConditionWidth=930;
    static int editConditionHeight=530;

    public PanelCondition() {
        initComponents();
        Designer.design(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        screenScrollPane = new javax.swing.JScrollPane();
        screenPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        addCondition = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("title");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 30));
        jLabel1.setMinimumSize(new java.awt.Dimension(500, 30));
        jLabel1.setPreferredSize(new java.awt.Dimension(500, 30));
        add(jLabel1);

        screenScrollPane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        screenScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        screenScrollPane.setMaximumSize(new java.awt.Dimension(321321, 321321));
        screenScrollPane.setMinimumSize(new java.awt.Dimension(0, 0));
        screenScrollPane.setPreferredSize(new java.awt.Dimension(960, 530));
        screenScrollPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                screenScrollPanePropertyChange(evt);
            }
        });

        screenPanel.setPreferredSize(new java.awt.Dimension(930, 530));
        screenPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));
        screenScrollPane.setViewportView(screenPanel);

        add(screenScrollPane);

        addCondition.setFont(new java.awt.Font("Tahoma", 0, 14));
        addCondition.setText("add Condition");
        addCondition.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        addCondition.setContentAreaFilled(false);
        addCondition.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addCondition.setMaximumSize(new java.awt.Dimension(200, 30));
        addCondition.setPreferredSize(new java.awt.Dimension(140, 30));
        addCondition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addConditionActionPerformed(evt);
            }
        });
        jPanel1.add(addCondition);

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 14));
        saveButton.setText("save Rule...");
        saveButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        saveButton.setContentAreaFilled(false);
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton.setMaximumSize(new java.awt.Dimension(200, 30));
        saveButton.setPreferredSize(new java.awt.Dimension(140, 30));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void screenScrollPanePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_screenScrollPanePropertyChange
    }//GEN-LAST:event_screenScrollPanePropertyChange

    private void addConditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addConditionActionPerformed
        new TreeSides(this);
    }//GEN-LAST:event_addConditionActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
    saveTrees();
    }//GEN-LAST:event_saveButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCondition;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton saveButton;
    public javax.swing.JPanel screenPanel;
    public javax.swing.JScrollPane screenScrollPane;
    // End of variables declaration//GEN-END:variables

}
