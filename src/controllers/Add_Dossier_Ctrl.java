package controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import model.Utile;
import model.entity.Client;
import view.Add_Dossier_View;
import view.Dossier_Form_View;
import view.View;

public class Add_Dossier_Ctrl {

	// ------------------- Les variables d'instance et déclarations  -----------------------//
	private static Client client=new Client();
	private Add_Dossier_View Add_dossier_view;
	private int ligne=-1;
	String IdSelect, fullName, raison, mobile, email, rc;
	// -------------------------- Le constructeur --------------------------//
	public Add_Dossier_Ctrl(View view) {initController();}
	// -------------------------- Les methodes --------------------------//
	public void initController() {
		initView();
		Add_dossier_view.getBtnChoisir().addActionListener(e -> Choisir());
		Add_dossier_view.getBtnAddClient().addActionListener(e -> AddClient());
		Add_dossier_view.getBtnAnnuler().addActionListener(e -> Annuler());
		Add_dossier_view.getRech_field().addKeyListener(KeyRech);
		Add_dossier_view.getTable().addMouseListener(RowSelected);
	}
	//*************************************************************//
	public void initView() {
		Add_dossier_view = new Add_Dossier_View();
		Utile.UpdateTable(Utile.Client_Sql, Add_dossier_view.getTable());
	}
	//*************************************************************//
	KeyAdapter KeyRech = new KeyAdapter() {
		public void keyReleased(java.awt.event.KeyEvent evt) {
			client = new Client();
			client.Rech_client("Nom_Client", Add_dossier_view.getRech_field()
					.getText().toString(), Add_dossier_view.getTable());
		}

	};
	//*************************************************************//
	MouseAdapter RowSelected = new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
			ligne = Add_dossier_view.getTable().getSelectedRow();
		  	 client = new Client();
			 client=Add_dossier_view.RecupereInfo(ligne);
		}
	};
	//*************************************************************//
	private void Choisir() {
		if(ligne!=-1)
		{
			Dossier_Form_View.SetFicheClient(client);
			Add_dossier_view.Fermer();
		}else{
			JOptionPane.showMessageDialog(null, "Vous devez sélectionner le client");
		}
	}
	//*************************************************************//
	private void AddClient() {
		Client_Ctrl cl= new Client_Ctrl(View.GetView());
		cl.setFromDossier(true);
		Add_dossier_view.Fermer();
	}
	//*************************************************************//
	private void Annuler() {
		Add_dossier_view.Fermer();
	}
	//*************************************************************//
	static public Client getClient() {
		return client;
	}
	//*************************************************************//

}
