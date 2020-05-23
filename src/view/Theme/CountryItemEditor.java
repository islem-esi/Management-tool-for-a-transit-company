package view.Theme;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxEditor;

public class CountryItemEditor extends BasicComboBoxEditor {
	private JPanel panel = new JPanel();
	private JLabel labelItem = new JLabel();
	static private String selectedValue;

	public CountryItemEditor() {
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1.0;
		constraints.insets = new Insets(2, 5, 2, 2);

		labelItem.setOpaque(false);
		labelItem.setHorizontalAlignment(JLabel.LEFT);
		labelItem.setForeground(Color.WHITE);

		panel.add(labelItem, constraints);
		panel.setBackground(new Color(0, 51, 102));

	}

	public Component getEditorComponent() {
		return this.panel;
	}

	public static String getNameItem() {
		return selectedValue;
	}

	public void setItem(Object item) {
		if (item == null) {
			return;
		}

		if(!(item instanceof String))
		{
			String[] countryItem = (String[]) item;
			selectedValue = countryItem[0];
			labelItem.setText(selectedValue);
			labelItem.setIcon(new ImageIcon(CountryItemEditor.class.getResource(countryItem[1])));

		}



	}
}