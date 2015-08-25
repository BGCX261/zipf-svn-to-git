package zipf.GUI.tree;

import zipf.GUI.condition.RuleTrees;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import zipf.GUI.PanelCondition;
import zipf.GUI.condition.ConAbstract;
import zipf.GUI.condition.ConPanel;
import zipf.GUI.condition.ConSetContainer;
import zipf.GUI.condition.ConSetPanel;
import zipf.GUI.condition.RuleItemContainer;
import zipf.GUI.condition.TreeSides;
import zipf.GUI.grid.ToolsPanel;
import zipf.event.conditions.DefaultChainable;
import zipf.event.conditions.Chainable;
import zipf.event.conditions.ConditionSet;
import zipf.event.conditions.DefaultRuleItem;
import zipf.event.conditions.RuleItemSet;
import zipf.event.interfaces.Routable;
import zipf.libraries.ToolsNode;

public class ToolsToggle extends ToolsRuleItem implements Serializable {

    int itemHeight = 66;
    Integer moveStart;
    public static Routable currentObject;
    public static RuleTrees ruleTrees = new RuleTrees();

    public void addTreeToPanel() {
        thisSide.add(this, index);
        ToolsPanel.setFixedBounds(this, 450, 60);
        setRulePanelSize();
    }

    public void openTree() {
        if (thisSide.openTree != null && thisSide.openTree != this) {
            thisSide.openTree.closeTree();
        }
        thisSide.openTree = (ToggleTree) this;
        ToolsPanel.setFixedBounds(this, 450, treeHeight + 66);
        setRulePanelSize();
        visualizeTree();
    }

    public void closeTree() {
        thisSide.openTree = null;
        ToolsPanel.setFixedBounds(this, 450, 60);
        setRulePanelSize();
    }

    public String setTreeButtonText() {
        String str = "";
        if (tree.getSelectionPath() != null) {
            if (getClassInPath() != null) {
                str += "    " + ToolsNode.name(getClassInPath());
            }
            if (getMethodInPath() != null) {
                str += "    " + ToolsNode.name(getMethodInPath());
            }
            if (getMethodableInPath() != null) {
                str += "    " + getMethodableInPath();
            }
            if (getMethodableInPath() != null) {
                str += " >>>" + getMethodableInPath();
            }
            treeButton.setText(str);
        }
        return str;
    }

    @Override
    public void treeValueChanged() {
        if (tree.getSelectionPath() != null) {
            selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
            selectedObject = selectedNode.getUserObject();
            path = selectedNode.getUserObjectPath();
        }
        setTreeButtonText();
        setTextInput();
    }

    public void treeMouseClicked(MouseEvent evt, JPanel ttree) {
        if (evt.getClickCount() == 2 && selectedNode.isLeaf()) {
            treeButton.setSelected(true);
            closeTree();
        }
    }

    public void setTextInput() {
        if ((selectedObject instanceof Chainable)) {
            inputBox.setEnabled(true);
            inputBox.setOpaque(true);
            inputBox.requestFocus();
            inputBox.revalidate();
        } else {
            inputBox.setEnabled(false);
            inputBox.setOpaque(false);
        }
    }

    private void visualizeTree() {
        Rectangle rec = tree.getBounds();
        rec.setBounds(0, rec.y + treeSides.getY(), 100, 100);
        treeSides.scrollRectToVisible(rec);
    }

    void initTree() {
    }

    public void addTree() {
        this.addTree(ToolsToggle.currentObject);
    }

    public void addTree(Routable current) {
    }

    public void setRulePanelSize() {
        ToolsPanel.setAutoHeight(thisSide, 450);
        ToolsPanel.setAutoHeight(otherSide, 450);
        int thisSideH = ToolsPanel.getAutoHeight(thisSide);
        int otherSideH = ToolsPanel.getAutoHeight(otherSide);
        int i = (thisSideH < otherSideH) ? otherSideH : thisSideH;
        if (i != 0) {
            ToolsPanel.setFixedHeight(treeSides, i + 30);
        }
        ToolsPanel.setFixedHeight(treeSides.panelCondition.screenPanel, ToolsPanel.getAutoHeight(treeSides.panelCondition.screenPanel)+treeHeight+64);
        treeSides.panelCondition.screenPanel.revalidate();
    }

    public void removeToggleTree() {
        if (this.getParent().getComponentCount() > 1) {
            this.getParent().remove(this);
            if (this.getHeight() > treeHeight) {
                thisSide.openTree = null;
            }
        }
        if (ruleItem != null) {
            ((Chainable) ruleItem).remove();
        }
        setRulePanelSize();
    }

    public void removeRuleItemPanel(ConAbstract vPanel) {
        vPanel.chainable.remove();
        vPanel.getParent().remove(vPanel);
        conPanels.updateUI();
    }

    public void setPoint() {
        if (conPanels.getMousePosition() != null) {
            moveStart = conPanels.getMousePosition().y;
        }
    }

    public Integer checkCoordinateChange(Integer y) {
        if (y != null) {
            Integer y2 = y / 30;
            if (moveStart != null && !(moveStart.equals(y2))) {
                moveStart = y2;
                return y2;
            }
        }
        return null;

    }

    public void setSpacer(RuleItemContainer container, int layer) {
        layer++;
        for (Component component : ((JPanel) container).getComponents()) {
            JPanel panel = (JPanel) component;
            if (panel instanceof ConSetContainer) {
                ((ConAbstract) panel).setSpacer(layer);
                setSpacer((RuleItemContainer) panel, layer);
            }
            ConAbstract conPanel = (ConAbstract) panel;
            conPanel.setOperatorsVisible(hasLogicalPart(conPanel));
        }
        conPanels.updateUI();
    }

    public void itemDragged(ConAbstract dragPanel) {
        if (conPanels.getMousePosition() == null) {
            return;
        }
        JPanel dragContainer = (JPanel) dragPanel.getParent();

        ConAbstract currentPanel = getCurrentPanel();

        if ((currentPanel == null) || (currentPanel == dragPanel)) {
            return;
        }

        JPanel currentContainer = (JPanel) currentPanel.getParent();

        if (dragPanel instanceof ConSetPanel) {
            if (currentPanel instanceof ConSetPanel) {
                return;
            }
            if (currentContainer == dragContainer) {
                dragPanel = (ConAbstract) dragPanel.getParent();
                dragContainer = (JPanel) dragPanel.getParent();
                int dragIndex = (dragPanel.getIndex() + 1);
                while (dragContainer.getComponentCount() - 1 < dragIndex) {
                    if (dragContainer.getParent() instanceof ConAbstract) {
                        dragIndex = ((ConAbstract) dragContainer).getIndex() + 1;
                        dragContainer = (JPanel) dragContainer.getParent();
                    } else {
                        return;
                    }
                }
                currentPanel = (ConAbstract) dragContainer.getComponent(dragIndex);
                currentContainer = dragContainer;

            } else if (currentContainer != dragContainer) {
                dragPanel = (ConAbstract) dragPanel.getParent();
                dragContainer = (JPanel) dragPanel.getParent();
            }
        }
        if (currentContainer != dragPanel && (currentContainer.getParent() != dragPanel)) {
            int currentIndex = currentPanel.getIndex();
            if (currentPanel instanceof ConSetPanel) {
                currentIndex++;
            }

            changePosition(currentContainer, currentIndex, dragPanel);
        }
    }

    void changePosition(JPanel currentContainer, int currentIndex, ConAbstract dragPanel) {
        if (currentContainer instanceof ConSetContainer && ((ConSetContainer) currentContainer).defaultConSetPanel.collapsed) {
            ((ConSetContainer) currentContainer).defaultConSetPanel.expandConSet();
        }
        Chainable chainable = dragPanel.chainable;
        RuleItemSet ruleItemSet = ((ConAbstract) currentContainer).getSet();
        int itemIndex = currentIndex;
        if (currentContainer instanceof ConSetContainer) {
            itemIndex--;
        }
        ruleItemSet.setIndex(itemIndex, (DefaultChainable) chainable);
        currentContainer.add(dragPanel, currentIndex);
        currentContainer.updateUI();
        setSpacer(conPanels, -1);
        conPanels.updateUI();
    }

    public boolean hasLogicalPart(ConAbstract con) {
        if (con instanceof ConSetPanel) {
            con = (ConAbstract) con.getParent();
        }
        List list = ((RuleItemSet) ((ConAbstract) con.getParent()).chainable).getRuleItems();
        return !(list.indexOf(con.chainable) == list.size() - 1);
    }

    public void createConSetPanel(ConAbstract panel) {
        ConditionSet conditionSet = new ConditionSet();
        thisSide.set.addRuleItem(conditionSet);
        ConSetContainer conSet = new ConSetContainer();
        conSet.chainable = conditionSet;
        conSet.ttools = this;
        conSet.defaultConSetPanel.ttools = this;
        changePosition((JPanel) panel.getParent(), panel.getIndex() + 1, conSet);
        conPanels.updateUI();
        conSet.scrollRectToVisible(conSet.getBounds());
    }

    public void saveRuleItem() {
        ruleItem = (DefaultRuleItem) getInPath(DefaultRuleItem.class);
        ruleItem = (DefaultRuleItem) ruleItem.clone();
        setValue();
        ConPanel conPanel = new ConPanel();
        conPanel.ttools = (ToolsToggle) this;
        conPanel.treePath = tree.getSelectionPath();
        conPanel.chainable = ruleItem;
        conPanel.label.setText(ToolsNode.name(ruleItem.itemClass) + "." + ruleItem);
        if (ruleItem.getValue() != null) {
            conPanel.inputBoxSmall.setText(ruleItem.getValue().toString());
        }
        changePosition(conPanels, conPanels.getComponentCount(), conPanel);
        inputBox.setSelectionStart(0);
        inputBox.setSelectionEnd(inputBox.getText().length());
    }

    void setValue() {
        Class returnClass = ruleItem.getReturnType();
        Scanner scanner = new Scanner(inputBox.getText());
        Object o = getInPath(returnClass);
        if (o == null) {
            if (scanner.hasNext()) {
                if (returnClass == int.class) {
                    o = scanner.nextInt();
                } else if (returnClass == long.class) {
                    o = scanner.nextLong();
                } else if (returnClass == void.class) {
                    o = scanner.nextInt();
                }
            }
            ruleItem.setValue(o);
        }
    }

    private ConAbstract getCurrentPanel() {
        JPanel panelsTmp = conPanels;
        while (panelsTmp instanceof RuleItemContainer) {
            Point p = panelsTmp.getMousePosition();
            if (p == null) {
                return null;
            }
            panelsTmp = (JPanel) panelsTmp.getComponentAt(p);
        }
        if (panelsTmp instanceof ConAbstract) {
            return (ConAbstract) panelsTmp;
        }
        return null;
    }
}
