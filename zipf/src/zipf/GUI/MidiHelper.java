package zipf.GUI;

import javax.sound.midi.MidiEvent;
import zipf.event.CommandEvent;
import javax.sound.midi.SysexMessage;
import java.util.Arrays;
import zipf.event.NoteSeq;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.ShortMessage;
import zipf.event.Note;
import static javax.sound.midi.ShortMessage.*;

public class MidiHelper {

    static TreeMap<Integer, String> statusShort = getShortMessageStatusMap();
    static TreeMap<Integer, String> statusMeta = getMetaMessageStatusMap();
    static HashMap<Integer, Note> openNotes = new HashMap<Integer, Note>();
    NoteSeq queue;

    public static TreeMap getShortMessageStatusMap() {
        TreeMap<Integer, String> status = new TreeMap<Integer, String>();
        Field[] finals = ShortMessage.class.getDeclaredFields();
        for (Field field : finals) {
            try {
                String str = field.getName();
                str = str.replace("_", " ");
                str = str.toLowerCase();
                status.put(field.getInt(new ShortMessage()), str);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Midi2Seq.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Midi2Seq.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return status;
    }

    public static TreeMap getMetaMessageStatusMap() {
        TreeMap<Integer, String> status = new TreeMap<Integer, String>();
        status.put(3, "Track Name");
        status.put(88, "Time Signature");
        status.put(89, "Key Signature");
        status.put(47, "End Of Track");
        status.put(33, "Midi Port");
        status.put(81, "Tempo");
        status.put(2, "Copyright");
//        status.put(  ,  );
//        status.put(  ,  );
//        status.put(  ,  );
//        status.put(  ,  );
//        status.put(  ,  );

        return status;
    }

    public static String code(MidiEvent event) {
        return code(event.getMessage());
    }

    public static String code(MidiMessage message) {
        if (message instanceof ShortMessage) {
            return statusShort.get(message.getStatus());
        }
        if (message instanceof MetaMessage) {
            int i = ((int) message.getMessage()[1]);
            String str = statusMeta.get(i);

            return str;
        }
        if (message instanceof SysexMessage) {
            return CommandEvent.getLong((SysexMessage) message).toString();
        }
        return "?  " + message.getClass().getSimpleName();
    }

    public void parse(MidiMessage message, long tick) {
        if (message instanceof ShortMessage) {
            parseShort((ShortMessage) message, tick);
        }
        if (message instanceof MetaMessage) {
            parseMeta((MetaMessage) message, tick);
        }
    }

    public void parseMeta(MetaMessage message, long tick) {
        if (code(message) == ("Tempo")) {
            byte[] data = (Arrays.copyOfRange(message.getMessage(), 3, message.getMessage().length));
            int l = MidiHelper.toInt(data);
            queue.Midi.setTempoInMPQ(l);
        }
    }

    public void parseShort(ShortMessage message, long tick) {
        int command = message.getCommand();
        switch (command) {
            case NOTE_ON:
                int volume = message.getData2();
                int y = message.getData1();
                if (volume == 0) {
                    addOffNote(message, tick);
                } else {
                    openNotes.put(y, new Note(queue, (int) tick, y, 1));
                }
                break;
            case NOTE_OFF:
                addOffNote(message, tick);
                break;
        }
    }

    private void addOffNote(ShortMessage message, long tick) {
        int y = message.getData1();
        Note note = openNotes.get(y);
        if (note != null) {
            note.setDuration((int) (tick - note.position));
            queue.addEvent(note);
            openNotes.remove(y);
        }
    }

    public static int toInt(byte[] data) {
        int i = 0;
        int length = data.length;
        for (int j = 0; j < length; ++j) {
            i |= (data[length - 1 - j] & 0xff) << (j << 3);
        }
        return i;
    }

    MidiHelper(NoteSeq queue) {
        this.queue = queue;
    }
}
