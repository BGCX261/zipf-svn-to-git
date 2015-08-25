package zipf.GUI.tree;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import zipf.GUI.CurrentItems;
import zipf.GUI.grid.GridEdit;
import zipf.GUI.grid.GridNote;
import zipf.GUI.grid.ToolsBar;
import zipf.IO.FileIO;
import zipf.event.Seq;
import zipf.libraries.EModels;

public class ToolsSplitTree extends ToolsTree {

    public JTree folderTree;
    public ToolsBar tools;
    public boolean autoLoad;
    public String[] currentFolderPath = new String[]{};
    public static File selectedFile;

    @Override
    public void updateTree() {
        tree.setModel(EModels.getFilesModel(currentFolderPath));
    }

    public void updateFolderTree() {
        folderTree.setModel(EModels.getFolderModel());
    }

    public void setTools(ToolsBar currentEdit) {
        tools = currentEdit;
    }

    public void copyMarked() {
        for (File file : getFiles()) {
            FileIO.copyFile(file);
        }
    }

    public void deleteMarked() {
        for (File file : getFiles()) {
            file.delete();
        }
        this.updateTree();
    }

    ArrayList<File> getFiles() {
        ArrayList<File> list = new ArrayList<File>();
        if (tree.getSelectionPaths().length > 0) {
            for (TreePath path : tree.getSelectionPaths()) {
                Object o = ((DefaultMutableTreeNode) path.getLastPathComponent()).getUserObject();
                if (o instanceof File) {
                    list.add((File) o);
                }
            }
        }
        return list;

    }
}
