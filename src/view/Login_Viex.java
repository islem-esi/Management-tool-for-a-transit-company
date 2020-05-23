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
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;

import model.Utile;
import model.entity.Utilisateur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login_Viex extends JFrame {

	// ------------------- Les déclarations  -----------------------//
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JTextField Username_field;
	private JButton Login_Btn;
	private JPasswordField passwordField;
	private JButton btnConfiguration;
	private JButton button;

	// -------------------------- Le constructeur --------------------------//

	public Login_Viex() {
		contentPane = new JPanel();
		setTitle("Gestion Facturation");
		setFocusTraversalPolicyProvider(true);
		setUndecorated(true);
		setResizable(false);

		///////////////////// Ajuster la taille de la fenetre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		setSize(screenSize.width, screenSize.height - taskBarSize);
		setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());
		setContentPane(contentPane);

		///////////////////// Fin Ajuster la taille de la fenetre

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(null);

		Username_field = new JTextField();
		Username_field.setBorder(null);
		Username_field.setHorizontalAlignment(SwingConstants.CENTER);
		Username_field.setForeground(Utile.myBlue);
		Username_field.setFont(new Font("Serif", Font.BOLD, 16));
		Username_field.setBounds(604, 303, 194, 30);
		contentPane.add(Username_field);

		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setForeground(Utile.myBlue);
		passwordField.setFont(new Font("Serif", Font.BOLD, 16));
		passwordField.setBounds(604, 354, 194, 30);
		contentPane.add(passwordField);

		Login_Btn = new JButton("");
		Login_Btn.setRolloverIcon(new ImageIcon(Login_Viex.class.getResource("/img/login_btn_af.png")));
		Login_Btn.setContentAreaFilled(false);
		Login_Btn.setBorderPainted(false);
		Login_Btn.setIcon(new ImageIcon(Login_Viex.class.getResource("/img/login_btn.png")));
		Login_Btn.setBounds(561, 409, 243, 41);
		contentPane.add(Login_Btn);
		setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());

		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View.fermer();
			}
		});
		button.setRolloverIcon(new ImageIcon(Login_Viex.class.getResource("/img/fermer2_ap.png")));
		button.setIcon(new ImageIcon(Login_Viex.class.getResource("/img/fermer2.png")));
		button.setFocusable(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBounds(642, 489, 92, 32);
		contentPane.add(button);

						btnConfiguration = new JButton("");
						btnConfiguration.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								  if (arg0.getClickCount() == 5) {
										new Configuration_View();
									  }
							}
						});
						btnConfiguration.setFocusable(false);
						btnConfiguration.setDefaultCapable(false);
						btnConfiguration.setBorderPainted(false);
						btnConfiguration.setContentAreaFilled(false);
						btnConfiguration.setRolloverEnabled(false);
						btnConfiguration.setRequestFocusEnabled(false);
						btnConfiguration.setBounds(538, 475, 286, 57);
						contentPane.add(btnConfiguration);

				// ////////////////////////// Debut Wallpaper /////////////////////////
				JLabel Wall = new JLabel("");
				Wall.setFont(new Font("Impact", Font.PLAIN, 18));
				Wall.setInheritsPopupMenu(false);
				Wall.setIcon(new ImageIcon(Login_Viex.class.getResource("/img/Background2.png")));
				Wall.setSize(screenSize.width, screenSize.height - taskBarSize);
				contentPane.add(Wall);
		// ////////////////////////// Fin Wallpaper /////////////////////////

	}

	// -------------------------- Les methodes --------------------------//

	@SuppressWarnings("deprecation")
	public boolean champVide() {
		if (Username_field.getText().equals("") || passwordField.getText().equals(""))
			return true;
		return false;
	}
	// -----------------------------------------------------//
	public void SetChampVide() {
		Username_field.setText("");
		passwordField.setText("");
	}
	// -----------------------------------------------------//
	@SuppressWarnings("deprecation")
	public Utilisateur RecupereInfo() {
		return new Utilisateur(Username_field.getText().toString(), passwordField.getText().toString());
	}
	// -----------------------------------------------------//

	public JTextField getUsername_field() {
		return Username_field;
	}
	// -----------------------------------------------------//

	public void setUsername_field(JTextField username_field) {
		Username_field = username_field;
	}
	// -----------------------------------------------------//

	public JTextField getPassword_field() {
		return passwordField;
	}
	// -----------------------------------------------------//

	public void setPassword_field(JPasswordField password_field) {
		passwordField = password_field;
	}

	// -----------------------------------------------------//
	public JButton getLogin_Btn() {
		return Login_Btn;
	}
	// -----------------------------------------------------//

	public void setLogin_Btn(JButton login_Btn) {
		Login_Btn = login_Btn;
	}
}
