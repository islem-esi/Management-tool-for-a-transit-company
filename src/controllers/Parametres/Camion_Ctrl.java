package controllers.Parametres;

import javax.swing.JComboBox;
import model.entity.Camion;
import model.entity.ExisteOrNot_Exception;
import model.Utile;
import view.BonSortie_View;
import view.Parametres_View.Camion_View;
import view.Parametres_View.NoLettersOrNoDigital_Exception;
import view.Parametres_View.OverInderSize_Exception;

public class Camion_Ctrl implements Parametre_Ctrl {

	// ********************* Les variables d'instance *********************//
	private Camion camion;
	private Camion_View camion_View;

	// ********************* Le constructeur *********************//

	public Camion_Ctrl() {
		initView();
		Utile.UpdateTable("select Matricule from Camion order by Matricule ", camion_View.getTable());
		camion_View.getBtn_Ajout().addActionListener(e -> Ajouter());
		camion_View.getBtn_Supprimer().addActionListener(e -> Supprimer());
		camion_View.getBtn_Modifier().addActionListener(e ->Modifier());
	}

	// ******************** Les methodes ***********************//

	// Role: initialise la fenètre du paramètre de camion

	public void initView() {
		camion_View = new Camion_View();
		camion_View.enableAll(false);
	}

	// Role: ajoute un camion(sa matr) à la base de données

	public void Ajouter() {
		try{
			camion_View.Test();
			camion = camion_View.getInformations();
			camion.Ajouter();
			Utile.UpdateTable("select Matricule from Camion order by Matricule", camion_View.getTable());
			camion_View.setChampsVides();
			JComboBox combo = new JComboBox();
			Utile.remplirCombo(combo, "Camion", "Matricule");
			BonSortie_View.comboBoxCamion.setModel(combo.getModel());

		}
		catch (OverInderSize_Exception e3){camion_View.getBtn_Ajout().setEnabled(false);}
		catch (NoLettersOrNoDigital_Exception e4){camion_View.getBtn_Ajout().setEnabled(false);}
		catch (ExisteOrNot_Exception e1){camion_View.getBtn_Ajout().setEnabled(false);}
	}

	// Role: supprime un camion(sa mart) de la base de données

	public void Supprimer() {
		try{
			camion = camion_View.getInformations();
			camion.Supprimer();
			Utile.UpdateTable("select Matricule from Camion order by Matricule", camion_View.getTable());
			camion_View.setChampsVides();
			JComboBox<String> combo = new JComboBox<String>();
			Utile.remplirCombo(combo, "Camion", "Matricule");
			BonSortie_View.comboBoxCamion.setModel(combo.getModel());
		}
		catch (ExisteOrNot_Exception e1){camion_View.getBtn_Supprimer().setEnabled(false);}
	}

	// Role : modifie un camion déja enregistré dans la BD
	public void Modifier() {
		try{
			camion_View.Test();
			camion = camion_View.RowToObject();
			camion.Modifier(camion_View.getInformations());
			Utile.UpdateTable("select Matricule from Camion order by Matricule", camion_View.getTable());
			camion_View.setChampsVides();
		}
		catch (OverInderSize_Exception e3){camion_View.getBtn_Modifier().setEnabled(false);}
		catch (NoLettersOrNoDigital_Exception e4){camion_View.getBtn_Modifier().setEnabled(false);}
		catch (ExisteOrNot_Exception e1){camion_View.getBtn_Modifier().setEnabled(false);}
	}

}
