package zipf.event;

import zipf.GUI.Zipf;

public class Controller {

    public static void fileCreated() {
        Zipf.editMain.browser.updateFolderTree();
        Zipf.editMain.browser.updateTree();
    }

    public static void setLooped(boolean loop, Seq queue) {
        queue.tools.edit.transportControls.loopButton.setSelected(queue.Midi.isLooped());
    }
}
