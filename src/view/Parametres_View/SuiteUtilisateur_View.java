package view.Parametres_View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class SuiteUtilisateur_View extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuiteUtilisateur_View frame = new SuiteUtilisateur_View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SuiteUtilisateur_View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 334);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(SystemColor.inactiveCaption));
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.inactiveCaptionBorder);
		textField_1.setBounds(184, 102, 171, 29);
		contentPane.add(textField_1);

		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setForeground(new Color(0, 0, 128));
		lblMotDePasse.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMotDePasse.setBounds(184, 77, 105, 14);
		contentPane.add(lblMotDePasse);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(0, 249, 507, 46);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Modifier");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(191, 11, 89, 23);
		panel.add(btnNewButton);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setForeground(new Color(0, 0, 128));
		btnSupprimer.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSupprimer.setBounds(290, 11, 105, 23);
		panel.add(btnSupprimer);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(new Color(0, 0, 128));
		btnAnnuler.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAnnuler.setBounds(405, 11, 89, 23);
		panel.add(btnAnnuler);
	}
}
