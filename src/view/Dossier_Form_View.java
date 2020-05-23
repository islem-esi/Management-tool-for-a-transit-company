package view;

import model.Utile;
import model.entity.Client;
import model.entity.Dossier;
import model.table.Dos_Cont_Model;
import model.table.Dos_Cont_Tab;
import view.Theme.CountryComboBox;
import view.Theme.CountryItemEditor;
import view.Theme.CustomComboBoxTester;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import controllers.Parametres.Conteneur_Ctrl;
import controllers.Parametres.Marchandise_Ctrl;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class Dossier_Form_View extends JFrame {

	// ------------------- Les déclarations  -----------------------//
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_info;
	public static JComboBox<String> comboTypeCont;
	public static JComboBox<String> comboTypeMarch;
	private JComboBox<String> Combo_Trans;
	private JComboBox<String> Combo_Rep;
	private CountryComboBox customCombobox;
	private JDateChooser DateArrive;
	private JDateChooser DateOuvert;
	private String Provenance;
	private static JTextField field_Code;
	private static JTextField field_FullName;
	private static JTextField field_Raison;
	private static JTextField field_Mobile;
	private static JTextField field_Email;
	private static JTextField field_Rc;
	private JTextField field_gros;
	private JTextField field_Article;
	private JTextField field_Quai;
	private JTextField Field_Transport;
	private JTextField field_NConteneur;
	private JTextField field_Marque;
	private JTextField field_Plomb;
	private JTextField filed_Poids;
	private JTextField field_Valeur;
	private JTable Table;
	private JButton btnAdd;
	private JButton btnSupprimer;
	private JButton Returne;
	private JButton btnValider;
	private JButton btn_rech;
	private JLabel label_1;
	private JButton plusTypeTC;
	private JButton plusTypeMarch;
	public int NbConteneur;
	private boolean valide = false;

	// -------------------------- Le constructeur --------------------------//

	public Dossier_Form_View() {
		contentPane = new JPanel();
		// ---------------DEBUT Ajustement--------------------//
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		setSize(screenSize.width, screenSize.height - taskBarSize);
		setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());
		setContentPane(contentPane);
		// ---------------END Ajustement --------------------//
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

		// ---------------Menu BAR--------------------//
		Menu menu = new Menu();
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1366, 111);
		panel_1 = menu.getPanel();
		contentPane.add(panel_1);
		// ---------------END Menu BAR--------------------//
		// -------------------------------------------------------------------------------//
		// ---------------DEBUT PANNEL--------------------//
		panel_info = new JPanel();
		// panel_info.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		panel_info.setBackground(new Color(255, 255, 255, 0));
		panel_info.setBounds(45, 110, 301, 576);
		contentPane.add(panel_info);
		panel_info.setLayout(null);

		// ---------------END PANNEL--------------------//

		// ---------------DEBUT LABELS--------------------//
		JLabel Txt_AjouterDossier = new JLabel("Ouverture de Dossier");
		Txt_AjouterDossier.setForeground(new Color(0, 51, 102));
		Txt_AjouterDossier.setBounds(618, 113, 287, 27);
		Txt_AjouterDossier.setFont(new Font("Impact", Font.PLAIN, 30));
		contentPane.add(Txt_AjouterDossier);

		JLabel Client_Info = new JLabel("Fiche Client : ");
		Client_Info.setBounds(75, 23, 192, 21);
		panel_info.add(Client_Info);
		Client_Info.setForeground(Color.WHITE);
		Client_Info.setFont(new Font("Khmer UI", Font.BOLD, 26));

		JLabel lblC = new JLabel("Code Client :");
		lblC.setBounds(101, 91, 112, 14);
		lblC.setForeground(new Color(0, 0, 128));
		lblC.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_info.add(lblC);

		JLabel lbl_NomPrenom = new JLabel("Nom et Pr\u00E9nom :");
		lbl_NomPrenom.setBounds(91, 160, 154, 14);
		lbl_NomPrenom.setForeground(new Color(0, 0, 128));
		lbl_NomPrenom.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_info.add(lbl_NomPrenom);

		JLabel lblRaisonSocial = new JLabel("Raison Social :");
		lblRaisonSocial.setBounds(100, 225, 129, 14);
		lblRaisonSocial.setForeground(new Color(0, 0, 128));
		lblRaisonSocial.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_info.add(lblRaisonSocial);

		JLabel lblMobile = new JLabel("Mobile :");
		lblMobile.setBounds(133, 289, 96, 14);
		lblMobile.setForeground(new Color(0, 0, 128));
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_info.add(lblMobile);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(132, 354, 84, 14);
		lblEmail.setForeground(new Color(0, 0, 128));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_info.add(lblEmail);

		JLabel lblRegistreCommerce = new JLabel("N\u00B0 RC :");
		lblRegistreCommerce.setBounds(123, 428, 122, 14);
		lblRegistreCommerce.setForeground(new Color(0, 0, 128));
		lblRegistreCommerce.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_info.add(lblRegistreCommerce);

		label_1 = new JLabel("");
		label_1.setBounds(0, 0, 301, 576);
		panel_info.add(label_1);
		label_1.setIcon(new ImageIcon(Dossier_Form_View.class.getResource("/img/fiche.png")));

		JLabel lblRepertoire = new JLabel("Repertoire :");
		lblRepertoire.setForeground(new Color(0, 51, 102));
		lblRepertoire.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRepertoire.setBounds(400, 283, 84, 14);
		contentPane.add(lblRepertoire);

		JLabel lblMoyenDeTransport = new JLabel("Moyen de Transport :");
		lblMoyenDeTransport.setForeground(new Color(0, 51, 102));
		lblMoyenDeTransport.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMoyenDeTransport.setBounds(400, 328, 146, 14);
		contentPane.add(lblMoyenDeTransport);

		JLabel lblProvenance = new JLabel("Provenance  :");
		lblProvenance.setForeground(new Color(0, 51, 102));
		lblProvenance.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProvenance.setBounds(400, 368, 97, 14);
		contentPane.add(lblProvenance);

		JLabel lblDateDarriv = new JLabel("Date d\u2019Arriv\u00E9 :");
		lblDateDarriv.setForeground(new Color(0, 51, 102));
		lblDateDarriv.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateDarriv.setBounds(784, 240, 107, 14);
		contentPane.add(lblDateDarriv);

		JLabel lblGros = new JLabel("Gros :");
		lblGros.setForeground(new Color(0, 51, 102));
		lblGros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGros.setBounds(837, 281, 84, 14);
		contentPane.add(lblGros);

		JLabel lblArticle = new JLabel("Article :");
		lblArticle.setForeground(new Color(0, 51, 102));
		lblArticle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblArticle.setBounds(837, 319, 84, 14);
		contentPane.add(lblArticle);

		JLabel lblQuai = new JLabel("Quai :");
		lblQuai.setForeground(new Color(0, 51, 102));
		lblQuai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuai.setBounds(837, 360, 84, 14);
		contentPane.add(lblQuai);

		JLabel lblDateDouverture = new JLabel("Date d\u2019Ouverture :");
		lblDateDouverture.setForeground(new Color(0, 51, 102));
		lblDateDouverture.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateDouverture.setBounds(400, 244, 124, 14);
		contentPane.add(lblDateDouverture);

		JLabel nContenur = new JLabel("N\u00B0 :");
		nContenur.setForeground(new Color(0, 51, 102));
		nContenur.setFont(new Font("Tahoma", Font.BOLD, 12));
		nContenur.setBounds(535, 458, 32, 14);
		contentPane.add(nContenur);

		JLabel lblTypeConteneur = new JLabel("Type Conteneur :");
		lblTypeConteneur.setForeground(new Color(0, 51, 102));
		lblTypeConteneur.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTypeConteneur.setBounds(357, 503, 113, 14);
		contentPane.add(lblTypeConteneur);

		JLabel lblTypeMarchandise = new JLabel("Type Marchandise:");
		lblTypeMarchandise.setForeground(new Color(0, 51, 102));
		lblTypeMarchandise.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTypeMarchandise.setBounds(357, 549, 113, 14);
		contentPane.add(lblTypeMarchandise);

		JLabel lblClient = new JLabel("Client :");
		lblClient.setForeground(new Color(0, 51, 102));
		lblClient.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClient.setBounds(615, 180, 52, 14);
		contentPane.add(lblClient);

		JLabel lblMarqueConteneur = new JLabel("Marque :");
		lblMarqueConteneur.setForeground(new Color(0, 51, 102));
		lblMarqueConteneur.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMarqueConteneur.setBounds(357, 458, 62, 14);
		contentPane.add(lblMarqueConteneur);

		JLabel lblPoids = new JLabel("Poids :");
		lblPoids.setForeground(new Color(0, 51, 102));
		lblPoids.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPoids.setBounds(896, 460, 43, 14);
		contentPane.add(lblPoids);

		JLabel lblValeur = new JLabel("Valeur :");
		lblValeur.setForeground(new Color(0, 51, 102));
		lblValeur.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValeur.setBounds(1031, 458, 52, 14);
		contentPane.add(lblValeur);

		JLabel lblNPlombage = new JLabel("N\u00B0 Plombage :");
		lblNPlombage.setForeground(new Color(0, 51, 102));
		lblNPlombage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNPlombage.setBounds(685, 458, 97, 14);
		contentPane.add(lblNPlombage);

		// -------------------------------------------------------------------------------//

		// ---------------END LABELS--------------------//
		// -------------------------------------------------------------------------------//
		// ---------------DEBUT FIELDS--------------------//
		field_Code = new JTextField("");
		field_Code.setBounds(67, 116, 178, 29);
		field_Code.setFont(new Font("Tahoma", Font.BOLD, 14));
		field_Code.setHorizontalAlignment(SwingConstants.CENTER);
		field_Code.setEditable(false);
		panel_info.add(field_Code);
		field_Code.setColumns(10);

		field_FullName = new JTextField();
		field_FullName.setBounds(67, 185, 178, 29);
		field_FullName.setFont(new Font("Tahoma", Font.BOLD, 14));
		field_FullName.setHorizontalAlignment(SwingConstants.CENTER);
		field_FullName.setEditable(false);
		field_FullName.setColumns(10);
		panel_info.add(field_FullName);

		field_Raison = new JTextField();
		field_Raison.setBounds(67, 249, 178, 29);
		field_Raison.setFont(new Font("Tahoma", Font.BOLD, 13));
		field_Raison.setHorizontalAlignment(SwingConstants.CENTER);
		field_Raison.setEditable(false);
		field_Raison.setColumns(10);
		panel_info.add(field_Raison);

		field_Mobile = new JTextField();
		field_Mobile.setBounds(67, 314, 178, 29);
		field_Mobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		field_Mobile.setHorizontalAlignment(SwingConstants.CENTER);
		field_Mobile.setEditable(false);
		field_Mobile.setColumns(10);
		panel_info.add(field_Mobile);

		field_Email = new JTextField();
		field_Email.setBounds(67, 379, 178, 29);
		field_Email.setFont(new Font("Tahoma", Font.BOLD, 14));
		field_Email.setHorizontalAlignment(SwingConstants.CENTER);
		field_Email.setEditable(false);
		field_Email.setColumns(10);
		panel_info.add(field_Email);

		field_Rc = new JTextField();
		field_Rc.setBounds(67, 453, 178, 29);
		field_Rc.setFont(new Font("Tahoma", Font.BOLD, 14));
		field_Rc.setHorizontalAlignment(SwingConstants.CENTER);
		field_Rc.setEditable(false);
		field_Rc.setColumns(10);
		panel_info.add(field_Rc);

		field_NConteneur = new JTextField();
		field_NConteneur.setForeground(SystemColor.inactiveCaptionText);
		field_NConteneur.setFont(new Font("Tahoma", Font.BOLD, 11));
		field_NConteneur.setHorizontalAlignment(SwingConstants.CENTER);
		field_NConteneur.setColumns(10);
		field_NConteneur.setBounds(558, 453, 118, 27);
		contentPane.add(field_NConteneur);

		field_Marque = new JTextField();
		field_Marque.setForeground(SystemColor.inactiveCaptionText);
		field_Marque.setFont(new Font("Tahoma", Font.BOLD, 11));
		field_Marque.setHorizontalAlignment(SwingConstants.CENTER);
		field_Marque.setColumns(10);
		field_Marque.setBounds(418, 453, 107, 27);
		contentPane.add(field_Marque);

		field_Plomb = new JTextField();
		field_Plomb.setForeground(SystemColor.inactiveCaptionText);
		field_Plomb.setFont(new Font("Tahoma", Font.BOLD, 11));
		field_Plomb.setHorizontalAlignment(SwingConstants.CENTER);
		field_Plomb.setColumns(10);
		field_Plomb.setBounds(774, 453, 118, 27);
		contentPane.add(field_Plomb);

		field_Valeur = new JTextField();
		field_Valeur.setForeground(SystemColor.inactiveCaptionText);
		field_Valeur.setFont(new Font("Tahoma", Font.BOLD, 11));
		field_Valeur.setHorizontalAlignment(SwingConstants.CENTER);
		field_Valeur.setColumns(10);
		field_Valeur.setBounds(1081, 453, 118, 27);
		contentPane.add(field_Valeur);

		filed_Poids = new JTextField();
		filed_Poids.setForeground(SystemColor.inactiveCaptionText);
		filed_Poids.setFont(new Font("Tahoma", Font.BOLD, 11));
		filed_Poids.setHorizontalAlignment(SwingConstants.CENTER);
		filed_Poids.setColumns(10);
		filed_Poids.setBounds(949, 453, 72, 27);
		contentPane.add(filed_Poids);

		Field_Transport = new JTextField();
		Field_Transport.setFont(new Font("Tahoma", Font.BOLD, 11));
		Field_Transport.setHorizontalAlignment(SwingConstants.CENTER);
		Field_Transport.setForeground(SystemColor.inactiveCaptionText);
		Field_Transport.setColumns(10);
		Field_Transport.setBounds(616, 323, 128, 27);
		contentPane.add(Field_Transport);

		// ---------------END FIELDS--------------------//
		// -------------------------------------------------------------------------------//

		// ---------------DEBUT BOTTUN--------------------//

		btnValider = new JButton("");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valide)
					JOptionPane.showMessageDialog(null, "Error Saisie");
			}
		});
		btnValider.setRolloverIcon(new ImageIcon(Dossier_Form_View.class.getResource("/img/Valider_ap.png")));
		btnValider.setIcon(new ImageIcon(Dossier_Form_View.class.getResource("/img/Valider.png")));
		btnValider.setBounds(719, 642, 156, 44);
		contentPane.add(btnValider);

		btn_rech = new JButton("");
		btn_rech.setRolloverIcon(new ImageIcon(Dossier_Form_View.class.getResource("/img/select_ap.png")));
		btn_rech.setFocusCycleRoot(true);
		btn_rech.setFocusPainted(false);
		btn_rech.setFocusTraversalPolicyProvider(true);
		btn_rech.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btn_rech.setBorderPainted(false);
		btn_rech.setBorder(null);
		btn_rech.setIcon(new ImageIcon(Dossier_Form_View.class.getResource("/img/select.png")));
		btn_rech.setBounds(670, 163, 156, 44);
		contentPane.add(btn_rech);

		// ---------------END BOTTUN--------------------//
		// -------------------------------------------------------------------------------//

		// ---------------DEBUT COMBO-BOX--------------------//
		customCombobox = new CountryComboBox();
		customCombobox.setBounds(534, 366, 209, 30);
		// customCombobox.setPreferredSize(new Dimension(120, 30));
		customCombobox.setEditable(true);
		customCombobox.addItems(CustomComboBoxTester.countryList);
		customCombobox.setSelectedIndex(45);

		Provenance = CountryItemEditor.getNameItem();
		customCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Provenance = CountryItemEditor.getNameItem();
			}
		});
		contentPane.add(customCombobox);

		Combo_Trans = new JComboBox<String>();
		Combo_Trans.setForeground(new Color(0, 0, 128));
		Combo_Trans.setModel(new DefaultComboBoxModel<String>(new String[] { "Navire", "Avire" }));
		Combo_Trans.setBounds(534, 326, 72, 20);
		contentPane.add(Combo_Trans);

		Combo_Rep = new JComboBox<String>();
		Combo_Rep.setForeground(new Color(0, 0, 128));
		Combo_Rep.setModel(new DefaultComboBoxModel<String>(new String[] { "DSTR", "OT" }));
		Combo_Rep.setBounds(534, 281, 72, 20);
		contentPane.add(Combo_Rep);

		comboTypeCont = new JComboBox<String>();
		Utile.remplirComboNoId(comboTypeCont, "type_conteneur", "Type_Conteneurcol");
		comboTypeCont.setBounds(474, 498, 120, 27);
		contentPane.add(comboTypeCont);

		comboTypeMarch = new JComboBox<String>();
		Utile.remplirComboNoId(comboTypeMarch, "type_marchandise", "Type_Marchandise");
		comboTypeMarch.setBounds(474, 544, 120, 27);
		contentPane.add(comboTypeMarch);

		// ---------------END COMBO-BOX--------------------//
		// -------------------------------------------------------------------------------//

		// ---------------DEBUT DATE--------------------//

		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, 0);
		DateOuvert = new JDateChooser(c.getTime());
		DateOuvert.setFont(new Font("Tahoma", Font.BOLD, 11));
		DateOuvert.setForeground(new Color(25, 25, 112));
		DateOuvert.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		DateOuvert.setBounds(534, 241, 128, 23);
		contentPane.add(DateOuvert);

		DateArrive = new JDateChooser();
		DateArrive.setForeground(SystemColor.inactiveCaptionText);
		DateArrive.setFont(new Font("Tahoma", Font.BOLD, 11));
		DateArrive.setBounds(901, 240, 128, 23);
		contentPane.add(DateArrive);


		// ---------------END DATE--------------------//
		// -------------------------------------------------------------------------------//

		// ---------------DEBUT TABLE--------------------//

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(644, 497, 611, 134);
		contentPane.add(scrollPane);

		Dos_Cont_Tab modele = new Dos_Cont_Tab();
		Table = new JTable(modele);
		Table.setRowHeight(22);
		Utile.Entete_Table(Table);
		Utile.Centrer_Table(Table);
		scrollPane.setViewportView(Table);

		btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!(field_NConteneur.getText().equals("") || field_Plomb.getText().equals(""))) {
					if (!Utile.NoPlombageExisteDb(field_Plomb.getText())
							&& !Utile.NoPlombageExisteTab(field_Plomb.getText(), Table)) {
						modele.addConteneur(new Dos_Cont_Model(field_Marque.getText(), field_NConteneur.getText(),
								field_Plomb.getText(), comboTypeCont.getSelectedItem().toString(),
								comboTypeMarch.getSelectedItem().toString(), filed_Poids.getText(),
								field_Valeur.getText()));
						ViderChamp();
						field_Plomb.setBackground(Color.WHITE);
						field_Plomb.setForeground(Color.BLACK);
						NbConteneur++;

					} else {
						JOptionPane.showMessageDialog(null, "le N° de Plombage existe Déja");
						field_Plomb.setText("");
						field_Plomb.setBackground(Color.RED);
						field_Plomb.setForeground(Color.WHITE);
					}
				} else
					JOptionPane.showMessageDialog(null, "Veuillez Remplissez les champs vides(N°TC ou/et N° Plompage");

			}
		});
		btnAdd.setBounds(388, 590, 89, 23);
		contentPane.add(btnAdd);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selection = Table.getSelectedRows();

				for (int i = selection.length - 1; i >= 0; i--) {
					modele.removeConteneur(selection[i]);
					NbConteneur--;
				}

			}
		});
		btnSupprimer.setBounds(489, 590, 105, 23);
		contentPane.add(btnSupprimer);

		plusTypeTC = new JButton("");
		plusTypeTC.setFocusTraversalPolicyProvider(true);
		plusTypeTC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Conteneur_Ctrl();
			}
		});
		plusTypeTC.setRolloverIcon(new ImageIcon(Dossier_Form_View.class.getResource("/img/plus_ap.png")));
		plusTypeTC.setContentAreaFilled(false);
		plusTypeTC.setBorderPainted(false);
		plusTypeTC.setIcon(new ImageIcon(Dossier_Form_View.class.getResource("/img/plus.png")));
		plusTypeTC.setBounds(599, 491, 35, 35);
		contentPane.add(plusTypeTC);

		plusTypeMarch = new JButton("");
		plusTypeMarch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Marchandise_Ctrl();
			}
		});
		plusTypeMarch.setRolloverIcon(new ImageIcon(Dossier_Form_View.class.getResource("/img/plus_ap.png")));
		plusTypeMarch.setContentAreaFilled(false);
		plusTypeMarch.setBorderPainted(false);
		plusTypeMarch.setRequestFocusEnabled(false);
		plusTypeMarch.setIcon(new ImageIcon(Dossier_Form_View.class.getResource("/img/plus.png")));
		plusTypeMarch.setBounds(600, 536, 35, 35);
		contentPane.add(plusTypeMarch);

		JPanel panel = new JPanel();
		panel.setBounds(883, 265, 156, 134);
		panel.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);

		field_gros = new JTextField();
		field_gros.setBounds(13, 11, 128, 27);
		panel.add(field_gros);
		field_gros.setFont(new Font("Tahoma", Font.BOLD, 11));
		field_gros.setHorizontalAlignment(SwingConstants.CENTER);
		field_gros.setForeground(SystemColor.inactiveCaptionText);
		field_gros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				valide = control_varchar(field_gros);
			}
		});
		field_gros.setColumns(10);

		field_Article = new JTextField();
		field_Article.setBounds(13, 49, 128, 27);
		panel.add(field_Article);
		field_Article.setFont(new Font("Tahoma", Font.BOLD, 11));
		field_Article.setHorizontalAlignment(SwingConstants.CENTER);
		field_Article.setForeground(SystemColor.inactiveCaptionText);
		field_Article.setColumns(10);

		field_Quai = new JTextField();
		field_Quai.setBounds(10, 90, 128, 27);
		panel.add(field_Quai);
		field_Quai.setFont(new Font("Tahoma", Font.BOLD, 11));
		field_Quai.setHorizontalAlignment(SwingConstants.CENTER);
		field_Quai.setForeground(SystemColor.inactiveCaptionText);
		field_Quai.setColumns(10);

		// ---------------END TABLE--------------------//
		// -------------------------------------------------------------------------------//

		// /////////////////////////// Debut Wallpaper /////////////////////////
		JLabel Wall = new JLabel("");
		Wall.setInheritsPopupMenu(false);
		Wall.setIcon(new ImageIcon(Login_Viex.class.getResource("/img/wall.jpg")));
		Wall.setSize(screenSize.width, screenSize.height - taskBarSize);
		contentPane.add(Wall);
		// ////////////////////////// Fin Wallpaper /////////////////////////

	}

	// -------------------------- Les methodes --------------------------//

	public boolean champVide() {
		if (DateOuvert.getDate() == null || DateArrive.getDate() == null || field_Code.getText().equals("")
				|| Table.getRowCount() == 0 || Provenance.equals(""))
			return true;
		return false;

	}
	// -----------------------------------------------------//

	public void SetChampVide() {
		DateOuvert.setDate(null);
		DateArrive.setDate(null);
		Combo_Rep.setCursor(null);
		Combo_Trans.setCursor(null);
		Field_Transport.setText("");
		field_gros.setText("");
		field_Article.setText("");
		field_Quai.setText("");
	}

	// -----------------------------------------------------//

	public Dossier RecupereInfo() {

		java.util.Date DateO = DateOuvert.getDate();
		java.sql.Date DateOuvertSQl = new java.sql.Date(DateO.getTime());

		java.util.Date DateA = DateArrive.getDate();
		java.sql.Date DateArrivetSQl = new java.sql.Date(DateA.getTime());

		return new Dossier(Integer.parseInt(field_Code.getText()), DateOuvertSQl, DateArrivetSQl,
				(String) Combo_Rep.getSelectedItem(), (String) Combo_Trans.getSelectedItem(), Field_Transport.getText(),
				Provenance, field_gros.getText(), field_Article.getText(), field_Quai.getText());
	}
	// -----------------------------------------------------//

	static public void SetFicheClient(Client client) {

		field_Code.setText(String.valueOf(client.getId()));
		field_FullName.setText(client.getNom() + " " + client.getPrenom());
		field_Raison.setText(client.getEntreprise_Client());
		field_Mobile.setText(client.getPhone());
		field_Email.setText(client.getEmail_Client());
		field_Rc.setText(client.getRC_Client());

	}
	// -----------------------------------------------------//

	public void ViderChamp() {
		filed_Poids.setText("");
		field_NConteneur.setText("");
		field_Plomb.setText("");
		field_Valeur.setText("");
		field_Marque.setText("");
	}
	// -----------------------------------------------------//

	public boolean control_varchar(JTextField JTF) {
		String nom = JTF.getText();
		char s;
		boolean number = false;
		for (int j = 0; (j < JTF.getText().length()) && (!number); j++) {
			s = nom.charAt(j);
			if (!((s > 61 && s < 92) || (s > 96 && s < 123) || (s >= 48 && s <= 57) || s == '_' || s == '-'))
				number = true;
		}

		if (number) {
			JTF.setBackground(Color.ORANGE);
		} else {
			JTF.setBackground(Color.WHITE);
		}
		return number;
	}

	// -----------------------------------------------------//

	public boolean control_num(JTextField JTF) {
		String nom = JTF.getText();
		char s;
		boolean number = false;
		for (int j = 0; (j < JTF.getText().length()) && (!number); j++) {
			s = nom.charAt(j);
			if (!(s >= 48 && s <= 57))
				number = true;
		}

		if (number) {
			JTF.setBackground(Color.ORANGE);
		} else {
			JTF.setBackground(Color.WHITE);
		}
		return number;
	}
	// -----------------------------------------------------//

	public boolean control_float(JTextField JTF) {
		String nom = JTF.getText();
		char s;
		int cpt = 0;
		boolean number = false;
		for (int j = 0; (j < JTF.getText().length()) && (!number); j++) {
			s = nom.charAt(j);
			if (!((s >= 48 && s <= 57) || s == '.'))
				number = true;
			if (s == '.')
				cpt++;
		}
		if (cpt > 1)
			number = true;
		if (number) {
			JTF.setBackground(Color.ORANGE);
		} else {
			JTF.setBackground(Color.WHITE);
		}
		return number;
	}


	// ----------------------- Les getters & setters ------------------------//

	public JTable getTable() {
		return Table;
	}

	// -----------------------------------------------------//

	public void setTable(JTable table) {
		Table = table;
	}
	// -----------------------------------------------------//


	public JTextField getField_Code() {
		return field_Code;
	}
	// -----------------------------------------------------//

	@SuppressWarnings("static-access")
	public void setField_Code(JTextField field_Code) {
		this.field_Code = field_Code;
	}
	// -----------------------------------------------------//

	public JTextField getField_FullName() {
		return field_FullName;
	}
	// -----------------------------------------------------//

	@SuppressWarnings("static-access")
	public void setField_FullName(JTextField field_FullName) {
		this.field_FullName = field_FullName;
	}
	// -----------------------------------------------------//

	public JTextField getField_Raison() {
		return field_Raison;
	}
	// -----------------------------------------------------//

	@SuppressWarnings("static-access")
	public void setField_Raison(JTextField field_Raison) {
		this.field_Raison = field_Raison;
	}
// -----------------------------------------------------//

	public JTextField getField_Mobile() {
		return field_Mobile;
	}
	// -----------------------------------------------------//

	@SuppressWarnings("static-access")
	public void setField_Mobile(JTextField field_Mobile) {
		this.field_Mobile = field_Mobile;
	}
	// -----------------------------------------------------//

	public JTextField getField_Email() {
		return field_Email;
	}
	// -----------------------------------------------------//

	@SuppressWarnings("static-access")
	public void setField_Email(JTextField field_Email) {
		this.field_Email = field_Email;
	}

	public JTextField getField_Rc() {
		return field_Rc;
	}

	@SuppressWarnings("static-access")
	public void setField_Rc(JTextField field_Rc) {
		this.field_Rc = field_Rc;
	}

	public JButton getReturne() {
		return Returne;
	}

	public void setReturne(JButton returne) {
		Returne = returne;
	}

	public JButton getBtnValider() {
		return btnValider;
	}

	public JButton getBtn_rech() {
		return btn_rech;
	}
}
