package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import com.toedter.calendar.JDateChooser;
import model.Utile;
import view.Theme.Msg;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class Statistique_View extends JFrame {

	// ------------------- Les déclarations  -----------------------//
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton RadioConteneur15, RadioConteneur16, RadioConteneur17;
	private JButton Returne;
	private JTable table, table2;
	private JPanel gfxChifrePane;
	private JPanel gfxFraudLegal;
	private JPanel gfxConteneur;
	private JRadioButton radio2015, radio2016, radio2017;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private int[] TC_Mois_2017 = new int[12];
	private int[] TC_Mois_2016 = new int[12];
	private int[] TC_Mois_2015 = new int[12];
	private int[] CA_Mois_2017 = new int[12];
	private int[] CA_Mois_2016 = new int[12];
	private int[] CA_Mois_2015 = new int[12];

	private int NbClient, NbDossier, NbConteneur, ChifreAffaire, NbFraude, NbLegale;
	private JLabel LabelNbLegaleDate;
	private JLabel LabelNbDossierDate;
	private JLabel LabelNbFraudeDate;
	private JLabel LabelNbTcDate;
	private JLabel LabelCADate;

	// -------------------------- Le constructeur --------------------------//
	public Statistique_View() {

		contentPane = new JPanel();
		NbClient = Utile.GetCountTable("client", "IdClient");
		NbDossier = Utile.GetCountTable("dossier", "IdDossier");
		ChifreAffaire = Utile.GetSumTable("facture", "ttc");
		NbConteneur = Utile.GetSumTable("dossier", "nbConteneur");
		NbFraude = Utile.GetCountFraude("dossier_conteneur", "Fraude", "FRAUDE");
		NbLegale = Utile.GetCountFraude("dossier_conteneur", "Fraude", "LEGALE");

		for (int i = 0; i < TC_Mois_2017.length; i++)
			TC_Mois_2017[i] = Utile.GetSumBetweenDate("dossier", "nbConteneur", "2017-" + (i + 1) + "-01",
					"2017-" + (i + 1) + "-31");

		for (int i = 0; i < TC_Mois_2016.length; i++)
			TC_Mois_2016[i] = Utile.GetSumBetweenDate("dossier", "nbConteneur", "2016-" + (i + 1) + "-01",
					"2016-" + (i + 1) + "-31");

		for (int i = 0; i < TC_Mois_2015.length; i++)
			TC_Mois_2015[i] = Utile.GetSumBetweenDate("dossier", "nbConteneur", "2015-" + (i + 1) + "-01",
					"2015-" + (i + 1) + "-31");

		for (int i = 0; i < CA_Mois_2017.length; i++)
			CA_Mois_2017[i] = Utile.GetSumFactureBetweenDate("facture", "TTC", "2017-" + (i + 1) + "-01",
					"2017-" + (i + 1) + "-31");

		for (int i = 0; i < CA_Mois_2016.length; i++)
			CA_Mois_2016[i] = Utile.GetSumFactureBetweenDate("facture", "TTC", "2016-" + (i + 1) + "-01",
					"2016-" + (i + 1) + "-31");

		for (int i = 0; i < CA_Mois_2015.length; i++)
			CA_Mois_2015[i] = Utile.GetSumFactureBetweenDate("facture", "TTC", "2015-" + (i + 1) + "-01",
					"2015-" + (i + 1) + "-31");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		setSize(screenSize.width, screenSize.height - taskBarSize);
		setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());
		setContentPane(contentPane);

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

		JLabel LabelNbDossier = new JLabel("50");
		LabelNbDossier.setFont(new Font("Agency FB", Font.BOLD, 29));
		LabelNbDossier.setForeground(java.awt.Color.WHITE);
		LabelNbDossier.setBounds(183, 259, 48, 56);
		contentPane.add(LabelNbDossier);

		JLabel LabelFact = new JLabel("50");
		LabelFact.setForeground(Color.WHITE);
		LabelFact.setFont(new Font("Agency FB", Font.BOLD, 29));
		LabelFact.setBounds(183, 588, 48, 56);
		contentPane.add(LabelFact);

		JLabel LabelNbClient = new JLabel("50");
		LabelNbClient.setForeground(Color.WHITE);
		LabelNbClient.setFont(new Font("Agency FB", Font.BOLD, 29));
		LabelNbClient.setBounds(186, 151, 48, 56);
		contentPane.add(LabelNbClient);
		contentPane.add(Returne);

		contentPane.setLayout(null);

		Menu menu = new Menu();
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1366, 111);
		panel_1 = menu.getPanel();
		contentPane.add(panel_1);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setForeground(SystemColor.inactiveCaptionText);
		tabbedPane_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		tabbedPane_1.setBounds(307, 132, 1004, 534);
		contentPane.add(tabbedPane_1);

		//-------------------- Debut Bilan ------------------------------------//

				JPanel PanBilan = new JPanel();
				tabbedPane_1.addTab("Bilan entre deux dates", null, PanBilan, null);
				PanBilan.setLayout(null);

				Calendar c = Calendar.getInstance();
				c.add(Calendar.YEAR, 0);
				JDateChooser dateA = new JDateChooser(c.getTime());
				dateA.setBounds(359, 47, 153, 28);
				PanBilan.add(dateA);

				JLabel lblDateDebut = new JLabel("Du  :");
				lblDateDebut.setFont(new Font("Tahoma", Font.BOLD, 17));
				lblDateDebut.setBounds(302, 47, 57, 28);
				PanBilan.add(lblDateDebut);

				JLabel lblAu = new JLabel("\u00E0 :");
				lblAu.setFont(new Font("Tahoma", Font.BOLD, 17));
				lblAu.setBounds(549, 47, 36, 28);
				PanBilan.add(lblAu);

				Calendar cc = Calendar.getInstance();
				cc.add(Calendar.YEAR, 0);

				JDateChooser dateB = new JDateChooser(cc.getTime());
				dateB.setBounds(582, 47, 153, 28);
				PanBilan.add(dateB);

				JButton AfficherBilanBtn = new JButton("");
				AfficherBilanBtn.setRolloverIcon(new ImageIcon(Statistique_View.class.getResource("/img/afficher_ap.png")));
				AfficherBilanBtn.setFocusable(false);
				AfficherBilanBtn.setContentAreaFilled(false);
				AfficherBilanBtn.setBorder(null);
				AfficherBilanBtn.setIcon(new ImageIcon(Statistique_View.class.getResource("/img/afficher.png")));
				AfficherBilanBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String Date1 = Utile.dateFormat2.format(dateA.getDate().getTime());
							String Date2 = Utile.dateFormat2.format(dateB.getDate().getTime());
							Bilan(Date1, Date2);

						} catch (Exception e1) {
							Msg.Afficher("Vous devez choisir date valide", Msg.IconExclam, false);
							Utile.Wait(2);
							Msg.CloseMsg();
						}

					}
				});
				AfficherBilanBtn.setBounds(487, 105, 110, 31);
				PanBilan.add(AfficherBilanBtn);

				JLabel lblNombreDeConteneurs = new JLabel("Nombre de Conteneurs Legale : ");
				lblNombreDeConteneurs.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblNombreDeConteneurs.setForeground(new Color(0, 51, 102));
				lblNombreDeConteneurs.setBounds(40, 368, 259, 14);
				PanBilan.add(lblNombreDeConteneurs);

				JLabel lblNombreDeDossiers = new JLabel("Nombre de Dossiers : ");
				lblNombreDeDossiers.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblNombreDeDossiers.setForeground(new Color(0, 51, 102));
				lblNombreDeDossiers.setBounds(114, 242, 176, 14);
				PanBilan.add(lblNombreDeDossiers);

				JLabel lblChifreDaffaire = new JLabel("Chifre d'affaire :");
				lblChifreDaffaire.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblChifreDaffaire.setForeground(new Color(0, 51, 102));
				lblChifreDaffaire.setBounds(153, 201, 136, 14);
				PanBilan.add(lblChifreDaffaire);

				LabelCADate = new JLabel("5000000.00");
				LabelCADate.setFont(new Font("Tahoma", Font.BOLD, 23));
				LabelCADate.setForeground(new Color(153, 0, 0));
				LabelCADate.setBounds(284, 197, 217, 19);
				PanBilan.add(LabelCADate);

				LabelNbDossierDate = new JLabel("");
				LabelNbDossierDate.setForeground(new Color(153, 0, 0));
				LabelNbDossierDate.setFont(new Font("Tahoma", Font.BOLD, 23));
				LabelNbDossierDate.setBounds(300, 238, 49, 19);
				PanBilan.add(LabelNbDossierDate);

				LabelNbLegaleDate = new JLabel("");
				LabelNbLegaleDate.setForeground(new Color(153, 0, 0));
				LabelNbLegaleDate.setFont(new Font("Tahoma", Font.BOLD, 23));
				LabelNbLegaleDate.setBounds(297, 364, 49, 19);
				PanBilan.add(LabelNbLegaleDate);

				JLabel lblNombreDeConteneurs_1 = new JLabel("Nombre de Conteneurs Fraude : ");
				lblNombreDeConteneurs_1.setForeground(new Color(0, 51, 102));
				lblNombreDeConteneurs_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblNombreDeConteneurs_1.setBounds(40, 326, 259, 14);
				PanBilan.add(lblNombreDeConteneurs_1);

				LabelNbFraudeDate = new JLabel("");
				LabelNbFraudeDate.setForeground(new Color(153, 0, 0));
				LabelNbFraudeDate.setFont(new Font("Tahoma", Font.BOLD, 23));
				LabelNbFraudeDate.setBounds(297, 322, 49, 19);
				PanBilan.add(LabelNbFraudeDate);

				JLabel label_11 = new JLabel("Nombre de Conteneurs : ");
				label_11.setForeground(new Color(0, 51, 102));
				label_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
				label_11.setBounds(87, 286, 200, 14);
				PanBilan.add(label_11);

				LabelNbTcDate = new JLabel("");
				LabelNbTcDate.setForeground(new Color(153, 0, 0));
				LabelNbTcDate.setFont(new Font("Tahoma", Font.BOLD, 23));
				LabelNbTcDate.setBounds(297, 282, 49, 19);
				PanBilan.add(LabelNbTcDate);

				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(Statistique_View.class.getResource("/img/Bilan.png")));
				lblNewLabel.setBounds(530, 168, 383, 283);
				PanBilan.add(lblNewLabel);

		//-------------------- Fin Bilan ------------------------------------//

		JPanel PanChAff = new JPanel();
		tabbedPane_1.addTab("Chiffre Affaire Annuel", null, PanChAff, null);
		gfxChifrePane = new JPanel();

		radio2015 = new JRadioButton("2015");
		radio2015.setFont(new Font("Tahoma", Font.BOLD, 15));
		radio2015.setFocusable(false);
		radio2015.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radio2015.isSelected())
					LineChart15(CA_Mois_2015);
			}
		});
		radio2015.setContentAreaFilled(false);
		buttonGroup.add(radio2015);

		radio2016 = new JRadioButton("2016");
		radio2016.setFont(new Font("Tahoma", Font.BOLD, 15));
		radio2016.setFocusable(false);
		radio2016.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radio2016.isSelected())
					LineChart16(CA_Mois_2016);

			}
		});
		radio2016.setContentAreaFilled(false);
		buttonGroup.add(radio2016);

		radio2017 = new JRadioButton("2017");
		radio2017.setSelected(true);
		radio2017.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radio2017.isSelected())
					LineChart17(CA_Mois_2017);

			}
		});
		radio2017.setFont(new Font("Tahoma", Font.BOLD, 15));
		radio2017.setFocusable(false);
		radio2017.setFocusPainted(false);
		radio2017.setContentAreaFilled(false);
		buttonGroup.add(radio2017);

		GroupLayout gl_PanChAff = new GroupLayout(PanChAff);
		gl_PanChAff.setHorizontalGroup(gl_PanChAff.createParallelGroup(
				Alignment.LEADING).addGroup(gl_PanChAff.createSequentialGroup().addGap(22).addGroup(gl_PanChAff
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_PanChAff.createSequentialGroup()
								.addComponent(radio2015, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio2016, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radio2017, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(gfxChifrePane, GroupLayout.PREFERRED_SIZE, 950, GroupLayout.PREFERRED_SIZE))));
		gl_PanChAff.setVerticalGroup(gl_PanChAff.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PanChAff.createSequentialGroup().addGap(20)
						.addGroup(gl_PanChAff.createParallelGroup(Alignment.LEADING).addComponent(radio2017)
								.addComponent(radio2015).addComponent(radio2016))
						.addGap(19)
						.addComponent(gfxChifrePane, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)));
		PanChAff.setLayout(gl_PanChAff);


		JPanel PanMeilleurClient = new JPanel();
		tabbedPane_1.addTab("Meilleurs Clients", null, PanMeilleurClient, null);
		PanMeilleurClient.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 979, 423);
		PanMeilleurClient.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		Utile.UpdateTable(Utile.BestClient_sql, table);

		JLabel lblListeDesMeilleurs = new JLabel("Liste des Meilleurs Clients ");
		lblListeDesMeilleurs.setForeground(Color.DARK_GRAY);
		lblListeDesMeilleurs.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblListeDesMeilleurs.setBounds(298, 11, 416, 59);
		PanMeilleurClient.add(lblListeDesMeilleurs);

		JPanel PanFraudLegal = new JPanel();
		tabbedPane_1.addTab("Fraude/Legale", null, PanFraudLegal, null);

		JPanel PanFraudClient = new JPanel();
		tabbedPane_1.addTab("Fraud par Client", null, PanFraudClient, null);
		PanFraudClient.setLayout(null);
		PanFraudLegal.setLayout(null);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 81, 979, 409);
		PanFraudClient.add(scrollPane2);

		table2 = new JTable();
		scrollPane2.setViewportView(table2);
		Utile.UpdateTable(Utile.FraudClient_sql, table2);

		JLabel lblListeDesClients = new JLabel("Liste des Clients Fraud\u00E9");
		lblListeDesClients.setForeground(Color.DARK_GRAY);
		lblListeDesClients.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblListeDesClients.setBounds(301, 11, 416, 59);
		PanFraudClient.add(lblListeDesClients);

		gfxFraudLegal = new JPanel();
		gfxFraudLegal.setBounds(73, 11, 853, 463);
		PanFraudLegal.add(gfxFraudLegal);

		JPanel PanConteneur = new JPanel();
		tabbedPane_1.addTab("Conteneurs", null, PanConteneur, null);
		PanConteneur.setLayout(null);
		gfxConteneur = new JPanel();
		gfxConteneur.setBounds(43, 49, 903, 428);
		PanConteneur.add(gfxConteneur);

		RadioConteneur17 = new JRadioButton("2017");
		buttonGroup_1.add(RadioConteneur17);
		RadioConteneur17.setSelected(true);
		RadioConteneur17.setFont(new Font("Tahoma", Font.BOLD, 15));
		RadioConteneur17.setFocusable(false);
		RadioConteneur17.addActionListener(e -> ConteneurRadio());

		RadioConteneur17.setFocusPainted(false);
		RadioConteneur17.setContentAreaFilled(false);
		RadioConteneur17.setBounds(198, 7, 92, 27);
		PanConteneur.add(RadioConteneur17);

		RadioConteneur16 = new JRadioButton("2016");
		buttonGroup_1.add(RadioConteneur16);
		RadioConteneur16.setFont(new Font("Tahoma", Font.BOLD, 15));
		RadioConteneur16.setFocusable(false);
		RadioConteneur16.addActionListener(e -> ConteneurRadio());

		RadioConteneur16.setContentAreaFilled(false);
		RadioConteneur16.setBounds(118, 7, 80, 27);
		PanConteneur.add(RadioConteneur16);

		RadioConteneur15 = new JRadioButton("2015");
		buttonGroup_1.add(RadioConteneur15);
		RadioConteneur15.setFont(new Font("Tahoma", Font.BOLD, 15));
		RadioConteneur15.setFocusable(false);
		RadioConteneur15.addActionListener(e -> ConteneurRadio());

		RadioConteneur15.setContentAreaFilled(false);
		RadioConteneur15.setBounds(41, 7, 77, 27);
		PanConteneur.add(RadioConteneur15);

		JLabel LabelNbCount = new JLabel("50");
		LabelNbCount.setForeground(Color.WHITE);
		LabelNbCount.setFont(new Font("Agency FB", Font.BOLD, 29));
		LabelNbCount.setBounds(183, 375, 48, 56);
		contentPane.add(LabelNbCount);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Statistique_View.class.getResource("/img/StatClients.png")));
		label_2.setBounds(65, 122, 200, 89);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Statistique_View.class.getResource("/img/Stat_Dossier.png")));
		label_3.setBounds(65, 230, 200, 89);
		contentPane.add(label_3);

		JLabel LabelChifreAf = new JLabel("50");
		LabelChifreAf.setHorizontalAlignment(SwingConstants.CENTER);
		LabelChifreAf.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelChifreAf.setForeground(Color.WHITE);
		LabelChifreAf.setFont(new Font("Agency FB", Font.BOLD, 20));
		LabelChifreAf.setBounds(141, 487, 113, 56);
		contentPane.add(LabelChifreAf);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Statistique_View.class.getResource("/img/Stat_Fact.png")));
		label_4.setBounds(65, 559, 200, 89);
		contentPane.add(label_4);

		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Statistique_View.class.getResource("/img/Stat_Conteneur.png")));
		label_8.setBounds(65, 342, 200, 89);
		contentPane.add(label_8);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Statistique_View.class.getResource("/img/StatChifire.png")));
		label_5.setBounds(65, 454, 200, 89);
		contentPane.add(label_5);

		/// Initialisation ////
		try {
			//BarChart();
			PieChart();
			LineChart17(CA_Mois_2017);
			BarChartConteneur(TC_Mois_2017);
		} catch (Exception e) {

		}

		LabelNbClient.setText(String.valueOf(NbClient));
		LabelNbDossier.setText(String.valueOf(NbDossier));
		LabelChifreAf.setText(String.valueOf(ChifreAffaire) + ",00 Da");
		LabelNbCount.setText(String.valueOf(NbConteneur));
		LabelFact.setText(String.valueOf(Utile.GetNbFactureNonRegle()));

		// ////////////////////////// Debut Wallpaper /////////////////////////
		JLabel Wall = new JLabel("");
		Wall.setInheritsPopupMenu(false);
		Wall.setIcon(new ImageIcon(Login_Viex.class.getResource("/img/wall.jpg")));
		Wall.setSize(screenSize.width, screenSize.height - taskBarSize);
		contentPane.add(Wall);
	}

	// -------------------------- Les methodes --------------------------//

	public void Bilan(String date1, String date2) {
		LabelCADate.setText(String.valueOf(Utile.GetSumTable("facture", "ttc", date1, date2) + ",00 Da"));
		LabelNbFraudeDate.setText(String.valueOf(Utile.GetCountLegalFraudDate("FRAUDE", date1, date2)));
		LabelNbLegaleDate.setText(String.valueOf(Utile.GetCountLegalFraudDate("LEGALE", date1, date2)));
		LabelNbTcDate.setText(String.valueOf(Utile.GetSumBetweenDate("dossier", "nbConteneur", date1, date2)));
		LabelNbDossierDate.setText(String.valueOf(Utile.GetCountDossierDate(date1, date2)));
	}
	// -----------------------------------------------------//

	public void ConteneurRadio() {
		try {
			if (RadioConteneur15.isSelected())
				BarChartConteneur(TC_Mois_2015);
			else if (RadioConteneur16.isSelected())
				BarChartConteneur(TC_Mois_2016);
			else if (RadioConteneur17.isSelected())
				BarChartConteneur(TC_Mois_2017);

		} catch (Exception e) {
		}
	}
	// -----------------------------------------------------//

	public void PieChart() {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("FRAUDE", (NbFraude * 100) / (NbFraude + NbLegale));
		pieDataset.setValue("LEGALE", (NbLegale * 100) / (NbFraude + NbLegale));
		JFreeChart chart = ChartFactory.createPieChart("Poucentage de Fraude/Legale", pieDataset, true, true, true);
		gfxFraudLegal.setLayout(new java.awt.BorderLayout());
		ChartPanel CP = new ChartPanel(chart);
		gfxFraudLegal.add(CP, BorderLayout.CENTER);
		gfxFraudLegal.validate();

	}
	// -----------------------------------------------------//

	public void BarChartConteneur(int[] Data) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(Data[0], "Nombres", "JAN");
		dataset.setValue(Data[1], "Nombres", "FEV");
		dataset.setValue(Data[2], "Nombres", "MAR");
		dataset.setValue(Data[3], "Nombres", "AVR");
		dataset.setValue(Data[4], "Nombres", "MAI");
		dataset.setValue(Data[5], "Nombres", "JUIN");
		dataset.setValue(Data[6], "Nombres", "JUILLET");
		dataset.setValue(Data[7], "Nombres", "AOT");
		dataset.setValue(Data[8], "Nombres", "SEPT");
		dataset.setValue(Data[9], "Nombres", "OCT");
		dataset.setValue(Data[10], "Nombres", "NOV");
		dataset.setValue(Data[11], "Nombres", "DEC");

		GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.cyan, 0.0f, 0.0f, new Color(0, 40, 70));

		JFreeChart chart = ChartFactory.createBarChart("Nombres de Conteneur par Mois ", "Mois", "Nombres ", dataset,
				PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot p = chart.getCategoryPlot();
		BarRenderer renderer = (BarRenderer) p.getRenderer();

		for (int s = 0; s < 12; s++) {
			renderer.setSeriesPaint(s, gp0);
		}

		CategoryAxis xAxis = (CategoryAxis) p.getDomainAxis();
		xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		p.setRangeGridlinePaint(Color.black);
		gfxConteneur.setLayout(new java.awt.BorderLayout());
		ChartPanel CP = new ChartPanel(chart);
		CP.setRequestFocusEnabled(false);
		CP.setMouseWheelEnabled(true);
		gfxConteneur.add(CP, BorderLayout.CENTER);
		gfxConteneur.validate();
	}
	// -----------------------------------------------------//

	public void LineChart15(int[] Data) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(Data[0], "Dinars", "JAN");
		dataset.setValue(Data[1], "Dinars", "FEV");
		dataset.setValue(Data[2], "Dinars", "MAR");
		dataset.setValue(Data[3], "Dinars", "AVR");
		dataset.setValue(Data[4], "Dinars", "MAI");
		dataset.setValue(Data[5], "Dinars", "JUIN");
		dataset.setValue(Data[6], "Dinars", "JUILLET");
		dataset.setValue(Data[7], "Dinars", "AOT");
		dataset.setValue(Data[8], "Dinars", "SEPT");
		dataset.setValue(Data[9], "Dinars", "OCT");
		dataset.setValue(Data[10], "Dinars", "NOV");
		dataset.setValue(Data[11], "Dinars", "DEC");
		JFreeChart chart = ChartFactory.createLineChart3D("Chifre d'Affaire de Societé", "Mois", "Dinars ", dataset,
				PlotOrientation.VERTICAL, false, true, false);

		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeGridlinePaint(Color.black);
		gfxChifrePane.setLayout(new java.awt.BorderLayout());
		ChartPanel CP = new ChartPanel(chart);
		gfxChifrePane.add(CP);
		gfxChifrePane.validate();
	}

	// -----------------------------------------------------//

	public void LineChart16(int[] Data) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(Data[0], "Dinars", "JAN");
		dataset.setValue(Data[1], "Dinars", "FEV");
		dataset.setValue(Data[2], "Dinars", "MAR");
		dataset.setValue(Data[3], "Dinars", "AVR");
		dataset.setValue(Data[4], "Dinars", "MAI");
		dataset.setValue(Data[5], "Dinars", "JUIN");
		dataset.setValue(Data[6], "Dinars", "JUILLET");
		dataset.setValue(Data[7], "Dinars", "AOT");
		dataset.setValue(Data[8], "Dinars", "SEPT");
		dataset.setValue(Data[9], "Dinars", "OCT");
		dataset.setValue(Data[10], "Dinars", "NOV");
		dataset.setValue(Data[11], "Dinars", "DEC");
		JFreeChart chart = ChartFactory.createLineChart3D("Chifre d'Affaire de Societé", "Mois", "Dinars ", dataset,
				PlotOrientation.VERTICAL, false, true, false);

		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeGridlinePaint(Color.black);
		gfxChifrePane.setLayout(new java.awt.BorderLayout());
		ChartPanel CP = new ChartPanel(chart);
		gfxChifrePane.add(CP);
		gfxChifrePane.validate();
	}

	public void LineChart17(int[] Data) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(Data[0], "Dinars", "JAN");
		dataset.setValue(Data[1], "Dinars", "FEV");
		dataset.setValue(Data[2], "Dinars", "MAR");
		dataset.setValue(Data[3], "Dinars", "AVR");
		dataset.setValue(Data[4], "Dinars", "MAI");
		dataset.setValue(Data[5], "Dinars", "JUIN");
		dataset.setValue(Data[6], "Dinars", "JUILLET");
		dataset.setValue(Data[7], "Dinars", "AOT");
		dataset.setValue(Data[8], "Dinars", "SEPT");
		dataset.setValue(Data[9], "Dinars", "OCT");
		dataset.setValue(Data[10], "Dinars", "NOV");
		dataset.setValue(Data[11], "Dinars", "DEC");
		JFreeChart chart = ChartFactory.createLineChart3D("Chifre d'Affaire de Societé", "Mois", "Dinars ", dataset,
				PlotOrientation.VERTICAL, false, true, false);

		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeGridlinePaint(Color.black);
		gfxChifrePane.setLayout(new java.awt.BorderLayout());
		ChartPanel CP = new ChartPanel(chart);
		gfxChifrePane.add(CP);
		gfxChifrePane.validate();
	}

	// -----------------------------------------------------//

	public JButton getReturne() {
		return Returne;
	}

}