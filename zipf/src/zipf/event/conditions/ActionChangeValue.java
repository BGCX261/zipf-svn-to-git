package zipf.event.conditions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import zipf.event.Note;

public class ActionChangeValue extends DefaultAction {


    public ActionChangeValue() {
       
    }

    public ActionChangeValue(Class clazz, Method method) {
        super(clazz,method);
    }

    @Override
    public void process() {
        invoke();
    }
}
