package zipf.event;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import zipf.GUI.vis.Vis;
import zipf.GUI.grid.ToolsVis;

public class CC extends Param {

    int ccNumber;
    public transient ShortMessage msg;

    public CC(Seq queue, long position, int y, int controlNumber) {
        super(position, y);
        this.ccNumber = controlNumber;
        this.queue = queue;
        initMidi();
        add();
    }

    @Override
    public void setY(int i) {
        if(i==-1){
            this.remove();
            return;
        }
        this.connectedPanel.setValue(i);
        updateY();
    }

    @Override
    public void initMidi() {
        msg = new ShortMessage();
        super.msg = this.msg;
        toMidi();
    }

   @Override
    public void toMidi() {
        updateY();
        event = new MidiEvent(msg, position);
    }

    @Override
    public void updateY() {
        try {
            msg.setMessage(ShortMessage.CONTROL_CHANGE, 0, ccNumber, y);
        } catch (InvalidMidiDataException ex) {
            Logger.getLogger(CC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getSignature() {
        return "cc" + Integer.toString(ccNumber);
    }

    public String toString() {
        return getSignature() + " " + getY();
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
