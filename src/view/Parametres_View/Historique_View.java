package view.Parametres_View;

import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import model.Utile;

import java.awt.Font;

public class Historique_View extends JFrame {

	private JPanel contentPane;

	private static final long serialVersionUID = 1L;
	private JTextField Rech_field;
	private JTable table;
	public JFrame frame;

	private JTextField textFieldEmplye;

	public Historique_View() {
		frame = new JFrame();
		frame.setBounds(new Rectangle(100, 10, 0, 0));
		frame.setTitle("Info Entreprise");
		frame.setResizable(false);
		frame.setBounds(100, 100, 986, 494);
		frame.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.getContentPane().setLayout(null);

		Rech_field = new JTextField();
		Rech_field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		Rech_field.setBounds(276, 30, 194, 27);
		frame.getContentPane().add(Rech_field);
		Rech_field.setColumns(10);

		JLabel lblR = new JLabel("Rechercher Par Designation   : ");
		lblR.setForeground(new Color(0, 0, 102));
		lblR.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblR.setBounds(38, 23, 230, 36);
		frame.getContentPane().add(lblR);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 960, 385);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		Utile.Property_Table(table);
		Utile.Entete_Table(table);
		Utile.Centrer_Table(table);
		Utile.Centrer_Table(table);

		scrollPane.setViewportView(table);


		JLabel lblRechercherParDesignation = new JLabel("Rechercher Par Employ\u00E9   : ");
		lblRechercherParDesignation.setForeground(new Color(0, 0, 102));
		lblRechercherParDesignation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRechercherParDesignation.setBounds(480, 23, 230, 36);
		frame.getContentPane().add(lblRechercherParDesignation);

		textFieldEmplye = new JTextField();
		textFieldEmplye.setColumns(10);
		textFieldEmplye.setBounds(687, 32, 194, 27);
		frame.getContentPane().add(textFieldEmplye);


		JLabel Wall = new JLabel("");
		Wall.setIcon(new ImageIcon(EntrepriseInfo_View.class.getResource("/img/wall2.png")));
		Wall.setBounds(-31, -279, 1028, 1117);
		frame.getContentPane().add(Wall);
		frame.setVisible(true);
		// ////////////////////////// Fin Wallpaper /////////////////////////

	}


	public JTextField getTextFieldEmplye() {
		return textFieldEmplye;
	}


	public void setTextFieldEmplye(JTextField textFieldEmplye) {
		this.textFieldEmplye = textFieldEmplye;
	}


	public JTextField getRech_field() {
		return Rech_field;
	}

	public void setRech_field(JTextField rech_field) {
		Rech_field = rech_field;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}


}
