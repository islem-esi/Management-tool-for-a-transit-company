package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import controllers.Client_Ctrl;
import controllers.Dossier_Ctrl;
import controllers.Login_Ctrl;
import controllers.Parametre_Ctrl;
import controllers.Statistique_Ctrl;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	// ------------------- Les déclarations  -----------------------//
	private static final long serialVersionUID = 1L;
	static public JPanel contentPane;
	public JPanel contentPane2;
	private JButton dossier;

	// -------------------------- Le constructeur --------------------------//

	public Menu() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 111);

		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 1366, 111);
		contentPane.setVerifyInputWhenFocusTarget(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		dossier = new JButton("");
		dossier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Dossier_Ctrl(View.GetView());
			}
		});
		dossier.setIcon(new ImageIcon(Menu.class.getResource("/img/m_dossier_av.png")));
		dossier.setRolloverIcon(new ImageIcon(Menu.class.getResource("/img/m_dossier_ap.png")));

		dossier.setContentAreaFilled(false);
		dossier.setBorderPainted(false);
		dossier.setBounds(447, 0, 105, 105);
		contentPane.add(dossier);

		JButton client = new JButton("");
		client.setRolloverIcon(new ImageIcon(Menu.class.getResource("/img/m_client_ap.png")));
		client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Client_Ctrl(View.GetView());
			}
		});
		client.setIcon(new ImageIcon(Menu.class.getResource("/img/m_client_av.png")));
		client.setContentAreaFilled(false);
		client.setBorderPainted(false);
		client.setBounds(313, 0, 105, 105);
		contentPane.add(client);

		JButton parametre = new JButton("");
		parametre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Parametre_Ctrl(View.GetView());
			}
		});
		parametre.setIcon(new ImageIcon(Menu.class.getResource("/img/m_param_av.png")));
		parametre.setRolloverIcon(new ImageIcon(Menu.class.getResource("/img/m_param_ap.png")));

		parametre.setContentAreaFilled(false);
		parametre.setBorderPainted(false);
		parametre.setBounds(579, 0, 105, 105);
		contentPane.add(parametre);

		JButton statistique = new JButton("");
		statistique.setIcon(new ImageIcon(Menu.class.getResource("/img/m_stat_av.png")));
		statistique.setRolloverIcon(new ImageIcon(Menu.class.getResource("/img/m_stat_ap.png")));

		statistique.setContentAreaFilled(false);
		statistique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Statistique_Ctrl(View.GetView());
			}
		});

		statistique.setBorderPainted(false);
		statistique.setBounds(705, 0, 105, 105);
		contentPane.add(statistique);

		JButton aide = new JButton("");
		aide.setIcon(new ImageIcon(Menu.class.getResource("/img/m_aide_av.png")));
		aide.setRolloverIcon(new ImageIcon(Menu.class.getResource("/img/m_aide_ap.png")));
		aide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Runtime.getRuntime().exec("hh.exe aide/Gestion_de_facturation.chm");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		aide.setContentAreaFilled(false);
		aide.setBorderPainted(false);
		aide.setBounds(840, 1, 117, 104);
		contentPane.add(aide);

		JButton exit = new JButton("");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Login_Ctrl(View.GetView());
			}
		});
		exit.setIcon(new ImageIcon(Menu.class.getResource("/img/m_exit_av.png")));
		exit.setRolloverIcon(new ImageIcon(Menu.class.getResource("/img/m_exit_ap.png")));

		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setBounds(957, 0, 105, 105);
		contentPane.add(exit);

		if (Login_Ctrl.IdUser != 1) {
			statistique.setVisible(false);
			parametre.setBounds(629, 0, 105, 105);
			dossier.setBounds(503, 0, 105, 105);
			client.setBounds(369, 0, 105, 105);
			aide.setBounds(750, 1, 117, 104);
			exit.setBounds(867, 0, 105, 105);
		} else {
		}

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/img/bar.png")));
		lblNewLabel.setBounds(0, 0, 1366, 111);
		contentPane.add(lblNewLabel);
		contentPane2 = new JPanel();
		contentPane2.setBounds(0, 0, 1366, 111);
		contentPane2.setVerifyInputWhenFocusTarget(false);
		contentPane2.setLayout(null);
		JLabel lblNewLabel2 = new JLabel("");
		lblNewLabel2.setIcon(new ImageIcon(Menu.class.getResource("/img/bar.png")));
		lblNewLabel2.setBounds(0, 0, 1366, 111);
		contentPane2.add(lblNewLabel2);

	}

	// ----------------------- Les getters & setters ------------------------//

	public JPanel getPanel() {
		return contentPane;
	}

	public void setPanel2() {
		setContentPane(null);
		this.setContentPane(contentPane2);
	}

}
