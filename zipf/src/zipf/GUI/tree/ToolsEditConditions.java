package zipf.GUI.tree;

import javax.swing.JPanel;
import zipf.GUI.CurrentItems;
import zipf.GUI.PanelCondition;
import zipf.GUI.Zipf;
import zipf.GUI.condition.TreeSides;
import zipf.IO.FileIO;
import zipf.event.conditions.ConditionSet;
import zipf.event.interfaces.Routable;
import zipf.libraries.ToolsNode;

public class ToolsEditConditions extends JPanel {

    TreeSides treeSides;

    public void newElementRule(Routable current) {
        ToolsToggle.currentObject = current;
        treeSides = new TreeSides((PanelCondition) this);
        setText(ToolsNode.name(current));
    }

    private void setText(String name) {
        treeSides.panelCondition.jLabel1.setText(name);
    }

    public void saveTrees() {
        FileIO.save(ToolsToggle.ruleTrees);
        CurrentItems.getCurrentBrowser().updateTree();
    }
}
