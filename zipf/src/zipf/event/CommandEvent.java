package zipf.event;

import zipf.event.interfaces.Identifier;
import java.util.Arrays;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.SysexMessage;
import zipf.event.conditions.ToolsEvent;
import zipf.event.conditions.Action;
import zipf.eventControl.Memory;

public class CommandEvent extends MidiEvent implements Memorable, Action, Identifier {

    SysexMessage message;
    byte[] memoID;
    int command;
    Event item;

    public CommandEvent(SysexMessage message, long position, int command, Event item) {
        super(message, position);
        this.item = item;
        this.message = message;
        this.command = command;
        code();
    }

    public static Long getLong(SysexMessage message) {
        if (message.getData().length > 1) {
            byte[] data = Arrays.copyOfRange(message.getData(), 1, message.getData().length - 1);
            long l = ToolsEvent.lFromBytes(data);
            return l;
        } else {
            return 00000L;
        }
    }

    public void code() {
        if (memoID == null) {
            memoID = Memory.add(this);
            int size = memoID.length + 3;
            byte[] array = new byte[size];
            array[0] = (byte) 240;
            array[1] = (byte) 125;
            array[size - 1] = (byte) 247;
            for (int i = 0; i < memoID.length; i++) {
                array[i + 2] = memoID[i];
            }
            memoID = array;
        }
    }

    @Override
    public String toString() {
        return command + " " + item.getClass().getSimpleName() + " at Position " + this.getTick() + "(id:" + getLong((SysexMessage) message) + ")";
    }

    @Override
    public void process() {
        switch (command) {
            case PLAY:
                item.play();
                Memory.playing.add((Seq) item);
                break;
            case STOP:
                item.stop();
                Memory.playing.remove((Seq) item);
                break;
        }
    }
}
