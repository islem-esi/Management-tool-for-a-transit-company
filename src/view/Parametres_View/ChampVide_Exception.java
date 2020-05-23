package view.Parametres_View;

import javax.swing.JOptionPane;

public class ChampVide_Exception extends Exception{

	private static final long serialVersionUID = 1L;

	/************************ le constructeur ***************************/
	public ChampVide_Exception(){
		JOptionPane.showMessageDialog(null,"Remplissez les champs vides !");
	}
}
