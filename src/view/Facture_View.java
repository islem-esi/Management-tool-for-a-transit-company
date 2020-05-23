package view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import model.NombresEnLettres;
import model.Utile;
import model.entity.BonVisite;
import model.entity.Dossier;
import model.entity.Facture;
import model.entity.Facture_Designation;
import model.table.Facture_Model;
import model.table.Facture_Tab;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Facture_View extends JFrame {
	// ------------------- Les déclarations  -----------------------//

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_Tab;
	private JPanel panel_info;
	private JButton Returne;
	private JButton BtnModifTable;
	private JButton BtnSuppTable;
	private JButton BtnValider;
	private JButton BtnPrint;
	private JButton BtnAjoutTable;
	private JTable table;
	private Facture_Tab modele;
	private JSpinner spin_nbre;
	private JSpinner spin_qte;
	private JComboBox<String> combo_Designation;
	private JTextField field_observation;
	private JTextField field_PU;
	private JTextField field_Code;
	private JTextField field_DateOuverture;
	private JTextField fieldStatutDossier;
	private JTextField filed_Rep;
	private JTextField field_Transport;
	private JTextField txtProvenance;
	private JTextField txtQuai;
	public static JTextField field_THT;
	public static JTextField field_totalDebour;
	public static JTextField field_TTva;
	public static JTextField field_TVA;
	public static JTextField field_TTC;
	public static JTextField txtGros;
	public static JTextField txtDateDarrive;
	public static JTextField txtArticle;
	public static JTextField fieldNbTc;
	public static JLabel sommeTXT;
	private JLabel lblC;
	private JLabel lbl_date;
	private JLabel lblMobile;
	private JLabel lblEmail;
	private JLabel lblRegistreCommerce;
	public JLabel lbnbconteneur;
	private JLabel Dossier_Info;
	private JLabel lblPU;
	private int IdDesignation;
	private int IdDossier;
	private float THT;
	private float DEB;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JTextField fieldCheque;
	public JTextField textField;
	public JTextField fieldEffectue;
	private JLabel Labeleffectue;
	private JRadioButton rdbtnEspece, rdbtnChaque;

	// -------------------------- Le constructeur --------------------------//

	public Facture_View() {
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
		panel_Tab = new JPanel();
		panel_Tab.setBounds(431, 166, 892, 465);
		contentPane.add(panel_Tab);
		panel_Tab.setLayout(null);

		// ---------------END PANNEL--------------------//

		// ---------------DEBUT LABELS--------------------//
		JLabel lblDesignation = new JLabel("D\u00E9signation :");
		lblDesignation.setBounds(10, 24, 81, 15);
		panel_Tab.add(lblDesignation);
		lblDesignation.setForeground(new Color(0, 0, 128));
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 12));

		lblPU = new JLabel("Prix Unitaire :");
		lblPU.setBounds(397, 24, 83, 15);
		panel_Tab.add(lblPU);
		lblPU.setForeground(new Color(0, 0, 128));
		lblPU.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel Txt_AjouterDossier = new JLabel("Facture ");
		Txt_AjouterDossier.setForeground(new Color(0, 51, 102));
		Txt_AjouterDossier.setBounds(782, 120, 168, 35);
		Txt_AjouterDossier.setFont(new Font("Impact", Font.PLAIN, 40));
		contentPane.add(Txt_AjouterDossier);

		JLabel lblNbre = new JLabel("Nbre :");
		lblNbre.setForeground(new Color(0, 0, 128));
		lblNbre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNbre.setBounds(745, 21, 36, 15);
		panel_Tab.add(lblNbre);

		JLabel lblTxtTotal = new JLabel("Arr\u00EAter la pr\u00E9sente facture \u00E0 la somme de :");
		lblTxtTotal.setForeground(new Color(0, 0, 128));
		lblTxtTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTxtTotal.setBounds(460, 401, 273, 15);
		panel_Tab.add(lblTxtTotal);

		JLabel lbl_Observation = new JLabel("Observation :");
		lbl_Observation.setForeground(new Color(0, 0, 128));
		lbl_Observation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_Observation.setBounds(397, 43, 83, 15);
		panel_Tab.add(lbl_Observation);

		JLabel lblTotalHt = new JLabel("Montant HT :");
		lblTotalHt.setForeground(new Color(0, 0, 128));
		lblTotalHt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalHt.setBounds(10, 362, 104, 15);
		panel_Tab.add(lblTotalHt);

		JLabel lblTotalDebours = new JLabel("Montant Debours :");
		lblTotalDebours.setForeground(new Color(0, 0, 128));
		lblTotalDebours.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalDebours.setBounds(215, 362, 122, 15);
		panel_Tab.add(lblTotalDebours);

		JLabel lblTauxTva = new JLabel("Montant TVA :");
		lblTauxTva.setForeground(new Color(0, 0, 128));
		lblTauxTva.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTauxTva.setBounds(122, 391, 104, 15);
		panel_Tab.add(lblTauxTva);

		JLabel lblTva = new JLabel("Taux TVA % :");
		lblTva.setForeground(new Color(0, 0, 128));
		lblTva.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTva.setBounds(10, 390, 91, 15);
		panel_Tab.add(lblTva);

		JLabel lblTtc = new JLabel("NET A PAYER :");
		lblTtc.setForeground(new Color(0, 0, 128));
		lblTtc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTtc.setBounds(666, 362, 104, 15);
		panel_Tab.add(lblTtc);

		// ---------------DEBUT Spinner--------------------//

		spin_qte = new JSpinner();
		spin_qte.setFont(new Font("Tahoma", Font.BOLD, 12));
		spin_qte.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spin_qte.setBounds(684, 19, 49, 20);
		panel_Tab.add(spin_qte);

		spin_nbre = new JSpinner();
		spin_nbre.setFont(new Font("Tahoma", Font.BOLD, 12));
		spin_nbre.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spin_nbre.setBounds(785, 19, 49, 20);
		panel_Tab.add(spin_nbre);

		// ---------------DEBUT Fields--------------------//
		field_PU = new JTextField();
		field_PU.setFont(new Font("Tahoma", Font.BOLD, 12));
		field_PU.setEditable(false);
		field_PU.setBounds(490, 22, 86, 20);
		panel_Tab.add(field_PU);
		field_PU.setColumns(10);
		field_PU.setText(String.valueOf(Utile.GetPrix(1)));

		JLabel lblQt = new JLabel("Vol/Qt\u00E9 :");
		lblQt.setBounds(626, 21, 61, 15);
		panel_Tab.add(lblQt);
		lblQt.setForeground(new Color(0, 0, 128));
		lblQt.setFont(new Font("Tahoma", Font.BOLD, 12));

		// ---------------DEBUT Button--------------------//

		BtnAjoutTable = new JButton("");
		BtnAjoutTable.setRolloverIcon(new ImageIcon(Facture_View.class.getResource("/img/ajouter_ap.png")));
		BtnAjoutTable.setIcon(new ImageIcon(Facture_View.class.getResource("/img/ajouter.png")));
		BtnAjoutTable.setBounds(181, 69, 156, 44);
		panel_Tab.add(BtnAjoutTable);

		BtnModifTable = new JButton("");
		BtnModifTable.setRolloverIcon(new ImageIcon(Facture_View.class.getResource("/img/edit_ap.png")));
		BtnModifTable.setIcon(new ImageIcon(Facture_View.class.getResource("/img/edit.png")));
		BtnModifTable.setBounds(370, 69, 156, 44);
		panel_Tab.add(BtnModifTable);

		BtnSuppTable = new JButton("");
		BtnSuppTable.setRolloverIcon(new ImageIcon(Facture_View.class.getResource("/img/dalete_ap.png")));
		BtnSuppTable.setIcon(new ImageIcon(Facture_View.class.getResource("/img/delete.png")));
		BtnSuppTable.setBounds(559, 69, 156, 44);
		panel_Tab.add(BtnSuppTable);

		BtnValider = new JButton("");
		BtnValider.setRolloverIcon(new ImageIcon(Facture_View.class.getResource("/img/Valider_ap.png")));
		BtnValider.setIcon(new ImageIcon(Facture_View.class.getResource("/img/Valider.png")));
		BtnValider.setBounds(710, 642, 156, 44);
		contentPane.add(BtnValider);

		BtnPrint = new JButton("");
		BtnPrint.setEnabled(false);
		BtnPrint.setRolloverIcon(new ImageIcon(Facture_View.class.getResource("/img/print_ap.png")));
		BtnPrint.setIcon(new ImageIcon(Facture_View.class.getResource("/img/print.png")));
		BtnPrint.setBounds(876, 642, 156, 44);
		contentPane.add(BtnPrint);

		// ---------------DEBUT TABLE----------------//
		/////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 124, 845, 225);
		panel_Tab.add(scrollPane);

		modele = new Facture_Tab();
		table = new JTable(modele);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setUpdateSelectionOnSort(false);
		table.setRowHeight(22);
		Utile.Entete_Table(table);
		Utile.Centrer_Table(table);
		Utile.Property_Table(table);

		scrollPane.setViewportView(table);

		BtnAjoutTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IdDesignation = Utile.getIdFromCombo(combo_Designation.getSelectedItem().toString());
				if (!Utile.PossedeDebour(IdDesignation))
					AddTableSansDebour();
				else
					AddTableDebour();
			}
		});

		BtnSuppTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selection = table.getSelectedRow();
				if (table.getModel().getValueAt(selection, 5).toString().equals("0.0")) {

					DEB -= (float) modele.getValueAt(selection, 6);
					field_totalDebour.setText(String.valueOf(DEB));
					field_TTC.setText(String.valueOf(DEB + THT + Float.parseFloat(field_TTva.getText())));
					sommeTXT.setText(NombresEnLettres.convert((long) Float.parseFloat(field_TTC.getText())));
				} else {
					THT -= (float) modele.getValueAt(selection, 5);
					field_THT.setText(String.valueOf(THT));
					field_TTva.setText(String.valueOf(THT * (Float.parseFloat(field_TVA.getText()) / 100)));
					field_TTC.setText(String.valueOf(THT + Float.parseFloat(field_TTva.getText())));
					sommeTXT.setText(NombresEnLettres.convert((long) Float.parseFloat(field_TTC.getText())));
				}
				modele.removeDesignation(selection);
			}
		});

		// ---------------FIN TABLE----------------//
		/////////////////////////////////////////////////////////////////////////////////
		//////////// FICHE DOSSIER
		panel_info = new JPanel();
		// panel_info.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		// panel_info.setBackground(new Color(255, 255, 255, 255));
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

		field_DateOuverture = new JTextField();
		field_DateOuverture.setForeground(new Color(51, 51, 51));
		field_DateOuverture.setHorizontalAlignment(SwingConstants.CENTER);
		field_DateOuverture.setFont(new Font("Raavi", Font.BOLD, 14));
		field_DateOuverture.setText("");
		field_DateOuverture.setEditable(false);
		field_DateOuverture.setColumns(10);
		field_DateOuverture.setBounds(160, 112, 178, 29);
		panel_info.add(field_DateOuverture);

		fieldNbTc = new JTextField();
		fieldNbTc.setForeground(new Color(51, 51, 51));
		fieldNbTc.setHorizontalAlignment(SwingConstants.CENTER);
		fieldNbTc.setFont(new Font("Raavi", Font.BOLD, 14));
		fieldNbTc.setText("");
		fieldNbTc.setEditable(false);
		fieldNbTc.setColumns(10);
		fieldNbTc.setBounds(160, 188, 178, 29);
		panel_info.add(fieldNbTc);

		fieldStatutDossier = new JTextField();
		fieldStatutDossier.setForeground(new Color(51, 51, 51));
		fieldStatutDossier.setHorizontalAlignment(SwingConstants.CENTER);
		fieldStatutDossier.setFont(new Font("Raavi", Font.BOLD, 14));
		fieldStatutDossier.setText("");
		fieldStatutDossier.setEditable(false);
		fieldStatutDossier.setColumns(10);
		fieldStatutDossier.setBounds(160, 228, 178, 29);
		panel_info.add(fieldStatutDossier);

		filed_Rep = new JTextField();
		filed_Rep.setForeground(new Color(51, 51, 51));
		filed_Rep.setHorizontalAlignment(SwingConstants.CENTER);
		filed_Rep.setFont(new Font("Raavi", Font.BOLD, 14));
		filed_Rep.setText("");
		filed_Rep.setEditable(false);
		filed_Rep.setColumns(10);
		filed_Rep.setBounds(160, 268, 178, 29);
		panel_info.add(filed_Rep);

		field_Transport = new JTextField();
		field_Transport.setForeground(new Color(51, 51, 51));
		field_Transport.setHorizontalAlignment(SwingConstants.CENTER);
		field_Transport.setFont(new Font("Raavi", Font.BOLD, 14));
		field_Transport.setText("");
		field_Transport.setEditable(false);
		field_Transport.setColumns(10);
		field_Transport.setBounds(160, 308, 178, 29);
		panel_info.add(field_Transport);

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

		//////////////////////////////////////////////////////////////////////////////

		// ---------------DEBUT ComboBox----------------//

		combo_Designation = new JComboBox<String>();
		combo_Designation.setBounds(95, 22, 292, 20);
		panel_Tab.add(combo_Designation);
		Utile.remplirCombo(combo_Designation, "designation", "Designation");
		combo_Designation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IdDesignation = Utile.getIdFromCombo(combo_Designation.getSelectedItem().toString());

				if (!Utile.PossedeDebour(IdDesignation)) {
					lblPU.setText("Prix Unitaire :");
					field_PU.setEditable(false);
					field_PU.setText(String.valueOf(Utile.GetPrix(IdDesignation)));

				} else {

					lblPU.setText("Debour :");
					field_PU.setEditable(true);
					field_PU.setText("0");
				}
				spin_nbre.setValue(1);
				spin_qte.setValue(1);

			}
		});

		field_THT = new JTextField();
		field_THT.setForeground(Color.DARK_GRAY);
		field_THT.setFont(new Font("Tahoma", Font.BOLD, 12));
		field_THT.setText("0.00");
		field_THT.setEditable(false);
		field_THT.setColumns(10);
		field_THT.setBounds(95, 360, 86, 20);
		panel_Tab.add(field_THT);

		field_totalDebour = new JTextField();
		field_totalDebour.setForeground(Color.DARK_GRAY);
		field_totalDebour.setFont(new Font("Tahoma", Font.BOLD, 12));
		field_totalDebour.setText("0.00");
		field_totalDebour.setEditable(false);
		field_totalDebour.setColumns(10);
		field_totalDebour.setBounds(355, 360, 86, 20);
		panel_Tab.add(field_totalDebour);

		field_TTva = new JTextField();
		field_TTva.setForeground(Color.DARK_GRAY);
		field_TTva.setFont(new Font("Tahoma", Font.BOLD, 12));
		field_TTva.setText("0.00");
		field_TTva.setEditable(false);
		field_TTva.setColumns(10);
		field_TTva.setBounds(215, 389, 86, 20);
		panel_Tab.add(field_TTva);

		field_TVA = new JTextField();
		field_TVA.setForeground(Color.DARK_GRAY);
		field_TVA.setFont(new Font("Tahoma", Font.BOLD, 12));
		field_TVA.setHorizontalAlignment(SwingConstants.LEFT);
		field_TVA.setText("19");
		field_TVA.setEditable(false);
		field_TVA.setColumns(10);
		field_TVA.setBounds(95, 388, 23, 20);
		panel_Tab.add(field_TVA);

		field_TTC = new JTextField();
		field_TTC.setFont(new Font("Tahoma", Font.BOLD, 12));
		field_TTC.setText("0.00");
		field_TTC.setForeground(new Color(204, 0, 51));
		field_TTC.setEditable(false);
		field_TTC.setColumns(10);
		field_TTC.setBounds(769, 360, 113, 20);
		panel_Tab.add(field_TTC);

		sommeTXT = new JLabel("");
		sommeTXT.setForeground(new Color(204, 0, 0));
		sommeTXT.setFont(new Font("Tahoma", Font.BOLD, 12));
		sommeTXT.setBounds(422, 416, 480, 36);
		panel_Tab.add(sommeTXT);

		field_observation = new JTextField();
		field_observation.setFont(new Font("Tahoma", Font.BOLD, 12));
		field_observation.setColumns(10);
		field_observation.setBounds(490, 45, 340, 20);
		panel_Tab.add(field_observation);

		fieldEffectue = new JTextField();
		fieldEffectue.setVisible(false);
		fieldEffectue.setForeground(Color.DARK_GRAY);
		fieldEffectue.setFont(new Font("Tahoma", Font.BOLD, 12));
		fieldEffectue.setColumns(10);
		fieldEffectue.setBounds(291, 436, 116, 20);
		panel_Tab.add(fieldEffectue);

		Labeleffectue = new JLabel("Effectu\u00E9 Par :");
		Labeleffectue.setVisible(false);
		Labeleffectue.setForeground(new Color(0, 0, 128));
		Labeleffectue.setFont(new Font("Tahoma", Font.BOLD, 12));
		Labeleffectue.setBounds(207, 439, 94, 15);
		panel_Tab.add(Labeleffectue);

		JLabel lblModeDeRgelemnt = new JLabel("Mode de payment :");
		lblModeDeRgelemnt.setForeground(Color.RED);
		lblModeDeRgelemnt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModeDeRgelemnt.setBounds(10, 416, 134, 15);
		panel_Tab.add(lblModeDeRgelemnt);

		fieldCheque = new JTextField();
		fieldCheque.setVisible(false);
		fieldCheque.setBounds(89, 437, 113, 20);
		panel_Tab.add(fieldCheque);
		fieldCheque.setColumns(10);

		JLabel lblNChque = new JLabel("N\u00B0 Ch\u00E8que :");
		lblNChque.setVisible(false);
		lblNChque.setForeground(new Color(0, 0, 128));
		lblNChque.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNChque.setBounds(10, 437, 91, 15);

		rdbtnChaque = new JRadioButton("Ch\u00E8que");
		rdbtnChaque.setFocusable(false);
		buttonGroup.add(rdbtnChaque);
		rdbtnChaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnChaque.isSelected()) {
					lblNChque.setVisible(true);
					fieldCheque.setVisible(true);
					Labeleffectue.setVisible(true);
					fieldEffectue.setVisible(true);
				}
			}
		});

		rdbtnChaque.setBounds(132, 413, 69, 23);
		panel_Tab.add(rdbtnChaque);

		rdbtnEspece = new JRadioButton("Esp\u00E9ce");
		rdbtnEspece.setSelected(true);
		rdbtnEspece.setFocusable(false);
		buttonGroup.add(rdbtnEspece);
		rdbtnEspece.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnEspece.isSelected()) {
					lblNChque.setVisible(false);
					fieldCheque.setVisible(false);
					Labeleffectue.setVisible(false);
					fieldEffectue.setVisible(false);

				}
			}
		});

		rdbtnEspece.setBounds(197, 413, 69, 23);

		panel_Tab.add(rdbtnEspece);

		panel_Tab.add(lblNChque);

		JLabel lblTimbre = new JLabel("Droit de timbre :");
		lblTimbre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimbre.setForeground(Color.RED);
		lblTimbre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTimbre.setBounds(262, 417, 108, 15);
		panel_Tab.add(lblTimbre);

		textField = new JTextField();
		textField.setText("0.01");
		textField.setForeground(Color.DARK_GRAY);
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(373, 412, 39, 20);
		panel_Tab.add(textField);

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
	public void AddTableDebour() {

		if (!DesExiste(IdDesignation)) {
			lblPU.setText("Debour :");
			field_PU.setEditable(true);

			float deb = Float.parseFloat(field_PU.getText());

			modele.addDesignation(new Facture_Model(IdDesignation,
					Utile.getTextFromCombo(combo_Designation.getSelectedItem().toString()), 0, 0, 0, 0,
					Float.parseFloat(field_PU.getText()), field_observation.getText()));
			DEB += deb;
			field_totalDebour.setText(String.valueOf(DEB));
			field_TTC.setText(String.valueOf(DEB + THT + Float.parseFloat(field_TTva.getText())));
			sommeTXT.setText(NombresEnLettres.convert((long) Float.parseFloat(field_TTC.getText())));
			field_observation.setText("");

		} else
			JOptionPane.showMessageDialog(null, "Designation déja ajouter ");
	}

	// -----------------------------------------------------//

	public void AddTableSansDebour() {

		if (!DesExiste(IdDesignation)) {
			lblPU.setText("Prix Unitaire :");
			field_PU.setEditable(false);
			float ht = Float.parseFloat(field_PU.getText()) * (int) spin_qte.getValue() * (int) spin_nbre.getValue();

			modele.addDesignation(new Facture_Model(IdDesignation,
					Utile.getTextFromCombo(combo_Designation.getSelectedItem().toString()), (int) spin_qte.getValue(),
					(int) spin_nbre.getValue(), Float.parseFloat(field_PU.getText()), ht, 0.00f,
					field_observation.getText()));
			THT += ht;
			field_THT.setText(String.valueOf(THT));
			field_TTva.setText(String.valueOf(THT * (Float.parseFloat(field_TVA.getText()) / 100)));
			field_TTC.setText(String.valueOf(THT + Float.parseFloat(field_TTva.getText())));
			sommeTXT.setText(NombresEnLettres.convert((long) Float.parseFloat(field_TTC.getText())));
			field_observation.setText("");

		} else
			JOptionPane.showMessageDialog(null, "Designation déja ajouter ");
	}

	// -----------------------------------------------------//

	public boolean DesExiste(int idDesignation) {

		for (int i = 0; i < table.getRowCount(); i++) {
			if (idDesignation == (int) table.getValueAt(i, 0))
				return true;
		}
		return false;
	}

	// -----------------------------------------------------//

	public boolean champVide() {
		if (table.getRowCount() == 0)
			return true;
		return false;
	}

	// -----------------------------------------------------//

	public Facture RecupereInfo() {

		return new Facture(Float.parseFloat(field_THT.getText()), Float.parseFloat(field_totalDebour.getText()),
				Float.parseFloat(field_TVA.getText()), Float.parseFloat(field_TTC.getText()), sommeTXT.getText());
	}

	// -----------------------------------------------------//

	public void afficherDossier(Dossier dossier, BonVisite bon_visite) {
		IdDossier = dossier.getIdDossier();
		field_Code.setText("" + dossier.getIdDossier());
		field_DateOuverture.setText(dossier.getDate_Ouverture().toString());
		fieldNbTc.setText("" + dossier.getNbConteneur());
		fieldStatutDossier.setText(dossier.getStatut_Dossier());
		filed_Rep.setText(dossier.getRepertoire());
		field_Transport.setText(dossier.getMoyenTransport());
		field_Transport.setText(dossier.getMoyenTransport());
		txtProvenance.setText(dossier.getProvenance());
		txtGros.setText(dossier.getGros());
		txtDateDarrive.setText(dossier.getDate_Arrive().toString());
		txtArticle.setText(dossier.getArticle());
		txtQuai.setText(dossier.getQuai());
	}
	// -----------------------------------------------------//

	public void SetFacture_View_Info(Facture facture) {
		field_THT.setText(String.valueOf(facture.getTHT()));
		field_TTva.setText(String.valueOf(facture.getTVA()));
		field_TTC.setText(String.valueOf(facture.getTTC()));
		field_totalDebour.setText(String.valueOf(facture.getDebours()));
		sommeTXT.setText(facture.getTTC_Lettre());
		table.setModel(Facture_Designation.RecuperModel(IdDossier));
	}
	// -----------------------------------------------------//

	public void DisableBtn() {
		BtnAjoutTable.setEnabled(false);
		rdbtnChaque.setEnabled(false);
		rdbtnEspece.setEnabled(false);
		field_observation.setEnabled(false);
		BtnModifTable.setEnabled(false);
		BtnSuppTable.setEnabled(false);
		BtnPrint.setEnabled(true);
		BtnValider.setEnabled(false);
		combo_Designation.setEnabled(false);
	}
	// -----------------------------------------------------//

	// ----------------------- Les getters & setters ------------------------//


	public JButton getReturne() {
		return Returne;
	}

	// -----------------------------------------------------//
	public void setReturne(JButton returne) {
		Returne = returne;
	}
	// -----------------------------------------------------//

	public JButton getBtnValider() {
		return BtnValider;
	}
	// -----------------------------------------------------//

	public JTable getTable() {
		return table;
	}
	// -----------------------------------------------------//

	public JButton getBtnPrint() {
		return BtnPrint;
	}
	// -----------------------------------------------------//

	public void setModele(Facture_Tab modele) {
		this.modele = modele;
	}
}
