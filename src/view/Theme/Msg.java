package view.Theme;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Msg extends JFrame {

	private static final long serialVersionUID = 1L;
	final public static String CnxReussit = "Connexion Réussit";
	final public static String ClientAjouter = "Client ajouté avec succèes";
	final public static String ClientModifier = "Client modifié avec succeès";
	final public static String ClientSupprimer = "Client supprimé avec succeès";
	final public static String ClientNonExiste = "Ce client n'éxiste pas!";
	final public static String ClientExiste = "Client existe deja";

	final public static String CnxError = "Utilisateur ou Mot de passe Erroné";
	final public static String ChampVide = "Veulliez Remplir les champs Vides";

	/////////////////////////////////////////////
	final public static String PathIcon1 = "/img/Msg/ok.png";
	final public static String PathIcon2 = "/img/Msg/error.png";
	final public static String IconOk = "/img/Msg/ok.png";
	final public static String IconError = "/img/Msg/error.png";
	final public static String IconExclam = "/img/Msg/exclam.png";
	final public static String IconInter = "/img/Msg/inter.png";

	/////////////////////////////////////////////

	public static JLabel Background, Icon, Message;
	public static JButton BtnFermer;
	public static JLabel Loading;
	public static JFrame frame;

	public Msg(String msg, String PathIcon, boolean Button, boolean Load) {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		setTitle("Message Dialog in Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(437, 112);
		setLocationRelativeTo(null);
		setResizable(false);
		if (Button) {
			BtnFermer = new JButton("Fermer");
			BtnFermer.setBounds(170, 78, 89, 23);
			BtnFermer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			getContentPane().setLayout(null);
			BtnFermer.setFocusable(false);
			BtnFermer.setDefaultCapable(false);
			BtnFermer.setBorder(null);
			BtnFermer.setBorderPainted(false);
			getContentPane().add(BtnFermer);
		}
		getContentPane().setLayout(null);


		if (Load) {
			Loading = new JLabel("");
			Loading.setFocusable(false);
			Loading.setVerifyInputWhenFocusTarget(false);
			Loading.setInheritsPopupMenu(false);
			Loading.setIcon(new ImageIcon(Msg.class.getResource("/img/Msg/loading3.gif")));
			Loading.setBounds(356, 26, 45, 45);
			getContentPane().add(Loading);
		}

		Message = new JLabel(msg);
		Message.setHorizontalTextPosition(SwingConstants.CENTER);
		Message.setHorizontalAlignment(SwingConstants.CENTER);
		Message.setBounds(71, 26, 366, 50);
		Message.setFont(new Font("Tahoma", Font.BOLD, 17));
		Message.setForeground(Color.WHITE);
		getContentPane().add(Message);

		Icon = new JLabel("");
		Icon.setBounds(21, 21, 69, 69);
		Icon.setIcon(new ImageIcon(Msg.class.getResource(PathIcon)));
		getContentPane().add(Icon);

		Background = new JLabel("");
		Background.setIcon(new ImageIcon(Msg.class.getResource("/img/Msg_transparent.png")));
		Background.setBounds(0, 0, 437, 112);
		getContentPane().add(Background);
		setVisible(true);
		frame = this;
	}

	public static void Afficher(String msg, String PathIcon) {
		new Msg(msg, PathIcon, true,false);
	}

	public static void Afficher(String msg, String PathIcon, boolean Button) {
		new Msg(msg, PathIcon, false,false);
	}
	public static void Afficher(String msg, String PathIcon, boolean Button,boolean loading) {
		new Msg(msg, PathIcon, false,true);
	}

	public static void CloseMsg() {
		frame.dispose();
	}
}
