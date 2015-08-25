package zipf.GUI;

import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

class CustomTreeModelListener implements TreeModelListener{

    public CustomTreeModelListener(JTree fileTree, Browser browser) {
    }

    @Override
    public void treeNodesChanged(TreeModelEvent e) {
        System.out.println("changed");
    }

    @Override
    public void treeNodesInserted(TreeModelEvent e) {
        System.out.println("inserted");
    }

    @Override
    public void treeNodesRemoved(TreeModelEvent e) {
        System.out.println("removed");
    }

    @Override
    public void treeStructureChanged(TreeModelEvent e) {
        System.out.println("structureChanged");
    }

}
