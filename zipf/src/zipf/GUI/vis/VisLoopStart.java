package zipf.GUI.vis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicArrowButton;
import zipf.GUI.vis.Vis;
import zipf.GUI.grid.GridLoop;
import zipf.GUI.grid.ToolsPanel;
import zipf.lookAndFeel.Designer;

public class VisLoopStart extends JPanel {
    private final GridLoop tools;

    public VisLoopStart(GridLoop tools) {
        this.tools = tools;
//        BasicArrowButton button = new BasicArrowButton(SwingConstants.EAST);
//        this.add(button,BorderLayout.CENTER);
//        JButton button = new
//        Designer.design(button);
//        button.setOpaque(false);
//        button.setMargin(new Insets(0,0,0,0));
//        button.setBackground(Color.white);
//        ToolsPanel.setFixedBounds(button, 30, 30);
        initComponents();
        jButton1.setMargin(new Insets(0,0,0,0));
        jButton1.setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 102, 255));
        setAutoscrolls(true);
        setMaximumSize(new java.awt.Dimension(20, 20));
        setMinimumSize(new java.awt.Dimension(20, 20));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(20, 20));
        setLayout(new java.awt.BorderLayout());

        jButton1.setText("[");
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(false);
        add(jButton1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

}
