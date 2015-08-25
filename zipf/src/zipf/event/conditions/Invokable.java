package zipf.event.conditions;

import java.lang.reflect.Method;

public interface Invokable {

    Object invoke();

    Object invokeReturn();

    Object invoke(Method method, Object value);

    Object invoke(Method method, Object item, Object value);

    Class getReturnType();

    public Method getMethod();

    public void setMethod(Method method);

    public Object getValue();

    public void setValue(Object value);

    public void setItemClass(Class itemClass);

    Class getItemClass();
}
