package zipf.libraries;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import zipf.event.conditions.DefaultCondition;
import zipf.event.conditions.Invokable;
import zipf.event.interfaces.Nameable;

public class ToolsNode {

    public static String name(Object o) {

        if (o instanceof Nameable) {
            return ((Nameable) o).getName();
        }

        if (o instanceof Invokable) {
            String str = "";
            str += name(((Invokable) o).getMethod()) + " ";
            str += o.toString() + " ";
            str += ((Invokable) o).getValue();
            return str;
        }

        if (o instanceof Field) {
            return ((Field) o).getName();
        }
        if (o instanceof Method) {
            String str = ((Method) o).getName();
            if (str.startsWith("get") || str.startsWith("set")) {
                str = str.substring(3);
            }
            return str;
        }

        if (o instanceof File) {
            if (((File) o).isFile()) {
                StringBuilder str = new StringBuilder(((File) o).getName());
                str.delete(str.length() - 4, str.length());
                return str.toString();
            } else {
                return ((File) o).getName();
            }
        }


        if (o instanceof Class) {
            return ((Class) o).getSimpleName();
        }

        if (o != null) {
            return o.toString();

        } else {
            return "null";
        }
    }

    static Hashtable insertInMap(Vector list, Object insert) {
        Hashtable map = new Hashtable();
        for (Object o : list) {
            map.put(o, insert);
        }
        return map;
    }
}
