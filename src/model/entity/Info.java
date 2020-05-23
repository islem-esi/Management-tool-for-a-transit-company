package model.entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DBHelper;
import view.Parametres_View.EntrepriseInfo_View;

public class Info {

	// ********************* Les variables d'instance *********************//
	private static String Nom;
	private static String Adresse;
	private static String RC;
	private static String NIF;
	private static String NIS;
	private static String Capitale;
	private static String FAX;
	private static String Mobile;
	private static String Email;
	private static String Entete;
	private byte[] imgEntete;

	// ********************* Les constructeurs *********************//
	public Info(){}

	//*************************************************************//

	public Info(String nom, String adresse, String rC, String nIF, String nIS, String capitale, String fAX,
			String mobile, String email, String entete) {
		Nom = nom;
		Adresse = adresse;
		RC = rC;
		NIF = nIF;
		NIS = nIS;
		Capitale = capitale;
		FAX = fAX;
		Mobile = mobile;
		Email = email;
		Entete = entete;
	}

	// ******************** Les methodes ***********************//

	public Info RecupereInfo() {
		Info info=new Info() ;
		String sql = "Select * from info where id=1";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect()
					.prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement()
					.executeQuery());

			while (DBHelper.getResultSet().next()) {

				info.setNom(DBHelper.getResultSet().getString(2));
				info.setAdresse(DBHelper.getResultSet().getString(3));
				info.setRC(DBHelper.getResultSet().getString(4));
				info.setNIF(DBHelper.getResultSet().getString(5));
				info.setNIS(DBHelper.getResultSet().getString(6));
				info.setCapitale(DBHelper.getResultSet().getString(7));
				info.setFAX(DBHelper.getResultSet().getString(8));
				info.setMobile(DBHelper.getResultSet().getString(9));
				info.setEmail(DBHelper.getResultSet().getString(10));
				info.setImgEntete(DBHelper.getResultSet().getBytes(11));
				info.setEntete(DBHelper.getResultSet().getString(12));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return info;
	}

	//*************************************************************//


	public void Update_Info(Info info) {
		String sql = " update Info set Nom= ?, Adresse= ?, RC= ?, NIF= ?, NIS= ?,"
				+ " Capitale= ?, FAX= ?, Mobile= ?, Email= ?, entete= ?, PathEntete= ?"
				+ "where id=1";

		try {

			InputStream imgEntete=new FileInputStream(info.getEntete());

			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setString(1, info.getNom());
			DBHelper.getPreparedStatement().setString(2, info.getAdresse());
			DBHelper.getPreparedStatement().setString(3, info.getRC());
			DBHelper.getPreparedStatement().setString(4, info.getNIF());
			DBHelper.getPreparedStatement().setString(5, info.getNIS());
			DBHelper.getPreparedStatement().setString(6, info.getCapitale());
			DBHelper.getPreparedStatement().setString(7, info.getFAX());
			DBHelper.getPreparedStatement().setString(8, info.getMobile());
			DBHelper.getPreparedStatement().setString(9, info.getEmail());
			DBHelper.getPreparedStatement().setBlob(10, imgEntete);
			DBHelper.getPreparedStatement().setString(11, info.getEntete());

			DBHelper.getPreparedStatement().execute();

			JOptionPane.showMessageDialog(null, "Informations modifiés avec succeès");
			EntrepriseInfo_View.info=info;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ********************* Les getters & setters *********************//

	public String getNom() {
		return Nom;
	}

	public String getAdresse() {
		return Adresse;
	}

	public String getRC() {
		return RC;
	}

	public String getNIF() {
		return NIF;
	}

	public String getNIS() {
		return NIS;
	}

	public String getCapitale() {
		return Capitale;
	}

	public String getFAX() {
		return FAX;
	}

	public String getMobile() {
		return Mobile;
	}

	public String getEmail() {
		return Email;
	}

	public String getEntete() {
		return Entete;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public void setRC(String rC) {
		RC = rC;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public void setNIS(String nIS) {
		NIS = nIS;
	}

	public void setCapitale(String capitale) {
		Capitale = capitale;
	}

	public void setFAX(String fAX) {
		FAX = fAX;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public void setEmail(String email) {
		Email = email;
	}


	public void setEntete(String entete) {
		Entete = entete;
	}


	public byte[] getImgEntete() {
		return imgEntete;
	}


	public void setImgEntete(byte[] imgEntete) {
		this.imgEntete = imgEntete;
	}


}
