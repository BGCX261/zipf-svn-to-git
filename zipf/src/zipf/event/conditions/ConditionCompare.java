package zipf.event.conditions;

import java.lang.reflect.Method;

public class ConditionCompare extends DefaultCondition {

    public int compareOperator;
    public boolean invert;


    public ConditionCompare(int compareOperator) {
        this.compareOperator = compareOperator;
    }

    public ConditionCompare(Class clazz, Method method,int compareOperator) {
        this(compareOperator);
        this.method = method;
        this.itemClass = clazz;
    }



    @Override
    public boolean check() {
        return compare()^ invert;
    }

    @Override
    public String toString() {
        String str = "";
//        if (getMethod() != null) {
//            str += ToolsNode.name(getMethod()) + " ";
//        }
//        if (getValue() != null) {
//            str += getValue().toString() + "  ";
//        }
//        String str = "compare " + getMethod().getDeclaringClass().getSimpleName() + "." + getMethod() + code(operator) + this.comparedObject;
        return str + code();
    }

    public String code() {
        if (compareOperator == 1) {
            return ">";
        }
        if (compareOperator == 0) {
            return "==";
        }
        if (compareOperator == -1) {
            return "<";
        }
        return null;
    }

    
    public void setIntOperator(int intOperator) {
        this.compareOperator = intOperator;
    }

    public void setInvert(boolean invert) {
        this.invert = invert;
    }

    boolean compare() {
        return compareOperator == ((Comparable)invokeReturn()).compareTo(value);
    }

 
    
}
