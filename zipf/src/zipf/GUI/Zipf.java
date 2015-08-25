package zipf.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import zipf.GUI.grid.GridSeq;
import zipf.GUI.grid.GridNote;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import zipf.GUI.grid.ToolsVis;
import zipf.IO.KeyboardPiano;
import zipf.event.Note;
import zipf.event.NoteSeq;
import zipf.event.Song;
import zipf.event.zTimer;
import zipf.lookAndFeel.Designer;
import zipf.lookAndFeel.Colors;

public class Zipf extends javax.swing.JFrame {

    static zTimer timer = new zTimer();
    MenuTools menutools = new MenuTools(this);

    public Zipf() {
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
        ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);
        Initializer.loadProps();
        UIManager.put("controlShadow", Color.red);
        UIManager.put("controlDkShadow", Colors.SHADE_GRAY);
        UIManager.put("ScrollBar.track", Colors.CONDITION_LIGHT_BACKGORUND);
        UIManager.put("ScrollBar.trackHighLight", Colors.CONDITION_LIGHT_BACKGORUND);
        UIManager.put("ScrollBar.background", Colors.CONDITION_LIGHT_BACKGORUND);
        UIManager.put("ScrollBar.background", Colors.CONDITION_LIGHT_BACKGORUND);
        UIManager.put("TabbedPane.background", Colors.CONDITION_BACKGROUND);
        UIManager.put("TabbedPane.darkShadow", Colors.CONDITION_BACKGROUND);
        UIManager.put("TabbedPane.highlight", Colors.CONDITION_BACKGROUND);
        UIManager.put("TabbedPane.shadow", Colors.CONDITION_BACKGROUND);
        UIManager.put("TabbedPane.light", Colors.CONDITION_BACKGROUND);
        UIManager.put("TabbedPane.focus", Colors.CONDITION_BACKGROUND);
        UIManager.put("TabbedPane.contentAreaColor", Colors.TAB_BACKGROUND);
        UIManager.put("control", Color.red);
        UIManager.put("window", Color.red);
        UIManager.put("desktop", Color.red);
        UIManager.put("control", Color.red);
        UIManager.put("SplitPaneDivider.draggingColor", Colors.DARK_BORDER);
        initComponents();
        Initializer.getMidiDevices();


//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        Thread.sleep(500);
//                        System.out.println(" tempo : " + editMain.editNotes.mainQueue.getTempo());
//                        System.out.println(editMain.editNotes.queue().getTempo());
//                        //                        Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
////                        System.out.println(comp.getClass().getSimpleName());
////                        Window window =
////                                KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusedWindow();
//////                        System.out.println(window.getClass().getSimpleName());
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(Zipf.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        }).start();
////
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Zipf.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            Logger.getLogger(Zipf.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(Zipf.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(Zipf.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputGroup = new javax.swing.ButtonGroup();
        outputGroup = new javax.swing.ButtonGroup();
        editMain = new zipf.GUI.EditMain();
        lämpchen = new javax.swing.JPanel();
        menu = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        settings = new javax.swing.JMenu();
        input = new javax.swing.JMenu();
        output = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("z i p f");
        setBackground(new java.awt.Color(102, 102, 0));
        setBounds(new Rectangle((Toolkit.getDefaultToolkit().getScreenSize().width/2)-600,20,800,600));
        setMinimumSize(new java.awt.Dimension(1235, 770));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        editMain.setBackground(Colors.CONDITION_LIGHT_BACKGORUND);
        editMain.setMinimumSize(new java.awt.Dimension(1100, 542));
        getContentPane().add(editMain, java.awt.BorderLayout.CENTER);

        lämpchen.setBackground(new java.awt.Color(0, 0, 153));
        lämpchen.setMaximumSize(new java.awt.Dimension(321321321, 1));
        lämpchen.setMinimumSize(new java.awt.Dimension(10, 1));
        lämpchen.setPreferredSize(new java.awt.Dimension(10, 1));
        lämpchen.setRequestFocusEnabled(false);
        getContentPane().add(lämpchen, java.awt.BorderLayout.PAGE_START);

        menu.setBackground(Colors.CONDITION_BACKGROUND);
        menu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 1, true));

        file.setText("File");

        jMenuItem1.setText("load");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        file.add(jMenuItem1);

        menu.add(file);

        edit.setText("Edit");
        menu.add(edit);

        settings.setText("Settings");

        input.setText("input");
        settings.add(input);

        output.setText("output");
        settings.add(output);

        menu.add(settings);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    }//GEN-LAST:event_formKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        menutools.showFileChooser();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {


                new Zipf().setVisible(true);
            }
        });

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(300000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Zipf.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            }
        }).start();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu edit;
    public static zipf.GUI.EditMain editMain;
    private javax.swing.JMenu file;
    public static javax.swing.JMenu input;
    public static javax.swing.ButtonGroup inputGroup;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JPanel lämpchen;
    private javax.swing.JMenuBar menu;
    public static javax.swing.JMenu output;
    public static javax.swing.ButtonGroup outputGroup;
    public static javax.swing.JMenu settings;
    // End of variables declaration//GEN-END:variables

    public JMenu getOutput() {
        return output;
    }

    public ButtonGroup getOutputGroup() {
        return outputGroup;
    }
    // End of variables declaration

    public JMenu getInput() {
        return input;
    }

    public ButtonGroup getInputGroup() {
        return inputGroup;
    }
}
