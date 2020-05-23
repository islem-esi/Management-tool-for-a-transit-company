package view.Theme;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class CountryComboBox extends JComboBox {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel model;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CountryComboBox() {
		model = new DefaultComboBoxModel();
		setModel(model);
		setRenderer(new CountryItemRenderer());
		setEditor(new CountryItemEditor());
	}

	@SuppressWarnings("unchecked")
	public void addItems(String[][] items) {

		for (String[] anItem : items) {
			model.addElement(anItem);
		}
	}
}