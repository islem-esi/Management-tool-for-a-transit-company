package view.Parametres_View;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.entity.Agent_Douane;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
import java.awt.SystemColor;

import javax.swing.JTable;

public class AgentDouane_View extends JFrame implements Parametre_View {

	// ********************* Les variables d'instance *********************//

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JTextField field_Nom;
	private JTextField field_Prenom;
	private JTextField field_Mobile;
	private JButton btn_Ajouter;
	private JButton btn_Modifier;
	private JButton btn_Supprimer;
	private JTable table;

	// ********************* Le constructeur *********************//

	public AgentDouane_View() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(new Rectangle(100, 10, 0, 0));
		frame.setTitle("Agent douane");
		frame.setResizable(false);
		frame.setBounds(100, 100, 768, 600);
		frame.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.getContentPane().setLayout(null);

		field_Nom = new JTextField();
		field_Nom.setForeground(new Color(0, 0, 128));
		field_Nom.setFont(new Font("Calibri", Font.PLAIN, 15));
		field_Nom.setBackground(SystemColor.menu);
		field_Nom.setToolTipText("");
		field_Nom.setColumns(10);
		field_Nom.setBounds(69, 46, 194, 30);
		frame.getContentPane().add(field_Nom);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setForeground(new Color(0, 0, 128));
		lblNom.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNom.setBounds(69, 30, 49, 14);
		frame.getContentPane().add(lblNom);

		JLabel lbl_listeChauffeurs = new JLabel("Liste des agents de douane : ");
		lbl_listeChauffeurs.setForeground(new Color(0, 0, 128));
		lbl_listeChauffeurs.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbl_listeChauffeurs.setBounds(101, 135, 220, 30);
		frame.getContentPane().add(lbl_listeChauffeurs);

		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setForeground(new Color(0, 0, 128));
		lblPrnom.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPrnom.setBounds(291, 30, 74, 14);
		frame.getContentPane().add(lblPrnom);

		field_Prenom = new JTextField();
		field_Prenom.setForeground(new Color(0, 0, 128));
		field_Prenom.setFont(new Font("Calibri", Font.PLAIN, 15));
		field_Prenom.setBackground(SystemColor.menu);
		field_Prenom.setToolTipText("");
		field_Prenom.setColumns(10);
		field_Prenom.setBounds(291, 46, 194, 30);
		frame.getContentPane().add(field_Prenom);

		JLabel lblMobile = new JLabel("Mobile :");
		lblMobile.setForeground(new Color(0, 0, 128));
		lblMobile.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblMobile.setBounds(513, 30, 91, 14);
		frame.getContentPane().add(lblMobile);

		field_Mobile = new JTextField();
		field_Mobile.setForeground(new Color(0, 0, 128));
		field_Mobile.setFont(new Font("Calibri", Font.PLAIN, 15));
		field_Mobile.setBackground(SystemColor.menu);
		field_Mobile.setToolTipText("");
		field_Mobile.setColumns(10);
		field_Mobile.setBounds(513, 46, 194, 30);
		frame.getContentPane().add(field_Mobile);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 161, 560, 385);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int ligne;
				ligne = table.getSelectedRow();
				String nom = table.getModel().getValueAt(ligne, 0).toString();
				String prenom = table.getModel().getValueAt(ligne, 1).toString();
				String tel = table.getModel().getValueAt(ligne, 2).toString();
				field_Nom.setText(nom);
				field_Prenom.setText(prenom);
				field_Mobile.setText(tel);
			}
		});
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setOpaque(false);
		panel.setBounds(22, 11, 718, 549);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		btn_Ajouter = new JButton("");
		btn_Ajouter.setRolloverIcon(new ImageIcon(AgentDouane_View.class.getResource("/img/ajouter_ap.png")));
		btn_Ajouter.setBounds(114, 79, 157, 45);
		panel.add(btn_Ajouter);
		btn_Ajouter.setBorder(null);
		btn_Ajouter.setIcon(new ImageIcon(Chauffeur_View.class.getResource("/img/ajouter.png")));

		btn_Supprimer = new JButton("");
		btn_Supprimer.setRolloverIcon(new ImageIcon(AgentDouane_View.class.getResource("/img/dalete_ap.png")));
		btn_Supprimer.setBounds(281, 80, 156, 44);
		panel.add(btn_Supprimer);
		btn_Supprimer.setBorder(null);
		btn_Supprimer.setIcon(new ImageIcon(AgentDouane_View.class.getResource("/img/delete.png")));

		btn_Modifier = new JButton("");
		btn_Modifier.setRolloverIcon(new ImageIcon(AgentDouane_View.class.getResource("/img/edit_ap.png")));
		btn_Modifier.setBounds(447, 79, 156, 44);
		panel.add(btn_Modifier);
		btn_Modifier.setBorder(null);
		btn_Modifier.setIcon(new ImageIcon(AgentDouane_View.class.getResource("/img/edit.png")));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AgentDouane_View.class.getResource("/img/wall2.png")));
		label.setBounds(0, 0, 762, 571);
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

		field_Nom.setText("");
		field_Prenom.setText("");
		field_Mobile.setText("");

	}

	// Role : teste si les textfeilds sont vides
	public boolean isChampVide() {

		if (field_Nom.getText().equals("") || field_Prenom.getText().equals("") || field_Mobile.getText().equals(""))
			return true;
		return false;

	}

	// Role: renvoit un objet de classe AgentDouane qui contient les
	// informations contenues dans les textfeilds
	public Agent_Douane getInformations() {

		return new Agent_Douane(field_Nom.getText().toString(), field_Prenom.getText().toString(),
				field_Mobile.getText().toString());

	}

	// Role: teste le contenu des textfeilds est jette des exceptions
	public void Test() throws ChampVide_Exception, OverInderSize_Exception, NoLettersOrNoDigital_Exception {
		if (isChampVide())
			throw new ChampVide_Exception();
		int i;
		i = Util.OverInderSize(field_Nom.getText(), 45, 2);
		if (i != 0)
			throw new OverInderSize_Exception(" Le nom de l'agent est trés lang ! ",
					" Le nom de l'agent est trés court ! ", i);
		if (!Util.isJustChar(field_Nom.getText()))
			throw new NoLettersOrNoDigital_Exception(" Le nom ne doit pas contenir des chiffres ! ");

		i = Util.OverInderSize(field_Prenom.getText(), 45, 2);
		if (i != 0)
			throw new OverInderSize_Exception(" Le prénom de l'agent est trés lang ! ",
					" Le prénom de l'agent est trés court ! ", i);
		if (!Util.isJustChar(field_Prenom.getText()))
			throw new NoLettersOrNoDigital_Exception(" Le prénom ne doit pas contenir des chiffres ! ");

		i = Util.OverInderSize(field_Mobile.getText(), 20, 10);

		if (i != 0)
			throw new OverInderSize_Exception(" Le numéro de téléphone est trés lang ",
					" le numéro de téléphone est composé d'au moins 10 chiffres ! ", i);
		if (!Util.isJustDigit(field_Mobile.getText()))
			throw new NoLettersOrNoDigital_Exception(" Le numéro de téléphone ne doit pas contenir des lettres ! ");
	}

	// Role: crée un objet de classe Agent_Douane à partir du contenu d'une
	// ligne du tableau
	public Agent_Douane RowToObject() throws SelectedRow_Exception {
		int i;
		for (i = 0; i < table.getRowCount(); i++) {
			if (table.isRowSelected(i)) {
				String nom = table.getModel().getValueAt(i, 0).toString();
				String prenom = table.getModel().getValueAt(i, 1).toString();
				String tel = table.getModel().getValueAt(i, 2).toString();
				return new Agent_Douane(nom, prenom, tel);
			}
		}
		throw new SelectedRow_Exception(table.getRowCount(), " Vous n'avez pas séléctionné un agent ! ");
	}
}
