package zipf.GUI.condition;

import java.awt.Container;
import javax.swing.JPanel;
import zipf.GUI.tree.ToolsToggle;
import zipf.event.conditions.Chainable;
import zipf.event.conditions.DefaultChainable;
import zipf.event.conditions.DefaultRuleItem;
import zipf.event.conditions.RuleItemSet;

public abstract class ConAbstract extends JPanel implements Comparable<ConAbstract> {

    public static String[] operators = {"&", "|", "^"};
    public Chainable chainable;
    public ToolsToggle ttools;
    boolean operatorVisible;

    public abstract JPanel getSpacer();

    public int getIndex() {
        return this.getParent().getComponentZOrder(this);
    }

    public abstract RuleItemSet getSet();

    @Override
    public int compareTo(ConAbstract o) {
        return o.getIndex() - getIndex();
    }

    public abstract void setSpacer(int i);

    public abstract void setOperatorsVisible(boolean bool);

    public RuleItemContainer getParentContainer() {
        Container panel = this.getParent();
        if (panel instanceof RuleItemContainer) {
            return (RuleItemContainer) panel;
        } else return null;
    }
}
