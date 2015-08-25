package zipf.GUI.table;

import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumberInput extends PlainDocument {

    JTextField field;

    public NumberInput(JTextField field) {
        this.field = field;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return;
        }
        super.insertString(offs, str, a);
        int i = Integer.parseInt(field.getText());
        if (i == 0) {
            field.setText("1");
        } else if (i > 256) {
            field.setText("256");
        }
    }
}
