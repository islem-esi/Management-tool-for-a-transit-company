package view.Parametres_View;

import javax.swing.JOptionPane;

public class SelectedRow_Exception extends Exception{
		private static final long serialVersionUID = 1L;

	/************************ le constructeur ***************************/
	public SelectedRow_Exception(int size,String message){
		if (size>0)
			JOptionPane.showMessageDialog(null,message);
		else
			JOptionPane.showMessageDialog(null,"Le tableau est vide !");
	}
}
