package view.Parametres_View;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.entity.Utilisateur;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Utilisateur_View extends JFrame {
	private static final long serialVersionUID = 1L;

	// ********************* Les variables d'instance *********************//
	private JPanel contentPane;
	private JTextField field_Nom;
	private JFrame frame;
	private static JTable table;
	private static JButton btn_Supprimer, btn_Modifier, btn_Ajout;

	// ********************* Le constructeur *********************//
	public Utilisateur_View() {

		frame = new JFrame();
		frame.setBounds(new Rectangle(100, 10, 0, 0));
		frame.setTitle("Utilisateur");
		frame.setResizable(false);
		frame.setBounds(100, 100, 675, 576);
		frame.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.getContentPane().setLayout(null);

		field_Nom = new JTextField();
		field_Nom.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		field_Nom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				btn_Ajout.setEnabled(!isChampVide() && ctrlUser());
				btn_Supprimer.setEnabled(!isChampVide() && ctrlUser());
				btn_Modifier.setEnabled((!isChampVide()) && (table.getSelectedRow() != -1));
			}
		});
		field_Nom.setBounds(63, 144, 194, 30);
		field_Nom.setToolTipText("");
		field_Nom.setColumns(10);
		frame.getContentPane().add(field_Nom);

		JLabel lblNom = new JLabel("Utilisateur  :");
		lblNom.setBounds(63, 129, 91, 14);
		lblNom.setForeground(new Color(0, 0, 128));
		lblNom.setFont(new Font("Times New Roman", Font.BOLD, 16));
		frame.getContentPane().add(lblNom);
		btn_Ajout = new JButton("");
		btn_Ajout.setBorder(null);
		btn_Ajout.setBounds(63, 200, 156, 44);
		btn_Ajout.setRolloverIcon(new ImageIcon(Utilisateur_View.class.getResource("/img/ajouter_ap.png")));
		btn_Ajout.setIcon(new ImageIcon(Utilisateur_View.class.getResource("/img/ajouter.png")));
		frame.getContentPane().add(btn_Ajout);

		btn_Supprimer = new JButton("");
		btn_Supprimer.setBorder(null);
		btn_Supprimer.setBounds(63, 255, 156, 44);
		btn_Supprimer.setRolloverIcon(new ImageIcon(Utilisateur_View.class.getResource("/img/dalete_ap.png")));
		btn_Supprimer.setIcon(new ImageIcon(Utilisateur_View.class.getResource("/img/delete.png")));
		frame.getContentPane().add(btn_Supprimer);

		btn_Modifier = new JButton("");
		btn_Modifier.setBorder(null);
		btn_Modifier.setBounds(63, 310, 156, 44);
		frame.getContentPane().add(btn_Modifier);
		btn_Modifier.setRolloverIcon(new ImageIcon(Utilisateur_View.class.getResource("/img/edit_ap.png")));
		btn_Modifier.setIcon(new ImageIcon(Utilisateur_View.class.getResource("/img/edit.png")));

		JLabel lblUtilisateurs = new JLabel(" Utilisateur");
		lblUtilisateurs.setForeground(new Color(0, 0, 128));
		lblUtilisateurs.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblUtilisateurs.setBounds(32, 19, 237, 50);
		frame.getContentPane().add(lblUtilisateurs);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(311, 130, 279, 392);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btn_Ajout.setEnabled(false);
				btn_Modifier.setEnabled(true);
				int lig = table.getSelectedRow();
				String util = table.getModel().getValueAt(lig, 0).toString();
				field_Nom.setText(util);
				btn_Supprimer.setEnabled(ctrlUser());
			}
		});
		scrollPane.setViewportView(table);

		JLabel label_4 = new JLabel("");
		label_4.setForeground(new Color(0, 0, 128));
		label_4.setBounds(-22, -56, 768, 621);
		label_4.setIcon(new ImageIcon(Utilisateur_View.class.getResource("/img/wall2.png")));
		frame.getContentPane().add(label_4);

		frame.setVisible(true);

	}

	// ********************* Les getters & setters *********************//

	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable t) {
		table = t;
	}

	public static JButton getBtn_Ajouter() {
		return btn_Ajout;
	}

	public static JButton getBtn_Modifier() {
		return btn_Modifier;
	}

	public static JButton getBtn_Supprimer() {
		return btn_Supprimer;
	}

	public String getNomUtilisateur(){
		return field_Nom.getText().toString();
	}


	// ********************* Les methodes ***********************//
	public boolean isChampVide() {
		return field_Nom.getText().toString().equals("");
	}

	// Role: vide les textfeilds
	public void setChampsVides() {

		field_Nom.setText("");
		enableAll(false);
	}

	public String RowToString() {
		int i = table.getSelectedRow();
		if (i != -1) {
			String nom = table.getModel().getValueAt(i, 0).toString();
			return nom;
		}
		return null;
	}

	public void enableAll(boolean oui) {
		btn_Ajout.setEnabled(oui);
		btn_Supprimer.setEnabled(oui);
		btn_Modifier.setEnabled(oui);
	}

	public void Test() throws OverInderSize_Exception {

		int i;
		i = Util.OverInderSize(field_Nom.getText().toString(), 45, 1);
		if (i != 0)
			throw new OverInderSize_Exception(" le nom d'utilisateur est trés lang ! ",
					" Le nom d'utilisateur est court ! ", i);

	}

	public Utilisateur getInformations(String password) {
		return new Utilisateur(field_Nom.getText().toString(),password);
	}

	public Utilisateur RowToObject() {
		int i = table.getSelectedRow();
		if (i != -1) {
			String nom = table.getModel().getValueAt(i, 0).toString();
			return new Utilisateur(nom, null);
		}
		return null;
	}

	public boolean ctrlUser(){
		String user = field_Nom.getText().toString();
		return !user.equals(Utilisateur.getAdmin());
	}
}
