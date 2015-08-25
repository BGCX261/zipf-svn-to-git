package zipf.GUI;

import zipf.GUI.IOMenu;
import zipf.IO.Settings;



public class Initializer implements zipf.IO.MidiTools {

    static IOMenu ioMenu = new IOMenu();

    public static void getMidiDevices() {
        midiIO.getDevices();
        ioMenu.fillMenu();
    }

    public static void loadProps() {
        Settings.initProps();
    }

}
