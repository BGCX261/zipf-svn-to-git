package zipf.libraries;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JTree.DynamicUtilTreeNode;
import zipf.event.NoteSeq;
import zipf.event.interfaces.Nameable;

public class FolderNode extends DynamicUtilTreeNode implements Nameable {

    String name;

    public FolderNode(Object value, Object children) {
        super(value, children);
    }

    @Override
    public String toString() {
        if (name == null) {
            name = ToolsNode.name(getUserObject());
        }
        return name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
