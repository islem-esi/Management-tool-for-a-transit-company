package view.Parametres_View;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.entity.Marchandise;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Marchandise_View extends JFrame implements Parametre_View {
	// ********************* Les variables d'instance *********************//
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField_typeMarch;
	private JFrame frame;
	private JButton btn_ajouter;
	private JButton btn_modifier;
	private JButton btn_supprimer;
	private JTable table;
	private JLabel label;
	private JPanel panel;
	private JLabel lblMarchandise;

	// ********************* Le constructeur *********************//

	public Marchandise_View() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(new Rectangle(100, 10, 0, 0));
		frame.setTitle("Gestion des Marchandises");
		frame.setBounds(100, 100,637, 555);
		frame.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		//panel.setBackground(Color.WHITE);
		panel.setOpaque(false);
		panel.setBounds(0, 0, 652, 529);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		btn_ajouter = new JButton("");
		btn_ajouter.setRolloverIcon(new ImageIcon(Marchandise_View.class.getResource("/img/ajouter_ap.png")));
		btn_ajouter.setBounds(76, 225, 157, 45);
		panel.add(btn_ajouter);
		btn_ajouter.setBorder(null);
		btn_ajouter.setIcon(new ImageIcon(Marchandise_View.class.getResource("/img/ajouter.png")));

		btn_supprimer = new JButton("");
		btn_supprimer.setRolloverIcon(new ImageIcon(Marchandise_View.class.getResource("/img/dalete_ap.png")));
		btn_supprimer.setBounds(76, 281, 156, 44);
		panel.add(btn_supprimer);
		btn_supprimer.setBorder(null);
		btn_supprimer.setIcon(new ImageIcon(Marchandise_View.class.getResource("/img/delete.png")));

		btn_modifier = new JButton("");
		btn_modifier.setRolloverIcon(new ImageIcon(Marchandise_View.class.getResource("/img/edit_ap.png")));
		btn_modifier.setBounds(76, 338, 156, 44);
		panel.add(btn_modifier);
		btn_modifier.setBorder(null);
		btn_modifier.setIcon(new ImageIcon(Marchandise_View.class.getResource("/img/edit.png")));

		textField_typeMarch = new JTextField();
		textField_typeMarch.setForeground(Color.BLACK);
		textField_typeMarch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				btn_ajouter.setEnabled(! isChampVide());
				btn_supprimer.setEnabled(! isChampVide());
				btn_modifier.setEnabled((! isChampVide())&& (table.getSelectedRow()!= -1));
			}
		});
		textField_typeMarch.setBounds(76, 146, 183, 30);
		panel.add(textField_typeMarch);
		textField_typeMarch.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_typeMarch.setBackground(new Color(255, 255, 255));
		textField_typeMarch.setToolTipText("");
		textField_typeMarch.setColumns(10);

		JLabel lblTypeMarchandise = new JLabel("Type de Marchandise :");
		lblTypeMarchandise.setBounds(76, 129, 157, 14);
		panel.add(lblTypeMarchandise);
		lblTypeMarchandise.setForeground(new Color(0, 0, 128));
		lblTypeMarchandise.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(293, 102, 278, 363);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int ligne = 0;
				ligne = table.getSelectedRow();
				btn_supprimer.setEnabled(true);
				btn_ajouter.setEnabled(false);
				btn_modifier.setEnabled(false);
				String type = table.getModel().getValueAt(ligne, 0).toString();
				textField_typeMarch.setText(type);
			}
		});
		scrollPane.setViewportView(table);

		lblMarchandise = new JLabel("Marchandise");
		lblMarchandise.setForeground(new Color(0, 0, 128));
		lblMarchandise.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblMarchandise.setBounds(32, 19, 238, 45);
		panel.add(lblMarchandise);

		label = new JLabel("");
		label.setIcon(new ImageIcon(Marchandise_View.class.getResource("/img/wall2.png")));
		label.setBounds(0, 0, 684, 529);
		frame.getContentPane().add(label);

		frame.setVisible(true);

	}

	// ********************* Les getters & setters *********************//

	public JTextField getTextField_typeMarch() {
		return textField_typeMarch;
	}

	public void setTextField_typeMarch(JTextField textField_typeMarch) {
		this.textField_typeMarch = textField_typeMarch;
	}

	public JButton getBtn_ajouter() {
		return btn_ajouter;
	}

	public void setBtn_ajouter(JButton btn_ajouter) {
		this.btn_ajouter = btn_ajouter;
	}

	public JButton getBtn_supprimer() {
		return btn_supprimer;
	}

	public void setBtn_supprimer(JButton btn_supprimer) {
		this.btn_supprimer = btn_supprimer;
	}

	public JButton getBtn_modifier() {
		return btn_modifier;
	}

	public void setBtn_modifier(JButton btn_modifier) {
		this.btn_modifier = btn_modifier;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	// ********************* Les methodes ***********************//
	// Role: vide les textfeilds
	public boolean isChampVide() {
		if (textField_typeMarch.getText().equals(""))
			return true;
		return false;
	}

	// Role : teste si les textfeilds sont vides
	public void setChampsVides() {
		textField_typeMarch.setText("");
		enableAll(false);
	}

	// Role: teste le contenu des textfeilds est jette des exceptions
	public void Test() throws OverInderSize_Exception {
		int i;

		i = Util.OverInderSize(textField_typeMarch.getText(), 45, 2);
		if (i != 0)
			throw new OverInderSize_Exception(" le type est trés lang ! ", " Le type est trés court! ", i);

	}

	// Role: renvoit un objet de classe Marchandise qui contient les
	// informations
	// contenues dans les textfeilds
	public Marchandise getInformations() {
		return new Marchandise(textField_typeMarch.getText().toString());
	}

	// Role: crée un objet de classe Marchandise à partir du contenu d'une ligne
	// du
	// tableau
	public Marchandise RowToObject() {
		int i = table.getSelectedRow();
			if (i != -1) {
				String type = table.getModel().getValueAt(i, 0).toString();
				return new Marchandise(type);
			}
		return null;
	}

	public void enableAll(boolean oui){
		btn_ajouter.setEnabled(oui);
		btn_supprimer.setEnabled(oui);
		btn_modifier.setEnabled(oui);
	}
}
