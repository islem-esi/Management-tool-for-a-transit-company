package controllers;

import controllers.Parametres.Bdd_Ctrl;
import controllers.Parametres.Camion_Ctrl;
import controllers.Parametres.Chauffeur_Ctrl;
import controllers.Parametres.Conteneur_Ctrl;
import controllers.Parametres.Declarant_Ctrl;
import controllers.Parametres.Designation_Ctrl;
import controllers.Parametres.Historique_Ctrl;
import controllers.Parametres.Info_Ctrl;
import controllers.Parametres.Marchandise_Ctrl;
import controllers.Parametres.Utilisateur_Ctrl;
import view.Parametre_View;
import view.View;

public class Parametre_Ctrl {
	// ------------------- Les variables d'instance et déclarations  -----------------------//
	private Parametre_View parametre_View;
	private View view;
	// -------------------------- Le constructeur --------------------------//
	public Parametre_Ctrl(View view) {
		this.view = view;
		initController();
	}
	// -------------------------- Les methodes --------------------------//
	public void initController() {
		initView();
		parametre_View.getBtn_Designation().addActionListener(e -> designation());
		parametre_View.getBtn_Camion().addActionListener(e -> Camion());
		parametre_View.getBtn_Conteneur().addActionListener(e -> Conteneur());
		parametre_View.getBtn_Provenance().addActionListener(e -> Declarant());
		parametre_View.getBtn_Entreprise().addActionListener(e -> Entreprise());
		parametre_View.getBtn_Chauf().addActionListener(e -> Chauf());
		parametre_View.getBtn_Marchandise().addActionListener(e -> Marchandise());
		parametre_View.getBtn_Historique().addActionListener(e -> historique());
		parametre_View.getReturne().addActionListener(e -> returne());
		parametre_View.getBtn_BDD().addActionListener(e -> bdd());
		parametre_View.getBtn_Users().addActionListener(e -> users());
	}
	//*************************************************************//
	public void initView() {
		parametre_View = new Parametre_View();
		view.setContentPane(parametre_View.getContentPane());
		view.setVisible(true);
	}
	//*************************************************************//
	private void returne() {
		new Menu_Ctrl(view);
	}
	//*************************************************************//
	private void designation() {
		new Designation_Ctrl();
	}
	//*************************************************************//
	private void Conteneur() {
		new Conteneur_Ctrl();
	}
	//*************************************************************//
	private void Declarant() {
		new Declarant_Ctrl();
	}
	//*************************************************************//
	private void Entreprise() {
		new Info_Ctrl();
	}
	//*************************************************************//
	private void bdd() {
		new Bdd_Ctrl();
	}
	//*************************************************************//
    private void historique(){
    	new Historique_Ctrl();
    }
	//*************************************************************//
	private void Camion() {
		new Camion_Ctrl();
	}
	//*************************************************************//
	private void Chauf() {
		new Chauffeur_Ctrl();
	}
	//*************************************************************//
	private void Marchandise() {
		new Marchandise_Ctrl();
	}
	//*************************************************************//
	private void users() {
		new Utilisateur_Ctrl();
	}
}