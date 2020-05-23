package view.Parametres_View;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.entity.Conteneur;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Conteneur_View extends JFrame implements Parametre_View {
	// ********************* Les variables d'instance *********************//
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField field_typeConteneur;
	private JFrame frame;
	private JTable table;
	private JButton btn_Ajout;
	private JButton btn_Modifier;
	private JButton btn_Supprimer;
	private JLabel label;
	private JPanel panel;
	private JLabel lblConteneur;

	// ********************* Le constructeur *********************//

	public Conteneur_View() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(new Rectangle(100, 10, 0, 0));
		frame.setTitle("Conteneur");
		frame.setResizable(false);
		frame.setBounds(100, 100, 637, 555);
		frame.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		// panel.setForeground(Color.WHITE);
		panel.setOpaque(false);
		panel.setBounds(0, 0, 649, 539);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		btn_Ajout = new JButton("");
		btn_Ajout.setBounds(76, 225, 157, 45);
		panel.add(btn_Ajout);
		btn_Ajout.setBorder(null);
		btn_Ajout.setIcon(new ImageIcon(Conteneur_View.class.getResource("/img/ajouter.png")));

		btn_Supprimer = new JButton("");
		btn_Supprimer.setBounds(77, 281, 156, 44);
		panel.add(btn_Supprimer);
		btn_Supprimer.setBorder(null);
		btn_Supprimer.setIcon(new ImageIcon(Conteneur_View.class.getResource("/img/delete.png")));

		btn_Modifier = new JButton("");
		btn_Modifier.setBounds(77, 334, 156, 44);
		panel.add(btn_Modifier);
		btn_Modifier.setBorder(null);
		btn_Modifier.setIcon(new ImageIcon(Conteneur_View.class.getResource("/img/edit.png")));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 102, 278, 363);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btn_Supprimer.setEnabled(true);
				btn_Ajout.setEnabled(false);
				btn_Modifier.setEnabled(false);
				int ligne = table.getSelectedRow();
				String conteneur = table.getModel().getValueAt(ligne, 0).toString();
				field_typeConteneur.setText(conteneur);
			}
		});
		scrollPane.setViewportView(table);

		field_typeConteneur = new JTextField();
		field_typeConteneur.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		field_typeConteneur.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				btn_Ajout.setEnabled(!isChampVide());
				btn_Supprimer.setEnabled(!isChampVide());
				btn_Modifier.setEnabled((!isChampVide()) && (table.getSelectedRow() != -1));
			}
		});
		field_typeConteneur.setBounds(76, 146, 183, 30);
		panel.add(field_typeConteneur);
		field_typeConteneur.setBackground(Color.WHITE);
		field_typeConteneur.setToolTipText("");
		field_typeConteneur.setColumns(10);

		JLabel lblType = new JLabel("Type de Conteneur :");
		lblType.setBounds(76, 123, 157, 19);
		panel.add(lblType);
		lblType.setForeground(new Color(0, 0, 128));
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 16));

		lblConteneur = new JLabel("Conteneur");
		lblConteneur.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblConteneur.setForeground(new Color(0, 0, 128));
		lblConteneur.setBounds(32, 19, 202, 45);
		panel.add(lblConteneur);

		label = new JLabel("");
		label.setBackground(Color.WHITE);
		label.setIcon(new ImageIcon(Conteneur_View.class.getResource("/img/wall2.png")));
		label.setBounds(0, 0, 738, 539);
		frame.getContentPane().add(label);

		frame.setVisible(true);

	}

	// ********************* Les getters & setters *********************//

	public JTable getTable() {
		return table;
	}

	public JTextField getField_typeConteneur() {
		return field_typeConteneur;
	}

	public void setField_typeConteneur(JTextField field_typeConteneur) {
		this.field_typeConteneur = field_typeConteneur;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtn_Ajout() {
		return btn_Ajout;
	}

	public void setBtn_Ajout(JButton btn_Ajout) {
		this.btn_Ajout = btn_Ajout;
	}

	public JButton getBtn_Modifier() {
		return btn_Modifier;
	}

	public void setBtn_Modifier(JButton btn_Modifier) {
		this.btn_Modifier = btn_Modifier;
	}

	public JButton getBtn_Supprimer() {
		return btn_Supprimer;
	}

	public void setBtn_Supprimer(JButton btn_Supprimer) {
		this.btn_Supprimer = btn_Supprimer;
	}

	// ********************* Les methodes ***********************//
	// Role: vide les textfeilds
	public boolean isChampVide() {
		if (field_typeConteneur.getText().equals(""))
			return true;
		return false;
	}

	// Role : teste si les textfeilds sont vides
	public void setChampsVides() {
		enableAll(false);
		field_typeConteneur.setText("");
	}

	// Role: teste le contenu des textfeilds est jette des exceptions
	public void Test() throws OverInderSize_Exception {

		int i;
		i = Util.OverInderSize(field_typeConteneur.getText(), 45, 1);
		if (i != 0)
			throw new OverInderSize_Exception(" le type de conteneur est trés lang ! ",
					" Le type de conteneur est trés court ! ", i);

	}

	// Role: renvoit un objet de classe Conteneur qui contient les informations
	// contenues dans les textfeilds
	public Conteneur getInformations() {
		return new Conteneur(field_typeConteneur.getText().toString());
	}

	// Role: crée un objet de classe Conteneur à partir du contenu d'une ligne
	// du
	// tableau
	public Conteneur RowToObject() {

		int i = table.getSelectedRow();
		if (i != -1) {
			String type = table.getModel().getValueAt(i, 0).toString();
			return new Conteneur(type);
		}
		return null;

	}

	public void enableAll(boolean oui) {
		btn_Ajout.setEnabled(oui);
		btn_Supprimer.setEnabled(oui);
		btn_Modifier.setEnabled(oui);
	}

}
