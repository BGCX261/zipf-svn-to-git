package zipf.GUI.vis;

import javax.swing.JPanel;
import zipf.GUI.grid.GridParam;
import zipf.GUI.grid.ToolsPanel;
import zipf.event.Param;

public class VisVolumeNotes extends JPanel {

    public VisVolumeNotes() {
        initComponents();
    }

    public VisVolumeNotes(int volume) {
        initComponents();
        setValue(volume);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLayeredPane jLayeredPane1 = new javax.swing.JLayeredPane();
        value = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        value.setBackground(new java.awt.Color(0, 102, 102));
        value.setForeground(new java.awt.Color(255, 255, 255));
        value.setLayout(null);
        value.setBounds(0, 0, 80, 100);
        jLayeredPane1.add(value, javax.swing.JLayeredPane.DEFAULT_LAYER);

        add(jLayeredPane1);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel value;
    // End of variables declaration//GEN-END:variables

    public void setValue(int i) {
        ToolsPanel.setFixedBounds(value, 20, VisHelper.getEventY(i));
    }
}
