package zipf.event.conditions;

import java.util.ArrayList;

public class ConditionSet extends DefaultCondition implements RuleItemSet<DefaultCondition> {

    public ArrayList<DefaultCondition> ruleItems = new ArrayList<DefaultCondition>();

    @Override
    public void set(Object item) {
        System.out.print(" > conditionSet in");
        bool = false;
        this.item = item;
        if (check()) {
            bool = true;
            System.out.println("<linking to " + targets + ">");
            notifyTargets(item);
        }
    }

    @Override
    public boolean check() {
        if (ruleItems.size() == 1 && ruleItems.get(0).bool) {
            return true;
        }
        boolean result = false;
        boolean second;
        int operatorTmp;
        result = ruleItems.get(0).bool;
        for (int i = 0; i < ruleItems.size() - 1; i++) {
            second = ruleItems.get(i + 1).bool;
            operatorTmp = ruleItems.get(i).operator;
//            System.out.print(ToolsNode.name(ruleItems.get(i).getClass().getSimpleName()) + " " + result + " " + code(operatorTmp) + " " + second + " " + ruleItems.get(i + 1).getClass().getSimpleName() + " ... ");
            switch (operatorTmp) {
                case AND:
                    result = result && second;
                    break;
                case OR:
                    result = result || second;
                    break;
                case XOR:
                    result = result ^ second;
                    break;
            }
//            System.out.println("TMP - CHECK " + result);
        }
//        System.out.println(" result is " + result);
        return result;
    }

    @Override
    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        int depth = 0;
//        ConditionSet parentSet = this;
//        while ((ConditionSet) parentSet.getParent() != null) {
//            depth++;
//            parentSet = (ConditionSet) parentSet.getParent();
//        }
//        if (this.getParent() != null) {
//            sb.append("Conditionset, size: " + ruleItems.size() + "// Parent-Size: " + ((ConditionSet) parentSet).ruleItems.size() + "\n");
//        } else {
//            sb.append("Conditionset, size: " + ruleItems.size() + "\n");
//        }
////        System.out.println(ruleItems);
//        for (DefaultCondition defaultCondition : ruleItems) {
//            int index = ruleItems.indexOf(defaultCondition);
//            String str = "";
//            for (int i = 0; i < depth; i++) {
//                str += " ";
//            }
//            sb.append(str + index + "  -  " + defaultCondition.toString());
//            if (index < ruleItems.size() - 1) {
//                sb.append("\n");
//            }
//        }
////        return "conditionSet  " + ruleItems.size() + "  targets: " + targets.toString() + "conditions: " + ruleItems;
//        return sb.toString();
        return ruleItems.toString();
    }

    @Override
    public int getOperator() {
        return operator;
    }

    @Override
    public void setOperator(int operator) {
        this.operator = operator;
    }

    @Override
    public void addRuleItem(DefaultCondition ruleItem) {
//        System.out.println("    adding");
        ruleItems.add(ruleItem);
        ruleItem.addTarget(this);
        ruleItem.parent = this;
        System.out.println(this);
    }

    @Override
    public void removeRuleItem(DefaultCondition ruleItem) {
//        System.out.println("       removing");
        ruleItems.remove(ruleItem);
        ruleItem.removeTarget(this);
        ruleItem.parent=null;
    }

    @Override
    public void setIndex(int newIndex, DefaultCondition item) {
//        System.out.println("     setting");
        if (item.parent != null) {
            item.remove();
        }
        ruleItems.add(newIndex, item);
        item.addTarget(this);
        item.parent = this;
        System.out.println(this);
    }

    @Override
    public ArrayList<DefaultCondition> getRuleItems() {
        return ruleItems;
    }

    @Override
    public void remove(DefaultChainable chainable) {
        if (chainable instanceof DefaultCondition) {
            removeRuleItem((DefaultCondition) chainable);
        } else {
            throw new RuntimeException();
        }
    }
}
