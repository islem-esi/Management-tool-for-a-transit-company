package controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import model.Utile;
import model.entity.Utilisateur;
import view.Login_Viex;
import view.Menu_View;
import view.View;
import view.Theme.Msg;

public class Login_Ctrl {
	// ------------------- Les variables d'instance et déclarations  -----------------------//
	private Login_Viex login_view;
	private View view;
	static public int IdUser;
	// -------------------------- Le constructeur --------------------------//
	public Login_Ctrl(View view) {
		this.view = view;
		initController();
	}
	// -------------------------- Les methodes --------------------------//
	public void initController() {
		initView();
		this.login_view.getLogin_Btn().addActionListener(e -> login2());
		login_view.getPassword_field().addKeyListener(EnterLogin);
		login_view.getUsername_field().addKeyListener(EnterLogin);
	}
	//*************************************************************//
	public void initView() {
		login_view = new Login_Viex();
		view.setContentPane(login_view.getContentPane());
		view.setVisible(true);
	}
	//*************************************************************//
	KeyAdapter EnterLogin = new KeyAdapter() {
		public void keyReleased(java.awt.event.KeyEvent evt) {
			if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
				login2();
			}
		}

	};
	//*************************************************************//
	private void login2() {
		if (!login_view.champVide()) {
			switch (new Utilisateur().Login_user2(login_view.RecupereInfo())) {
			case 0: {
				Msg.Afficher(Msg.CnxError, Msg.IconError, false);
				Utile.Wait(2);
				Msg.CloseMsg();
				login_view.SetChampVide();
			}
				break;
			case 1: {
				IdUser = 1;
				Utile.Wait(2);
				Msg.CloseMsg();
				new Menu_Ctrl(view);
			}
				break;
			case 2: {
				IdUser = 2;
				Utile.Wait(2);
				Msg.CloseMsg();
				Menu_View menu_View = new Menu_View();
				menu_View.getClient_btn().setVisible(false);
				new Menu_Ctrl(view);
			}
				break;
			}
		} else {
			Msg.Afficher(Msg.ChampVide, Msg.IconExclam, false);
			Utile.Wait(2);
			Msg.CloseMsg();
		}
	}

}
