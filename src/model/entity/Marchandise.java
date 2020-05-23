package model.entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ConfigSQL;

public class Marchandise {

	// ********************* Les variables d'instance *********************//

	private String typeMarchandise;
	private Connection cnx = null;
	private java.sql.PreparedStatement stat = null;
	private ResultSet rest = null;
	private String sql;

	// ********************* Le constructeur *********************//

	public Marchandise(String march) {
		this.typeMarchandise = march;
		cnx = ConfigSQL.getConnection();
	}

	// ********************* Les getters & setters *********************//
	public String getTypeMarchandise() {
		return typeMarchandise;
	}

	// ******************** Les methodes ***********************//

	// Role: cherche une marchandise dans le tableau Marchandise
	public boolean Rechercher() {
		sql = "select Type_Marchandise from Type_Marchandise where Type_Marchandise = ?";
		boolean trouve = false;
		try {
			stat = cnx.prepareStatement(sql);
			stat.setString(1, this.typeMarchandise);
			rest = stat.executeQuery();
			if (rest.next()) {
				trouve = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trouve;
	}

	// Role: ajoute une marchandise à la BD

	public void Ajouter() throws ExisteOrNot_Exception {

		boolean trouve = Rechercher();
		if (trouve)
			throw new ExisteOrNot_Exception(" Ce type de marchandise est déja enregistré ! ");
		else {
			sql = "INSERT INTO Type_Marchandise(Type_Marchandise) VALUES(?)";
			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, this.typeMarchandise);
				stat.execute();
				JOptionPane.showMessageDialog(null, " Le type de marchandise est ajouté ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Role: supprime une marchandise du tableau des Marchandises
	public void Supprimer() throws ExisteOrNot_Exception {
		boolean trouve = Rechercher();
		if (!trouve)
			throw new ExisteOrNot_Exception(" Ce type de marchandise n'est pas enregistré ! ");
		else {

			sql = "delete from Type_Marchandise where Type_Marchandise = ?";
			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, this.typeMarchandise);
				stat.execute();
				JOptionPane.showMessageDialog(null, " Le type de marchandise est supprimé ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Role: modifie un type de marchandise déja enregistré dans la BD
	public void Modifier(Object obj) throws ExisteOrNot_Exception {
		Marchandise march;
		march = (Marchandise) obj;
		boolean trouve = false;
		trouve = Rechercher();
		if (!trouve)
			throw new ExisteOrNot_Exception(" Ce type de marchandise n'est pas enregistré ! ");
		else {
			sql = "update Type_Marchandise set Type_Marchandise = ? where Type_Marchandise = ?";
			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, march.getTypeMarchandise());
				stat.setString(2, this.typeMarchandise);
				stat.execute();
				JOptionPane.showMessageDialog(null, " Le type da marchandise est modifié ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}