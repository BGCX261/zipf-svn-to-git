package zipf.event.pending;

import zipf.event.NoteSeq;

public class EventStructure  {



    public NoteSeq baseNoteLayer() {
        throw new UnsupportedOperationException();
    }

    public ParameterCurve harmonicalDensity() {
        throw new UnsupportedOperationException();
    }

    public NoteSeq chords() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param l
     * @param buffer
     * @return
     */
    public boolean allNotesOff(int l, boolean buffer) {
        return true;
    }

    /**
     *
     * @param l
     * @return
     */
    public boolean sustainAll(int l) {
        return true;
    }

    /**
     *
     * @param l
     * @return
     */
    public void fadeOut(int l) {
    }

    /**
     *
     * @param l
     * @return
     */
    public void fadeIn(int l) {
    }
}
