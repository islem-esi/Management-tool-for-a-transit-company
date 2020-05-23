package view.Parametres_View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.entity.Declarant;
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

import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Declarant_View extends JFrame implements Parametre_View {
	private static final long serialVersionUID = 1L;

	// ********************* Les variables d'instance *********************//

	private JPanel contentPane;
	private JFrame frame;
	private JTextField field_Nom;
	private JTextField field_Prenom;
	private JTextField field_Mobile;
	private JButton btn_Ajouter;
	private JButton btn_Modifier;
	private JButton btn_Supprimer;
	private JTable table;
	private JLabel lblDclarant;
	private JLabel lbTestSize;
	private JLabel lbTestChar;

	// ********************* Le constructeur *********************//

	public Declarant_View() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(new Rectangle(100, 10, 0, 0));
		frame.setTitle("Déclarant");
		frame.setResizable(false);
		frame.setBounds(100, 100, 912, 585);
		frame.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		// panel.setBackground(Color.WHITE);
		panel.setOpaque(false);
		panel.setBounds(0, 0, 935, 597);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		btn_Ajouter = new JButton("");
		btn_Ajouter.setRolloverIcon(new ImageIcon(Declarant_View.class.getResource("/img/ajouter_ap.png")));
		btn_Ajouter.setBounds(56, 336, 157, 45);
		panel.add(btn_Ajouter);
		btn_Ajouter.setBorder(null);
		btn_Ajouter.setIcon(new ImageIcon(Chauffeur_View.class.getResource("/img/ajouter.png")));

		btn_Supprimer = new JButton("");
		btn_Supprimer.setRolloverIcon(new ImageIcon(Declarant_View.class.getResource("/img/dalete_ap.png")));
		btn_Supprimer.setBounds(56, 392, 156, 44);
		panel.add(btn_Supprimer);
		btn_Supprimer.setBorder(null);
		btn_Supprimer.setIcon(new ImageIcon(Declarant_View.class.getResource("/img/delete.png")));

		btn_Modifier = new JButton("");
		btn_Modifier.setRolloverIcon(new ImageIcon(Declarant_View.class.getResource("/img/edit_ap.png")));
		btn_Modifier.setBounds(56, 447, 156, 44);
		panel.add(btn_Modifier);
		btn_Modifier.setBorder(null);
		btn_Modifier.setIcon(new ImageIcon(Declarant_View.class.getResource("/img/edit.png")));

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
				String nom = table.getModel().getValueAt(ligne, 0).toString();
				String prenom = table.getModel().getValueAt(ligne, 1).toString();
				String tel = table.getModel().getValueAt(ligne, 2).toString();
				field_Nom.setText(nom);
				field_Prenom.setText(prenom);
				field_Mobile.setText(tel);
			}
		});
		scrollPane.setViewportView(table);

		field_Mobile = new JTextField();
		field_Mobile.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean valide = ctrlMobile(field_Mobile.getText().toString());
				btn_Ajouter.setEnabled(!isChampVide() && valide);
				btn_Supprimer.setEnabled(!isChampVide() && valide);
				btn_Modifier.setEnabled((!isChampVide()) && valide && (table.getSelectedRow() != -1));
			}
		});
		field_Mobile.setBounds(56, 260, 194, 30);
		panel.add(field_Mobile);
		field_Mobile.setForeground(Color.BLACK);
		field_Mobile.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		field_Mobile.setBackground(Color.WHITE);
		field_Mobile.setToolTipText("");
		field_Mobile.setColumns(10);

		field_Prenom = new JTextField();
		field_Prenom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				btn_Ajouter.setEnabled(!isChampVide());
				btn_Supprimer.setEnabled(!isChampVide());
				btn_Modifier.setEnabled((!isChampVide()) && (table.getSelectedRow() != -1));
			}
		});
		field_Prenom.setBounds(56, 198, 194, 30);
		panel.add(field_Prenom);
		field_Prenom.setForeground(Color.BLACK);
		field_Prenom.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		field_Prenom.setBackground(Color.WHITE);
		field_Prenom.setToolTipText("");
		field_Prenom.setColumns(10);

		JLabel lblMobile = new JLabel("Mobile :");
		lblMobile.setBounds(56, 245, 91, 14);
		panel.add(lblMobile);
		lblMobile.setForeground(new Color(0, 0, 128));
		lblMobile.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setBounds(56, 179, 74, 14);
		panel.add(lblPrnom);
		lblPrnom.setForeground(new Color(0, 0, 128));
		lblPrnom.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(56, 121, 49, 14);
		panel.add(lblNom);
		lblNom.setForeground(new Color(0, 0, 128));
		lblNom.setFont(new Font("Times New Roman", Font.BOLD, 16));

		field_Nom = new JTextField();
		field_Nom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				btn_Ajouter.setEnabled(!isChampVide());
				btn_Supprimer.setEnabled(!isChampVide());
				btn_Modifier.setEnabled((!isChampVide()) && (table.getSelectedRow() != -1));
			}
		});
		field_Nom.setBounds(56, 138, 194, 30);
		panel.add(field_Nom);
		field_Nom.setForeground(Color.BLACK);
		field_Nom.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		field_Nom.setBackground(Color.WHITE);
		field_Nom.setToolTipText("");
		field_Nom.setColumns(10);

		lblDclarant = new JLabel("D\u00E9clarant");
		lblDclarant.setForeground(new Color(0, 0, 128));
		lblDclarant.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblDclarant.setBounds(32, 19, 205, 45);
		panel.add(lblDclarant);

		lbTestSize = new JLabel("pas moins que 10 chiffres");
		lbTestSize.setBackground(new Color(175, 238, 238));
		lbTestSize.setOpaque(true);
		lbTestSize.setForeground(Color.RED);
		lbTestSize.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbTestSize.setBounds(56, 298, 157, 14);
		panel.add(lbTestSize);

		lbTestChar = new JLabel("pas de caract\u00E8re non num\u00E9rique");
		lbTestChar.setBackground(new Color(175, 238, 238));
		lbTestChar.setOpaque(true);
		lbTestChar.setForeground(Color.RED);
		lbTestChar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbTestChar.setBounds(56, 298, 205, 14);
		panel.add(lbTestChar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AgentDouane_View.class.getResource("/img/wall2.png")));
		label.setBounds(0, 0, 935, 597);
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
		enableAll(false);

	}

	// Role : teste si les textfeilds sont vides
	public boolean isChampVide() {

		if (field_Nom.getText().equals("") || field_Prenom.getText().equals("") || field_Mobile.getText().equals(""))
			return true;
		return false;

	}

	// Role: renvoit un objet de classe AgentDouane qui contient les
	// informations contenues dans les textfeilds
	public Declarant getInformations() {

		return new Declarant(field_Nom.getText().toString(), field_Prenom.getText().toString(),
				field_Mobile.getText().toString());

	}

	// Role: teste le contenu des textfeilds est jette des exceptions
	public void Test() throws OverInderSize_Exception, NoLettersOrNoDigital_Exception {
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
	public Declarant RowToObject() {
		int i = table.getSelectedRow();
		if (i != -1) {
			String nom = table.getModel().getValueAt(i, 0).toString();
			String prenom = table.getModel().getValueAt(i, 1).toString();
			String tel = table.getModel().getValueAt(i, 2).toString();
			return new Declarant(nom, prenom, tel);
		}
		return null;
	}

	public void enableAll(boolean oui) {
		btn_Ajouter.setEnabled(oui);
		btn_Supprimer.setEnabled(oui);
		btn_Modifier.setEnabled(oui);
		lbTestChar.setVisible(false);
		lbTestSize.setVisible(false);
	}

	public boolean ctrlMobile(String str) {
		if (str.length() > 0) {
			if (!Util.isJustDigit(str)) {
				lbTestChar.setVisible(true);
				lbTestSize.setVisible(false);
				return false;
			}
			if (str.length() < 10) {
				lbTestSize.setVisible(true);
				lbTestChar.setVisible(false);
				return false;
			}
		}
		lbTestChar.setVisible(false);
		lbTestSize.setVisible(false);
		return true;
	}
}
