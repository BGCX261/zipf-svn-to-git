package zipf.GUI.tree;

import java.awt.event.KeyEvent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTreeUI;
import zipf.GUI.condition.TreeSides;
import zipf.lookAndFeel.Designer;

public class ToggleTree extends ToolsToggle {

    public ToggleTree(TreeSides treeSides, int index) {
        initComponents();
        super.tree = this.tree;
        super.treeButton = this.treeButton;
        super.inputBox = this.inputBox;
        super.conPanels = this.conPanels;
        this.treeSides = treeSides;
        this.index = index;
        Designer.design(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        treeButton = new javax.swing.JToggleButton();
        treeScrollPane = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        addRuleItem = new javax.swing.JButton();
        deleteRuleItem = new javax.swing.JButton();
        inputBox = new javax.swing.JTextField();
        panelsScrollPane = new javax.swing.JScrollPane();
        viewPortPanel = new javax.swing.JPanel();
        conPanels = new zipf.GUI.condition.ConTainer();

        setMinimumSize(new java.awt.Dimension(450, 66));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(450, 66));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        //elementsButton.setSelected(true);
        treeButton.setFont(new java.awt.Font("Dialog", 1, 18));
        treeButton.setText("title");
        treeButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        treeButton.setContentAreaFilled(false);
        treeButton.setMaximumSize(new java.awt.Dimension(75, 40));
        treeButton.setMinimumSize(new java.awt.Dimension(40, 29));
        treeButton.setPreferredSize(new java.awt.Dimension(40, 40));
        treeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                treeButtonMousePressed(evt);
            }
        });
        treeButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                treeButtonStateChanged(evt);
            }
        });
        treeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treeButtonActionPerformed(evt);
            }
        });
        treeButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                treeButtonFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                treeButtonFocusLost(evt);
            }
        });
        add(treeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 120, 30));

        treeScrollPane.setBorder(null);
        treeScrollPane.setFocusable(false);
        treeScrollPane.setPreferredSize(new java.awt.Dimension(59, 250));

        ComponentUI treeUIui = tree.getUI();
        ((BasicTreeUI) treeUIui).setExpandedIcon(null);
        ((BasicTreeUI) treeUIui).setCollapsedIcon(null);
        tree.setShowsRootHandles(false);
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("JTree");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("colors");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("blue");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("violet");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("red");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("ye");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("sports");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("basketball");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("soccer");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("football");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("hockey");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("food");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("hot dogs");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("pizza");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("ravioli");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("bananas");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        tree.setAutoscrolls(true);
        tree.setFocusable(false);
        tree.setMaximumSize(new java.awt.Dimension(450, 40));
        tree.setMinimumSize(new java.awt.Dimension(150, 150));
        tree.setRootVisible(false);
        tree.setToggleClickCount(1);
        tree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeMouseClicked(evt);
            }
        });
        tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeValueChanged(evt);
            }
        });
        treeScrollPane.setViewportView(tree);

        add(treeScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 160, -1));

        addRuleItem.setText("+");
        addRuleItem.setAlignmentX(0.5F);
        addRuleItem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 1, true));
        addRuleItem.setContentAreaFilled(false);
        addRuleItem.setMaximumSize(new java.awt.Dimension(15, 30));
        addRuleItem.setMinimumSize(new java.awt.Dimension(15, 30));
        addRuleItem.setPreferredSize(new java.awt.Dimension(15, 30));
        addRuleItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRuleItemActionPerformed(evt);
            }
        });
        add(addRuleItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 20, -1));

        deleteRuleItem.setText("X");
        deleteRuleItem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        deleteRuleItem.setContentAreaFilled(false);
        deleteRuleItem.setMargin(null);
        deleteRuleItem.setMaximumSize(new java.awt.Dimension(15, 30));
        deleteRuleItem.setMinimumSize(new java.awt.Dimension(15, 30));
        deleteRuleItem.setPreferredSize(new java.awt.Dimension(15, 30));
        deleteRuleItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRuleItemActionPerformed(evt);
            }
        });
        add(deleteRuleItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 20, -1));

        inputBox.setBackground(new java.awt.Color(204, 204, 255));
        inputBox.setFont(new java.awt.Font("Tahoma", 1, 18));
        inputBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        inputBox.setEnabled(false);
        inputBox.setMinimumSize(new java.awt.Dimension(40, 30));
        inputBox.setOpaque(false);
        inputBox.setPreferredSize(new java.awt.Dimension(150, 40));
        inputBox.setSelectedTextColor(new java.awt.Color(204, 204, 255));
        inputBox.setSelectionColor(new java.awt.Color(0, 0, 153));
        inputBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputBoxFocusLost(evt);
            }
        });
        inputBox.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                inputBoxInputMethodTextChanged(evt);
            }
        });
        inputBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputBoxKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputBoxKeyTyped(evt);
            }
        });
        add(inputBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 270, 30));

        panelsScrollPane.setBackground(new java.awt.Color(204, 255, 204));
        panelsScrollPane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));

        viewPortPanel.setBackground(new java.awt.Color(204, 255, 204));
        viewPortPanel.setPreferredSize(new java.awt.Dimension(250, 250));

        conPanels.setPreferredSize(new java.awt.Dimension(250, 250));
        conPanels.setLayout(new javax.swing.BoxLayout(conPanels, javax.swing.BoxLayout.Y_AXIS));
        viewPortPanel.add(conPanels);

        panelsScrollPane.setViewportView(viewPortPanel);

        add(panelsScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 270, 250));
    }// </editor-fold>//GEN-END:initComponents

    private void treeButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_treeButtonStateChanged
    }//GEN-LAST:event_treeButtonStateChanged

    private void treeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treeButtonActionPerformed
        if (thisSide.openTree == this) {
            closeTree();
        } else {
            openTree();
        }
}//GEN-LAST:event_treeButtonActionPerformed

    private void treeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeButtonMouseClicked
    }//GEN-LAST:event_treeButtonMouseClicked

    private void treeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeButtonMousePressed
//        System.out.println(this.getHeight());
    }//GEN-LAST:event_treeButtonMousePressed

    private void treeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeValueChanged
        treeValueChanged();
}//GEN-LAST:event_treeValueChanged

    private void treeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeMouseClicked
        treeMouseClicked(evt, this);
}//GEN-LAST:event_treeMouseClicked

    private void inputBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputBoxFocusLost
}//GEN-LAST:event_inputBoxFocusLost

    private void inputBoxInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_inputBoxInputMethodTextChanged
}//GEN-LAST:event_inputBoxInputMethodTextChanged

    private void treeButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_treeButtonFocusGained
    }//GEN-LAST:event_treeButtonFocusGained

    private void treeButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_treeButtonFocusLost
//        elementsButton.setSelected(false);
    }//GEN-LAST:event_treeButtonFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
    }//GEN-LAST:event_formFocusGained

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
    }//GEN-LAST:event_formFocusLost

    private void addRuleItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRuleItemActionPerformed
        addTree();
    }//GEN-LAST:event_addRuleItemActionPerformed

    private void inputBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputBoxKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_inputBoxKeyTyped

    private void inputBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputBoxKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            saveRuleItem();
        }
    }//GEN-LAST:event_inputBoxKeyPressed

    private void deleteRuleItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRuleItemActionPerformed
        removeToggleTree();
        // TODO add your handling code here:
}//GEN-LAST:event_deleteRuleItemActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRuleItem;
    public zipf.GUI.condition.ConTainer conPanels;
    private javax.swing.JButton deleteRuleItem;
    public javax.swing.JTextField inputBox;
    private javax.swing.JScrollPane panelsScrollPane;
    public javax.swing.JTree tree;
    public javax.swing.JToggleButton treeButton;
    public javax.swing.JScrollPane treeScrollPane;
    private javax.swing.JPanel viewPortPanel;
    // End of variables declaration//GEN-END:variables

}
