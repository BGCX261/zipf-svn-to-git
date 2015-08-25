package zipf.GUI.condition;

import java.util.ArrayList;
import zipf.GUI.condition.TreeSides;
import zipf.event.conditions.ConditionSet;
import zipf.event.interfaces.Nameable;
import zipf.eventControl.Counter;

public class RuleTrees extends ArrayList<ConditionSet> implements Nameable {

    public String name;

    @Override
    public String getName() {
        if (name == null) {
            name = Counter.countAndName(this);
        }
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
