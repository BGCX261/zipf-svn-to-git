package zipf.GUI.grid;

import javax.swing.JPanel;
import zipf.lookAndFeel.Colors;

public class ContainerParam extends JPanel {

    ToolsBar tools;

    public ContainerParam() {
        initComponents();
    }

    public ContainerParam(ToolsBar vtools) {
        this.tools = vtools;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollParam = new javax.swing.JScrollPane();
        paramContainer = new zipf.GUI.grid.BoxPanelY();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        scrollParam.setBorder(null);
        scrollParam.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollParam.setAlignmentX(0.0F);
        scrollParam.setOpaque(false);

        paramContainer.setOpaque(false);
        paramContainer.setLayout(new javax.swing.BoxLayout(paramContainer, javax.swing.BoxLayout.Y_AXIS));
        scrollParam.setViewportView(paramContainer);

        add(scrollParam, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel paramContainer;
    private javax.swing.JScrollPane scrollParam;
    // End of variables declaration//GEN-END:variables
}
