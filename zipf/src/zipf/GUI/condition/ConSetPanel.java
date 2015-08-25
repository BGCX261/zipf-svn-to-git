package zipf.GUI.condition;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import javax.swing.JPanel;
import javax.swing.tree.TreePath;
import zipf.GUI.grid.ToolsPanel;
import zipf.GUI.tree.ToolsToggle;
import zipf.event.conditions.Operable;
import zipf.event.conditions.RuleItemSet;

public class ConSetPanel extends ConAbstract {

    int labelSize = 160;
    public boolean collapsed;

    public ConSetPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 102));
        setAlignmentX(1.0F);
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(250, 30));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setMaximumSize(new java.awt.Dimension(5, 30));
        jPanel2.setMinimumSize(new java.awt.Dimension(5, 30));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(5, 30));
        add(jPanel2);

        jButton2.setBackground(new java.awt.Color(0, 204, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton2.setText("-");
        jButton2.setAlignmentY(0.2F);
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 0), 1, true));
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setMargin(null);
        jButton2.setMaximumSize(new java.awt.Dimension(15, 15));
        jButton2.setMinimumSize(new java.awt.Dimension(15, 15));
        jButton2.setPreferredSize(new java.awt.Dimension(15, 15));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });
        add(jButton2);

        label.setBackground(new java.awt.Color(0, 204, 102));
        label.setFont(new java.awt.Font("Tahoma", 0, 12));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("v a l u e");
        label.setAlignmentY(0.2F);
        label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 0), 1, true));
        label.setMaximumSize(new java.awt.Dimension(165, 15));
        label.setMinimumSize(new java.awt.Dimension(40, 15));
        label.setOpaque(true);
        label.setPreferredSize(new java.awt.Dimension(160, 30));
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelMousePressed(evt);
            }
        });
        label.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                labelMouseDragged(evt);
            }
        });
        add(label);

        jLayeredPane2.setMaximumSize(new java.awt.Dimension(40, 30));
        jLayeredPane2.setMinimumSize(new java.awt.Dimension(40, 30));
        jLayeredPane2.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(207, 255, 207));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setForeground(new java.awt.Color(102, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("&");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setMaximumSize(new java.awt.Dimension(40, 30));
        jLabel1.setMinimumSize(new java.awt.Dimension(40, 30));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(40, 30));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jLabel1.setBounds(0, 0, 40, 30);
        jLayeredPane2.add(jLabel1, javax.swing.JLayeredPane.PALETTE_LAYER);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AND", "OR", "XOR" }));
        jComboBox1.setBorder(null);
        jComboBox1.setLightWeightPopupEnabled(false);
        jComboBox1.setMaximumSize(new java.awt.Dimension(40, 30));
        jComboBox1.setMinimumSize(new java.awt.Dimension(40, 30));
        jComboBox1.setPreferredSize(new java.awt.Dimension(40, 30));
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });
        jComboBox1.setBounds(0, 0, -1, -1);
        jLayeredPane2.add(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        add(jLayeredPane2);

        jPanel1.setMaximumSize(new java.awt.Dimension(15, 30));
        jPanel1.setMinimumSize(new java.awt.Dimension(15, 30));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(15, 30));
        add(jPanel1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10));
        jButton1.setText("X");
        jButton1.setAlignmentY(1.0F);
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 0), 1, true));
        jButton1.setContentAreaFilled(false);
        jButton1.setMaximumSize(new java.awt.Dimension(15, 15));
        jButton1.setMinimumSize(new java.awt.Dimension(15, 15));
        jButton1.setPreferredSize(new java.awt.Dimension(15, 15));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
}//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange
}//GEN-LAST:event_jComboBox1PropertyChange

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        if (!jComboBox1.isPopupVisible()) {
            jComboBox1.setPopupVisible(true);
        } else {
            jComboBox1.setPopupVisible(false);
        }
    }//GEN-LAST:event_jLabel1MousePressed

    private void labelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMouseDragged
        ttools.itemDragged(this);
    }//GEN-LAST:event_labelMouseDragged

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        int i = jComboBox1.getSelectedIndex();
        ((Operable) getSet()).setOperator(i);
        jLabel1.setText(operators[i]);
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void labelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMousePressed
    }//GEN-LAST:event_labelMousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        if (!collapsed) {
        collapseSet();
        } else {
        expandConSet();
        }
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           ttools.removeRuleItemPanel((ConAbstract) this.getParent());
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables

    @Override
    public JPanel getSpacer() {
        return null;
    }

    @Override
    public RuleItemSet getSet() {
        return ((ConAbstract) this.getParent()).getSet();
    }

    @Override
    public void setSpacer(int i) {
        System.out.println("spacer in consetPanel " + i);
        label.setPreferredSize(new Dimension(labelSize - (i - 15), 30));

    }

    @Override
    public void setOperatorsVisible(boolean bool) {
        if (bool) {
            this.jLabel1.setForeground(Color.BLACK);
        } else {
            this.jLabel1.setForeground(new Color(207,255,207));

        }
        this.operatorVisible = bool;
    }

    public void collapseSet(){
            collapsed = true;
            jButton2.setText("+");
            setItemHeight(0);
    }

    public void expandConSet(){
            collapsed = false;
            jButton2.setText("-");
            setItemHeight(this.getHeight());
    }

    public void setItemHeight(int height) {
        List<Component> list = Arrays.asList(getParent().getComponents());
        for (Component c : list.subList(1, list.size())) {
            ToolsPanel.setFixedBounds(c, this.getWidth(), height);
        }
        ttools.conPanels.updateUI();
    }


    
}
