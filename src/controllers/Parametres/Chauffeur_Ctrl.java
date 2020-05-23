package controllers.Parametres;

import javax.swing.JComboBox;

import model.entity.Chauffeur;
import model.entity.ExisteOrNot_Exception;
import model.Utile;
import view.BonSortie_View;
import view.Parametres_View.Chauffeur_View;
import view.Parametres_View.NoLettersOrNoDigital_Exception;
import view.Parametres_View.OverInderSize_Exception;

public class Chauffeur_Ctrl implements Parametre_Ctrl{

	// ********************* Les variables d'instance *********************//

	private Chauffeur chauffeur;
	private Chauffeur_View chauffeur_View;

	// ************************** Le constructeur *************************//

	public Chauffeur_Ctrl() {

		initView();
		Utile.UpdateTable(
				"select Nom_Chauffeur as Nom, Prenom_Chauffeur as Prenom, Phone_Chauffeur as Mobile from Chauffeur order by Nom_Chauffeur , Prenom_Chauffeur",
				chauffeur_View.getTable());
		chauffeur_View.getBtn_Ajouter().addActionListener(e -> Ajouter());
		chauffeur_View.getBtn_Supprimer().addActionListener(e -> Supprimer());
		chauffeur_View.getBtn_Modifier().addActionListener(e -> Modifier());
	}
	// *********************** Les methodes ***************************//

	// Role: initialise la fenètre du paramètre de chauffeur

	public void initView() {
		chauffeur_View = new Chauffeur_View();
		chauffeur_View.enableAll(false);
	}

	// Role: ajoute un chauffeur à BD
	public void Ajouter(){
		try{
			chauffeur_View.Test();
			chauffeur = chauffeur_View.getInformations();
			chauffeur.Ajouter();
			Utile.UpdateTable(
					"select Nom_Chauffeur as Nom, Prenom_Chauffeur as Prenom, Phone_Chauffeur as Mobile from Chauffeur order by Nom_Chauffeur , Prenom_Chauffeur",
					chauffeur_View.getTable());
			chauffeur_View.setChampsVides();

			JComboBox<String> combo = new JComboBox<String>();
			Utile.remplirCombo(combo, "Chauffeur", "Nom_Chauffeur");
			BonSortie_View.comboBoxChauffeur.setModel(combo.getModel());

		}
		catch (OverInderSize_Exception e3){chauffeur_View.getBtn_Ajouter().setEnabled(false);}
		catch (NoLettersOrNoDigital_Exception e4){chauffeur_View.getBtn_Ajouter().setEnabled(false);}
		catch (ExisteOrNot_Exception e1){chauffeur_View.getBtn_Ajouter().setEnabled(false);}
	}

	// Role: supprime un chauffeur de la BD
	public void Supprimer(){
		try{
			chauffeur = chauffeur_View.getInformations();
			chauffeur.Supprimer();
			Utile.UpdateTable(
					"select Nom_Chauffeur as Nom, Prenom_Chauffeur as Prenom, Phone_Chauffeur as Mobile from Chauffeur order by Nom_Chauffeur , Prenom_Chauffeur",
					chauffeur_View.getTable());
			chauffeur_View.setChampsVides();
			JComboBox<String> combo = new JComboBox<String>();
			Utile.remplirCombo(combo, "Chauffeur", "Nom_Chauffeur");
			BonSortie_View.comboBoxChauffeur.setModel(combo.getModel());
		}
		catch (ExisteOrNot_Exception e1){chauffeur_View.getBtn_Supprimer().setEnabled(false);}
	}

	// Role : modifie un chauffeur déja enregistré dans la BD
	public void Modifier(){
		try{
			chauffeur_View.Test();
			chauffeur = chauffeur_View.RowToObject();
			chauffeur.Modifier(chauffeur_View.getInformations());
			Utile.UpdateTable(
					"select Nom_Chauffeur as Nom, Prenom_Chauffeur as Prenom, Phone_Chauffeur as Mobile from Chauffeur order by Nom_Chauffeur , Prenom_Chauffeur ",
					chauffeur_View.getTable());
			chauffeur_View.setChampsVides();
		}
		catch (OverInderSize_Exception e3){chauffeur_View.getBtn_Modifier().setEnabled(false);}
		catch (NoLettersOrNoDigital_Exception e4){chauffeur_View.getBtn_Modifier().setEnabled(false);}
		catch (ExisteOrNot_Exception e1){chauffeur_View.getBtn_Modifier().setEnabled(false);}
	}
}
