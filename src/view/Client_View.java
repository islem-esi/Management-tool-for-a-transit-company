package view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import model.Utile;
import model.entity.Client;
import java.awt.SystemColor;

public class Client_View extends JFrame {

	// ------------------- Les déclarations  -----------------------//
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField field_Nom;
	private JTextField field_Prenom;
	private JButton Ajouter_Btn;
	private JButton Modifier_Btn;
	private JComboBox<String> combo_RechPar;
	private JButton Suprimer_Btn;
	private JTextField field_Raison;
	private JTextField field_Mobile;
	private JTextField field_Email;
	private JTextField field_RC;
	private JTextField field_CarteF;
	private JTextField Rech_field;
	private JButton Print_Btn;
	private JButton Returne;
	private JTextField field_Adresse;
	private JTable table;
	private JLabel errorLabel;
	private JLabel label;

	// -------------------------- Le constructeur --------------------------//
	public Client_View() {
		contentPane = new JPanel();

		///////////////////// Ajuster la taille de la fenetre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		setSize(screenSize.width, screenSize.height - taskBarSize);
		setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());
		setContentPane(contentPane);

		///////////////////// Fin Ajuster la taille de la fenetre

		contentPane.setLayout(null);

		Returne = new JButton("");
		Returne.setIcon(new ImageIcon(Client_View.class.getResource("/img/return_av.png")));
		Returne.setContentAreaFilled(false);
		Returne.setBorderPainted(false);
		Returne.setBounds(0, 0, 113, 104);
		Returne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Returne.setIcon(new ImageIcon(Menu.class.getResource("/img/return_ap.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Returne.setIcon(new ImageIcon(Menu.class.getResource("/img/return_av.png")));
			}
		});
		contentPane.add(Returne);

		Menu menu = new Menu();
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1366, 111);
		panel_1 = menu.getPanel();
		contentPane.add(panel_1);

		field_Nom = new JTextField();
		field_Nom.setBackground(Color.WHITE);
		field_Nom.addKeyListener(new KeyAdapter() {
			@Override

			public void keyReleased(KeyEvent arg0) {
				control_nom();
				eanableAddClient();
			}
		});
		field_Nom.setFont(new Font("Serif", Font.BOLD, 13));
		field_Nom.setHorizontalAlignment(JTextField.CENTER);
		field_Nom.setBounds(1152, 180, 164, 30);
		contentPane.add(field_Nom);
		field_Nom.setColumns(10);

		field_Prenom = new JTextField();
		field_Prenom.setHorizontalAlignment(SwingConstants.CENTER);
		field_Prenom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				controlPrenom();
				eanableAddClient();
			}
		});

		field_Prenom.setFont(new Font("Serif", Font.BOLD, 13));
		field_Prenom.setBounds(1152, 246, 164, 30);
		contentPane.add(field_Prenom);
		field_Prenom.setColumns(10);

		Ajouter_Btn = new JButton("");
		Ajouter_Btn.setRolloverIcon(new ImageIcon(Client_View.class.getResource("/img/ajouter_ap.png")));

		Ajouter_Btn.setIcon(new ImageIcon(Client_View.class.getResource("/img/ajouter.png")));
		Ajouter_Btn.setEnabled(false);
		Ajouter_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnabledAll();
			}
		});

		field_Raison = new JTextField();
		field_Raison.setHorizontalAlignment(SwingConstants.CENTER);
		field_Raison.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
		});

		field_Raison.setFont(new Font("Serif", Font.BOLD, 13));
		field_Raison.setToolTipText("");
		field_Raison.setColumns(10);
		field_Raison.setBounds(1152, 312, 164, 30);
		contentPane.add(field_Raison);

		field_Mobile = new JTextField();
		field_Mobile.setHorizontalAlignment(SwingConstants.CENTER);
		field_Mobile.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				controlPhone();
				eanableAddClient();
			}
		});

		field_Mobile.setFont(new Font("Serif", Font.BOLD, 13));
		field_Mobile.setColumns(10);
		field_Mobile.setBounds(1152, 447, 164, 30);
		contentPane.add(field_Mobile);

		field_Email = new JTextField();
		field_Email.setHorizontalAlignment(SwingConstants.CENTER);
		field_Email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				controlEmail();
				eanableAddClient();
			}
		});

		field_Email.setFont(new Font("Serif", Font.BOLD, 13));
		field_Email.setToolTipText("");
		field_Email.setColumns(10);
		field_Email.setBounds(1152, 517, 164, 30);
		contentPane.add(field_Email);

		field_RC = new JTextField();
		field_RC.setHorizontalAlignment(SwingConstants.CENTER);
		field_RC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				eanableAddClient();
			}
		});

		field_RC.setFont(new Font("Serif", Font.BOLD, 13));
		field_RC.setColumns(10);
		field_RC.setBounds(1152, 587, 164, 30);
		contentPane.add(field_RC);

		field_Adresse = new JTextField();
		field_Adresse.setHorizontalAlignment(SwingConstants.CENTER);
		field_Adresse.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				eanableAddClient();
			}
		});

		field_Adresse.setFont(new Font("Serif", Font.BOLD, 13));
		field_Adresse.setToolTipText("");
		field_Adresse.setColumns(10);
		field_Adresse.setBounds(1152, 382, 164, 30);
		contentPane.add(field_Adresse);

		field_CarteF = new JTextField();
		field_CarteF.setHorizontalAlignment(SwingConstants.CENTER);
		field_CarteF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				eanableAddClient();
			}
		});

		field_CarteF.setFont(new Font("Serif", Font.BOLD, 13));
		field_CarteF.setColumns(10);
		field_CarteF.setBounds(1152, 649, 164, 30);
		contentPane.add(field_CarteF);
		Ajouter_Btn.setBounds(284, 635, 156, 44);
		contentPane.add(Ajouter_Btn);

		Rech_field = new JTextField();
		Rech_field.setBorder(null);
		Rech_field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		Rech_field.setBounds(634, 138, 142, 21);
		contentPane.add(Rech_field);
		Rech_field.setColumns(10);

		JLabel lblR = new JLabel("Rechercher Par : ");
		lblR.setForeground(new Color(178, 34, 34));
		lblR.setFont(new Font("Arial", Font.BOLD, 17));
		lblR.setBounds(372, 136, 150, 20);
		contentPane.add(lblR);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 182, 1056, 442);
		contentPane.add(scrollPane);

		table = new JTable();
		Utile.Property_Table(table);
		Utile.Entete_Table(table);
		Utile.Centrer_Table(table);

		scrollPane.setViewportView(table);

		Modifier_Btn = new JButton("");
		Modifier_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnabledAll();

			}
		});

		Modifier_Btn.setRolloverIcon(new ImageIcon(Client_View.class.getResource("/img/edit_ap.png")));
		Modifier_Btn.setIcon(new ImageIcon(Client_View.class.getResource("/img/edit.png")));
		Modifier_Btn.setEnabled(false);
		Modifier_Btn.setBounds(461, 635, 156, 44);
		contentPane.add(Modifier_Btn);

		Suprimer_Btn = new JButton("");
		Suprimer_Btn.setRolloverIcon(new ImageIcon(Client_View.class.getResource("/img/dalete_ap.png")));
		Suprimer_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnabledAll();
			}
		});

		Suprimer_Btn.setIcon(new ImageIcon(Client_View.class.getResource("/img/delete.png")));
		Suprimer_Btn.setEnabled(false);

		Suprimer_Btn.setBounds(634, 635, 156, 44);
		contentPane.add(Suprimer_Btn);

		JLabel lblNom = new JLabel("* Nom : ");
		lblNom.setForeground(new Color(0, 0, 128));
		lblNom.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblNom.setBounds(1194, 155, 89, 22);
		contentPane.add(lblNom);

		JLabel lblPrnom = new JLabel("* Pr\u00E9nom : ");
		lblPrnom.setForeground(new Color(0, 0, 128));
		lblPrnom.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblPrnom.setBounds(1184, 221, 99, 22);
		contentPane.add(lblPrnom);

		JLabel lblRaisonSocial = new JLabel("* Raison Social : ");
		lblRaisonSocial.setForeground(new Color(0, 0, 128));
		lblRaisonSocial.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblRaisonSocial.setBounds(1159, 287, 142, 22);
		contentPane.add(lblRaisonSocial);

		JLabel lblMobile = new JLabel("* Mobile : ");
		lblMobile.setForeground(new Color(0, 0, 128));
		lblMobile.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblMobile.setBounds(1185, 423, 89, 22);
		contentPane.add(lblMobile);

		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setForeground(new Color(0, 0, 128));
		lblEmail.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblEmail.setBounds(1208, 494, 89, 22);
		contentPane.add(lblEmail);

		JLabel lblRegistreCommerce = new JLabel("* N\u00B0 RC : ");
		lblRegistreCommerce.setForeground(new Color(0, 0, 128));
		lblRegistreCommerce.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblRegistreCommerce.setBounds(1198, 562, 85, 22);
		contentPane.add(lblRegistreCommerce);

		JLabel lblCarteFiscale = new JLabel("Carte Fiscale : ");
		lblCarteFiscale.setForeground(new Color(0, 0, 128));
		lblCarteFiscale.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblCarteFiscale.setBounds(1168, 628, 133, 22);
		contentPane.add(lblCarteFiscale);

		JLabel lblGestionDeClients = new JLabel("Clients");
		lblGestionDeClients.setForeground(new Color(0, 51, 102));
		lblGestionDeClients.setFont(new Font("Rockwell", Font.BOLD, 36));
		lblGestionDeClients.setBounds(79, 108, 150, 62);
		contentPane.add(lblGestionDeClients);

		combo_RechPar = new JComboBox<String>();
		combo_RechPar.setForeground(new Color(25, 25, 112));
		combo_RechPar.setFont(new Font("Tahoma", Font.BOLD, 14));
		combo_RechPar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rech_field.setText("");
			}
		});
		combo_RechPar.setModel(new DefaultComboBoxModel<String>(new String[] { "Nom", "Code" }));
		combo_RechPar.setBounds(519, 128, 66, 37);
		contentPane.add(combo_RechPar);

		JLabel lblAdresse = new JLabel("Adresse : ");
		lblAdresse.setForeground(new Color(0, 0, 128));
		lblAdresse.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblAdresse.setBounds(1194, 360, 112, 22);
		contentPane.add(lblAdresse);

		Print_Btn = new JButton("");
		Print_Btn.setRolloverIcon(new ImageIcon(Client_View.class.getResource("/img/print_ap.png")));
		Print_Btn.setIcon(new ImageIcon(Client_View.class.getResource("/img/print.png")));
		Print_Btn.setBounds(814, 635, 156, 44);
		contentPane.add(Print_Btn);

		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(1156, 142, 194, 14);
		contentPane.add(errorLabel);

		JButton btnViderLesChamps = new JButton("Vider les champs");
		btnViderLesChamps.setRequestFocusEnabled(false);
		btnViderLesChamps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				field_Nom.setText("");
				field_Prenom.setText("");
				field_Raison.setText("");
				field_Mobile.setText("");
				field_Email.setText("");
				field_Adresse.setText("");
				field_RC.setText("");
				field_CarteF.setText("");

			}
		});
		btnViderLesChamps.setForeground(SystemColor.inactiveCaptionText);
		btnViderLesChamps.setBounds(1165, 115, 143, 23);
		contentPane.add(btnViderLesChamps);

		label = new JLabel("");
		label.setIcon(new ImageIcon(Client_View.class.getResource("/img/search_field3.png")));
		label.setBounds(596, 130, 193, 37);
		contentPane.add(label);

		//
		//
		// ////////////////////////// Debut Wallpaper /////////////////////////
		JLabel Wall = new JLabel((String) null);
		Wall.setInheritsPopupMenu(false);
		Wall.setIcon(new ImageIcon(Login_Viex.class.getResource("/img/wall.jpg")));
		Wall.setSize(screenSize.width, screenSize.height - taskBarSize);
		contentPane.add(Wall);
		contentPane.add(Wall);

	}

	// -------------------------- Les methodes --------------------------//

	public boolean champVide() {
		if (field_Nom.getText().equals("") || field_Prenom.getText().equals("") || field_Raison.getText().equals("")
				|| field_Mobile.getText().equals("") || field_RC.getText().equals(""))
			return true;

		return false;

	}

	// -----------------------------------------------------//

	public boolean champVideMini() {
		if (field_RC.getText().equals(""))
			return true;

		return false;

	}

	// -----------------------------------------------------//

	public void SetChampVide() {
		field_Nom.setText("");
		field_Prenom.setText("");
		field_Raison.setText("");
		field_Mobile.setText("");
		field_Adresse.setText("");
		field_Email.setText("");
		field_CarteF.setText("");
		field_RC.setText("");
	}

	// -----------------------------------------------------//

	public void SetInfoFromTable(int ligne) {

		field_Nom.setText(table.getModel().getValueAt(ligne, 1).toString());
		field_Prenom.setText(table.getModel().getValueAt(ligne, 2).toString());
		field_Raison.setText(table.getModel().getValueAt(ligne, 3).toString());
		field_Mobile.setText(table.getModel().getValueAt(ligne, 4).toString());
		field_Email.setText(table.getModel().getValueAt(ligne, 5).toString());
		field_Adresse.setText(table.getModel().getValueAt(ligne, 6).toString());
		field_RC.setText(table.getModel().getValueAt(ligne, 7).toString());
		field_CarteF.setText(table.getModel().getValueAt(ligne, 8).toString());
	}

	// -----------------------------------------------------//

	public Client RecupereInfo() {
		return new Client(field_Nom.getText(), field_Prenom.getText(), field_Raison.getText(), field_Mobile.getText(),
				field_Email.getText(), field_Adresse.getText(), field_RC.getText(), field_CarteF.getText());
	}

	// -----------------------------------------------------//


	public int RechPar() {
		int select = 0;

		switch (combo_RechPar.getSelectedItem().toString()) {
		case "Nom":
			select = 1;
			break;
		case "Code":
			select = 2;
			break;
		}
		return select;
	}

	// -----------------------------------------------------//

	public boolean control_nom() {
		String nom = field_Nom.getText();
		char s;
		boolean number = false;
		for (int j = 0; (j < field_Nom.getText().length()) && (!number); j++) {
			s = nom.charAt(j);
			if (!((s > 61 && s < 92) || (s > 96 && s < 123)))
				number = true;
		}

		if (number) {
			field_Nom.setBackground(Color.ORANGE);
			errorLabel.setVisible(true);
			errorLabel.setText("Le nom n'est pas valide");
		} else {
			field_Nom.setBackground(Color.WHITE);
			errorLabel.setVisible(false);
			errorLabel.setText("");
		}
		return number;
	}

	// -----------------------------------------------------//

	public boolean controlPrenom() {
		String nom = field_Prenom.getText();
		char s;
		boolean number = false;

		for (int j = 0; (j < nom.length()) && (!number); j++) {
			s = nom.charAt(j);
			if (!((s > 61 && s < 92) || (s > 96 && s < 123)))
				number = true;
		}
		if (number) {
			field_Prenom.setBackground(Color.ORANGE);
			errorLabel.setVisible(true);
			errorLabel.setText("Le prénom n'est pas valide");
		} else {
			field_Prenom.setBackground(Color.WHITE);
			errorLabel.setVisible(false);
			errorLabel.setText("");
		}
		return number;
	}

	// -----------------------------------------------------//

	public boolean controlPhone() {
		String nom = field_Mobile.getText();
		char s;
		boolean number = false;
		if (nom.length() != 10)
			number = true;
		else {
			for (int i = 0; i < 10; i++) {
				s = nom.charAt(i);
				if (s < 48 || s > 57)
					number = true;
			}
			if (nom.charAt(0) != 48)
				number = true;
		}
		if (nom.length() == 0)
			number = false;

		if (number) {
			field_Mobile.setBackground(Color.ORANGE);
			errorLabel.setVisible(true);
			errorLabel.setText("Le numéro n'est pas valide");
		} else {
			field_Mobile.setBackground(Color.WHITE);
			errorLabel.setVisible(false);
			errorLabel.setText("");
		}
		return number;
	}

	// -----------------------------------------------------//


	public boolean controlEmail() {
		String nom = field_Email.getText();
		char s;
		boolean number = true;
		for (int i = 0; i < nom.length(); i++) {
			s = nom.charAt(i);
			if (s == '@')
				number = false;
		}
		if (nom.length() == 0)
			number = false;
		if (number) {
			field_Email.setBackground(Color.ORANGE);
			errorLabel.setVisible(true);
			errorLabel.setText("l'Email n'est pas valide");
		} else {
			field_Email.setBackground(Color.WHITE);
			errorLabel.setVisible(false);
			errorLabel.setText("");
		}
		return number;
	}

	// -----------------------------------------------------//

	public void EnabledAll() {
		Modifier_Btn.setEnabled(false);
		Suprimer_Btn.setEnabled(false);
		Ajouter_Btn.setEnabled(false);

	}

	// -----------------------------------------------------//

	public void eanableAddClient() {
		if (control_nom() || controlEmail() || controlPhone() || controlPrenom() || champVide())
			Ajouter_Btn.setEnabled(false);
		else
			Ajouter_Btn.setEnabled(true);
		eanableModifyClient();
		eanableDeleteClient();
	}

	// -----------------------------------------------------//

	public void eanableModifyClient() {
		if (control_nom() || controlEmail() || controlPhone() || controlPrenom() || champVide())
			Modifier_Btn.setEnabled(false);
		else
			Modifier_Btn.setEnabled(true);
	}

	// -----------------------------------------------------//

	public void eanableDeleteClient() {
		if (control_nom() || controlEmail() || controlPhone() || controlPrenom() || champVide())
			Suprimer_Btn.setEnabled(false);
		else
			Suprimer_Btn.setEnabled(true);
	}

	// ----------------------- Les getters & setters ------------------------//

	public JButton getAjouter_Btn() {
		return Ajouter_Btn;
	}

	public JButton getModifier_Btn() {
		return Modifier_Btn;
	}

	public JButton getSuprimer_Btn() {
		return Suprimer_Btn;
	}

	public JTextField getField_Nom() {
		return field_Nom;
	}

	public void setField_Nom(JTextField field_Nom) {
		this.field_Nom = field_Nom;
	}


	public JTextField getField_Prenom() {
		return field_Prenom;
	}

	public void setField_Prenom(JTextField field_Prenom) {
		this.field_Prenom = field_Prenom;
	}

	public JTextField getField_Raison() {
		return field_Raison;
	}

	public void setField_Raison(JTextField field_Raison) {
		this.field_Raison = field_Raison;
	}

	public JTextField getField_Mobile() {
		return field_Mobile;
	}

	public void setField_Mobile(JTextField field_Mobile) {
		this.field_Mobile = field_Mobile;
	}

	public JTextField getField_Email() {
		return field_Email;
	}

	public void setField_Email(JTextField field_Email) {
		this.field_Email = field_Email;
	}

	public JTextField getField_RC() {
		return field_RC;
	}

	public void setField_RC(JTextField field_RC) {
		this.field_RC = field_RC;
	}

	public JTextField getField_CarteF() {
		return field_CarteF;
	}

	public void setField_CarteF(JTextField field_CarteF) {
		this.field_CarteF = field_CarteF;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getRech_field() {
		return Rech_field;
	}

	public void setRech_field(JTextField rech_field) {
		Rech_field = rech_field;
	}

	public JButton getReturne() {
		return Returne;
	}

	public JButton getPrint_Btn() {
		return Print_Btn;
	}

}
