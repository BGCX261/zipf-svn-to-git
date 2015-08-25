package zipf.IO;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import zipf.event.Controller;
import zipf.event.Event;
import zipf.event.NoteSeq;
import zipf.event.Seq;
import zipf.event.Song;
import zipf.event.interfaces.Element;
import zipf.event.interfaces.MidiItem;
import zipf.event.interfaces.Propertable;
import zipf.eventControl.Counter;
import zipf.libraries.ToolsNode;

public class FileIO implements Serializable {

    static File midiFile;
    static HashMap<Class, String> endings = new HashMap<Class, String>();

    static {
        endings.put(NoteSeq.class, ".seq");
        endings.put(Song.class, ".zipf");
//        endings.put( .class , "");
//        endings.put( .class , "");
//        endings.put( .class , "");
    }

    public static File copyFile(File file) {
        String path = removeEnding(file).getPath();
        String copyString = " - copy (";
        String ending = getEnding(file);
        int j = 1;
        if (path.contains(copyString)) {
            path = path.substring(0, path.indexOf(copyString));
        }
        while (new File(path + copyString + j + ")" + ending).exists()) {
            j++;
        }
        File copy = new File(path + copyString + j + ")");
        if (file.isDirectory()) {
            copy.mkdir();
            return copy;
        }
        Object o = load(file);
        if (o instanceof Event) {
            o = ((Event) o).copy();
            Counter.countAndName((Event) o);
        }
        save(o, copy);
        return copy;
    }

    public static String getEnding(File file) {
        String ending = ".";
        String[] tmp = file.getPath().split(Pattern.quote("."));
        ending += tmp[tmp.length - 1];
        return ending;
    }

    public static File removeEnding(File file) {
        return new File(file.getPath().substring(0, file.getPath().indexOf(getEnding(file))));
    }

    public FileIO() {
    }

    public static void save(Object o) {
        String pathString = "Library" + File.separator + o.getClass().getSimpleName();
        File path = new File(pathString);
        path.mkdir();
        File file = new File(pathString + File.separator + ToolsNode.name(o));
        save(o, file);
    }

    public static void save(Object o, File file) {
        String ending = endings.get(o.getClass());
        file = new File(file.getPath() + ending);
        if (o instanceof Propertable) {
            ((Propertable) o).collectProperties();
        }
        try {
            if (!new File(file.getParent()).exists()) {
                new File(file.getParent()).mkdir();
            }
            if (!file.exists()) {
                System.out.println(file);
                file.createNewFile();
                Controller.fileCreated();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        FileOutputStream fos = null;
        {
            ObjectOutputStream oos = null;
            try {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(o);
// <editor-fold defaultstate="collapsed" desc="catch">
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }// </editor-fold>
        }
    }

    public static Object load(File file) {
        Object o = null;
        if (file.isFile()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                o = ois.readObject();

// <editor-fold defaultstate="collapsed" desc="catch">
            } catch (IOException ex) {
                Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }// </editor-fold>
        return o;
    }

    public static String[] getFileList(Element e) {

        String[] strings;
        String[] tmp;

        File dir = new File("Library" + File.separator + e.getClass().getSimpleName());
        dir.mkdir();
        strings = dir.list();
        tmp = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            tmp[i] = strings[i].substring(0, strings[i].length() - 4);
        }

        return tmp;
    }
}
