package model.entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ConfigSQL;

public class Agent_Douane {

	// ********************* Les variables d'instance *********************//

	private String nomAgent;
	private String prenomAgent;
	private String telAgent;
	private Connection cnx = null;
	private java.sql.PreparedStatement stat = null;
	private ResultSet rest = null;
	private String sql;

	// ********************* Le constructeur *********************//

	public Agent_Douane(String nom, String prenom, String tel) {

		nomAgent = nom;
		prenomAgent = prenom;
		telAgent = tel;
		cnx = ConfigSQL.getConnection();
	}

	// ******************** Les methodes ***********************//

	public boolean Rechercher() {	// Role: recherche un agent dans la BD
		sql = "select * from Agent_Douane where Nom_Agent = ? and Prenom_Agent = ? and Phone_Agent = ?";
		boolean trouve = false;
		try {
			stat = cnx.prepareStatement(sql);
			stat.setString(1, this.nomAgent);
			stat.setString(2, this.prenomAgent);
			stat.setString(3, this.telAgent);
			rest = stat.executeQuery();
			if (rest.next())
				trouve = true;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		return trouve;
	}

	//*************************************************************//

	public void Ajouter() throws ExisteOrNot_Exception {	// Role: ajoute un agent à la BD
		boolean trouve = false;
		trouve = Rechercher();
		if (trouve)
			throw new ExisteOrNot_Exception(" Cet agent existe déja ! ");
		else {
			sql = " INSERT into Agent_Douane (Nom_Agent , Prenom_Agent , Phone_Agent) values ( ? , ? , ? ) ";
			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, this.nomAgent);
				stat.setString(2, this.prenomAgent);
				stat.setString(3, this.telAgent);
				stat.execute();
				JOptionPane.showMessageDialog(null, "L'agent est ajouté");
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

	public void Supprimer() throws ExisteOrNot_Exception {	// Role: supprime un agent de la BD
		boolean trouve = false;
		trouve = Rechercher();
		if (!trouve)
			throw new ExisteOrNot_Exception(" Cet agent n'existe pas ! ");
		else {
			sql = "delete from Agent_Douane where  Nom_Agent = ?   and   Prenom_Agent = ?   and   Phone_Agent = ? ";
			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, this.nomAgent);
				stat.setString(2, this.prenomAgent);
				stat.setString(3, this.telAgent);
				stat.execute();
				JOptionPane.showMessageDialog(null, "L'agent est supprimé");
			} catch (SQLException e) {
				System.out.print(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	//*************************************************************//

	public void Modifier(Object obj) throws ExisteOrNot_Exception {	// Role: modiffie les informations d'un agent déja enregistré dans la BD
		Agent_Douane agent;
		agent = (Agent_Douane) obj;
		boolean trouve = false;
		trouve = Rechercher();
		if (!trouve)
			throw new ExisteOrNot_Exception(" Cet agent n'exite pas ! ");
		else {
			sql = "update Agent_Douane set Nom_Agent = ? , Prenom_Agent = ?  , Phone_Agent = ? where Nom_Agent = ?   and   Prenom_Agent = ?   and   Phone_Agent = ? ";

			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, agent.getNomAgent());
				stat.setString(2, agent.getPrenomAgent() );
				stat.setString(3, agent.getTelAgent());
				stat.setString(4, this.nomAgent);
				stat.setString(5, this.prenomAgent);
				stat.setString(6, this.telAgent);
				stat.execute();
				JOptionPane.showMessageDialog(null, "L'agent est modifié");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// ********************* Les getters & setters *********************//

	public String getNomAgent() {
		return nomAgent;
	}

	public String getPrenomAgent() {
		return prenomAgent;
	}

	public String getTelAgent() {
		return telAgent;
	}

}
