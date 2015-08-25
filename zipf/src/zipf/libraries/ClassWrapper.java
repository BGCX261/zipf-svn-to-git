package zipf.libraries;

import java.lang.reflect.Method;

public class ClassWrapper {

    public Class itemClass;

    public ClassWrapper(Class itemClass) {
        this.itemClass = itemClass;
    }

    @Override
    public String toString() {
        return ToolsNode.name(itemClass);
    }
}
