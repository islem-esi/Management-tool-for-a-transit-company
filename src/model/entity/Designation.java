package model.entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import controllers.Login_Ctrl;
import model.ConfigSQL;
import model.DBHelper;
import model.Utile;
import net.proteanit.sql.DbUtils;

import java.time.*;

public class Designation {

	// ********************* Les variables d'instance *********************//

	private String designation;
	private String prixUnit;
	private String typeDebours;
	private Connection cnx = null;
	private  java.sql.PreparedStatement stat = null;
	private ResultSet rest = null;
	private String sql;

	// ********************* Le constructeur *********************//


	public Designation(String designation,String prixUnitaire,String typeDebours){
		this.designation = designation;
		this.prixUnit = prixUnitaire;
		this.typeDebours = typeDebours;
		cnx = ConfigSQL.getConnection();
	}
	// ********************* Les getters & setters *********************//

	public String getDesignation() {
		return designation;
	}

	public String getPrixUnit() {
		return prixUnit;
	}

	public String getTypeDebours() {
		return typeDebours;
	}

		// ******************** Les methodes ***********************//
	// Role: recherche une desingation dans la BD
		public boolean Rechercher(){
			sql = "select * from Designation where Designation = ? and Prix_Unit = ? and Type_Debours = ? ";
			boolean trouve = false;
			try {
				stat = cnx.prepareStatement(sql);
				stat.setString(1, this.designation);
				stat.setString(2, this.prixUnit);
				stat.setString(3, this.typeDebours);
				rest = stat.executeQuery();
				if(rest.next())
					trouve = true;
			} catch (SQLException e) {
				System.out.print(e.getMessage());
				e.printStackTrace();
			}
			return trouve;
		}

		// -------------------------------------------------------//

		// Role: ajoute une designation dans la BD
		public void Ajouter() throws ExisteOrNot_Exception{
			boolean trouve = false;
			trouve =Rechercher();
			if(trouve)
				throw new ExisteOrNot_Exception(" Cette désignation est déja enregistrée ! ");
			else{
				sql = " INSERT into Designation (Designation , Prix_Unit , Type_Debours) values ( ? , ? , ? ) ";
				try {
					stat = cnx.prepareStatement(sql);
					stat.setString(1, this.designation);
					stat.setString(2,this.prixUnit );
					stat.setString(3, this.typeDebours);
					stat.execute();
					JOptionPane.showMessageDialog(null, "La désignation est ajoutée");
				} catch (SQLException e) {
					System.out.print(e.getMessage());
					e.printStackTrace();
				}
				sql = " INSERT into historique (idUtilisateur , designation , date , prix ,prix_prec ,changement,vu ) values ( ? , ? , ? , ? , ? , ? ,?) ";
				try {
					stat = cnx.prepareStatement(sql);
					stat.setInt(1, Login_Ctrl.IdUser);
					stat.setString(2,designation);
					stat.setString(3,Instant.now().toString());
					stat.setString(4,prixUnit);
					stat.setString(5,"0");
					stat.setString(6,"ajout");
					stat.setString(7,"non");
					stat.execute();
				} catch (SQLException e) {
					System.out.print(e.getMessage());
					e.printStackTrace();
				}

			}
		}

		// -------------------------------------------------------//

		// Role: supprime une designation de la BD
		public void Supprimer() throws ExisteOrNot_Exception{
			boolean trouve = false;
			trouve =Rechercher();
			if(!trouve)
				throw new ExisteOrNot_Exception(" Cette désignation n'est pas enregistrée ! ");
			else{
				sql = "delete from Designation where  Designation = ?   and   Prix_Unit = ?  and Type_Debours = ? ";
				try {
					stat = cnx.prepareStatement(sql);
					stat.setString(1, this.designation);
					stat.setString(2, this.prixUnit);
					stat.setString(3, this.typeDebours);
					stat.execute();
					JOptionPane.showMessageDialog(null, "La désignation est supprimée");
				} catch (SQLException e) {
					System.out.print(e.getMessage());
					e.printStackTrace();
				}
			}
		}

		// -------------------------------------------------------//

		public static boolean modifExiste() {

			boolean trouve = false;
			String sql = "SELECT * FROM historique where idUtilisateur != 1 && vu='non';";
			try {
				DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));

				//DBHelper.getPreparedStatement().setString(1,"non");

				DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

				if (DBHelper.getResultSet().isBeforeFirst()) { // checking if the result
															// has at least 1
															// element
					trouve = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return trouve;
		}

		// -------------------------------------------------------//

		//Role : mettre les designation comme vus
		public static void consulte() {
			String sql = "update historique set vu='oui';";
			try {
				DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
				DBHelper.getPreparedStatement().execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// -------------------------------------------------------//

		static public void RechDesignationHistorique1(String s, JTable table) {
			String sql ="Select Nom_Utilisateur as 'employé' , historique.idUtilisateur as 'code employé',designation,date,prix as 'nouveau prix',prix_prec as 'ancien prix',changement from historique "
					+ " inner join utilisateur where historique.idUtilisateur=utilisateur.idUtilisateur"
					+ " && historique.designation like '" + s + "%'";
			try {
				DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
				DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
				table.setModel(DbUtils.resultSetToTableModel(DBHelper.getResultSet()));
				Utile.Centrer_Table(table);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// -------------------------------------------------------//

		static public void RechDesignationHistorique2(String s, JTable table) {
			String sql ="Select Nom_Utilisateur as 'employé' , historique.idUtilisateur as 'code employé',designation,date,prix as 'nouveau prix',prix_prec as 'ancien prix',changement from historique "
					+ " inner join utilisateur where historique.idUtilisateur=utilisateur.idUtilisateur"
					+ " && utilisateur.Nom_Utilisateur like '" + s + "%'";
			try {
				DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
				DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
				table.setModel(DbUtils.resultSetToTableModel(DBHelper.getResultSet()));
				Utile.Centrer_Table(table);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		// -------------------------------------------------------//

		// Role: modifier les informations d'une désignation déja enregistrée dans la BD
		public void Modifier(Object obj) throws ExisteOrNot_Exception{
			Designation designation;
			designation= (Designation)obj;
			boolean trouve = false;
			trouve =Rechercher();
			if(!trouve)
				throw new ExisteOrNot_Exception(" Ce chauffeur n'est pas enregistré ! ");
			else{
				sql = "update Designation set Designation = ? , Prix_Unit = ? , Type_Debours = ?  where Designation = ?   and   Prix_Unit = ? and Type_Debours = ? ";

				try {
					stat = cnx.prepareStatement(sql);
					stat.setString(1, designation.getDesignation());
					stat.setString(2, designation.getPrixUnit());
					stat.setString(3, designation.getTypeDebours());
					stat.setString(4, this.designation);
					stat.setString(5, this.prixUnit);
					stat.setString(6, this.typeDebours);

					stat.execute();
					JOptionPane.showMessageDialog(null, "La désignation est modifiée");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				sql = " INSERT into historique (idUtilisateur , designation , date , prix ,prix_prec ,changement,vu ) values ( ? , ? , ? , ? , ? , ? ,?) ";
				try {
					stat = cnx.prepareStatement(sql);
					stat.setInt(1, Login_Ctrl.IdUser);
					stat.setString(2,designation.getDesignation());
					stat.setString(3,Instant.now().toString());
					stat.setString(4,designation.getPrixUnit());
					stat.setString(5,this.prixUnit);
					stat.setString(6,"modification");
					stat.setString(7,"non");
					stat.execute();
				} catch (SQLException e) {
					System.out.print(e.getMessage());
					e.printStackTrace();
				}

			}
		}
}
