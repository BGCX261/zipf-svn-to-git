package zipf.GUI;

import zipf.GUI.grid.ToolsVis;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import zipf.GUI.Zipf;
import zipf.GUI.grid.Grid;

public class KeyInput {

    public void setActions(JPanel panel, final ToolsVis tools) {


        panel.getInputMap(1).put(KeyStroke.getKeyStroke("DELETE"),
                "deleteFocused");
        panel.getActionMap().put("deleteFocused", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tools.deleteFocused();
            }
        });
        panel.getInputMap(1).put(KeyStroke.getKeyStroke("L"),
                "test");
        panel.getActionMap().put("test", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        panel.getInputMap(1).put(KeyStroke.getKeyStroke("LEFT"),
                "moveLeft");
        panel.getActionMap().put("moveLeft", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tools.moveFocusedOnGrid(new Point(-1, 0));
            }
        });
        panel.getInputMap(1).put(KeyStroke.getKeyStroke("RIGHT"),
                "moveRight");
        panel.getActionMap().put("moveRight", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tools.moveFocusedOnGrid(new Point(1, 0));
            }
        });
        panel.getInputMap(1).put(KeyStroke.getKeyStroke("UP"),
                "moveUp");
        panel.getActionMap().put("moveUp", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tools.moveFocusedOnGrid(new Point(0, -1));
            }
        });
        panel.getInputMap(1).put(KeyStroke.getKeyStroke("DOWN"),
                "moveDown");
        panel.getActionMap().put("moveDown", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tools.moveFocusedOnGrid(new Point(0, 1));
            }
        });
    }

//
//    public static void setNotesActions(final EditNotes panel) {
//        panel.getInputMap(2).put(KeyStroke.getKeyStroke("DELETE"),
//                "deleteFocused");
//        panel.getActionMap().put("deleteFocused", new AbstractAction() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Zipf.noteTools.clearFocused();
//            }
//        });
//        panel.getInputMap(2).put(KeyStroke.getKeyStroke("LEFT"),
//                "moveLeft");
//        panel.getActionMap().put("moveLeft", new AbstractAction() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Zipf.noteTools.moveFocusedOnGrid(new Point(-1, 0));
//            }
//        });
//        panel.getInputMap(2).put(KeyStroke.getKeyStroke("RIGHT"),
//                "moveRight");
//        panel.getActionMap().put("moveRight", new AbstractAction() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Zipf.noteTools.moveFocusedOnGrid(new Point(1, 0));
//            }
//        });
//        panel.getInputMap(2).put(KeyStroke.getKeyStroke("UP"),
//                "moveUp");
//        panel.getActionMap().put("moveUp", new AbstractAction() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Zipf.noteTools.moveFocusedOnGrid(new Point(0, -1));
//            }
//        });
//        panel.getInputMap(2).put(KeyStroke.getKeyStroke("DOWN"),
//                "moveDown");
//        panel.getActionMap().put("moveDown", new AbstractAction() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Zipf.noteTools.moveFocusedOnGrid(new Point(0, 1));
//            }
//        });
//    }
}
