package zipf.event.pending;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultTreeModel;
import zipf.libraries.ElementNode;

public class TreeLoader {

    ElementNode root;
    ElementNode lastNode = root;
    int depth = 1;
    int virtualDepth;
    String str = "";
    LinkedList<ElementNode> path = new LinkedList<ElementNode>();

    private TreeLoader(int depth) {
        this.virtualDepth = depth;
    }

    TreeLoader() {
    }

    void pathUp() {

        path.add(depth, root);
        depth++;
        root = lastNode;
//        System.out.println("pathup to: " + root + "  " );
    }

    void pathDown() {
        path.removeLast();
        depth--;
        root = path.getLast();
//        System.out.println("pathdown to: " + root);
    }

    public DefaultTreeModel getTree(String path) {
        return new DefaultTreeModel(loadTree(new File(path)));
    }

    public ElementNode loadTree(String str) {
        return loadTree(new File(str));
    }

    public ElementNode loadTree(File file) {
//        System.out.println(depth + virtualDepth);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            root = new ElementNode(br.readLine());
            path.add(root);
            while ((str = br.readLine()) != null) {
//                System.out.println("-" + str + "-" + "  root:" + root);
                if (emptyChar(depth)) {
                    pathUp();
                    addNextNode();
                } else if (!Character.isWhitespace(str.charAt(0)) || (emptyChar(depth - 1) && !emptyChar(depth))) {
                    addNextNode();
                } else {
                    while (!(emptyChar(depth - 1) && !emptyChar(depth))) {
                        pathDown();
                    }
                    addNextNode();
                }
//                System.out.println(encode());
            }
//            System.out.println(model.getChildCount(root));
            return path.getFirst();


        } catch (IOException ex) {
            Logger.getLogger(TreeLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    void addNextNode() {
        if (str.contains("file:")) {
            lastNode= (new TreeLoader(depth + virtualDepth).loadTree(new File(str.split(":")[1])));
            root.add(lastNode);
//            System.out.println("add " + lastNode + " to: " + root + "    " + depth);
        return;
        }
        lastNode = new ElementNode(str.trim());
        root.add(lastNode);
//        System.out.println("add " + lastNode + " to: " + root  + "     " + depth);
    }

    private boolean emptyChar(int depth) {
        return Character.isWhitespace(str.charAt(depth));
    }

    private String encode() {
        String string = "";
        for (int i = 0; i < depth + virtualDepth; i++) {
            string += " ";
        }
        string += str.trim();
        return string;
    }
}
