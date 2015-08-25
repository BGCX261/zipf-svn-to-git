package zipf.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import zipf.event.zTimer;
import zipf.eventControl.Counter;

public class Settings {

    public static Properties props = new Properties();
    public static File propFile = new File("settings.ini");
    public static int inSel;
    public static int outSel;

    public static void saveSettings() {
        try {
            props.store(new FileOutputStream(propFile), "settings");
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public static int getPropInt(String string) {
        String s = props.getProperty(string);
        int i = Integer.parseInt(s);
        return i;
    }

    public static void setIntProp(String string, int count) {
        props.setProperty(string, Integer.toString(count));
        saveSettings();
    }

    static boolean isFreshDay() {
        return !props.getProperty("lastStarted").equals(zTimer.getDate());
    }

    public static void showPropList() {
        for (String s : props.stringPropertyNames()) {
            System.out.println(s + " : " + props.getProperty(s));
        }
    }

    public static void initProps() {
        try {
            props.load(new FileInputStream(propFile));
//            showPropList();

            if (!isFreshDay()) {
                Counter.setCount("NoteSeq", getPropInt("NoteSeqDayCount"));
                Counter.setCount("TrackLine", getPropInt("TrackLineDayCount"));
            } else {
                props.setProperty("lastStarted", zTimer.getDate());
                props.setProperty("NoteSeqDayCount", "0");
                props.setProperty("TrackLineDayCount", "0");
            }
        } catch (FileNotFoundException e) {
            repair();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            repair();
            e.printStackTrace();
        }




        inSel = getPropInt("lastIn");
        outSel = getPropInt("lastOut");

    }

    public static void repair() {
        System.out.println("repairing settings.ini ...");

        try {
            if (propFile.exists() == false) {
                propFile.createNewFile();
            }
            props.setProperty("lastIn", "-1");
            props.setProperty("lastOut", "0");
            props.setProperty("lastOpenedName", "");
            props.setProperty("lastOpened", "");
            props.setProperty("lastStarted", zTimer.getDate());
            props.setProperty("lastPath", "");
            props.setProperty("NoteSeqDayCount", "1");
            props.setProperty("TrackLineDayCount", "1");
            saveSettings();


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        initProps();

    }
}
