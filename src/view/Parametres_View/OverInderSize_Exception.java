package view.Parametres_View;

import javax.swing.JOptionPane;

public class OverInderSize_Exception extends Exception{

	private static final long serialVersionUID = 1L;

	/************************ le constructeur ***************************/

	public OverInderSize_Exception(String over,String inder, int i){
	if(i == 1)
		JOptionPane.showMessageDialog(null,over);
	if(i == -1)
		JOptionPane.showMessageDialog(null,inder);
	}
}
