package zipf.GUI.condition;

import java.awt.Dimension;
import javax.swing.JPanel;
import zipf.GUI.PanelCondition;
import zipf.GUI.tree.ToolsToggle;
import zipf.GUI.tree.TreeAction;
import zipf.GUI.tree.TreeCondition;
import zipf.event.conditions.ActionSet;
import zipf.event.conditions.Condition;
import zipf.event.conditions.ConditionSet;
import zipf.lookAndFeel.Designer;

public class TreeSides extends JPanel {

    public PanelCondition panelCondition;

    public TreeSides(PanelCondition panelCondition) {
        this.panelCondition = panelCondition;
        initComponents();
        conditionPanel.set = new ConditionSet();
        actionPanel.set = new ActionSet();
        panelCondition.screenPanel.add(this);
        conditionPanel.set.addTarget(actionPanel.set);
        new TreeAction(this, 0);
        new TreeCondition(this, 0);
        ToolsToggle.ruleTrees.add((ConditionSet) conditionPanel.set);
        Designer.design(panelCondition.screenPanel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        conditionPanel = new zipf.GUI.condition.TreeSide();
        actionPanel = new zipf.GUI.condition.TreeSide();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 2, true));
        setPreferredSize(new java.awt.Dimension(1000, 300));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        conditionPanel.setAlignmentX(0.0F);
        conditionPanel.setAlignmentY(0.0F);
        conditionPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        add(conditionPanel);

        actionPanel.setAlignmentX(1.0F);
        actionPanel.setAlignmentY(0.0F);
        actionPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        add(actionPanel);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public zipf.GUI.condition.TreeSide actionPanel;
    public zipf.GUI.condition.TreeSide conditionPanel;
    // End of variables declaration//GEN-END:variables
}
