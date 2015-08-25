package zipf.event.conditions;

import java.lang.reflect.Method;
import zipf.event.Event;
import zipf.event.Note;
import zipf.event.interfaces.Visable;
import zipf.libraries.ToolsNode;

public class DefaultAction extends DefaultRuleItem implements Action {

    public DefaultAction() {
    }

    public DefaultAction(Class clazz, Method method) {
        super(clazz, method);
    }

    @Override
    public void set(Object item) {
        System.out.print(" > Action in ");
        this.item = item;
        process();
        if (item instanceof Visable) {
            ((Visable)item).getVis().updateBounds();
        }
        System.out.println("committed change on " + item + " with method " + method + " (value " + value + ")");
        System.out.println(((Note)item).getY());
    }

    @Override
    public void process() {
        invoke();
    }

    @Override
    public String toString() {
//        String str = this.getClass().getSimpleName();
//        if (str.contains("Action")) {
//            str = str.substring(6, str.length());
//        }
        return ToolsNode.name(method);
    }
}
