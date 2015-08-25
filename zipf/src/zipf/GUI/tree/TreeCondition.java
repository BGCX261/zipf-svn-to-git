package zipf.GUI.tree;

import java.util.Arrays;
import zipf.GUI.condition.TreeSides;
import zipf.event.conditions.DefaultCondition;
import zipf.event.conditions.DefaultRouter;
import zipf.event.interfaces.Routable;
import zipf.libraries.EModels;

public class TreeCondition extends ToggleTree {

    public TreeCondition(TreeSides treeSides, int index) {
        super(  treeSides, index);
        thisSide = treeSides.conditionPanel;
        otherSide = treeSides.actionPanel;
        conPanels.chainable = treeSides.conditionPanel.set;
        setTreeModel(EModels.getElementConditionTree(currentObject.getClass()));
        addTreeToPanel();
    }

    @Override
    public void addTree(Routable current) {
        currentObject = current;
        new TreeCondition( treeSides, Arrays.asList(thisSide.getComponents()).indexOf(this) + 1);
    }

    @Override
    public void saveRuleItem() {
        super.saveRuleItem();
        DefaultRouter router = ToolsToggle.currentObject.getRouter();
        router.addRuleItem((DefaultCondition) ruleItem);
    }

}
