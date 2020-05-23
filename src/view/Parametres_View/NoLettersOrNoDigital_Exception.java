package view.Parametres_View;

import javax.swing.JOptionPane;

public class NoLettersOrNoDigital_Exception extends Exception{

	private static final long serialVersionUID = 1L;

	/************************ le constructeur ***************************/
	public NoLettersOrNoDigital_Exception(String message){
		super(message);
		JOptionPane.showMessageDialog(null,message);
	}

}
