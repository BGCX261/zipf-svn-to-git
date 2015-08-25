
package zipf.GUI.grid;

import zipf.GUI.CurrentItems;
import zipf.GUI.PanelCondition;
import zipf.GUI.table.NumberInput;


public class SidePanelNote extends SidePanel {

    GridNote tools;

    public SidePanelNote(GridNote vtools) {
        this.tools=vtools;
        initComponents();
    }

    SidePanelNote() {
         initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gridLengthGroup = new javax.swing.ButtonGroup();
        clearButton = new javax.swing.JButton();
        addRule = new javax.swing.JButton();
        setGridLength4 = new javax.swing.JToggleButton();
        setGridLength3 = new javax.swing.JToggleButton();
        setGridLength2 = new javax.swing.JToggleButton();
        setGridLength1 = new javax.swing.JToggleButton();
        addParam = new javax.swing.JButton();

        clearButton.setText("clear");
        clearButton.setContentAreaFilled(false);
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButtonMouseClicked(evt);
            }
        });

        addRule.setText("add Rule");
        addRule.setContentAreaFilled(false);
        addRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRuleActionPerformed(evt);
            }
        });

        gridLengthGroup.add(setGridLength4);
        setGridLength4.setText("64");
        setGridLength4.setBorder(null);
        setGridLength4.setPreferredSize(new java.awt.Dimension(25, 25));
        setGridLength4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setGridLength4ActionPerformed(evt);
            }
        });

        gridLengthGroup.add(setGridLength3);
        setGridLength3.setText("32");
        setGridLength3.setBorder(null);
        setGridLength3.setPreferredSize(new java.awt.Dimension(25, 25));
        setGridLength3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setGridLength3ActionPerformed(evt);
            }
        });

        gridLengthGroup.add(setGridLength2);
        setGridLength2.setText("16");
        setGridLength2.setBorder(null);
        setGridLength2.setPreferredSize(new java.awt.Dimension(25, 25));
        setGridLength2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setGridLength2ActionPerformed(evt);
            }
        });

        gridLengthGroup.add(setGridLength1);
        setGridLength1.setText("8");
        setGridLength1.setBorder(null);
        setGridLength1.setPreferredSize(new java.awt.Dimension(25, 25));
        setGridLength1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setGridLength1ActionPerformed(evt);
            }
        });

        addParam.setText("add param");
        addParam.setContentAreaFilled(false);
        addParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addParamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clearButton)
                            .addComponent(setGridLength1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setGridLength2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setGridLength3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setGridLength4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addParam)))
                    .addComponent(addRule, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setGridLength1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(setGridLength2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(setGridLength3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(setGridLength4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addParam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addRule)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseClicked
        tools.newQueue();
}//GEN-LAST:event_clearButtonMouseClicked

    private void addRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRuleActionPerformed
        tools.addRule(tools.queue());
}//GEN-LAST:event_addRuleActionPerformed

    private void setGridLength4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setGridLength4ActionPerformed
        int i = Integer.parseInt(setGridLength4.getText());
        tools.setSeqLength(i);
}//GEN-LAST:event_setGridLength4ActionPerformed

    private void setGridLength3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setGridLength3ActionPerformed
        int i = Integer.parseInt(setGridLength1.getText());
        tools.setSeqLength(i);
}//GEN-LAST:event_setGridLength3ActionPerformed

    private void setGridLength2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setGridLength2ActionPerformed
        int i = Integer.parseInt(setGridLength2.getText());
        tools.setSeqLength(i);
}//GEN-LAST:event_setGridLength2ActionPerformed

    private void setGridLength1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setGridLength1ActionPerformed
        int i = Integer.parseInt(setGridLength1.getText());
        tools.setSeqLength(i);
}//GEN-LAST:event_setGridLength1ActionPerformed

    private void addParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addParamActionPerformed
        tools.addCC();        // TODO add your handling code here:
}//GEN-LAST:event_addParamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addParam;
    private javax.swing.JButton addRule;
    private javax.swing.JButton clearButton;
    private javax.swing.ButtonGroup gridLengthGroup;
    private javax.swing.JToggleButton setGridLength1;
    private javax.swing.JToggleButton setGridLength2;
    private javax.swing.JToggleButton setGridLength3;
    private javax.swing.JToggleButton setGridLength4;
    // End of variables declaration//GEN-END:variables

}
