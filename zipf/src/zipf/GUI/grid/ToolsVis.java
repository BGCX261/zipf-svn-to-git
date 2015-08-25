package zipf.GUI.grid;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLayeredPane;
import zipf.GUI.vis.Vis;
import zipf.GUI.vis.VisPanel;
import zipf.event.Event;

public abstract class ToolsVis extends ToolsMoveVis {

    public ToolsVis() {
    }

    public ToolsVis(GridEdit edit, int ch) {
        super(edit, ch);
    }

    public void addToUI(Vis vis) {
        vis.updateBounds();
        viss.add(vis);
        editPane.add(vis, JLayeredPane.MODAL_LAYER);
    }

    public void visDragged(VisPanel vis, MouseEvent evt) {

// <editor-fold defaultstate="collapsed" desc="painting">
        if (evt.isAltDown() && evt.isShiftDown()) {
            if (!focused.contains(vis)) {
                singleFocusOn((Vis) vis);
            }
            if (focused.contains(vis)) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ToolsVis.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<Vis> list = (ArrayList<Vis>) focused.clone();
                for (Vis focVis : list) {
                    Vis copy = copyVis(focVis);
                    addToFocused(copy);
                    removeFromFocused(focVis);
                    System.out.println(focused);
                }
            }
        }// </editor-fold>
        moveFocusedOnGrid();
    }

    public void visMousePressed(VisPanel vis, MouseEvent evt) {
        lastClickRight = evt.getButton() == MouseEvent.BUTTON3;
        if (lastClickRight) {
            removeVis((Vis) vis);
            focused.remove(vis);
        }
        if (!focused.contains(vis)) {
            singleFocusOn((Vis) vis);
        }
        setMoveRoot((Vis) vis);
        if (evt.isControlDown()) {
            ArrayList<Vis> list = (ArrayList<Vis>) focused.clone();
            for (Vis focVis : list) {
                Vis copy = copyVis(focVis);
                addToFocused(copy);
                removeFromFocused(focVis);
                if (focVis == vis) {
                    copy.dragPoint = movedVis.dragPoint;
                    movedVis = copy;
                }
            }
        }
    }

    public void visMouseReleased(VisPanel vis, MouseEvent evt) {
        vis.dragPoint = null;
        movedVis = null;
    }

    public void visMouseClicked(VisPanel vis, MouseEvent evt) {
        if (!evt.isControlDown()) {
            focusedClear();
        }
        addToFocused((Vis) vis);
    }

    @Override
    public void gridDragged() {
        tableMouseDragged = true;
    }

    @Override
    public void gridReleased() {
        tableMouseDragged = false;
    }

    public void addRule(Event event) {
        edit.switchTo(Grid.CONDITIONS);
        edit.editConditions.panelCondition.newElementRule(event);
    }
}
