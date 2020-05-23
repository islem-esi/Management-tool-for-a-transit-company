package model.entity.Abstract;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DBHelper;
import model.Utile;

public abstract class Personne {

	// ------------------- Les déclarations  -----------------------//

	private int Id;
	private String Nom;
	private String Prenom;
	private String Phone;

	// -------------------------- Les constructeurs --------------------------//

	public Personne() {
	}
	// -------------------------------------------------------//

	public Personne(String nom, String prenom, String phone) {
		Nom = nom;
		Prenom = prenom;
		Phone = phone;
	}
	// -------------------------------------------------------//

	public Personne(int id, String nom, String prenom, String phone) {
		Id = id;
		Nom = nom;
		Prenom = prenom;
		Phone = phone;
	}

	// -------------------------- Les methodes --------------------------//


	public boolean existes(String nomCol,String prenomCol,String tab){
		boolean res=false;
		String sql="SELECT * FROM "+tab+" WHERE  "+nomCol+"= '"+Nom+"' && "+prenomCol+"='"+Prenom+"';";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if(DBHelper.getResultSet().isBeforeFirst()){
				res=true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	// -------------------------------------------------------//

	public void inserer(String idcol,String nomCol,String prenomCol,String phoneCol,String tab){
		if (Nom.equals(" choisir ...")){
			JOptionPane.showMessageDialog(null,"CE NOM N'EST PAS VALIDE !!");
		}else{
		if (existes(nomCol,prenomCol,tab)){
			JOptionPane.showMessageDialog(null,"IL EXISTE DEJA !!");

		}else{
			String sql="INSERT INTO "+tab+" ("+nomCol+","+prenomCol+","+phoneCol+") "

			+"  VALUES ('"+Nom+"','"+Prenom+"','"+Phone+"');";
			try {
				DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
				DBHelper.getPreparedStatement().execute();

				JOptionPane.showMessageDialog(null," ajouté avec succès");

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		Id=Utile.GetMaxId(tab, idcol);
		}

	}

	// ----------------------- Les getters & setters ------------------------//

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

}
