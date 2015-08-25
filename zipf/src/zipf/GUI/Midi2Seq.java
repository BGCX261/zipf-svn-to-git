package zipf.GUI;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import zipf.GUI.grid.Grid;
import zipf.event.NoteSeq;
import zipf.event.TransportThread;
import zipf.event.Song;
import zipf.event.interfaces.MidiMetrics;

public class Midi2Seq {

    static Sequence sequence;

    public static Object convert(File file, Grid tools) {
        if (file.getName().endsWith(".mid")) {
            return mid2Seq(file, tools);
        }
        return null;
    }

    static Object mid2Seq(File file, Grid tools) {
        try {
            sequence = MidiSystem.getSequence(file);
        } catch (InvalidMidiDataException ex) {
            Logger.getLogger(Midi2Seq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Midi2Seq.class.getName()).log(Level.SEVERE, null, ex);
        }
        MidiHelper helper = new MidiHelper(new NoteSeq(convertTick(sequence.getTickLength()), tools, false));
        for (int j = 0; j < sequence.getTracks().length; j++) {
            Track track = sequence.getTracks()[j];
            for (int i = 0; i < track.size(); i++) {
                MidiEvent event = track.get(i);
                MidiMessage message = event.getMessage();
                helper.parse(message, (convertTick(event.getTick())));
                if (i % 100 < 5) {
                    System.out.print(".");
                }
            }
        }
        System.out.println("");
        System.out.println("Tempo (BPM): " + helper.queue.Midi.getTempoInBPM());
        System.out.print("Resolution: " + sequence.getResolution());
        System.out.println(" with Divisiontype " + sequence.getDivisionType() + "(0-PPQ, other SMPTE");
        return helper.queue;
    }

    static long convertTick(long value) {
        double floatValue = (double) value;
        double factor = (double) MidiMetrics.PPQ / ((double) sequence.getResolution());
        double result = floatValue * factor;
        return (long) (result);
    }
}
