package model.entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.ConfigSQL;

public class Declarant {

	// ********************* Les variables d'instance *********************//

	private String nomDeclarant;
	private String prenomDeclarant;
	private String telDeclarant;
	private Connection cnx = null;
	private java.sql.PreparedStatement stat = null;
	private ResultSet rest = null;
	private String sql;

	// ********************* Le constructeur *********************//

	public Declarant(String nom, String prenom, String tel) {

		nomDeclarant = nom;
		prenomDeclarant = prenom;
		telDeclarant = tel;
		cnx = ConfigSQL.getConnection();

	}
	// ********************* Les getters & setters *********************//

	public String getNomDeclarant() {
		return nomDeclarant;
	}

	public String getPrenomDeclarant() {
		return prenomDeclarant;
	}

	public String getTelDeclarant() {
		return telDeclarant;
	}

	// ******************** Les methodes ***********************//

	// Role: recherche un declarant dans la BD
	public boolean Rechercher() {
		sql = "select * from declarant where Nom_Declarant = ? and Prenom_Declarant = ? and Phone_Declarant = ?";
		boolean trouve = false;
		try {
			stat = cnx.prepareStatement(sql);
			stat.setString(1, this.nomDeclarant);
			stat.setString(2, this.prenomDeclarant);
			stat.setString(3, this.telDeclarant);
			rest = stat.executeQuery();
			if (rest.next())
				trouve = true;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		return trouve;
	}

	// Role: ajoute un declarant à la BD
	public void Ajouter() throws ExisteOrNot_Exception {
		boolean trouve = false;
		trouve = Rechercher();
		if (trouve)
			throw new ExisteOrNot_Exception(" Cet agent existe déja ! ");
		else {
			sql = " INSERT into declarant (Nom_Declarant , Prenom_Declarant , Phone_Declarant) values ( ? , ? , ? ) ";
			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, this.nomDeclarant);
				stat.setString(2, this.prenomDeclarant);
				stat.setString(3, this.telDeclarant);
				stat.execute();
				JOptionPane.showMessageDialog(null, "le déclarant est ajouté");
			} catch (SQLException e) {
				System.out.print(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	// Role: supprime un declarant de la BD
	public void Supprimer() throws ExisteOrNot_Exception {
		boolean trouve = false;
		trouve = Rechercher();
		if (!trouve)
			throw new ExisteOrNot_Exception(" Cet agent n'existe pas ! ");
		else {
			sql = "delete from declarant where  Nom_Declarant = ?   and   Prenom_Declarant = ?   and   Phone_Declarant = ? ";
			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, this.nomDeclarant);
				stat.setString(2, this.prenomDeclarant);
				stat.setString(3, this.telDeclarant);
				stat.execute();
				JOptionPane.showMessageDialog(null, "le déclarant est supprimé");
			} catch (SQLException e) {
				System.out.print(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	// Role: modiffie les informations d'un declarant déja enregistré dans la BD
	public void Modifier(Object obj) throws ExisteOrNot_Exception {
		Declarant declarant;
		declarant = (Declarant) obj;
		boolean trouve = false;
		trouve = Rechercher();
		if (!trouve)
			throw new ExisteOrNot_Exception(" Cet agent n'exite pas ! ");
		else {
			sql = "update Declarant set Nom_Declarant = ? , Prenom_Declarant = ?  , Phone_Declarant = ? where Nom_Declarant = ?   and   Prenom_Declarant = ?   and   Phone_Declarant = ? ";

			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, declarant.getNomDeclarant());
				stat.setString(2, declarant.getPrenomDeclarant() );
				stat.setString(3, declarant.getTelDeclarant());
				stat.setString(4, this.nomDeclarant);
				stat.setString(5, this.prenomDeclarant);
				stat.setString(6, this.telDeclarant);
				stat.execute();
				JOptionPane.showMessageDialog(null, "le déclarant est modifié");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
