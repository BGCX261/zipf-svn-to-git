package zipf.event.conditions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import zipf.event.Event;

public abstract class DefaultRuleItem extends DefaultChainable implements Invokable {

    public DefaultRuleItem() {
    }


    public Method method;
    public Object value;
    public Class itemClass;

    public DefaultRuleItem(Class itemClass, Method method) {
        this.method = method;
        this.itemClass = itemClass;
    }

    @Override
    public Object invoke() {
        return invoke(method, item, value);
    }

    @Override
    public Object invokeReturn() {
        return invoke(method, item);
    }

    @Override
    public Class getReturnType() {
        return method.getReturnType();
    }

    @Override
    public Object invoke(Method method, Object item, Object value) {
        Object o = null;
        Object [] array = (value!=null) ? new Object[]{value} : new Object[]{};
//        System.out.println("method " + method + " item " + item + " value " + value );
        try {
            o = method.invoke(item, array);
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

    @Override
    public Object invoke(Method method, Object item) {
        return invoke(method, item, null);
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public void setMethod(Method method) {
        this.method = method;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public void setItemClass(Class itemClass) {
        this.itemClass = itemClass;
    }

    @Override
    public Class getItemClass() {
        return itemClass;
    }
}
