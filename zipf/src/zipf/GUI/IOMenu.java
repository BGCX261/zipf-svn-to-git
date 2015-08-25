package zipf.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
import zipf.GUI.Zipf;
import zipf.IO.MidiIO;

import zipf.IO.MidiTools;
import zipf.IO.Settings;


public class IOMenu implements MidiTools {

    static public JRadioButtonMenuItem[] buttonIn = new JRadioButtonMenuItem[30];
    static public JRadioButtonMenuItem[] buttonOut = new JRadioButtonMenuItem[30];
    static String[][] midiDev;
    int newIn;
    int newOut;

    public void fillMenu() {
        String[] in = MidiIO.inList;
        String[] out = MidiIO.outList;
        for (int i = 0; i < in.length; i++) {
            if (in[i] != null) {
                {
                    buttonIn[i] = new JRadioButtonMenuItem(in[i], false);
                    buttonIn[i].addActionListener(new butLis());
                    Zipf.inputGroup.add(buttonIn[i]);
                    Zipf.input.add(buttonIn[i]);
                }
            }
        }
        buttonIn[29] = new JRadioButtonMenuItem("Computer Tastatur", false);
        buttonIn[29].addActionListener(new butLis());
        Zipf.inputGroup.add(buttonIn[29]);
        Zipf.input.add(buttonIn[29]);

        if (Settings.inSel == -1) {
            Zipf.inputGroup.setSelected(buttonIn[29].getModel(), true);
        } else {
            Zipf.inputGroup.setSelected(buttonIn[Settings.inSel].getModel(), true);
        }


        for (int i = 0; i < out.length; i++) {
            if (out[i] != null) {
                {
                    buttonOut[i] = new JRadioButtonMenuItem(out[i], false);
                    buttonOut[i].addActionListener(new butLis());
                    Zipf.outputGroup.add(buttonOut[i]);
                    Zipf.output.add(buttonOut[i]);
                }
            }
        }
        Zipf.outputGroup.setSelected(buttonOut[Settings.outSel].getModel(), true);


    }

    class butLis implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent err) {
            if (err.getSource() instanceof JRadioButtonMenuItem) {
                JRadioButtonMenuItem radioButton = (JRadioButtonMenuItem) err.getSource();
                for (int i = 0; i < buttonIn.length; i++) {
                    if (buttonIn[i] == radioButton) {
                        newIn = i;
                    }
                }

                for (int i = 0; i < buttonOut.length; i++) {
                    if (buttonOut[i] == radioButton) {
                        newOut = i;
                    }
                }

                if (radioButton.getText().contains("Computer Tastatur")) {
                    newIn = -1;
                }
                midiIO.selectInOut(newIn, newOut);
            }
        }
    }
}
