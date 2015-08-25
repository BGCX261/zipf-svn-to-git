package zipf.GUI.condition;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;
import zipf.GUI.grid.ToolsPanel;
import zipf.event.conditions.RuleItemSet;

public class ConTainer extends ConAbstract implements RuleItemContainer {


    public ConTainer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(204, 255, 204));
        setPreferredSize(new java.awt.Dimension(250, 300));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void updateUI() {
        int i = ToolsPanel.getAutoHeight(this);
        this.setPreferredSize(new Dimension(250, i));
        if (this.getParent()!=null) {
            this.getParent().setPreferredSize(new Dimension(250, i));
        }
        super.updateUI();
    }

    @Override
    public RuleItemSet getSet() {
        return  (RuleItemSet) chainable;
    }

    @Override
    public JPanel getSpacer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    @Override
    public void setSpacer(int i) {
        for (Component c : this.getComponents()) {
            ((ConAbstract) c).setSpacer(i);
        }
    }

    @Override
    public void setOperatorsVisible(boolean bool) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
