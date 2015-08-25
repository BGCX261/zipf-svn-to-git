package zipf.libraries;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.tree.TreeNode;
import zipf.event.BaseNote;
import zipf.event.Note;
import zipf.event.NoteSeq;
import zipf.event.conditions.ConditionCompare;
import zipf.event.conditions.ConditionCompareNumberMod;
import zipf.event.conditions.DefaultCondition;
import zipf.event.conditions.DefaultCondition;

public class NodeLibrary {

    public static HashMap<Class, TreeNode> conditionNode = new HashMap<Class, TreeNode>();
    public static HashMap<Class, TreeNode> actionNode = new HashMap<Class, TreeNode>();

    static {
        conditionNode.put(NoteSeq.class, NodeFactory.getMainClassNode(NoteSeq.class, "get", Note.class, BaseNote.class));
        actionNode.put(NoteSeq.class, NodeFactory.getMainClassNode(NoteSeq.class, "set", Note.class, BaseNote.class));
    }

    static Vector<DefaultCondition> comparatorList(Class clazz, Method method) {
        Vector<DefaultCondition> conditions = new Vector<DefaultCondition>();
        conditions.add(new ConditionCompare(clazz, method, 0));
        conditions.add(new ConditionCompare(clazz, method, 1));
        conditions.add(new ConditionCompare(clazz, method, -1));
        return conditions;
    }

    static Vector<ConditionCompareNumberMod> noteListCondition(Class clazz, Method method) {
        Vector<ConditionCompareNumberMod> conditions = new Vector<ConditionCompareNumberMod>();
        for (int i = 0; i < 12; i++) {
            conditions.add(new ConditionCompareNumberMod(clazz, method, i, 0, 12));
        }
        return conditions;
    }

    public static Vector<Method> methodList(Class clazz, String keyWord) {
        Vector<Method> list = new Vector<Method>();
        Object[] oa = clazz.getMethods();
        for (Object o : oa) {
            Method method = (Method) o;
            if (((method.getDeclaringClass() == Object.class) || !method.getName().contains(keyWord))) {
                method = null;
                continue;
            }
            Class tmpClass = null;
            if (keyWord.equals("get")) {
                tmpClass = method.getReturnType();
            } else if (keyWord.equals("set")) {
                tmpClass = method.getParameterTypes()[0];
            }
//            System.out.println(tmpClass);
            if (tmpClass == int.class || tmpClass == long.class) {
                list.add(method);
                continue;
            }
        }
        return list;
    }

    public static Hashtable getFieldNode(Object o, String keyWord) {

        Hashtable fields = new Hashtable();
        Vector fieldV = new Vector();
        Object[] oa = o.getClass().getFields();
        for (int i = 0; i < oa.length; i++) {
            Field oo = (Field) oa[i];
            if (oo.getDeclaringClass() == Object.class && oo.getName().contains(keyWord)) {
                oa[i] = null;
            }
        }
        for (Object field : oa) {
            if (field != null) {
                fieldV.add(field);
            }
        }
        fields.put(o, fields);
        return fields;
    }

    public static ElementNode getFileNode(String[] pathArray, boolean files, boolean folders) {
        String path = getPathFromArray(pathArray);
        ElementNode root = new ElementNode(new File(path));
        ElementNode actualRoot = root;
        File rootFile = new File(path);
        rootFile.mkdir();
        getFilesFromDir(actualRoot, rootFile.listFiles(), files, folders);
        return root;
    }

    public static void getFilesFromDir(ElementNode actualRoot, File[] fileList, boolean files, boolean folders) {
        if (fileList != null) {
            for (File file : fileList) {
                if (file.isDirectory() && !file.getName().equals(".svn") && folders) {
                    ElementNode newNode = new ElementNode(file);
                    actualRoot.add(newNode);
                    getFilesFromDir(newNode, file.listFiles(), files, folders);
                } else if (file.isFile() && files) {
                    
                    actualRoot.add(new ElementNode(file));
                }
            }
        }
    }

    static TreeNode getFiles(String... string) {
        return getFileNode(string, true, false);
    }

    static TreeNode getFolders(String... string) {
        return getFileNode(string, false, true);
    }

    private static String getPathFromArray(String... pathArray) {
        String path = "";
        if (pathArray.length==0||!pathArray[0].equals("Library")) {
            path += "Library";
        }
        for (String str : pathArray) {
            path += File.separator + str;
        }
        return path;
    }
}
