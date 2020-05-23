package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BonVisiteConfirme  extends JFrame{

	// ------------------- Les déclarations  -----------------------//
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JButton btnok;
	private JButton btnOui;
	private JButton btnNon;
	private JButton btnAnnuler;

	// -------------------------- Le constructeur --------------------------//

	public BonVisiteConfirme() {

		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(new Rectangle(100, 10, 0, 0));
		frame.setTitle("QUITTER");
		frame.setResizable(false);
		frame.setBounds(100, 100, 715, 400);
		frame.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.getContentPane().setLayout(null);

		JLabel lblListeDesDclarants = new JLabel("Voulez-vous enregistrer les modifications apport\u00E9es ?");
		lblListeDesDclarants.setForeground(new Color(0, 0, 128));
		lblListeDesDclarants.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblListeDesDclarants.setBounds(98, 57, 558, 50);
		frame.getContentPane().add(lblListeDesDclarants);


		btnok = new JButton("  OK");
		btnok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnok.setBounds(782, 347, 89, 23);
		frame.getContentPane().add(btnok);

		JLabel label = new JLabel("");
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(96, 182, 466, 50);
		frame.getContentPane().add(label);

		btnOui = new JButton("Oui");
		btnOui.setBounds(96, 236, 89, 23);
		frame.getContentPane().add(btnOui);

		btnNon = new JButton("Non");
		btnNon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNon.setBounds(276, 236, 89, 23);
		frame.getContentPane().add(btnNon);

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(466, 236, 89, 23);
		frame.getContentPane().add(btnAnnuler);

		frame.setVisible(true);

	}

	// ----------------------- Les getters & setters ------------------------//

	public JButton getBtnOui() {
		return btnOui;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JButton getBtnok() {
		return btnok;
	}

	public void setBtnok(JButton btnok) {
		this.btnok = btnok;
	}

	public void setBtnOui(JButton btnOui) {
		this.btnOui = btnOui;
	}

	public JButton getBtnNon() {
		return btnNon;
	}

	public void setBtnNon(JButton btnNon) {
		this.btnNon = btnNon;
	}

	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	public void setBtnAnnuler(JButton btnAnnuler) {
		this.btnAnnuler = btnAnnuler;
	}

	public JFrame getFrame() {
		return frame;
	}


}
