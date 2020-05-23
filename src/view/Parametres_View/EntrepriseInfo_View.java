package view.Parametres_View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Utile;
import model.entity.Info;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class EntrepriseInfo_View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField field_Mobile;
	private JTextField field_adresse;
	private JTextField field_nom;
	public JFrame frame;
	private JTextField field_Email;
	private JTextField field_Rc;
	private JTextField field_Nif;
	private JTextField field_Nis;
	private JTextField field_Capitale;
	private JTextField field_fax;
	private String path_Entete;
	private JButton BtnMisAjour;
	private JLabel LabelEntete;
	public static Info info;

	public EntrepriseInfo_View() {

		frame = new JFrame();
		frame.setBounds(new Rectangle(100, 10, 0, 0));
		frame.setTitle("Info Entreprise");
		frame.setResizable(false);
		frame.setBounds(100, 100, 896, 594);
		frame.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.getContentPane().setLayout(null);

		JLabel lblMobile = new JLabel("Mobile : ");
		lblMobile.setForeground(Utile.myBlue);
		lblMobile.setFont(new Font("Raavi", Font.BOLD, 15));
		lblMobile.setBounds(33, 191, 105, 14);
		frame.getContentPane().add(lblMobile);

		field_Mobile = new JTextField();
		field_Mobile.setEditable(false);
		field_Mobile.setHorizontalAlignment(SwingConstants.CENTER);
		field_Mobile.setForeground(Color.DARK_GRAY);
		field_Mobile.setFont(new Font("Tahoma", Font.BOLD, 15));
		field_Mobile.setToolTipText("");
		field_Mobile.setColumns(10);
		field_Mobile.setBounds(124, 182, 194, 30);
		frame.getContentPane().add(field_Mobile);

		field_adresse = new JTextField();
		field_adresse.setEditable(false);
		field_adresse.setHorizontalAlignment(SwingConstants.CENTER);
		field_adresse.setForeground(Color.DARK_GRAY);
		field_adresse.setFont(new Font("Tahoma", Font.BOLD, 15));
		field_adresse.setColumns(10);
		field_adresse.setBounds(124, 137, 668, 30);
		frame.getContentPane().add(field_adresse);

		field_nom = new JTextField();
		field_nom.setEditable(false);
		field_nom.setHorizontalAlignment(SwingConstants.CENTER);
		field_nom.setForeground(Color.DARK_GRAY);
		field_nom.setFont(new Font("Tahoma", Font.BOLD, 15));
		field_nom.setToolTipText("");
		field_nom.setColumns(10);
		field_nom.setBounds(124, 96, 194, 30);
		frame.getContentPane().add(field_nom);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setForeground(Utile.myBlue);
		lblNom.setFont(new Font("Raavi", Font.BOLD, 15));
		lblNom.setBounds(54, 105, 60, 14);
		frame.getContentPane().add(lblNom);

		JLabel lblAdresse = new JLabel("Adresse : ");
		lblAdresse.setForeground(Utile.myBlue);
		lblAdresse.setFont(new Font("Raavi", Font.BOLD, 15));
		lblAdresse.setBounds(33, 146, 105, 14);
		frame.getContentPane().add(lblAdresse);

		JLabel lblInformationsDeLentreprise = new JLabel("Informations de l'Entreprise ");
		lblInformationsDeLentreprise.setForeground(Utile.myBlue);
		lblInformationsDeLentreprise.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblInformationsDeLentreprise.setBounds(213, 0, 523, 50);
		frame.getContentPane().add(lblInformationsDeLentreprise);

		field_Email = new JTextField();
		field_Email.setEditable(false);
		field_Email.setHorizontalAlignment(SwingConstants.CENTER);
		field_Email.setForeground(Color.DARK_GRAY);
		field_Email.setFont(new Font("Tahoma", Font.BOLD, 15));
		field_Email.setToolTipText("");
		field_Email.setColumns(10);
		field_Email.setBounds(598, 182, 194, 30);
		frame.getContentPane().add(field_Email);

		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setForeground(Utile.myBlue);
		lblEmail.setFont(new Font("Raavi", Font.BOLD, 15));
		lblEmail.setBounds(540, 191, 105, 14);
		frame.getContentPane().add(lblEmail);

		field_Rc = new JTextField();
		field_Rc.setEditable(false);
		field_Rc.setHorizontalAlignment(SwingConstants.CENTER);
		field_Rc.setForeground(Color.DARK_GRAY);
		field_Rc.setFont(new Font("Tahoma", Font.BOLD, 15));
		field_Rc.setToolTipText("");
		field_Rc.setColumns(10);
		field_Rc.setBounds(124, 232, 194, 30);
		frame.getContentPane().add(field_Rc);

		JLabel lblRc = new JLabel("RC : ");
		lblRc.setForeground(Utile.myBlue);
		lblRc.setFont(new Font("Raavi", Font.BOLD, 15));
		lblRc.setBounds(54, 241, 105, 14);
		frame.getContentPane().add(lblRc);

		field_Nif = new JTextField();
		field_Nif.setEditable(false);
		field_Nif.setHorizontalAlignment(SwingConstants.CENTER);
		field_Nif.setForeground(Color.DARK_GRAY);
		field_Nif.setFont(new Font("Tahoma", Font.BOLD, 15));
		field_Nif.setToolTipText("");
		field_Nif.setColumns(10);
		field_Nif.setBounds(371, 232, 159, 30);
		frame.getContentPane().add(field_Nif);

		JLabel lblNif = new JLabel("NIF : ");
		lblNif.setForeground(Utile.myBlue);
		lblNif.setFont(new Font("Raavi", Font.BOLD, 15));
		lblNif.setBounds(328, 241, 105, 14);
		frame.getContentPane().add(lblNif);

		field_Nis = new JTextField();
		field_Nis.setEditable(false);
		field_Nis.setHorizontalAlignment(SwingConstants.CENTER);
		field_Nis.setForeground(Color.DARK_GRAY);
		field_Nis.setFont(new Font("Tahoma", Font.BOLD, 15));
		field_Nis.setToolTipText("");
		field_Nis.setColumns(10);
		field_Nis.setBounds(598, 232, 194, 30);
		frame.getContentPane().add(field_Nis);

		JLabel lblNis = new JLabel("NIS : ");
		lblNis.setForeground(Utile.myBlue);
		lblNis.setFont(new Font("Raavi", Font.BOLD, 15));
		lblNis.setBounds(540, 241, 105, 14);
		frame.getContentPane().add(lblNis);

		JLabel lblCapitale = new JLabel("Capitale : ");
		lblCapitale.setForeground(Utile.myBlue);
		lblCapitale.setFont(new Font("Raavi", Font.BOLD, 15));
		lblCapitale.setBounds(296, 284, 105, 14);
		frame.getContentPane().add(lblCapitale);

		field_Capitale = new JTextField();
		field_Capitale.setEditable(false);
		field_Capitale.setHorizontalAlignment(SwingConstants.CENTER);
		field_Capitale.setForeground(Color.DARK_GRAY);
		field_Capitale.setFont(new Font("Tahoma", Font.BOLD, 15));
		field_Capitale.setToolTipText("");
		field_Capitale.setColumns(10);
		field_Capitale.setBounds(371, 273, 159, 30);
		frame.getContentPane().add(field_Capitale);

		JLabel lblEntente = new JLabel("Ent\u00EAte  :");
		lblEntente.setForeground(Utile.myBlue);
		lblEntente.setFont(new Font("Raavi", Font.BOLD, 21));
		lblEntente.setBounds(54, 330, 81, 32);
		frame.getContentPane().add(lblEntente);

		JLabel lblFax = new JLabel("FAX : ");
		lblFax.setForeground(Utile.myBlue);
		lblFax.setFont(new Font("Raavi", Font.BOLD, 15));
		lblFax.setBounds(328, 191, 105, 14);
		frame.getContentPane().add(lblFax);

		field_fax = new JTextField();
		field_fax.setEditable(false);
		field_fax.setHorizontalAlignment(SwingConstants.CENTER);
		field_fax.setForeground(Color.DARK_GRAY);
		field_fax.setFont(new Font("Tahoma", Font.BOLD, 15));
		field_fax.setToolTipText("");
		field_fax.setColumns(10);
		field_fax.setBounds(371, 182, 159, 30);
		frame.getContentPane().add(field_fax);

		JPanel panel = new JPanel();
		panel.setBounds(124, 373, 668, 115);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 1));

		LabelEntete = new JLabel("");
		panel.add(LabelEntete);

		JButton Parcour_Entete = new JButton("");
		Parcour_Entete.setFocusable(false);
		Parcour_Entete.setContentAreaFilled(false);
		Parcour_Entete.setBorderPainted(false);
		Parcour_Entete.setBorder(null);
		Parcour_Entete.setRolloverIcon(new ImageIcon(EntrepriseInfo_View.class.getResource("/img/upload_ap.png")));
		Parcour_Entete.setIcon(new ImageIcon(EntrepriseInfo_View.class.getResource("/img/upload.png")));
		Parcour_Entete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(""));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("IMAGE", "jpg", "gif", "png");
				fileChooser.addChoosableFileFilter(filter);
				int result = fileChooser.showSaveDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					path_Entete = selectedFile.getAbsolutePath();
					ImageIcon myImage = new ImageIcon(path_Entete);
					java.awt.Image img = myImage.getImage();
					java.awt.Image newImg = img.getScaledInstance(LabelEntete.getWidth(), LabelEntete.getHeight(),
							java.awt.Image.SCALE_DEFAULT);
					ImageIcon finalImage = new ImageIcon(newImg);
					LabelEntete.setIcon(finalImage);
				} else if (result == JFileChooser.CANCEL_OPTION)
					JOptionPane.showMessageDialog(null, "T'as rien choisi");
			}
		});
		Parcour_Entete.setBounds(142, 320, 48, 42);
		frame.getContentPane().add(Parcour_Entete);

		BtnMisAjour = new JButton("");
		BtnMisAjour.setRolloverIcon(new ImageIcon(EntrepriseInfo_View.class.getResource("/img/misAjour_ap.png")));
		BtnMisAjour.setFocusable(false);
		BtnMisAjour.setContentAreaFilled(false);
		BtnMisAjour.setBorderPainted(false);
		BtnMisAjour.setBorder(null);
		BtnMisAjour.setIcon(new ImageIcon(EntrepriseInfo_View.class.getResource("/img/misAjour.png")));
		BtnMisAjour.setForeground(new Color(25, 25, 112));
		BtnMisAjour.setFont(new Font("Tahoma", Font.BOLD, 26));
		BtnMisAjour.setBounds(345, 499, 184, 44);
		frame.getContentPane().add(BtnMisAjour);

		JButton btnNewButton = new JButton("");
		btnNewButton.setRolloverIcon(new ImageIcon(EntrepriseInfo_View.class.getResource("/img/edit_ap.png")));
		btnNewButton.setIcon(new ImageIcon(EntrepriseInfo_View.class.getResource("/img/edit.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				field_nom.setEditable(true);
				field_adresse.setEditable(true);
				field_Rc.setEditable(true);
				field_Nif.setEditable(true);
				field_Nis.setEditable(true);
				field_Capitale.setEditable(true);
				field_Mobile.setEditable(true);
				field_Email.setEditable(true);
				field_fax.setEditable(true);

			}
		});
		btnNewButton.setBounds(124, 48, 156, 44);
		frame.getContentPane().add(btnNewButton);

		JLabel Wall = new JLabel("");
		Wall.setIcon(new ImageIcon(EntrepriseInfo_View.class.getResource("/img/wall2.png")));
		Wall.setBounds(-31, -279, 950, 1117);
		frame.getContentPane().add(Wall);
		// frame.setVisible(true);

	}

	@SuppressWarnings("static-access")
	public void SetInfo(Info info) {
		field_nom.setText(info.getNom());
		field_adresse.setText(info.getAdresse());
		field_Rc.setText(info.getRC());
		field_Nif.setText(info.getNIF());
		field_Nis.setText(info.getNIS());
		field_Capitale.setText(info.getCapitale());
		field_Mobile.setText(info.getMobile());
		field_Email.setText(info.getEmail());
		field_fax.setText(info.getFAX());

		try {
			ImageIcon EntetImage = new ImageIcon(info.getImgEntete());
			java.awt.Image img2 = EntetImage.getImage();
			java.awt.Image newImg2 = img2.getScaledInstance(LabelEntete.getWidth(), LabelEntete.getHeight(),
					java.awt.Image.SCALE_DEFAULT);
			ImageIcon finalImage2 = new ImageIcon(newImg2);
			LabelEntete.setIcon(finalImage2);
			this.info = info;
			path_Entete = info.getEntete();

		} catch (Exception e) {
		}
	}

	@SuppressWarnings("static-access")
	public void SetInfo_Home(Info info) {
		field_nom.setText(info.getNom());
		field_adresse.setText(info.getAdresse());
		field_Rc.setText(info.getRC());
		field_Nif.setText(info.getNIF());
		field_Nis.setText(info.getNIS());
		field_Capitale.setText(info.getCapitale());
		field_Mobile.setText(info.getMobile());
		field_Email.setText(info.getEmail());
		field_fax.setText(info.getFAX());
		path_Entete = info.getEntete();
		this.info = info;

	}

	public JButton getBtnMisAjour() {
		return BtnMisAjour;
	}

	public Info recuperInfo() {
		Info info = new Info();

		info.setNom(field_nom.getText());
		info.setAdresse(field_adresse.getText());
		info.setRC(field_Rc.getText());
		info.setNIF(field_Nif.getText());
		info.setNIS(field_Nis.getText());
		info.setCapitale(field_Capitale.getText());
		info.setFAX(field_fax.getText());
		info.setMobile(field_Mobile.getText());
		info.setEmail(field_Email.getText());
		info.setEntete(path_Entete);
		return info;
	}
}
