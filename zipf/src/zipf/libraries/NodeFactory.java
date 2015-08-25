package zipf.libraries;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Vector;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import zipf.event.BaseNote;
import zipf.event.Note;
import zipf.event.NoteSeq;
import zipf.event.conditions.ActionChangeValue;

public class NodeFactory {

    static Class itemClass;
    static Method method;
    static boolean isReturn;
    static boolean isParameterless;
    static boolean isReturnInt;
    static boolean isReturnLong;
    static boolean isPitch;
    static boolean isDuration;
    static boolean isPosition;
    static boolean isReturnNumber;
    static boolean isNumberGetter;
    static boolean isVoid;
    static boolean isSetter;

    private static void checkContext() {
        isReturn = method.getReturnType() == null;
        isParameterless = method.getParameterTypes().length == 0;
        isReturnInt = returns(int.class, Integer.class);
        isReturnLong = returns(long.class, Long.class);
        isVoid = returns(void.class);
        isPitch = (contains("etY")) && isNoteType();
        isDuration = contains("Duration");
        isPosition = contains("Position");
        isReturnNumber = isReturnLong || isReturnInt;
        isNumberGetter = isParameterless & isReturnNumber;
        isSetter = isVoid && contains("set") && method.getParameterTypes().length == 1;
    }

    private static boolean contains(String string) {
        return method.getName().contains(string);
    }

    private static boolean is(Class... classes) {
        for (Class clazz : classes) {
            if (itemClass == clazz) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNoteType() {
        return is(Note.class, BaseNote.class);
    }

    private static boolean returns(Class... classes) {
        for (Class clazz : classes) {
            if (method.getReturnType() == clazz) {
                return true;
            }
        }
        return false;
    }

    public static Hashtable getMethodNodes(String keyWord, Class clazz) {
        itemClass = clazz;
        Hashtable methodNodes = new Hashtable();
        for (Method m : NodeLibrary.methodList(clazz, keyWord)) {
            method = m;
            Vector subNodes = null;
            checkContext();
            if (isNumberGetter) {
                subNodes = NodeLibrary.comparatorList(clazz, m);
                if (isPitch) {
                    ToolsNode.insertInMap(subNodes, NodeLibrary.noteListCondition(clazz, m));
                }
                methodNodes.put(new MethodWrapper(m), subNodes);
            } else if (isSetter) {
                methodNodes.put(new ActionChangeValue(clazz,m), "dummy");
            }
        }
        return methodNodes;
    }

    static Hashtable getClassNodes(String string, Class... classes) {
        Hashtable nodes = new Hashtable();
        for (Class clazz : classes) {
            nodes.put(new ClassWrapper(clazz), getMethodNodes(string, clazz));
        }
        return nodes;
    }

    static MutableTreeNode getMainClassNode(Class mainClass, String string, Class... classes) {
        return new FolderNode(mainClass, getClassNodes(string, classes));
    }
}
