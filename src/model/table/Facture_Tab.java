package model.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class Facture_Tab extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	private final List<Facture_Model> Factures = new ArrayList<Facture_Model>();

	private final String[] entetes = { "Code", "Désignation","Qté" ,"Nbre","Prix Unitaire" ,"Prix HT","Debours","Observation" };

	public Facture_Tab() {
	}

	public int getRowCount() {
		return Factures.size();
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
			return Factures.get(rowIndex).getCode();
		case 1:
			return Factures.get(rowIndex).getDesignation();
		case 2:
			return Factures.get(rowIndex).getQte();
		case 3:
			return Factures.get(rowIndex).getNbre();
		case 4:
			return Factures.get(rowIndex).getPrixUnite();
		case 5:
			return Factures.get(rowIndex).getPrixHT();
		case 6:
			return Factures.get(rowIndex).getDebours();
		case 7:
			return Factures.get(rowIndex).getObservation();

		default:
			return null; // Ne devrait jamais arriver
		}
	}

	public void addDesignation(Facture_Model facture_Model) {
		Factures.add(facture_Model);

		fireTableRowsInserted(Factures.size() - 1, Factures.size() - 1);
	}

	public void removeDesignation(int rowIndex) {
		Factures.remove(rowIndex);

		fireTableRowsDeleted(rowIndex, rowIndex);
	}
}
