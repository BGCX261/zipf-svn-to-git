package zipf.GUI.vis;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import zipf.GUI.grid.Grid;
import zipf.GUI.grid.GridParam;
import zipf.GUI.grid.ToolsPanel;
import zipf.event.Param;
import zipf.lookAndFeel.Borders;

public class VisVolume extends JPanel {


    public VisVolume() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(Borders.VOLUME_VIS);
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(0, 0));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }

}
