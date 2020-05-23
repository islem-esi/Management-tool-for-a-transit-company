package controllers.Parametres;

import view.Parametres_View.BDD_view;

public class Bdd_Ctrl {

	// ********************* Les variables d'instance *********************//
	private BDD_view bdd_view;

	// ************************** Le constructeur *************************//

	public Bdd_Ctrl() {
		initView();
		bdd_view.getBtnBackupNow().addActionListener(e -> BackUp());
		bdd_view.getBtnResturation().addActionListener(e -> Restaure());

	}
	// *********************** Les methodes ***************************//

	// Role: initialise la fenètre du paramètre

	public void initView() {
		bdd_view = new BDD_view();
		bdd_view.frame.setVisible(true);
	}

	public void BackUp() {

		Process p = null;

		try {

			Runtime runtime = Runtime.getRuntime();
			p = runtime.exec("cmd.exe /c C:/wamp/bin/mysql/mysql5.5.24/bin/mysqldump "
					+ "-u root --add-drop-database -B gestion_facturation -r" + bdd_view.getPathBackup());
			int processComplete = p.waitFor();
			if (processComplete == 0)
				bdd_view.getLabel_Sauv().setText("BackUp Created Success");
			else
				bdd_view.getLabel_Sauv().setText("Can't Created BackUp");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Restaure() {

		String user = "root";
		String pass = "";
		String[] RestoreCmd = new String[] { "C:/wamp/bin/mysql/mysql5.5.24/bin/mysql.exe", "--user=" + user,
				"--password=" + pass, "-e", "source " + bdd_view.getPathRestore() };

		Process process;
		try {
			process = Runtime.getRuntime().exec(RestoreCmd);
			int processComplete = process.waitFor();
			if (processComplete == 0)
				bdd_view.getLabel_Restore().setText("Restored  Success");
			else
				bdd_view.getLabel_Restore().setText("Can't Restore");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
