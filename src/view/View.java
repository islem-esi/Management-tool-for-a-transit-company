package view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class View extends JFrame {

	// ------------------- Les déclarations  -----------------------//

	private static final long serialVersionUID = 1L;
	static JPanel contentPane;
	private Dimension screenSize;
	private int taskBarSize;
	static View pan;

	// -------------------------- Le constructeur --------------------------//

	public View() {
		setResizable(false);
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/img/icon.png")));
		InitFrame();
		InitWall();
		pan=this;
	}

	// -------------------------- Les methodes --------------------------//
	public void InitWall() {
		JLabel Wall = new JLabel("");
		Wall.setLocation(0, 0);
		Wall.setInheritsPopupMenu(false);
		Wall.setIcon(new ImageIcon(Login_Viex.class
				.getResource("/img/wall.jpg")));
		Wall.setSize(1366, 728);
		setLocation(screenSize.width - getWidth(), screenSize.height
				- taskBarSize - getHeight());
		getContentPane().setLayout(null);

		JButton close = new JButton("");
		close.setIcon(new ImageIcon(View.class.getResource("/img/close.png")));
		close.setRolloverIcon(new ImageIcon(View.class.getResource("/img/close_ap.png")));
		close.setFocusable(false);
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		close.setBorder(null);
		close.setBounds(1132, 44, 17, 17);
		contentPane.add(close);
		getContentPane().add(Wall);

		JLabel Tmp_Bar = new JLabel("");
		Tmp_Bar.setIcon(new ImageIcon(Add_Dossier_View.class.getResource("/img/bar.jpg")));
		Tmp_Bar.setBounds(0, 0, 1366, 111);
		getContentPane().add(Tmp_Bar);
		getContentPane().add(Wall);

	}
	// -----------------------------------------------------//
	public void InitFrame() {
		contentPane = new JPanel();
		setTitle("Gestion Facturation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(
				getGraphicsConfiguration());
		taskBarSize = scnMax.bottom;
		setSize(screenSize.width, screenSize.height - taskBarSize);
		setLocation(screenSize.width - getWidth(), screenSize.height
				- taskBarSize - getHeight());
		setContentPane(contentPane);
	}

	// ----------------------- Les getters & setters ------------------------//

	static JPanel getPane() {
		return contentPane;
	}

	static public void fermer()
	{
		pan.dispose();
	}

	public static View GetView()
	{
		return pan;
	}
}
