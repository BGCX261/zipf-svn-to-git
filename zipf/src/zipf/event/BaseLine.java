package zipf.event;

import java.util.ArrayList;

public class BaseLine extends ArrayList {

    BaseRhythm rhythm;
    BasePhrase phrase;

    public BaseLine(BaseRhythm rhythm, BasePhrase phrase) {
        this.rhythm = rhythm;
        this.phrase = phrase;
    }

    public void addChord(BaseChord chord, int index) {
        this.add(index, chord);
    }
}
