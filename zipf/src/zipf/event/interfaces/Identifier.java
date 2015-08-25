package zipf.event.interfaces;

public interface Identifier {

        public final int PLAY = 1;
    public final int STOP = 2;

    public static enum Class {

        maj, min, aug, mn, sus
    }

    public static enum Context {

        Note, Layer, Pattern, Structure
    }

    public static enum NoteLength {

        Whole, Half, Quarter, Eight, Sixteenth, Thirtysecond, Sixtyfourth, HundredTwentyEight, Thirds
    }

    public static enum PartLength {

        Full, OneBar, TwoBar, FourBar, EightBar, SixteenBar
    }

    public static enum Elements {

        Note, RhythmNote, ParameterCurve
    }
    int NOTESEQ = 30;
    int TRACKLINE = 31;
    int NOTE = 10;
    int SEQNOTE = 11;
    int POOL = 20;

}
