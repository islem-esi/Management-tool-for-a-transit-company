package view.Parametres_View;

import javax.swing.JOptionPane;

public class AjoutStopedException extends Exception{

	private static final long serialVersionUID = 1L;

	public AjoutStopedException(String message){
		super(message);
		JOptionPane.showMessageDialog(null,message);
	}
}
