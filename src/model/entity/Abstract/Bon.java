package model.entity.Abstract;

import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import model.DBHelper;

public abstract class Bon {

	// ------------------- Les déclarations  -----------------------//

	protected int IdDossier;
	protected Date Date_Bon;
	protected String Transit;
	protected int IdDeclarant;
	protected String Declarant;
	protected String AgentDouane;

	// -------------------------- Les constructeurs --------------------------//

	public Bon() {	}

	// -------------------------------------------------------//

	public Bon(int idDossier, Date date_Bon, String transit, int idDeclarant, String agentDouane) {
		IdDossier = idDossier;
		Date_Bon = date_Bon;
		Transit = transit;
		IdDeclarant = idDeclarant;
		AgentDouane = agentDouane;
	}

	// -------------------------- Les methodes --------------------------//

	public boolean existes(String tab) {
		boolean res = false;
		String sql = "SELECT * FROM " + tab + " WHERE  idDossier= " + IdDossier + ";";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if (DBHelper.getResultSet().isBeforeFirst()) { // checking if the result

				res = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	// -------------------------------------------------------//

	public void inserer(String tab) {

		if (existes(tab)) {

			JOptionPane.showMessageDialog(null, "CE BON EXISTE DEJA");
		} else {
			String sql = "INSERT INTO " + tab + "(idDossier,Date_Bon_Visite,idDeclarant,AgentDouane,Transit)"

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

	// ----------------------- Les getters & setters ------------------------//


	public int getIdDossier() {
		return IdDossier;
	}

	public void setIdDossier(int idDossier) {
		this.IdDossier = idDossier;
	}

	public Date getDate_Bon() {
		return Date_Bon;
	}

	public void setDate_Bon(Date date_Bon) {
		Date_Bon = date_Bon;
	}

	public String getTransit() {
		return Transit;
	}

	public void setTransit(String transit) {
		Transit = transit;
	}

	public int getIdDeclarant() {
		return IdDeclarant;
	}

	public void setIdDeclarant(int idDeclarant) {
		this.IdDeclarant = idDeclarant;
	}

	public String getAgentDouane() {
		return AgentDouane;
	}

	public void setAgentDouane(String agentDouane) {
		AgentDouane = agentDouane;
	}

	public String getDeclarant() {
		return Declarant;
	}

	public void setDeclarant(String declarant) {
		Declarant = declarant;
	}



}
