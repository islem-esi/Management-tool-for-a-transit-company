package view.Parametres_View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.entity.Designation;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

public class Designation_View extends JFrame {
	private static final long serialVersionUID = 1L;

	// ********************* Les variables d'instance *********************//

	private JPanel contentPane;
	private JFrame frame;
	private JTextField field_designation;
	private JTextField field_prixUnit;
	private JButton btn_Ajouter;
	private JButton btn_Modifier;
	private JButton btn_Supprimer;
	private JTable table;
	private JLabel label;
	private JPanel panel;
	private JTextField field_debours;
	private JLabel lblDsignation;
	private JLabel lblDa;
	private JLabel lbTestPrix;

	// ********************* Le constructeur *********************//

	public Designation_View() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(new Rectangle(100, 10, 0, 0));
		frame.setTitle("Designation");
		frame.setResizable(false);
		frame.setBounds(100, 100, 912, 585);
		frame.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		// panel.setBackground(Color.WHITE);
		panel.setOpaque(false);
		panel.setBounds(0, 0, 932, 549);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		field_designation = new JTextField();
		field_designation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				btn_Ajouter.setEnabled(!isChampVide());
				btn_Supprimer.setEnabled(!isChampVide());
				btn_Modifier.setEnabled((!isChampVide()) && (table.getSelectedRow() != -1));
			}
		});

		lblDa = new JLabel(" DA");
		lblDa.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblDa.setBackground(Color.LIGHT_GRAY);
		lblDa.setOpaque(true);
		lblDa.setForeground(new Color(0, 0, 128));
		lblDa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDa.setBounds(218, 260, 32, 30);
		panel.add(lblDa);
		field_designation.setBounds(56, 138, 194, 30);
		panel.add(field_designation);
		field_designation.setForeground(Color.BLACK);
		field_designation.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		field_designation.setBackground(Color.WHITE);
		field_designation.setToolTipText("");
		field_designation.setColumns(10);

		field_prixUnit = new JTextField();
		field_prixUnit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean valide = ctrlPrix(field_prixUnit.getText().toString());
				btn_Ajouter.setEnabled(!isChampVide() && valide);
				btn_Supprimer.setEnabled(!isChampVide()&& valide);
				btn_Modifier.setEnabled((!isChampVide())&& valide && (table.getSelectedRow() != -1));
			}
		});
		field_prixUnit.setBounds(56, 260, 162, 30);
		panel.add(field_prixUnit);
		field_prixUnit.setForeground(Color.BLACK);
		field_prixUnit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		field_prixUnit.setBackground(Color.WHITE);
		field_prixUnit.setToolTipText("");
		field_prixUnit.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 102, 560, 415);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int ligne;
				ligne = table.getSelectedRow();
				btn_Supprimer.setEnabled(true);
				btn_Ajouter.setEnabled(false);
				btn_Modifier.setEnabled(false);
				String desig = table.getModel().getValueAt(ligne, 0).toString();
				String prix = table.getModel().getValueAt(ligne, 1).toString();
				String debours = table.getModel().getValueAt(ligne, 2).toString();
				field_designation.setText(desig);
				field_prixUnit.setText(prix);
				field_debours.setText(debours);
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblDesignation = new JLabel("D\u00E9signation :");
		lblDesignation.setBounds(56, 113, 115, 19);
		panel.add(lblDesignation);
		lblDesignation.setForeground(new Color(0, 0, 128));
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JLabel lblPrixUnit = new JLabel("Prix unitaire  :");
		lblPrixUnit.setBounds(56, 239, 122, 14);
		panel.add(lblPrixUnit);
		lblPrixUnit.setForeground(new Color(0, 0, 128));
		lblPrixUnit.setFont(new Font("Times New Roman", Font.BOLD, 16));

		field_debours = new JTextField();
		field_debours.setForeground(Color.BLACK);
		field_debours.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		field_debours.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				btn_Ajouter.setEnabled(!isChampVide());
				btn_Supprimer.setEnabled(!isChampVide());
				btn_Modifier.setEnabled((!isChampVide()) && (table.getSelectedRow() != -1));
			}
		});
		field_debours.setBackground(Color.WHITE);
		field_debours.setBounds(56, 198, 194, 30);
		panel.add(field_debours);
		field_debours.setColumns(10);

		JLabel lblTypeDeDebours = new JLabel("Type de debours :");
		lblTypeDeDebours.setForeground(new Color(0, 0, 128));
		lblTypeDeDebours.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTypeDeDebours.setBounds(56, 179, 135, 14);
		panel.add(lblTypeDeDebours);

		btn_Ajouter = new JButton("");
		btn_Ajouter.setRolloverIcon(new ImageIcon(Designation_View.class.getResource("/img/ajouter_ap.png")));
		btn_Ajouter.setBounds(56, 336, 156, 44);
		panel.add(btn_Ajouter);
		btn_Ajouter.setBorder(null);
		btn_Ajouter.setIcon(new ImageIcon(Designation_View.class.getResource("/img/ajouter.png")));

		btn_Modifier = new JButton("");
		btn_Modifier.setRolloverIcon(new ImageIcon(Designation_View.class.getResource("/img/edit_ap.png")));
		btn_Modifier.setBounds(56, 446, 156, 44);
		panel.add(btn_Modifier);
		btn_Modifier.setBorder(null);
		btn_Modifier.setIcon(new ImageIcon(Designation_View.class.getResource("/img/edit.png")));

		btn_Supprimer = new JButton("");
		btn_Supprimer.setRolloverIcon(new ImageIcon(Designation_View.class.getResource("/img/dalete_ap.png")));
		btn_Supprimer.setBounds(56, 391, 156, 44);
		panel.add(btn_Supprimer);
		btn_Supprimer.setBorder(null);
		btn_Supprimer.setIcon(new ImageIcon(Designation_View.class.getResource("/img/delete.png")));

		lblDsignation = new JLabel("D\u00E9signation");
		lblDsignation.setForeground(new Color(0, 0, 128));
		lblDsignation.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblDsignation.setBounds(32, 19, 194, 41);
		panel.add(lblDsignation);

		lbTestPrix = new JLabel("pas de caract\u00E8re non num\u00E9rique");
		lbTestPrix.setBackground(new Color(173, 216, 230));
		lbTestPrix.setOpaque(true);
		lbTestPrix.setForeground(Color.RED);
		lbTestPrix.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbTestPrix.setBounds(56, 301, 209, 14);
		panel.add(lbTestPrix);

		label = new JLabel("");
		label.setIcon(new ImageIcon(Designation_View.class.getResource("/img/wall2.png")));
		label.setBounds(0, 0, 932, 571);
		frame.getContentPane().add(label);

		frame.setVisible(true);

	}

	// ********************* Les getters & setters *********************//

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtn_Ajouter() {
		return btn_Ajouter;
	}

	public JButton getBtn_Modifier() {
		return btn_Modifier;
	}

	public JButton getBtn_Supprimer() {
		return btn_Supprimer;
	}

	// ********************* Les methodes ***********************//
	// Role: vide les textfeilds
	public void setChampsVides() {

		field_designation.setText("");
		field_prixUnit.setText("");
		field_debours.setText("");
		enableAll(false);
	}

	// Role : teste si les textfeilds sont vides
	public boolean isChampVide() {

		if (field_designation.getText().equals("") || field_prixUnit.getText().equals("")
				|| field_debours.getText().equals(""))
			return true;
		return false;

	}

	// Role: renvoit un objet de classe Chauffeur qui contient les informations
	// contenues dans les textfeilds
	public Designation getInformations() {

		return new Designation(field_designation.getText().toString(), field_prixUnit.getText().toString(),
				field_debours.getText().toString());
	}

	// Role: teste le contenu des textfeilds est jette des exceptions
	public void Test() throws OverInderSize_Exception, NoLettersOrNoDigital_Exception, NumberFormatException {
		int i = 0;
		i = Util.OverInderSize(field_designation.getText(), 45, 2);
		if (i != 0)
			throw new OverInderSize_Exception(" Le nom de la désignation est trés lang ! ",
					" Le nom de la désignation est trés court ! ", i);
		// if (! Util.isJustChar(field_designation.getText()))
		// throw new NoLettersOrNoDigital_Exception(" Le nom ne doit pas
		// contenir des chiffres ! ");
		i = Util.OverInderSize(field_prixUnit.getText(), 20, 1);
		if (i != 0)
			throw new OverInderSize_Exception(" Le prix unitaire est trés lang ! ",
					" Le prix unitaire est trés court ! ", i);
		if (!Util.isJustDigit(field_prixUnit.getText()))
			throw new NoLettersOrNoDigital_Exception(" Le prix ne doit pas contenir des lettres ! ");

	}

	// Role: crée un objet de classe Chauffeur à partir du contenu d'une ligne
	// du tableau
	public Designation RowToObject() {
		int i = table.getSelectedRow();
		if (i != -1) {
			String design = table.getModel().getValueAt(i, 0).toString();
			String prix = table.getModel().getValueAt(i, 1).toString();
			String debours = table.getModel().getValueAt(i, 2).toString();
			return new Designation(design, prix, debours);
		}
		return null;
	}

	public void enableAll(boolean oui) {
		btn_Ajouter.setEnabled(oui);
		btn_Supprimer.setEnabled(oui);
		btn_Modifier.setEnabled(oui);
		lbTestPrix.setVisible(false);
	}

	public boolean ctrlPrix(String str){
		if(!Util.isJustDigit(str) && (str.length() >0)){
			lbTestPrix.setVisible(true);
			return false;
		}
		lbTestPrix.setVisible(false);
		return true;
	}
}
