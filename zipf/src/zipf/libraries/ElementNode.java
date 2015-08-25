package zipf.libraries;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.JTree.DynamicUtilTreeNode;
import javax.swing.tree.DefaultMutableTreeNode;
import zipf.event.Note;
import zipf.event.interfaces.Nameable;

public class ElementNode extends DefaultMutableTreeNode implements Nameable {

    private String name;

    public ElementNode() {
    }

    public ElementNode(Object userObject) {
        super(userObject);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (name == null) {
            name = ToolsNode.name(getUserObject());
        }
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
