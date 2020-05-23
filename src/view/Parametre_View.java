package view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controllers.Login_Ctrl;
import model.Utile;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Parametre_View extends JFrame {

	// ------------------- Les déclarations  -----------------------//

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btn_Info;
	private JButton btn_Chauf;
	private JButton btn_Designation;
	private JButton btn_Camion;
	private JButton btn_BDD;
	private JButton btn_Marchandise;
	private JButton btn_Conteneur;
	private JButton btn_Declarant;
	private JButton btn_Users;
	private JButton btn_Historique;
	private JLabel lblParamtre;
	private JButton Returne;

	// -------------------------- Le constructeur --------------------------//
	public Parametre_View() {
		contentPane = new JPanel();

		///////////////////// Ajuster la taille de la fenetre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		setSize(screenSize.width, screenSize.height - taskBarSize);
		setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());
		setContentPane(contentPane);

		///////////////////// Fin Ajuster la taille de la fenetre

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

		// ---------------Menu BAR--------------------//
		Menu menu = new Menu();
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1366, 111);
		panel_1 = menu.getPanel();
		contentPane.add(panel_1);
		// ---------------END Menu BAR--------------------//

		// ///////// Fin Parametre de la fenetre ///////////
		btn_Info = new JButton("");
		btn_Info.setRolloverIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_info_ap.png")));
		btn_Info.setBorder(null);
		btn_Info.setContentAreaFilled(false);
		btn_Info.setFocusable(false);
		btn_Info.setIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_info.png")));
		btn_Info.setBounds(87, 258, 195, 159);
		contentPane.add(btn_Info);
		setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());

		btn_Chauf = new JButton("");
		btn_Chauf.setRolloverIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_chauf_ap.png")));
		btn_Chauf.setBorder(null);
		btn_Chauf.setContentAreaFilled(false);
		btn_Chauf.setFocusable(false);
		btn_Chauf.setIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_chauf.png")));
		btn_Chauf.setBounds(87, 496, 195, 159);
		contentPane.add(btn_Chauf);

		btn_Designation = new JButton("");
		btn_Designation.setRolloverIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_desig_ap.png")));
		btn_Designation.setBorder(null);
		btn_Designation.setContentAreaFilled(false);
		btn_Designation.setFocusable(false);
		btn_Designation.setIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_desig.png")));
		btn_Designation.setBounds(343, 258, 195, 159);
		contentPane.add(btn_Designation);

		btn_Camion = new JButton("");
		btn_Camion.setRolloverIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_camion_ap.png")));
		btn_Camion.setBorder(null);
		btn_Camion.setContentAreaFilled(false);
		btn_Camion.setFocusable(false);
		btn_Camion.setIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_camion.png")));
		btn_Camion.setBounds(343, 496, 195, 159);
		contentPane.add(btn_Camion);

		btn_BDD = new JButton("");
		btn_BDD.setRolloverIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_bdd_ap.png")));
		btn_BDD.setBorder(null);
		btn_BDD.setContentAreaFilled(false);
		btn_BDD.setFocusable(false);
		btn_BDD.setIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_bdd.png")));
		btn_BDD.setBounds(853, 258, 195, 159);
		contentPane.add(btn_BDD);

		btn_Marchandise = new JButton("");
		btn_Marchandise
				.setRolloverIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_Marchandise_ap.png")));
		btn_Marchandise.setBorder(null);
		btn_Marchandise.setContentAreaFilled(false);
		btn_Marchandise.setFocusable(false);
		btn_Marchandise.setIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_Marchandise.png")));
		btn_Marchandise.setBounds(853, 496, 195, 159);
		contentPane.add(btn_Marchandise);

		btn_Conteneur = new JButton("");
		btn_Conteneur.setRolloverIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_conteneur_ap.png")));
		btn_Conteneur.setBorder(null);
		btn_Conteneur.setContentAreaFilled(false);
		btn_Conteneur.setFocusable(false);
		btn_Conteneur.setIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_conteneur.png")));
		btn_Conteneur.setBounds(595, 496, 195, 159);
		contentPane.add(btn_Conteneur);

		btn_Declarant = new JButton("");
		btn_Declarant.setRolloverIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_declarant_ap.png")));
		btn_Declarant.setBorder(null);
		btn_Declarant.setContentAreaFilled(false);
		btn_Declarant.setFocusable(false);
		btn_Declarant.setIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_declarant.png")));
		btn_Declarant.setBounds(595, 258, 195, 159);
		contentPane.add(btn_Declarant);

		btn_Users = new JButton("");
		btn_Users.setRolloverIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_users_ap.png")));
		btn_Users.setBorder(null);
		btn_Users.setContentAreaFilled(false);
		btn_Users.setFocusable(false);
		btn_Users.setIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_users.png")));
		btn_Users.setBounds(1114, 496, 195, 159);
		contentPane.add(btn_Users);

		btn_Historique = new JButton("");
		btn_Historique.setRolloverIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_historique_ap.png")));
		btn_Historique.setBorder(null);
		btn_Historique.setContentAreaFilled(false);
		btn_Historique.setFocusable(false);
		btn_Historique.setIcon(new ImageIcon(Parametre_View.class.getResource("/img/param_historique.png")));
		btn_Historique.setBounds(1114, 258, 195, 159);
		contentPane.add(btn_Historique);

		lblParamtre = new JLabel("Param\u00E9tres");
		lblParamtre.setForeground(Utile.myBlue);
		lblParamtre.setFont(new Font("Impact", Font.PLAIN, 45));
		lblParamtre.setBounds(602, 147, 480, 55);
		contentPane.add(lblParamtre);

		if (Login_Ctrl.IdUser != 1) {
			btn_Info.setBounds(202, 257, 195, 159);
			btn_Historique.setVisible(false);
			btn_Users.setVisible(false);
			btn_Chauf.setBounds(202, 495, 195, 159);
			btn_Designation.setBounds(458, 257, 195, 159);
			btn_Camion.setBounds(458, 495, 195, 159);
			btn_BDD.setBounds(968, 257, 195, 159);
			btn_Marchandise.setBounds(968, 495, 195, 159);
			btn_Conteneur.setBounds(710, 495, 195, 159);
			btn_Declarant.setBounds(710, 257, 195, 159);
			lblParamtre.setBounds(602, 147, 480, 55);
		}

		// ////////////////////////// Debut Wallpaper /////////////////////////
		JLabel Wall = new JLabel("");
		Wall.setInheritsPopupMenu(false);
		Wall.setIcon(new ImageIcon(Login_Viex.class.getResource("/img/wall.jpg")));
		Wall.setSize(screenSize.width, screenSize.height - taskBarSize);
		contentPane.add(Wall);
		contentPane.add(Wall);

	}
	// ----------------------- Les getters & setters ------------------------//

	public JButton getReturne() {
		return Returne;
	}

	public void setReturne(JButton returne) {
		Returne = returne;
	}

	public JButton getBtn_Entreprise() {
		return btn_Info;
	}

	public void setBtn_Entreprise(JButton btn_Entreprise) {
		this.btn_Info = btn_Entreprise;
	}

	public JButton getBtn_Chauf() {
		return btn_Chauf;
	}

	public void setBtn_Chauf(JButton btn_Chauf) {
		this.btn_Chauf = btn_Chauf;
	}

	public JButton getBtn_Designation() {
		return btn_Designation;
	}

	public void setBtn_Designation(JButton btn_Designation) {
		this.btn_Designation = btn_Designation;
	}

	public JButton getBtn_Camion() {
		return btn_Camion;
	}

	public void setBtn_Camion(JButton btn_Camion) {
		this.btn_Camion = btn_Camion;
	}

	public JButton getBtn_Marchandise() {
		return btn_Marchandise;
	}

	public void setBtn_Marchandise(JButton btn_Marchandise) {
		this.btn_Marchandise = btn_Marchandise;
	}

	public JButton getBtn_Conteneur() {
		return btn_Conteneur;
	}

	public void setBtn_Conteneur(JButton btn_Conteneur) {
		this.btn_Conteneur = btn_Conteneur;
	}

	public JButton getBtn_Provenance() {
		return btn_Declarant;
	}

	public void setBtn_Provenance(JButton btn_Provenance) {
		this.btn_Declarant = btn_Provenance;
	}

	public JButton getBtn_Info() {
		return btn_Info;
	}

	public JButton getBtn_Declarant() {
		return btn_Declarant;
	}

	public JButton getBtn_Users() {
		return btn_Users;
	}

	public JButton getBtn_Historique() {
		return btn_Historique;
	}

	public JButton getBtn_BDD() {
		return btn_BDD;
	}

}