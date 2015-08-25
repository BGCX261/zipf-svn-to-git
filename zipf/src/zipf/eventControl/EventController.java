package zipf.eventControl;

import zipf.event.conditions.ToolsEvent;
import zipf.event.EndOfTrack;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.SysexMessage;
import zipf.GUI.Zipf;
import zipf.GUI.grid.GridNote;
import zipf.event.BaseNote;
import zipf.event.CommandEvent;
import zipf.event.NoteSeq;
import zipf.event.Pool;
import zipf.event.PoolLive;
import zipf.event.interfaces.Playable;
import zipf.event.Seq;
import zipf.event.conditions.DefaultRouter;

public class EventController  {

    static BaseNote baseNote;
    static ArrayList<ShortMessage> notePool = new ArrayList<ShortMessage>(127);
    static PoolLive pool = new PoolLive();
    static ArrayList<NoteSeq> metaPool = new ArrayList<NoteSeq>();
    public static EndOfTrack eot = new EndOfTrack();
    static ArrayList<Playable> inMemory = new ArrayList<Playable>();
    static int noteSum = 0;
    public static Pool currentPool;
    public static DefaultRouter router = new DefaultRouter(EventController.class);


    static void fireBaseNote(BaseNote baseNote) {
        EventController.baseNote = baseNote;
    }


    public static void fireMessage(MidiMessage message, long timeStamp) {
        if (message instanceof ShortMessage) {
            fireShortMessage((ShortMessage) message);
        }

        if (message instanceof SysexMessage) {
            CommandEvent command = (CommandEvent) Memory.memory.get(CommandEvent.getLong((SysexMessage) message));
            command.process();
        }
    }

    public static long metaToID(byte[] messageData) {

        long l = ToolsEvent.lFromBytes(Arrays.copyOfRange(messageData, 1, messageData.length));
        return l;

    }

    public static void fill(int newNote) {
//        if (newNote > 0) {
//			UI.noteCount[newNote]++;
//        }
//        if (newNote > 0) {
//            pool.add(newNote);
//			postPoolFill(newNote);
//			Visor.noteVis();
//			Visor.noteVis(newNote);
//                                else
//				postPooling();
//        }
//        if (newNote < 0) {
//
//            pool.remove(Math.abs(newNote));
//			Visor.noteVis();
//        }
//        if (pool.size() > 2) {
//            Integer[] pitch = new Integer[pool.size()];
//            BaseChord baseChord;
//            if ((baseChord = chordTools.chordAnalyze(pool.toArray(pitch))) != null) {
//                fireLiveBaseNote(baseChord.baseNote);
//            }
//        }
    }

    public static void fireBaseNote(int baseNote, Seq parentSeq) {
    }

    private static void fireLiveBaseNote(BaseNote baseNote) {
    }

    private static void fireNoteOn(ShortMessage message) {
        Zipf.lämpchen.setBackground(Color.YELLOW);
        pool.add(message.getData1());
    }

    private static void fireNoteOff(ShortMessage message) {
        Zipf.lämpchen.setBackground(Color.DARK_GRAY);
        pool.remove(message.getData1());
    }

    public static void fireSeqStart(long songID) {
//        throw new UnsupportedOperationException("Not yet implemented");
//        Memory.memory.get(songID).play();
    }

    private static void fireSeqStop(long songID) {
//        throw new UnsupportedOperationException("Not yet implemented");
//        Memory.memory.get(songID).stopZero();
    }

    public static void fireTick(long tick) {

    }

    public static void fireShortMessage(ShortMessage message) {
        ShortMessage shortMessage = (ShortMessage) message;
        if (shortMessage.getCommand() == ShortMessage.NOTE_ON) {
            fireNoteOn(shortMessage);
            noteSum++;
        } else if (shortMessage.getCommand() == ShortMessage.NOTE_OFF) {
            fireNoteOff(shortMessage);
        }

    }
}
