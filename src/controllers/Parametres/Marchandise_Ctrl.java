package controllers.Parametres;

import javax.swing.JComboBox;
import model.entity.ExisteOrNot_Exception;
import model.entity.Marchandise;
import model.Utile;
import view.Dossier_Form_View;
import view.Parametres_View.Marchandise_View;
import view.Parametres_View.OverInderSize_Exception;

public class Marchandise_Ctrl implements Parametre_Ctrl {

	// ********************* Les variables d'instance *********************//
	private Marchandise marchandise;
	private Marchandise_View marchandise_View;

	// ********************* Le constructeur *********************//
	public Marchandise_Ctrl() {
		initView();
		Utile.UpdateTable("select Type_Marchandise as Type from Type_Marchandise order by Type_Marchandise",
				marchandise_View.getTable());
		marchandise_View.getBtn_ajouter().addActionListener(e -> Ajouter());
		marchandise_View.getBtn_supprimer().addActionListener(e -> Supprimer());
		marchandise_View.getBtn_modifier().addActionListener(e -> Modifier());
	}

	// ******************** Les methodes ***********************//

	// Role: initialise la fenètre du paramètre de camion

	public void initView() {
		marchandise_View = new Marchandise_View();
		marchandise_View.enableAll(false);
	}

	// Role: ajoute un type de marchandise à BD
	public void Ajouter() {
		try {
			marchandise_View.Test();
			marchandise = marchandise_View.getInformations();
			marchandise.Ajouter();
			Utile.UpdateTable("select Type_Marchandise as Type from Type_Marchandise order by Type_Marchandise",
					marchandise_View.getTable());
			marchandise_View.setChampsVides();
			JComboBox<String> combo = new JComboBox<String>();
			Utile.remplirComboNoId(combo, "type_marchandise", "Type_Marchandise");
			Dossier_Form_View.comboTypeMarch.setModel(combo.getModel());
		}
		catch (OverInderSize_Exception e3) { marchandise_View.getBtn_ajouter().setEnabled(false);}
		catch (ExisteOrNot_Exception e1) { marchandise_View.getBtn_ajouter().setEnabled(false);}
	}

	// Role: supprime un type de marchandise de la BD
	public void Supprimer() {
		try {
			marchandise = marchandise_View.getInformations();
			marchandise.Supprimer();
			Utile.UpdateTable("select Type_Marchandise as Type from Type_Marchandise order by Type_Marchandise",
					marchandise_View.getTable());
			marchandise_View.setChampsVides();
		} catch (ExisteOrNot_Exception e1) { marchandise_View.getBtn_supprimer().setEnabled(false);}
	}

	// Role : modifie un type de conteneur déja enregistré dans la BD
	public void Modifier() {
		try {
			marchandise_View.Test();
			marchandise = marchandise_View.RowToObject();
			marchandise.Modifier(marchandise_View.getInformations());
			Utile.UpdateTable("select Type_Marchandise as Type from Type_Marchandise order by Type_Marchandise",
					marchandise_View.getTable());
			marchandise_View.setChampsVides();
		}
		catch (OverInderSize_Exception e3) {marchandise_View.getBtn_modifier().setEnabled(false);}
		catch (ExisteOrNot_Exception e1) {marchandise_View.getBtn_modifier().setEnabled(false);}
	}

}
