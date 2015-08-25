package zipf.GUI.vis;

import javax.swing.JPanel;
import zipf.GUI.KeyInput;
import zipf.GUI.grid.GridTable;
import zipf.GUI.grid.ToolsBar;
import zipf.GUI.grid.ToolsVis;
import zipf.event.NoteEvent;

public class VisBar<GenEvent extends NoteEvent> extends Vis<GenEvent> {

    public VisBar(ToolsBar tools, GenEvent event) {
        super(tools, event);
        new KeyInput().setActions((JPanel) this, (ToolsVis) tools);
    }

    @Override
    public void updateBounds() {
        setBounds((int) ((float) connectedEvent.getPosition() * tools.tw()), Y() * tools.ch, (int) ((float) connectedEvent.getDuration() * tools.tw()), tools.ch);
        revalidate();
    }

    public int length() {
        return ((NoteEvent) connectedEvent).intDuration();
    }
}
