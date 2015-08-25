package zipf.GUI.vis;

import java.awt.Point;
import zipf.GUI.grid.GridSeq;
import zipf.GUI.CurrentItems;
import zipf.GUI.PanelCondition;
import zipf.GUI.grid.GridTools;
import zipf.GUI.grid.ToolsBar;
import zipf.event.NoteSeq;
import zipf.event.Seq;
import zipf.event.Song;

public class VisSeq extends VisBar<Seq> {

    public VisSeq(ToolsBar tools, Seq seq) {
        super(tools, seq);
        initComponents();
        title.setText(((Seq) connectedEvent).getName());
        tools.addToUI(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seqPopup = new javax.swing.JPopupMenu();
        addRule = new javax.swing.JMenuItem();
        anotherThing = new javax.swing.JMenuItem();
        title = new javax.swing.JLabel();

        addRule.setText("add Rule...");
        addRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRuleActionPerformed(evt);
            }
        });
        seqPopup.add(addRule);

        anotherThing.setText("jMenuItem2");
        seqPopup.add(anotherThing);

        setBackground(new java.awt.Color(51, 153, 0));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setAlignmentX(0.9F);
        setAlignmentY(0.1F);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(true);
        setPreferredSize(new java.awt.Dimension(30, 10));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        title.setFont(new java.awt.Font("Tahoma", 1, 18));
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("title");
        title.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titleMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                titleMouseReleased(evt);
            }
        });
        title.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titleMouseDragged(evt);
            }
        });
        add(title, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void titleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMouseDragged
        tools.visDragged(this, evt);
    }//GEN-LAST:event_titleMouseDragged

    private void titleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMousePressed
        if (evt.isPopupTrigger()) {
            seqPopup.show(this, 20, 0);
        }
        tools.visMousePressed(this, evt);
    }//GEN-LAST:event_titleMousePressed

    private void titleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMouseReleased
        if (evt.isPopupTrigger()) {
            seqPopup.show(this, 20, 20);
        }
    }//GEN-LAST:event_titleMouseReleased

    private void addRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRuleActionPerformed
        tools.addRule(connectedEvent);
    }//GEN-LAST:event_addRuleActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addRule;
    private javax.swing.JMenuItem anotherThing;
    private javax.swing.JPopupMenu seqPopup;
    public javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

    @Override
    public int Y() {
        if (tools.queue() instanceof NoteSeq) {
            return invert(((NoteSeq) connectedEvent).getY());
        } else {
            return ((NoteSeq) connectedEvent).getTrackNumber();
        }
    }

    @Override
    public void setY(int y) {
        if (tools.queue() instanceof NoteSeq) {
            ((NoteSeq) connectedEvent).setY(invert(y));
        } else {
            ((NoteSeq) connectedEvent).setTrackNumber(y);
        }
    }

    @Override
    public void remove() {
        tools.queue().Midi.send(connectedEvent.offNote.getMessage());
        super.remove();
    }
}
/*
 * TODO title set seqName, SongName, ruleObject..
 */
