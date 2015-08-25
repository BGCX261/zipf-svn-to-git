package zipf.GUI.grid;

public class SidePanelParam extends SidePanel {

    public GridParam tools;

    public SidePanelParam(GridParam vtools) {
        this.tools=vtools;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paramTitle = new javax.swing.JLabel();
        menuPopup1 = new zipf.GUI.grid.MenuPopup();

        setLayout(null);

        paramTitle.setFont(new java.awt.Font("Tahoma", 0, 12));
        paramTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paramTitle.setText("paramTitle");
        paramTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        paramTitle.setAlignmentX(0.5F);
        paramTitle.setMaximumSize(new java.awt.Dimension(100, 20));
        paramTitle.setMinimumSize(new java.awt.Dimension(100, 20));
        paramTitle.setPreferredSize(new java.awt.Dimension(100, 20));
        add(paramTitle);
        paramTitle.setBounds(20, 10, 60, 20);
        add(menuPopup1);
        menuPopup1.setBounds(20, 30, 75, 23);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private zipf.GUI.grid.MenuPopup menuPopup1;
    public javax.swing.JLabel paramTitle;
    // End of variables declaration//GEN-END:variables

}
