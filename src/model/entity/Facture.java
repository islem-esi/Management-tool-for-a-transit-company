package model.entity;

import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DBHelper;

public class Facture {
	// ------------------- Les déclarations  -----------------------//

	private int IdDossier;
	private Date Date_Facture;
	private float THT;
	private float Debours;
	private float TVA;
	private float TTC;
	private String TTC_Lettre;

	// -------------------------- Le constructeur --------------------------//

	public Facture(float tHT, float debours, float tVA, float tTC,
		String tTC_Lettre) {
		THT = tHT;
		Debours = debours;
		TVA = tVA;
		TTC = tTC;
		TTC_Lettre = tTC_Lettre;
	}

	// -------------------------- Les methodes --------------------------//

	public void SetFacture_info(int id) {

		String sql = "SELECT * FROM facture WHERE idDossier='" + id + "';";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if ((DBHelper.getResultSet().next())) {
				IdDossier = id;
				 Date_Facture=DBHelper.getResultSet().getDate("Date_Facture");
				 THT=DBHelper.getResultSet().getFloat("THT");
				 Debours=DBHelper.getResultSet().getFloat("Debours");
				 TVA=DBHelper.getResultSet().getFloat("TVA");
				 TTC=DBHelper.getResultSet().getFloat("TTC");;
				 TTC_Lettre=DBHelper.getResultSet().getString("TTC_Lettre");;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// -------------------------- Les methodes --------------------------//

	public Facture(int idDossier) {
		IdDossier=idDossier;
		}

	//*************************************************************//

	static public void Insert_Facture(int IdDossier, Facture fact) {

		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		String sql = " insert into Facture (idDossier,Date_Facture," + "THT,Debours,TVA,TTC,TTC_Lettre)"
				+ "values (? , ? , ? , ? , ? , ? , ? ) ";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setInt(1, IdDossier);
			DBHelper.getPreparedStatement().setTimestamp(2, date);
			DBHelper.getPreparedStatement().setFloat(3, fact.getTHT());
			DBHelper.getPreparedStatement().setFloat(4, fact.getDebours());
			DBHelper.getPreparedStatement().setFloat(5, fact.getTVA());
			DBHelper.getPreparedStatement().setFloat(6, fact.getTTC());
			DBHelper.getPreparedStatement().setString(7, fact.getTTC_Lettre());
			DBHelper.getPreparedStatement().execute();
			JOptionPane.showMessageDialog(null, "Facture ajouté avec succèes");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//*************************************************************//

	public boolean existes() {
		boolean res = false;
		String sql = "SELECT * FROM facture WHERE idDossier=?";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setInt(1, IdDossier);
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if (DBHelper.getResultSet().isBeforeFirst()) { // checking if the result
				res = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	// ----------------------- Les getters & setters ------------------------//

	public int getIdDossier() {
		return IdDossier;
	}

	public Date getDate_Facture() {
		return Date_Facture;
	}

	public float getTTC() {
		return TTC;
	}

	public float getTHT() {
		return THT;
	}

	public float getDebours() {
		return Debours;
	}

	public float getTVA() {
		return TVA;
	}

	public String getTTC_Lettre() {
		return TTC_Lettre;
	}

}
