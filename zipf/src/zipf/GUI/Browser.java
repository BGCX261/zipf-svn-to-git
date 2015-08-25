package zipf.GUI;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.EventObject;
import java.util.regex.Pattern;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import zipf.GUI.grid.GridEdit;
import zipf.GUI.grid.GridNote;
import zipf.GUI.tree.ToolsSplitTree;
import zipf.libraries.EModels;
import zipf.libraries.ElementNode;
import zipf.lookAndFeel.Designer;
import zipf.lookAndFeel.Colors;

public class Browser extends ToolsSplitTree {

    public Browser() {
        initComponents();
//        ButtonDesigner.design(loadButton, saveButton, newQueue);
        super.tree = fileTree;
        super.folderTree = folderTree;
        folderTree.setModel(EModels.getFolderModel());
        setTreeModel(EModels.getFilesModel(currentFolderPath));
        folderTree.setCellEditor(new DefaultTreeCellEditor(folderTree, new DefaultTreeCellRenderer()));
        fileTree.setCellEditor(new DefaultTreeCellEditor(folderTree, new DefaultTreeCellRenderer()));
        fileTree.getCellEditor().addCellEditorListener(new CustomCellEditorListener(fileTree, this));
        folderTree.getCellEditor().addCellEditorListener(new CustomCellEditorListener(folderTree, this));
        fileTree.getModel().addTreeModelListener(new CustomTreeModelListener(fileTree,this));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        loadButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        autoLoadBox = new javax.swing.JCheckBox();
        newQueue = new javax.swing.JButton();
        browserSplitPane = new javax.swing.JSplitPane();
        folderScroll = new javax.swing.JScrollPane();
        folderTree = new javax.swing.JTree();
        fileScroll = new javax.swing.JScrollPane();
        fileTree = new javax.swing.JTree();
        deleteButton = new javax.swing.JButton();
        copyButton = new javax.swing.JButton();

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        loadButton.setText("load");
        loadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        add(loadButton, gridBagConstraints);

        saveButton.setText("save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 10);
        add(saveButton, gridBagConstraints);

        autoLoadBox.setText("AutoLoad");
        autoLoadBox.setOpaque(false);
        autoLoadBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                autoLoadBoxStateChanged(evt);
            }
        });
        autoLoadBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                autoLoadBoxItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 20, 20);
        add(autoLoadBox, gridBagConstraints);

        newQueue.setText("new");
        newQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newQueueActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 20, 10);
        add(newQueue, gridBagConstraints);

        browserSplitPane.setDividerLocation(250);
        browserSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        folderScroll.setBorder(null);

        folderTree.setAutoscrolls(true);
        folderTree.setDragEnabled(true);
        folderTree.setEditable(true);
        folderTree.setRootVisible(false);
        folderTree.setToggleClickCount(1);
        folderTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                folderTreeMouseClicked(evt);
            }
        });
        folderTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                folderTreeValueChanged(evt);
            }
        });
        folderTree.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                folderTreeMouseDragged(evt);
            }
        });
        folderTree.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                folderTreeKeyTyped(evt);
            }
        });
        folderScroll.setViewportView(folderTree);

        browserSplitPane.setTopComponent(folderScroll);

        fileScroll.setBorder(null);

        fileTree.setAutoscrolls(true);
        fileTree.setDragEnabled(true);
        fileTree.setEditable(true);
        fileTree.setRootVisible(false);
        fileTree.setToggleClickCount(1);
        fileTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileTreeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fileTreeMousePressed(evt);
            }
        });
        fileTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                fileTreeValueChanged(evt);
            }
        });
        fileTree.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                fileTreeMouseDragged(evt);
            }
        });
        fileTree.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fileTreeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fileTreeKeyTyped(evt);
            }
        });
        fileScroll.setViewportView(fileTree);

        browserSplitPane.setBottomComponent(fileScroll);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 10);
        add(browserSplitPane, gridBagConstraints);

        deleteButton.setText("delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(deleteButton, gridBagConstraints);

        copyButton.setText("copy");
        copyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        add(copyButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void loadButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadButtonMouseClicked
        if (!tree.isSelectionEmpty()) {
            File file = (File) selectedObject;
            if (file != null) {
                tools.loadFileToNewGrid(file);
            }
        }
    }//GEN-LAST:event_loadButtonMouseClicked

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (tools.queue().get("file") == null) {
//            tools.queue.setCount();
            tools.saveSeq(tools.queue().getName());
            updateTree();
        } else {
            tools.saveSeq((File) tools.queue().get("file"));
        }
//        jTree1.setSelectedValue(name, true);

}//GEN-LAST:event_saveButtonActionPerformed

    private void autoLoadBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_autoLoadBoxStateChanged
    }//GEN-LAST:event_autoLoadBoxStateChanged

    private void autoLoadBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_autoLoadBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            autoLoad = true;
        } else {
            autoLoad = false;
        }

    }//GEN-LAST:event_autoLoadBoxItemStateChanged

    private void newQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newQueueActionPerformed
        tools.newQueue();
}//GEN-LAST:event_newQueueActionPerformed

    private void fileTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileTreeMouseClicked
        if (evt.getClickCount() == 2 && selectedNode != null && selectedNode.isLeaf()) {
            tools.loadFileToNewGrid(selectedFile);
        }
    }//GEN-LAST:event_fileTreeMouseClicked

    private void fileTreeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fileTreeKeyTyped
    }//GEN-LAST:event_fileTreeKeyTyped

    private void fileTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_fileTreeValueChanged
        if (evt.getNewLeadSelectionPath() != null) {
            treeValueChanged();
            if ((selectedFile = (File) selectedObject) != null) {
                if (autoLoad) {
                    tools.loadFileToNewGrid(selectedFile);
                }
            }
        }
    }//GEN-LAST:event_fileTreeValueChanged

    private void fileTreeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileTreeMouseDragged
    }//GEN-LAST:event_fileTreeMouseDragged

    private void folderTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_folderTreeMouseClicked
    }//GEN-LAST:event_folderTreeMouseClicked

    private void folderTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_folderTreeValueChanged
        currentFolderPath = evt.getPath().getLastPathComponent().toString().split(Pattern.quote(File.separator));
        this.updateTree();
    }//GEN-LAST:event_folderTreeValueChanged

    private void folderTreeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_folderTreeMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_folderTreeMouseDragged

    private void folderTreeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_folderTreeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_folderTreeKeyTyped

    private void fileTreeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileTreeMousePressed
        tools.ctrlPressed = evt.isControlDown();
    }//GEN-LAST:event_fileTreeMousePressed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        deleteMarked();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void copyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonActionPerformed
        copyMarked();
    }//GEN-LAST:event_copyButtonActionPerformed

    private void fileTreeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fileTreeKeyPressed
        if (fileTree.getSelectionPaths() != null) {
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_ENTER:
                    setSelected((ElementNode) fileTree.getSelectionPath().getLastPathComponent());
                    break;
                case KeyEvent.VK_DELETE:
                    deleteMarked();
                    break;
                case KeyEvent.VK_C:
                    if (evt.isControlDown()) {
                        copyMarked();
                    }
                    break;
            }
        }
    }//GEN-LAST:event_fileTreeKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox autoLoadBox;
    private javax.swing.JSplitPane browserSplitPane;
    private javax.swing.JButton copyButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane fileScroll;
    public javax.swing.JTree fileTree;
    private javax.swing.JScrollPane folderScroll;
    public javax.swing.JTree folderTree;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton newQueue;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
