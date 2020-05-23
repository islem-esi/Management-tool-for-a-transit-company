package model.entity;

import java.sql.Date;
import java.sql.SQLException;

import model.DBHelper;
import model.Utile;
import model.entity.Abstract.Bon;

public class BonVisite extends Bon {

	// -------------------------- Les constructeurs --------------------------//

	public BonVisite() {}
	// -------------------------------------------------------//
	public BonVisite(int idDossier, Date date_Bon_Sortie, String transit, int idDeclarant,String Declarant, String agentDouane) {
		super(idDossier, date_Bon_Sortie, transit, idDeclarant, agentDouane);
		super.Declarant=Declarant;
	}
	// -------------------------------------------------------//
	public BonVisite(int id) {

		String sql = "SELECT * FROM bon_visite WHERE idDossier='" + id + "';";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if ((DBHelper.getResultSet().next())) {
				IdDossier = id;
				IdDeclarant = DBHelper.getResultSet().getInt("idDeclarant");
				Transit = DBHelper.getResultSet().getString("Transit");
				AgentDouane = DBHelper.getResultSet().getString("AgentDouane");
				Date_Bon = DBHelper.getResultSet().getDate("Date_Bon_Visite");
			}
			Declarant = Utile.GetDeclarantById(IdDossier);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
