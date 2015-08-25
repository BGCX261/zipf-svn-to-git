package zipf.event.conditions;

import java.lang.reflect.Method;

public class ConditionCompareNumberMod extends ConditionCompare {

    private final int mod;

    public ConditionCompareNumberMod(int compareOperator, int mod) {
        super(compareOperator);
        this.mod = mod;
    }

    public ConditionCompareNumberMod(int compareOperator, int mod, int value) {
        super(compareOperator);
        this.mod = mod;
        setValue(value);
    }

    public ConditionCompareNumberMod(Class clazz, Method method, int value, int compareOperator, int mod) {
        this(value, compareOperator, mod);
        this.method = method;
        this.itemClass = clazz;
    }

    @Override
    boolean compare() {
        Integer integer = (Integer) ((int) (Integer) invokeReturn() % mod);
        return compareOperator == integer.compareTo((Integer) value);
    }

    @Override
    public String toString() {
        if (mod == 12 && getValue() != null) {
            return ToolsEvent.noteNames[(Integer) getValue()];
        } else {
            return "empty Name for conditionMod";
        }
    }
}
