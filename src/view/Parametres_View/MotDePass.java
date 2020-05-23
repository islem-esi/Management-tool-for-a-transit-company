package view.Parametres_View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import controllers.Parametres.MotDePass_Ctrl;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MotDePass extends JDialog {
	private static final long serialVersionUID = 1L;

	// ********************* Les variables d'instance *********************//
	private JPasswordField fieldPassword;
	private JPasswordField fieldConfirmer;
	private JLabel label;
	private JLabel lblMotDePasse;
	private JPanel panel;
	private JLabel lblSaisirLeMot;
	private JLabel lblConfirmerLeMot;
	private JButton btnOk;
	private JButton btnAnnuler;
	private JLabel lbTestPass;
	private MotDePass_Ctrl ctrl;

	// ********************* Le constructeur *********************//
	public MotDePass(Frame f, String titre, boolean modale, MotDePass_Ctrl ctrl) {
		super(f, titre, modale);
		setSize(450, 320);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().setVisible(true);
		label = new JLabel("");
		label.setIcon(new ImageIcon(MotDePass.class.getResource("/img/passWord.png")));
		label.setBounds(73, 23, 34, 33);
		getContentPane().add(label);

		lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBackground(Color.WHITE);
		lblMotDePasse.setOpaque(true);
		lblMotDePasse.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMotDePasse.setForeground(UIManager.getColor("activeCaption"));
		lblMotDePasse.setBounds(103, 23, 123, 33);
		getContentPane().add(lblMotDePasse);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(UIManager.getColor("activeCaption")));
		panel.setBounds(54, 42, 335, 197);
		getContentPane().add(panel);
		panel.setLayout(null);

		fieldPassword = new JPasswordField();
		fieldPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean valide = ctrlPassword(fieldPassword.getText().toString().length());
				btnOk.setEnabled(valide && !isChampVide());
			}
		});
		fieldPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		fieldPassword.setBorder(new LineBorder(UIManager.getColor("activeCaption")));
		fieldPassword.setBounds(53, 50, 229, 30);
		panel.add(fieldPassword);

		fieldConfirmer = new JPasswordField();
		fieldConfirmer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				btnOk.setEnabled(!isChampVide());
			}
		});
		fieldConfirmer.setFont(new Font("Times New Roman", Font.BOLD, 18));
		fieldConfirmer.setBorder(new LineBorder(UIManager.getColor("activeCaption")));
		fieldConfirmer.setBounds(53, 136, 229, 30);
		panel.add(fieldConfirmer);

		lblSaisirLeMot = new JLabel("Saisir le mot de passe");
		lblSaisirLeMot.setForeground(new Color(0, 0, 128));
		lblSaisirLeMot.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSaisirLeMot.setBounds(53, 33, 146, 14);
		panel.add(lblSaisirLeMot);

		lblConfirmerLeMot = new JLabel("Confirmer le mot de passe");
		lblConfirmerLeMot.setForeground(new Color(0, 0, 128));
		lblConfirmerLeMot.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblConfirmerLeMot.setBounds(53, 118, 175, 14);
		panel.add(lblConfirmerLeMot);

		lbTestPass = new JLabel("pas moins que 4 caract\u00E8res");
		lbTestPass.setVisible(false);
		lbTestPass.setForeground(Color.RED);
		lbTestPass.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbTestPass.setBounds(138, 81, 146, 14);
		panel.add(lbTestPass);

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (confirmPass()) {
					ctrl.setPassword(fieldPassword.getText().toString());
					setVisible(false);
				} else {
					setChampVide();
					btnOk.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Mot de passe incorrect !");
				}
			}
		});
		btnOk.setEnabled(false);
		btnOk.setForeground(new Color(0, 0, 128));
		btnOk.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOk.setBounds(197, 250, 89, 23);
		btnOk.setVisible(true);
		getContentPane().add(btnOk);

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnAnnuler.setForeground(new Color(0, 0, 128));
		btnAnnuler.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAnnuler.setBounds(296, 250, 89, 23);
		btnAnnuler.setVisible(true);
		getContentPane().add(btnAnnuler);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	// ********************* Les getters & setters *********************//

	public JPasswordField getFieldPassword() {
		return fieldPassword;
	}

	public JPasswordField getFieldConfirmer() {
		return fieldConfirmer;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	// ********************* Les methodes ***********************//

	public boolean isChampVide() {
		return fieldPassword.getText().toString().equals("") || fieldConfirmer.getText().toString().equals("");
	}

	public void setChampVide() {
		fieldPassword.setText("");
		fieldConfirmer.setText("");
	}

	public boolean ctrlPassword(int size) {
		if ((size < 4) && (size > 0)) {
			lbTestPass.setVisible(true);
			return false;
		}
		lbTestPass.setVisible(false);
		return true;
	}

	public boolean confirmPass() {
		return fieldPassword.getText().toString().equals(fieldConfirmer.getText().toString());
	}

}
