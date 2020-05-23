package model.entity;

import java.sql.SQLException;
import javax.swing.JTable;
import model.DBHelper;
import model.table.Facture_Model;
import model.table.Facture_Tab;

public class Facture_Designation {

	// ------------------- Les déclarations  -----------------------//

	private static int idDossier;
	private static int idDesignation;
	private static String Designation;
	private static int VOL_QT;
	private static int NBRE;
	private static float PrixUnit;
	private static float PrixHT;
	private static float debour;
	private static String Observation;

	// -------------------------- Les methodes --------------------------//

	public static Facture_Tab RecuperModel(int idDossier) {

		Facture_Tab modele = new Facture_Tab();
		String sql = "select * from Facture_Designation where idDossier=?";
		try {

			DBHelper.setPreparedStatement(DBHelper.getConnect()
					.prepareStatement(sql));
			DBHelper.getPreparedStatement().setInt(1, idDossier);
			DBHelper.setResultSet(DBHelper.getPreparedStatement()
					.executeQuery());

			while (DBHelper.getResultSet().next()) {

				idDesignation = DBHelper.getResultSet().getInt("idDesignation");
				Designation = DBHelper.getResultSet().getString("Designation");
				VOL_QT = DBHelper.getResultSet().getInt("VOL_QT");
				NBRE = DBHelper.getResultSet().getInt("NBRE");
				PrixUnit = DBHelper.getResultSet().getFloat("PrixUnit");
				PrixHT= DBHelper.getResultSet().getFloat("PrixHT");
				debour = DBHelper.getResultSet().getFloat("debour");
				Observation = DBHelper.getResultSet().getString("Observation");
			 modele.addDesignation(new Facture_Model(idDesignation,Designation,VOL_QT,NBRE,PrixUnit,PrixHT,debour,Observation));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return modele;

	}

	//*************************************************************//

	static public void Insert_Facture_Designation(int IdDossier, JTable table) {
		String sql = "insert into Facture_Designation(idDossier,idDesignation,Designation, VOL_QT, NBRE, PrixUnit,PrixHT,debour,Observation)"
				+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		for (int i = 0; i < table.getRowCount(); i++) {

			try {
				DBHelper.setPreparedStatement(DBHelper.getConnect()
						.prepareStatement(sql));
				DBHelper.getPreparedStatement().setInt(1, IdDossier);
				DBHelper.getPreparedStatement().setInt(2,
						(int) table.getValueAt(i, 0));
				DBHelper.getPreparedStatement().setString(3,
						(String) table.getValueAt(i, 1));
				DBHelper.getPreparedStatement().setInt(4,
						(int) table.getValueAt(i, 2));
				DBHelper.getPreparedStatement().setInt(5,
						(int) table.getValueAt(i, 3));
				DBHelper.getPreparedStatement().setFloat(6,
						(float) table.getValueAt(i, 4));
				DBHelper.getPreparedStatement().setFloat(7,
						(float) table.getValueAt(i, 5));
				DBHelper.getPreparedStatement().setFloat(8,
						(float) table.getValueAt(i, 6));
				DBHelper.getPreparedStatement().setString(9,
						(String) table.getValueAt(i, 7));

				DBHelper.getPreparedStatement().execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// ----------------------- Les getters & setters ------------------------//

	public int getIdDossier() {
		return idDossier;
	}

	public int getIdDesignation() {
		return idDesignation;
	}

	@SuppressWarnings("static-access")
	public void setIdDesignation(int idDesignation) {
		this.idDesignation = idDesignation;
	}

	@SuppressWarnings("static-access")
	public void setDebour(float debour) {
		this.debour = debour;
	}

	@SuppressWarnings("static-access")
	public void setIdDossier(int idDossier) {
		this.idDossier = idDossier;
	}

	public int getVOL_QT() {
		return VOL_QT;
	}

	public void setVOL_QT(int vOL_QT) {
		VOL_QT = vOL_QT;
	}

	public int getNBRE() {
		return NBRE;
	}

	public void setNBRE(int nBRE) {
		NBRE = nBRE;
	}

	public float getPrixUnit() {
		return PrixUnit;
	}

	public void setPrixUnit(float prixUnit) {
		PrixUnit = prixUnit;
	}

	public float getDebour() {
		return debour;
	}



}
