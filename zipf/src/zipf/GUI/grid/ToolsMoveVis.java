package zipf.GUI.grid;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import zipf.GUI.table.VolumeModel;
import zipf.GUI.vis.Vis;
import zipf.GUI.vis.VisNote;
import zipf.GUI.vis.VisPanel;
import zipf.GUI.vis.VisSeq;
import zipf.event.Event;
import zipf.event.Note;

public abstract class ToolsMoveVis extends GridTable {

    private Timer timer;
    boolean copied;
    TimerTask task;
// <editor-fold defaultstate="collapsed" desc="vars...">
    public int capacityX;
    public int gridFactor = 2;
    public VisPanel dragThing = null;
    public boolean tableMouseDragged;
    public ArrayList<Vis> focused = new ArrayList<Vis>();
    VisPanel movedVis;
    Point visDragPoint;
// </editor-fold>

    public ToolsMoveVis(GridEdit edit, int ch) {
        super(edit, ch);
    }

    public ToolsMoveVis() {
    }

    public void setMoveRoot(VisPanel vis) {
        vis.dragPoint = vis.getMousePosition();
        visDragPoint = quantizeCoordinates(vis.getMousePosition());
        movedVis = vis;
    }

    public Point checkVisCoordinateChange() {
        setMoveRoot();
        if (movedVis != null) {
            Point p = quantizeCoordinates(movedVis.getLocation());
            if (moveRoot != null && p != null && visDragPoint != null) {
                p.x += visDragPoint.x;
                Point p2 = new Point(moveRoot.x - p.x, moveRoot.y - p.y);
                return p2;
            }
        }
        return null;
    }

    public Point checkCoordinateChange() {
        Point p = quantizeCoordinates(editPane.getMousePosition());
        if (moveRoot != null && p != null) {
            Point p2 = new Point(p.x - moveRoot.x, p.y - moveRoot.y);
            moveRoot = p;
            return p2;
        }
        return null;
    }

    private void updateFocusedBounds() {
        if (focused != null) {
            for (Vis vis : focused) {
                vis.updateBounds();
            }
        }
    }

    public void moveFocusedOnGrid() {
        Point p2 = checkVisCoordinateChange();
        if (p2 != null || movedVis == null) {
            if (timer != null) {
                timer.cancel();
                timer = null;
            }
            moveFocusedOnGrid(p2);
        } else if (timer == null) {
            timer = new Timer();
            task = new MoveTask(scrollLoop.getLocationOnScreen(), scrollLoop.getSize(), this);
            timer.scheduleAtFixedRate(task, 0, 100);
        }
    }

    public void moveFocusedOnGrid(Point p) {
        if (p != null) {
            if (p.x != 0 && !isXBumping(p.x)) {
                moveFocusedX(p.x);
                updateFocusedBounds();
            }
            if (p.y != 0 && !isYBumping(p.y)) {
                moveFocusedY(p.y);
                updateFocusedBounds();
            }
        }
    }

    public void moveFocusedX(int x) {
        for (Vis vis : focused) {
            vis.setPosition(vis.position() + x);
        }
        if (movedVis != null) {
            Rectangle rec = movedVis.getBounds();
            rec.x += movedVis.dragPoint.x;
            rec.width = 20;
            rec.grow((int) ((float) 1 * cw()), 1 * ch);
            editPane.scrollRectToVisible(rec);
        }
    }

    public void moveFocusedY(int y) {
        for (Vis vis : focused) {
            int y2 = vis.Y() + y;
            vis.setY(y2);
        }
        if (movedVis != null && movedVis.dragPoint != null) {
            Rectangle rec = movedVis.getBounds();
            rec.x += movedVis.dragPoint.x;
            rec.width = 20;
            rec.grow((int) ((float) 1 * cw()), 1 * ch);
            editPane.scrollRectToVisible(rec);
        }
    }

    public void removeVis(Vis vis) {
        vis.remove();
        vis.connectedEvent.remove();
        viss.remove(vis);
    }

    public void deleteFocused() {
        for (int i = 0; i < focused.size(); i++) {
            removeVis(focused.get(i));
        }
        focused.clear();
    }

    @Override
    public void updateVissBounds() {
        if (viss != null) {
            for (Vis vis : viss) {
                vis.updateBounds();
            }
        }
    }

    public boolean isXBumping(int i) {
        boolean bumpTop = false;
        boolean bumpBottom = false;
        for (Vis vis : focused) {
            if (!bumpTop) {
                bumpTop = queue().longValue(vis.position() + i) > queue().getDuration();
            }
            if (!bumpBottom) {
                bumpBottom = vis.position() + i < 0;
            }
        }
        return bumpTop || bumpBottom;
    }

    public boolean isYBumping(int i) {
        boolean bumpTop = false;
        boolean bumpBottom = false;
        for (Vis vis : focused) {
            if (!bumpTop) {
                bumpTop = vis.Y() + i < 0;
            }
            if (!bumpBottom) {
                bumpBottom = vis.Y() + i > rows() - 1;
            }
        }
        return bumpTop || bumpBottom;
    }

    public void focusedClear() {
        for (Vis vis : focused) {
            vis.setBackground(Vis.INIT);
            if (vis instanceof VisNote) {
                ((Note) vis.connectedEvent).unMark();
            }
        }
        focused.clear();
    }

    public void singleFocusOn(Vis vis) {
        focusedClear();
        addToFocused(vis);
    }

    public void addToFocused(Vis vis) {
        vis.grabFocus();
        if (!focused.contains(vis)) {
            focused.add(vis);
            vis.setBackground(Vis.FOCUSED);
            if (vis instanceof VisNote) {
                ((Note) vis.connectedEvent).mark();
            }
        }
    }

    public void markItems(Rectangle rec) {
        if (tableMouseDragged) {
            for (Vis vis : viss) {
                if (javax.swing.SwingUtilities.isRectangleContainingRectangle(rec, vis.getBounds())) {
                    addToFocused(vis);
                } else {
                    removeFromFocused(vis);
                }
            }
        }
    }

    public void removeFromFocused(Vis vis) {
        vis.setBackground(Vis.INIT);
        focused.remove(vis);
        if (vis instanceof VisNote) {
            ((Note) vis.connectedEvent).unMark();
        }
    }

    private static class MoveTask extends TimerTask {

        private final Point gridPosition;
        private final Dimension gridDimension;
        private final ToolsMoveVis tools;

        public MoveTask(Point gridPosition, Dimension gridDimension, ToolsMoveVis tools) {
            this.gridPosition = gridPosition;
            this.gridDimension = gridDimension;
            this.tools = tools;
        }

        @Override
        public void run() {
            tools.setMoveRoot();
            if (tools.moveRoot != null || tools.movedVis == null) {
                this.cancel();
                tools.timer = null;
            }
            Point p = MouseInfo.getPointerInfo().getLocation();
            if (p.y < gridPosition.y) {
                tools.moveFocusedOnGrid(new Point(0, -1));
                return;
            }
            if (p.y > (gridPosition.y + gridDimension.height)) {
                tools.moveFocusedOnGrid(new Point(0, 1));
                return;
            }
            if (p.x < gridPosition.x) {
                tools.moveFocusedOnGrid(new Point(-1, 0));
                return;
            }
            if (p.x > (gridPosition.x + gridDimension.width)) {
                tools.moveFocusedOnGrid(new Point(1, 0));
                return;
            }


            if (tools.moveRoot != null || tools.movedVis == null) {
                this.cancel();
                tools.timer = null;
//            return;
            }
        }
    }

    public Vis copyVis(Vis vis) {
        Event event = vis.connectedEvent.copy();
        event.eventVis = null;
        event.initUI();
        return event.eventVis;
    }
}
