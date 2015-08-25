package zipf.event;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;

public class EndOfTrack extends MetaMessage{


    public EndOfTrack(){

        try {
            setMessage(0x2f, new byte[]{0x00}, 1);
        } catch (InvalidMidiDataException ex) {
            Logger.getLogger(EndOfTrack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
