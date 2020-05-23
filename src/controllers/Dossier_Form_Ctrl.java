package controllers;

import javax.swing.JOptionPane;
import model.Utile;
import model.entity.Client;
import model.entity.Dossier;
import model.entity.Dossier_Conteneur;
import view.Dossier_Form_View;
import view.View;

public class Dossier_Form_Ctrl {
	// ------------------- Les variables d'instance et déclarations  -----------------------//

	private Dossier_Form_View dossier_Form_View;
	private View view;
	// -------------------------- Le constructeur --------------------------//
	public Dossier_Form_Ctrl(View view) {
		this.view = view;
		initController();
	}
	// -------------------------- Les methodes --------------------------//
	public Dossier_Form_Ctrl(View view2, Client client2) {
		this.view = view2;
		initController();
		Dossier_Form_View.SetFicheClient(client2);
	}
	//*************************************************************//
	public void initController() {
		initView();
		dossier_Form_View.getBtnValider().addActionListener(e -> Ajouter_Dossier());
		dossier_Form_View.getBtn_rech().addActionListener(e -> Rech_Client());
		dossier_Form_View.getReturne().addActionListener(e -> returne());
	}
	//*************************************************************//
	public void initView() {
		dossier_Form_View = new Dossier_Form_View();
		view.setContentPane(dossier_Form_View.getContentPane());
		view.setVisible(true);
	}
	//*************************************************************//
	private void Ajouter_Dossier() {
		if (!dossier_Form_View.champVide()) {
			Dossier.Insert_Dossier(dossier_Form_View.RecupereInfo(), dossier_Form_View.NbConteneur);
			Dossier_Conteneur.Insert_Conteneur(Utile.GetMaxId("dossier", "idDossier"), dossier_Form_View.getTable());
		} else
			JOptionPane.showMessageDialog(null, "Veuillez Remplissez les champs vides");
	}
	//*************************************************************//
	private void returne() {
		new Dossier_Ctrl(view);
	}
	//*************************************************************//
	private void Rech_Client() {
		new Add_Dossier_Ctrl(view);
	}
}
