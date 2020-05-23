package controllers.Parametres;
import model.entity.Info;
import view.Parametres_View.EntrepriseInfo_View;

public class Info_Ctrl {

    // ********************* Les variables d'instance *********************//
    private EntrepriseInfo_View entrepriseInfo_View;

    // ************************** Le constructeur *************************//

    public Info_Ctrl() {
        initView();
        entrepriseInfo_View.getBtnMisAjour().addActionListener(e -> MisAjour());
    }
    // *********************** Les methodes ***************************//

    public void initView() {    // Role: initialise la fenètre
    	Info info=new Info();
        entrepriseInfo_View = new EntrepriseInfo_View();
        entrepriseInfo_View.frame.setVisible(true);
        entrepriseInfo_View.SetInfo(info.RecupereInfo());
    }

	//*************************************************************//

    public void MisAjour(){
    	Info info=new Info();
    	info.Update_Info(entrepriseInfo_View.recuperInfo());
    }



}
