package controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.collections.map.HashedMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import model.Utile;
import model.entity.Client;
import view.Client_View;
import view.View;

public class Client_Ctrl {

	// ------------------- Les variables d'instance et déclarations  -----------------------//
	private Client client;
	private Client_View client_view;
	private View view;
	private boolean fromDossier = false;

	// -------------------------- Le constructeur --------------------------//
	public Client_Ctrl(View view) {
		this.view = view;
		initController();
	}
	// -------------------------- Les methodes --------------------------//
	public void initController() {
		initView();
		client_view.getAjouter_Btn().addActionListener(e -> Ajouter_Client());
		client_view.getModifier_Btn().addActionListener(e -> Modifier_Client());
		client_view.getSuprimer_Btn()
				.addActionListener(e -> Supprimer_Client());
		client_view.getPrint_Btn().addActionListener(e -> Print());
		client_view.getReturne().addActionListener(e -> returne());
		client_view.getRech_field().addKeyListener(KeyRech);
		client_view.getTable().addMouseListener(RowSelected);
	}
	//*************************************************************//
	public void initView() {
		client_view = new Client_View();
		view.setContentPane(client_view.getContentPane());
		view.setVisible(true);
		client = new Client();
		Utile.UpdateTable(Utile.Client_Sql, client_view.getTable());
	}
	//*************************************************************//
	KeyAdapter KeyRech = new KeyAdapter() {
		public void keyReleased(java.awt.event.KeyEvent evt) {

			if (client_view.RechPar() == 1) { // Recherche Par Nom_Client
				client.Rech_client("concat(Nom_Client,' ',Prenom_Client)", client_view.getRech_field()
						.getText(), client_view.getTable());
			} else if ((client_view.RechPar() == 2)) { // Recherche Par
														// Code_Client
				client.Rech_client("idClient", client_view.getRech_field()
						.getText(), client_view.getTable());
			}
		}
	};
	//*************************************************************//
	MouseAdapter RowSelected = new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
			int ligne = client_view.getTable().getSelectedRow();
			client_view.SetInfoFromTable(ligne);
			client_view.EnabledAll();
			client_view.getSuprimer_Btn().setEnabled(true);
		}
	};
	//*************************************************************//
	private void returne() {
		new Menu_Ctrl(view);
	}
	//*************************************************************//
	private void Print() {
		try {
			DefaultTableModel de = (DefaultTableModel) client_view.getTable()
					.getModel();
			JRTableModelDataSource dataSource = new JRTableModelDataSource(de);
			String report = "Impression/ClientTable.jrxml";

			JasperReport jr = JasperCompileManager.compileReport(report);
			HashedMap parameters = new HashedMap();
			parameters.put("Title", "Title");
			@SuppressWarnings("unchecked")
			JasperPrint jp = JasperFillManager.fillReport(jr, parameters,
					dataSource);
			JasperViewer.viewReport(jp, false);

		} catch (JRException e) {

			e.printStackTrace();
		}

	}
	//*************************************************************//
	private void Ajouter_Client() {

		if (!client_view.champVide()) {
			int id1 = Utile.GetMaxId("Client", "idClient");
			client.Insert_Client(client_view.RecupereInfo());
			Utile.UpdateTable(Utile.Client_Sql, client_view.getTable());

			if (fromDossier) {
				int id2 = Utile.GetMaxId("Client", "idClient");

				if (id1 != id2) {
					client = client_view.RecupereInfo();
					client.setId(id2);
					new Dossier_Form_Ctrl(view, client);
				}
			}

		} else
			JOptionPane.showMessageDialog(null,
					"Veuillez Remplissez les champs vides");
	}
	//*************************************************************//
	private void Modifier_Client() {
		if (!client_view.champVide()) {
			client.Update_Client(client_view.RecupereInfo());
			Utile.UpdateTable(Utile.Client_Sql, client_view.getTable());
			client_view.SetChampVide();

		} else
			JOptionPane.showMessageDialog(null,
					"Veuillez Remplissez les champs vides");
	}
	//*************************************************************//
	private void Supprimer_Client() {
		if (!client_view.champVideMini()) {
			client.Archive_Client(client_view.RecupereInfo());
			client.delete_Client(client_view.RecupereInfo());
			Utile.UpdateTable(Utile.Client_Sql, client_view.getTable());
			client_view.SetChampVide();//

		} else
			JOptionPane
					.showMessageDialog(null,
							"Veuillez Remplissez le champs 'N:Rc' ou séléctionnez un client");
	}
	//*************************************************************//
	public void setFromDossier(boolean fromDossier) {
		this.fromDossier = fromDossier;
	}

}
