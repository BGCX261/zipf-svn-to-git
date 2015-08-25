package zipf.GUI;

import javax.swing.JPanel;
import zipf.GUI.tree.ToolsEditConditions;
import zipf.GUI.tree.ToolsToggle;

public class EditConditions extends JPanel {

    public EditConditions() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCondition = new zipf.GUI.PanelCondition();

        setMaximumSize(new java.awt.Dimension(321321, 321321));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(980, 700));
        setLayout(new java.awt.BorderLayout());

        panelCondition.setAlignmentX(0.02F);
        panelCondition.setMaximumSize(new java.awt.Dimension(321321, 321321));
        panelCondition.setMinimumSize(new java.awt.Dimension(0, 0));
        add(panelCondition, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public zipf.GUI.PanelCondition panelCondition;
    // End of variables declaration//GEN-END:variables

}
