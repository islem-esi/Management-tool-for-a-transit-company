package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Utile;
import model.entity.Dossier;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class BonVisite_View extends JFrame {

	// ------------------- Les déclarations  -----------------------//

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton Returne;
	private JTable table;
	private JLabel Dossier_Info;
	private JPanel panel_info;
	private JLabel lblC;
	private JLabel lbl_date;
	private JLabel lbnbconteneur;
	private JLabel lblMobile;
	private JLabel lblEmail;
	private JLabel lblRegistreCommerce;
	private JTextField field_Code;
	private JTextField field_FullName;
	private JTextField field_Raison;
	private JTextField field_Mobile;
	private JTextField field_Email;
	private JTextField field_Rc;
	private JTextField textField_AgantDouane;
	private JTextField txtChoisir;
	private JTextField textField_transit;
	private JTextField txtProvenance;
	private JTextField txtGros;
	private JTextField txtDateDarrive;
	private JTextField txtArticle;
	private JTextField txtQuai;
	private JButton legale;
	private JButton fraude;
	private JButton nouveauDeclarant;
	private JButton btnValider;
	private JButton Print_btn;
	public static JComboBox<String> ComboDeclarant;

	// -------------------------- Le constructeur --------------------------//

	public BonVisite_View() {
		contentPane = new JPanel();

		// /////////////////// Ajuster la taille de la fenetre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		setSize(screenSize.width, screenSize.height - taskBarSize);
		setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());
		setContentPane(contentPane);

		// /////////////////// Fin Ajuster la taille de la fenetre

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

		// ---------------Menu BAR--------------------//
		Menu menu = new Menu();
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1366, 111);
		panel_1 = menu.getPanel();
		contentPane.add(panel_1);
		// ---------------END Menu BAR--------------------//

		contentPane.setLayout(null);

		JLabel Txt_AjouterDossier = new JLabel("Bon de Visite");
		Txt_AjouterDossier.setForeground(new Color(0, 0, 128));
		Txt_AjouterDossier.setBounds(658, 110, 229, 45);
		Txt_AjouterDossier.setFont(new Font("Impact", Font.PLAIN, 40));
		contentPane.add(Txt_AjouterDossier);

		panel_info = new JPanel();
		panel_info.setBackground(new Color(255, 255, 255, 0));

		panel_info.setBounds(54, 136, 375, 542);
		contentPane.add(panel_info);
		panel_info.setLayout(null);

		Dossier_Info = new JLabel("  INFORMATIONS DU DOSSIER");
		Dossier_Info.setBounds(34, 0, 279, 21);
		panel_info.add(Dossier_Info);
		Dossier_Info.setForeground(new Color(255, 255, 255));
		Dossier_Info.setFont(new Font("Khmer UI", Font.BOLD, 18));

		lblC = new JLabel("Code Dossier :");
		lblC.setForeground(new Color(0, 0, 128));
		lblC.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblC.setBounds(38, 79, 103, 14);
		panel_info.add(lblC);

		lbl_date = new JLabel("Date d'ouverture  :");
		lbl_date.setForeground(new Color(0, 0, 128));
		lbl_date.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_date.setBounds(24, 118, 117, 14);
		panel_info.add(lbl_date);

		lbnbconteneur = new JLabel("Nombre de conteneurs :");
		lbnbconteneur.setForeground(new Color(0, 0, 128));
		lbnbconteneur.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbnbconteneur.setBounds(10, 194, 150, 14);
		panel_info.add(lbnbconteneur);

		lblMobile = new JLabel("Statut du dossier :");
		lblMobile.setForeground(new Color(0, 0, 128));
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMobile.setBounds(27, 234, 133, 14);
		panel_info.add(lblMobile);

		lblEmail = new JLabel("Repertoire :");
		lblEmail.setForeground(new Color(0, 0, 128));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(46, 274, 84, 14);
		panel_info.add(lblEmail);

		lblRegistreCommerce = new JLabel(" Moyen de transport : ");
		lblRegistreCommerce.setForeground(new Color(0, 0, 128));
		lblRegistreCommerce.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegistreCommerce.setBounds(17, 314, 143, 14);
		panel_info.add(lblRegistreCommerce);

		field_Code = new JTextField();
		field_Code.setForeground(new Color(51, 51, 51));
		field_Code.setHorizontalAlignment(SwingConstants.CENTER);
		field_Code.setFont(new Font("Raavi", Font.BOLD, 14));
		field_Code.setText("");
		field_Code.setEditable(false);
		field_Code.setBounds(160, 73, 178, 29);
		panel_info.add(field_Code);
		field_Code.setColumns(10);

		field_FullName = new JTextField();
		field_FullName.setForeground(new Color(51, 51, 51));
		field_FullName.setHorizontalAlignment(SwingConstants.CENTER);
		field_FullName.setFont(new Font("Raavi", Font.BOLD, 14));
		field_FullName.setText("");
		field_FullName.setEditable(false);
		field_FullName.setColumns(10);
		field_FullName.setBounds(160, 112, 178, 29);
		panel_info.add(field_FullName);

		field_Raison = new JTextField();
		field_Raison.setForeground(new Color(51, 51, 51));
		field_Raison.setHorizontalAlignment(SwingConstants.CENTER);
		field_Raison.setFont(new Font("Raavi", Font.BOLD, 14));
		field_Raison.setText("");
		field_Raison.setEditable(false);
		field_Raison.setColumns(10);
		field_Raison.setBounds(160, 188, 178, 29);
		panel_info.add(field_Raison);

		field_Mobile = new JTextField();
		field_Mobile.setForeground(new Color(51, 51, 51));
		field_Mobile.setHorizontalAlignment(SwingConstants.CENTER);
		field_Mobile.setFont(new Font("Raavi", Font.BOLD, 14));
		field_Mobile.setText("");
		field_Mobile.setEditable(false);
		field_Mobile.setColumns(10);
		field_Mobile.setBounds(160, 228, 178, 29);
		panel_info.add(field_Mobile);

		field_Email = new JTextField();
		field_Email.setForeground(new Color(51, 51, 51));
		field_Email.setHorizontalAlignment(SwingConstants.CENTER);
		field_Email.setFont(new Font("Raavi", Font.BOLD, 14));
		field_Email.setText("");
		field_Email.setEditable(false);
		field_Email.setColumns(10);
		field_Email.setBounds(160, 268, 178, 29);
		panel_info.add(field_Email);

		field_Rc = new JTextField();
		field_Rc.setForeground(new Color(51, 51, 51));
		field_Rc.setHorizontalAlignment(SwingConstants.CENTER);
		field_Rc.setFont(new Font("Raavi", Font.BOLD, 14));
		field_Rc.setText("");
		field_Rc.setEditable(false);
		field_Rc.setColumns(10);
		field_Rc.setBounds(160, 308, 178, 29);
		panel_info.add(field_Rc);

		txtProvenance = new JTextField();
		txtProvenance.setForeground(new Color(51, 51, 51));
		txtProvenance.setHorizontalAlignment(SwingConstants.CENTER);
		txtProvenance.setFont(new Font("Raavi", Font.BOLD, 14));
		txtProvenance.setText("");
		txtProvenance.setEditable(false);
		txtProvenance.setColumns(10);
		txtProvenance.setBounds(160, 348, 178, 29);
		panel_info.add(txtProvenance);

		txtGros = new JTextField();
		txtGros.setForeground(new Color(51, 51, 51));
		txtGros.setHorizontalAlignment(SwingConstants.CENTER);
		txtGros.setFont(new Font("Raavi", Font.BOLD, 14));
		txtGros.setText("");
		txtGros.setEditable(false);
		txtGros.setColumns(10);
		txtGros.setBounds(160, 392, 178, 29);
		panel_info.add(txtGros);

		txtDateDarrive = new JTextField();
		txtDateDarrive.setForeground(new Color(51, 51, 51));
		txtDateDarrive.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateDarrive.setFont(new Font("Raavi", Font.BOLD, 14));
		txtDateDarrive.setText("");
		txtDateDarrive.setEditable(false);
		txtDateDarrive.setColumns(10);
		txtDateDarrive.setBounds(160, 152, 178, 29);
		panel_info.add(txtDateDarrive);

		txtArticle = new JTextField();
		txtArticle.setForeground(new Color(51, 51, 51));
		txtArticle.setHorizontalAlignment(SwingConstants.CENTER);
		txtArticle.setFont(new Font("Raavi", Font.BOLD, 14));
		txtArticle.setText("");
		txtArticle.setEditable(false);
		txtArticle.setColumns(10);
		txtArticle.setBounds(160, 432, 178, 29);
		panel_info.add(txtArticle);

		txtQuai = new JTextField();
		txtQuai.setForeground(new Color(51, 51, 51));
		txtQuai.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuai.setFont(new Font("Raavi", Font.BOLD, 14));
		txtQuai.setText("");
		txtQuai.setEditable(false);
		txtQuai.setColumns(10);
		txtQuai.setBounds(160, 476, 178, 29);
		panel_info.add(txtQuai);

		JLabel lblProvenance = new JLabel(" Provenance :");
		lblProvenance.setForeground(new Color(0, 0, 128));
		lblProvenance.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProvenance.setBounds(38, 355, 112, 14);
		panel_info.add(lblProvenance);

		JLabel lblGros = new JLabel("Gros :");
		lblGros.setForeground(new Color(0, 0, 128));
		lblGros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGros.setBounds(67, 399, 93, 14);
		panel_info.add(lblGros);

		JLabel lblArticle = new JLabel("Article : ");
		lblArticle.setForeground(new Color(0, 0, 128));
		lblArticle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblArticle.setBounds(67, 439, 93, 14);
		panel_info.add(lblArticle);

		JLabel lblQuai = new JLabel("Quai :");
		lblQuai.setForeground(new Color(0, 0, 128));
		lblQuai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuai.setBounds(76, 482, 84, 14);
		panel_info.add(lblQuai);

		JLabel lblDateDarriv = new JLabel(" Date d'arriv\u00E9 :");
		lblDateDarriv.setForeground(new Color(0, 0, 128));
		lblDateDarriv.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateDarriv.setBounds(36, 159, 124, 14);
		panel_info.add(lblDateDarriv);

		btnValider = new JButton("");
		btnValider.setRolloverIcon(new ImageIcon(BonVisite_View.class.getResource("/img/Valider_ap.png")));
		btnValider.setIcon(new ImageIcon(BonVisite_View.class.getResource("/img/Valider.png")));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnValider.setBounds(695, 622, 156, 44);
		contentPane.add(btnValider);

		JLabel lblChoisirUnDclarant = new JLabel("Agent de Douane :");
		lblChoisirUnDclarant.setForeground(new Color(0, 0, 128));
		lblChoisirUnDclarant.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChoisirUnDclarant.setBounds(525, 226, 131, 14);
		contentPane.add(lblChoisirUnDclarant);

		textField_AgantDouane = new JTextField();
		textField_AgantDouane.setHorizontalAlignment(SwingConstants.CENTER);
		textField_AgantDouane.setForeground(new Color(0, 0, 128));
		textField_AgantDouane.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_AgantDouane.setColumns(10);
		textField_AgantDouane.setBounds(644, 220, 121, 29);
		contentPane.add(textField_AgantDouane);

		ComboDeclarant = new JComboBox<String>();
		ComboDeclarant.setBounds(809, 261, 157, 27);
		Utile.remplirCombo(ComboDeclarant, "declarant", "Nom_Declarant");
		contentPane.add(ComboDeclarant);
		ComboDeclarant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtChoisir.setText(ComboDeclarant.getSelectedItem().toString());
			}
		});

		txtChoisir = new JTextField();
		txtChoisir.setHorizontalAlignment(SwingConstants.CENTER);
		txtChoisir.setForeground(new Color(0, 0, 128));
		txtChoisir.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtChoisir.setBackground(Color.WHITE);
		txtChoisir.setEditable(false);
		txtChoisir.setText(" choisir ...");
		txtChoisir.setColumns(10);
		txtChoisir.setBounds(644, 260, 121, 29);
		contentPane.add(txtChoisir);

		JLabel lblDclarante = new JLabel("D\u00E9clarant  :");
		lblDclarante.setForeground(new Color(0, 0, 128));
		lblDclarante.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDclarante.setBounds(564, 266, 131, 14);
		contentPane.add(lblDclarante);

		textField_transit = new JTextField();
		textField_transit.setHorizontalAlignment(SwingConstants.CENTER);
		textField_transit.setForeground(new Color(0, 0, 128));
		textField_transit.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_transit.setColumns(10);
		textField_transit.setBounds(644, 180, 121, 29);
		contentPane.add(textField_transit);

		JLabel lblTransit = new JLabel("Transit :");
		lblTransit.setForeground(new Color(0, 0, 128));
		lblTransit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTransit.setBounds(590, 186, 71, 14);
		contentPane.add(lblTransit);

		// / TABLEU TABLEU TABLEU ///

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(564, 392, 550, 219);
		contentPane.add(scrollPane);
		table = new JTable();
		Utile.Property_Table(table);
		Utile.Entete_Table(table);
		Utile.Centrer_Table(table);
		Utile.Centrer_Table(table);

		scrollPane.setViewportView(table);
		scrollPane.setViewportView(table);

		nouveauDeclarant = new JButton("");
		nouveauDeclarant.setContentAreaFilled(false);
		nouveauDeclarant.setRequestFocusEnabled(false);
		nouveauDeclarant.setBorderPainted(false);
		nouveauDeclarant.setBounds(976, 253, 35, 35);
		nouveauDeclarant.setIcon(new ImageIcon(BonVisite_View.class.getResource("/img/plus.png")));
		nouveauDeclarant.setRolloverIcon(new ImageIcon(BonVisite_View.class.getResource("/img/plus_ap.png")));
		nouveauDeclarant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(nouveauDeclarant);
		Print_btn = new JButton("");
		Print_btn.setRolloverIcon(new ImageIcon(BonVisite_View.class.getResource("/img/print_ap.png")));
		Print_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Print_btn.setIcon(new ImageIcon(Client_View.class.getResource("/img/print.png")));
		Print_btn.setBounds(865, 622, 156, 44);
		Print_btn.setOpaque(false);
		Print_btn.setContentAreaFilled(false);
		Print_btn.setBorderPainted(false);
		contentPane.add(Print_btn);

		fraude = new JButton("");
		fraude.setRolloverIcon(new ImageIcon(BonVisite_View.class.getResource("/img/tousFraud_ap.png")));
		fraude.setIcon(new ImageIcon(BonVisite_View.class.getResource("/img/tousFraud.png")));
		fraude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		fraude.setBounds(855, 337, 156, 32);
		contentPane.add(fraude);

		legale = new JButton("");
		legale.setRolloverIcon(new ImageIcon(BonVisite_View.class.getResource("/img/tousLegal_Ap.png")));
		legale.setIcon(new ImageIcon(BonVisite_View.class.getResource("/img/tousLegal.png")));
		legale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		legale.setBounds(689, 337, 156, 32);
		contentPane.add(legale);

		JLabel label = new JLabel("");
		label.setBounds(42, 110, 375, 576);
		contentPane.add(label);
		label.setIcon(new ImageIcon(BonVisite_View.class.getResource("/img/fiche2.png")));

		// ////////////////////////// Debut Wallpaper /////////////////////////
		JLabel Wall = new JLabel("");
		Wall.setInheritsPopupMenu(false);
		Wall.setIcon(new ImageIcon(Login_Viex.class.getResource("/img/wall.jpg")));
		Wall.setSize(screenSize.width, screenSize.height - taskBarSize);
		contentPane.add(Wall);
		// ////////////////////////// Fin Wallpaper /////////////////////////

	}

	// -------------------------- Les methodes --------------------------//

	public static void SetCombo() {
		JComboBox<String> combo = new JComboBox<String>();
		combo.setBounds(809, 261, 157, 27);
		Utile.remplirCombo(combo, "declarant", "Nom_Declarant");
		ComboDeclarant.setModel(combo.getModel());
	}

	public void afficherDossier(Dossier dossier) {
		field_Code.setText("" + dossier.getIdDossier());
		field_FullName.setText(dossier.getDate_Ouverture().toString());
		field_Raison.setText("" + dossier.getNbConteneur());
		field_Mobile.setText(dossier.getStatut_Dossier());
		field_Email.setText(dossier.getRepertoire());
		txtProvenance.setText(dossier.getProvenance());
		field_Rc.setText(dossier.getMoyenTransport());
		field_Rc.setText(dossier.getMoyenTransport());
		txtGros.setText(dossier.getGros());
		txtDateDarrive.setText(dossier.getDate_Arrive().toString());
		txtArticle.setText(dossier.getArticle());
		txtQuai.setText(dossier.getQuai());
	}

	public boolean champVide() {
		if (textField_AgantDouane.getText().equals("") || txtChoisir.getText().equals(" choisir ...")
				|| textField_transit.getText().equals(""))
			return true;
		return false;
	}

	public void DisableBtn() {
		getNouveauDeclarant().setEnabled(false);
		getFraude().setEnabled(false);
		getLegale().setEnabled(false);
		getComboBox_2().setEnabled(false);
		getBtnValider().setEnabled(false);
		getPrint_btn().setEnabled(true);
		getTextField_transit().setEditable(false);
		getTextField_AgantDouane().setEditable(false);

	}

	// ----------------------- Les getters & setters ------------------------//

	public JButton getPrint_btn() {
		return Print_btn;
	}

	public void setPrint_btn(JButton print_btn) {
		Print_btn = print_btn;
	}

	public JTextField getTextField_AgantDouane() {
		return textField_AgantDouane;
	}

	public void setTextField_AgantDouane(JTextField textField_AgantDouane) {
		this.textField_AgantDouane = textField_AgantDouane;
	}

	public JTextField getTxtChoisir() {
		return txtChoisir;
	}

	public void setTxtChoisir(JTextField txtChoisir) {
		this.txtChoisir = txtChoisir;
	}

	public JTextField getTextField_transit() {
		return textField_transit;
	}

	public void setTextField_transit(JTextField textField_transit) {
		this.textField_transit = textField_transit;
	}

	public JLabel getLbl_NomPrenom() {
		return lbl_date;
	}

	public void setLbl_NomPrenom(JLabel lbl_NomPrenom) {
		this.lbl_date = lbl_NomPrenom;
	}

	public JTextField getField_Code() {
		return field_Code;
	}

	public void setField_Code(JTextField field_Code) {
		this.field_Code = field_Code;
	}

	public JTextField getField_FullName() {
		return field_FullName;
	}

	public void setField_FullName(JTextField field_FullName) {
		this.field_FullName = field_FullName;
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

	public JTextField getField_Rc() {
		return field_Rc;
	}

	public void setField_Rc(JTextField field_Rc) {
		this.field_Rc = field_Rc;
	}

	public JButton getReturne() {
		return Returne;
	}

	public void setReturne(JButton returne) {
		Returne = returne;
	}

	public static JComboBox<String> getComboBox_2() {
		return ComboDeclarant;
	}

	public JButton getLegale() {
		return legale;
	}

	public void setLegale(JButton legale) {
		this.legale = legale;
	}

	public JButton getFraude() {
		return fraude;
	}

	public void setFraude(JButton fraude) {
		this.fraude = fraude;
	}

	public JButton getNouveauDeclarant() {
		return nouveauDeclarant;
	}

	public void setNouveauDeclarant(JButton nouveauDeclarant) {
		this.nouveauDeclarant = nouveauDeclarant;
	}

	public JButton getBtnValider() {
		return btnValider;
	}

	public void setBtnValider(JButton btnValider) {
		this.btnValider = btnValider;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
