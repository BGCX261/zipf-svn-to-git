package zipf.IO;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.*;
import java.io.PrintStream;
import zipf.eventControl.EventController;

public class MidiReceiver implements Receiver, MidiTools {

    static MidiMessage[] messages = new MidiMessage[13];
    static boolean swMode = false;
    static MidiMessage[] messagesOff = new MidiMessage[13];
    static MidiMessage x;
    PrintStream printstream;
    public static int noteM;
    public static int note;
    public static int onOff;
    static Integer[] poolState = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    boolean ON;
    boolean OFF;
    static long time2 = 0;
    boolean played = false;

    public MidiReceiver(PrintStream printstream) {
        this.printstream = printstream;

        int i;
        for (i = 0; i < 12; i++) {
            try {
                ShortMessage mTmp = new ShortMessage();
                mTmp.setMessage(150, 60 + i, 100);
                messages[i + 1] = (MidiMessage) mTmp;
            } catch (InvalidMidiDataException e) {
                e.printStackTrace();
            }
        }
        for (i = 0; i < 12; i++) {
            try {
                ShortMessage mTmp = new ShortMessage();
                mTmp.setMessage(150, 60 + i, 0);
                messagesOff[i + 1] = (MidiMessage) mTmp;
            } catch (InvalidMidiDataException e) {
                e.printStackTrace();
            }
        }
    }

    public void open() {

    }

    public MidiReceiver(PrintStream printstream, boolean ON, boolean OFF) {
        this.printstream = printstream;
        this.ON = ON;
        this.OFF = OFF;
    }

    public MidiReceiver() {
    }

    @Override
    public void send(MidiMessage message, long timeStamp) {
        try {
            MidiSystem.getSynthesizer().getReceiver().send(message, timeStamp);
            //        System.out.println(message);
            EventController.fireMessage(message, timeStamp);
            //        if (message instanceof ShortMessage && ((ShortMessage) message).getChannel() != 9) {
            //            note = ((ShortMessage) message).getData1();
            //            if (note > 0) {
            //                noteM = note % 12;
            //                if (message instanceof ShortMessage) {
            //                    procNote((ShortMessage) message, timeStamp);
            //                }
            sendToReceiver((ShortMessage) message, true);
            //        }
            //        }
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(MidiReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void procNote(ShortMessage mes, long timeStamp) {
        long time = System.currentTimeMillis();

        time2 = time;

        ON = (mes.getCommand() == 0x90);
        OFF = (mes.getCommand() == 0x80);


        if ((poolState[noteM] == 1) && (OFF || mes.getData2() == 0)) {
            poolState[noteM] = 0;
            EventController.fill(-noteM);
        } else if ((poolState[noteM] == 0) && (ON)) {
            poolState[noteM] = 1;
            EventController.fill(noteM);
        }
    }

    public void close() {
    }

    public void sendToReceiver(MidiMessage msg, boolean mode) {
        mode = mode ^ swMode;
        if (mode) {
            if (midiIO.devOut.isOpen()) {
                midiIO.currentReceiver.send(msg, 0);
            }
        }
    }

    public void sendToReceiver(int note, int state, boolean mode) {
        if (midiIO.devOut != null && midiIO.devOut.isOpen()) {
            mode = mode ^ swMode;
            if (mode) {
                switch (state) {
                    case 1:
                        if (messages[note] != null) {
                            zipfSend(messages[note], 0);
                        }
                        break;
                    case 0:
                        if (messagesOff[note] != null) {
                            zipfSend(messagesOff[note], 0);
                        }
                        break;
                }
            }
        }
    }

    public static void out(Object string) {

        System.out.println(string);
    }

    void zipfSend(MidiMessage message, long timestamp) {
        try {
            //    System.out.println("sending..." + ((ShortMessage)message).getData2());
            MidiSystem.getReceiver().send(message, -1);
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(MidiReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//   void allNotesOff(){
//       ChannelMessage msg;
//       
//   }
}
