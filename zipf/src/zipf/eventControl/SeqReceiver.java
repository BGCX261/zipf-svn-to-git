package zipf.eventControl;

import zipf.event.Midi;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import zipf.GUI.CurrentItems;
import zipf.GUI.EditMain;
import zipf.GUI.Zipf;
import zipf.GUI.grid.GridTools;
import zipf.event.BaseNote;
import zipf.event.EndOfTrack;
import zipf.event.MidiSequence;
import zipf.event.Pool;
import zipf.event.Seq;
import zipf.event.conditions.DefaultRouter;

public class SeqReceiver extends Midi implements Receiver {

    Pool currentPool;
    public DefaultRouter router = new DefaultRouter(this);
    public BaseNote baseNote;

    public SeqReceiver(Seq seq, boolean connected) {
        super(seq, connected);
        getTransmitter().setReceiver(this);
    }

    @Override
    public void send(MidiMessage message, long timeStamp) {
        if (message instanceof ShortMessage) {
            fireShortMessage((ShortMessage) message);
        }
//            EventController.fireMessage(message, timeStamp);
        if (queue == GridTools.queueInEdit) {
            Pool newPool = getCurrentPool();
            if (newPool != currentPool) {
                currentPool = newPool;
                if (currentPool != null) {
                    sendPoolToRouter(currentPool, timeStamp);
                    if (currentPool.baseNote != baseNote) {
                        this.baseNote = currentPool.baseNote;
                        fireBaseNoteChange(currentPool.baseNote);
                    }
                }
            }
        }
    }

    public void sendPoolToRouter(Pool currentPool, long timeStamp) {
        ArrayList eventList = currentPool.getEvents();
        System.out.println(eventList);
        router.set(eventList);
    }

    public void fill(int newNote) {
    }

    public void fireBaseNote(BaseNote baseNote, Seq parentSeq) {
    }

    private void fireLiveBaseNote(BaseNote baseNote) {
    }

    private void fireNoteOn(ShortMessage message) {
        Zipf.lämpchen.setBackground(Color.YELLOW);
        if (message.getChannel() == 15) {
            if (message.getData2() != 0) {
//            System.out.println("- - -");
//                System.out.println("firing onNote  " + message.getData1());
                queue.playItem(message.getData1());
            } else {
                fireNoteOff(message);
            }
        }
    }

    private void fireNoteOff(ShortMessage message) {
        Zipf.lämpchen.setBackground(Color.DARK_GRAY);
        if (message.getChannel() == 15) {
//            System.out.println("firing offNote  " + message.getData1());
            queue.stopItem(message.getData1());
        }
    }

    public void fireSeqStart(long songID) {
    }

    private void fireSeqStop(long songID) {
    }

    public void fireTick(long tick) {
    }

    public void fireShortMessage(ShortMessage message) {
        ShortMessage shortMessage = (ShortMessage) message;
        if (shortMessage.getCommand() == ShortMessage.NOTE_ON) {
            fireNoteOn(shortMessage);
        } else if (shortMessage.getCommand() == ShortMessage.NOTE_OFF) {
            fireNoteOff(shortMessage);
        }
    }

    @Override
    public void close() {
    }

    private void fireBaseNoteChange(BaseNote baseNote) {
        this.baseNote = baseNote;
    }
}
