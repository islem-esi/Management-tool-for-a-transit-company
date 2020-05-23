package view.Parametres_View;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.entity.Camion;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import java.awt.Rectangle;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Camion_View extends JFrame implements Parametre_View {

	// ********************* Les variables d'instance *********************//
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField field_Matricule;
	private JFrame frame;
	private JButton btn_Ajout;
	private JButton btn_Supprimer;
	private JButton btn_Modifier;
	private JTable table;
	private JLabel label;
	private JPanel panel;
	private JLabel lbTestChar;
	private JLabel lbTestSize;

	// ********************* Le constructeur *********************//

	public Camion_View() {

		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 11));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(new Rectangle(100, 10, 0, 0));
		frame.setTitle("Camion");
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
		panel.setBounds(0, 0, 718, 547);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		btn_Ajout = new JButton("");
		btn_Ajout.setRolloverIcon(new ImageIcon(Marchandise_View.class.getResource("/img/ajouter_ap.png")));
		btn_Ajout.setBounds(76, 225, 157, 45);
		panel.add(btn_Ajout);
		btn_Ajout.setBorder(null);
		btn_Ajout.setIcon(new ImageIcon(Marchandise_View.class.getResource("/img/ajouter.png")));

		btn_Supprimer = new JButton("");
		btn_Supprimer.setRolloverIcon(new ImageIcon(Marchandise_View.class.getResource("/img/dalete_ap.png")));
		btn_Supprimer.setBounds(76, 281, 156, 44);
		panel.add(btn_Supprimer);
		btn_Supprimer.setBorder(null);
		btn_Supprimer.setIcon(new ImageIcon(Marchandise_View.class.getResource("/img/delete.png")));

		btn_Modifier = new JButton("");
		btn_Modifier.setRolloverIcon(new ImageIcon(Marchandise_View.class.getResource("/img/edit_ap.png")));
		btn_Modifier.setBounds(76, 338, 156, 44);
		panel.add(btn_Modifier);
		btn_Modifier.setBorder(null);
		btn_Modifier.setIcon(new ImageIcon(Marchandise_View.class.getResource("/img/edit.png")));

		JLabel lblNom = new JLabel("Matricule :");
		lblNom.setBounds(76, 129, 80, 14);
		panel.add(lblNom);
		lblNom.setForeground(new Color(0, 0, 128));
		lblNom.setFont(new Font("Times New Roman", Font.BOLD, 16));

		field_Matricule = new JTextField();
		field_Matricule.setBounds(76, 146, 183, 30);
		field_Matricule.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean valide = ctrlMatricule(field_Matricule.getText().toString());
				btn_Ajout.setEnabled(! isChampVide() && valide);
				btn_Supprimer.setEnabled(! isChampVide() && valide);
				btn_Modifier.setEnabled((! isChampVide())&& valide && (table.getSelectedRow()!= -1));
			}
		});
		panel.add(field_Matricule);
		field_Matricule.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		field_Matricule.setForeground(Color.BLACK);
		field_Matricule.setBackground(Color.WHITE);
		field_Matricule.setToolTipText("");
		field_Matricule.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 102, 278, 363);
		panel.add(scrollPane);
		scrollPane.setForeground(SystemColor.activeCaption);
		scrollPane.setBackground(SystemColor.activeCaption);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btn_Supprimer.setEnabled(true);
				btn_Ajout.setEnabled(false);
				btn_Modifier.setEnabled(false);
				int ligne = 0;
				ligne = table.getSelectedRow();

				String matricule = table.getModel().getValueAt(ligne, 0).toString();
				field_Matricule.setText(matricule);
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblCamion = new JLabel("Camion");
		lblCamion.setBounds(32, 19, 299, 45);
		lblCamion.setForeground(new Color(0, 0, 128));
		lblCamion.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel.add(lblCamion);

		lbTestSize = new JLabel("pas moins que 11 chiffres");
		lbTestSize.setBackground(new Color(175, 238, 238));
		lbTestSize.setOpaque(true);
		lbTestSize.setForeground(Color.RED);
		lbTestSize.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbTestSize.setBounds(76, 187, 173, 14);
		panel.add(lbTestSize);

		lbTestChar = new JLabel("pas de caract\u00E8re non num\u00E9rique");
		lbTestChar.setBackground(new Color(175, 238, 238));
		lbTestChar.setOpaque(true);
		lbTestChar.setForeground(Color.RED);
		lbTestChar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbTestChar.setBounds(76, 187, 207, 14);
		panel.add(lbTestChar);

		label = new JLabel("");
		label.setIcon(new ImageIcon(Camion_View.class.getResource("/img/wall2.png")));
		label.setBounds(0, 0, 815, 547);
		frame.getContentPane().add(label);

		frame.setVisible(true);

	}

	// ********************* Les getters & setters *********************//

	public JTextField getField_Matricule() {
		return field_Matricule;
	}

	public void setField_Matricule(JTextField field_Matricule) {
		this.field_Matricule = field_Matricule;
	}

	public JButton getBtn_Ajout() {
		return btn_Ajout;
	}

	public void setBtn_Ajout(JButton btn_Ajout) {
		this.btn_Ajout = btn_Ajout;
	}

	public JButton getBtn_Supprimer() {
		return btn_Supprimer;
	}

	public void setBtn_Supprimer(JButton btn_Supprimer) {
		this.btn_Supprimer = btn_Supprimer;
	}

	public JButton getBtn_Modifier() {
		return btn_Modifier;
	}

	public void setBtn_Modifier(JButton btn_Modifier) {
		this.btn_Modifier = btn_Modifier;
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
		if (field_Matricule.getText().equals(""))
			return true;
		return false;
	}

	// Role : teste si les textfeilds sont vides
	public void setChampsVides() {
		field_Matricule.setText("");
		enableAll(false);
	}

	// Role: teste le contenu des textfeilds est jette des exceptions
	public void Test() throws OverInderSize_Exception, NoLettersOrNoDigital_Exception {

		int i;
		if (!Util.isJustDigit(field_Matricule.getText()))
			throw new NoLettersOrNoDigital_Exception(" La matricule ne doit pas contenir des lettres ! ");

		i = Util.OverInderSize(field_Matricule.getText(), 20, 11);
		if (i != 0)
			throw new OverInderSize_Exception(" la matricule est trés langue ! ",
					" La matricule d'un camion est composée d'au moins 11 chiffres ! ", i);

	}

	// Role: renvoit un objet de classe Camion qui contient les informations
	// contenues dans les textfeilds
	public Camion getInformations() {
		return new Camion(field_Matricule.getText().toString());
	}

	// Role: crée un objet de classe Camion à partir du contenu d'une ligne du
	// tableau
	public Camion RowToObject() {

		int i = table.getSelectedRow();
		if (i != -1) {
				String matr = table.getModel().getValueAt(i, 0).toString();
				return new Camion(matr);
		}
		return null;
	}

	public void enableAll(boolean oui){
		btn_Ajout.setEnabled(oui);
		btn_Supprimer.setEnabled(oui);
		btn_Modifier.setEnabled(oui);
		lbTestSize.setVisible(false);
		lbTestChar.setVisible(false);
	}

	public boolean ctrlMatricule(String str){
		if(!Util.isJustDigit(str)){
			lbTestChar.setVisible(true);
			lbTestSize.setVisible(false);
			return false;
		}
		if((str.length()<11)&&(str.length()>0)){
			lbTestSize.setVisible(true);
			lbTestChar.setVisible(false);
			return false;
		}
		lbTestChar.setVisible(false);
		lbTestSize.setVisible(false);
		return true;
	}
}


