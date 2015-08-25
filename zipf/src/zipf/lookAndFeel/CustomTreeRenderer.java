package zipf.lookAndFeel;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class CustomTreeRenderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component c = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        c.setBackground(Colors.CONDITION_LIGHT_BACKGORUND);
        this.setBackgroundNonSelectionColor(Colors.CONDITION_LIGHT_BACKGORUND);
        this.setBackgroundSelectionColor(Colors.CONDITION_BACKGROUND);
        this.setClosedIcon(new ImageIcon(new byte[]{}));
        this.setOpenIcon(new ImageIcon(new byte[]{}));
        this.setIcon(new ImageIcon(new byte[]{}));
        return c;
    }
}
