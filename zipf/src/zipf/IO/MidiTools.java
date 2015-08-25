package zipf.IO;

import zipf.event.Midi;

public interface MidiTools {

    MidiIO midiIO = new MidiIO();
    MidiReceiver midiReceiver = new MidiReceiver(System.out);
}
