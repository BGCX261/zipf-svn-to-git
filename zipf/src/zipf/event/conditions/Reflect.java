package zipf.event.conditions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reflect {


    public Object invoke(Method method, Object item, Object value) {
        Object o=null;
        try {
            Object[] argument = new Object[]{value};
            o = method.invoke(item, argument);
// <editor-fold defaultstate="collapsed" desc="catch...">
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ActionChangeValue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ActionChangeValue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ActionChangeValue.class.getName()).log(Level.SEVERE, null, ex);
        }// </editor-fold>
        return o;
    }

    public Object invoke(Method method, Object item) {
        return invoke(method, item, new Object[]{null});
    }

}
