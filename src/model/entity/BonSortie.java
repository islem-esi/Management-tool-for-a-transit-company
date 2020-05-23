package model.entity;

import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DBHelper;
import model.Utile;
import model.entity.Abstract.Bon;

public class BonSortie extends Bon {

	// -------------------------- Les constructeurs --------------------------//

	public BonSortie() {}
	// -------------------------------------------------------//
	public BonSortie(int idDossier, Date date_Bon_Sortie, String transit, int idDeclarant, String agentDouane) {
		super(idDossier, date_Bon_Sortie, transit, idDeclarant, agentDouane);
	}
	// -------------------------------------------------------//
	public BonSortie(int id) {

		String sql = "SELECT * FROM bon_sortie WHERE idDossier='" + id + "';";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if ((DBHelper.getResultSet().next())) {
				IdDossier = id;
				IdDeclarant = DBHelper.getResultSet().getInt("idDeclarant");
				Transit = DBHelper.getResultSet().getString("Transit");
				AgentDouane = DBHelper.getResultSet().getString("AgentDouane");
				Date_Bon = DBHelper.getResultSet().getDate("Date_Bon_Sortie");
			}
			Declarant = Utile.GetDeclarantById(IdDossier);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	// -------------------------- Les methodes --------------------------//
	public boolean existes(String tab) {
		boolean res = false;
		String sql = "SELECT * FROM " + tab + " WHERE  idDossier= " + IdDossier + ";";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));

			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if (DBHelper.getResultSet().isBeforeFirst()) {
				res = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	//*************************************************************//

	public void inserer(String tab) {

		if (existes(tab)) {

			JOptionPane.showMessageDialog(null, "CE BON EXISTE DEJA");
		} else {
			String sql = "INSERT INTO " + tab + "(idDossier,Date_Bon_Sortie,idDeclarant,AgentDouane,Transit)"

					+ "  VALUES ('" + IdDossier + "',now()," + IdDeclarant + ",'" + AgentDouane + "','" + Transit
					+ "');";
			try {
				DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
				DBHelper.getPreparedStatement().execute();
				JOptionPane.showMessageDialog(null, "Bon ajouté avec succès");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
