package controllers.Parametres;


import model.entity.Declarant;
import model.entity.ExisteOrNot_Exception;
import javax.swing.JComboBox;
import model.Utile;
import view.BonVisite_View;
import view.Parametres_View.Declarant_View;
import view.Parametres_View.NoLettersOrNoDigital_Exception;
import view.Parametres_View.OverInderSize_Exception;

public class Declarant_Ctrl implements Parametre_Ctrl{

	// ********************* Les variables d'instance *********************//

	private Declarant declarant;
	private Declarant_View declarant_View;

	// ************************** Le constructeur *************************//

	public Declarant_Ctrl() {

		initView();
		Utile.UpdateTable("select Nom_Declarant as Nom, Prenom_Declarant as Prenom, Phone_Declarant as Mobile from declarant order by Nom_Declarant , Prenom_Declarant",
				declarant_View.getTable());
		declarant_View.getBtn_Ajouter().addActionListener(e -> Ajouter());
		declarant_View.getBtn_Supprimer().addActionListener(e -> Supprimer());
		declarant_View.getBtn_Modifier().addActionListener(e -> Modifier());
	}

	// *********************** Les methodes ***************************//

	// Role: initialise la fenètre du paramètre de declarant

	public void initView() {
		declarant_View = new Declarant_View();
		declarant_View.enableAll(false);
	}

	public void Ajouter() {
		try {
			declarant_View.Test();
			declarant = declarant_View.getInformations();
			declarant.Ajouter();
			Utile.UpdateTable("select Nom_Declarant as Nom, Prenom_Declarant as Prenom, Phone_Declarant as Mobile from declarant order by Nom_Declarant , Prenom_Declarant",
					declarant_View.getTable());
			declarant_View.setChampsVides();

			JComboBox<String> combo = new JComboBox<String>();
			Utile.remplirCombo(combo, "declarant", "Nom_Declarant");
			BonVisite_View.ComboDeclarant.setModel(combo.getModel());

		}
		catch (OverInderSize_Exception e3) {declarant_View.getBtn_Ajouter().setEnabled(false);}
		catch (NoLettersOrNoDigital_Exception e4) {declarant_View.getBtn_Ajouter().setEnabled(false);}
		catch (ExisteOrNot_Exception e1) {declarant_View.getBtn_Ajouter().setEnabled(false);}
	}

	public void Supprimer() {
		try {
			declarant = declarant_View.getInformations();
			declarant.Supprimer();
			Utile.UpdateTable("select Nom_Declarant as Nom, Prenom_Declarant as Prenom, Phone_Declarant as Mobile from declarant order by Nom_Declarant , Prenom_Declarant",
					declarant_View.getTable());
			declarant_View.setChampsVides();
		} catch (ExisteOrNot_Exception e1) {declarant_View.getBtn_Supprimer().setEnabled(false);}
	}


	public void Modifier() {
		try {
			declarant_View.Test();
			declarant = declarant_View.RowToObject();
			declarant.Modifier(declarant_View.getInformations());
			Utile.UpdateTable("select Nom_Declarant as Nom, Prenom_Declarant as Prenom, Phone_Declarant as Mobile from declarant order by Nom_Declarant , Prenom_Declarant",
					declarant_View.getTable());
			declarant_View.setChampsVides();

			JComboBox<String> combo = new JComboBox<String>();
			Utile.remplirCombo(combo, "declarant", "Nom_Declarant");
			BonVisite_View.ComboDeclarant.setModel(combo.getModel());
		}
		catch (OverInderSize_Exception e3) {declarant_View.getBtn_Modifier().setEnabled(false);}
		catch (NoLettersOrNoDigital_Exception e4) {declarant_View.getBtn_Modifier().setEnabled(false);}
		catch (ExisteOrNot_Exception e1) {declarant_View.getBtn_Modifier().setEnabled(false);}
	}

}

