package zipf.GUI.table;

import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class CustomTable extends JTable{

    @Override
    public Component prepareEditor(TableCellEditor editor, int row, int column) {
               boolean isSelected = isCellSelected(row, column);
        Component comp = editor.getTableCellEditorComponent(this, null, isSelected,
                                                  row, column);
        if (comp instanceof JComponent) {
	    JComponent jComp = (JComponent)comp;
	    if (jComp.getNextFocusableComponent() == null) {
		jComp.setNextFocusableComponent(this);
	    }
	}
	return comp;
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {


        boolean isSelected = false;
        boolean hasFocus = false;

        // Only indicate the selection and focused cell if not printing
        if (!isPaintingForPrint()) {
            isSelected = isCellSelected(row, column);

            boolean rowIsLead =
                (selectionModel.getLeadSelectionIndex() == row);
            boolean colIsLead =
                (columnModel.getSelectionModel().getLeadSelectionIndex() == column);

            hasFocus = (rowIsLead && colIsLead) && isFocusOwner();
        }

	return renderer.getTableCellRendererComponent(this, null,
	                                              isSelected, hasFocus,
	                                              row, column);
    }



}
