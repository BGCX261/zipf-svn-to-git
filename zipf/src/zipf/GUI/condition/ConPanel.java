package zipf.GUI.condition;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.tree.TreePath;
import zipf.lookAndFeel.Colors;
import zipf.event.conditions.Operable;
import zipf.event.conditions.Invokable;
import zipf.event.conditions.RuleItemSet;

public class ConPanel extends ConAbstract {

    public TreePath treePath;
    int labelSize = 150;

    public ConPanel() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        inputBoxSmall = new javax.swing.JTextField();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setAlignmentX(1.0F);
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(250, 30));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setText("X");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 0), 1, true));
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setMaximumSize(new java.awt.Dimension(15, 15));
        jButton1.setMinimumSize(new java.awt.Dimension(15, 15));
        jButton1.setPreferredSize(new java.awt.Dimension(15, 15));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton2.setText("+");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setMaximumSize(new java.awt.Dimension(15, 15));
        jButton2.setMinimumSize(new java.awt.Dimension(15, 15));
        jButton2.setPreferredSize(new java.awt.Dimension(15, 15));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);

        label.setBackground(new java.awt.Color(210, 255, 210));
        label.setFont(new java.awt.Font("Tahoma", 0, 12));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("v a l u e");
        label.setMaximumSize(new java.awt.Dimension(150, 15));
        label.setMinimumSize(new java.awt.Dimension(40, 15));
        label.setOpaque(true);
        label.setPreferredSize(new java.awt.Dimension(150, 15));
        label.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                labelFocusGained(evt);
            }
        });
        add(label);

        inputBoxSmall.setBackground(Colors.CONDITION_BACKGROUND);
        inputBoxSmall.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inputBoxSmall.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputBoxSmall.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 1, true));
        inputBoxSmall.setMargin(null);
        inputBoxSmall.setMaximumSize(new java.awt.Dimension(40, 20));
        inputBoxSmall.setMinimumSize(new java.awt.Dimension(40, 20));
        inputBoxSmall.setPreferredSize(new java.awt.Dimension(40, 20));
        inputBoxSmall.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputBoxSmallFocusLost(evt);
            }
        });
        inputBoxSmall.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                inputBoxSmallInputMethodTextChanged(evt);
            }
        });
        inputBoxSmall.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputBoxSmallKeyPressed(evt);
            }
        });
        add(inputBoxSmall);

        jLayeredPane2.setBackground(new java.awt.Color(207, 255, 207));
        jLayeredPane2.setAlignmentX(1.0F);
        jLayeredPane2.setMaximumSize(new java.awt.Dimension(30, 30));
        jLayeredPane2.setMinimumSize(new java.awt.Dimension(30, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AND", "OR", "XOR" }));
        jComboBox1.setBorder(null);
        jComboBox1.setMaximumSize(new java.awt.Dimension(30, 30));
        jComboBox1.setMinimumSize(new java.awt.Dimension(30, 30));
        jComboBox1.setPreferredSize(new java.awt.Dimension(30, 30));
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
        jComboBox1.setBounds(0, 0, 30, 30);
        jLayeredPane2.add(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setForeground(new java.awt.Color(102, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("&");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setAlignmentX(1.0F);
        jLabel1.setMaximumSize(new java.awt.Dimension(30, 28));
        jLabel1.setMinimumSize(new java.awt.Dimension(30, 28));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(30, 28));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jLabel1.setBounds(0, 0, 30, 30);
        jLayeredPane2.add(jLabel1, javax.swing.JLayeredPane.MODAL_LAYER);

        add(jLayeredPane2);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
}//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange
}//GEN-LAST:event_jComboBox1PropertyChange

    private void inputBoxSmallFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputBoxSmallFocusLost
}//GEN-LAST:event_inputBoxSmallFocusLost

    private void inputBoxSmallInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_inputBoxSmallInputMethodTextChanged
}//GEN-LAST:event_inputBoxSmallInputMethodTextChanged

    private void inputBoxSmallKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputBoxSmallKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ((Invokable)chainable).setValue(Integer.parseInt(inputBoxSmall.getText()));
        }
    }//GEN-LAST:event_inputBoxSmallKeyPressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        if (!jComboBox1.isPopupVisible()) {
            jComboBox1.setPopupVisible(true);
        } else {
            jComboBox1.setPopupVisible(false);
        }
    }//GEN-LAST:event_jLabel1MousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ttools.createConSetPanel(this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        ttools.itemDragged(this);     
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
    }//GEN-LAST:event_formMousePressed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
    }//GEN-LAST:event_formFocusGained

    private void labelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_labelFocusGained
    }//GEN-LAST:event_labelFocusGained

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    ttools.removeRuleItemPanel(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        int i = jComboBox1.getSelectedIndex();
        ((Operable) chainable).setOperator(i);
        jLabel1.setText(operators[i]);
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField inputBoxSmall;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane2;
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
//        spacer.setPreferredSize(new Dimension(i, 30));
        label.setPreferredSize(new Dimension(labelSize - (i), 30));
                this.setPreferredSize(new Dimension(labelSize - (i), 30));
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
}
