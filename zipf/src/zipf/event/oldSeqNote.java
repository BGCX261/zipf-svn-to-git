package zipf.event;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.SysexMessage;
import zipf.IO.MidiTools;

public abstract class oldSeqNote extends NoteEvent implements MidiTools {

    public transient SysexMessage msg;
    public transient SysexMessage offMsg;

    public oldSeqNote(Seq parentSeq, long position, int y, long duration) {
        super(parentSeq, position, y, duration);
    }

    @Override
    public void initMidi() {
        msg= new SysexMessage();
        offMsg= new SysexMessage();
        super.msg = this.msg;
        super.offMsg = this.offMsg;
        toMidi();
    }

    @Override
    public void toMidi() {
        event = new CommandEvent(msg, position, PLAY, this);
        offNote = new CommandEvent(offMsg, position + duration, STOP, this);
        CommandEvent on = (CommandEvent) event;
        CommandEvent off = (CommandEvent) offNote;
        try {
            msg.setMessage(on.memoID, on.memoID.length);
            offMsg.setMessage(off.memoID, off.memoID.length);
            System.out.println(this);
        } catch (InvalidMidiDataException ex) {
            Logger.getLogger(CommandEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(event + " " + this);
    }
}
