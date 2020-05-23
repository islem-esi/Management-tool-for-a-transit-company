package controllers.Parametres;

import model.entity.Designation;
import model.entity.ExisteOrNot_Exception;
import model.Utile;
import view.Parametres_View.Designation_View;
import view.Parametres_View.NoLettersOrNoDigital_Exception;
import view.Parametres_View.OverInderSize_Exception;

public class Designation_Ctrl {

	// ********************* Les variables d'instance *********************//

	private Designation designation;
	private Designation_View designation_View;

	// ************************** Le constructeur *************************//

	public Designation_Ctrl() {

		initView();
		Utile.UpdateTable("select designation as Désignation , Prix_Unit as Prix_Unitaire , Type_Debours from designation order by designation",
				designation_View.getTable());
		designation_View.getBtn_Ajouter().addActionListener(e -> Ajouter());
		designation_View.getBtn_Supprimer().addActionListener(e -> Supprimer());
		designation_View.getBtn_Modifier().addActionListener(e -> Modifier());
	}
	// *********************** Les methodes ***************************//

	// Role: initialise la fenètre du paramètre de designation

	public void initView() {
		designation_View = new Designation_View();
		designation_View.enableAll(false);
	}

	// Role: ajoute un designation à BD
	public void Ajouter() {
		try {
			designation_View.Test();
			designation = designation_View.getInformations();
			designation.Ajouter();
			Utile.UpdateTable("select Designation as Désignation , Prix_Unit as Prix_Unitaire , Type_Debours from Designation order by Designation",
					designation_View.getTable());
			designation_View.setChampsVides();
		}
		catch (OverInderSize_Exception e3) {designation_View.getBtn_Ajouter().setEnabled(false);}
		catch (NoLettersOrNoDigital_Exception e4) {designation_View.getBtn_Ajouter().setEnabled(false);}
		catch (ExisteOrNot_Exception e1) {designation_View.getBtn_Ajouter().setEnabled(false);}
	}

	// Role: supprime un designation de la BD
	public void Supprimer() {
		try {
			designation = designation_View.getInformations();
			designation.Supprimer();
			Utile.UpdateTable("select Designation as Désignation , Prix_Unit as Prix_Unitaire , Type_Debours from Designation order by Designation",
					designation_View.getTable());
			designation_View.setChampsVides();
		} catch (ExisteOrNot_Exception e1) {designation_View.getBtn_Supprimer().setEnabled(false);}
	}

	// Role : modifie un designation déja enregistré dans la BD
	public void Modifier() {
		try {
			designation_View.Test();
			designation = designation_View.RowToObject();
			designation.Modifier(designation_View.getInformations());
			Utile.UpdateTable("select Designation as Désignation , Prix_Unit as Prix_Unitaire , Type_Debours from Designation order by Designation",
					designation_View.getTable());
			designation_View.setChampsVides();
		}
		catch (OverInderSize_Exception e3) {designation_View.getBtn_Modifier().setEnabled(false);}
		catch (NoLettersOrNoDigital_Exception e4) {designation_View.getBtn_Modifier().setEnabled(false);}
		catch (ExisteOrNot_Exception e1) {designation_View.getBtn_Modifier().setEnabled(false);}
	}

}
