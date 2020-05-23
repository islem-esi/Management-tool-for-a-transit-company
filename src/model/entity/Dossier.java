package model.entity;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DBHelper;
import model.Utile;
import net.proteanit.sql.DbUtils;

public class Dossier {
	// ------------------- Les déclarations  -----------------------//

	private int idDossier;
	private int IdClient;
	private Date Date_Ouverture;
	private static Date Date_Fermeture;
	private Date Date_Arrive;
	private String Repertoire;
	private int NbConteneur;
	private String MoyenTransport;
	private String Statut_Dossier;
	private String TransportID;
	private String Provenance;
	private String Gros;
	private String Article;
	private String Quai;


	// -------------------------- Les constructeurs --------------------------//
	public Dossier() {}

	//*************************************************************//

	public Dossier(int idClient, Date date_Ouverture, Date date_Arrive, String repertoire, String moyenTransport,
			String transportID, String provenance, String gros, String article, String quai) {
		IdClient = idClient;
		Date_Ouverture = date_Ouverture;
		Date_Arrive = date_Arrive;
		Repertoire = repertoire;
		MoyenTransport = moyenTransport;
		TransportID = transportID;
		Provenance = provenance;
		Gros = gros;
		Article = article;
		Quai = quai;
	}
	// -------------------------- Les methodes --------------------------//

	static public void MettreAjour(int IdDossier) {
		String sql = " update dossier set Date_Fermeture=now(), Statut_Dossier= ?" + "where idDossier= ?";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setString(1, "terminer");
			DBHelper.getPreparedStatement().setInt(2, IdDossier);
			DBHelper.getPreparedStatement().execute();

			java.sql.Date ourJavaDateObject = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			Date_Fermeture = ourJavaDateObject;

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//*************************************************************//

	static public void Insert_Dossier(Dossier dos, int NbCont) {
		String sql = " insert into dossier (idClient,Date_Ouverture,Date_Arrive,"
				+ "Repertoire,MoyenTransport,TransportID,Provenance,Gros,Article,Quai,nbConteneur)"
				+ "values (? , ? , ? , ? , ? , ? , ?, ?, ?, ?,? ) ";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setInt(1, dos.getIdClient());
			DBHelper.getPreparedStatement().setDate(2, dos.getDate_Ouverture());
			DBHelper.getPreparedStatement().setDate(3, dos.getDate_Arrive());
			DBHelper.getPreparedStatement().setString(4, dos.getRepertoire());
			DBHelper.getPreparedStatement().setString(5, dos.getMoyenTransport());
			DBHelper.getPreparedStatement().setString(6, dos.getTransportID());
			DBHelper.getPreparedStatement().setString(7, dos.getProvenance());
			DBHelper.getPreparedStatement().setString(8, dos.getGros());
			DBHelper.getPreparedStatement().setString(9, dos.getArticle());
			DBHelper.getPreparedStatement().setString(10, dos.getQuai());
			DBHelper.getPreparedStatement().setInt(11, NbCont);
			DBHelper.getPreparedStatement().execute();

			JOptionPane.showMessageDialog(null, "Dossier ajouté avec succèes");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//*************************************************************//

	static public void Rech_Dossier_nom(String s, JTable table) {
		String sql = Utile.Dossier_Sql + " && concat(Nom_Client,' ',Prenom_Client) like '%" + s + "%'";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			table.setModel(DbUtils.resultSetToTableModel(DBHelper.getResultSet()));
			Utile.Centrer_Table(table);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//*************************************************************//

	public static boolean isDstr(int idDossier) {
		String sql = "select Repertoire from dossier where idDossier="+idDossier+" and Repertoire='OT'";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if ((DBHelper.getResultSet().next())) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	//*************************************************************//

	public static String GetEntreprise(int idDossier)
	{
		String sql = "select Entreprise_Client from dossier"
				+ " inner join client where dossier.idClient=client.idClient"
				+ " and idDossier="+idDossier;
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if ((DBHelper.getResultSet().next())) {
				return DBHelper.getResultSet().getString("Entreprise_Client");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "";
		}

	//*************************************************************//

	public Dossier(int id) {
		String sql = "SELECT * FROM dossier WHERE idDossier='" + id + "';";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if ((DBHelper.getResultSet().next())) {
				idDossier = id;
				IdClient = DBHelper.getResultSet().getInt("idClient");
				NbConteneur = DBHelper.getResultSet().getInt("nbConteneur");
				Provenance = DBHelper.getResultSet().getString("Provenance");
				Repertoire = DBHelper.getResultSet().getString("Repertoire");
				MoyenTransport = DBHelper.getResultSet().getString("MoyenTransport");
				TransportID = DBHelper.getResultSet().getString("TransportID");
				Gros = DBHelper.getResultSet().getString("Gros");
				Article = DBHelper.getResultSet().getString("Article");
				Statut_Dossier = DBHelper.getResultSet().getString("Statut_Dossier");
				Quai = DBHelper.getResultSet().getString("Quai");
				Date_Ouverture = DBHelper.getResultSet().getDate("Date_Ouverture");
				Date_Fermeture = DBHelper.getResultSet().getDate("Date_Fermeture");
				Date_Arrive = DBHelper.getResultSet().getDate("Date_Arrive");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//*************************************************************//

	public static void RechByDate(java.sql.Date date1, java.sql.Date date2, JTable tab) {
		String sql = Utile.Dossier_Sql + " and Date_Ouverture between ? and ?";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setDate(1, date1);
			DBHelper.getPreparedStatement().setDate(2, date2);
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			tab.setModel(DbUtils.resultSetToTableModel(DBHelper.getResultSet()));
			Utile.Property_Table(tab);
			Utile.Centrer_Table(tab);
			Utile.Table_Non_Edit(tab);
			Utile.Entete_Table(tab);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// ----------------------- Les getters & setters ------------------------//

	public int getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(int idDossier) {
		this.idDossier = idDossier;
	}

	public int getIdClient() {
		return IdClient;
	}

	public void setIdClient(int idClient) {
		this.IdClient = idClient;
	}

	public Date getDate_Ouverture() {
		return Date_Ouverture;
	}

	public void setDate_Ouverture(Date date_Ouverture) {
		Date_Ouverture = date_Ouverture;
	}

	public Date getDate_Fermeture() {
		return Date_Fermeture;
	}

	public void setDate_Fermeture(Date date_Fermeture) {
		Date_Fermeture = date_Fermeture;
	}

	public Date getDate_Arrive() {
		return Date_Arrive;
	}

	public void setDate_Arrive(Date date_Arrive) {
		Date_Arrive = date_Arrive;
	}

	public String getRepertoire() {
		return Repertoire;
	}

	public void setRepertoire(String repertoire) {
		Repertoire = repertoire;
	}

	public String getMoyenTransport() {
		return MoyenTransport;
	}

	public void setMoyenTransport(String moyenTransport) {
		MoyenTransport = moyenTransport;
	}

	public String getTransportID() {
		return TransportID;
	}

	public void setTransportID(String transportID) {
		TransportID = transportID;
	}

	public String getProvenance() {
		return Provenance;
	}

	public void setProvenance(String Provenance) {
		this.Provenance = Provenance;
	}

	public String getGros() {
		return Gros;
	}

	public void setGros(String gros) {
		Gros = gros;
	}

	public String getArticle() {
		return Article;
	}

	public void setArticle(String article) {
		Article = article;
	}

	public String getQuai() {
		return Quai;
	}

	public void setQuai(String quai) {
		Quai = quai;
	}

	public int getNbConteneur() {
		return NbConteneur;
	}

	public void setNbConteneur(int nbConteneur) {
		NbConteneur = nbConteneur;
	}

	public String getStatut_Dossier() {
		return Statut_Dossier;
	}

	public void setStatut_Dossier(String statut_Dossier) {
		Statut_Dossier = statut_Dossier;
	}

}
