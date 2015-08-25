package zipf.GUI.tree;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import zipf.libraries.ElementNode;
import zipf.libraries.EModels;

public class ToolsTree extends JPanel{

    public DefaultMutableTreeNode selectedNode;
    public Object selectedObject;
    public DefaultTreeModel model;
    public JTree tree;
    public String title = "title";
    public final static int treeHeight=250;


    public void updateTree() {
        tree.setModel(model);
    }

    public void setTreeModel(DefaultTreeModel model) {
        this.model = model;
        updateTree();
    }

    public void treeValueChanged() {
        setSelected((ElementNode) tree.getSelectionPath().getLastPathComponent());
    }

    public void setSelected(ElementNode elementNode) {
        selectedNode = elementNode;
        selectedObject = elementNode.getUserObject();
    }
}
