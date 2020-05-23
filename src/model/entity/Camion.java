package model.entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ConfigSQL;

public class Camion {

	// ********************* Les variables d'instance *********************//

	private int idCamion = 0;
	private String matricule;
	private Connection cnx = null;
	private java.sql.PreparedStatement stat = null;
	private ResultSet rest = null;
	private String sql;

	// ********************* Le constructeur *********************//

	public Camion(String mat) {
		this.matricule = mat;
		cnx = ConfigSQL.getConnection();
	}

	// ******************** Les methodes ***********************//

	public boolean Rechercher() {	// Role: cherche un camion(sa matr) dans le tableau camion
		sql = "select * from gestion_facture2.Camion where Matricule = ?";
		boolean trouve = false;
		try {
			stat = cnx.prepareStatement(sql);
			stat.setString(1, this.matricule);
			rest = stat.executeQuery();
			if (rest.next()) {
				idCamion = rest.getInt("idCamion");
				trouve = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trouve;
	}
	//*************************************************************//

	public void Ajouter() throws ExisteOrNot_Exception {	// Role: ajoute un camion(sa matr)

		boolean trouve = Rechercher();
		if (trouve)
			throw new ExisteOrNot_Exception(" Ce camion est déja enregistrée ! ");
		else {

			sql = "INSERT INTO Camion(Matricule) VALUES(?)";
			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, this.matricule);
				stat.execute();
				JOptionPane.showMessageDialog(null, "Le camion est ajouté");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//*************************************************************//

	public void Supprimer() throws ExisteOrNot_Exception {	// Role: supprime un camion(sa mart) du tableau des camions
		boolean trouve = Rechercher();
		if (!trouve)
			throw new ExisteOrNot_Exception(" Ce camion n'est pas enregistré ! ");
		else {
			sql = "delete from gestion_facture2.Camion where idCamion = ?";
			try {
				stat = cnx.prepareStatement(sql);
				stat.setInt(1, idCamion);
				stat.execute();
				JOptionPane.showMessageDialog(null, "Le camion est supprimé");
			}catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				JOptionPane.showMessageDialog(null, "Cette donnée est utilisé dans autre chose");
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//*************************************************************//

	public void Modifier(Object obj) throws ExisteOrNot_Exception {	// Role: Modifie un camion(sa matr)
		Camion camion;
		camion = (Camion) obj;
		boolean trouve = false;
		trouve = Rechercher();
		if (!trouve)
			throw new ExisteOrNot_Exception(" Ce camion n'est pas enregistré ! ");
		else {
			sql = "update Camion set Matricule = ? where idCamion = ?";
			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, camion.getMatricule());
				stat.setInt(2, idCamion);
				stat.execute();
				JOptionPane.showMessageDialog(null, " La matricule est modifiée ");
			}catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				JOptionPane.showMessageDialog(null, "Cette donnée est utilisé dans autre chose");
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// ********************* Les getters & setters *********************//

	public String getMatricule() {
		return matricule;
	}
}
