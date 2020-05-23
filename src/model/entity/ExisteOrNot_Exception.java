package model.entity;

import javax.swing.JOptionPane;

public class ExisteOrNot_Exception extends Exception{

	private static final long serialVersionUID = 1L;

	// ********************* Le constructeur *********************//
	public ExisteOrNot_Exception(String message){
		super(message);
		JOptionPane.showMessageDialog(null, message);
	}
}
