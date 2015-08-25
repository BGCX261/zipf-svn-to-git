package zipf.GUI;

import zipf.GUI.grid.GridEdit;
import zipf.event.NoteSeq;
import zipf.event.Song;

public class CurrentItems {

    public static GridEdit currentEdit;
    public static NoteSeq currentNoteSeq;
    public static Song currentSong;

    public static Browser getCurrentBrowser() {
        if (Zipf.editMain != null) {
            return Zipf.editMain.browser;
        }
        return null;
    }

    public static GridEdit getCurrentEdit() {
        return currentEdit;
    }

    public static void setCurrentEdit(GridEdit currentEdit) {
        CurrentItems.currentEdit = currentEdit;
        Browser browser = getCurrentBrowser();
        if (browser != null) {
            browser.setTools(currentEdit.gridTable);
        }
    }

    public static NoteSeq getCurrentNoteSeq() {
        return currentNoteSeq;
    }

    public static void setCurrentNoteSeq(NoteSeq currentNoteSeq) {
        CurrentItems.currentNoteSeq = currentNoteSeq;
    }

    public static Song getCurrentSong() {
        return currentSong;
    }

    public static void setCurrentSong(Song currentSong) {
        CurrentItems.currentSong = currentSong;
    }

    public static void setSelectedTab(String str) {
        if (str.contains("Note")) {
            Zipf.editMain.tabbed.setSelectedIndex(0);
        }
        if (str.contains("Seq")) {
            Zipf.editMain.tabbed.setSelectedIndex(1);
        }
        if (str.contains("Rule")) {
            Zipf.editMain.tabbed.setSelectedIndex(2);
        }
    }
}
