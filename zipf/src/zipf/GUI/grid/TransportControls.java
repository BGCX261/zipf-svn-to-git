package zipf.GUI.grid;

import java.awt.Color;
import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Arrays;
import javax.sound.midi.Sequencer;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import zipf.GUI.CurrentItems;
import zipf.GUI.EditMain;
import zipf.GUI.Zipf;
import zipf.GUI.table.NumberInput;
import zipf.IO.KeyboardPiano;
import zipf.lookAndFeel.Designer;

public class TransportControls extends javax.swing.JPanel {

    public ToolsBar tools;
    public double dragStart;

    public TransportControls() {
        initComponents();
    }

    public TransportControls(ToolsBar vtools) {
        initComponents();
//        ButtonDesigner.design(loopButton,pauseButton,playButton,stopButton);
        this.tools = vtools;

        MouseMotionAdapter spinnerValue = new java.awt.event.MouseMotionAdapter() {

            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                float current = (float) MouseInfo.getPointerInfo().getLocation().getY();
                float diff = (float) ((float) dragStart - current);
                if (Math.abs(diff) < 5) {
                    float tempo = CurrentItems.getCurrentEdit().queue().getTempo() + (diff);
                    if (tempo > 0) {
                        jSpinner1.setValue(tempo);
                    }
                }
                dragStart = MouseInfo.getPointerInfo().getLocation().getY();
            }
        };
        ((NumberEditor) jSpinner1.getEditor()).getTextField().setHorizontalAlignment(JTextField.CENTER);
        jSpinner1.getComponents()[0].addMouseMotionListener(spinnerValue);
        jSpinner1.getComponents()[1].addMouseMotionListener(spinnerValue);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loopButton = new javax.swing.JToggleButton();
        stopButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        playButton = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        tempoLabel = new javax.swing.JLabel();
        barDiv = new javax.swing.JTextField();
        spacerSlash = new javax.swing.JLabel();
        tickDiv = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setMaximumSize(new java.awt.Dimension(1000, 80));
        setMinimumSize(new java.awt.Dimension(1000, 80));
        setPreferredSize(new java.awt.Dimension(1000, 80));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loopButton.setText("Loop");
        loopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loopButtonActionPerformed(evt);
            }
        });
        add(loopButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 70, 30));

        stopButton.setText("stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        add(stopButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 60, 30));

        pauseButton.setText("pause");
        pauseButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pauseButton.setContentAreaFilled(false);
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });
        add(pauseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 60, 30));

        playButton.setText("play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        add(playButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 340, 30));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(120.0f), Float.valueOf(30.0f), Float.valueOf(250.0f), Float.valueOf(10.0f)));
        jSpinner1.setBorder(null);
        jSpinner1.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinner1, ""));
        jSpinner1.setFocusable(false);
        jSpinner1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jSpinner1MousePressed(evt);
            }
        });
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        jSpinner1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSpinner1MouseDragged(evt);
            }
        });
        jSpinner1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spinnerKeyPressed(evt);
            }
        });
        add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 70, 30));

        tempoLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        tempoLabel.setText("Tempo:");
        add(tempoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 50, 30));

        barDiv.setDocument(new NumberInput(barDiv));
        barDiv.setFont(new java.awt.Font("Tahoma", 0, 18));
        barDiv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        barDiv.setText("4");
        barDiv.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                barDivInputMethodTextChanged(evt);
            }
        });
        barDiv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                barDivKeyPressed(evt);
            }
        });
        add(barDiv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        spacerSlash.setFont(new java.awt.Font("Tahoma", 0, 18));
        spacerSlash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        spacerSlash.setText("/");
        add(spacerSlash, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 20, 30));

        tickDiv.setDocument(new NumberInput(tickDiv));
        tickDiv.setFont(new java.awt.Font("Tahoma", 0, 18));
        tickDiv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tickDiv.setText("4");
        tickDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tickDivActionPerformed(evt);
            }
        });
        tickDiv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tickDivKeyPressed(evt);
            }
        });
        add(tickDiv, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 30));

        jToggleButton1.setText("keyboard");
        jToggleButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jToggleButton1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jToggleButton1KeyReleased(evt);
            }
        });
        add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 100, 30));

        jCheckBox1.setText("off");
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });
        add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void loopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loopButtonActionPerformed
        tools.setLoopEnabled(loopButton.isSelected());
}//GEN-LAST:event_loopButtonActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        tools.playSequence();
}//GEN-LAST:event_playButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        tools.stopSequencer();
    }//GEN-LAST:event_stopButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void jToggleButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jToggleButton1KeyPressed
        KeyboardPiano.play(evt);
    }//GEN-LAST:event_jToggleButton1KeyPressed

    private void jToggleButton1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jToggleButton1KeyReleased
        KeyboardPiano.off(evt);
    }//GEN-LAST:event_jToggleButton1KeyReleased

    private void jSpinner1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinner1MouseDragged
}//GEN-LAST:event_jSpinner1MouseDragged

    private void jSpinner1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinner1MousePressed
}//GEN-LAST:event_jSpinner1MousePressed

    private void tickDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tickDivActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_tickDivActionPerformed

    private void barDivInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_barDivInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_barDivInputMethodTextChanged

    private void barDivKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barDivKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tools.setQuarterCount();
        }
    }//GEN-LAST:event_barDivKeyPressed

    private void tickDivKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tickDivKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tools.setQuarterCount();
        }
    }//GEN-LAST:event_tickDivKeyPressed

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
        if (jCheckBox1.isSelected()) {
            tools.setQuarterDivision(true);
        } else {
            tools.setQuarterDivision(false);
        }
    }//GEN-LAST:event_jCheckBox1StateChanged

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        Number n = (Number) ((JSpinner) evt.getSource()).getValue();
        tools.queue().setTempo((Float) n);
    }//GEN-LAST:event_jSpinner1StateChanged

    private void spinnerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spinnerKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_spinnerKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField barDiv;
    private javax.swing.JCheckBox jCheckBox1;
    public javax.swing.JSpinner jSpinner1;
    private javax.swing.JToggleButton jToggleButton1;
    public javax.swing.JToggleButton loopButton;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton playButton;
    private javax.swing.JLabel spacerSlash;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel tempoLabel;
    public javax.swing.JTextField tickDiv;
    // End of variables declaration//GEN-END:variables
}
