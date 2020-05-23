package model.entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.ConfigSQL;

public class Chauffeur{

	// ********************* Les variables d'instance *********************//

	private String nomChauffeur;
	private String prenomChauffeur;
	private String tleChauffeur;
	private Connection cnx = null;
	private java.sql.PreparedStatement stat = null;
	private ResultSet rest = null;
	private String sql;

	// ********************* Le constructeur *********************//

	public Chauffeur(String nom,String prenom,String tle){
		this.nomChauffeur = nom;
		this.prenomChauffeur = prenom;
		this.tleChauffeur = tle;
		cnx = ConfigSQL.getConnection();
	}

	// ******************** Les methodes ***********************//

	public boolean Rechercher(){	// Role: recherche un chauffeur dans la BD
		sql = "select * from Chauffeur where Nom_Chauffeur = ? and Prenom_Chauffeur = ? and Phone_Chauffeur = ?";
		boolean trouve = false;
		try {
			stat = cnx.prepareStatement(sql);
			stat.setString(1, this.nomChauffeur);
			stat.setString(2, this.prenomChauffeur);
			stat.setString(3, this.tleChauffeur);
			rest = stat.executeQuery();
			if(rest.next())
				trouve = true;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		return trouve;
	}
	//*************************************************************//

	public void Ajouter() throws ExisteOrNot_Exception{	// Role: ajoute un chauffeur dans la BD
		boolean trouve = false;
		trouve =Rechercher();
		if(trouve)
			throw new ExisteOrNot_Exception(" Ce chauffeur est déja enregistré ! ");
		else{
			sql = " INSERT into Chauffeur (Nom_Chauffeur , Prenom_Chauffeur , Phone_Chauffeur) values ( ? , ? , ? ) ";
			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, this.nomChauffeur);
				stat.setString(2, this.prenomChauffeur);
				stat.setString(3, this.tleChauffeur);
				stat.execute();
				JOptionPane.showMessageDialog(null, "Le chauffeur est ajouté");
			} catch (SQLException e) {
				System.out.print(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	//*************************************************************//

	public void Supprimer() throws ExisteOrNot_Exception{	// Role: supprime un chauffeur de la BD
		boolean trouve = false;
		trouve =Rechercher();
		if(!trouve)
			throw new ExisteOrNot_Exception(" Ce chauffeur n'est pas enregistré ! ");
		else{
			sql = "delete from Chauffeur where  Nom_Chauffeur = ?   and   Prenom_Chauffeur = ?   and   Phone_Chauffeur = ? ";
			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, this.nomChauffeur);
				stat.setString(2, this.prenomChauffeur);
				stat.setString(3, this.tleChauffeur);
				stat.execute();
				JOptionPane.showMessageDialog(null, "Le chauffeur est supprimé");
			}catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				JOptionPane.showMessageDialog(null, "Cette donnée est utilisé dans autre chose");
			}
			catch (SQLException e) {
				System.out.print(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	//*************************************************************//

	public void Modifier(Object obj) throws ExisteOrNot_Exception{	// Role: modifier les informations d'un chauffeur déja enregistré dans la BD
		Chauffeur chauffeur;
		chauffeur = (Chauffeur)obj;
		boolean trouve = false;
		trouve =Rechercher();
		if(!trouve)
			throw new ExisteOrNot_Exception(" Ce chauffeur n'est pas enregistré ! ");
		else{
			sql = "update Chauffeur set Nom_Chauffeur = ? , Prenom_Chauffeur = ?  , Phone_Chauffeur = ? where Nom_Chauffeur = ?   and   Prenom_Chauffeur = ?   and   Phone_Chauffeur = ? ";

			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, chauffeur.getNomChauffeur());
				stat.setString(2, chauffeur.getPrenomChauffeur());
				stat.setString(3, chauffeur.getTleChauffeur());
				stat.setString(4, this.nomChauffeur);
				stat.setString(5, this.prenomChauffeur);
				stat.setString(6, this.tleChauffeur);
				stat.execute();
				JOptionPane.showMessageDialog(null, "Le chauffeur est modifié");
			}
			catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				JOptionPane.showMessageDialog(null, "Cette donnée est utilisé dans autre chose");
			}

			catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}


	// ********************* Les getters & setters *********************//

	public String getNomChauffeur() {
		return nomChauffeur;
	}

	public String getPrenomChauffeur() {
		return prenomChauffeur;
	}

	public String getTleChauffeur() {
		return tleChauffeur;
	}

}
