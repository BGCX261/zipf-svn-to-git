package zipf.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import zipf.GUI.grid.Grid;
import zipf.GUI.grid.GridEdit;
import zipf.GUI.grid.GridTools;
import zipf.GUI.grid.ToolsBar;
import zipf.event.NoteSeq;
import zipf.event.Seq;
import zipf.event.Song;

public class MenuTools {

    private final Zipf zipf;
    JFileChooser fileChooser = new JFileChooser("Library" + File.separator + "Midi");
    FileNameExtensionFilter fileFilter = new FileNameExtensionFilter(
            "MIDI Files", "mid", "midi");

    MenuTools(final Zipf zipf) {
        this.zipf = zipf;
        fileChooser.setFileFilter(fileFilter);
        fileChooser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("ApproveSelection")) {
                    ((ToolsBar)GridTools.queueInEdit.tools).loadFileToNewGrid(fileChooser.getSelectedFile());
                }
            }
        });
    }

    void showFileChooser() {
        fileChooser.showOpenDialog(zipf.getContentPane());
    }
}
