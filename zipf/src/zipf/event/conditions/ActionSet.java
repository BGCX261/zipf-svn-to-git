package zipf.event.conditions;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class ActionSet extends DefaultAction implements RuleItemSet<DefaultAction> {

    static HashMap<Method, ArrayList<Object>> methods = new HashMap<Method, ArrayList<Object>>();
    public ArrayList<DefaultAction> ruleItems = new ArrayList<DefaultAction>();

    @Override
    public void set(Object item) {
        System.out.print(" > ActionSet in");
        for (DefaultAction action : ruleItems) {
            action.set(item);
        }
    }

    @Override
    public void notifyTargets(Object item) {
        for (DefaultAction action : ruleItems) {
            if (!methods.get(action.getMethod()).contains(item)) {
                methods.get(action.getMethod()).add(item);
                action.set(item);
            }
        }
    }

    @Override
    public void addRuleItem(DefaultAction ruleItem) {
        ruleItems.add(ruleItem);
        ruleItem.parent = this;
    }

    @Override
    public void removeRuleItem(DefaultAction ruleItem) {
        ruleItems.remove(ruleItem);
    }

    @Override
    public void setIndex(int newIndex, DefaultAction item) {
        ruleItems.remove(item);
        ruleItems.add(newIndex, item);
            item.parent = this;
    }

    @Override
    public ArrayList<DefaultAction> getRuleItems() {
        return ruleItems;
    }

    @Override
    public void remove(DefaultChainable chainable) {
        if (chainable instanceof DefaultAction) {
            ruleItems.remove((DefaultAction)chainable);
        } else {
            throw new RuntimeException();
        }
    }
}
