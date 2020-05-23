package model.entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.ConfigSQL;

public class Conteneur {
	// ********************* Les variables d'instance *********************//

	private int idConteneur = 0;
	private String typeConteneur;
	private java.sql.PreparedStatement stat = null;
	private Connection cnx = null;
	private ResultSet rest = null;
	private String sql;

	// ********************* Le constructeur *********************//

	public Conteneur(String conteneur){
		this.typeConteneur = conteneur;
		cnx = ConfigSQL.getConnection();
	}

	// ********************* Les getters & setters *********************//

	public String getTypeConteneur() {
		return typeConteneur;
	}

	// ******************** Les methodes ***********************//

	// Role: cherche un conteneur dans le tableau Type_Conteneur et venvoit true si
	// il existe

	public boolean Rechercher() {
		sql = "select * from Type_Conteneur where Type_Conteneurcol = ?";
		boolean trouve = false;
		try {
			stat = cnx.prepareStatement(sql);
			stat.setString(1, this.typeConteneur);
			rest = stat.executeQuery();
			if (rest.next()) {
				idConteneur = rest.getInt("idType_Conteneur");
				trouve = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trouve;
	}

	// Role: ajoute un type de conteneur

		public void Ajouter() throws ExisteOrNot_Exception {// paramertre string typec

		boolean trouve = Rechercher();
		if(trouve)
			throw new ExisteOrNot_Exception(" Ce type de conteneur est déja enregistré ! ");
		else{
			sql = "INSERT INTO Type_Conteneur(Type_Conteneurcol) VALUES(?)";
			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, this.typeConteneur);
				stat.execute();
				JOptionPane.showMessageDialog(null, "Le type de conteneur est ajouté");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Role: supprime un conteneur du tableau des conteneur
	public void Supprimer() throws ExisteOrNot_Exception {
		boolean trouve = Rechercher();
		if(!trouve)
			throw new ExisteOrNot_Exception(" Ce type de conteneur n'est pas enregistré ! ");
		else{
			sql = "delete from  Type_Conteneur where  idType_Conteneur = ?";
			try {
				stat = cnx.prepareStatement(sql);
				stat.setInt(1, idConteneur);
				stat.execute();
				JOptionPane.showMessageDialog(null, " Le type de conteneur est supprimé ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Role: modifie un type de conteneur
	public void Modifier(Object obj) throws ExisteOrNot_Exception{
		Conteneur conteneur;
		conteneur = (Conteneur) obj;
		boolean trouve = false;
		trouve = Rechercher();
		if (!trouve)
			throw new ExisteOrNot_Exception(" Ce type de conteneur n'est pas enregistré ! ");
		else {
			sql = "update Type_Conteneur set Type_Conteneurcol = ? where Type_Conteneurcol = ?";
			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1,conteneur.getTypeConteneur());
				stat.setString(2, this.typeConteneur);
				stat.execute();
				JOptionPane.showMessageDialog(null, " Le type de conteneur est modifiée ");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
