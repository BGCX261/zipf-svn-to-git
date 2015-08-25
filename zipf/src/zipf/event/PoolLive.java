package zipf.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import zipf.eventControl.ToolsChord;

public class PoolLive {

    public TreeSet<Integer> notes = new TreeSet<Integer>();
    public TreeSet<Integer> modNotes = new TreeSet<Integer>();

    public void add(int i) {
        notes.add(i);
        modNotes.add(i % 12);
        analyzePool();
    }

    public void remove(int i) {
        notes.remove(i);
        int j =i%12;
        for (Integer inte : notes) {
            if (inte%12==j){
                return;
            }
        }
        modNotes.remove(j);
    }


    @Override
    public String toString(){
//        return notes + " // " + modNotes;
        return notes.subSet(0, 10).toString() + " // " + notes + " // " + modNotes;
    }

    public Integer[] getModNotes(){
        Integer[] i = new Integer[modNotes.size()];
        return modNotes.toArray(i);
    }


    void analyzePool() {
        ToolsChord.chordAnalyze(getModNotes());
    }

}
