package view;

import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import model.Utile;
import model.entity.Client;

public class Add_Dossier_View extends JFrame {

	// ------------------- Les déclarations  -----------------------//

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Rech_field;
	private JTable table;
	private JButton btnChoisir;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JFrame frame;
	private JTextField textField_3;
	private JButton btnAddClient;
	private JButton btnAnnuler;

	// -------------------------- Le constructeur --------------------------//

	public Add_Dossier_View() {

		frame = new JFrame();
		frame.setBounds(new Rectangle(100, 10, 0, 0));
		frame.setTitle("Chosir un Client :");
		frame.setResizable(false);
		frame.setBounds(0, 0, 986, 528);
		frame.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Rech_field = new JTextField();
		Rech_field.setBounds(86, 11, 75, 27);
		contentPane.add(Rech_field);
		Rech_field.setColumns(10);
		frame.getContentPane().setLayout(null);

		JLabel Txt_AjouterDossier = new JLabel("Code : ");
		Txt_AjouterDossier.setForeground(new Color(0, 0, 128));
		Txt_AjouterDossier.setBounds(24, 13, 75, 20);
		Txt_AjouterDossier.setFont(new Font("Khmer UI", Font.BOLD, 18));
		frame.getContentPane().add(Txt_AjouterDossier);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 49, 946, 402);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		Utile.Property_Table(table);
		Utile.Entete_Table(table);
		Utile.Centrer_Table(table);
		scrollPane.setViewportView(table);

		btnChoisir = new JButton("Choisir");
		btnChoisir.setForeground(new Color(0, 51, 102));
		btnChoisir.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		btnChoisir.setBounds(318, 462, 86, 23);
		frame.getContentPane().add(btnChoisir);

		JLabel label = new JLabel("Nom : ");
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("Khmer UI", Font.BOLD, 18));
		label.setBounds(171, 13, 75, 20);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				(new Client()).MultiRechClient(textField.getText(), textField_3.getText(), textField_1.getText(), textField_2.getText(), table);
			}
		});
		textField.setColumns(10);
		textField.setBounds(227, 11, 194, 27);
		frame.getContentPane().add(textField);

		JLabel lblEntreprise = new JLabel("Entreprise : ");
		lblEntreprise.setForeground(new Color(0, 0, 128));
		lblEntreprise.setFont(new Font("Khmer UI", Font.BOLD, 18));
		lblEntreprise.setBounds(431, 13, 106, 20);
		frame.getContentPane().add(lblEntreprise);

		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				(new Client()).MultiRechClient(textField.getText(), textField_3.getText(), textField_1.getText(), textField_2.getText(), table);
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(531, 11, 194, 27);
		frame.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				(new Client()).MultiRechClient(textField.getText(), textField_3.getText(), textField_1.getText(), textField_2.getText(), table);
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(774, 11, 194, 27);
		frame.getContentPane().add(textField_2);

		JLabel lblRc = new JLabel("RC : ");
		lblRc.setForeground(new Color(0, 0, 128));
		lblRc.setFont(new Font("Khmer UI", Font.BOLD, 18));
		lblRc.setBounds(733, 13, 52, 20);
		frame.getContentPane().add(lblRc);

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(new Color(204, 51, 0));
		btnAnnuler.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		btnAnnuler.setBounds(615, 462, 86, 23);
		frame.getContentPane().add(btnAnnuler);

		btnAddClient = new JButton("Ajouter Nouveau Client");
		btnAddClient.setForeground(new Color(0, 153, 51));
		btnAddClient.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		btnAddClient.setBounds(417, 462, 185, 23);
		frame.getContentPane().add(btnAddClient);

		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				(new Client()).MultiRechClient(textField.getText(), textField_3.getText(), textField_1.getText(), textField_2.getText(), table);
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(85, 13, 67, 27);
		frame.getContentPane().add(textField_3);

		// ////////////////////////// Debut Wallpaper /////////////////////////

		JLabel Wall = new JLabel("");
		Wall.setLocation(0, -72);
		Wall.setInheritsPopupMenu(false);
		Wall.setBounds(0, 0, 980, 500);
		Wall.setIcon(new ImageIcon(Add_Dossier_View.class.getResource("/img/wall2.png")));
		frame.getContentPane().add(Wall);
		frame.setVisible(true);
		// ////////////////////////// Fin Wallpaper /////////////////////////
	}

	// -------------------------- Les methodes --------------------------//

	public boolean ligne_Selected(int ligne)
	{
		if(ligne==-1) return false;
		return true;
	}

	// -----------------------------------------------------//

	public Client RecupereInfo(int ligne) {
		return new Client(
				Integer.parseInt(table.getModel().getValueAt(ligne, 0).toString()),
				table.getModel().getValueAt(ligne, 1).toString(),
				table.getModel().getValueAt(ligne, 2).toString(),
				table.getModel().getValueAt(ligne, 3).toString(),
				table.getModel().getValueAt(ligne, 4).toString(),
				table.getModel().getValueAt(ligne, 5).toString(),
				table.getModel().getValueAt(ligne, 6).toString(),
				table.getModel().getValueAt(ligne, 7).toString(),
				table.getModel().getValueAt(ligne, 8).toString());
					}

	// -----------------------------------------------------//

	public void Fermer() {
		frame.dispose();
	}

	// ----------------------- Les getters & setters ------------------------//

	public JTextField getRech_field() {
		return Rech_field;
	}

	public void setRech_field(JTextField rech_field) {
		Rech_field = rech_field;
	}


	public JButton getBtnAddClient() {
		return btnAddClient;
	}

	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnChoisir() {
		return btnChoisir;
	}

	public void setBtnChoisir(JButton btnChoisir) {
		this.btnChoisir = btnChoisir;
	}

}
