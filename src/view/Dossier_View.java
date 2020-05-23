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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import model.Utile;
import model.entity.Dossier;
import view.Theme.Msg;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

public class Dossier_View extends JFrame {

	// ------------------- Les déclarations  -----------------------//

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JButton Btn_Ajouter_Dos;
	private JTextField Rech_field;
	private JTable table;
	private JButton Returne;
	private JButton Btn_Visite;
	private JButton Btn_Sortie;
	private JButton Btn_Facture;
	private JDateChooser DateA, DateB;
	private JLabel label_2;

	// -------------------------- Le constructeur --------------------------//

	public Dossier_View() {
		contentPane = new JPanel();

		///////////////////// Ajuster la taille de la fenetre
		///////////////////// ////////////////////
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		setSize(screenSize.width, screenSize.height - taskBarSize);
		setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());
		setContentPane(contentPane);

		///////////////////// Fin Ajuster la taille de la fenetre

		contentPane.setLayout(null);
		Returne = new JButton("");
		Returne.setIcon(new ImageIcon(Client_View.class.getResource("/img/return_av.png")));
		Returne.setContentAreaFilled(false);
		Returne.setBorderPainted(false);
		Returne.setBounds(0, 0, 113, 104);
		Returne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Returne.setIcon(new ImageIcon(Menu.class.getResource("/img/return_ap.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Returne.setIcon(new ImageIcon(Menu.class.getResource("/img/return_av.png")));
			}
		});
		contentPane.add(Returne);

		Menu menu = new Menu();
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1366, 111);
		panel_1 = menu.getPanel();
		contentPane.add(panel_1);

		Btn_Ajouter_Dos = new JButton("");
		Btn_Ajouter_Dos.setRolloverIcon(new ImageIcon(Dossier_View.class.getResource("/img/bu_new_ap.png")));
		Btn_Ajouter_Dos.setOpaque(false);
		Btn_Ajouter_Dos.setContentAreaFilled(false);
		Btn_Ajouter_Dos.setBorderPainted(false);

		Btn_Ajouter_Dos.setIcon(new ImageIcon(Dossier_View.class.getResource("/img/bu_New.png")));

		Btn_Ajouter_Dos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		Btn_Ajouter_Dos.setBounds(1102, 184, 184, 44);
		contentPane.add(Btn_Ajouter_Dos);

		Rech_field = new JTextField();
		Rech_field.setBorder(null);
		Rech_field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		Rech_field.setBounds(271, 125, 143, 23);
		contentPane.add(Rech_field);
		Rech_field.setColumns(10);

		JLabel lblR = new JLabel("Rechercher Par Client : ");
		lblR.setForeground(new Color(139, 0, 0));
		lblR.setFont(new Font("Arial", Font.BOLD, 15));
		lblR.setBounds(57, 119, 194, 36);
		contentPane.add(lblR);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 166, 1024, 496);
		contentPane.add(scrollPane);

		table = new JTable();
		Utile.Property_Table(table);
		Utile.Entete_Table(table);
		Utile.Centrer_Table(table);
		Utile.Centrer_Table(table);

		scrollPane.setViewportView(table);

		Btn_Visite = new JButton("");
		Btn_Visite.setRolloverIcon(new ImageIcon(Dossier_View.class.getResource("/img/bu_visite_ap.png")));
		Btn_Visite.setIcon(new ImageIcon(Dossier_View.class.getResource("/img/bu_visite.png")));
		Btn_Visite.setOpaque(false);
		Btn_Visite.setContentAreaFilled(false);
		Btn_Visite.setBorderPainted(false);
		Btn_Visite.setBounds(1102, 253, 184, 44);
		contentPane.add(Btn_Visite);

		Btn_Sortie = new JButton("");
		Btn_Sortie.setRolloverIcon(new ImageIcon(Dossier_View.class.getResource("/img/bu_sortie_ap.png")));
		Btn_Sortie.setIcon(new ImageIcon(Dossier_View.class.getResource("/img/bu_sortie.png")));
		Btn_Sortie.setOpaque(false);
		Btn_Sortie.setContentAreaFilled(false);
		Btn_Sortie.setBorderPainted(false);
		Btn_Sortie.setBounds(1102, 328, 184, 44);
		contentPane.add(Btn_Sortie);

		Btn_Facture = new JButton("");
		Btn_Facture.setRolloverIcon(new ImageIcon(Dossier_View.class.getResource("/img/bu_facture_ap.png")));
		Btn_Facture.setIcon(new ImageIcon(Dossier_View.class.getResource("/img/bu_facture.png")));
		Btn_Facture.setOpaque(false);
		Btn_Facture.setContentAreaFilled(false);
		Btn_Facture.setBorderPainted(false);
		Btn_Facture.setBounds(1102, 400, 184, 44);
		contentPane.add(Btn_Facture);

		// ////////////////////////// Debut Wallpaper /////////////////////////
		JLabel Wall = new JLabel("");
		Wall.setInheritsPopupMenu(false);
		Wall.setIcon(new ImageIcon(Login_Viex.class.getResource("/img/wall.jpg")));
		Wall.setSize(screenSize.width, screenSize.height - taskBarSize);
		setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());

		JLabel label = new JLabel("Du :");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(436, 124, 46, 28);
		contentPane.add(label);

		DateA = new JDateChooser();
		DateA.setBounds(478, 124, 153, 28);
		contentPane.add(DateA);

		JLabel label_1 = new JLabel("Au :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBounds(641, 124, 46, 28);
		contentPane.add(label_1);

		DateB = new JDateChooser();
		DateB.setBounds(680, 124, 153, 28);
		contentPane.add(DateB);

		JButton afficherByDate = new JButton("");
		afficherByDate.setRolloverIcon(new ImageIcon(Dossier_View.class.getResource("/img/afficher_ap.png")));
		afficherByDate.setContentAreaFilled(false);
		afficherByDate.setBorderPainted(false);
		afficherByDate.setBorder(null);
		afficherByDate.setIcon(new ImageIcon(Dossier_View.class.getResource("/img/afficher.png")));
		afficherByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.sql.Date Date11 = new java.sql.Date(DateA.getDate().getTime());
					java.sql.Date Date22 = new java.sql.Date(DateB.getDate().getTime());
					Dossier.RechByDate(Date11, Date22, table);
					SetSizeColumn();

				} catch (Exception e1) {
					Msg.Afficher("Vous devez choisir date valide", Msg.IconExclam, false);
					Utile.Wait(2);
					Msg.CloseMsg();
				}
			}
		});
		afficherByDate.setFocusable(false);
		afficherByDate.setBounds(843, 122, 110, 31);
		contentPane.add(afficherByDate);

		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Dossier_View.class.getResource("/img/search_field3.png")));
		label_2.setBounds(233, 119, 193, 37);
		contentPane.add(label_2);
		contentPane.add(Wall);

		// ////////////////////////// Fin Wallpaper /////////////////////////

	}

	// -------------------------- Les methodes --------------------------//

	public void SetSizeColumn() {
		getTable().getColumnModel().getColumn(0).setMaxWidth(65);
		getTable().getColumnModel().getColumn(1).setMaxWidth(70);
		getTable().getColumnModel().getColumn(2).setMaxWidth(125);
		getTable().getColumnModel().getColumn(3).setMaxWidth(125);
		getTable().getColumnModel().getColumn(4).setMaxWidth(105);
		getTable().getColumnModel().getColumn(5).setMaxWidth(80);
		getTable().getColumnModel().getColumn(6).setMaxWidth(130);
		getTable().getColumnModel().getColumn(7).setMaxWidth(130);
		getTable().getColumnModel().getColumn(8).setMaxWidth(122);
		getTable().getColumnModel().getColumn(9).setMaxWidth(70);

	}

	// ----------------------- Les getters & setters ------------------------//

	public JButton getBtn_Ajouter_Dos() {
		return Btn_Ajouter_Dos;
	}

	public void setBtn_Ajouter_Dos(JButton btn_Ajouter_Dos) {
		Btn_Ajouter_Dos = btn_Ajouter_Dos;
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

	public JButton getBtn_Visite() {
		return Btn_Visite;
	}

	public void setBtn_Visite(JButton btn_Visite) {
		Btn_Visite = btn_Visite;
	}

	public JButton getBtn_Sortie() {
		return Btn_Sortie;
	}

	public void setBtn_Sortie(JButton btn_Sortie) {
		Btn_Sortie = btn_Sortie;
	}

	public JButton getBtn_Facture() {
		return Btn_Facture;
	}

	public void setBtn_Facture(JButton btn_Facture) {
		Btn_Facture = btn_Facture;
	}

	public JButton getReturne() {
		return Returne;
	}

	public void setReturne(JButton returne) {
		Returne = returne;
	}
}
