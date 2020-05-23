package controllers;

import java.io.IOException;

import controllers.Parametres.Historique_Ctrl;
import model.entity.Designation;
import view.Menu_View;
import view.View;

public class Menu_Ctrl {

	// ------------------- Les variables d'instance et déclarations  -----------------------//
	private Menu_View menu_view;
	private View view;
	// -------------------------- Le constructeur --------------------------//
	public Menu_Ctrl(View view) {
		this.view = view;
		initController();
	}
	// -------------------------- Les methodes --------------------------//
	public void initController() {
		initView();
		menu_view.getClient_btn().addActionListener(e -> client());
		menu_view.getDecon_btn().addActionListener(e -> deconect());
		menu_view.getDossier_btn().addActionListener(e -> dossier());
		menu_view.getParam_btn().addActionListener(e -> param());
		menu_view.getAide_btn().addActionListener(e -> aide());
		menu_view.getStat_btn().addActionListener(e -> state());
		menu_view.getBtnDtails().addActionListener(e -> details());
	}
	//*************************************************************//
	public void initView() {
		menu_view = new Menu_View();
		if (Login_Ctrl.IdUser == 2) {
			menu_view.getStat_btn().setVisible(false);
		}
		view.setContentPane(menu_view.getContentPane());
		view.setVisible(true);
	}
	//*************************************************************//
	private void client() {
		new Client_Ctrl(View.GetView());
	}
	//*************************************************************//
	private void param() {
		new Parametre_Ctrl(View.GetView());
	}
	//*************************************************************//
	private void aide() {
		try {
			Runtime.getRuntime().exec("hh.exe aide/Gestion_de_facturation.chm");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//*************************************************************//
	private void state() {
		new Statistique_Ctrl(View.GetView());
	}
	//*************************************************************//
	private void deconect() {
		new Login_Ctrl(View.GetView());
	}
	//*************************************************************//
	private void dossier() {
		new Dossier_Ctrl(View.GetView());
	}
	//*************************************************************//
	private void details() {
		Historique_Ctrl historique_Ctrl = new Historique_Ctrl();
		historique_Ctrl.detail();
		menu_view.attention.setVisible(false);
		menu_view.btnDtails.setVisible(false);
		menu_view.lblIlExisteDes.setVisible(false);
		Designation.consulte();
	}
	//*************************************************************//
}