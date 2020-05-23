package model.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class Dos_Cont_Tab extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private final List<Dos_Cont_Model> dosiers_Cont = new ArrayList<Dos_Cont_Model>();
	private final String[] entetes = { "Marque","N° TC","N° Plompage","Type TC","Type Marchandise","Poids","Valeur" };


	public Dos_Cont_Tab() {

	}

	public int getRowCount() {
		return dosiers_Cont.size();
	}

	public int getColumnCount() {
		return entetes.length;
	}

	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return dosiers_Cont.get(rowIndex).getMarque();
		case 1:
			return dosiers_Cont.get(rowIndex).getNumConteneur();
		case 2:
			return dosiers_Cont.get(rowIndex).getNoPlomb();
		case 3:
			return dosiers_Cont.get(rowIndex).getTypeConteneur();
		case 4:
			return dosiers_Cont.get(rowIndex).getTypeMarchandise();
		case 5:
			return dosiers_Cont.get(rowIndex).getPoids();
		case 6:
			return dosiers_Cont.get(rowIndex).getValeur();

		default:
			return null; // Ne devrait jamais arriver
		}
	}

	public void addConteneur(Dos_Cont_Model dos_cont) {
		dosiers_Cont.add(dos_cont);

		fireTableRowsInserted(dosiers_Cont.size() - 1, dosiers_Cont.size() - 1);
	}

	public void removeConteneur(int rowIndex) {
		dosiers_Cont.remove(rowIndex);

		fireTableRowsDeleted(rowIndex, rowIndex);
	}
}
