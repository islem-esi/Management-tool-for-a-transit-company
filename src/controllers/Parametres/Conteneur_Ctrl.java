package controllers.Parametres;

import model.entity.Conteneur;
import model.entity.ExisteOrNot_Exception;

import javax.swing.JComboBox;

import model.Utile;
import view.Dossier_Form_View;
import view.Parametres_View.Conteneur_View;
import view.Parametres_View.OverInderSize_Exception;

public class Conteneur_Ctrl implements Parametre_Ctrl{

	// ********************* Les variables d'instance *********************//
	private Conteneur conteneur;
	private Conteneur_View conteneur_View;

	// ********************* Le constructeur *********************//

	public Conteneur_Ctrl() {
		initView();
		Utile.UpdateTable("select  Type_Conteneurcol as Type from Type_Conteneur order by Type_Conteneurcol", conteneur_View.getTable());
		conteneur_View.getBtn_Ajout().addActionListener(e -> Ajouter());
		conteneur_View.getBtn_Supprimer().addActionListener(e -> Supprimer());
		conteneur_View.getBtn_Modifier().addActionListener(e -> Modifier());
	}

	// ******************** Les methodes ***********************//
	// Role: initialise la fenètre du paramètre de conteneur

	public void initView() {
		conteneur_View = new Conteneur_View();
		conteneur_View.enableAll(false);
	}

	// Role: ajoute un type de conteneur à la BD
		public void Ajouter(){
			try{
				conteneur_View.Test();
				conteneur = conteneur_View.getInformations();
				conteneur.Ajouter();
				Utile.UpdateTable("select  Type_Conteneurcol as Type from Type_Conteneur order by Type_Conteneurcol", conteneur_View.getTable());
				conteneur_View.setChampsVides();
				JComboBox<String> combo = new JComboBox<String>();
				Utile.remplirComboNoId(combo, "type_conteneur", "Type_Conteneurcol");
				Dossier_Form_View.comboTypeCont.setModel(combo.getModel());
			}
			catch (OverInderSize_Exception e3){conteneur_View.getBtn_Ajout().setEnabled(false);}
			catch (ExisteOrNot_Exception e1){conteneur_View.getBtn_Ajout().setEnabled(false);}
		}

		// Role: supprime un type de conteneur de la BD
		public void Supprimer(){
			try{
				conteneur = conteneur_View.getInformations();
				conteneur.Supprimer();
				Utile.UpdateTable("select  Type_Conteneurcol as Type from Type_Conteneur order by Type_Conteneurcol", conteneur_View.getTable());
				conteneur_View.setChampsVides();
			}
			catch (ExisteOrNot_Exception e1){conteneur_View.getBtn_Supprimer().setEnabled(false);}
		}

		// Role : modifie un type de conteneur déja enregistré dans la BD
		public void Modifier(){
			try{
				conteneur_View.Test();
				conteneur = conteneur_View.RowToObject();
				conteneur.Modifier(conteneur_View.getInformations());
				Utile.UpdateTable("select  Type_Conteneurcol as Type from Type_Conteneur order by Type_Conteneurcol", conteneur_View.getTable());
				conteneur_View.setChampsVides();
			}
			catch (OverInderSize_Exception e3){conteneur_View.getBtn_Modifier().setEnabled(false);}
			catch (ExisteOrNot_Exception e1){conteneur_View.getBtn_Modifier().setEnabled(false);}
		}

}
