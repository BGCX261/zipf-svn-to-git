package zipf.GUI.vis;

import javax.swing.JPanel;
import zipf.GUI.grid.GridParam;
import zipf.GUI.grid.ToolsPanel;
import zipf.event.Param;

public class VisParamValue extends JPanel {

    public VisParamValue() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        value = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);
        add(jPanel1);

        value.setBackground(new java.awt.Color(0, 102, 102));
        value.setForeground(new java.awt.Color(255, 255, 255));
        value.setAlignmentY(0.0F);
        value.setLayout(null);
        add(value);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel value;
    // End of variables declaration//GEN-END:variables

    public void setValue(int i) {
        ToolsPanel.setFixedBounds(value, 40, VisHelper.getEventY(i));
    }
}
