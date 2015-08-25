package zipf.event.conditions;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class DefaultRouter extends ConditionSet {

    Object eventSource;
    public HashMap<Class, ArrayList<DefaultCondition>> conditionTable = new HashMap<Class, ArrayList<DefaultCondition>>();

    public DefaultRouter(Object source) {
        this.eventSource = source;
    }

    @Override
    public void set(Object item) {
//        System.out.println("");
//        System.out.print(" > ");
        for (Method m : ActionSet.methods.keySet()) {
            ActionSet.methods.get(m).clear();
        }
        if (item instanceof Iterable) {
            for (Object i : (Iterable) item) {
                for (Class clazz : conditionTable.keySet()) {
                    System.out.println("class: " + clazz.getSimpleName() + " item " + i.getClass().getSimpleName());
                    if (clazz.isAssignableFrom(i.getClass())) {
                        ruleItems = conditionTable.get(clazz);
                    }
                    if (ruleItems != null) {
                        notifyTargets(i);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "  listening to  " + eventSource + "   with conditions:  " + targets;
    }

    @Override
    public void addRuleItem(DefaultCondition condition) {
        Class clazz = condition.getItemClass();
        ArrayList<DefaultCondition> list = ((ruleItems = conditionTable.get(clazz)) != null) ? ruleItems : new ArrayList<DefaultCondition>();
        list.add(condition);
        if (ruleItems == null) {
            conditionTable.put(clazz, list);
        }
        condition.parentRouter = this;
        System.out.println(this.sources + "  " + conditionTable);
    }

    @Override
    public void removeRuleItem(DefaultCondition condition) {
        Class clazz = condition.getItemClass();
        conditionTable.get(clazz).remove(condition);
    }

    @Override
    public void notifyTargets(Object item) {
        if (!ruleItems.isEmpty()) {
            for (DefaultCondition condition : ruleItems) {
                condition.set(item);
            }
        }
    }
}
