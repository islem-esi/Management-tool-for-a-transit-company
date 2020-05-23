package model;

import java.awt.Color;
import java.awt.Font;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

public class Utile {

	// -------------------------- Les Constants --------------------------//

    public static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	// -----------------------------------------------------//
    public static DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
	// -----------------------------------------------------//
	public static Color myBlue=new Color(1, 74, 112);
	// -----------------------------------------------------//
    final static public String FactureNonRegle="SELECT count(idDossier) FROM dossier where Statut_Dossier='en cours';";
	// -----------------------------------------------------//
	final static public String AllTypeTC = "SELECT (Type_Conteneurcol) FROM dossier_conteneur "
			+ "inner join type_conteneur " + "on type_conteneur.idType_Conteneur=dossier_conteneur.idType_Conteneur "
			+ "where idDossier=? " + "group by Type_Conteneurcol ";
	// -----------------------------------------------------//
	final static public String BestClient_sql = "SELECT Nom_Client as Nom,Prenom_Client as Prenom,"
			+ "sum(TTC) as CA,max(TTC) as Max,min(TTC) as Min ,count(TTC) as NbDossier " + "FROM client "
			+ "inner join dossier " + "on client.idClient=dossier.idClient " + "inner join facture "
			+ "on dossier.idDossier=facture.idDossier " + "group by client.idClient " + "order by CA desc";
	// -----------------------------------------------------//
	final static public String FraudClient_sql = "SELECT Nom_Client as Nom,Prenom_Client as Prenom,Entreprise_Client as Entreprise,"
			+ "count(Fraude) as Nombrefraude " + "FROM client " + "inner join dossier "
			+ "on client.idClient=dossier.idClient " + "inner join dossier_conteneur "
			+ "on dossier.idDossier=dossier_conteneur.idDossier " + "where dossier_conteneur.Fraude='FRAUDE' "
			+ "group by client.idClient " + "order by Nombrefraude desc ";
	// -----------------------------------------------------//
	final static public String Dossier_Sql = "Select idDossier as NoDossier,Repertoire,Date_Ouverture as 'Date d'"+"'ouverture',Date_Fermeture as 'Date de fermeture',Statut_Dossier as 'Statut du dossier',client.idClient as 'Code Client',"
			+ "concat(Nom_Client,' ',Prenom_Client) as Client,Entreprise_Client as Entreprise,Provenance, nbConteneur as 'Nbr TC' from dossier"
			+ " inner join client where dossier.idClient=client.idClient";
	// -----------------------------------------------------//
	final static public String Client_Sql = "Select idClient as Code,Nom_Client as Nom,Prenom_Client as Prénom,"
			+ "Entreprise_Client as Entreprise,Phone_Client as Mobile,Email_Client as Email"
			+ ",Adresse_Client as Adresse,RC_Client as RC,CarteF as 'Carte Fiscale'" + " from Client";
	// -----------------------------------------------------//

	// -------------------------- Les methodes Utiles--------------------------//

	public static String passHash(String passwordToHash) { // Pour Hasher le Password
		String hashtext = null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(passwordToHash.getBytes());
			byte[] digest = md.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			hashtext = bigInt.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashtext;
	}

	// -------------------------------------------------------//
	public static int GetCountFraude(String table, String Col, String Condition) {
		int count = 0;
		String sql = "Select count(" + Col + ") from " + table + " where Fraude= '" + Condition + "'";

		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				count = DBHelper.getResultSet().getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	// -------------------------------------------------------//

	public static String GetMarchandiseById(int idMarch) {
		String Name = "";
		String sql = "Select Type_Marchandise from type_marchandise " + "where idTypeMarchandise=?";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setInt(1, idMarch);
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if ((DBHelper.getResultSet().next())) {
				Name = DBHelper.getResultSet().getString("Type_Marchandise");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Name;
	}

	// -------------------------------------------------------//

	public static int GetIdByString(String NameIdColumn, String table, String stringColumn, String string) {
		int Id = 0;
		String sql = "Select " + NameIdColumn + " from " + table + " where " + stringColumn + "=?";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setString(1, string);
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			while (DBHelper.getResultSet().next()) {
				Id = DBHelper.getResultSet().getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Id;
	}

	// -------------------------------------------------------//

	public static int GetSumTable(String table, String col) {
		int sum = 0;
		String sql = "Select sum(" + col + ") from " + table;

		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				sum = DBHelper.getResultSet().getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	// -------------------------------------------------------//
	public static int GetCountLegalFraudDate(String Statut,String date1,String date2) {
		int sum = 0;
		String sql = "Select count(Fraude) from dossier_conteneur inner join dossier "
				+ "on dossier_conteneur.idDossier=dossier.idDossier"
				+ " where Fraude='"+Statut
				+ "' and Date_Arrive between '" + date1 + "' and '"+ date2 + "'";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				sum = DBHelper.getResultSet().getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	// -------------------------------------------------------//

	public static int GetSumTable(String table, String col,String date1,String date2) {
		int sum = 0;
		String sql = "Select sum(" + col + ") from " + table+" where Date_Facture between '" + date1 + "' and '"
				+ date2 + "'";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				sum = DBHelper.getResultSet().getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sum;
	}

	// -------------------------------------------------------//

	public static int GetSumBetweenDate(String table, String col, String date1, String date2) {
		int sum = 0;
		String sql = "Select sum(" + col + ") from " + table + " where Date_Arrive between '" + date1 + "' and '"
				+ date2 + "'";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				sum = DBHelper.getResultSet().getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	// -------------------------------------------------------//

	public static int GetSumFactureBetweenDate(String table, String col, String date1, String date2) {
		int sum = 0;
		String sql = "Select sum(" + col + ") from " + table + " where Date_Facture between '" + date1 + "' and '"
				+ date2 + "'";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				sum = DBHelper.getResultSet().getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}


	// -------------------------------------------------------//

	public static int GetCountDossierDate(String date1, String date2) {
		int sum = 0;

		String sql = "Select count(iddossier) from dossier where Date_Ouverture between '" + date1 + "' and '"+ date2 + "'";

		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				sum = DBHelper.getResultSet().getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	// -------------------------------------------------------//

	public static int GetNbFactureNonRegle() {
		int count = 0;
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(FactureNonRegle));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				count = DBHelper.getResultSet().getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// -------------------------------------------------------//

	public static int GetCountTable(String table, String IdCol) {
		int count = 0;
		String sql = "Select count(" + IdCol + ") from " + table;

		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			while (DBHelper.getResultSet().next()) {
				count = DBHelper.getResultSet().getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// -------------------------------------------------------//



	public static int GetMaxId(String table, String IdCol) {
		int max = 0;
		String sql = "Select MAX(" + IdCol + ") from " + table;

		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				max = DBHelper.getResultSet().getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return max;
	}

	// -------------------------------------------------------//

	public static boolean PossedeDebour(int IdDesignation) {
		boolean debours = false;
		String sql = "Select Type_Debours from designation where idDesignation=?";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setInt(1, IdDesignation);
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				if (DBHelper.getResultSet().getString(1).equals("oui"))
					debours = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return debours;
	}

	// -------------------------------------------------------//

	public static float GetPrix(int IdDesignation) {
		float Prix = 0;

		String sql = "Select Prix_Unit from designation where idDesignation=?";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setInt(1, IdDesignation);
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				Prix = DBHelper.getResultSet().getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Prix;
	}

	// -------------------------------------------------------//

	public static void Wait(int Second) {
		try {
			Thread.sleep(Second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// -------------------------------------------------------//

	public static String getAllTypeTC(int IdDossier) {
		String Types = "";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(AllTypeTC));
			DBHelper.getPreparedStatement().setInt(1, IdDossier);
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				Types = Types + DBHelper.getResultSet().getString(1) + " | ";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Types;
	}

	// -------------------------------------------------------//

	public static String getAllNoTC(int IdDossier) {
		String No = "";
		String sql = "SELECT NoConteneur FROM dossier_conteneur where idDossier=?";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setInt(1, IdDossier);
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				No = No + DBHelper.getResultSet().getString(1) + " | ";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return No;
	}

	// -------------------------------------------------------//

	public static int getIdFromCombo(String s) {
		int Id = Integer.parseInt(s.substring(0, s.indexOf("-")));
		return Id;
	}

	// -------------------------------------------------------//

	public static String getTextFromCombo(String s) {
		String text = s.substring(s.indexOf("-") + 1);
		return text;
	}

	// -------------------------------------------------------//

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void remplirCombo(JComboBox combo, String col1, String col2, String tab) {
		String sql = "Select * from " + tab;
		int itemCount = combo.getItemCount();

		for (int i = 0; i < itemCount; i++) {
			combo.removeItemAt(0);
		}
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				String info = DBHelper.getResultSet().getString(col1).toString();
				String prenom = DBHelper.getResultSet().getString(col2).toString();
				combo.addItem(info + " " + prenom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// -------------------------------------------------------//

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void remplirComboNoId(JComboBox combo, String table, String Column) {

		String sql = "Select * from " + table;
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				String nom = DBHelper.getResultSet().getString(Column);
				combo.addItem(nom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// -------------------------------------------------------//

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void remplirCombo(JComboBox combo, String table, String Column) {

		String sql = "Select * from " + table;
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			while (DBHelper.getResultSet().next()) {
				int Id = Integer.parseInt(DBHelper.getResultSet().getString(1));
				String nom = DBHelper.getResultSet().getString(Column);
				combo.addItem(Id + "-" + nom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// -------------------------------------------------------//

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void Centrer_Combo(JComboBox combo) {
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		combo.setRenderer(dlcr);
	}

	// -------------------------------------------------------//

	public static void Property_Table(JTable table) {
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Simplified Arabic", Font.BOLD, 13));
		table.setForeground(new Color(1, 56, 83));
		table.setRowHeight(22);
		table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
	}

	// -------------------------------------------------------//

	public static void Table_Non_Edit(JTable table) {
		for (int c = 0; c < table.getColumnCount(); c++) {
			Class<?> col_class = table.getColumnClass(c);
			table.setDefaultEditor(col_class, null);
		}
	}

	// -------------------------------------------------------//

	public static void Entete_Table(JTable table) {
		table.getTableHeader().setBackground(new Color(1, 74, 112));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.getTableHeader().setFont((new Font("Simplified Arabic", Font.BOLD, 13)));
	}

	// -------------------------------------------------------//

	public static void Centrer_Table(JTable table) {
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableModel tableModel = table.getModel();
		for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
			table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
		}
	}

	// -------------------------------------------------------//

	public static void UpdateTable(String sql, JTable tab) {
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			tab.setModel(DbUtils.resultSetToTableModel(DBHelper.getResultSet()));
			Property_Table(tab);
			Centrer_Table(tab);
			Table_Non_Edit(tab);
			Entete_Table(tab);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// -------------------------------------------------------//

	public static int GetIdFromTable(String Name, String prenom, JTable tab) {

		int id = -1;
		for (int i = 0; i < tab.getRowCount(); i++) {

			if (tab.getModel().getValueAt(i, 1).equals(Name) && tab.getModel().getValueAt(i, 2).equals(prenom)) {
				id = Integer.parseInt((String) tab.getModel().getValueAt(i, 0));
			}
		}
		return id;
	}

	// -------------------------------------------------------//

	public static void GetTableInfo(String table, JTable tab) {

		String sql = "Select * from " + table;
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			tab.setModel(DbUtils.resultSetToTableModel(DBHelper.getResultSet()));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// -------------------------------------------------------//

	public static String getFirstword(String myString) {

		String word = "";

		for (int i = 0, // start of word
		j = 0; // end of word
				i < myString.length(); // make sure we're in bounds
				) { // Start from where we left off plus one
								// to get rid of space we just found

			j = myString.indexOf(" ", i); // find the next space
			if (j == -1) { // -1 means no more spaces so we're done
				break;
			}
			word = myString.substring(i, j); // here is your word

			break;
		}
		return word;
	}
	// -------------------------------------------------------//
	public static String GetDeclarantById(int idDossier) {
		String Name = "";
		String sql = "Select Nom_Declarant from declarant "
				+ "inner join bon_visite where declarant.idDeclarant=bon_visite.idDeclarant "
				+ "&& bon_visite.idDossier=?";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setInt(1, idDossier);
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if ((DBHelper.getResultSet().next())) {
				Name = DBHelper.getResultSet().getString("Nom_Declarant");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Name;
	}

	// -------------------------------------------------------//

	public static String GetTypeTCById(int idTC) {
		String Name = "";
		String sql = "Select Type_Conteneurcol from type_conteneur " + "where idType_Conteneur=?";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setInt(1, idTC);
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if ((DBHelper.getResultSet().next())) {
				Name = DBHelper.getResultSet().getString("Type_Conteneurcol");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Name;
	}



	// -------------------------------------------------------//

	public static int convertir2(int id, String idcol, String rescol, String tab) {
		int res = 0;
		String sql = "SELECT * FROM " + tab + " WHERE " + idcol + "=" + id + ";";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if ((DBHelper.getResultSet().next())) {
				res = DBHelper.getResultSet().getInt(rescol);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// -------------------------------------------------------//

	public static String convertir(int id, String idcol, String rescol, String tab) {
		String res = "";
		String sql = "SELECT * FROM " + tab + " WHERE " + idcol + "=" + id + ";";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if ((DBHelper.getResultSet().next())) {
				res = DBHelper.getResultSet().getString(rescol);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	// -------------------------------------------------------//

	public static int convertir(String valeur, String inputcol, String outputcol, String tab) {
		int res = 0;
		String sql = "SELECT * FROM " + tab + " WHERE " + inputcol + "='" + valeur + "';";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
			if ((DBHelper.getResultSet().next())) {
				res = DBHelper.getResultSet().getInt(outputcol);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	// -------------------------------------------------------//

	public static boolean NoPlombageExisteDb(String NoPlomb) {
		boolean trouve = false;
		String sql = "Select NoPlomb FROM dossier_conteneur where NoPlomb=?";
		try {
			DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql));
			DBHelper.getPreparedStatement().setString(1, NoPlomb);
			DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());

			if (DBHelper.getResultSet().isBeforeFirst()) {
				trouve = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trouve;
	}

	// -------------------------------------------------------//

	public static boolean NoPlombageExisteTab(String NoPlomb, JTable table) {
		boolean trouve = false;

		for (int i = 0; i < table.getRowCount(); i++) {
			if (NoPlomb.equals((String) table.getValueAt(i, 2)))
				trouve = true;
		}

		return trouve;
	}

	// -------------------------------------------------------//

}
