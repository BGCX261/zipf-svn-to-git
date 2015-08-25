package zipf.event.conditions;

import java.lang.reflect.Method;
import zipf.event.Event;

public abstract class DefaultCondition extends DefaultRuleItem implements Condition {

    public int operator;
    public boolean bool = false;
    DefaultRouter parentRouter;

    @Override
    public void set(Object item) {
        System.out.print(" > DefaultCondition in " + item);
        bool = false;
        this.item = item;
        System.out.print(" (check is " + check() + ")");
        if (check()) {
            bool = true;
            notifyTargets(item);
        }
    }

    @Override
    public void remove() {
        super.remove();
        if(parentRouter!=null){
            parentRouter.removeRuleItem(this);
        }
    }



    @Override
    public int getOperator() {
        return operator;
    }

    @Override
    public void setOperator(int operator) {
        this.operator = operator;
    }

    public String code(int operatorTmp) {
        switch (operatorTmp) {
            case 0:
                return "AND";
            case 1:
                return "OR";
            case 2:
                return "XOR";
        }
        return "NONE";
    }
}
