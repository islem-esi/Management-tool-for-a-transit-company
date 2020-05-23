package controllers.Parametres;

import view.Parametres_View.MotDePass;

public class MotDePass_Ctrl {

	// ********************* Les variables d'instance *********************//

	private String password = "";
	private MotDePass motdepass;
	// ********************* Le constructeur *********************//

	public MotDePass_Ctrl(){
		intView();
	}
	// ********************* Les getters & setters *********************//

	public String getPassword() {
		return password;
	}

	public MotDePass getMotdepass() {
		return motdepass;
	}


	// ********************* Les methodes ***********************//

	public void setPassword(String password) {
		this.password = password;
	}

	public void intView(){
		motdepass = new MotDePass(null,"Mot de passe",true,this);
		motdepass.getBtnOk().setEnabled(false);
	}

}
