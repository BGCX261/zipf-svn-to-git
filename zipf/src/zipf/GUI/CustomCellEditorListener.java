package zipf.GUI;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import zipf.IO.FileIO;

class CustomCellEditorListener implements CellEditorListener {

    JTree tree;
    Browser browser;

    public CustomCellEditorListener(JTree tree, Browser browser) {
        this.tree = tree;
        this.browser = browser;
    }

    @Override
    public void editingStopped(ChangeEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getEditingPath().getLastPathComponent();
        String fileName = tree.getCellEditor().getCellEditorValue().toString();
        Object o = node.getUserObject();
        if (o instanceof File) {
            File file = (File) o;
            if (!file.isDirectory()) {
                fileName += FileIO.getEnding(file);
            }
            File file2 = new File(file.getParent() + File.separator + fileName);
            boolean renamed = file.renameTo(file2);
        }
            browser.updateTree();
            browser.updateFolderTree();
    }

    @Override
    public void editingCanceled(ChangeEvent e) {
    }
}
