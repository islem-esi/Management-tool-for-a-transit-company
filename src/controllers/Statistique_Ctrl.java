package controllers;

import view.Statistique_View;
import view.View;

public class Statistique_Ctrl {
	// ------------------- Les variables d'instance et déclarations  -----------------------//
	private Statistique_View stat2_View;
	private View view;
	// -------------------------- Le constructeur --------------------------//
	public Statistique_Ctrl(View view) {
		this.view = view;
		initController();
	}
	// -------------------------- Les methodes --------------------------//
	public void initController() {
		initView();
		stat2_View.getReturne().addActionListener(e -> returne());
	}
	//*************************************************************//
	public void initView() {
		stat2_View = new Statistique_View();
		view.setContentPane(stat2_View.getContentPane());
		view.setVisible(true);
	}
	//*************************************************************//
	private void returne() {
		new Menu_Ctrl(view);
	}

}