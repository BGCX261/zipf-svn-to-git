package zipf.libraries;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Vector;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import zipf.event.conditions.ActionChangeValue;
import zipf.event.conditions.ConditionCompareNumberMod;
import zipf.event.conditions.DefaultAction;
import zipf.event.interfaces.Routable;

public class EModels {


    public static DefaultTreeModel getElementConditionTree(Class clazz) {
        return new DefaultTreeModel(NodeLibrary.conditionNode.get(clazz));
    }
    public static DefaultTreeModel getElementActionTree(Class clazz) {
        return new DefaultTreeModel(NodeLibrary.actionNode.get(clazz));
    }

    public static DefaultTreeModel getFolderModel(String...path) {
        return new DefaultTreeModel(NodeLibrary.getFolders(path));
    }

    public static DefaultTreeModel getFilesModel(String... path) {
        return new DefaultTreeModel(NodeLibrary.getFiles(path));
    }

}
