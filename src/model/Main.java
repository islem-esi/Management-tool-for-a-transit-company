package model;

import view.View;
import view.Parametres_View.EntrepriseInfo_View;
import controllers.Login_Ctrl;
import model.entity.Info;

public class Main {

	public static DBHelper db;

	public static void main(String[] args) {

		new View();
		new Login_Ctrl(View.GetView());

		try
		{
			db = new DBHelper();
			Info info = new Info();
			EntrepriseInfo_View entrepriseInfo_View = new EntrepriseInfo_View();
			entrepriseInfo_View.SetInfo_Home(info.RecupereInfo());
		}catch (Exception e) {
		}
	}

}