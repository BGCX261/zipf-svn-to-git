package zipf.libraries;

import java.io.Serializable;
import java.lang.reflect.Method;

public class MethodWrapper {

    public Method method;

    public MethodWrapper(Method method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return ToolsNode.name(method);
    }
}
