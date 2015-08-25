package zipf.GUI.tree;

import java.util.Arrays;
import zipf.GUI.condition.TreeSides;
import zipf.event.interfaces.Routable;
import zipf.libraries.EModels;

public class TreeAction extends ToggleTree {


    public TreeAction(TreeSides treeSides, int index) {
        super( treeSides, index);
        thisSide = treeSides.actionPanel;
        otherSide = treeSides.conditionPanel;
        conPanels.chainable = treeSides.actionPanel.set;
        setTreeModel(EModels.getElementActionTree(currentObject.getClass()));
        addTreeToPanel();
    }

    @Override
    public void addTree(Routable current) {
        ToolsToggle.currentObject = current;
        new TreeAction(treeSides, Arrays.asList(thisSide.getComponents()).indexOf(this) + 1);
    }



    @Override
    public void saveRuleItem() {
    super.saveRuleItem();
//        System.out.println("  ActionSet  " + ruleItemSet + "  Action " + ruleItem);
    }

    @Override
    void initTree() {
        model = EModels.getElementActionTree(currentObject.getClass());
        updateTree();
    }

 
}
