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
import model.entity.BonVisite;
import model.entity.Dossier;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

public class BonSortie_View extends JFrame {

	// -------------------------- Le constructeur --------------------------//

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
	private JTextField textFieldDeclarant;
	private JTextField textField_transit;
	private JTextField txtProvenance;
	private JTextField txtGros;
	private JTextField txtDateDarrive;
	private JTextField txtArticle;
	private JTextField txtQuai;
	private JButton nouveauchauffeur;
	private JButton btnValider;
	private JTextField textFieldCamion;
	private JTextField textFieldChauffeur;
	private JButton btnNouveauCamion;
	private JLabel lblNTelDe;
	private JTextField textFieldNumTel;
	private JLabel lblTypeConteneur;
	private JTextField textFieldTypeConteneur;
	private JButton sauvegarder;
	private JButton Print_btn;
	private JTextField textFieldNumConteneur;
	public static JComboBox<String> comboBoxChauffeur;
	public static JComboBox<String> comboBoxCamion;

	// -------------------------- Le constructeur --------------------------//

	public BonSortie_View() {
		contentPane = new JPanel();
		///////////////////// Ajuster la taille de la fenetre
		///////////////////// ////////////////////
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		setSize(screenSize.width, screenSize.height - taskBarSize);
		setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());
		setContentPane(contentPane);

		///////////////////// Fin Ajuster la taille de la fenetre
		///////////////////// ////////////////////
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
		contentPane.setLayout(null);

		Menu menu = new Menu();
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1366, 111);
		panel_1 = menu.getPanel();
		contentPane.add(panel_1);

		JLabel Txt_AjouterDossier = new JLabel("Bon de Sortie");
		Txt_AjouterDossier.setForeground(new Color(0, 0, 128));
		Txt_AjouterDossier.setBounds(669, 118, 250, 44);
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
		btnValider.setRolloverIcon(new ImageIcon(BonSortie_View.class.getResource("/img/Valider_ap.png")));
		btnValider.setIcon(new ImageIcon(BonSortie_View.class.getResource("/img/Valider.png")));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnValider.setBounds(729, 634, 156, 44);
		contentPane.add(btnValider);

		JLabel lblChoisirUnDclarant = new JLabel("Agent de Douane :");
		lblChoisirUnDclarant.setForeground(new Color(0, 0, 128));
		lblChoisirUnDclarant.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChoisirUnDclarant.setBounds(703, 178, 131, 14);
		contentPane.add(lblChoisirUnDclarant);

		textField_AgantDouane = new JTextField();
		textField_AgantDouane.setForeground(new Color(0, 0, 0));
		textField_AgantDouane.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_AgantDouane.setHorizontalAlignment(SwingConstants.CENTER);
		textField_AgantDouane.setEditable(false);
		textField_AgantDouane.setColumns(10);
		textField_AgantDouane.setBounds(845, 172, 121, 29);
		contentPane.add(textField_AgantDouane);

		comboBoxChauffeur = new JComboBox<String>();

		comboBoxChauffeur.setBounds(803, 270, 223, 29);
		Utile.remplirCombo(comboBoxChauffeur, "Chauffeur", "Nom_Chauffeur");
		contentPane.add(comboBoxChauffeur);
		comboBoxChauffeur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldChauffeur.setText(comboBoxChauffeur.getSelectedItem().toString());
				String tel;
				tel = Utile.convertir(Utile.getIdFromCombo(comboBoxChauffeur.getSelectedItem().toString()),
						"idChauffeur", "Phone_Chauffeur", "chauffeur");
				textFieldNumTel.setText(tel);
			}
		});

		textFieldDeclarant = new JTextField();
		textFieldDeclarant.setForeground(new Color(0, 0, 0));
		textFieldDeclarant.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldDeclarant.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDeclarant.setEditable(false);
		textFieldDeclarant.setColumns(10);
		textFieldDeclarant.setBounds(1057, 172, 209, 29);
		contentPane.add(textFieldDeclarant);

		JLabel lblDclarante = new JLabel("D\u00E9clarant  :");
		lblDclarante.setForeground(new Color(0, 0, 128));
		lblDclarante.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDclarante.setBounds(976, 178, 131, 14);
		contentPane.add(lblDclarante);

		textField_transit = new JTextField();
		textField_transit.setForeground(new Color(0, 0, 0));
		textField_transit.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_transit.setHorizontalAlignment(SwingConstants.CENTER);
		textField_transit.setEditable(false);
		textField_transit.setColumns(10);
		textField_transit.setBounds(560, 172, 121, 29);
		contentPane.add(textField_transit);

		JLabel lblTransit = new JLabel("Transit :");
		lblTransit.setForeground(new Color(0, 0, 128));
		lblTransit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTransit.setBounds(468, 178, 71, 14);
		contentPane.add(lblTransit);

		// / TABLEU TABLEU TABLEU ///

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(564, 455, 550, 177);
		contentPane.add(scrollPane);

		table = new JTable();
		Utile.Property_Table(table);
		Utile.Entete_Table(table);
		Utile.Centrer_Table(table);
		Utile.Centrer_Table(table);

		scrollPane.setViewportView(table);
		scrollPane.setViewportView(table);

		nouveauchauffeur = new JButton("");
		nouveauchauffeur.setRolloverIcon(new ImageIcon(BonSortie_View.class.getResource("/img/new_ap.png")));
		nouveauchauffeur.setIcon(new ImageIcon(BonSortie_View.class.getResource("/img/new.png")));
		nouveauchauffeur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		nouveauchauffeur.setBounds(1121, 273, 100, 32);
		contentPane.add(nouveauchauffeur);

		JLabel lblNConteneur = new JLabel("N \u00B0 Conteneur  :");
		lblNConteneur.setForeground(new Color(0, 0, 128));
		lblNConteneur.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNConteneur.setBounds(453, 231, 121, 14);
		contentPane.add(lblNConteneur);

		JLabel lblChauffeur = new JLabel("Chauffeur  :");
		lblChauffeur.setForeground(new Color(0, 0, 128));
		lblChauffeur.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChauffeur.setBounds(453, 280, 121, 14);
		contentPane.add(lblChauffeur);

		JLabel lblCamion = new JLabel(" Camion   :");
		lblCamion.setForeground(new Color(0, 0, 128));
		lblCamion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCamion.setBounds(453, 378, 121, 14);
		contentPane.add(lblCamion);

		textFieldCamion = new JTextField();
		textFieldCamion.setForeground(new Color(0, 0, 0));
		textFieldCamion.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldCamion.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCamion.setText(" Choisir ...");
		textFieldCamion.setEditable(false);
		textFieldCamion.setColumns(10);
		textFieldCamion.setBounds(560, 372, 233, 29);
		contentPane.add(textFieldCamion);

		textFieldChauffeur = new JTextField();
		textFieldChauffeur.setForeground(new Color(0, 0, 0));
		textFieldChauffeur.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldChauffeur.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldChauffeur.setText(" Choisir ...");
		textFieldChauffeur.setEditable(false);
		textFieldChauffeur.setColumns(10);
		textFieldChauffeur.setBounds(560, 270, 233, 29);
		contentPane.add(textFieldChauffeur);

		comboBoxCamion = new JComboBox<String>();
		comboBoxCamion.setBounds(803, 373, 223, 27);
		Utile.remplirCombo(comboBoxCamion, "Camion", "Matricule");
		comboBoxCamion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldCamion.setText(comboBoxCamion.getSelectedItem().toString());

			}
		});

		contentPane.add(comboBoxCamion);

		btnNouveauCamion = new JButton("");
		btnNouveauCamion.setRolloverIcon(new ImageIcon(BonSortie_View.class.getResource("/img/new_ap.png")));
		btnNouveauCamion.setIcon(new ImageIcon(BonSortie_View.class.getResource("/img/new.png")));
		btnNouveauCamion.setBounds(1121, 375, 100, 32);
		contentPane.add(btnNouveauCamion);
		Print_btn = new JButton("");
		Print_btn.setRolloverIcon(new ImageIcon(BonSortie_View.class.getResource("/img/print_ap.png")));
		Print_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Print_btn.setIcon(new ImageIcon(Client_View.class.getResource("/img/print.png")));
		Print_btn.setBounds(895, 634, 156, 44);
		Print_btn.setOpaque(false);
		Print_btn.setContentAreaFilled(false);
		Print_btn.setBorderPainted(false);
		contentPane.add(Print_btn);

		lblNTelDe = new JLabel("N\u00B0 tel de chauffeur  :");
		lblNTelDe.setForeground(new Color(0, 0, 128));
		lblNTelDe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNTelDe.setBounds(439, 325, 145, 14);
		contentPane.add(lblNTelDe);

		textFieldNumTel = new JTextField();
		textFieldNumTel.setForeground(new Color(0, 0, 0));
		textFieldNumTel.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldNumTel.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumTel.setEditable(false);
		textFieldNumTel.setColumns(10);
		textFieldNumTel.setBounds(570, 323, 281, 20);
		contentPane.add(textFieldNumTel);

		lblTypeConteneur = new JLabel("Type Conteneur  :");
		lblTypeConteneur.setForeground(new Color(0, 0, 128));
		lblTypeConteneur.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTypeConteneur.setBounds(703, 237, 121, 14);
		contentPane.add(lblTypeConteneur);

		textFieldTypeConteneur = new JTextField();
		textFieldTypeConteneur.setForeground(new Color(0, 0, 0));
		textFieldTypeConteneur.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldTypeConteneur.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTypeConteneur.setEditable(false);
		textFieldTypeConteneur.setColumns(10);
		textFieldTypeConteneur.setBounds(817, 230, 176, 29);
		contentPane.add(textFieldTypeConteneur);

		sauvegarder = new JButton("");
		sauvegarder.setIcon(new ImageIcon(BonSortie_View.class.getResource("/img/sauv.png")));
		sauvegarder.setRolloverIcon(new ImageIcon(BonSortie_View.class.getResource("/img/sauv_ap.png")));
		sauvegarder.setEnabled(true);
		sauvegarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sauvegarder.setBounds(570, 412, 121, 32);
		contentPane.add(sauvegarder);

		textFieldNumConteneur = new JTextField();
		textFieldNumConteneur.setForeground(new Color(0, 0, 0));
		textFieldNumConteneur.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldNumConteneur.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumConteneur.setText(" S\u00E9lectionner ...");
		textFieldNumConteneur.setEditable(false);
		textFieldNumConteneur.setColumns(10);
		textFieldNumConteneur.setBounds(560, 229, 121, 29);
		contentPane.add(textFieldNumConteneur);

		JLabel label = new JLabel("");
		label.setBounds(42, 110, 375, 576);
		contentPane.add(label);
		label.setIcon(new ImageIcon(BonVisite_View.class.getResource("/img/fiche2.png")));

		// ////////////////////////// Debut Wallpaper /////////////////////////
		JLabel Wall = new JLabel("");
		Wall.setLocation(0, 0);
		Wall.setInheritsPopupMenu(false);
		Wall.setIcon(new ImageIcon(Login_Viex.class.getResource("/img/wall.jpg")));
		Wall.setSize(screenSize.width, screenSize.height - taskBarSize);
		contentPane.add(Wall);
		// ////////////////////////// Fin Wallpaper /////////////////////////

	}


	public boolean champVide() {
		if (textFieldNumConteneur.getText().equals("") || textFieldNumConteneur.getText().equals(" Sélectionner ...")
				|| textFieldChauffeur.getText().equals(" Choisir ...")
				|| textFieldCamion.getText().equals(" Choisir ...") || textFieldCamion.getText().equals("")
				|| textFieldChauffeur.getText().equals(""))
			return true;

		return false;

	}

	// -------------------------- Les methodes --------------------------//

	public void afficherDossier(Dossier dossier, BonVisite bon_visite) {
		field_Code.setText("" + dossier.getIdDossier());

		field_FullName.setText(dossier.getDate_Ouverture().toString());
		field_Raison.setText("" + dossier.getNbConteneur());
		field_Mobile.setText(dossier.getStatut_Dossier());
		field_Email.setText(dossier.getRepertoire());
		field_Rc.setText(dossier.getMoyenTransport());
		field_Rc.setText(dossier.getMoyenTransport());
		txtProvenance.setText(dossier.getProvenance());
		txtGros.setText(dossier.getGros());
		txtDateDarrive.setText(dossier.getDate_Arrive().toString());
		txtArticle.setText(dossier.getArticle());
		txtQuai.setText(dossier.getQuai());
		textFieldDeclarant.setText(bon_visite.getDeclarant());
		textField_AgantDouane.setText(bon_visite.getAgentDouane());
		textField_transit.setText(bon_visite.getTransit());
	}

	public void DisableBtn() {
		getSauvegarder().setEnabled(false);
		getPrint_btn().setEnabled(true);
		getNouveauchauffeur().setEnabled(false);
		getBtnNouveauCamion().setEnabled(false);
		getBtnValider().setEnabled(false);
		getComboBoxCamion().setEnabled(false);
		getComboBoxChauffeur().setEnabled(false);

	}
	// ----------------------- Les getters & setters ------------------------//

	public JButton getPrint_btn() {
		return Print_btn;
	}

	public void setPrint_btn(JButton print_btn) {
		Print_btn = print_btn;
	}

	public JButton getSauvegarder() {
		return sauvegarder;
	}

	public void setSauvegarder(JButton sauvegarder) {
		this.sauvegarder = sauvegarder;
	}

	public JTextField getTextFieldNumTel() {
		return textFieldNumTel;
	}

	public void setTextFieldNumTel(JTextField textFieldNumTel) {
		this.textFieldNumTel = textFieldNumTel;
	}

	public JTextField getTextFieldTypeConteneur() {
		return textFieldTypeConteneur;
	}

	public void setTextFieldTypeConteneur(JTextField textFieldTypeConteneur) {
		this.textFieldTypeConteneur = textFieldTypeConteneur;
	}

	public JButton getBtnNouveauCamion() {
		return btnNouveauCamion;
	}

	public void setBtnNouveauCamion(JButton btnNouveauCamion) {
		this.btnNouveauCamion = btnNouveauCamion;
	}

	public JTextField getTextField_AgantDouane() {
		return textField_AgantDouane;
	}

	public void setTextField_AgantDouane(JTextField textField_AgantDouane) {
		this.textField_AgantDouane = textField_AgantDouane;
	}

	public JTextField getTxtChoisir() {
		return textFieldDeclarant;
	}

	public void setTxtChoisir(JTextField txtChoisir) {
		this.textFieldDeclarant = txtChoisir;
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



	public JTextField getTextFieldDeclarant() {
		return textFieldDeclarant;
	}

	public void setTextFieldDeclarant(JTextField textFieldDeclarant) {
		this.textFieldDeclarant = textFieldDeclarant;
	}

	public JButton getNouveauchauffeur() {
		return nouveauchauffeur;
	}

	public void setNouveauchauffeur(JButton nouveauchauffeur) {
		this.nouveauchauffeur = nouveauchauffeur;
	}

	public JComboBox<String> getComboBoxChauffeur() {
		return comboBoxChauffeur;
	}

	@SuppressWarnings("static-access")
	public void setComboBoxChauffeur(JComboBox<String> comboBoxChauffeur) {
		this.comboBoxChauffeur = comboBoxChauffeur;
	}

	public JTextField getTextFieldNumConteneur() {
		return textFieldNumConteneur;
	}

	public void setTextFieldNumConteneur(JTextField textFieldNumConteneur) {
		this.textFieldNumConteneur = textFieldNumConteneur;
	}

	public JTextField getTextFieldCamion() {
		return textFieldCamion;
	}

	public void setTextFieldCamion(JTextField textFieldCamion) {
		this.textFieldCamion = textFieldCamion;
	}

	public JTextField getTextFieldChauffeur() {
		return textFieldChauffeur;
	}

	public void setTextFieldChauffeur(JTextField textFieldChauffeur) {
		this.textFieldChauffeur = textFieldChauffeur;
	}

	public JComboBox<String> getComboBoxCamion() {
		return comboBoxCamion;
	}

	@SuppressWarnings("static-access")
	public void setComboBoxCamion(JComboBox<String> comboBoxCamion) {
		this.comboBoxCamion = comboBoxCamion;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboBox_2() {
		return comboBoxChauffeur;
	}

	@SuppressWarnings("static-access")
	public void setComboBox_2(JComboBox<String> comboBox_2) {
		this.comboBoxChauffeur = comboBox_2;
	}

	public JButton getNouveauDeclarant() {
		return nouveauchauffeur;
	}

	public void setNouveauDeclarant(JButton nouveauDeclarant) {
		this.nouveauchauffeur = nouveauDeclarant;
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
