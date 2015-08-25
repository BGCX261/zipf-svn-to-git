package zipf.GUI.condition;

import javax.swing.JPanel;
import zipf.GUI.tree.ToggleTree;
import zipf.event.conditions.ConditionSet;
import zipf.event.conditions.RuleItemSet;

public class TreeSide extends JPanel {

    public ToggleTree openTree;
    public RuleItemSet set;

    public TreeSide(){
        
    }

    public TreeSide(RuleItemSet set) {
        this.set = set;
    }
}
