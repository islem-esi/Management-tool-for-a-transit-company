package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import model.ConfigSQL;
import model.DBHelper;
import model.Utile;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Configuration_View extends JFrame {

	// ------------------- Les déclarations  -----------------------//

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JFrame frmConfiguration;
	private JButton btnConfiguration;
	private static JTextField field_user;
	private static JTextField field_dbName;
	private static JTextField filed_host;
	private static JPasswordField field_pass;

	// -------------------------- Le constructeur --------------------------//

	public Configuration_View() {

		frmConfiguration = new JFrame();
		frmConfiguration.setAlwaysOnTop(true);
		frmConfiguration.setTitle("Configuration");
		frmConfiguration.setResizable(false);
		frmConfiguration.setBounds(0, 0, 380, 263);
		frmConfiguration.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frmConfiguration.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(533, 543, 300, 135);
		frmConfiguration.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblUtilisateur = new JLabel("Utilisateur : ");
		lblUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUtilisateur.setBounds(35, 27, 145, 14);
		lblUtilisateur.setForeground(Utile.myBlue);
		frmConfiguration.getContentPane().add(lblUtilisateur);

		JLabel lblMotDePasse = new JLabel("Mot de passe : ");
		lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMotDePasse.setBounds(35, 67, 145, 14);
		lblMotDePasse.setForeground(Utile.myBlue);
		frmConfiguration.getContentPane().add(lblMotDePasse);

		JLabel lblBaseDe = new JLabel("Base de donne\u00E9  : ");
		lblBaseDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBaseDe.setForeground(Utile.myBlue);
		lblBaseDe.setBounds(35, 108, 145, 14);
		frmConfiguration.getContentPane().add(lblBaseDe);

		JLabel lblServer = new JLabel("Serveur  : ");
		lblServer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblServer.setForeground(Utile.myBlue);
		lblServer.setBounds(35, 146, 145, 14);
		frmConfiguration.getContentPane().add(lblServer);

		field_user = new JTextField();
		field_user.setFont(new Font("Tahoma", Font.BOLD, 12));
		field_user.setForeground(Color.DARK_GRAY);
		field_user.setHorizontalAlignment(SwingConstants.CENTER);
		field_user.setText("root");
		field_user.setBounds(172, 25, 141, 20);
		frmConfiguration.getContentPane().add(field_user);
		field_user.setColumns(10);

		field_dbName = new JTextField();
		field_dbName.setText("gestion_facturation");
		field_dbName.setFont(new Font("Tahoma", Font.BOLD, 12));
		field_dbName.setForeground(Color.DARK_GRAY);
		field_dbName.setHorizontalAlignment(SwingConstants.CENTER);
		field_dbName.setBounds(172, 106, 141, 20);
		frmConfiguration.getContentPane().add(field_dbName);
		field_dbName.setColumns(10);

		filed_host = new JTextField();
		filed_host.setText("192.168.1.1");
		filed_host.setFont(new Font("Tahoma", Font.BOLD, 12));
		filed_host.setForeground(Color.DARK_GRAY);
		filed_host.setHorizontalAlignment(SwingConstants.CENTER);
		filed_host.setBounds(172, 145, 141, 20);
		frmConfiguration.getContentPane().add(filed_host);
		filed_host.setColumns(10);

		field_pass = new JPasswordField();
		field_pass.setFont(new Font("Tahoma", Font.BOLD, 12));
		field_pass.setForeground(Color.DARK_GRAY);
		field_pass.setHorizontalAlignment(SwingConstants.CENTER);
		field_pass.setBounds(172, 65, 141, 20);
		frmConfiguration.getContentPane().add(field_pass);

		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetDbInfo();
				ConfigSQL.SaveConfiguration();
				ConfigSQL.LoadConfiguration();
				frmConfiguration.dispose();
				new DBHelper();
			}
		});
		btnValider.setBounds(160, 189, 89, 23);
		frmConfiguration.getContentPane().add(btnValider);

		JLabel Wall = new JLabel("");
		Wall.setIcon(new ImageIcon(Configuration_View.class.getResource("/img/wall2.png")));
		Wall.setBounds(-31, -279, 950, 1117);
		frmConfiguration.getContentPane().add(Wall);
		frmConfiguration.setVisible(true);

		filed_host.setText(ConfigSQL.getDBHOST());
		field_user.setText(ConfigSQL.getDBUSER());
		field_pass.setText(ConfigSQL.getDBPASS());
		field_dbName.setText(ConfigSQL.getDBNAME());

	}

	// ----------------------- Les getters & setters ------------------------//

	public static ConfigSQL SetDbInfo() {
		return new ConfigSQL(filed_host.getText(), field_user.getText(), field_pass.getText(), field_dbName.getText());
	}

	public JButton getBtnConfiguration() {
		return btnConfiguration;
	}

}
