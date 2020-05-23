package model.entity;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import view.View;
import controllers.Dossier_Ctrl;
import model.DBHelper;
import model.Utile;

public class Dossier_Conteneur {

	private int idDossier;
	private int idType_Conteneur;
	private int idTypeMarchandise;
	private String Marque_Conteneur;
	private String Fraude;

	// -------------------------- Les constructeurs --------------------------//
	public Dossier_Conteneur() {}
	// -------------------------------------------------------//
	public Dossier_Conteneur(int idDossier, int idType_Conteneur, int idTypeMarchandise, String marque_Conteneur) {
		this.idDossier = idDossier;
		this.idType_Conteneur = idType_Conteneur;
		this.idTypeMarchandise = idTypeMarchandise;
		Marque_Conteneur = marque_Conteneur;
	}
	// -------------------------------------------------------//
	static public void Insert_Conteneur(int IdDossier, JTable table) {
		String sql = "insert into dossier_conteneur(idDossier,Marque, NoConteneur, NoPlomb,"
				+ "idType_Conteneur,idTypeMarchandise,Poids,Valeur,Fraude)"
				+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int idc = 0, idm = 0;
		for (int i = 0; i < table.getRowCount(); i++) {

			idc = Utile.GetIdByString("idType_Conteneur", "type_conteneur", "Type_Conteneurcol",
					(String) table.getValueAt(i, 3));
			idm = Utile.GetIdByString("idTypeMarchandise", "type_marchandise", "Type_Marchandise",
					(String) table.getValueAt(i, 4));
			try {
				DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
				DBHelper.getPreparedStatement().setLong(1, IdDossier);
				DBHelper.getPreparedStatement().setString(2, (String) table.getValueAt(i, 0));
				DBHelper.getPreparedStatement().setString(3, (String) table.getValueAt(i, 1));
				DBHelper.getPreparedStatement().setString(4, (String) table.getValueAt(i, 2));
				DBHelper.getPreparedStatement().setLong(5, idc);
				DBHelper.getPreparedStatement().setLong(6, idm);
				DBHelper.getPreparedStatement().setString(7, (String) table.getValueAt(i, 5));
				DBHelper.getPreparedStatement().setString(8, (String) table.getValueAt(i, 6));
				DBHelper.getPreparedStatement().setString(9, "LEGALE");
				DBHelper.getPreparedStatement().execute();
				new Dossier_Ctrl(View.GetView());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "il y a un problème , s'il vous plaît essayer à nouveau");
				e.printStackTrace();
			}
		}

	}

	// -------------------------------------------------------//

	static public void Insert_Conteneur2(int IdDossier, JTable table) {
		String sql = "insert into dossier_conteneur(idDossier,idType_Conteneur, idTypeMarchandise, Marque_Conteneur, Fraude)"
				+ " values(?, ?, ?, ?, ?)";
		int idc = 0, idm = 0;
		for (int i = 0; i < table.getRowCount(); i++) {

			idc = Utile.GetIdByString("idType_Conteneur", "type_conteneur", "Type_Conteneurcol",
					(String) table.getValueAt(i, 1));
			idm = Utile.GetIdByString("idTypeMarchandise", "type_marchandise", "Type_Marchandise",
					(String) table.getValueAt(i, 2));
			try {
				DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
				DBHelper.getPreparedStatement().setLong(1, IdDossier);
				DBHelper.getPreparedStatement().setLong(2, idc);
				DBHelper.getPreparedStatement().setLong(3, idm);
				DBHelper.getPreparedStatement().setString(4, (String) table.getValueAt(i, 0));
				DBHelper.getPreparedStatement().setString(5, "non");
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

	public void setIdDossier(int idDossier) {
		this.idDossier = idDossier;
	}

	public int getIdType_Conteneur() {
		return idType_Conteneur;
	}

	public void setIdType_Conteneur(int idType_Conteneur) {
		this.idType_Conteneur = idType_Conteneur;
	}

	public int getIdTypeMarchandise() {
		return idTypeMarchandise;
	}

	public void setIdTypeMarchandise(int idTypeMarchandise) {
		this.idTypeMarchandise = idTypeMarchandise;
	}

	public String getMarque_Conteneur() {
		return Marque_Conteneur;
	}

	public void setMarque_Conteneur(String marque_Conteneur) {
		Marque_Conteneur = marque_Conteneur;
	}

	public String getFraude() {
		return Fraude;
	}

	public void setFraude(String fraude) {
		Fraude = fraude;
	}
}
