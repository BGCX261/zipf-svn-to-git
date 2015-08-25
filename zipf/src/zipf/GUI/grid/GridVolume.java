package zipf.GUI.grid;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import zipf.GUI.vis.Vis;
import zipf.GUI.vis.VisHelper;
import zipf.GUI.table.CCModel;
import zipf.GUI.table.CCRenderer;
import zipf.GUI.table.VolumeModel;
import zipf.GUI.table.VolumeParamRenderer;
import zipf.GUI.vis.ContainerVolumeVis;
import zipf.event.Note;

public class GridVolume extends GridParam {

    private Note volumeNote;

    public GridVolume(ToolsBar tools) {
        super(tools);
    }

    @Override
    public void setMRQ() {
        renderer = new VolumeParamRenderer(this);
        model = new VolumeModel(this);
    }

    @Override
    public void gridReleased() {
        super.gridReleased();
        volumeNote = null;
    }

    @Override
    public void gridPressed(MouseEvent evt) {
        Point p = getGridPoint();
        if (p != null) {
            Collection<Note> noteSet = queue().getNotesInInt(getGridPoint().x);
            if (noteSet != null && noteSet.size() > 0) {
                int yPos = VisHelper.getVisY(editPane.getMousePosition().y);
                int index = 0;
                Comparator<Note> comparator = new Comparator<Note>() {

                    @Override
                    public int compare(Note o1, Note o2) {
                        return o1.volume - o2.volume;
                    }
                };
                ArrayList<Note> notes = new ArrayList<Note>();
                ArrayList<Integer> volumes = new ArrayList<Integer>();
                for (Note note : noteSet) {
                    note.unMark();
                    notes.add(note);
                    volumes.add(note.volume);
                }
                volumes.add(yPos);
                Collections.sort(volumes);
                Collections.sort(notes, comparator);
                index = volumes.indexOf(yPos);
                if (index == 1 && notes.size() == 1) {
                    index = 0;
                } else if (index == notes.size()) {
                    index -= 1;
                }
                volumeNote = notes.get(index);
                ((ToolsBar) volumeNote.queue.tools).singleFocusOn(volumeNote.eventVis);
                dragOperation();
            }
        }
    }

    @Override
    public void dragOperation() {
        Point mouse = editPane.getMousePosition();
        if (mouse != null) {
            if (volumeNote != null && volumeNote.getIntPosition() == getGridPoint().x) {
//            note.mark();
                volumeNote.setVolume(VisHelper.getVisY(mouse.y - 4));
                model.fireTableDataChanged();
            } else {
                this.gridPressed(null);
            }
        }
    }
}
