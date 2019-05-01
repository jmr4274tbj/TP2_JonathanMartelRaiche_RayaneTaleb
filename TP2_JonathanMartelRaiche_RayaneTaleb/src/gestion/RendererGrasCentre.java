package gestion;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class RendererGrasCentre extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;
	@Override
    public Component getTableCellRendererComponent(JTable table,//le JTable qui appelle le renderer
    												Object value,//valeur � attribuer � la cellule qui sera affect�e par le renderer
    												boolean isSelected,//vrai si la cellule est s�lectionn�e
    												boolean hasFocus, //vrai si la cellule a le focus
    												int row,//num�ro de ligne de la cellule concern�e
    												int column//num�ro de colonne de la cellule concern�e

    												) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setFont(getFont().deriveFont(Font.BOLD));
        setHorizontalAlignment(CENTER);
        return this;
    }
}
