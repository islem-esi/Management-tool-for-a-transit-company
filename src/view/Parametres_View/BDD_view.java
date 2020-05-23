package view.Parametres_View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Utile;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;

public class BDD_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField field_path_save;
	private JButton btnBackupNow;
	private JLabel Label_Sauv;
	public JFrame frame;
	private String pathBackup = null;
	private String pathRestore = null;

	String filename;
	private JLabel lblSauvgarde;
	private JLabel lblResturation;
	private JButton btnResturation;
	private JTextField field_path_restaure;
	private JLabel lblPathRestaure;
	private JButton Restaur_Parcoure;
	private JButton Save_Parcoure;
	private JLabel Label_Restore;

	public BDD_view() {

		frame = new JFrame();
		frame.setBounds(new Rectangle(100, 10, 0, 0));
		frame.setTitle("Info Entreprise");
		frame.setResizable(false);
		frame.setBounds(100, 100, 746, 442);
		frame.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.getContentPane().setLayout(null);

		field_path_save = new JTextField();
		field_path_save.setEditable(false);
		field_path_save.setHorizontalAlignment(SwingConstants.CENTER);
		field_path_save.setForeground(Color.DARK_GRAY);
		field_path_save.setFont(new Font("Tahoma", Font.BOLD, 15));
		field_path_save.setColumns(10);
		field_path_save.setBounds(159, 137, 413, 30);
		frame.getContentPane().add(field_path_save);

		Save_Parcoure = new JButton("");
		Save_Parcoure.setFocusable(false);
		Save_Parcoure.setContentAreaFilled(false);
		Save_Parcoure.setBorderPainted(false);
		Save_Parcoure.setBorder(null);
		Save_Parcoure.setRolloverIcon(new ImageIcon(EntrepriseInfo_View.class.getResource("/img/upload_ap.png")));
		Save_Parcoure.setIcon(new ImageIcon(EntrepriseInfo_View.class.getResource("/img/upload.png")));
		Save_Parcoure.setBounds(582, 130, 48, 42);
		Save_Parcoure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				// fileChooser.setCurrentDirectory(new File(""));
				// FileNameExtensionFilter filter = new
				// FileNameExtensionFilter("SQL", "sql");
				// fileChooser.addChoosableFileFilter(filter);
				// fileChooser.showOpenDialog(this);
				int result = fileChooser.showSaveDialog(null);
				String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					pathBackup = selectedFile.getAbsolutePath();
					pathBackup = pathBackup.replace('\\', '/');
					pathBackup = pathBackup + "_" + date + ".sql";
					field_path_save.setText(pathBackup);

				} else if (result == JFileChooser.CANCEL_OPTION)
					JOptionPane.showMessageDialog(null, "T'as rien choisi");
			}
		});

		frame.getContentPane().add(Save_Parcoure);

		Label_Sauv = new JLabel("");
		Label_Sauv.setForeground(Color.RED);
		Label_Sauv.setFont(new Font("Raavi", Font.BOLD, 17));
		Label_Sauv.setBounds(300, 178, 272, 18);
		frame.getContentPane().add(Label_Sauv);

		JLabel lblPathSave = new JLabel("Path Sauvgarde : ");
		lblPathSave.setForeground(Utile.myBlue);
		lblPathSave.setFont(new Font("Raavi", Font.BOLD, 15));
		lblPathSave.setBounds(24, 147, 125, 14);
		frame.getContentPane().add(lblPathSave);

		JLabel lblInformationsDeLentreprise = new JLabel("Sauvgarde et Resturation Base de donnes");
		lblInformationsDeLentreprise.setForeground(Utile.myBlue);
		lblInformationsDeLentreprise.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblInformationsDeLentreprise.setBounds(35, 11, 682, 50);
		frame.getContentPane().add(lblInformationsDeLentreprise);

		btnBackupNow = new JButton("BackUp");
		btnBackupNow.setBounds(159, 178, 131, 23);
		frame.getContentPane().add(btnBackupNow);

		lblSauvgarde = new JLabel("Sauvgarde");
		lblSauvgarde.setForeground(new Color(1, 74, 112));
		lblSauvgarde.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSauvgarde.setBounds(288, 76, 192, 50);
		frame.getContentPane().add(lblSauvgarde);

		lblResturation = new JLabel("Resturation");
		lblResturation.setForeground(new Color(1, 74, 112));
		lblResturation.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblResturation.setBounds(272, 218, 192, 50);
		frame.getContentPane().add(lblResturation);

		btnResturation = new JButton("Resturation");
		btnResturation.setBounds(159, 319, 131, 23);
		frame.getContentPane().add(btnResturation);

		field_path_restaure = new JTextField();
		field_path_restaure.setHorizontalAlignment(SwingConstants.CENTER);
		field_path_restaure.setForeground(Color.DARK_GRAY);
		field_path_restaure.setFont(new Font("Tahoma", Font.BOLD, 15));
		field_path_restaure.setEditable(false);
		field_path_restaure.setColumns(10);
		field_path_restaure.setBounds(159, 278, 413, 30);
		frame.getContentPane().add(field_path_restaure);

		lblPathRestaure = new JLabel("Path resturation: ");
		lblPathRestaure.setForeground(new Color(1, 74, 112));
		lblPathRestaure.setFont(new Font("Raavi", Font.BOLD, 15));
		lblPathRestaure.setBounds(24, 288, 139, 14);
		frame.getContentPane().add(lblPathRestaure);

		Restaur_Parcoure = new JButton("");
		Restaur_Parcoure.setIcon(new ImageIcon(BDD_view.class.getResource("/img/upload.png")));
		Restaur_Parcoure.setFocusable(false);
		Restaur_Parcoure.setContentAreaFilled(false);
		Restaur_Parcoure.setBorderPainted(false);
		Restaur_Parcoure.setBorder(null);
		Restaur_Parcoure.setBounds(582, 270, 48, 42);
		Restaur_Parcoure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				// fileChooser.setCurrentDirectory(new File(""));
				// FileNameExtensionFilter filter = new
				// FileNameExtensionFilter("SQL", "sql");
				// fileChooser.addChoosableFileFilter(filter);
				// fileChooser.showOpenDialog(this);
				int result = fileChooser.showSaveDialog(null);
				// String date = new SimpleDateFormat("yyyy-MM-dd").format(new
				// Date());

				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					pathRestore = selectedFile.getAbsolutePath();
					pathRestore = pathRestore.replace('\\', '/');
					field_path_restaure.setText(pathRestore);

				} else if (result == JFileChooser.CANCEL_OPTION)
					JOptionPane.showMessageDialog(null, "T'as rien choisi");
			}
		});

		frame.getContentPane().add(Restaur_Parcoure);

		Label_Restore = new JLabel("");
		Label_Restore.setForeground(Color.RED);
		Label_Restore.setFont(new Font("Raavi", Font.BOLD, 17));
		Label_Restore.setBounds(300, 323, 272, 18);
		frame.getContentPane().add(Label_Restore);

		JLabel Wall = new JLabel("");
		Wall.setIcon(new ImageIcon(EntrepriseInfo_View.class.getResource("/img/wall2.png")));
		Wall.setBounds(-31, -279, 950, 1117);
		frame.getContentPane().add(Wall);
		// frame.setVisible(true);

	}

	public JButton getBtnBackupNow() {
		return btnBackupNow;
	}

	public JButton getBtnResturation() {
		return btnResturation;
	}

	public String getPathBackup() {
		return pathBackup;
	}

	public String getPathRestore() {
		return pathRestore;
	}

	public JLabel getLabel_Sauv() {
		return Label_Sauv;
	}

	public JLabel getLabel_Restore() {
		return Label_Restore;
	}

}
