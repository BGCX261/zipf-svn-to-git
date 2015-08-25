package zipf.GUI.tree;

import java.awt.Dimension;
import java.lang.reflect.Method;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import zipf.GUI.condition.TreeSide;
import zipf.GUI.condition.ConTainer;
import zipf.GUI.condition.TreeSides;
import zipf.event.conditions.DefaultRuleItem;
import zipf.event.conditions.Invokable;
import zipf.event.interfaces.Routable;

public class ToolsRuleItem extends ToolsTree {

    public DefaultRuleItem ruleItem;
    public int layer = JLayeredPane.MODAL_LAYER;
    public TreeSide thisSide;
    public TreeSide otherSide;
    public JToggleButton treeButton;
    public JTextField inputBox;
    public ConTainer conPanels;
    public Object value;
    public Object[] path;
    TreeSides treeSides;
    int index;

    public void growPanel(int i, JPanel panel) {
        panel.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight() + i));
    }

    public Class getClassInPath() {
        for (int i = path.length - 1; i >= 0; i--) {
            if (path[i] instanceof Class) {
                return (Class) path[i];
            }
        }
        return null;
    }

    public Object getInPath(Class clazz) {
        for (int i = path.length - 1; i >= 0; i--) {
            if (clazz.isInstance(path[i])) {
                return path[i];
            }
        }
        return null;
    }

    public Method getMethodInPath() {
        for (int i = path.length - 1; i >= 0; i--) {
            if (path[i] instanceof Method) {
                return (Method) path[i];
            }
        }
        return null;
    }

    public Routable getRoutableInPath() {
        for (int i = path.length - 1; i >= 0; i--) {
            if (path[i] instanceof Routable) {
                return (Routable) path[i];
            }
        }
        return null;
    }

    public Invokable getMethodableInPath() {
        for (int i = path.length - 1; i >= 0; i--) {
            if (path[i] instanceof Invokable) {
                return (Invokable) path[i];
            }
        }
        return null;
    }
}
