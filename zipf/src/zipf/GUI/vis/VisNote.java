package zipf.GUI.vis;

import java.awt.Component;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import zipf.GUI.KeyInput;
import zipf.GUI.grid.GridNote;
import zipf.GUI.grid.ToolsMoveVis;
import zipf.GUI.grid.ToolsVis;
import zipf.event.Note;
import zipf.event.Pool;

public class VisNote extends VisBar {

    public int borderWidth = 8;
    public VisVolume volumeVis = new VisVolume();

    public VisNote(GridNote tools, Note note) {
        super(tools, note);
        initComponents();
        setVolume(((Note) connectedEvent).getVolume());
        volumeVis.setOpaque(false);
        tools.addToUI(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 102, 102));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setFocusTraversalPolicyProvider(true);
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void updateBounds() {
        super.updateBounds();
        updateVolumeVis();
    }

    public void setVolume(int i) {
        int y = VisHelper.getEventY(i);
        volumeVis.setBounds(this.getX(), 59 - y, 10, 10);
    }

    public void mark() {
        setBackground(Vis.FOCUSED);
        volumeVis.setBorder(new javax.swing.border.LineBorder(Vis.FOCUSED, borderWidth, false));
        ((JLayeredPane) volumeVis.getParent()).setLayer(volumeVis, JLayeredPane.MODAL_LAYER);
    }

    public void unMark() {
        setBackground(Vis.INIT);
        volumeVis.setBorder(new javax.swing.border.LineBorder(Vis.INIT, borderWidth, false));
        ((JLayeredPane) volumeVis.getParent()).setLayer(volumeVis, JLayeredPane.PALETTE_LAYER);
    }

    private void updateVolumeVis() {
        volumeVis.setBounds(this.getX(), volumeVis.getY(), 10, 10);
        volumeVis.setBorder(new javax.swing.border.LineBorder(((LineBorder) volumeVis.getBorder()).getLineColor(), borderWidth, false));
        updateVolumeModel();
    }

    @Override
    public void remove() {
        super.remove();
        JLayeredPane parentThis = (JLayeredPane) this.getParent();
        JLayeredPane parentVolume = (JLayeredPane) volumeVis.getParent();
        if (parentVolume != null) {
            parentVolume.remove(volumeVis);
            updateVolumeModel();
        }
        if (parentThis != null) {
            parentThis.remove(this);
            parentThis.revalidate();
        }

    }

    @Override
    public void setY(int y) {
        super.setY(invert(y));
    }

    private void updateVolumeModel() {
        ((GridNote) tools).volumeGrid.model.fireTableDataChanged();
    }
}
