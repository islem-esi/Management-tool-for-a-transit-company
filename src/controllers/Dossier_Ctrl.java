package controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import model.Utile;
import model.entity.BonSortie;
import model.entity.BonVisite;
import model.entity.Dossier;
import view.Dossier_View;
import view.View;

public class Dossier_Ctrl {
	// ------------------- Les variables d'instance et déclarations  -----------------------//
	private Dossier_View dossier_view;
	private View view;
	private int idDossier = -1;
	int IdSelected;
	// -------------------------- Le constructeur --------------------------//
	public Dossier_Ctrl(View view) {
		this.view = view;
		initController();
	}
	// -------------------------- Les methodes --------------------------//
	public void initController() {
		initView();
		dossier_view.getBtn_Ajouter_Dos().addActionListener(e -> Ajouter_Dossier());
		dossier_view.getBtn_Visite().addActionListener(e -> Bon_Visite());
		dossier_view.getBtn_Sortie().addActionListener(e -> Bon_Sortie());
		dossier_view.getBtn_Facture().addActionListener(e -> Facture());
		dossier_view.getReturne().addActionListener(e -> returne());
		dossier_view.getRech_field().addKeyListener(KeyRech);
		dossier_view.getTable().addMouseListener(RowSelected);
	}
	//*************************************************************//
	public void initView() {
		dossier_view = new Dossier_View();
		view.setContentPane(dossier_view.getContentPane());
		view.setVisible(true);
		Utile.UpdateTable(Utile.Dossier_Sql, dossier_view.getTable());
		dossier_view.SetSizeColumn();
	}
	//*************************************************************//
	KeyAdapter KeyRech = new KeyAdapter() {
		public void keyReleased(java.awt.event.KeyEvent evt) {
			Dossier.Rech_Dossier_nom(dossier_view.getRech_field().getText().toString(), dossier_view.getTable());
			dossier_view.SetSizeColumn();
		}
	};
	//*************************************************************//
	MouseAdapter RowSelected = new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
			int ligne = dossier_view.getTable().getSelectedRow();

			IdSelected = new Integer(dossier_view.getTable().getModel().getValueAt(ligne, 0).toString()).intValue();
			idDossier = IdSelected;
		}
	};
	//*************************************************************//
	private void Ajouter_Dossier() {
		new Dossier_Form_Ctrl(view);
	}
	//*************************************************************//
	private void Bon_Visite() {
		if (idDossier == -1) {
			JOptionPane.showMessageDialog(null, "Veuilliez selectionner un dossier !");
		} else {
			BonVisite bon = new BonVisite();
			bon.setIdDossier(idDossier);
			BonVisite_Ctrl bonVisite_Ctrl = new BonVisite_Ctrl(view);
			bonVisite_Ctrl.setIdDossier(idDossier);
			bonVisite_Ctrl.getBon().setIdDossier(idDossier);
			bonVisite_Ctrl.upDate();
			Dossier dossier = new Dossier(idDossier);
			bonVisite_Ctrl.setDossier(dossier);
			bonVisite_Ctrl.getBonVisite_View().afficherDossier(dossier);
		}
	}
	//*************************************************************//
	private void Bon_Sortie() {

		if (idDossier == -1) {
			JOptionPane.showMessageDialog(null, "Veuilliez selectionner un dossier !");
		} else {
			BonVisite bon_visite = new BonVisite(idDossier);
			if (bon_visite.existes("bon_visite")) {
				BonSortie_Ctrl bonSortie_Ctrl = new BonSortie_Ctrl(view, bon_visite);
				bonSortie_Ctrl.setIdDossier(idDossier);
				bonSortie_Ctrl.upDate();
				Dossier dossier = new Dossier(idDossier);
				bonSortie_Ctrl.setDossier(dossier);
				bonSortie_Ctrl.getBonSortie().setIdDeclarant(bon_visite.getIdDeclarant());
				bonSortie_Ctrl.getBonSortie().setDeclarant(bon_visite.getDeclarant());
				bonSortie_Ctrl.getBonSortie().setAgentDouane(bon_visite.getAgentDouane());
				bonSortie_Ctrl.getBonSortie().setTransit(bon_visite.getTransit());
				bonSortie_Ctrl.getBonSortie_View().afficherDossier(dossier, bon_visite);
			} else {
				JOptionPane.showMessageDialog(null, "VOUS DEVEZ AJOUTER LE BON DE VISITE D'ABORD ");
			}
		}
	}
	//*************************************************************//
	private void Facture() {
		if (idDossier == -1) {
			JOptionPane.showMessageDialog(null, "Veuilliez selectionner un dossier !");
		} else {
			BonSortie bon_sortie = new BonSortie(idDossier);
			if (bon_sortie.existes("bon_sortie")) {
				Facture_Ctrl facture_ctrl =new Facture_Ctrl(view, idDossier);
				facture_ctrl.upDate();
				new Dossier(idDossier);
			} else {
				JOptionPane.showMessageDialog(null, "VOUS DEVEZ AJOUTER LE BON DE SORTIE D'ABORD ");
			}
		}
	}
	//*************************************************************//
	private void returne() {
		new Menu_Ctrl(view);
	}
	//*************************************************************//
}
