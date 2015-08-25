package zipf.event.conditions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import zipf.event.NoteSeq;

public class ToolsEvent {

    static HashMap<String, String[]> chord2 = new HashMap<String, String[]>();
    static HashMap<String, String[]> chord3 = new HashMap<String, String[]>();
    static HashMap<String, String[]> chord4 = new HashMap<String, String[]>();
    static HashMap<String, String[]> chord5 = new HashMap<String, String[]>();
    public static HashMap<String, String[]>[] chordNames = new HashMap[6];
    public static String[] noteNames = new String[]{"C", "Cis", "D", "Dis", "E", "F",
        "Fis", "G", "Gis", "A", "Ais", "H"};

    {
        chord2.put("1", new String[]{"Minor second", "min2"});
        chord2.put("2", new String[]{"Major second", "maj2"});
        chord2.put("3", new String[]{"Minor third", "min3"});
        chord2.put("4", new String[]{"Major third", "maj3"});
        chord2.put("5", new String[]{"Perfect fourth", "4"});
        chord2.put("6", new String[]{"Tritone", "tritone"});
        chord2.put("7", new String[]{"Perfect fifth", "5"});
        chord2.put("8", new String[]{"Minor sixth", "min6"});
        chord2.put("9", new String[]{"Major sixth", "maj6"});
        chord2.put("10", new String[]{"Minor seventh", "min7"});
        chord2.put("11", new String[]{"Major seventh", "maj7"});
        chord2.put("12", new String[]{"Perfect octave", "oct"});


        chordNames[2] = chord3;

        chord3.put("336", new String[]{"Diminished", "dim"});
        chord3.put("345", new String[]{"Minor", "min"});
        chord3.put("435", new String[]{"Major", "maj"});
        chord3.put("444", new String[]{"Augmented", "aug"});
        chord3.put("525", new String[]{"Suspended 4", "sus4"});
        chordNames[3] = chord3;

        chord4.put("2235", new String[]{"Major add9", "maj add9"});
        chord4.put("3333", new String[]{"Half Diminished 7/ Minor 7 (b5)", "halfDim7/min7(b5)"});
        chord4.put("3342", new String[]{"Diminished 7", "dim7"});
        chord4.put("3423", new String[]{"Minor 6 / Minor 7 b5 1st Inversion", "min6/min7 b5 (1.inv)"});
        chord4.put("3432", new String[]{"Minor 7", "min7"});
        chord4.put("3441", new String[]{"Minor #7", "min#7"});
        chord4.put("4323", new String[]{"Major 6/Minor 7 1st Inversion", "maj6/min7(1.inv)"});
        chord4.put("4332", new String[]{"Major 7", "maj7"});
        chord4.put("4341", new String[]{"Major #7", "maj#7"});
        chord4.put("4422", new String[]{"Augmented 7", "aug7"});
        chord4.put("4431", new String[]{"Major 7 #5", "maj7 #5"});
        chord4.put("5232", new String[]{"7 Suspended 4", "7sus4"});
        chordNames[4] = chord4;

        chord5.put("13332", new String[]{"Major 7 (b9)", "maj (b9)"});
        chord5.put("14232", new String[]{"7 Suspended (b9)", "7sus (b9)"});
        chord5.put("21342", new String[]{"Diminished 7 b5/9", "dim7 b5/9"});
        chord5.put("21432", new String[]{"Minor 9", "min9"});
        chord5.put("21441", new String[]{"Minor #7/9", "min #7/9"});
        chord5.put("22323", new String[]{"Major 6/9", "maj 6/9"});
        chord5.put("22332", new String[]{"Major 9", "maj9"});
        chord5.put("22341", new String[]{"Major #7/9", "maj #7/9"});
        chordNames[5] = chord5;
    }



    public static long metaToID(byte[] messageData) {

        long l = lFromBytes(Arrays.copyOfRange(messageData, 1, messageData.length));
        return l;

    }

    public static byte[] lToBytes(long l) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(bos);
            dos.writeLong(l);
            dos.flush();
            byte[] data = bos.toByteArray();
            return data;
        } catch (IOException ex) {
            Logger.getLogger(ToolsEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static long lFromBytes(byte[] bytes) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            DataInputStream dis = new DataInputStream(bis);
            long l = dis.readLong();
            return l;
        } catch (IOException ex) {
            Logger.getLogger(ToolsEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
