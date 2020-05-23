package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import view.Theme.Msg;

public class ConfigSQL {

	private static String DBHOST="",DBUSER="",DBPASS="",DBNAME="";
	static String[] Data = new String[] { "", "", "", "" };
	static BufferedReader in = null;
	static BufferedWriter out = null;
	static int i = 0;
	static String ligne;

	public ConfigSQL(String DBHOST, String DBUSER, String DBPASS, String DBNAME) {
		this.DBHOST = DBHOST;
		this.DBUSER = DBUSER;
		this.DBPASS = DBPASS;
		this.DBNAME = DBNAME;
	}

	public static Connection getConnection() {
		LoadConfiguration();
		Connection connect = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://" + DBHOST + "/" + DBNAME + "?" + "user=" + DBUSER
					+ "&password=" + DBPASS + "&useSSL=false");
		} catch (Exception e) {
			ErrorDBMsg();
		}
		return connect;
	}

	public static void SaveConfiguration() {
		JFileChooser fr = new JFileChooser();
		FileSystemView fw = fr.getFileSystemView();
		String path = fw.getDefaultDirectory().toString() + "\\configuration.txt";
		try {
			out = new BufferedWriter(new FileWriter(path));
			out.write("host:" + DBHOST);
			out.write("\n");
			out.write("username:" + DBUSER);
			out.write("\n");
			out.write("password:" + DBPASS);
			out.write("\n");
			out.write("DBName:" + DBNAME);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void LoadConfiguration() {

		JFileChooser fr = new JFileChooser();
		FileSystemView fw = fr.getFileSystemView();
		String path = fw.getDefaultDirectory().toString() + "\\configuration.txt";

		File file = new File(path);
		if (file.exists()) {
			int i = 0;
			try {
				in = new BufferedReader(new FileReader(path));
				while ((ligne = in.readLine()) != null) {
					StringTokenizer tok = new StringTokenizer(ligne, ":");
					tok.nextToken();
					if (tok.hasMoreTokens())
						Data[i] = tok.nextToken();
					i++;
				}
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			DBHOST = Data[0];
			DBUSER = Data[1];
			DBPASS = Data[2];
			DBNAME = Data[3];
		} else {
			Init_Configuration(path);
			LoadConfiguration();
		}
	}

	public static void Init_Configuration(String path) {

		try {
			out = new BufferedWriter(new FileWriter(path));
			out.write("host:" + "localhost");
			out.write("\n");
			out.write("username:" + "root");
			out.write("\n");
			out.write("password:" + "");
			out.write("\n");
			out.write("DBName:" + "gestion_facturation");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void ErrorDBMsg() {
		Msg.Afficher("Erreure de base de donnée", Msg.IconExclam, false);
		Utile.Wait(2);
		Msg.CloseMsg();
	}

	public static String getDBHOST() {
		return DBHOST;
	}

	public static String getDBUSER() {
		return DBUSER;
	}

	public static String getDBPASS() {
		return DBPASS;
	}

	public static String getDBNAME() {
		return DBNAME;
	}

}
