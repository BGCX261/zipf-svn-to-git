package zipf.GUI.condition;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import zipf.GUI.grid.ToolsPanel;
import zipf.event.conditions.RuleItemSet;

public class ConSetContainer extends ConAbstract implements RuleItemContainer {

    public ArrayList<ConAbstract> panels = new ArrayList<ConAbstract>();

    public ConSetContainer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        defaultConSetPanel = new zipf.GUI.condition.ConSetPanel();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 0), 1, true));
        setAlignmentX(1.0F);
        setMaximumSize(new java.awt.Dimension(100, 100030));
        setMinimumSize(new java.awt.Dimension(250, 0));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(240, 30));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
        add(defaultConSetPanel);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public zipf.GUI.condition.ConSetPanel defaultConSetPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public JPanel getSpacer() {
        return null;
    }

    @Override
    public void updateUI() {
        this.setPreferredSize(new Dimension(this.getWidth(), getBestSize()));
        super.updateUI();
    }

    @Override
    public RuleItemSet getSet() {
        return  (RuleItemSet) chainable;
    }

    @Override
    public void setSpacer(int i) {
        ToolsPanel.setFixedBounds(this, 250 - (i * 15), getBestSize()+2);
        for (Component c: this.getComponents()){
            if (c instanceof ConPanel) {
                ConPanel conPanel = (ConPanel) c;
                ToolsPanel.setFixedBounds(conPanel.label, conPanel.labelSize-((i*15)+5), 15);
            }
            if (c instanceof ConSetPanel) {
                ConSetPanel conSetPanel = (ConSetPanel) c;
                ToolsPanel.setFixedBounds(conSetPanel.label, conSetPanel.labelSize-((i*15)+5), 15);
            }
        }
        this.updateUI();
    }

    public int getBestSize(){
        return ToolsPanel.getAutoHeight(this)+2;
    }

    @Override
    public void setOperatorsVisible(boolean bool) {
//        this.conSetPanel1.setOperatorsVisible(bool);
    }



    
    
}
