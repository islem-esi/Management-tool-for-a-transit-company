package model.entity.Abstract;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DBHelper;
import model.Utile;

public abstract class MultiObjects {

	// ------------------- Les déclarations  -----------------------//

	private int Id;
	private String Description;

	// -------------------------- Les constructeurs --------------------------//

	public MultiObjects() {	}

	// -------------------------------------------------------//

	public MultiObjects(int id, String description) {
		super();
		Id = id;
		Description = description;
	}

	// -------------------------------------------------------//

	public MultiObjects(String description) {
		super();
		Description = description;
	}

	// -------------------------- Les methodes --------------------------//

	public boolean existes(String description,String tab){
		boolean res=false;
		String sql="SELECT * FROM "+tab+" WHERE  "+description+"= '"+Description+"' ;";
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
	public void inserer(String idcol,String description,String tab){
		if (Description.equals(" Choisir ...")){
			JOptionPane.showMessageDialog(null,"CE NOM N'EST PAS VALIDE !!");
		}else{
		if (existes(description,tab)){
			JOptionPane.showMessageDialog(null,"IL EXISTE DEJA !!");

		}else{
			String sql="INSERT INTO "+tab+" ("+description+") "

			+"  VALUES ('"+Description+"');";

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

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
