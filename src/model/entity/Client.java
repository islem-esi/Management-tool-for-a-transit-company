package model.entity;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DBHelper;
import model.Utile;
import model.entity.Abstract.Personne;
import net.proteanit.sql.DbUtils;
import view.Theme.Msg;

public class Client extends Personne {
	// ------------------- Les déclarations  -----------------------//
	private String Entreprise_Client;
	private String Email_Client;
	private String Adresse_Client;
	private String RC_Client;
	private String CartF_Client;

	// -------------------------- Les constructeurs --------------------------//

	public Client() {	}

	// -------------------------------------------------------//

	public Client(String nom_Client, String prenom_Client,
			String entreprise_Client, String phone_Client, String email_Client,
			String adresse_Client, String rC_Client, String carteF_Client) {

		super(nom_Client, prenom_Client, phone_Client);
		Entreprise_Client = entreprise_Client;
		Email_Client = email_Client;
		Adresse_Client = adresse_Client;
		RC_Client = rC_Client;
		CartF_Client = carteF_Client;
	}
	// -------------------------------------------------------//

	public Client(int Id_client ,String nom_Client, String prenom_Client,
			String entreprise_Client, String phone_Client, String email_Client,
			String adresse_Client, String rC_Client, String carteF_Client) {

		super(Id_client,nom_Client, prenom_Client, phone_Client);
		Entreprise_Client = entreprise_Client;
		Email_Client = email_Client;
		Adresse_Client = adresse_Client;
		RC_Client = rC_Client;
		CartF_Client = carteF_Client;
	}

	// -------------------------- Les methodes --------------------------//

	public boolean ClientExiste(String Rc) {

		boolean trouve = false;
		String sql = "Select * FROM client where RC_Client=?";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setString(1, Rc);

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

	//*************************************************************//

	public void Insert_Client(Client cl) {
		String sql = " insert into client (Nom_Client, Prenom_Client, Entreprise_Client, Phone_Client, Email_Client, Adresse_Client, RC_Client,CarteF)"
				+ "values (? , ? , ? , ? , ? , ? , ?, ? ) ";

		if (!ClientExiste(cl.getRC_Client())) {

			try {
				DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
				DBHelper.getPreparedStatement().setString(1, cl.getNom());
				DBHelper.getPreparedStatement().setString(2, cl.getPrenom());
				DBHelper.getPreparedStatement().setString(3,cl.getEntreprise_Client());
				DBHelper.getPreparedStatement().setString(4, cl.getPhone());
				DBHelper.getPreparedStatement().setString(5, cl.getEmail_Client());
				DBHelper.getPreparedStatement().setString(6, cl.getAdresse_Client());
				DBHelper.getPreparedStatement().setString(7, cl.getRC_Client());
				DBHelper.getPreparedStatement().setString(8, cl.getCartF_Client());

				DBHelper.getPreparedStatement().execute();

				Msg.Afficher(Msg.ClientAjouter, Msg.IconOk,false);
				Utile.Wait(1);
				Msg.CloseMsg();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			Msg.Afficher(Msg.ClientExiste, Msg.IconExclam,false);
			Utile.Wait(1);
			Msg.CloseMsg();
		}
	}

	//*************************************************************//

	public void Archive_Client(Client cl) {
		String sql = " insert into client_archive (Nom_Client, Prenom_Client, Entreprise_Client, Phone_Client, Email_Client, Adresse_Client, RC_Client, CarteF)"
				+ "values (? , ? , ? , ? , ? , ? , ?, ?) ";

	  if(ClientExiste(cl.getRC_Client())) {

			  try {
				  DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
				  DBHelper.getPreparedStatement().setString(1, cl.getNom());
				  DBHelper.getPreparedStatement().setString(2, cl.getPrenom());
				  DBHelper.getPreparedStatement().setString(3,cl.getEntreprise_Client());
				  DBHelper.getPreparedStatement().setString(4, cl.getPhone());
				  DBHelper.getPreparedStatement().setString(5, cl.getEmail_Client());
				  DBHelper.getPreparedStatement().setString(6, cl.getAdresse_Client());
				  DBHelper.getPreparedStatement().setString(7, cl.getRC_Client());
				  DBHelper.getPreparedStatement().setString(8, cl.getCartF_Client());
				  DBHelper.getPreparedStatement().execute();

				} catch (SQLException e) {
					e.printStackTrace();
				}
		  }
	}

	//*************************************************************//

	public void MultiRechClient(String name, String code, String ent, String RC, JTable table) {
		String sql=Utile.Client_Sql+" where idClient like'"+ code + "%'" + " AND concat(Nom_Client,' ',Prenom_Client) like'%" + name+"%'" + " AND Entreprise_Client like'" + ent+"%'" + " AND RC_Client like'" + RC+"%'";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			table.setModel(DbUtils.resultSetToTableModel(DBHelper.getResultSet()));
			Utile.Centrer_Table(table);
			Utile.Table_Non_Edit(table);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//*************************************************************//
	public void Update_Client(Client cl) {
		String sql = " update client set Nom_Client= ?, Prenom_Client= ?, Entreprise_Client= ?, Phone_Client= ?, Email_Client= ?, Adresse_Client= ?, RC_Client= ?, CarteF= ?"
				+ "where Rc_client= ?";

	  if(ClientExiste(cl.getRC_Client())) {

			  try {
				  DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
				  DBHelper.getPreparedStatement().setString(1, cl.getNom());
				  DBHelper.getPreparedStatement().setString(2, cl.getPrenom());
				  DBHelper.getPreparedStatement().setString(3,cl.getEntreprise_Client());
					DBHelper.getPreparedStatement().setString(4, cl.getPhone());
					DBHelper.getPreparedStatement().setString(5, cl.getEmail_Client());
					DBHelper.getPreparedStatement().setString(6, cl.getAdresse_Client());
					String str=cl.getRC_Client();
					DBHelper.getPreparedStatement().setString(7, str);
					DBHelper.getPreparedStatement().setString(8, cl.getCartF_Client());
					DBHelper.getPreparedStatement().setString(9, str);
					DBHelper.getPreparedStatement().execute();
					Msg.Afficher(Msg.ClientModifier, Msg.IconOk,false);
					Utile.Wait(1);
					Msg.CloseMsg();

				} catch (SQLException e) {
					e.printStackTrace();
				}
		  }

	  else
	  {
		  JOptionPane.showMessageDialog(null, "Ce client n'éxiste pas! Voulez vous l'ajouter. boutton oui/ non manque ici merci");
		  Insert_Client(cl);
	  }

	}

	//*************************************************************//

	public void delete_Client(Client cl) {
		String sql = " delete from client where Rc_Client= ?";

	  if(ClientExiste(cl.getRC_Client())) {

			  try {
				  DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
					String str=cl.getRC_Client();
					DBHelper.getPreparedStatement().setString(1, str);
					if (JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimmer ce client")==0)
					{
						DBHelper.getPreparedStatement().execute();

						Msg.Afficher(Msg.ClientSupprimer, Msg.IconOk,false);
						Utile.Wait(1);
						Msg.CloseMsg();
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		  }

	  else
	  {
			Msg.Afficher(Msg.ClientNonExiste, Msg.IconExclam,false);
			Utile.Wait(1);
			Msg.CloseMsg();
	  }

	}

	//*************************************************************//
	public void Rech_client(String critere, String s, JTable table) {
		String sql=Utile.Client_Sql+" where " + critere + " like '%" + s + "%'";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			table.setModel(DbUtils.resultSetToTableModel(DBHelper.getResultSet()));
			Utile.Centrer_Table(table);
			Utile.Table_Non_Edit(table);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// ----------------------- Les getters & setters ------------------------//

	public String getEntreprise_Client() {
		return Entreprise_Client;
	}

	public void setEntreprise_Client(String entreprise_Client) {
		Entreprise_Client = entreprise_Client;
	}

	public String getEmail_Client() {
		return Email_Client;
	}

	public void setEmail_Client(String email_Client) {
		Email_Client = email_Client;
	}

	public String getAdresse_Client() {
		return Adresse_Client;
	}

	public void setAdresse_Client(String adresse_Client) {
		Adresse_Client = adresse_Client;
	}

	public String getRC_Client() {
		return RC_Client;
	}

	public void setRC_Client(String rC_Client) {
		RC_Client = rC_Client;
	}

	public String getCartF_Client() {
		return CartF_Client;
	}

	public void setCartF_Client(String cartF_Client) {
		CartF_Client = cartF_Client;
	}



}
