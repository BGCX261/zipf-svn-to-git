package zipf.GUI.grid;

import zipf.GUI.grid.GridSeq;

public class SidePanelSeqEdit extends SidePanel {

    GridSeq tools;

    public SidePanelSeqEdit(GridSeq vtools) {
        initComponents();
        this.tools=vtools;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JButton addTrackButton = new javax.swing.JButton();
        javax.swing.JButton clearButton = new javax.swing.JButton();

        setLayout(null);

        addTrackButton.setText("add Track");
        addTrackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTrackButtonActionPerformed(evt);
            }
        });
        add(addTrackButton);
        addTrackButton.setBounds(0, 10, 110, 23);

        clearButton.setText("clear");
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButtonMouseClicked(evt);
            }
        });
        add(clearButton);
        clearButton.setBounds(0, 60, 110, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void addTrackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTrackButtonActionPerformed
        tools.addTrack();
}//GEN-LAST:event_addTrackButtonActionPerformed

    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseClicked
        tools.newQueue();
    }//GEN-LAST:event_clearButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
