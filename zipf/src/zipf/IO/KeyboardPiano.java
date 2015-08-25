package zipf.IO;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.ShortMessage;
import zipf.event.Note;

public class KeyboardPiano implements MidiTools {

    public static final HashMap<Integer, Integer> keyMap = new HashMap<Integer, Integer>();
    
   static {
        keyMap.put( 89 , 60 );
        keyMap.put( 83 , 61 );
        keyMap.put( 88 , 62 );
        keyMap.put( 68 , 63 );
        keyMap.put( 67 , 64 );
        keyMap.put( 86 , 65 );
        keyMap.put( 71 , 66 );
        keyMap.put( 66 , 67 );
        keyMap.put( 72 , 68 );
        keyMap.put( 78 , 69 );
        keyMap.put( 74 , 70 );
        keyMap.put( 77 , 71 );
    }

   
    public static void play(KeyEvent key) {
        ShortMessage noteOn = new ShortMessage();

        int i = key.getKeyCode();
        if (keyMap.containsKey(i)) {
            try {
                noteOn.setMessage(ShortMessage.NOTE_ON, 0, keyMap.get(i), 100);
                midiReceiver.send(noteOn, 0);
            } catch (InvalidMidiDataException ex) {
                Logger.getLogger(KeyboardPiano.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void off(KeyEvent key) {
        ShortMessage noteOff = new ShortMessage();

        int i = key.getKeyCode();
        if (keyMap.containsKey(i)) {
            try {
                noteOff.setMessage(ShortMessage.NOTE_OFF, 0, keyMap.get(i), 100);
                midiReceiver.send(noteOff, 0);
            } catch (InvalidMidiDataException ex) {
                Logger.getLogger(KeyboardPiano.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
