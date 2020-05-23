package controllers.Parametres;

import java.awt.event.KeyAdapter;
import model.Utile;
import model.entity.Designation;
import view.Parametres_View.Historique_View;

public class Historique_Ctrl {
	// ------------------- Les variables d'instance et déclarations  -----------------------//
	private Historique_View historique_view;

	// -------------------------- Le constructeur --------------------------//

	public Historique_Ctrl() {
		initController();
	}

	// -------------------------- Les methodes --------------------------//
	public void initController() {
		initView();
		historique_view.getRech_field().addKeyListener(KeyRech);
		historique_view.getTextFieldEmplye().addKeyListener(KeyRech2);
	}

	//*************************************************************//

	public void initView() {
		historique_view = new Historique_View();
		String sql = "Select Nom_Utilisateur as 'employé' , historique.idUtilisateur as 'code employé',designation,date,prix as 'nouveau prix'"
				+ ",prix_prec as 'ancien prix',changement from historique "
				+ " inner join utilisateur where historique.idUtilisateur=utilisateur.idUtilisateur";
		Utile.UpdateTable(sql, historique_view.getTable());
	}

	//*************************************************************//

	public void detail() {
		String sql = "Select Nom_Utilisateur as 'employé' , historique.idUtilisateur as 'code employé',designation,date,prix as 'nouveau prix'"
				+ ",prix_prec as 'ancien prix',changement from historique "
				+ " inner join utilisateur where historique.idUtilisateur=utilisateur.idUtilisateur && vu='non'";
		Utile.UpdateTable(sql, historique_view.getTable());
	}
	//*************************************************************//
	KeyAdapter KeyRech = new KeyAdapter() {
		public void keyReleased(java.awt.event.KeyEvent evt) {

			Designation.RechDesignationHistorique1(historique_view.getRech_field().getText().toString(),
					historique_view.getTable());
		}
	};

	//*************************************************************//

	KeyAdapter KeyRech2 = new KeyAdapter() {
		public void keyReleased(java.awt.event.KeyEvent evt) {

			Designation.RechDesignationHistorique2(historique_view.getTextFieldEmplye().getText().toString(),
					historique_view.getTable());
		}
	};
}
