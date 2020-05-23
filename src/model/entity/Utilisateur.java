package model.entity;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.ConfigSQL;
import model.DBHelper;
import model.Utile;
import view.Parametres_View.AjoutStopedException;
import view.Theme.Msg;

public class Utilisateur {

	private int idUtilisateur;
	private String Nom_Utilisateur;
	private String Pass_Utilisateur;

	public Utilisateur() {
	}

	public Utilisateur(String nom_Utilisateur, String pass_Utilisateur) {

		Nom_Utilisateur = nom_Utilisateur;
		Pass_Utilisateur = pass_Utilisateur;
	}

	public boolean Login_user(Utilisateur utilisateur) {

		boolean trouve = false;

		String sql = "select Nom_Utilisateur, Pass_Utilisateur,idUtilisateur from utilisateur"; // requet

		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect()
					.prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement()
					.executeQuery());

			// pour detect la fin de la boucle

			while (DBHelper.getResultSet().next() && (!trouve)) {
				String username = DBHelper.getResultSet().getString(
						"Nom_Utilisateur");
				String password = DBHelper.getResultSet().getString(
						"Pass_Utilisateur");

				if (username.equals(utilisateur.getNom_Utilisateur())
						&& password.equals(utilisateur.getPass_Utilisateur())) {
					Msg.Afficher(Msg.CnxReussit, Msg.PathIcon1);
					trouve = true;

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trouve;
	}

	public int Login_user2(Utilisateur utilisateur) {

		int trouve = 0;
		String sql = "select * from utilisateur";

		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect()
					.prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement()
					.executeQuery());

			while (DBHelper.getResultSet().next() && (trouve==0)) {
				String username = DBHelper.getResultSet().getString(
						"Nom_Utilisateur");
				String password = DBHelper.getResultSet().getString(
						"Pass_Utilisateur");
				int Id = DBHelper.getResultSet().getInt("idUtilisateur");

				if (username.equals(utilisateur.getNom_Utilisateur())
						&& password.equals(Utile.passHash(utilisateur.getPass_Utilisateur()))) {
					if (Id == 1)
						trouve = 1;
					else
						trouve = 2;
					Msg.Afficher(Msg.CnxReussit, Msg.PathIcon1,false,true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			trouve=-1;
			ConfigSQL.ErrorDBMsg();
		}

		return trouve;
	}


	// Role; recherche un utilisateur dans la BD
	public static boolean Rechercher(String nomUser) {
		String sql = "select * from utilisateur where Nom_Utilisateur = ?";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setString(1, nomUser);
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if (DBHelper.getResultSet().next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// Role: ajoute un utilisateur
	public void Ajouter() throws ExisteOrNot_Exception, AjoutStopedException {
		boolean trouve = Rechercher(Nom_Utilisateur);
		if (trouve)
			throw new ExisteOrNot_Exception(" Cet utilisateur est déja enregistré ! ");
		if (this.Pass_Utilisateur.equals(""))
			throw new AjoutStopedException("Utilisateur non ajouté");
		else {
			String sql = " INSERT into Utilisateur (Nom_Utilisateur , Pass_Utilisateur) values ( ? , ? ) ";
			try {
				DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
				DBHelper.getPreparedStatement().setString(1, Nom_Utilisateur);
				DBHelper.getPreparedStatement().setString(2, Utile.passHash(Pass_Utilisateur));
				DBHelper.getPreparedStatement().execute();
				JOptionPane.showMessageDialog(null, "L'utilisateur est ajouté");
			} catch (SQLException e) {
				System.out.print(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	// Role: supprime un utilisateur
	public void Supprimer() throws ExisteOrNot_Exception {
		boolean trouve = Rechercher(Nom_Utilisateur);
		if (!trouve)
			throw new ExisteOrNot_Exception(" Cet utilisateur n'est pas enregistré ! ");
		else {
			String sql = "delete from Utilisateur where  Nom_Utilisateur = ?  and idUtilisateur != 1";
			try {
				DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
				DBHelper.getPreparedStatement().setString(1, Nom_Utilisateur);
				DBHelper.getPreparedStatement().execute();
				JOptionPane.showMessageDialog(null, "L'utilisateur est supprimé");
			} catch (SQLException e) {
				System.out.print(e.getMessage());
				e.printStackTrace();
			}

		}

	}

	// Role: modifie un utilisateur
	public void updatePassword() throws ExisteOrNot_Exception {
		boolean trouve = Rechercher(Nom_Utilisateur);
		if (!trouve)
			throw new ExisteOrNot_Exception(" Cet Utilisteur n'est pas enregistré ! ");
		String sql = "update Utilisateur set Pass_Utilisateur = ? where Nom_Utilisateur = ?";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setString(1, this.Pass_Utilisateur);
			DBHelper.getPreparedStatement().setString(2, this.Nom_Utilisateur);
			DBHelper.getPreparedStatement().execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Role: modifie un utilisateur
	public void Modifier(Utilisateur util) throws ExisteOrNot_Exception {

		if (!Rechercher(Nom_Utilisateur))
			throw new ExisteOrNot_Exception(" Utilisateur non existant ! ");
		if (!equals(util)) {
			try {
				if (!util.getPass_Utilisateur().equals("")) {
					String sql = "update Utilisateur set Nom_Utilisateur = ? , Pass_Utilisateur = ? where Nom_Utilisateur = ? ";
					DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
					DBHelper.getPreparedStatement().setString(1, util.getNom_Utilisateur());
					DBHelper.getPreparedStatement().setString(2, Utile.passHash(util.getPass_Utilisateur()));
					DBHelper.getPreparedStatement().setString(3, this.Nom_Utilisateur);
				} else {
					String sql = "update Utilisateur set Nom_Utilisateur = ? where Nom_Utilisateur = ? ";
					DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
					DBHelper.getPreparedStatement().setString(1, util.getNom_Utilisateur());
					DBHelper.getPreparedStatement().setString(2, this.Nom_Utilisateur);
				}
				DBHelper.getPreparedStatement().execute();
				JOptionPane.showMessageDialog(null, "Utilisateur modifié");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else
			JOptionPane.showMessageDialog(null, "Vous n'avez rien changé !");
	}

	public boolean equals(Utilisateur util) {
		return ((Nom_Utilisateur.equals(util.getNom_Utilisateur()))
				&& (util.getPass_Utilisateur().equals("")));
	}



	// ********************* Les getters & setters *********************//
		public int getIdUtilisateur() {
			return idUtilisateur;
		}

		public void setIdUtilisateur(int idUtilisateur) {
			this.idUtilisateur = idUtilisateur;
		}

		public String getNom_Utilisateur() {
			return Nom_Utilisateur;
		}

		public void setNom_Utilisateur(String nom_Utilisateur) {
			Nom_Utilisateur = nom_Utilisateur;
		}

		public String getPass_Utilisateur() {
			return Pass_Utilisateur;
		}

		public void setPass_Utilisateur(String pass_Utilisateur) {
			Pass_Utilisateur = pass_Utilisateur;
		}

		public static String getAdmin(){
			String sql = "select * from utilisateur where idUtilisateur = 1";
			try {
				DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
				DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
				if (DBHelper.getResultSet().next())
					return DBHelper.getResultSet().getString("Nom_Utilisateur");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}





}
