package model.table;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.table.AbstractTableModel;

public class Bon_Visite_Tab extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<Boolean> rowList;
    private Set<Integer> checked = new TreeSet<Integer>();

	private final List<Bon_Visite_Model> BonVisite = new ArrayList<Bon_Visite_Model>();
	private final String[] entetes = { "N° Conteneur", "Fraude" };

	public Bon_Visite_Tab(int rows) {
        rowList = new ArrayList<Boolean>(rows);
        for (int i = 0; i < rows; i++) {
        }
		BonVisite.add(new Bon_Visite_Model("three"));

	}
    @Override
    public void setValueAt(Object aValue, int row, int col) {
        boolean b = (Boolean) aValue;
        rowList.set(row, b);
        if (b) {
            checked.add(row);
        } else {
            checked.remove(row);
        }
        fireTableRowsUpdated(row, row);
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 1;
    }


	@Override
	public Class getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return Boolean.class;
		default:
			return Object.class;
		}
	}

	public int getRowCount() {
		return BonVisite.size();
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
			return BonVisite.get(rowIndex).getNumConteneur();
		case 1:
			return BonVisite.get(rowIndex).getFraude();
		default:
			return null;
		}
	}

	public void addConteneur(Bon_Visite_Model bon_visi) {

		BonVisite.add(bon_visi);

		fireTableRowsInserted(BonVisite.size() - 1, BonVisite.size() - 1);
	}

	public void removeConteneur(int rowIndex) {
		BonVisite.remove(rowIndex);

		fireTableRowsDeleted(rowIndex, rowIndex);
	}
}
