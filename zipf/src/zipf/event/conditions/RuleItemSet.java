package zipf.event.conditions;

import java.util.ArrayList;

public interface RuleItemSet<GenRuleItem extends DefaultChainable> extends Chainable{

    void addRuleItem(GenRuleItem ruleItem);

    void removeRuleItem(GenRuleItem ruleItem);

    void setIndex(int newIndex, GenRuleItem item);

    public ArrayList<GenRuleItem> getRuleItems();

    public void remove(DefaultChainable chainable);

}
