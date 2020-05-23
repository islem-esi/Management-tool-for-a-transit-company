package controllers.Parametres;

import model.entity.ExisteOrNot_Exception;
import model.entity.Utilisateur;
import model.Utile;
import view.Parametres_View.*;

public class Utilisateur_Ctrl {

	// ********************* Les variables d'instance *********************//

	private Utilisateur utilisateur;
	private Utilisateur_View utilisateur_View;
	private MotDePass_Ctrl ctrlPassword;

	// ************************** Le constructeur *************************//

	public Utilisateur_Ctrl() {

		initView();
		Utile.UpdateTable("select Nom_Utilisateur as Utilisateur from utilisateur order by Nom_Utilisateur ", Utilisateur_View.getTable());
		Utilisateur_View.getBtn_Ajouter().addActionListener(e -> Ajouter());
		Utilisateur_View.getBtn_Supprimer().addActionListener(e -> Supprimer());
		Utilisateur_View.getBtn_Modifier().addActionListener(e -> Modifier());
	}
	// *********************** Les methodes ***************************//

	// Role: initialise la fenètre du paramètre de chauffeur

	public void initView() {
		utilisateur_View = new Utilisateur_View();
		utilisateur_View.enableAll(false);
	}

	// Role: ajoute un chauffeur à BD
	public void Ajouter() {
		try {
			utilisateur_View.Test();
			String user = utilisateur_View.getNomUtilisateur();
			boolean existe = Utilisateur.Rechercher(user);
			if (existe)
				throw new ExisteOrNot_Exception("Utilisateur existant !");
			ctrlPassword = new MotDePass_Ctrl();
			while (ctrlPassword.getMotdepass().isVisible());
			utilisateur = new Utilisateur(user, ctrlPassword.getPassword());
			utilisateur.Ajouter();
			utilisateur_View.setChampsVides();
			Utile.UpdateTable("select Nom_Utilisateur as Utilisateur from utilisateur order by Nom_Utilisateur", Utilisateur_View.getTable());
		} catch (OverInderSize_Exception e) {
			Utilisateur_View.getBtn_Ajouter().setEnabled(false);
			e.printStackTrace();
		} catch (ExisteOrNot_Exception e) {
			Utilisateur_View.getBtn_Ajouter().setEnabled(false);
			e.printStackTrace();
		} catch (AjoutStopedException e) {
			utilisateur_View.setChampsVides();
			e.printStackTrace();
		}

	}

	// Role: supprime un chauffeur de la BD
	public void Supprimer() {
		try {
			utilisateur = utilisateur_View.getInformations(null);
			utilisateur.Supprimer();
			utilisateur_View.setChampsVides();
			Utile.UpdateTable("select Nom_Utilisateur as Utilisateur from utilisateur order by Nom_Utilisateur", Utilisateur_View.getTable());
		} catch (ExisteOrNot_Exception e) {
			Utilisateur_View.getBtn_Supprimer().setEnabled(false);
			e.printStackTrace();
		}
	}

	// Role : modifie un chauffeur déja enregistré dans la BD
	public void Modifier() {
		String user = utilisateur_View.getNomUtilisateur();
		try {
		utilisateur = utilisateur_View.RowToObject();
		if(!user.equals(utilisateur.getNom_Utilisateur()) && Utilisateur.Rechercher(user))
			throw new ExisteOrNot_Exception("Utilisateur existant !");
		ctrlPassword = new MotDePass_Ctrl();
		while (ctrlPassword.getMotdepass().isVisible());
		utilisateur.Modifier(new Utilisateur(user,ctrlPassword.getPassword()));
		utilisateur_View.setChampsVides();
		Utile.UpdateTable("select Nom_Utilisateur as Utilisateur from utilisateur order by Nom_Utilisateur", Utilisateur_View.getTable());
		} catch (ExisteOrNot_Exception e) {
			Utilisateur_View.getBtn_Modifier().setEnabled(false);
			e.printStackTrace();
		}
	}

}
