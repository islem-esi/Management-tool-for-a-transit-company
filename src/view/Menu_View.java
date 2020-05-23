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
import model.entity.Designation;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Menu_View extends JFrame {
	// ------------------- Les déclarations  -----------------------//

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton Client_btn;
	private JButton Aide_btn;
	private JButton Param_btn;
	private JButton Dossier_btn;
	private JButton Decon_btn;
	private JButton Stat_btn;
	private JLabel lblNewLabel;
	public JButton btnDtails;
	public JLabel attention;
	public JLabel lblIlExisteDes;

	// -------------------------- Le constructeur --------------------------//
	public Menu_View() {
		contentPane = new JPanel();

		setTitle("Gestion Facturation");
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

		contentPane.setLayout(null);

		Client_btn = new JButton("");
		Client_btn.setRolloverIcon(new ImageIcon(Menu_View.class.getResource("/img/MenuClient_ap.png")));
		Client_btn.setBorder(null);
		Client_btn.setContentAreaFilled(false);
		Client_btn.setFocusable(false);

		Client_btn.setIcon(new ImageIcon(Menu_View.class.getResource("/img/MenuClient.png")));
		Client_btn.setBounds(340, 194, 190, 190);
		contentPane.add(Client_btn);

		Aide_btn = new JButton("");
		Aide_btn.setRolloverIcon(new ImageIcon(Menu_View.class.getResource("/img/MenuAide_ap.png")));
		Aide_btn.setBorder(null);
		Aide_btn.setContentAreaFilled(false);
		Aide_btn.setFocusable(false);
		Aide_btn.setIcon(new ImageIcon(Menu_View.class.getResource("/img/MenuAide.png")));
		Aide_btn.setBounds(340, 427, 190, 190);
		contentPane.add(Aide_btn);

		Param_btn = new JButton("");
		Param_btn.setRolloverIcon(new ImageIcon(Menu_View.class.getResource("/img/MenuParam_ap.png")));
		Param_btn.setBorder(null);
		Param_btn.setContentAreaFilled(false);
		Param_btn.setFocusable(false);
		Param_btn.setIcon(new ImageIcon(Menu_View.class.getResource("/img/MenuParam.png")));
		Param_btn.setBounds(593, 427, 190, 190);
		contentPane.add(Param_btn);

		Decon_btn = new JButton("");
		Decon_btn.setRolloverIcon(new ImageIcon(Menu_View.class.getResource("/img/MenuDecon_ap.png")));
		Decon_btn.setBorder(null);
		Decon_btn.setContentAreaFilled(false);
		Decon_btn.setFocusable(false);
		Decon_btn.setIcon(new ImageIcon(Menu_View.class.getResource("/img/MenuDecon.png")));
		Decon_btn.setBounds(845, 427, 190, 190);
		contentPane.add(Decon_btn);

		Stat_btn = new JButton("");
		Stat_btn.setRolloverIcon(new ImageIcon(Menu_View.class.getResource("/img/MenuStat_ap.png")));
		Stat_btn.setBorder(null);
		Stat_btn.setContentAreaFilled(false);
		Stat_btn.setFocusable(false);
		Stat_btn.setIcon(new ImageIcon(Menu_View.class.getResource("/img/MenuStat.png")));
		Stat_btn.setBounds(845, 194, 190, 190);
		contentPane.add(Stat_btn);

		Dossier_btn = new JButton("");
		Dossier_btn.setRolloverIcon(new ImageIcon(Menu_View.class.getResource("/img/MenuDossier_ap.png")));
		Dossier_btn.setBorder(null);
		Dossier_btn.setContentAreaFilled(false);
		Dossier_btn.setFocusable(false);
		Dossier_btn.setIcon(new ImageIcon(Menu_View.class.getResource("/img/MenuDossier.png")));
		Dossier_btn.setBounds(593, 194, 190, 190);
		contentPane.add(Dossier_btn);

		if (Login_Ctrl.IdUser != 1) {
			Stat_btn.setVisible(false);
			Dossier_btn.setBounds(661, 171, 190, 190);
			Decon_btn.setBounds(767, 401, 190, 190);
			Param_btn.setBounds(539, 401, 190, 190);
			Aide_btn.setBounds(310, 401, 190, 190);
			Client_btn.setBounds(431, 171, 190, 190);

		}

		// ////////////////////////// Debut Wallpaper /////////////////////////
		JLabel Wall = new JLabel("");
		Wall.setInheritsPopupMenu(false);
		Wall.setIcon(new ImageIcon(Login_Viex.class.getResource("/img/wall.jpg")));
		Wall.setSize(screenSize.width, screenSize.height - taskBarSize);
		setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());

		lblIlExisteDes = new JLabel("    il existe des modifications apport\u00E9es sur les d\u00E9signarions ");
		lblIlExisteDes.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIlExisteDes.setForeground(Color.RED);
		lblIlExisteDes.setBounds(384, 655, 544, 22);
		// contentPane.add(lblIlExisteDes);
		btnDtails = new JButton("");
		btnDtails.setRolloverIcon(new ImageIcon(Menu_View.class.getResource("/img/historique_ap.png")));
		btnDtails.setFocusable(false);
		btnDtails.setContentAreaFilled(false);
		btnDtails.setBorderPainted(false);
		btnDtails.setBorder(null);
		btnDtails.setIcon(new ImageIcon(Menu_View.class.getResource("/img/historique.png")));
		btnDtails.setBounds(903, 628, 65, 65);

		attention = new JLabel("");
		attention.setIcon(new ImageIcon(Menu_View.class.getResource("/img/gif/attention2.gif")));
		attention.setBounds(345, 641, 50, 44);

		if (Login_Ctrl.IdUser == 1) {

			 if (Designation.modifExiste()){
				 contentPane.add(btnDtails);
			     contentPane.add(lblIlExisteDes);
				 contentPane.add(attention);
			 }
		}

		lblNewLabel = new JLabel("Accueil ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("MahmoudArt", Font.BOLD, 98));
		lblNewLabel.setForeground(Utile.myBlue);
		lblNewLabel.setBounds(412, 58, 562, 125);
		contentPane.add(lblNewLabel);

		contentPane.add(Wall);
		// ////////////////////////// Fin Wallpaper /////////////////////////
	}

	// ----------------------- Les getters & setters ------------------------//
	public JButton getClient_btn() {
		return Client_btn;
	}

	public void setClient_btn(JButton client_btn) {
		Client_btn = client_btn;
	}

	public JButton getAide_btn() {
		return Aide_btn;
	}

	public void setAide_btn(JButton aide_btn) {
		Aide_btn = aide_btn;
	}

	public JButton getParam_btn() {
		return Param_btn;
	}

	public JButton getDossier_btn() {
		return Dossier_btn;
	}

	public void setDossier_btn(JButton dossier_btn) {
		Dossier_btn = dossier_btn;
	}

	public JButton getDecon_btn() {

		return Decon_btn;
	}

	public void setDecon_btn(JButton decon_btn) {
		Decon_btn = decon_btn;
	}

	public JButton getStat_btn() {
		return Stat_btn;
	}

	public void setStat_btn(JButton stat_btn) {
		Stat_btn = stat_btn;
	}

	public JButton getBtnDtails() {
		return btnDtails;
	}

	public void setBtnDtails(JButton btnDtails) {
		this.btnDtails = btnDtails;
	}
}