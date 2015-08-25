package zipf.IO;

import java.io.*;
import java.lang.Thread.*;
import javax.sound.midi.*;
import zipf.GUI.Zipf;
import zipf.GUI.IOMenu;

public class MidiIO extends Thread implements MidiTools{

    static MidiDevice.Info[] midiInfo = MidiSystem.getMidiDeviceInfo();
    public static MidiDevice.Info[] devicesIn = new MidiDevice.Info[30];
    public static MidiDevice.Info[] devicesOut = new MidiDevice.Info[30];
    public static String[] outList = new String[50];
    public static String[] inList = new String[50];
    public static MidiDevice devOut;
    public static MidiDevice devIn;
    static Sequencer sequencer;
    public static Receiver currentReceiver;
    static int posJRTSin;
    static int posJRTSout;



    public void selectInOut(int inSel, int outSel) {
//TODO Arraybounds..
//		if (inSel != -1 && devInMidi[inSel] == null)
//		inSel = -1;
//System.out.print("in  " + inSel + "   out  " + outSel);
        try {
            if (devIn != null) {
                devIn.close();
            }
            if (devOut != null) {
                devOut.close();
            }
            if (this.getState() == State.RUNNABLE) {
                this.interrupt();
            }

//            if (inSel == -2) {
//                Sequencer seq = MidiSystem.getSequencer();
//                seq.open();
//                seq.getTransmitter().setReceiver(midiReceiver);
//                seq.setSequence(MidiSystem.getSequence(FileIO.midiFile));
//                seq.start();
//                sequencer = seq;
//            }
//            if (inSel == -3) {
//                sequencer.stop();
//                sequencer.close();
//                sequencer = null;
//            }

            if (inSel > -1) {
                Settings.props.setProperty("lastIn", Integer.toString(inSel));
                if (inSel >= posJRTSin) {
                    ++inSel;
                }
                devIn = MidiSystem.getMidiDevice(devicesIn[inSel]);
                devIn.open();
                Transmitter tra = devIn.getTransmitter();
                tra.setReceiver(midiReceiver);
            }
            if (inSel == -1) {
                Settings.props.setProperty("lastIn", Integer.toString(inSel));
                devIn = MidiSystem.getMidiDevice(midiInfo[posJRTSin]);
                devIn.open();
                Transmitter tra = devIn.getTransmitter();
                tra.setReceiver(midiReceiver);
                inSel = 0;
            }

//            if (outSel >= deviceList.posJRTSout) {
//                ++outSel;
//            }
            Settings.props.setProperty("lastOut", Integer.toString(outSel));
            devOut = MidiSystem.getMidiDevice(devicesOut[outSel]);
            devOut.open();
            System.out.println("devOut opened" + devOut);
            currentReceiver = devOut.getReceiver();

        } catch (MidiUnavailableException e) {
            System.err.println(e);
        }

        Settings.saveSettings();
        if (this.getState() == State.NEW) {
            this.start();
        }
        if (this.getState() == State.WAITING) {
            this.start();
        }

    }

    @Override
    public void run() {
//System.out.println("in-Listener active");
        try {
            System.in.read();
        } catch (IOException ioe) {
        } catch (Exception e) {
            System.err.println(e);
        }
        devIn.close();
        devOut.close();
    }

    public static void getDevices() {

        for (int i = 0, outCount = 0, inCount = 0; i < midiInfo.length; i++) {

            try {
                MidiDevice midiDevice = MidiSystem.getMidiDevice(midiInfo[i]);

                boolean isOut = (midiDevice.getMaxReceivers() != 0);
                boolean isIn = (midiDevice.getMaxTransmitters() != 0);

                if (isOut && !midiDevice.isOpen()) {
//                    if (midiInfo[i].toString().contains("Real Time Sequencer")) {
//                        posJRTSout = i;
//                    } else {
                    outList[outCount] = (midiInfo[i].toString());
                    devicesOut[outCount] = midiInfo[i];
//                    System.out.println(midiInfo[i]);
                    outCount++;
//                    }
                }
                if (isIn) {
                    if (midiInfo[i].toString().contains("Real Time Sequencer")) {
                        posJRTSin = i;
                    } else {
                        inList[inCount] = (midiInfo[i].toString());
                        devicesIn[inCount] = midiInfo[i];
                        inCount++;
                    }
                }
            } catch (MidiUnavailableException e) {
            }
        }
    }
}
